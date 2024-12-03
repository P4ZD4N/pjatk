# Zadania z podzapytaniem; w tej części WSZYSTKIE zadania należy rozwiązać stosując podzapytania.
1. Znajdź nazwiska i pensje pracowników, których pensja jest równa minimalnej pensji w 
firmie.
2. Znajdź nazwiska, pensje i numery departamentów wszystkich pracowników 
zatrudnionych na tym samym stanowisku, co BLAKE.
3. Z wyniku poprzedniego zadania wyeliminuj dane BLAKE’a.
4. Znajdź nazwisko, pensję i numer departamentu pracowników, których płace wynoszą 
tyle, ile najniższe zarobki w poszczególnych departamentach.
5. Znajdź nazwisko, pensję i numer departamentu pracowników o najniższych zarobkach 
w tych departamentach, w których są zatrudnieni. 
UWAGA: różnica pomiędzy zadaniem 4 i 5 polega na tym, że w zadaniu 4 warunkiem 
jest tylko płaca równa najniższej płacy w DOWOLNYM departamencie; w zadaniu 5
szukamy najmniej zarabiających w SWOIM departamencie. W ORACLE możemy 
porównywać listy wartości (w tym przypadku pary Sal i Deptno). W MS SQL Server taka 
możliwość nie istnieje - zadanie należy rozwiązać stosując zapytanie skorelowane z 
podzapytaniem. 
6. Stosując kwantyfikator ANY wypisz nazwisko, pensję i numer departamentu
pracowników zarabiających powyżej najniższej pensji z departamentu 30 (czyli więcej 
od dowolnego pracownika z departamentu 30, czyli tego, który zarabia najmniej).
7. Stosując kwantyfikator ALL wypisz nazwisko, pensję i numer departamentu
pracowników, których zarobki są wyższe od pensji każdego pracownika z departamentu 
30 (czyli większe od najwyższej pensji w departamencie 30). 
8. Znajdź numery departamentów, których średnie zarobki przekraczają średni zarobek 
departamentu 30.
9. Do wyniku zadania poprzedniego dodaj wartości średnich zarobków w departamentach, 
nazwy i lokalizacje departamentów.
10. Znajdź stanowisko, na którym są najwyższe średnie zarobki. 
WSKAZÓWKA: w ORACLE można stosować zagnieżdżenia funkcji agregujących. W 
MS SQL Server należy posłużyć się albo zapytaniem skorelowanym (patrz dział VI), 
albo użyć kwantyfikatora ALL. 
11. Znajdź nazwisko, pensję, stanowisko i numer departamentu pracowników, których 
zarobki przekraczają najwyższe pensje z departamentu SALES. 
12. Znajdź nazwisko, stanowisko i pensję pracowników, którzy pracują na tym samym 
stanowisku, co pracownik o numerze 7369 i których zarobki są większe niż pracownika 
o numerze 7876. 
13. Wypisz nazwy działów, w których pracują urzędnicy (CLERK).
