-- Last updated: 14/07/2026, 16:16:19
SELECT 
    IFNULL(
        (SELECT DISTINCT salary 
         FROM Employee 
         ORDER BY salary DESC 
         LIMIT 1 OFFSET 1), 
    NULL) AS SecondHighestSalary;