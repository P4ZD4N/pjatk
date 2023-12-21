SELECT DEPTNO FROM EMP;
SELECT DEPTNO FROM DEPT;

-- Jest widoczna różnica pomiędzy wynikami tych zapytań, ponieważ pierwsze zwraca numer działu każdego pracownika,
-- który znajduje się w tabeli EMP, natomiast drugie każdy numer działu, który istnieje w tabeli DEPT.

SELECT DISTINCT DEPTNO FROM EMP;
SELECT DEPTNO FROM DEPT;

-- Po dodaniu DISTINCT wynik nie jest identyczny, klauzula ta powoduje,
-- że wyświetlone zostaną wszystkie unikalne numery działów, które występują w tabeli EMP.
-- Wynik porównany z wynikiem polecenia SELECT DEPTNO FROM DEPT; też nie jest taki sam,
-- ponieważ w tabeli EMP do żadnego pracownika nie jest przypisany numer 40.