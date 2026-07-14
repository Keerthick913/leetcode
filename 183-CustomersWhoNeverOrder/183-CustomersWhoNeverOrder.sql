-- Last updated: 14/07/2026, 16:16:08
# Write your MySQL query statement below
SELECT c.name AS Customers
FROM Customers c
WHERE NOT EXISTS (
    SELECT 1 
    FROM Orders o 
    WHERE o.customerId = c.id
);