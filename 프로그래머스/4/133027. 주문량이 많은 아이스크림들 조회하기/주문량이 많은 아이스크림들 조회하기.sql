select j.FLAVOR
from JULY j left join FIRST_HALF fh on fh.SHIPMENT_ID = j.SHIPMENT_ID
group by j.FLAVOR
order by sum(fh.TOTAL_ORDER) + sum(j.TOTAL_ORDER) desc
limit 3;