SELECT g.`name`, 
(CASE
WHEN `budget` < 50000 THEN 'Normal budget'
ELSE 'Insufficient budget'
END) as 'budget_level',
t.`name` as 'team_name',
a.`name` as 'address_name '
FROM `games` as g
JOIN `teams` as t
ON g.`team_id` = t.`id`
JOIN `offices` as o
ON t.`office_id` = o.`id`
JOIN `addresses` as a
ON o.`address_id` = a.`id`
WHERE g.`id` NOT IN (SELECT `game_id` FROM `games_categories`) 
AND `release_date` IS NULL
ORDER BY g.`name`;