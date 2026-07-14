-- Last updated: 14/07/2026, 16:13:30
# Write your MySQL query statement below
SELECT 
    name
FROM 
    SalesPerson
WHERE 
    sales_id NOT IN (
        SELECT 
            o.sales_id
        FROM 
            Orders o
        JOIN 
            Company c ON o.com_id = c.com_id
        WHERE 
            c.name = 'RED'
    );