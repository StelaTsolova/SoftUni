# 1. Managers

Write a query to retrieve information about the **managers - id, full_name, deparment_id** and **department_name**. Select the **first 5** departments ordered by **employee_id**. 

### Example 

| **employee_id** | **full_name** | **department_id** | **department_name** | 
| --- | --- | --- | --- |
| 3 |	Roberto Tamburello | 10 |	Finance     |
| 4 |	Rob Walters        | 2  | Tool Design |
| … |	…                  | …  |	…           |

# 2. Towns Addresses

Write a query to get information about the **addresses** in the database, which are in **San Francisco, Sofia** or **Carnation**. 
Retrieve **town_id, town_name, address_text**. Order the result by **town_id**, then by **address_id**. 

### Example 

| **town_id** | **town_name** | **address_text** | 
| --- | --- | --- | 
| 9	 | San Fransisco | 1234 Seaside Way |
| 9	 | San Fransisco | 5725 Glaze Drive |
| 15 | Carnation     | 1411 Ranch Drive |
| …	 | …	           | …                |

# 3. Employees Without Managers

Write a query to get information about **employee_id, first_name, last_name, department_id** and **salary** for all employees who **don't have** a manager. 

### Example 

| **employee_id** | **first_name** | **last_name** | **department_id** | **salary** | 
| --- | --- | --- | --- | --- |
| 109 |	Ken	    | Sanchez |	16 | 125 500 |
| 291 |	Svetlin | Nakov	  | 6  | 48 000  |
| 292 |	Martin  |	Kulov	  | 6  | 48 000  |
| 293 |	George  |	Denchev	| 6  | 48 000  |

# 4. Higher Salary

Write a query to count the number of employees who receive **salary** higher than the **average**.

### Example 

| **count** | 
| --- |
| 88 |
