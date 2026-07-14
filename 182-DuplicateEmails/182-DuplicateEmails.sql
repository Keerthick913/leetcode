-- Last updated: 14/07/2026, 16:16:10
SELECT 
    email AS Email
FROM 
    Person
GROUP BY 
    email
HAVING 
    COUNT(email) > 1;