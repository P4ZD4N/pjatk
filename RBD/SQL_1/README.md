# Proste zapytania zwracające wszystkie rekordy z jednej tabeli.
## Klauzule SELECT i FROM są obligatoryjne w każdym zapytaniu.
1. Wybierz numery departamentów, nazwiska pracowników oraz numery pracownicze 
ich szefów z tabeli EMP.
2. Wypisz wszystkie dane z wszystkich kolumn tabeli EMP.
3. Wylicz wartość rocznej pensji podstawowej (12 płac miesięcznych) dla każdego 
pracownika, bez uwzględniania prowizji.
4. Oblicz, ile będą wynosiły roczne dochody każdego pracownika, bez uwzględniania 
prowizji, jeśli założymy, że każdy dostanie podwyżkę o 250 miesięcznie.
5. Wyrażenie sal * 12 z poprzedniego zadania zaetykietuj nagłówkiem Roczna.
6. Wyrażenie sal * 12 zaetykietuj nagłówkiem Placa Roczna.
7. Wypisz w jednej kolumnie wynikowej połączony numer pracownika i jego nazwisko. 
Kolumnę wynikową zaetykietuj nagłówkiem Zatrudniony.
8. Literał: Utwórz zapytanie zwracające w jednej kolumnie połączony tekst Pracownik
numer i nazwisko pracownika, tekst pracuje w dziale nr i numer działu. Kolumnę 
wynikową nazwij Informacje o pracownikach.
9. Oblicz roczne dochody każdego pracownika, z uwzględnieniem prowizji comm.
Uwaga: dwuargumentowa funkcja NVL (Oracle) i ISNULL (Ms SQL Server) zwraca 
wartość pierwszego argumentu, jeżeli jest on znaczący albo wartość drugiego 
argumentu, jeżeli pierwszy jest NULL.
10. Wypisz wszystkie numery departamentów występujące w tabeli EMP.
11. Wypisz wszystkie wzajemnie różne, (czyli bez powtórzeń) numery departamentów 
występujące w tabeli EMP. 
Powtarzające się rekordy eliminuje opcjonalne DISTINCT w klauzuli SELECT.
12. Wybierz wszystkie wzajemnie różne (czyli niepowtarzające się) kombinacje wartości 
Deptno i Job.
13. Posortuj rosnąco wszystkie dane tabeli EMP według wartości w kolumnie Ename.
Klauzula ORDER BY (opcjonalna) sortuje zwracane w zapytaniu rekordy rosnąco 
(ASC – domyślne, można opuścić) lub malejąco (DESC) względem kolumn (jednej lub 
kilku) wyspecyfikowanych po klauzuli. W zapytaniu może pojawić się tylko raz, na 
końcu.
14. Posortuj malejąco wszystkie dane tabeli EMP według daty zatrudnienia (kolumna 
Hiredate) począwszy od ostatnio zatrudnionych.
15. Posortuj dane z tabeli EMP według wzrastającej wartości kolumny Deptno, oraz 
malejących wartości kolumny Sal