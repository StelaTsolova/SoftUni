SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`) as 'Full_name', 
s.`name` as 'Store_name', 
a.`name`, e.`salary`
FROM `employees` as e
JOIN `stores` as s
ON e.`store_id` = s.`id`
JOIN `addresses` as a
ON s.`address_id` = a.`id`
WHERE e.`salary` < 4000 AND a.`name` LIKE '%5%' AND CHAR_LENGTH(a.`name`) > 8 AND RIGHT(e.`last_name`, 1) = 'n'; 