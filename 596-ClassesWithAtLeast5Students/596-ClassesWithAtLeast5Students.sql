-- Last updated: 14/07/2026, 16:13:32
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;