 # DELIMITER $$

CREATE PROCEDURE usp_transfer_money (from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
    IF from_account_id  NOT IN (SELECT `id` FROM `accounts`) 
    OR to_account_id NOT IN (SELECT `id` FROM `accounts`) 
    OR amount <= 0 
    OR from_account_id = to_account_id
    OR (SELECT `balance` FROM `accounts` WHERE `id` = from_account_id) < amount 
    THEN ROLLBACK;
    ELSE 
	   UPDATE `accounts`
		SET `balance` = `balance` - amount
		WHERE `id` = from_account_id;
        
        UPDATE `accounts`
        SET `balance` = `balance` + amount
		WHERE `id` = to_account_id;
	END IF;
END 

# DELIMITER ;