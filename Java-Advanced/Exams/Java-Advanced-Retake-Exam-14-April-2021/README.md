# 1. Bouquets

*You want to go on a bouquets competition but to participate you have to make at least 5* *bouquets.*

You will be given **two sequences of integers, representing daffodils and tulips.** You need to start making bouquets **knowing that one bouquets needs 15 flowers**. 
Your goal is to make **at least 5 bouquets.**

You will start crafting from the **last tulips** and the **first daffodils**. If the **sum** of their values is **equal** to **15** - **create one bouquet** and **remove** them.
While the sum is **bigger than 15**, keep **decreasing** the value of the **tulips by 2**. If the sum **is less than 15 you have to store them for later and remove them**. 
You need to **stop** combining when you have **no more daffodils or tulips**. In the end, if you have **any stored flowers you should make as many bouquets as you can with them.**

### Input

- On the **first line**, you will receive the integers representing the **tulips**, **separated** by **", "**.
- On the **second line**, you will receive the integers representing the **daffodils**, **separated** by "**,**".

### Output

- Print whether you have succeeded making **at least 5** **bouquets**:

  o **"You made it! You go to the competition with {count of bouquets} bouquets!"**

  o **"You failed... You need more {number} bouquets."**

### Constraints

- All of the given numbers will be valid integers in the range **[0, 120]**.
- Don't have situation with negative number.

### Examples

| **Input** | **Output** |
| --- | --- |
| 10, 15, 2, 7, 9, 13 | You made it! You go to the competition with 5 bouquets! |
| 2, 10, 8, 12, 0, 5  |
| **Input** | **Output** |
| 10, 5, 3, 7, 8 | You failed... You need more 1 bouquets. |
| 5, 10, 8, 7, 6 |

# 2. Cooking journey

*You successfully started your cooking journey, so now you need to sell the products from your basket in the pastry shop* *in order to collect your price.*

You will be given an integer **n** for the **size** of the pastry shop with **square** shape. On the next **n** lines, you will receive the **rows** of the pastry shop. 
You will be placed on a **random position**, marked with the letter '**S**'. On random positions there will be clients, marked with a **single digit**. 
There **may** also be **pillars**. Their **count** will be either **0** or **2** and they are **marked** with the **letter** - '**P**'. 
**All of the empty positions** will be marked with **'-'**.

Each turn, you will be given **commands** for the **your movement**. Move commands will be: "**up**", "**down**", "**left**", "**right**". If you **move** to a **client**, 
you **collects the price equal** to the **digit there** and the client **disappears**. If you move to a **pillar**, you move on the **position** of the **other pillar** and 
then **both** pillars **disappear**. If you **go out** of the pastry shop, you **disappear** from the pastry shop and you are out of there. 
You need **at least 50 dollars** to rent your own Pastry shop.

When **you are out of the pastry shop or you collect enough money,** the program **ends**.

### Input

- On the first line, you are given the integer **n** - the size of the **square** matrix.
- The **next n lines** holds the values for every **row**.
- On each of the next lines you will get a move command.

### Output

- On the first line:

  o If the player goes to the void, print: "**Bad news! You are out of the pastry shop.**"

  o If the player collects enough star power, print: "**Good news! You succeeded in collecting enough money!**"

- On the second line print all star power collected: "**Money: {money}**"
- In the end print the matrix.

### Constraints

- The size of the **square** matrix will be between **[2...10].**
- There will **always** be **0** or **2** pillars, marked with the **letter** - '**P**'.
- Your position will be marked with '**S**'.
- You will **always** go out of the pastry shop or collect enough money.

### Examples

| **Input** | **Output** |
| --- | --- |
| 5     | Bad news, you are out of the pastry shop. |
| SP--- | Money: 0                                  |
| ----- | -----                                     |
| ----- | -----                                     |
| ----- | -----                                     |
| ----P | -----                                     |
| right | -----                                     |
| right |
| **Input** | **Output** |
| 6      | Good news! You succeeded in collecting enough money! |
| S98--- | Money: 53                                            |
| 99---- | ------                                               |
| 666666 | ------                                               |
| ------ | --S666                                               |
| --77-- | ------                                               |
| -6-6-6 | --77--                                               |
| right  | -6-6-6                                               |
| right  |
| down   |
| left   |
| left   |
| down   |
| right  |
| right  |

# 3. University

