SELECT ca.`id`, ca.`make`, ca.`mileage`, 
COUNT(c.`car_id`) as 'count_of_courses',
ROUND(AVG(c.`bill`), 2) as 'avg_bill'
FROM `cars` as ca
LEFT JOIN `courses` as c
ON c.`car_id` =  ca.`id`
GROUP BY ca.`id`
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, ca.`id`;