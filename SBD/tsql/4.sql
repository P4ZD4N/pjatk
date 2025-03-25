CREATE PROCEDURE InsertNewEmployee
    @deptName VARCHAR(20),
    @empSurname VARCHAR(20)
AS
BEGIN

    IF NOT EXISTS(SELECT 1 FROM Dept WHERE dname = @deptName)
    BEGIN
        THROW 51001, 'Department with this name not exist!', 1;
    END

    DECLARE @empJob VARCHAR(20), @empSal INT, @empNo INT, @deptNo INT;

    SELECT TOP 1 @empJob = job 
    FROM Emp 
    GROUP BY job 
    ORDER BY COUNT(*) DESC;
    
    SELECT @empSal = MIN(sal) 
    FROM Emp 
    INNER JOIN Dept on Emp.deptno = Dept.deptno 
    WHERE dname = @deptName;
    
    SELECT @empNo = MAX(empno) + 1 
    FROM Emp;
    
    SELECT @deptNo = deptno 
    FROM Dept
    WHERE dname = @deptName;

    INSERT INTO Emp(empno, ename, job, hiredate, sal, deptno) 
    VALUES (@empNo, @empSurname, @empJob, GETDATE(), @empSal, @deptNo);
END;