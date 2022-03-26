# DELIMITER $$

CREATE FUNCTION udf_users_photos_count(username VARCHAR(30)) 
RETURNS INT 
DETERMINISTIC
BEGIN
RETURN 
(SELECT COUNT(up.`user_id`)
FROM `users` as u
JOIN `users_photos` as up
ON up.`user_id` = u.`id`
WHERE u.`username` = username);
END 

# DELIMITER ;