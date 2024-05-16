SELECT 'YOUNGEST' type, name,  DATE_FORMAT(w.birthday, '%d.%m.%Y') birhday
FROM world.worker w
WHERE now() - w.birthday = (SELECT MAX(now() - birthday) FROM world.worker)
union
SELECT 'ELDEST' type, name, DATE_FORMAT(w.birthday, '%d.%m.%Y') birhday
FROM world.worker w
WHERE now() - w.birthday = (SELECT MIN(now() - birthday) FROM world.worker);
