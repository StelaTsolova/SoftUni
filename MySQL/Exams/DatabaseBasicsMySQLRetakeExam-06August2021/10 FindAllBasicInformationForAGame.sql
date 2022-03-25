# DELIMITER $$

CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20)) 
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
RETURN 
(SELECT CONCAT_WS(' ', 'The', g.`name`, 'is developed by a', t.`name`, 'in an office with an address', a.`name`) 
FROM `games` as g
JOIN `teams` as t
ON g.`team_id` = t.`id`
JOIN `offices` as o
ON t.`office_id` = o.`id`
JOIN `addresses` as a
ON o.`address_id` = a.`id`
WHERE g.`name` = game_name);
END 

# DELIMITER ;