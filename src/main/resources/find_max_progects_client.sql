select c.name name, tt.count_id progectCount
from world.client c, (select p.client_id id, count(p.client_id) count_id
                from world.progect p
                group by p.client_id) tt,

				(select count(p.client_id) max_count
								from world.progect p
								group by p.client_id
				order by count(p.client_id) desc
				limit 1) ttt
where c.id = tt.id and
      tt.count_id = ttt.max_count;


