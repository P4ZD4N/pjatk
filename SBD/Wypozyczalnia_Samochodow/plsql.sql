-- 1. Procedura znajdująca wypozyczenia które nie mają ustawionej daty zwrotu i dodająca odpowiednią uwagę jeśli przekroczono
-- przewidywaną datę zakończenia rezerwacji z tabeli Rezerwacja
-- Cel: znajduje wszystkie wypożyczenia, które nie mają ustawionej daty zwrotu (Data_Zwrotu IS NULL). Dla tych rekordów sprawdza czy 
-- przekroczono przewidywaną datę zakończenia z tabeli Rezerwacja. Jeśli tak — wstawia uwagę w polu Uwagi w tabeli Historia_Wypozyczen: ‘Przekroczono termin zwrotu’

CREATE PROCEDURE Sprawdz_Zwroty IS

    RezerwacjaId INT;
    DataZakonczenia DATE;
    LiczbaAktualizacji INT := 0;

    CURSOR cursorWypozyczenia IS
        SELECT hw.Rezerwacja_Id, r.Data_Zakonczenia
        FROM Historia_Wypozyczen hw
        INNER JOIN Rezerwacja r ON hw.Rezerwacja_Id = r.Id
        WHERE hw.Data_Zwrotu IS NULL;

BEGIN

    OPEN cursorWypozyczenia;

    LOOP

        FETCH cursorWypozyczenia INTO RezerwacjaId, DataZakonczenia;

        EXIT WHEN cursorWypozyczenia%NOTFOUND;

        IF DataZakonczenia < SYSDATE THEN

            UPDATE Historia_Wypozyczen
            SET Uwagi = 'Przekroczono termin zwrotu'
            WHERE Rezerwacja_Id = RezerwacjaId;

            LiczbaAktualizacji := LiczbaAktualizacji + 1;

        END IF;

    END LOOP;

    CLOSE cursorWypozyczenia;

    DBMS_OUTPUT.PUT_LINE('Sprawdzenie zwrotów zakończone. Zaktualizowano ' || LiczbaAktualizacji || ' rekordów.');

END;

-- 2. Procedura zliczająca i wypisująca liczbę i sumę dni wypożyczeń dla podanego klienta
-- Cel: Dane pochodzące ze zliczenia dokładnej liczby wypożyczeń i sumy dni dla podanego klienta mogą przydać się w potencjalnie
-- organizowanych konkursach, statystykach oraz działaniach marketingowych.

CREATE OR REPLACE PROCEDURE Podsumuj_Wypozyczenia_Klienta (
    KlientId INT
) AS
    LiczbaWypozyczen INT := 0;
    SumaDni INT := 0;
    IloscKlientow INT := 0;
BEGIN

    SELECT COUNT(*)
    INTO IloscKlientow
    FROM Klient
    WHERE Id = KlientId;

    IF IloscKlientow = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Brak klienta o podanym ID: ' || KlientId);
    END IF;

    SELECT COUNT(*)
    INTO LiczbaWypozyczen
    FROM Historia_Wypozyczen
    WHERE Klient_Id = KlientId;

    SELECT NVL(SUM(NVL(Data_Zwrotu, SYSDATE) - Data_Wypozyczenia), 0)
    INTO SumaDni
    FROM Historia_Wypozyczen
    WHERE Klient_Id = KlientId;

    DBMS_OUTPUT.PUT_LINE('Klient ID: ' || KlientId);
    DBMS_OUTPUT.PUT_LINE('Liczba wypożyczeń: ' || LiczbaWypozyczen);
    DBMS_OUTPUT.PUT_LINE('Łączna liczba dni wypożyczeń: ' || SumaDni);

END;

-- Błąd - brak klienta o podanym ID: 4
CALL PODSUMUJ_WYPOZYCZENIA_KLIENTA(4)

-- 3. Trigger walidujący i poprawiający dane przy próbie dodania nowego klienta do bazy danych
-- Cel: Zapobieganie dodania klienta z emailem istniejącym w bazie, z nieprawidłowym numerem telefonu lub z miastem, które nie istnieje w bazie.
-- Trigger poprawia także imię i nazwisko na zaczynające się od wielkiej litery.

CREATE OR REPLACE TRIGGER Sprawdz_Dodanie_Klienta
BEFORE INSERT ON Klient
FOR EACH ROW
DECLARE
    emailCount INT;
    miastoCount INT;
