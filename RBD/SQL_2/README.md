## Klauzula WHERE (opcjonalna) ograniczająca zwracane rekordy do tych tylko, które 
dla podanego po WHERE warunku logicznego zwracają TRUE (odrzucane są te, które 
zwracają FALSE lub NULL). Warunek logiczny może być zbudowany z wielu zdań 
logicznych, połączonych negacją NOT, koniunkcją AND lub alternatywą OR. 

1. Wypisz nazwiska, numery pracowników, stanowiska pracy, płacę i numery 
departamentów wszystkich zatrudnionych na stanowisku CLERK. 
2. Wybierz wszystkie nazwy i numery departamentów większe od 20. 
3. Wypisz numery i nazwiska pracowników, których prowizja przekracza miesięczną 
pensję. 
4. Wybierz wszystkie dane tych pracowników, których płaca mieści się w przedziale  
<1000, 2000>. 
5. Wybierz wszystkie dane tych pracowników, których bezpośrednimi szefami są 
pracownicy o numerach 7902, 7566 lub 7788. 
6. Wybierz wszystkie dane tych pracowników, których nazwiska zaczynają się na literę S. 
Predykat LIKE oraz wildcards, czyli znaki uniwersalne: ‘_’ (zastępujący jeden dowolny 
znak) i ‘%’ (zastępujący dowolny ciąg znaków).  
7. Wybierz wszystkie dane pracowników, których nazwiska są czteroliterowe, używając i 
nie używając funkcji zwracającej długości napisu LENGHT (Oracle) i LEN (Ms SQL 
Server). 
8. Wypisz numer, nazwisko i stanowisko tych pracowników, którzy nie posiadają szefa. 
9. Wypisz numer, nazwisko i płacę tych pracowników, których zarobki są poza 
przedziałem <1000, 2000>. 
10. Wypisz numer, nazwisko i numer działu tych pracowników, których nazwiska nie 
zaczynają się na literę M. 
11. Wybierz nazwiska tych pracowników, którzy mają szefa. 
12. Wypisz nazwisko, numer działu, płacę i stanowisko pracowników zatrudnionych na 
stanowisku CLERK, których zarobki mieszczą się w przedziale <1000, 2000>. 
13. Wypisz nazwisko, numer działu, płacę i stanowisko tych pracowników, którzy albo są 
zatrudnieni na stanowisku CLERK, albo ich zarobki mieszczą się w przedziale <1000, 
2000>. 
14. Wypisz nazwisko, płacę i stanowisko wszystkich pracowników zatrudnionych na 
stanowisku MANAGER z pensją powyżej (Sal) równą 1500 oraz wszystkich 
zatrudnionych na stanowisku SALESMAN. 
15. Wypisz nazwisko, płacę i stanowisko wszystkich pracowników zatrudnionych na 
stanowisku MANAGER lub na stanowisku SALESMAN, których pensje (Sal) są 
wyższe od 1500. 
16. Wypisz nazwisko, stanowisko i numer departamentu wszystkich pracowników 
zatrudnionych na stanowisku MANAGER ze wszystkich departamentów wraz ze 
wszystkimi pracownikami zatrudnionymi na stanowisku CLERK w departamencie 10. 
17. Wypisz wszystkie dane z tabeli SALGRADE. 
18. Wypisz wszystkie dane z tabeli DEPT. 
19. Wypisz wszystkie dane tych pracowników, których roczne dochody (z uwzględnieniem 
prowizji)  są mniejsze od 12000 lub większe od 24000/ 
20. Wypisz numery pracownicze, stanowiska i numery departamentów wszystkich 
pracowników. Wynik posortuj rosnąco według numerów departamentów i stanowisk. 
21. Wypisz wszystkie wzajemnie różne, (czyli bez powtórzeń) nazwy stanowisk pracy. 
22. Wypisz wszystkie dane pracowników zatrudnionych w departamentach 10 i 20 w 
kolejności alfabetycznej ich nazwisk. 
23. Wypisz wszystkie nazwiska i stanowiska pracy wszystkich pracowników z 
departamentu 20 zatrudnionych na stanowisku CLERK. 
24. Wybierz nazwiska tych pracowników, w których nazwisku występuje ciąg liter „TH” 
lub „LL”. 
25. Wypisz nazwisko, stanowisko i pensję pracowników, którzy posiadają szefa. 
26. Wypisz nazwiska i całoroczne dochody (z uwzględnieniem jednorazowej rocznej 
prowizji COMM) wszystkich pracowników. 
27. Wypisz nazwisko, numer departamentu i datę zatrudnienia tych pracowników, którzy 
zostali zatrudnieni w 1982 r. 
28. Wypisz nazwiska, roczną pensję oraz prowizję tych wszystkich SALESMAN’ów, 
których miesięczna pensja przekracza prowizję. Wyniki posortuj według malejących 
zarobków, potem nazwisk (rosnąco).