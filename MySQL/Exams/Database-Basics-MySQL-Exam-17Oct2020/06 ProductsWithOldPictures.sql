SELECT p.`name`, p.`price`, p.`best_before`, 
CONCAT(SUBSTRING(p.`description`, 1, 10), '...') as 'short_description', 
pi.`url`
FROM `products` as p
JOIN `pictures` as pi
ON p.`picture_id` = pi.`id`
WHERE CHAR_LENGTH(p.`description`) > 100 
AND YEAR(pi.`added_on`) < 2019 
AND p.`price` > 20
ORDER BY p.`price` DESC;