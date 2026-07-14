-- Last updated: 14/07/2026, 16:12:25
SELECT 
    user_id, 
    email
FROM 
    Users
WHERE 
    email REGEXP '^[a-zA-Z0-9_]+@[a-zA-Z]+\\.com$'
ORDER BY 
    user_id ASC;