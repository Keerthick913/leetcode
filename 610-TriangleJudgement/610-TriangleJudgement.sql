-- Last updated: 14/07/2026, 16:13:26
# Write your MySQL query statement below
SELECT 
    x, 
    y, 
    z,
    CASE 
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM 
    Triangle;