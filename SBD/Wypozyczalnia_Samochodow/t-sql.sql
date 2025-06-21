-- 1. Procedura kończąca wypozyczenie
-- Cel: Zakończyć wypożyczenie samochodu dla wskazanej rezerwacji aktualizując historię wypożyczeń (Data_Zwrotu, Uwagi, Przebieg_stop)
-- oraz zmieniając status dostępności samochodu w Stan_Samochodu.

CREATE PROCEDURE Zakoncz_Wypozyczenie
    @RezerwacjaId INT,
    @DataZwrotu DATE,
    @Uwagi VARCHAR,
    @PrzebiegStop INT
AS
BEGIN

    DECLARE @SamochodId INT;
    DECLARE @PrzebiegStart INT;
    DECLARE @DataWypozyczenia DATE;

    SELECT @PrzebiegStart = Przebieg_start
    FROM Historia_Wypozyczen
    WHERE Rezerwacja_Id = @RezerwacjaId;
    
    SELECT @DataWypozyczenia = Data_Wypozyczenia
    FROM Historia_Wypozyczen
    WHERE Rezerwacja_Id = @RezerwacjaId;

    IF @PrzebiegStop < @PrzebiegStart
    BEGIN
        RAISERROR('Przebieg na koniec nie moze byc mniejszy niz na poczatku.', 16, 1);
    END
    
    IF @DataZwrotu < @DataWypozyczenia
    BEGIN
        RAISERROR('Data zwrotu nie moze byc przed data wypozyczenia.', 16, 1);
    END

    UPDATE Historia_Wypozyczen
    SET Data_Zwrotu = @DataZwrotu,
        Przebieg_stop = @PrzebiegStop,
        Uwagi = @Uwagi
    WHERE Rezerwacja_Id = @RezerwacjaId;

    SELECT @SamochodId = Samochod_Id
    FROM Historia_Wypozyczen
    WHERE Rezerwacja_Id = @RezerwacjaId;

    UPDATE Stan_Samochodu
    SET Status_Dostepnosci = 1
    WHERE Samochod_Id = @SamochodId;

    PRINT 'Pomyslnie zaktualizowano historie wypozyczenia dla rezerwacji numer: ' + CONVERT(VARCHAR, @RezerwacjaId);

END;

-- Poprawny przypadek
EXEC Zakoncz_Wypozyczenie
    @RezerwacjaId = 3,
    @DataZwrotu = '2025-05-02',
    @Uwagi = 'Auto w porządku, zatankowane.',
    @PrzebiegStop = 30300;

-- Błąd — przebieg końcowy mniejszy niż początkowy
EXEC Zakoncz_Wypozyczenie
    @RezerwacjaId = 3,
    @DataZwrotu = '2025-05-02',
    @Uwagi = 'Auto w porządku, zatankowane.',
    @PrzebiegStop = 1;

-- Błąd — data zwrotu nie moze byc przed data wypozyczenia.
EXEC Zakoncz_Wypozyczenie
    @RezerwacjaId = 3,
    @DataZwrotu = '2022-06-10',
    @Uwagi = 'Auto w porządku, zatankowane.',
    @PrzebiegStop = 30500;


-- 2. Procedura aktualizująca stan samochodu
-- Cel: Zaktualizować stan wskazanego samochodu - należy wskazać pracownika, datę ostatniego przeglądu oraz opis stanu. Procedura nie 
-- automatycznie ustala status dostępności na podstawie daty ostatniego przeglądu.

CREATE PROCEDURE Aktualizacja_Stanu_Samochodu
    @SamochodId INT,
    @PracownikId INT,
    @DataOstatniegoPrzegladu DATE,
    @OpisStanu NVARCHAR(100)
