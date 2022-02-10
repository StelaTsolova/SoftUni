# DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with (town VARCHAR(50))
BEGIN
	SELECT `name` AS `town_name`
    FROM `towns`
    WHERE `name` LIKE CONCAT(town, '%')
    ORDER BY `name`;
END 

# DELIMITER ;