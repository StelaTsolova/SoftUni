# DELIMITER $$

CREATE PROCEDURE udp_reduce_price (category_name VARCHAR(50))
BEGIN
UPDATE `products` as p
JOIN `reviews` as r
ON p.`review_id` = r.`id`
JOIN `categories` as c
ON p.`category_id` = c.`id`
SET p.`price` = p.`price` - (p.`price` * 0.3)
WHERE r.`rating` < 4 AND c.`name` = category_name;
END 

# DELIMITER ;