AS
BEGIN

    DECLARE @StatusDostepnosci INT;

    IF NOT EXISTS (SELECT 1 FROM Stan_Samochodu WHERE Samochod_Id = @SamochodId)
    BEGIN
        RAISERROR('Nie istnieje jeszcze wpis o stanie samochodu dla samochodu z id  %d', 16, 1, @SamochodId);
    END

    IF NOT EXISTS (SELECT 1 FROM Pracownik WHERE Id = @PracownikId)
    BEGIN
        RAISERROR('Nie istnieje jeszcze pracownik z id  %d', 16, 1, @PracownikId);
    END

    SELECT MAX(Data_Ostatniego_Przegladu) AS MaksymalnaData
    FROM Stan_Samochodu
    WHERE Samochod_Id = @SamochodId;

    IF DATEDIFF(YEAR, @DataOstatniegoPrzegladu, GETDATE()) > 1
        BEGIN
            SET @StatusDostepnosci = 0;
        END
    ELSE
        BEGIN
            SET @StatusDostepnosci = 1;
        END

    UPDATE Stan_Samochodu
    SET Data_Ostatniego_Przegladu = @DataOstatniegoPrzegladu,
        Opis_Stanu = @OpisStanu,
        Pracownik_Id = @PracownikId,
        Status_Dostepnosci = @StatusDostepnosci
    WHERE Samochod_Id = @SamochodId;

    IF @StatusDostepnosci = 0
    BEGIN
        PRINT 'Samochód wymaga przeglądu! Ostatni przegląd był ponad rok temu!';
    END

END;

-- Poprawny przypadek
EXEC Aktualizacja_Stanu_Samochodu
    @SamochodId = 1,
    @PracownikId = 1,
    @DataOstatniegoPrzegladu = '2025-06-01',
    @OpisStanu = 'Wszystko w porządku, stan techniczny dobry.';

-- Błąd - Nie istnieje jeszcze wpis o stanie samochodu dla samochodu z id  5
EXEC Aktualizacja_Stanu_Samochodu
    @SamochodId = 5,
    @PracownikId = 1,
    @DataOstatniegoPrzegladu = '2025-06-01',
    @OpisStanu = 'Wszystko w porządku, stan techniczny dobry.';

-- Błąd - Nie istnieje jeszcze pracownik z id  5
EXEC Aktualizacja_Stanu_Samochodu
    @SamochodId = 1,
    @PracownikId = 5,
    @DataOstatniegoPrzegladu = '2025-06-01',
    @OpisStanu = 'Wszystko w porządku, stan techniczny dobry.';

-- Poprawny przypadek z ostrzeżeniem - Samochód wymaga przeglądu! Ostatni przegląd był ponad rok temu!
EXEC Aktualizacja_Stanu_Samochodu
    @SamochodId = 1,
    @PracownikId = 1,
    @DataOstatniegoPrzegladu = '2022-06-01',
    @OpisStanu = 'Wszystko w porządku, stan techniczny dobry.';

-- 3. Trigger FOR działający na tabeli Klient powiadamiający pracowników z tego samego miasta co nowy klient o nowym kliencie.
-- Cel: Przy dodaniu nowego klienta powiadomić wszystkich pracowników z tego samego miasta o nabyciu nowego klienta. Umożliwia 
-- pracownikom z danego miasta byc na bieżąco z nowymi klientami, co może wspierać lepszą organizację pracy, koordynację lub działania marketingowe.

CREATE TRIGGER Powiadom_Pracownikow ON Klient
FOR INSERT
AS
BEGIN

    DECLARE @MiastoId INT;
    DECLARE @PracownikId INT;
    DECLARE @Imie VARCHAR(20);
    DECLARE @Nazwisko VARCHAR(20);
    DECLARE @LiczbaPracownikow INT;

    SELECT TOP 1 @MiastoId = Miasto_Id FROM inserted;

    SELECT @LiczbaPracownikow = COUNT(*)
    FROM Pracownik
    WHERE Miasto_Id = @MiastoId;

    IF @LiczbaPracownikow < 1
    BEGIN
        PRINT 'Brak pracowników w mieście klienta! Żaden pracownik nie został powiadomiony.';
        RETURN;
    END;

    PRINT 'Liczba pracowników w tym mieście: ' + CONVERT(VARCHAR, @LiczbaPracownikow );

    DECLARE PracownikCursor CURSOR FOR
    SELECT Id, Imie, Nazwisko
    FROM Pracownik
    WHERE Miasto_Id = @MiastoId;

    OPEN PracownikCursor;

    FETCH NEXT FROM PracownikCursor INTO @PracownikId, @Imie, @Nazwisko;

    WHILE @@FETCH_STATUS = 0
    BEGIN

        PRINT 'Powiadomiono pracownika: ' + @Imie + ' ' + @Nazwisko;
        FETCH NEXT FROM PracownikCursor INTO @PracownikId, @Imie, @Nazwisko;

    END;

    CLOSE PracownikCursor;
    DEALLOCATE PracownikCursor;

