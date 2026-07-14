-- Last updated: 14/07/2026, 16:16:01
# Write your MySQL query statement below
DELETE p FROM Person p
JOIN Person p2 
ON p.Email = p2.Email AND p.Id > p2.Id;