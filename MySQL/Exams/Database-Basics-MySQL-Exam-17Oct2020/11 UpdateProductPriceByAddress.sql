# DELIMITER $$

CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
UPDATE `products` AS p
JOIN`products_stores` AS ps
ON ps.`product_id` = p.`id`
JOIN`stores` AS s 
ON ps.`store_id` = s.`id`
JOIN `addresses` AS a 
ON s.`address_id` = a.`id` 
SET p.`price` = CASE
        WHEN a.`name` LIKE '0%' THEN p.`price` + 100
        ELSE p.`price` + 200
    END
WHERE a.`name` = address_name;
END 

# DELIMITER ;