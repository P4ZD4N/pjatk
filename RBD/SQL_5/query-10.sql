SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MAX(AVG(SAL)) FROM EMP GROUP BY JOB);