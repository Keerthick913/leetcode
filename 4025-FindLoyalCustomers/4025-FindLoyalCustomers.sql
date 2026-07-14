-- Last updated: 14/07/2026, 16:12:20
select customer_id 
from customer_transactions 
group by customer_id
having sum( transaction_type ='purchase') >2 -- min 3 days
and
datediff(max(transaction_date),min(transaction_date))>29
and
sum(transaction_type ='refund')/count(*)<0.2
order by 1