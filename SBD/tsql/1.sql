
CREATE PROCEDURE InsertNewDepartment
    @DeptName VARCHAR(20),
    @DeptLoc VARCHAR(20)
AS
BEGIN
    DECLARE @DeptNo INT;

    IF EXISTS(SELECT 1 FROM Dept WHERE dname = @DeptName AND loc = @DeptLoc)
    BEGIN
        THROW 50001, 'Department with the same name and location already exists!', 1;
    END

    SELECT @DeptNo = ISNULL(MAX(deptno), 0) + 1 FROM Dept;
    INSERT INTO Dept(deptno, dname, loc) VALUES (@DeptNo, @DeptName, @DeptLoc);
END;