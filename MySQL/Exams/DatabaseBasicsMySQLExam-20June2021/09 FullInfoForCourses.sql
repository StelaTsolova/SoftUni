SELECT a.`name`,
(
 CASE
  WHEN HOUR(`start`) BETWEEN 6 AND 20 THEN 'Day'
  WHEN HOUR(`start`) >= 21 OR HOUR(`start`) <= 5 THEN 'Night'
  END
  ) as 'day_time',
  c.`bill`, cl.`full_name`, ca.`make`, ca.`model`, cat.`name` as 'category_name'
FROM `courses` as c
JOIN `addresses` as a
ON c.`from_address_id` = a.`id`
JOIN `clients` as cl
ON c.`client_id` = cl.`id`
JOIN `cars` as ca
ON c.`car_id` = ca.`id`
JOIN `categories` as cat
ON ca.`category_id` = cat.`id`
GROUP BY c.`id`
ORDER BY c.`id`;