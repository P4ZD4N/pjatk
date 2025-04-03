CREATE TRIGGER trigger1
ON Emp
FOR INSERT, UPDATE, DELETE
AS
BEGIN

    IF EXISTS (SELECT * FROM deleted WHERE deleted.sal > 0) AND NOT EXISTS(SELECT * FROM inserted)
    BEGIN
        THROW 50000, 'Nie mozna usunac pracownika z wynagrodzeniem wiekszym niz 0!', 1;
        RETURN;
    END

    IF EXISTS (SELECT 1 FROM inserted i JOIN deleted d ON i.empno = d.empno WHERE i.ename <> d.ename)
    BEGIN
        THROW 50000, 'Nie mozna zmienic nazwiska pracownika!', 1;
        RETURN;
    END

    IF EXISTS (
        SELECT 1 FROM inserted i
        WHERE EXISTS(SELECT 1 FROM Emp e WHERE e.ename = i.ename AND e.empno <> i.empno)
    )
    BEGIN
        THROW 50000, 'Pracownik o takim nazwisku juz istnieje!', 1;
        RETURN;
    END

END;