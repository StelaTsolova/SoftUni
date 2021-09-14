# 1.	Count Chars in a String

Write a program, which **counts all characters** in a string **except space (' ')**.

**Print all occurrences in the following format:**

**{char} -> {occurrences}**

### Examples

| **Input** | **Output** | 
| --- | --- |
| text | t -> 2 |
|      | e -> 1 |
|      | x -> 1 |
| **Input** | **Output** | 
| text text text | t -> 6 |
|                | e -> 3 |
|                | x -> 3 |

# 2.	A Miner Task

Until you receive **"stop"** command, you will be given a sequence of strings, each on a new line. Every **odd** line on the console is representing 
a **resource** (e.g. Gold, Silver, Copper, etc.) and every **even** - **quantity**. Your task is to collect the resources and print them each on a new line.

**Print the resources and their quantities in format: {resource} -> {quantity}**

The quantities inputs will be in the range **[1 ... 2 000 000 000]**

### Examples

| **Input** | **Output** | | **Input** | **Output** | 
| --- | --- | --- | --- | --- |
| Gold   | Gold -> 155  | | gold   | gold -> 170  |
| 155    | Silver -> 10 | | 155    | silver -> 10 |
| Silver | Copper -> 17 | | silver | copper -> 17 |
| 10     |              | | 10     |
| Copper |              | | copper |
| 17     |              | | 17     |
| stop   |              | | gold   |
|        |              | | 15     |
|        |              | | stop   |

# 3.	Legendary Farming

*You've beaten all the content and the last thing left to accomplish is own a legendary item. However, it's a tedious process and requires quite a bit of farming.*

Anyway, you are not too pretentious - any legendary will do. The possible items are:

- **Shadowmourne** - requires **250 Shards**
- **Valanyr** - requires **250 Fragments**
- **Dragonwrath** - requires **250 Motes**

**Shards, Fragments** and **Motes** are the **key materials**, all else is **junk.** You will be given lines of input, such as\
**"2 motes 3 ores 15 stones".** Keep track of the **key materials -** the **first** that reaches the **250 mark** **wins** the **race**. At that point, 
print the corresponding legendary obtained. Then, print the **remaining** shards, fragments, motes, ordered by **quantity** in **descending** order, 
then by **name** in **ascending** order, each on a new line. Finally, print the collected **junk** items, in **alphabetical** order.

### Input

- Each line of input is in format **{quantity} {material} {quantity} {material} ... {quantity} {material}**

### Output

- On the first line, print the obtained item in format **{Legendary item} obtained!**
- On the next three lines, print the remaining key materials in descending order by quantity

   o If two key materials have the same quantity, print them in alphabetical order
- On the final several lines, print the junk items in alphabetical order

   o All materials are printed in format **{material}: {quantity}**
   
   o All output should be **lowercase**, except the first letter of the legendary

### Examples

| **Input** | **Output** | 
| --- | --- | 
| 3 Motes 5 stones 5 Shards         | Valanyr obtained! |
| 6 leathers 255 fragments 7 Shards | fragments: 5      |
|                                   | shards: 5         |
|                                   | motes: 3          |
|                                   | leathers: 6       |
|                                   | stones: 5         |
| **Input** | **Output** | 
| 123 silver 6 shards 8 shards 5 motes | Dragonwrath obtained! |
|  9 fangs 75 motes 103 MOTES 8 Shards | shards: 22            |
|  86 Motes 7 stones 19 silver         | motes: 19             |
|                                      | fragments: 0          |
|                                      | fangs: 9              |
|                                      | silver: 123           |

# 4.	Orders

Write a program, which keeps information about **products** and their **prices**. Each product has a **name**, a **price** and its **quantity**. 
If the product **doesn't exist** yet, **add** it with its **starting quantity**.

If you receive a product, which **already exists,** **increase** its quantity by the input quantity and if its **price is different**, **replace** the price as well.

You will receive products' **names**, **prices** and **quantities** on **new lines**.Until you receive the command "**buy**", keep adding items. 
When you do receive the command "**buy**", print the items with their **names** and **total price** of all the products with that name.

### Input

-   Until you receive "**buy**", the products come in the format: "**{name} {price} {quantity}**"
-   The product data is **always** delimited by a **single space**

