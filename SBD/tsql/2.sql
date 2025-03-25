CREATE PROCEDURE ModifySalaries
AS
BEGIN

    DECLARE empSalCursor CURSOR FOR SELECT empno, sal FROM emp;
    DECLARE @empNo VARCHAR(20), @empSal INT;

    OPEN empSalCursor

    FETCH NEXT FROM empSalCursor INTO @empNo, @empSal;

    WHILE @@FETCH_STATUS = 0
    BEGIN

        IF @empSal < 1000
        BEGIN
            UPDATE Emp
            SET sal = sal + (sal * 10 / 100)
            WHERE empno = @empNo;

            PRINT 'Salary increased by 10% for employee ID: ' + CAST(@empNo AS VARCHAR);
        END

        IF @empSal > 1500
        BEGIN
            UPDATE Emp
            SET sal = sal - (sal * 10 / 100)
            WHERE empno = @empNo;

            PRINT 'Salary decreased by 10% for employee ID: ' + CAST(@empNo AS VARCHAR);
        END

        FETCH NEXT FROM empSalCursor INTO @empNo, @empSal;
    END

    CLOSE empSalCursor;
    DEALLOCATE empSalCursor;
END;