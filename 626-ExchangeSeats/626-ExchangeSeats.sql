-- Last updated: 14/07/2026, 16:13:24
# Write your MySQL query statement below
SELECT 
    CASE 
        -- If it's the last row and the ID is odd, keep it the same
        WHEN id % 2 = 1 AND id = (SELECT COUNT(*) FROM Seat) THEN id
        -- If the ID is odd, increment it
        WHEN id % 2 = 1 THEN id + 1
        -- If the ID is even, decrement it
        ELSE id - 1
    END AS id,
    student
FROM Seat
ORDER BY id ASC;