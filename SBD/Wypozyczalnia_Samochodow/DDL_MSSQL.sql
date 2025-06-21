DROP TABLE IF EXISTS Stan_Samochodu;
DROP TABLE IF EXISTS Historia_Wypozyczen;
DROP TABLE IF EXISTS Rezerwacja;
DROP TABLE IF EXISTS Samochod;
DROP TABLE IF EXISTS Model;
DROP TABLE IF EXISTS Pracownik;
DROP TABLE IF EXISTS Klient;
DROP TABLE IF EXISTS Miasto;

-- Tabela Miasto
CREATE TABLE Miasto (
    Id INT NOT NULL PRIMARY KEY,
    Miasto NVARCHAR(20) NOT NULL
);

-- Tabela Klient
CREATE TABLE Klient (
    Id INT NOT NULL PRIMARY KEY,
    Imie NVARCHAR(20) NOT NULL,
    Nazwisko NVARCHAR(20) NOT NULL,
    Numer_Prawa_Jazdy NVARCHAR(15) NOT NULL,
    Telefon BIGINT NOT NULL,
    Email NVARCHAR(30) NOT NULL,
    Miasto_Id INT NOT NULL,
    FOREIGN KEY (Miasto_Id) REFERENCES Miasto(Id)
);

-- Tabela Pracownik
CREATE TABLE Pracownik (
    Id INT NOT NULL PRIMARY KEY,
    Imie NVARCHAR(20) NOT NULL,
    Nazwisko NVARCHAR(20) NOT NULL,
    Telefon BIGINT NOT NULL,
    Email NVARCHAR(30) NOT NULL,
    Miasto_Id INT NOT NULL,
    FOREIGN KEY (Miasto_Id) REFERENCES Miasto(Id)
);

-- Tabela Model
CREATE TABLE Model (
    Model_Id INT NOT NULL PRIMARY KEY,
    Marka NVARCHAR(20) NOT NULL,
    Model NVARCHAR(20) NOT NULL,
    Typ NVARCHAR(20) NOT NULL
);

-- Tabela Samochod
CREATE TABLE Samochod (
    Id INT NOT NULL PRIMARY KEY,
    Rok_Produkcji INT NOT NULL,
    Numer_Rejestracyjny NVARCHAR(15) NOT NULL,
    Paliwo NVARCHAR(20) NOT NULL,
    Cena_Dzien DECIMAL(6,2) NOT NULL,
    Cena_Tydzien DECIMAL(6,2) NOT NULL,
    Cena_Miesiac DECIMAL(6,2) NOT NULL
);

-- Tabela Rezerwacja
CREATE TABLE Rezerwacja (
    Id INT NOT NULL PRIMARY KEY,
    Pracownik_Id INT NOT NULL,
    Klient_Id INT NOT NULL,
    Data_Rozpoczecia DATE NOT NULL,
    Data_Zakonczenia DATE NOT NULL,
    Model_Id INT NOT NULL,
    FOREIGN KEY (Pracownik_Id) REFERENCES Pracownik(Id),
    FOREIGN KEY (Klient_Id) REFERENCES Klient(Id),
    FOREIGN KEY (Model_Id) REFERENCES Model(Model_Id)
);

-- Tabela Historia_Wypozyczen
CREATE TABLE Historia_Wypozyczen (
    Rezerwacja_Id INT NOT NULL PRIMARY KEY,
    Klient_Id INT NOT NULL,
    Pracownik_Id INT NOT NULL,
    Data_Wypozyczenia DATE NOT NULL,
    Data_Zwrotu DATE NULL,
    Uwagi NVARCHAR(100) NULL,
    Samochod_Id INT NOT NULL,
    Przebieg_start INT NOT NULL,
    Przebieg_stop INT NULL,
    FOREIGN KEY (Rezerwacja_Id) REFERENCES Rezerwacja(Id),
    FOREIGN KEY (Klient_Id) REFERENCES Klient(Id),
    FOREIGN KEY (Pracownik_Id) REFERENCES Pracownik(Id),
    FOREIGN KEY (Samochod_Id) REFERENCES Samochod(Id)
);

-- Tabela Stan_Samochodu
CREATE TABLE Stan_Samochodu (
    Samochod_Id INT NOT NULL,
    Pracownik_Id INT NOT NULL,
    Data_Ostatniego_Przegladu DATE NOT NULL,
    Opis_Stanu NVARCHAR(100) NOT NULL,
    Status_Dostepnosci INT NOT NULL,
    PRIMARY KEY (Samochod_Id, Pracownik_Id),
    FOREIGN KEY (Samochod_Id) REFERENCES Samochod(Id),
    FOREIGN KEY (Pracownik_Id) REFERENCES Pracownik(Id)
);
