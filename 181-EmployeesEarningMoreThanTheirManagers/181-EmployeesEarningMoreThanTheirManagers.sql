-- Last updated: 14/07/2026, 16:16:12
SELECT 
    name AS Employee
FROM 
    Employee e
WHERE 
    salary > (
        SELECT salary 
        FROM Employee 
        WHERE id = e.managerId
    );