### Output

-   Print information about **each** **product**, following the format:\
    "**{productName} -> {totalPrice}**"
- **Format** the average grade to the **2^nd^ decimal place**

### Examples

| **Input** | **Output** | 
| --- | --- |
| Beer 2.20 100    | Beer -> 220.00     |
| IceTea 1.50 50   | IceTea -> 75.00    |
| NukaCola 3.30 80 | NukaCola -> 264.00 |
| Water 1.00 500   | Water -> 500.00    |
| buy              |                    |
| **Input** | **Output** | 
| Beer 2.40 350   | Beer -> 660.00  |
| Water 1.25 200  | Water -> 250.00  |
| IceTea 5.20 100 | IceTea -> 110.00 |
| Beer 1.20 200   | 
| IceTea 0.50 120 |
| buy             |
| **Input** | **Output** | 
| CesarSalad 10.20 25  | CesarSalad -> 255.00  |
| SuperEnergy 0.80 400 | SuperEnergy -> 320.00 |
| Beer 1.35 350        | Beer -> 472.50        |
| IceCream 1.50 25     | IceCream -> 37.50     |
| buy                  |

# 5.	SoftUni Parking

*SoftUni just got a new **parking lot**. It's so fancy, it even has online **parking validation**. Except, the online service doesn't work. It can only receive users' data, 
but doesn't know what to do with it. Good thing you're on the dev team and know how to fix it, right?*

Write a program, which validates parking for an online service. Users can **register** to park and **unregister** to leave.

The program **receives 2 commands**:

- "register {username} {licensePlateNumber}":
   
   o The system only supports **one car per user** at the moment, so if a user tries to register **another license plate**, using the **same username**, 
the system should print:\
"ERROR: already registered with plate number {licensePlateNumber}"

   o If the aforementioned checks pass successfully, the plate can be registered, so the\
system should print:\
 "**{username} registered {licensePlateNumber} successfully**"

- "unregister {username}":
   
   o If the user is **not present** in the database, the system should print:\
"ERROR: user {username} not found"

   o If the aforementioned check passes successfully, the system should print:\
"{username} unregistered successfully"

After you execute all of the commands, **print** all the currently **registered users** and their **license plates** in the format:

-   "**{username} => {licensePlateNumber}**"

### Input

- First line: **n** - **number of commands** - **integer**
- Next **n** lines: **commands** in one of **two** possible formats:

   o Register: "register {username} {licensePlateNumber}"

   o Unregister: "unregister {username}"

The input will **always** be **valid** and you **do not need** to check it explicitly.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 5                        | John registered CS1234JS successfully   |
| register John CS1234JS   | George registered JAVA123S successfully |
| register George JAVA123S | Andy registered AB4142CD successfully   |
| register Andy AB4142CD   | Jesica registered VR1223EE successfully |
| register Jesica VR1223EE | Andy unregistered successfully          |
| unregister Andy          | John => CS1234JS                        |
|                          | George => JAVA123S                      |
|                          | Jesica => VR1223EE                      |
| **Input** | **Output** | 
| 4                       | Jony registered AA4132BB successfully                |
| register Jony AA4132BB  | ERROR: already registered with plate number AA4132BB |
| register Jony AA4132BB  | Linda registered AA9999BB successfully               |
| register Linda AA9999BB | Jony unregistered successfully                       |
| unregister Jony         | Linda => AA9999BB                                    |
| **Input** | **Output** |
| 6                          | Jacob registered MM1111XX successfully    |
| register Jacob MM1111XX    | Anthony registered AB1111XX successfully  |
| register Anthony AB1111XX  | Jacob unregistered successfully           |
| unregister Jacob           | Joshua registered DD1111XX successfully   |
| register Joshua DD1111XX   | ERROR: user Lily not found                |
| unregister Lily            | Samantha registered AA9999BB successfully |
| register Samantha AA9999BB | Anthony => AB1111XX                       |
|                            | Joshua => DD1111XX                        |
|                            | Samantha => AA9999BB                      |

# 6.	Courses

Write a program, which keeps information about **courses**. Each course has a **name** and **registered students**.

