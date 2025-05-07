CREATE OR REPLACE PROCEDURE fourth (
    deptName VARCHAR2(50), empName VARCHAR2(50)
)
AS
    existingCount INTEGER;
    newEmpJob VARCHAR2(50);
    newEmpSal INTEGER;
    newEmpNo INTEGER;
    newDeptNo INTEGER;
BEGIN

    SELECT COUNT(*) INTO existingCount FROM DEPT WHERE DNAME = deptName;

    IF existingCount != 1 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Dział o podanej nazwie nie istnieje!');
    END IF;

    SELECT job INTO newEmpJob FROM emp GROUP BY job HAVING COUNT(*) = (
        SELECT MAX(COUNT(*)) FROM emp GROUP BY job
    );

    SELECT MIN(sal) INTO newEmpSal FROM emp INNER JOIN dept ON emp.DEPTNO = dept.DEPTNO WHERE DNAME = deptName;

    SELECT MAX(DEPTNO) + 1 INTO newEmpNo FROM DEPT;

    SELECT deptno INTO newDeptNo FROM DEPT WHERE dname = deptName;

    INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    VALUES (newEmpNo, empName, newEmpJob, NULL, SYSDATE, newEmpSal, NULL, newDeptNo);
END;