INSERT INTO `clients` (`full_name`, `phone_number`)
SELECT concat_ws(' ', d.first_name, d.last_name), concat('(088) 9999', (d.id*2))
FROM `drivers` as d
WHERE d.id BETWEEN 10 AND 20;