You will receive **course** **name** and **student** **name,** until you receive the command "**end**". **Check if such course already exists, and if not - add the course.** 
Register the user into the course. When you do receive the command "**end**", print the courses with their **names** and **total registered users**, 
ordered by the count of registered users in **descending** order. For each contest print registered users ordered by name in **ascending** order.

### Input

-   Until you receive "**end**", the input come in the format: "**{courseName} : {studentName}**"
-   The product data is **always** delimited by " : "

### Output

-   Print information about **each** **course**, following the format:\
    **"{courseName}: {registeredStudents}"**
-   Print information about each student, following the format:\
    **"-- {studentName}"**

### Examples

| **Input** | **Output** | 
| --- | --- |
| Programming Fundamentals : John Smith    | Programming Fundamentals: 2 |
| Programming Fundamentals : Linda Johnson | -- John Smith               |
| JS Core : Will Wilson                    | -- Linda Johnson            |
| Java Advanced : Harrison White           | JS Core: 1                  |
| end                                      | -- Will Wilson              |
|                                          | Java Advanced: 1            |
|                                          | -- Harrison White           |
| **Input** | **Output** | 
| Algorithms : Jay Moore                | Python Fundamentals: 3 |
| Programming Basics : Martin Taylor    | -- Andrew Robinson     |
| Python Fundamentals : John Anderson   | -- Clark Lewis         |
| Python Fundamentals : Andrew Robinson | -- John Anderson       |
| Algorithms : Bob Jackson              | Algorithms: 2          |
| Python Fundamentals : Clark Lewis     | -- Bob Jackson         |
| end                                   | -- Jay Moore           |
|                                       | Programming Basics: 1  |
|                                       | -- Martin Taylor       |

# 7.	Student Academy

Write a program, which keeps information about **students** and **their grades**.

On the first line you will receive number **n**. After that you will receive **n pair of rows**. First you will receive the **student's name**, after that you will receive his grade. 
**Check if student already exists, and if not - add him**. Keep track of all grades for each student.

When you finish reading data, keep students with **average grade higher or equal to 4.50**. Order filtered students by **average grade in descending order**.

**Print the students and their average grade in format:**

**"{name} -> {averageGrade}"**

**Format** the average grade to the **2^nd^ decimal place**.

### Examples

| **Input** | **Output** | | **Input** | **Output** | 
| --- | --- | --- | --- | --- |
| 5      | John -> 5.00   |  | 5         | Robert -> 6.00    |
| John   | George -> 5.00 |  | Amanda    | Rob -> 5.50       |
| 5.5    | Alice -> 4.50  |  | 3.5       | Christian -> 5.00 |
| John   |                |  | Amanda    |
| 4.5    |                |  | 4         |
| Alice  |                |  | Rob       |
| 6      |                |  | 5.5       |
| Alice  |                |  | Christian |
| 3      |                |  | 5         |
| George |                |  | Robert    |
| 5      |                |  | 6         |

# 8.	Company Users

Write a program which keeps information about companies and their employees.

You will receive **company** **name** and **employee's id,** until you receive the command "**End**". Add each employee to the given company. Keep in mind that 
a company **cannot** have two employees with the same id.

When you finish reading data, **order the companies by the name in ascending order**.

Print the company name and each employee's id in the following format:

**{companyName}**

**-- {id1}**

**-- {id2}**

**-- {idN}**

### Input / Constraints

-   Until you receive "**End**", the input come in the format: "**{companyName} -> {employeeId}**"
-   The input **always** will be valid

### Examples

| **Input** | **Output** | 
| --- | --- |
| SoftUni -> AA12345   | HP         |
| SoftUni -> BB12345   | -- BB12345 |
| Microsoft -> CC12345 | Microsoft  |
| HP -> BB12345        | -- CC12345 |
| End                  | SoftUni    |
|                      | -- AA12345 |
|                      | -- BB12345 |
| **Input** | **Output** |
| SoftUni -> AA12345  | Lenovo     |
| SoftUni -> CC12344  | -- XX23456 |
| Lenovo -> XX23456   | Movement   |
| SoftUni -> AA12345  | -- DD11111 |
| Movement -> DD11111 | SoftUni    |
| End                 | -- AA12345 |
|                     | -- CC12344 |

# 9.	*ForceBook

