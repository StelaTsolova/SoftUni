SELECT `employee_id`, `first_name`
FROM `employees` 
WHERE `employee_id` NOT IN (SELECT `employee_id` FROM `employees_projects`)
ORDER BY `employee_id` DESC
LIMIT 3;