**Problem Description**

Your task is to create a repository which stores departments by creating the classes described below.

### Student

First, write a Java class Student with the following **public** fields:

- **firstName: String**
- **lastName: String**
- **bestSubject: String**

The class **constructor** should receive (**firstName, lastName** and **bestSubject**).

The class also should have the methods:

- **getFirstName()**
- **getLastName()**
- **getBestSubject()**
- Override the **toString()** method in the following format:

**"Student: {firstName} {lastName}, {bestSubject}"**

### University

**Next**, write a **Java** class University that has **students** (a collection which stores the entity **Student**). All entities inside the repository have 
the **same public fields**. Also, the University class should have those fields:

- **capacity:** int
- **students: List<Student\>** - holds all added students in the university

The class **constructor** should receive (**capacity**), also it should initialize the **students** with a new instance of the collection.

Implement the following features:

- **getCapacity()**
- **getStudents()**
- getStudentCount() method - **returns** the **number** of **students in the university**
- registerStudent(Student student) method - **adds** an **entity** to the students **if there is room** for it

  o Returns **"Added student {firstName} {lastName}"** if the student is **successfully added**

  o Returns **"Student is already in the university"** if the student is already in the university

  o Returns **"No seats in the university"** if the university is full

- dismissStudent(Student student) method - **removes the student**

  o Returns **"Student not found" if the student is not in the university**

- **getStudent(String firstName, String lastName)** method **-** returns the student with the **given names**.
- **getStatistics() - returns** a **String** in the following **format**:

  o **"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subjec = {bestSubject}**\
   &nbsp;&nbsp; **==Student: First Name = {firstName}, Last Name= {lastName}, Best Subject = {bestSubject}**

   &nbsp;&nbsp;&nbsp; **(...)**"

### Constraints

- The **combinations** of **names** will **always be unique**.
- The **capacity** will always be **a positive** **number**.

### Examples

This is an example how the **University** class is **intended to be used**.

| **Sample code usage** |
| --- |
| // Initialize the repository                                                   |
| &nbsp;&nbsp; University university = new University(10);                       |
| // Initialize entities                                                         |
| &nbsp;&nbsp; Student student = new Student("John", "Smith", "Astrology");      |
| &nbsp;&nbsp; Student studentTwo = new Student("Anna", "Cameron", "Geometry");  |
| &nbsp;&nbsp; Student studentThree = new Student("Samy", "Johnson", "Algebra"); |
| &nbsp;&nbsp; Student studentFour = new Student("Rihanna", "Fenty", "Music");   |
| &nbsp;&nbsp; Student studentFive = new Student("Ellie", "Goulding", "Music");  |
| // Print Student                                                               |
| &nbsp;&nbsp; System.out.println(student);                                      |
| // Student: John Smith, Astrology                                              |
| // Register Student                                                            |
| &nbsp;&nbsp; String register = university.registerStudent(student);            |
| &nbsp;&nbsp; System.out.println(university.getCapacity()); // 10               |
| &nbsp;&nbsp; System.out.println(register); // Added student John Smith         |
| &nbsp;&nbsp; String registerTwo = university.registerStudent(studentTwo);      |
| &nbsp;&nbsp; String registerThree = university.registerStudent(studentThree);  |
| &nbsp;&nbsp; String registerFour = university.registerStudent(studentFour);    |
| // Dismiss Student                                                             |
| &nbsp;&nbsp; String dismissed = university.dismissStudent(student);            |
| &nbsp;&nbsp; System.out.println(dismissed); // Removed student John Smith      |
| &nbsp;&nbsp; String dismissedTwo = university.dismissStudent(studentFive);     |
| &nbsp;&nbsp; System.out.println(dismissedTwo); // Student not found            |
| // Get Student                                                                 |
| &nbsp;&nbsp; System.out.println(university.getStudent("Rihanna", "Fenty"));    |
| // Student: Rihanna Fenty, Music                                               |
| &nbsp;&nbsp; System.out.println(university.getStudentCount()); // 3            |
| &nbsp;&nbsp; System.out.println(university.getStatistics());                   |
| //==Student: First Name = Anna, Last Name = Cameron, Best Subject = Geometry   |
| //==Student: First Name = Samy, Last Name = Johnson, Best Subject = Algebra    |
| //==Student: First Name = Rihanna, Last Name = Fenty, Best Subject = Music     |
