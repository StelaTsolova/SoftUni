# 1. Pastry shop

*You are asked to cook pastries and cakes for the near pastry shop, because your recipes are so great. You need to mix liquids with ingredients to cook the required delicacies.*

First, you will be given **a sequence of integers, representing liquids**. Afterwards, you will be given another **sequence of integers representing ingredients**.

You need to start from the **first liquid** and try to mix it with the **last ingredient.** If the **sum** of their values is **equal** to **any of the items** 
**in the table below** - **cook the food corresponding** to the **value** and **remove** **both** the **liquid** and the **ingredient**. Otherwise, **remove only the liquid** and 
**increase** the **value** of the **ingredient by 3**. You need to **stop** combining when you have **no more liquids** or **ingredients**.

| **Food** | **Value needed** | 
| --- | --- |
| Biscuit | 25  |
| Cake    | 50  |
| Pastry  | 75  |
| Pie     | 100 |

### Input

- On the **first line**, you will receive the integers representing the **liquids**, **separated** by a **single space**.
- On the **second line**, you will receive the integers representing the **ingredients**, **separated** by a **single space**.


### Output

- On the **first** line of output print one of the following ouputs:

  o "**Great! You succeeded in cooking all the food!**" -if you have at least

**one of each** of the **foods**, after completing combining.

  o "**What a pity! You didn't have enough materials to cook everything.**" - if you **did not** collect  **one of each** of the **foods**, after completing combining.

- On the **second** line - print all liquids you have left:

  o If there are no liquids: "**Liquids left: none**"

  o If there are liquids: "**Liquids left: {liquid1}, {liquid2}, {liquid3}, (...)**"

- On the **third** line - print all physical materials you have left:

  o If there are no items: "**Ingredients left: none**"

  o If there are items: "**Ingredients left: {ingredient}, {ingredient}, {ingredient}, (...)"**

- Then, you need to print **all** AdvancedMaterials and the **amount you have of them**, ordered:

  o **"Biscuit: {amount}"**

  o **"Cake: {amount}"**

  o **"Pie: {amount}"**

  o **"Pastry: {amount}"**
  
### Constraints

- All of the given numbers will be valid integers in the range **[0, 100]**.
- Advanced materials **can be** crafted more than once.
 
### Examples

| **Input** | **Output** | 
| --- | --- |
| 1 25 50 50  | Great! You succeeded in cooking all the food! |
| 50 25 25 24 | Liquids left: none                            |
|             | Ingredients left: none                        |
|             | Biscuit: 1                                    |
|             | Cake: 1                                       |
|             | Pie: 1                                        |
|             | Pastry: 1                                     |
| **Input** | **Output** | 
| 10 20 30 40 50 | What a pity! You didn't have enough materials to cook everything. |
| 50 40 30 30 15 | Liquids left: none                                                |
|                | Ingredients left: 39, 40, 50                                      |
|                | Biscuit: 1                                                        |
|                | Cake: 1                                                           |
|                | Pie: 0                                                            |
|                | Pastry: 0                                                         |

# 2. Formula One

You will be given an integer N for the size of the square matrix and then an integer for the count of commands. On the next **n** lines, you will receive the rows of the matrix. 
The player starts at a random position (the player is marked with **"P"**) and **all of the empty slots** will be filled with **"." (dot)**. 
The goal is to reach the finish mark which will be marked with **"F"**. On the field there can also be bonuses and traps. 
Bonuses are marked with **"B"** and traps are marked with **"T"**.

Each turn you will be given commands for **the player's movement.** If the player **goes out** of the matrix, he comes in from **the other side**. 
For example, if the player is on 0, 0 and the next command is left, he goes to the last spot on the first row.

If the player steps on a **bonus**, he should move another step forward in the direction he is going. If the player steps on a **trap**, he should move a step backwards.

When the player reaches the **finish mark** or the **count of commands is reached,** the game ends.

### Input

- On the first line, you are given the integer N - the size of the square matrix.
- On the second you are given the count of commands.
- The next N lines hold the values for every row.
- On each of the next lines you will get commands for movement directions.

### Output

- If the player reaches the finish mark, print:

  o **"Well done, the player won first place!"**

- If the player reaches the commands count and hasn't reached the finish mark print:

  o **"Oh no, the player got lost on the track!"**

- In the end print the matrix.

### Constraints

