-- Last updated: 14/07/2026, 16:16:21

SELECT 
    p.firstName, 
    p.lastName, 
    a.city, 
    a.state
FROM 
    Person p
LEFT JOIN 
    Address a ON p.personId = a.personId;