CREATE TRIGGER trigger2
ON Dept
FOR UPDATE
AS
BEGIN

    IF EXISTS (SELECT 1 FROM inserted i JOIN Dept d ON i.dname = d.dname AND i.deptno <> d.deptno)
    BEGIN
        UPDATE Dept
        SET dname = d.dname
        FROM Dept d
        JOIN deleted old ON d.deptno = old.deptno;

        RAISERROR('Nie mozna zmienic nazwy dzialu na istniejaca wartosc!', 10, 1);
    END

END;