You should store information for every **unique forceUser**, registered in the application.

You will receive **several input lines** in one of the following formats:

**{forceSide} | {forceUser}**
**{forceUser} -> {forceSide}**

The forceUser and forceSide are strings, containing **any** character.

If you receive **forceSide** **| forceUser** you should **check if such forceUser already exists**, and **if not** - **add** him/her to the corresponding side.

If you receive a **forceUser -> forceSide** you should check if there is such **forceUser** already and if so, **change his/her side**. If there is no such **forceUser**, 
add him/her to the corresponding **forceSide**, treating the command **as new registered forceUser.**\
**Then you should print on the console: "{forceUser} joins the {forceSide} side!"**

You should end your program when you receive the command **"Lumpawaroo"**. At that point you should print each force side, **ordered descending by forceUsers count, 
than ordered by name**. For each side print the **forceUsers**, **ordered by name**.

In case there are **no forceUsers in a side**, you **shouldn't print** the side information.

### Input / Constraints

- The input comes in the form of commands in one of the formats specified above
- The input ends when you receive the command **"Lumpawaroo"**

### Output

- As output for each forceSide, **ordered descending by forceUsers count**, **then by name**, you must print all the forceUsers, **ordered by name alphabetically**
- The output format is:

**Side: {forceSide}, Members: {forceUsers.Count}**
**! {forceUser}**
**! {forceUser}**
**! {forceUser}**

- In case there are **NO** forceUsers, don't print this side

### Examples

| **Input** | **Output** | 
| --- | --- |
| Light | George | Side: Dark, Members: 1  |
| Dark | Peter   | ! Peter                 |
| Lumpawaroo     | Side: Light, Members: 1 |
|                | ! George                |
| **Input** | **Output** | 
| Lighter | Royal        | Sam Johnson joins the Lighter side! |
| Darker | DCay          | DCay joins the Lighter side!        |
| Sam Johnson -> Lighter | Side: Lighter, Members: 3           |
| DCay -> Lighter        | ! Dcay                              |
| Lumpawaroo             | ! Royal                             |
|                        | ! Sam Johnson                       |  

# 10.	*SoftUni Exam Results

Judge statistics on the last Programing Fundamentals exam was not working correctly, so you have the task to take all the submissions and analyze them properly. 
You should collect all the submission and print the final results and statistics about each language that the participants submitted their solutions in.

You will be receiving lines in the following format: **"{username}-{language}-{points}"** until you receive **"exam finished"**.
You should store each username and his submissions and points.
You can receive a **command to ban** a user for cheating in the following format: **"{username}-banned"**. In that case, you should **remove** the user from the contest, 
but **preserve his submissions in the total count of submissions for each language**.

After receiving **"exam finished"**, print each of the participants, ordered **descending** by their max points, then by username, in the following format:

**Results:**

**{username} | {points}**

**...**

After that print each language, used in the exam, ordered **descending** by total submission count and then by language name, in the following format:

**Submissions:**

**{language} - {submissionsCount}**

**...**

### Input / Constraints

Until you receive **"exam finished"**, you will be receiving participant submissions in the following format: **"{username}-{language}-{points}"**

You can receive a ban command -> **"{username}-banned"**

The points of the participant will always be a **valid integer in the range [0-100]**

### Output

- Print the exam results for each participant, ordered descending by max points and then by username, in the following format:

**Results:**

**{username} | {points}**

**...**

- After that print each language, ordered descending by total submissions and then by language name, in the following format:

**Submissions:**

**{language} - {submissionsCount}**

**...**

- Allowed working **time**/**memory**: **100ms**/**16MB**

### Examples

| **Input** | **Output** | 
| --- | --- |
| Peter-Java-84 | Results:     |  
| George-C#-70  | Kiril | 94   |
| George-C#-84  | George | 84  |
| Kiril-C#-94   | George | 84  |
| exam finished | Submissions: |
|               | C# - 3       |
|               | Java - 1     |
| **Input** | **Output** |
| Peter-Java-91 | Results:     |
| George-C#-84  | Peter | 91   |
| Kiril-Java-90 | George | 84  |
| Kiril-C#-50   | Submissions: |
| Kiril-banned  | C# - 2       |
| exam finished | Java - 2     |
