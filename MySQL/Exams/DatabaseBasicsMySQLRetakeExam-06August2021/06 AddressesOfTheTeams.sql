SELECT t.`name` as 'team_name', 
a.`name` as 'address_name', 
CHAR_LENGTH(a.`name`) as 'count_of_characters'
FROM `teams` as t
JOIN `offices` as o
ON t.`office_id` = o.`id`
JOIN `addresses` as a
ON o.`address_id` = a.`id`
WHERE o.`website` IS NOT NULL
ORDER BY team_name, address_name;