END;

-- Poprawny przypadek (powiadomienie jednego pracownika)
INSERT INTO Klient (Id, Imie, Nazwisko, Numer_Prawa_Jazdy, Telefon, Email, Miasto_Id)
VALUES (4, 'Jan', 'Kowalski', 'AA123', '123456789', 'jk@example.com', 1);

-- Poprawny przypadek (brak pracowników w mieście klienta, żaden pracownik nie został powiadomiony)
INSERT INTO Klient (Id, Imie, Nazwisko, Numer_Prawa_Jazdy, Telefon, Email, Miasto_Id)
VALUES (5, 'Jan', 'Kowalski', 'AA125', '123356789', 'jk1@example.com', 3);

-- 4. Trigger INSTEAD OF działający na tabeli Stan_Samochodu obsługujący operacje UPDATE oraz DELETE. 
-- Cel: Przy próbie usunięcia  stanu samochodu trigger nie usuwa rekordu a ustawia nowy opis stanu oraz status dostępności na -1.
-- Trigger zapobiega także aktualizacji statusu dostepnosci na wartosc inna niz -1, 0 lub 1. Przy próbie aktualizacji statusu na -1 aktualizowany
-- jest opis. Mechanizm pozwala zachować historię i kontrolę nad stanami pojazdów bez utraty danych oraz ogranicza możliwość wprowadzenia niepoprawnych wartości.

CREATE TRIGGER Stan_Samochodu_Update_Delete
ON Stan_Samochodu
INSTEAD OF UPDATE, DELETE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM inserted
        WHERE Status_Dostepnosci NOT IN (-1, 0, 1)
    )
    BEGIN
        RAISERROR('Status_Dostepnosci może być tylko -1 (wycofany), 0 (niedostępny) lub 1 (dostępny)', 16, 1);
        RETURN;
    END

    IF EXISTS (SELECT * FROM deleted) AND NOT EXISTS (SELECT * FROM inserted)
    BEGIN
        UPDATE Stan_Samochodu
        SET
            Status_Dostepnosci = -1,
            Opis_Stanu = 'Wycofany z użytku ' + CONVERT(varchar, GETDATE())
        FROM Stan_Samochodu ss
        INNER JOIN deleted d ON ss.Samochod_Id = d.Samochod_Id AND ss.Pracownik_Id = d.Pracownik_Id
    END

    IF EXISTS (SELECT * FROM inserted) AND EXISTS(SELECT * FROM deleted)
    BEGIN

        UPDATE Stan_Samochodu
        SET 
            Status_Dostepnosci = IIF(i.Status_Dostepnosci = -1, -1, i.Status_Dostepnosci),
            Opis_Stanu = IIF(i.Status_Dostepnosci = -1,
                             'Wycofany z użytku ' + CONVERT(varchar, GETDATE()),
                             i.Opis_Stanu),
            Data_Ostatniego_Przegladu = i.Data_Ostatniego_Przegladu
        FROM Stan_Samochodu ss
        INNER JOIN inserted i ON ss.Samochod_Id = i.Samochod_Id
                              AND ss.Pracownik_Id = i.Pracownik_Id
        INNER JOIN deleted d ON ss.Samochod_Id = d.Samochod_Id
                            AND ss.Pracownik_Id = d.Pracownik_Id
                            AND ss.Data_Ostatniego_Przegladu = d.Data_Ostatniego_Przegladu;
    END
END

-- Poprawny przypadek - zamiast usunięcia ustawienie dostępności na -1 oraz informacji o wycofaniu w opisie stanu
DELETE FROM Stan_Samochodu
WHERE Samochod_Id = 1;

-- Błąd - Status_Dostepnosci może być tylko -1 (wycofany), 0 (niedostępny) lub 1 (dostępny)
UPDATE Stan_Samochodu
SET Status_Dostepnosci = 2, Opis_Stanu = 'Samochód w dobrym stanie', Data_Ostatniego_Przegladu = '2025-06-01'
WHERE Samochod_Id = 1;