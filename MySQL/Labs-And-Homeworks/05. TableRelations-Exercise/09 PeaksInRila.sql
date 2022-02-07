SELECT `mountain_range`, `peak_name`, 
`elevation` AS `peak_elevation`
FROM `peaks` AS p
JOIN `mountains` AS m
ON m.`id` = p.`mountain_id`
WHERE `mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;