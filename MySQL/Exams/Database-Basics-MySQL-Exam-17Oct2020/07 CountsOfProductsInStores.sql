SELECT s.`name`, 
COUNT(ps.`product_id`) as 'product_count', 
ROUND(AVG(p.`price`), 2) as 'avg'
FROM `stores` as s
LEFT JOIN `products_stores` as ps
ON ps.`store_id` = s.`id`
LEFT JOIN `products` as p
ON ps.`product_id` = p.`id`
GROUP BY s.`id`
ORDER BY product_count DESC, `avg` DESC, s.`id`;