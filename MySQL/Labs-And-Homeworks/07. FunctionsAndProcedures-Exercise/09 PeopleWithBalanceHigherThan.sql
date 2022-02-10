# DELIMITER $$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than (given_number DECIMAL(19, 4))
BEGIN
	SELECT ah.`first_name`, ah.`last_name`
    FROM `account_holders` AS ah
    WHERE (SELECT SUM(a.`balance`) 
		FROM `accounts` AS a
		WHERE ah.`id` = a.`account_holder_id` 
		GROUP BY ah.`id`) > given_number
    ORDER BY ah.`id`;
END 

# DELIMITER ;