CREATE OR REPLACE PROCEDURE second
AS
    empNumber INTEGER;
    empSal INTEGER;
    CURSOR cur1 IS SELECT empno, sal FROM EMP;
BEGIN

    OPEN cur1;

    LOOP

        FETCH cur1 INTO empNumber, empSal;
        EXIT WHEN cur1%NOTFOUND;

        IF empSal < 1000 THEN
            UPDATE emp SET sal = sal + (sal * 0.10) WHERE EMPNO = empNumber;
            DBMS_OUTPUT.PUT_LINE('Podwyzszono wyplate pracownika z ID ' || empNumber || ' o 10%');
        ELSIF empSal > 1500 THEN
            UPDATE emp SET sal = sal - (sal * 0.10) WHERE EMPNO = empNumber;
            DBMS_OUTPUT.PUT_LINE('Obnizono wyplate pracownika z ID ' || empNumber || ' o 10%');
        END IF;
    END LOOP;

    CLOSE cur1;
END;