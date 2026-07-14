-- Last updated: 14/07/2026, 16:12:32
# Write your MySQL query statement below
select actor_id, director_id 
from(
select actor_id,director_id, 
count(timestamp) as cooperated 
from ActorDirector 
group by actor_id,director_id) 
table1
where cooperated>=3;