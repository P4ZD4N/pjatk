-- Miasta
INSERT INTO Miasto (Id, Miasto) VALUES (1, 'Warszawa');
INSERT INTO Miasto (Id, Miasto) VALUES (2, 'Kraków');
INSERT INTO Miasto (Id, Miasto) VALUES (3, 'Wrocław');

-- Klienci
INSERT INTO Klient (Id, Imie, Nazwisko, Numer_Prawa_Jazdy, Telefon, Email, Miasto_Id) 
VALUES (1, 'Jan', 'Kowalski', 'B123456789', 123456789, 'jk@example.com', 1);
INSERT INTO Klient (Id, Imie, Nazwisko, Numer_Prawa_Jazdy, Telefon, Email, Miasto_Id) 
VALUES (2, 'Anna', 'Nowak', 'B987654321', 987654321, 'an@example.com', 2);
INSERT INTO Klient (Id, Imie, Nazwisko, Numer_Prawa_Jazdy, Telefon, Email, Miasto_Id) 
VALUES (3, 'Piotr', 'Wójcik', 'A112233445', 112233445, 'pw@example.com', 3);

-- Pracownicy
INSERT INTO Pracownik (Id, Imie, Nazwisko, Telefon, Email, Miasto_Id) 
VALUES (1, 'Krzysztof', 'Lewandowski', 987654321, 'kl@example.com', 1);
INSERT INTO Pracownik (Id, Imie, Nazwisko, Telefon, Email, Miasto_Id) 
VALUES (2, 'Magdalena', 'Zielińska', 123456789, 'mz@example.com', 2);

-- Modele
INSERT INTO Model (Model_Id, Marka, Model, Typ) 
VALUES (1, 'Toyota', 'Corolla', 'Sedan');
INSERT INTO Model (Model_Id, Marka, Model, Typ) 
VALUES (2, 'Ford', 'Focus', 'Hatchback');
INSERT INTO Model (Model_Id, Marka, Model, Typ) 
VALUES (3, 'BMW', 'X5', 'SUV');

-- Samochody
INSERT INTO Samochod (Id, Rok_Produkcji, Numer_Rejestracyjny, Paliwo, Cena_Dzien, Cena_Tydzien, Cena_Miesiac)
VALUES (1, 2020, 'ABC123', 'Benzyna', 100.00, 600.00, 2200.00);
INSERT INTO Samochod (Id, Rok_Produkcji, Numer_Rejestracyjny, Paliwo, Cena_Dzien, Cena_Tydzien, Cena_Miesiac)
VALUES (2, 2019, 'DEF456', 'Diesel', 120.00, 720.00, 2500.00);
INSERT INTO Samochod (Id, Rok_Produkcji, Numer_Rejestracyjny, Paliwo, Cena_Dzien, Cena_Tydzien, Cena_Miesiac)
VALUES (3, 2022, 'GHI789', 'Hybryda', 140.00, 840.00, 2800.00);
INSERT INTO Samochod (Id, Rok_Produkcji, Numer_Rejestracyjny, Paliwo, Cena_Dzien, Cena_Tydzien, Cena_Miesiac)
VALUES (4, 2021, 'JKL012', 'Benzyna', 110.00, 650.00, 2300.00);

-- Stan samochodów
INSERT INTO Stan_Samochodu (Samochod_Id, Pracownik_Id, Data_Ostatniego_Przegladu, Opis_Stanu, Status_Dostepnosci)
VALUES (1, 1, '2025-06-01', 'Bardzo dobry', 1);
INSERT INTO Stan_Samochodu (Samochod_Id, Pracownik_Id, Data_Ostatniego_Przegladu, Opis_Stanu, Status_Dostepnosci)
VALUES (2, 2, '2025-06-03', 'Dobry', 1);
INSERT INTO Stan_Samochodu (Samochod_Id, Pracownik_Id, Data_Ostatniego_Przegladu, Opis_Stanu, Status_Dostepnosci)
VALUES (3, 1, '2025-06-05', 'Idealny', 1);

-- Rezerwacje 
INSERT INTO Rezerwacja (Id, Pracownik_Id, Klient_Id, Data_Rozpoczecia, Data_Zakonczenia, Model_Id)
VALUES (1, 1, 1, '2025-05-01', '2025-05-05', 1);
INSERT INTO Rezerwacja (Id, Pracownik_Id, Klient_Id, Data_Rozpoczecia, Data_Zakonczenia, Model_Id)
VALUES (2, 2, 2, '2025-06-10', '2025-06-20', 2);
INSERT INTO Rezerwacja (Id, Pracownik_Id, Klient_Id, Data_Rozpoczecia, Data_Zakonczenia, Model_Id)
VALUES (3, 1, 3, '2025-05-01', '2025-05-10', 3);
INSERT INTO Rezerwacja (Id, Pracownik_Id, Klient_Id, Data_Rozpoczecia, Data_Zakonczenia, Model_Id)
VALUES (4, 2, 2, '2025-06-15', '2025-06-25', 1);

-- Historia wypożyczeń
INSERT INTO Historia_Wypozyczen (Rezerwacja_Id, Klient_Id, Pracownik_Id, Data_Wypozyczenia, Data_Zwrotu, Uwagi, Samochod_Id, Przebieg_start, Przebieg_stop)
VALUES (1, 1, 1, '2026-05-01', '2026-05-05', 'Brak uwag', 1, 15000, 15200);
INSERT INTO Historia_Wypozyczen (Rezerwacja_Id, Klient_Id, Pracownik_Id, Data_Wypozyczenia, Data_Zwrotu, Uwagi, Samochod_Id, Przebieg_start, Przebieg_stop)
VALUES (2, 2, 2, '2025-05-10', null, null, 2, 25000, null);
INSERT INTO Historia_Wypozyczen (Rezerwacja_Id, Klient_Id, Pracownik_Id, Data_Wypozyczenia, Data_Zwrotu, Uwagi, Samochod_Id, Przebieg_start, Przebieg_stop)
VALUES (3, 3, 1, '2025-05-01', '2025-05-10', 'Brak uwag', 3, 30000, 30300);
INSERT INTO Historia_Wypozyczen (Rezerwacja_Id, Klient_Id, Pracownik_Id, Data_Wypozyczenia, Data_Zwrotu, Uwagi, Samochod_Id, Przebieg_start, Przebieg_stop)
VALUES (4, 3, 1, '2025-04-15', '2025-04-20', 'Wymiana oleju', 3, 30300, 30700);

