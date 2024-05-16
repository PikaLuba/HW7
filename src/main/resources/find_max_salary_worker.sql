SELECT name, MAX(salary) salary
FROM world.worker
WHERE salary = (SELECT MAX(salary) FROM world.worker)
group by name;