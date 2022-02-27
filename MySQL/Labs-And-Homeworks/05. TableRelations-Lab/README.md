# 1.  Mountains and Peaks

Write a query to create two tables - **mountains** and **peaks** and **link their fields** properly. Tables should have:

\-  Mountains:

- **id**
- **name**

\-  Peaks:

- **id**
- **name**
- **mountain_id**

Check your solutions using the "**Run Queries and Check DB**" strategy.

# 2.  Trip Organization

Write a query to retrieve information about SoftUni camp's transportation organization. Get information about the drivers (**name** and **id**) and their **vehicle type**. 

### Example

| **driver_id** | **people** | **driver_name** |                                      
| --- | --- | --- |
| 1 |	bus |	Simo Sheytanov |
| 2 |	van |	Roli Dimitrova |
| 1 |	van |	Simo Sheytanov |
| … |	…   |	…              |

# 3. SoftUni Hiking

Get information about the hiking **routes** - **starting point** and **ending point**, and their **leaders** - **name** and **id**. 

### Example

| **route_starting_point** | **route_ending_point** | **leader_id** | **leader_name** |                                    
| --- | --- | --- | --- |
| Hotel Malyovitsa | Malyovitsa Peak | 3 | RoYaL Yonkov |
| Hotel Malyovitsa | Malyovitsa Hut	 | 3 | RoYaL Yonkov |
| Ribni Ezera Hut	 | Rila Monastery  | 3 | RoYaL Yonkov |
| Borovets         | Musala Peak     | 4 | Ivan Ivanov  |

# 4. Delete Mountains

Drop tables from the task 1.

Write a query to create a one-to-many relationship between a table, holding information about mountains (id, name) and other - about peaks (id, name, mountain_id), 
so that when a mountain gets removed from the database, all his peaks are deleted too.

# 5.  Project Management DB*

Write a query to create a project management db according to the following E/R Diagram:

![image](https://user-images.githubusercontent.com/87463484/155898829-33b7b304-c550-480f-8d3d-0596d87d1504.png)
