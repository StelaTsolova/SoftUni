# DELIMITER $$
    
CREATE PROCEDURE `usp_raise_salary_by_id` (`id` INT)
DETERMINISTIC
BEGIN
UPDATE `employees` AS e
	JOIN `departments` AS d
	ON e.`department_id` = d.`department_id`
	SET e.`salary` = e.`salary` * 1.05
	WHERE e.`employee_id` = `id`;
END

# DELIMITER ;