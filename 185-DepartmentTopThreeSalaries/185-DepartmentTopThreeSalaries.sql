-- Last updated: 14/07/2026, 16:16:04
# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE (
        SELECT COUNT(DISTINCT salary)
        FROM Employee
        WHERE departmentId = e.departmentId
          AND salary > e.salary
      ) < 3;