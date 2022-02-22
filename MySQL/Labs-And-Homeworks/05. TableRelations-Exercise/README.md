# 1. One-To-One Relationship

Create two tables as follows. Use appropriate data types.

|  | **people** |  |  |                                           | **passports** | |
| --- | --- | --- | --- | --- | --- | --- |
| **person_id** | **first_name** | **salary** | **passport_id** | | **passport_id** | **passport_number** |
| 1             | Roberto        | 43300.00   | 102             | | 101             | N34FG21B            |
| 2             |	Tom            | 56100.00   | 103             | | 102             | K65LO4R7            |
| 3             |	Yana	         | 60200.00   | 101             | | 103             | ZE657QP2            |

**Insert the data from the example above.**

- Alter table **people** and make **person_id** a **primary key**.
- Create a foreign key between **people** and **passports** by using the passport_id column.
- Think about which passport field should be **UNIQUE**.
- Format salary to **second** digit after decimal point.

# 2. One-To-Many Relationship

Create two tables as follows. Use appropriate data types.

|  | **people** |  |                                    | | **models** | |                                        
| --- | --- | --- | --- | --- | --- | --- |
| **manufacturer_id** |	**name** | **established_on** | | **model** | **name** | **manufacturer_id** |
| 1                   |	BMW      | 01/03/1916         | | 101       | X1       | 1                   |
| 2                   |	Tesla    | 01/01/2003         | | 102       | i6       | 1                   |
| 3                   |	Lada	   | 01/05/1966         | | 103       | Model S  | 2                   |
|                     |          |                    | | 104	      | Model X  | 2                   |
|                     |          |                    | | 105	      | Model 3  | 2                   |
|                     |          |                    | | 106	      | Nova     | 3                   |

**Insert the data from the example above.**

- Add primary and foreign keys.

| **people** |  |                                
| --- | --- | 
| **student_id** | **name** |
| 1              | Mila     |                                    
| 2	             | Toni     |
| 3	             | Ron      |


# 3.	Many-To-Many Relationship

Create three tables as follows. Use appropriate data types.

| **exams** |  |                                    | **students_exams** | |                                        
| --- | --- | --- | --- | --- |
| **exam_id** | **name** | | **student_id** | **exam_id** |
| 101	| Spring MVC |                                 | 1 | 101 |
| 102	| Neo4j      |                                 | 1 | 102 |
| 103	| Oracle 11g |                                 | 2 | 101 |
|     |            |                                 | 3 | 103 |
|     |            |                                 | 2 | 102 |
|     |            |                                 | 2 | 103 |

**Insert the data from the example above.**

- Add primary and foreign keys.
- Have in mind that the table **student_exams** should have a **composite** primary key.

# 4.	Self-Referencing

Create a single table as follows. Use appropriate data types.

|  | **teachers** |  |                                           
| --- | --- | --- | 
| **teacher_id** | **name** | **manager_id** |
| 101 |	John   |	   |
| 102 |	Maya   | 106 |
| 103 |	Silvia | 106 |
| 104 |	Ted    | 105 |
| 105 |	Mark	 | 101 |
| 106 |	Greta	 | 101 |

**Insert the data from the example above**.

- Add primary and foreign keys.
- The foreign key should be between **manager_id** and **teacher_id**.

# 5. Online Store Database

Create a new database and design the following structure:

![image](https://user-images.githubusercontent.com/87463484/155165130-5b2160d7-0d50-4838-bbb1-ed7621dc8a6f.png)

# 6. University Database

Create a new database and design the following structure: 

![image](https://user-images.githubusercontent.com/87463484/155165258-3729f310-51b9-4fc4-955c-8f9048d461f5.png)

# 7. SoftUni Design

Create an E/R Diagram of the SoftUni Database. There are some special relations you should check out: **employees** are **self-referenced (manager_id)** and 
**departments** have **One-to-One** with the **employees (manager_id)** while the **employees** have **One-to-Many (department_id**). 
You might find it interesting how it looks on а diagram.

# 8. Geography Design

Create an E/R Diagram of the Geography Database.

# 9.	Peaks in Rila

Display all peaks for **"Rila" mountain_range**. Include:

- **mountain_range**
- **peak_name**
- **peak_elevation**

Peaks should be sorted by **peak_elevation** descending.

### Examaple

| **mountain_range** | **peak_name** | **peak_elevation** |
| --- | --- | --- | 
| Rila | Musala	| 2925 |
| …    | …      | …    |