- The size of the matrix will be between **[2...20].**
- The players will always be indicated with **"P"**.
- If the player steps on the finish mark **at the same time** as his last command, he **wins** the game.
- When the final matrix is printed and the vehicle has completed successfully, you must replace the "F" with the "P".
- Commands will be in the format **up**, **down**, **left** or **right**.
- There won't be a case where you bypass the finish while you are on a trap or a bonus.
- A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 5     | Well done, the player won first place! |
| 3     | .....                                  |
| ..... | .....                                  |
| .P... | .B...                                  |
| .B... | ..T..                                  |
| ..T.. | .P...                                  |
| .F... |
| down  |
| right |
| down  |
| **Input** | **Output** |   
| 4    | Oh no, the player got lost on the track! |
| 3    | ....                                     |
| .... | ...B                                     |
| .P.B | ..T.                                     |
| ..T. | P..F                                     |
| ...F |
| up   |
| up   |
| left |
 
# 3. Café

*Now that you successfully saved money for your own Café , you need to recruit some employees to work there. You are You should build a system for that.*

### Problem description

Your task is to create a cafe, which stores employees by creating the classes described below.

First, write a Java class **Employee** with the following properties:

- **name: String**
- **age: int**
- **country: String**

The class **constructor** should receive **name**, **age**and**country**and override the **ToString()** method in the following format:

**"Employee: {name}, {age} from {country}"**

**Next**, write a Java class **Cafe** that has **employees** (a collection, which stores the entity **Employee**). 
All entities inside the repository have the **same properties**. Also, the Cafe class should have those properties:

- **name: String**
- **capacity: int**

The class **constructor** should receive **name** and **capacity**, also it should initialize the **employees** with a new instance of the collection.
Implement the following features:

- Field **employees** - **List** that holds added Employees
- Method addEmployee(Employee employee) - **adds** an **entity** to the data **if there is room** for him/her.
- Method removeEmployee(String name) - removes an employee by **given name,** if such **exists**, and **returns bool**.
- Method getOldestEmployee() - returns the **oldest** employee.
- Method **getEmployee(string name)** - returns the employee with the **given name**.
- Getter getCount() - **returns** the **number** of employees.
- **report()** - **returns** a **string** in the following **format**:

  o **"Employees working at Cafe {cafeName}:\
&nbsp;&nbsp; {Employee1}\
&nbsp;&nbsp; {Employee2}\
&nbsp;&nbsp; (...)**"

### Constraints

- The **names** of the employees will be **always unique**.
- The **age** of the employees will always be with **positive values**.
- You will always have an employee added before receiving methods manipulating the Employees.

### Examples

This is an example how the **Cafe** class is **intended to be used**.

| **Sample code usage** | 
| --- |
| //Initialize the repository                                                  |
| Cafe cafe = new Cafe("Costa", 15);                                           |
| //Initialize entity                                                          |
| Employee employee = new Employee("Alexander", 30, "Bulgaria");               |
| //Print Employee                                                             |
| System.out.println(employee); // Employee: Alexander, 30 from Bulgaria       |
| <br>                                                                         |
| //Add Employee                                                               |
| cafe.addEmployee(employee);                                                  |
| <br>                                                                         |
| //Remove Employee                                                            |
| System.out.println(cafe.removeEmployee("Employee")); //false                 |
| <br>                                                                         |
| Employee secondEmployee = new Employee("Sara", 24, "UK");                    |
| Employee thirdEmployee = new Employee("Anna", 22, "Germany");                |
| <br>                                                                         |
| //Add Employee                                                               |
| cafe.addEmployee(secondEmployee);                                            |
| cafe.addEmployee(thirdEmployee);                                             |
| <br>                                                                         |
| Employee oldestEmployee = cafe.getOldestEmployee();                          |
| Employee employeeStephen = cafe.getEmployee("Sara");                         |
| System.out.println(oldestEmployee); // Employee: Alexander, 30 from Bulgaria |
| System.out.println(employeeStephen); //Employee: Sara, 24 from UK            |
| <br>                                                                         |
| System.out.println(cafe.getCount()); // 3                                    |
| System.out.println(cafe.removeEmployee("Anna")); // true                     |
| <br>                                                                         |
| System.out.println(cafe.report());                                           |
| //Employees working at Cafe Costa:                                           |
| //Employee: Alexander, 30 from Bulgaria                                      |
| //Employee: Sara, 24 from UK                                                 |
