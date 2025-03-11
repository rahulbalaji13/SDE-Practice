SELECT E1.NAME AS Lower_Earner, E2.NAME AS Higher_Earner
FROM EMPLOYEE E1
JOIN EMPLOYEE E2 ON E1.SALARY < E2.SALARY
ORDER BY E1.ID ASC, E2.SALARY ASC;
