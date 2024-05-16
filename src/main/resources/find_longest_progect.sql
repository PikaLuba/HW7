select p.name name, max(tt.count_month) month_count
from world.progect p, (select pp.id,
				 period_diff(DATE_FORMAT(pp.finish_date, '%Y%m'), DATE_FORMAT(pp.start_date, '%Y%m')) count_month
				from world.progect pp) tt

where p.id = tt.id and

tt.count_month = (SELECT MAX(
       period_diff(DATE_FORMAT(finish_date, '%Y%m'), DATE_FORMAT(start_date, '%Y%m'))
          ) FROM world.progect
				 )
group by p.name;