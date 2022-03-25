SELECT cl.`full_name`, 
COUNT(c.`car_id`) as 'count_of_cars',
SUM(c.`bill`) as 'total_sum'
FROM `clients` as cl
JOIN `courses` as c
ON c.`client_id` = cl.`id`
WHERE SUBSTR(cl.`full_name`, 2, 1) = 'a'
GROUP BY cl.`id`
HAVING count_of_cars > 1
ORDER BY cl.`full_name`;