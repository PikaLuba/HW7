select p.name name, ttt.count_month * tt.sum_salary price
from world.progect p, (select pw.progect_id progect_id, sum(w.salary) sum_salary
                  from world.progect_worker pw, world.worker w
                  where pw.worker_id = w.id
                  group by  pw.progect_id) tt,

                (select p.id progect_id, period_diff(DATE_FORMAT(p.finish_date, '%Y%m'), DATE_FORMAT(p.start_date, '%Y%m')) count_month
                  from world.progect p) ttt
where p.id = tt.progect_id and 
      p.id = ttt.progect_id
order by ttt.count_month * tt.sum_salary desc; 