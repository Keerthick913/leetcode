-- Last updated: 14/07/2026, 16:12:24
WITH WeeklyMeetings AS (
    SELECT 
        employee_id,
        YEARWEEK(meeting_date, 1) AS meeting_week,
        SUM(duration_hours) AS total_hours
    FROM 
        meetings
    GROUP BY 
        employee_id, 
        YEARWEEK(meeting_date, 1)
    HAVING 
        SUM(duration_hours) > 20
),
HeavyWeeksCount AS (
    SELECT 
        employee_id,
        COUNT(meeting_week) AS meeting_heavy_weeks
    FROM 
        WeeklyMeetings
    GROUP BY 
        employee_id
    HAVING 
        COUNT(meeting_week) >= 2
)
SELECT 
    e.employee_id,
    e.employee_name,
    e.department,
    h.meeting_heavy_weeks
FROM 
    HeavyWeeksCount h
JOIN 
    employees e ON h.employee_id = e.employee_id
ORDER BY 
    h.meeting_heavy_weeks DESC,
    e.employee_name ASC;