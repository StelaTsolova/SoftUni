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
END 

# DELIMITER ;