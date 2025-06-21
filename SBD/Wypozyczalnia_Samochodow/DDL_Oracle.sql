-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-01-20 21:13:39.257

-- tables
-- Table: Historia_Wypozyczen

CREATE TABLE Historia_Wypozyczen (
    Rezerwacja_Id integer  NOT NULL,
    Klient_Id integer  NOT NULL,
    Pracownik_Id integer  NOT NULL,
    Data_Wypozyczenia date  NOT NULL,
    Data_Zwrotu date  NULL,
    Uwagi varchar2(100)  NULL,
    Samochod_Id integer  NOT NULL,
    Przebieg_start integer  NOT NULL,
    Przebieg_stop integer  NULL,
    CONSTRAINT Historia_Wypozyczen_pk PRIMARY KEY (Rezerwacja_Id)
) ;

-- Table: Klient
CREATE TABLE Klient (
    Id integer  NOT NULL,
    Imie varchar2(20)  NOT NULL,
    Nazwisko varchar2(20)  NOT NULL,
    Numer_Prawa_Jazdy varchar2(15)  NOT NULL,
    Telefon number(9,0)  NOT NULL,
    Email varchar2(30)  NOT NULL,
    Miasto_Id integer  NOT NULL,
    CONSTRAINT Klient_pk PRIMARY KEY (Id)
) ;

-- Table: Miasto
CREATE TABLE Miasto (
    Id integer  NOT NULL,
    Miasto varchar2(20)  NOT NULL,
    CONSTRAINT Miasto_pk PRIMARY KEY (Id)
) ;

-- Table: Model
CREATE TABLE Model (
    Model_Id integer  NOT NULL,
    Marka varchar2(20)  NOT NULL,
    Model varchar2(20)  NOT NULL,
    Typ varchar2(20)  NOT NULL,
    CONSTRAINT Model_pk PRIMARY KEY (Model_Id)
) ;

-- Table: Pracownik
CREATE TABLE Pracownik (
    Id integer  NOT NULL,
    Imie varchar2(20)  NOT NULL,
    Nazwisko varchar2(20)  NOT NULL,
    Telefon number(9,0)  NOT NULL,
    Email varchar2(30)  NOT NULL,
    Miasto_Id integer  NOT NULL,
    CONSTRAINT Pracownik_pk PRIMARY KEY (Id)
) ;

-- Table: Rezerwacja
CREATE TABLE Rezerwacja (
    Id integer  NOT NULL,
    Pracownik_Id integer  NOT NULL,
    Klient_Id integer  NOT NULL,
    Data_Rozpoczecia date  NOT NULL,
    Data_Zakonczenia date  NOT NULL,
    Model_Id integer  NOT NULL,
    CONSTRAINT Rezerwacja_pk PRIMARY KEY (Id)
) ;

-- Table: Samochod
CREATE TABLE Samochod (
    Id integer  NOT NULL,
    Rok_Produkcji number(4,0)  NOT NULL,
    Numer_Rejestracyjny varchar2(15)  NOT NULL,
    Paliwo varchar2(20)  NOT NULL,
    Cena_Dzien number(6,2)  NOT NULL,
    Cena_Tydzien number(6,2)  NOT NULL,
    Cena_Miesiac number(6,2)  NOT NULL,
    CONSTRAINT Samochod_pk PRIMARY KEY (Id)
) ;

-- Table: Stan_Samochodu
CREATE TABLE Stan_Samochodu (
    Samochod_Id integer  NOT NULL,
    Pracownik_Id integer  NOT NULL,
    Data_Ostatniego_Przegladu date  NOT NULL,
    Opis_Stanu varchar2(100)  NOT NULL,
    Status_Dostepnosci integer  NOT NULL,
    CONSTRAINT Stan_Samochodu_pk PRIMARY KEY (Samochod_Id,Pracownik_Id)
) ;

-- foreign keys
-- Reference: Historia_Wypozyczen_Pracownik (table: Historia_Wypozyczen)
ALTER TABLE Historia_Wypozyczen ADD CONSTRAINT Historia_Wypozyczen_Pracownik
    FOREIGN KEY (Pracownik_Id)
    REFERENCES Pracownik (Id);

-- Reference: Historia_Wypozyczen_Rezerwacja (table: Historia_Wypozyczen)
ALTER TABLE Historia_Wypozyczen ADD CONSTRAINT Historia_Wypozyczen_Rezerwacja
    FOREIGN KEY (Rezerwacja_Id)
    REFERENCES Rezerwacja (Id);

-- Reference: Historia_Wypozyczen_Samochod (table: Historia_Wypozyczen)
ALTER TABLE Historia_Wypozyczen ADD CONSTRAINT Historia_Wypozyczen_Samochod
    FOREIGN KEY (Samochod_Id)
    REFERENCES Samochod (Id);

-- Reference: Klient_Miasto (table: Klient)
ALTER TABLE Klient ADD CONSTRAINT Klient_Miasto
    FOREIGN KEY (Miasto_Id)
    REFERENCES Miasto (Id);

-- Reference: Pracownik_Miasto (table: Pracownik)
ALTER TABLE Pracownik ADD CONSTRAINT Pracownik_Miasto
    FOREIGN KEY (Miasto_Id)
    REFERENCES Miasto (Id);

-- Reference: Rezerwacja_Model (table: Rezerwacja)
ALTER TABLE Rezerwacja ADD CONSTRAINT Rezerwacja_Model
    FOREIGN KEY (Model_Id)
    REFERENCES Model (Model_Id);

-- Reference: Rezerwacje_Klient (table: Rezerwacja)
ALTER TABLE Rezerwacja ADD CONSTRAINT Rezerwacje_Klient
    FOREIGN KEY (Klient_Id)
    REFERENCES Klient (Id);

-- Reference: Rezerwacje_Pracownik (table: Rezerwacja)
ALTER TABLE Rezerwacja ADD CONSTRAINT Rezerwacje_Pracownik
    FOREIGN KEY (Pracownik_Id)
    REFERENCES Pracownik (Id);

-- Reference: Stan_Samochodu_Pracownik (table: Stan_Samochodu)
ALTER TABLE Stan_Samochodu ADD CONSTRAINT Stan_Samochodu_Pracownik
    FOREIGN KEY (Pracownik_Id)
    REFERENCES Pracownik (Id);

-- Reference: Stan_Samochodu_Samochod (table: Stan_Samochodu)
ALTER TABLE Stan_Samochodu ADD CONSTRAINT Stan_Samochodu_Samochod
    FOREIGN KEY (Samochod_Id)
    REFERENCES Samochod (Id);

-- Reference: Wypozyczenie_Klient (table: Historia_Wypozyczen)
ALTER TABLE Historia_Wypozyczen ADD CONSTRAINT Wypozyczenie_Klient
    FOREIGN KEY (Klient_Id)
    REFERENCES Klient (Id);

-- End of file.

