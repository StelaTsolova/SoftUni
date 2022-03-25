# DELIMITER $$

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN 
 (SELECT COUNT(c.`id`)
 FROM `clients` as cl
 JOIN `courses` as c
 ON c.`client_id` = cl.`id`
 WHERE `phone_number` = phone_num);
END 

# DELIMITER ;
 