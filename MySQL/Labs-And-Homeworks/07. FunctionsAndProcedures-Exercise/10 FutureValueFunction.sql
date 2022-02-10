# DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value (sum DECIMAL(19, 4), yearly_interest_rate DOUBLE, number_years INT)
RETURNS DECIMAL (19, 4)
DETERMINISTIC
BEGIN
	RETURN (sum * pow((1 + yearly_interest_rate), number_years));
END 

# DELIMITER ;