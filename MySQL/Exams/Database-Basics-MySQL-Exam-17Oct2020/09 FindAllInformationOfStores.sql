SELECT REVERSE(s.`name`) as 'reversed_name',
CONCAT_WS('-', UPPER(t.`name`), a.`name`) as 'full_address',
COUNT(e.`id`) as 'employees_count'
FROM `employees` as e
JOIN `stores` as s
ON e.`store_id` = s.`id`
JOIN `addresses` as a
ON s.`address_id` = a.`id`
JOIN `towns` as t
ON a.`town_id` = t.`id`
GROUP BY s.`name`
ORDER BY full_address;