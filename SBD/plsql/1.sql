CREATE OR REPLACE PROCEDURE first (
    deptName VARCHAR2(50),
    deptLoc VARCHAR2(50),
    newDeptID OUT INTEGER
)
AS
    existingCount INTEGER;
BEGIN

    SELECT COUNT(*) INTO existingCount FROM DEPT WHERE DNAME = deptName OR LOC = deptLoc;

    IF existingCount > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Dział o podanej nazwie lub lokalizacji już istnieje.');
    ELSE
        SELECT MAX(DEPTNO) + 1 INTO newDeptID FROM DEPT;
        INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (newDeptID, deptName, deptLoc);
    END IF;
END;