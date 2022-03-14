# DELIMITER $$

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30)) 
RETURNS INT 
DETERMINISTIC
BEGIN
RETURN 
(SELECT COUNT(c.`id`)
FROM `customers` as c
JOIN `orders` as o
ON `customer_id` = c.`id`
JOIN `orders_products` as op
ON op.`order_id` = o.`id`
JOIN `products` as p
ON op.`product_id` = p.`id`
WHERE c.`first_name` = name
GROUP BY c.`id`);
END 

# DELIMITER ;