BEGIN

    SELECT COUNT(*) INTO emailCount
    FROM Klient
    WHERE Email = :NEW.Email;

    IF emailCount > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Klient z podanym adresem email już istnieje.');
    END IF;

    IF LENGTH(:NEW.Telefon) <> 9 OR NOT REGEXP_LIKE(:NEW.Telefon, '^[0-9]{9}$') THEN
        RAISE_APPLICATION_ERROR(-20002, 'Numer telefonu musi mieć dokładnie 9 cyfr.');
    END IF;

    SELECT COUNT(*) INTO miastoCount
    FROM Miasto
    WHERE Id = :NEW.Miasto_Id;

    IF miastoCount = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Podane miasto nie istnieje w bazie.');
    END IF;

    :NEW.Imie := INITCAP(:NEW.Imie);
    :NEW.Nazwisko := INITCAP(:NEW.Nazwisko);

    DBMS_OUTPUT.PUT_LINE('Dodano klienta: ' || :NEW.Imie || ' ' || :NEW.Nazwisko);

END;

-- Prawidłowy przypadek
INSERT INTO KLIENT (ID, IMIE, NAZWISKO, NUMER_PRAWA_JAZDY, TELEFON, EMAIL, MIASTO_ID)
VALUES (5, 'jan', 'kowalski', 'bbsdf123', '123456789', 'jan.kowalski@example.com', 1);

-- Błąd - Klient z podanym adresem email już istnieje.
INSERT INTO KLIENT (ID, IMIE, NAZWISKO, NUMER_PRAWA_JAZDY, TELEFON, EMAIL, MIASTO_ID)
VALUES (6, 'jan', 'kowalski', 'basdf123', '123456789', 'jan.kowalski@example.com', 1);

-- Błąd - Numer telefonu musi mieć dokładnie 9 cyfr.
INSERT INTO KLIENT (ID, IMIE, NAZWISKO, NUMER_PRAWA_JAZDY, TELEFON, EMAIL, MIASTO_ID)
VALUES (6, 'jan', 'kowalski', 'basdf123', '12345678', 'jan.kowalski1@example.com', 1);

-- Błąd - Podane miasto nie istnieje w bazie.
INSERT INTO KLIENT (ID, IMIE, NAZWISKO, NUMER_PRAWA_JAZDY, TELEFON, EMAIL, MIASTO_ID)
VALUES (6, 'jan', 'kowalski', 'basdf123', '123456789', 'jan.kowalski1@example.com', 6);

-- 4. Trigger AFTER UPDATE na tabeli Historia_Wypozyczen weryfikujący spójność dat oraz aktualizujący status samochodu po zwrocie.
-- Cel: Zapobiega zapisom z niepoprawną datą zwrotu oraz automatycznie aktualizuje dostępność pojazdu.

CREATE OR REPLACE TRIGGER Weryfikuj_Zwrot_Pojazdu
AFTER UPDATE ON Historia_Wypozyczen
FOR EACH ROW
BEGIN

    IF :OLD.Data_Zwrotu IS NOT NULL AND :NEW.Data_Zwrotu IS NOT NULL THEN

        IF :NEW.Data_Zwrotu < :NEW.Data_Wypozyczenia THEN
            RAISE_APPLICATION_ERROR(-20020, 'Data zwrotu nie może być wcześniejsza niż data wypożyczenia.');
        END IF;

    END IF;

    IF :OLD.Data_Zwrotu IS NULL AND :NEW.Data_Zwrotu IS NOT NULL THEN

        IF :NEW.Data_Zwrotu < :NEW.Data_Wypozyczenia THEN
            RAISE_APPLICATION_ERROR(-20020, 'Data zwrotu nie może być wcześniejsza niż data wypożyczenia.');
        END IF;

        UPDATE Stan_Samochodu
        SET Status_Dostepnosci = 1
        WHERE Samochod_Id = :NEW.Samochod_Id;

        DBMS_OUTPUT.PUT_LINE('Zaktualizowano wypożyczenie z ID: ' || :NEW.REZERWACJA_ID);
        DBMS_OUTPUT.PUT_LINE('Pojazd ID ' || :NEW.Samochod_Id || ' oznaczony jako dostępny.');

    END IF;

END;

-- Prawidłowy przypadek
UPDATE HISTORIA_WYPOZYCZEN
SET DATA_ZWROTU = TO_DATE('2025-05-04', 'YYYY-MM-DD')
WHERE REZERWACJA_ID = 1

-- Błąd - Data zwrotu nie może być wcześniejsza niż data wypożyczenia.
UPDATE HISTORIA_WYPOZYCZEN
SET DATA_ZWROTU = TO_DATE('2025-04-04', 'YYYY-MM-DD')
WHERE REZERWACJA_ID = 1

-- 