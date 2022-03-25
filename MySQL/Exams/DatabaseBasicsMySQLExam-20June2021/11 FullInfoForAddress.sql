# DELIMITER $$

CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT a.`name`, cl.`full_name`,
 ( CASE
WHEN c.`bill` <= 20 THEN 'Low'
WHEN c.`bill` <= 30 THEN 'Medium'
WHEN  c.`bill` > 30 THEN 'High'
 END ) as 'level_of_bill',
 ca.`make`, ca.`condition`, cat.`name`
 FROM `addresses` as a
 JOIN `courses` as c
ON c.`from_address_id` = a.`id`
JOIN `clients` as cl
ON c.`client_id` = cl.`id`
JOIN `cars` as ca
ON c.`car_id` = ca.`id`
JOIN `categories` as cat
ON ca.`category_id` = cat.`id`
WHERE a.`name` = address_name
ORDER BY ca.`make`, cl.`full_name`;
END 

# DELIMITER ;