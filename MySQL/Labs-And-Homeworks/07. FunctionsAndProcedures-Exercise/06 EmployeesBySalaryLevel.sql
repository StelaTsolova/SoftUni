# DELIMITER $$

CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(19,4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(20);
    SET salary_level := 
    (CASE 
		WHEN salary < 30000 THEN 'Low'
		WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
		WHEN salary > 50000 THEN 'High'
    END);    
	RETURN salary_level;
END;

# DELIMITER ;

# DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(20))
BEGIN 
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE salary_level = ufn_get_salary_level(`salary`)
    ORDER BY `first_name` DESC, `last_name` DESC;
END 

# DELIMITER ;