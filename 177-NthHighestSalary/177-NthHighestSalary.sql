-- Last updated: 14/07/2026, 16:16:17
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N - 1;
  RETURN (
      SELECT DISTINCT salary 
      FROM Employee 
      ORDER BY salary DESC 
      LIMIT 1 OFFSET M
  );
END