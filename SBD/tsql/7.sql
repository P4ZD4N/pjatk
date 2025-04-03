CREATE TRIGGER trigger3
ON Emp
FOR DELETE, UPDATE
AS
BEGIN

    IF EXISTS (SELECT * FROM deleted) AND NOT EXISTS(SELECT * FROM inserted)
    BEGIN
        THROW 50000, 'Nie mozna usunac pracownika!', 1;
    END

    IF EXISTS (SELECT 1 FROM inserted i INNER JOIN deleted d ON i.empno = d.empno WHERE i.sal < d.sal)
    BEGIN
        THROW 50000, 'Nie mozna obnizyc wynagrodzenia!', 1;
    END

END;