# 1. Flower Wreaths

*You want to go on a flowers wreath competition but to participate you have to make at least 5 flower wreaths.*

You will be given **two sequences of integers, representing roses and lilies**. You need to start making wreaths **knowing that one wreath needs 15 flowers**. 
Your goal is to make **at least 5 flower wreaths**.

You will start crafting from the **last lilies** and the **first roses**. If the **sum** of their values is **equal** to **15** - **create one wreath** and **remove** them. 
If the sum is **bigger than 15**, just **decrease** the value of the **lilies by 2**. If the sum is **less than 15 you have to store them for later and remove them**. 
You need to **stop** combining when you have **no more roses or lilies**. In the end, if you have **any stored flowers you should make as many wreaths as you can with them**.

### Input

- On the **first line**, you will receive the integers representing the **lilies**, **separated** by **", "**.
- On the **second line**, you will receive the integers representing the **roses**, **separated** by "**,**".

### Output

- Print whether you have succeeded making **at least 5 wreaths**:

  o **"You made it, you are going to the competition with {count of wreaths} wreaths!"**

  o **"You didn't make it, you need {wreaths needed} wreaths more!"**

### Constraints

- All of the given numbers will be valid integers in the range **[0, 120]**.
- Don't have situation with negative number.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 10, 15, 2, 7, 9, 13 | You made it, you are going to the competition with 5 wreaths! |
| 2, 10, 8, 12, 0, 5  |
| **Input** | **Output** | 
| 10, 5, 3, 7, 8 | You didn't make, you need 1 wreaths more! |
| 5, 10, 8, 7, 6 |

# 2. Bee

You will be given an integer **n** for the **size** of the bee territory with **square** shape. On the next **n** lines, you will receive the **rows** of the territory. 
The bee will be placed on a **random position**, marked with the letter '**B**'. On random positions there will be flowers, marked with **'f'**. 
There may also be а  **bonus** on the territory. There will always be only one bonus. It will be **marked** with the **letter** - '**O**'. 
**All of the empty positions** will be marked with **'.'**.

Each turn, you will be given **command** for the **bee's movement**.

The commands will be: "**up**", "**down**", "**left**", "**right**", "**End**".

If the bee **moves** to a **flower**, it pollinates the flower and increase pollinated flowers with one.

If it goes to a **bonus**, the bee gets a bonus one move forward and then the bonus **disappears**. If the bee **goes out** she can't return back and the program ends. 
If the bee receive "**End**" command the program ends. The bee needs **at least 5 pollinated flowers**.

### Input

- On the first line, you are given the integer **n** - the size of the **square** matrix.
- The **next n lines** holds the values for every **row**.
- On each of the next lines until you receive "**End**" command,  you will receive a move command.

### Output

- On the first line:

  o If the bee goes out of its territory print: **"The bee got lost!"**

- On the second line:

  o  If the bee couldn't pollinated enough flowers print: **"The bee couldn't pollinate the flowers, she needed {needed} flowers more"**

  o If the bee successfully pollinated enough flowers print: **"Great job, the bee manage to pollinate {polinationed flowers} flowers!"**

- In the end print the matrix.

### Constraints

- The size of the **square** matrix will be between **[2...10].**
- There will **always** be **0** or **1** bonus, marked with - '**O**'.
- The bee position will be marked with '**B**'.
- There won't be a case where a bonus moves the bee out of its territory.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 5     | The bee got lost!                                 |
| Bff.. | Great job, the bee manage to pollinate 6 flowers! |
| ..O.. | .....                                             |
| f.f.f | .....                                             |
| ..... | ....f                                             |
| fffff | .....                                             |
| right | ..fff                                             |
| right |
| down  |
| left  |
| left  |
| down  |
| down  |
| right |
| down  |
| **Input** | **Output** | 
| 4     | The bee couldn't pollinate the flowers, she needed 2 flowers more |
| ....  | .B..                                                              |
| .O..  | ....                                                              |
| ff..  | ....                                                              |
| f.B.  | ....                                                              |
| left  |
| left  |
| up    |
| right |
| up    |
| End   |

# 3. Vet Clinic

### Problem description

Your task is to create a repository, which stores items by creating the classes described below.

First, write a Java class **Pet** with the following fields:

- **name: String**
- **age: int**
- **owner: String**

The class **constructor** should receive **name**, **age** and **owner**. You need to create the appropriate **getters and setters**. 
The class should override the **toString()** method in the following format:

**"{name} {age} ({owner})"**

**Next**, write a Java class **Clinic** that has **data** (a collection, which stores the Pets). All entities inside the repository have the **same fields**. 
Also, the **Clinic** class should have those filelds:

- **capacity: int**

The class **constructor** should receive **capacity**, also it should initialize the **data** with a new instance of the collection. Implement the following features:

- Field **data** - **List** that holds added pets
- Method **add(Pet pet)** - **adds** an **entity** to the data **if there is** an **empty cell** for the pet.
- Method **remove(String name)** - removes the pet by **given name**, if such **exists**, and **returns boolean**.
- Method **getPet(String name, String owner)** - returns the pet with the **given name** and **owner**  or **null if no such pet exists**.
- Method **getOldestPet()** - returns the oldest Pet.
- Getter **getCount** - **returns** the **number** of pets.
- **getStatistics()** - **returns** a **String** in the following **format**:

  o **"The clinic has the following patients:**\
&nbsp;&nbsp; **{name} {owner}**\
&nbsp;&nbsp; **{name} {owner}**\
&nbsp;&nbsp; **(...)**"

### Constraints

- The **combinations** of **names** and **owners** will **always be unique**.
- The **age** of the pets will always be **positive**.

### Examples

This is an example of how the **Clinic** class is **intended to be used**.

| **Sample code usage** |  
| --- | 
| // Initialize the repository                         |
| Clinic clinic = new Clinic(20);                      |
| <br>                                                 |
| // Initialize entity                                 |
| Pet dog = new Pet("Ellias", 5, "Tim");               |
| <br>                                                 |
| // Print Pet                                         |
| System.out.println(dog); // Ellias 5 (Tim)           |
| <br>                                                 |
| // Add Pet                                           |
| clinic.add(dog);                                     |
| <br>                                                 |
| // Remove Pet                                        |
| System.out.println(clinic.remove("Ellias")); // true |
| System.out.println(clinic.remove("Pufa")); // false  |
| <br>                                                 |
| Pet cat = new Pet("Bella", 2, "Mia");                |
| Pet bunny = new Pet("Zak", 4, "Jon");                |                  
| <br>                                                 |
| clinic.add(cat);                                     |
| clinic.add(bunny);                                   |
| <br>                                                 |
| // Get Oldest Pet                                    |
| Pet oldestPet = clinic.getOldestPet();               |
| System.out.println(oldestPet); // Zak 4 (Jon)        |
| <br>                                                 |
| // Get Pet                                           |
| Pet pet = clinic.getPet("Bella", "Mia");             |
| System.out.println(pet); // Bella 2 (Mia)            |
| <br>                                                 |
| // Count                                             |
| System.out.println(clinic.getCount()); // 2          |
| <br>                                                 |
| // Get Statistics                                    |
| System.out.println(clinic.getStatistics());          |
| //The clinic has the following patients:             |
| //Bella Mia                                          |
| //Zak Jon                                            |
