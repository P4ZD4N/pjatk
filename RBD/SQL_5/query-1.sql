SELECT ENAME, SAL
FROM EMP 
WHERE SAL = (SELECT MIN(SAL) FROM EMP);