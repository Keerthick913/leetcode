-- Last updated: 14/07/2026, 16:14:50
# Write your MySQL query statement below
select name from Employee
where id IN ( select managerId from Employee
group by managerId
having count(*)>=5);