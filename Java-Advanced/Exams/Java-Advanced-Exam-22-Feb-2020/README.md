# 1. Loot box

*You are tired of being the only one on your team without cool items, so you decided to buy some loot boxes which have a chance to drop some cool items.*

Every purchase gives you two loot boxes and they are represented as a sequence of integers. First, you will be given **a sequence of integers, representing the first loot box**.
Afterwards, you will be given another **sequence of integers representing the second loot box**.

You need to start from the **first item** in the first box and **sum** it with the last item in the second box. If the **sum** of their values is **an even number**, 
add the **summed** item to **your collection of claimed items** and **remove** them **both** from the boxes. Otherwise, remove the last item from the second box and 
add it at the last position in the first box. You need to **stop** summing items when one of the boxes becomes empty.

If the first loot box becomes empty print:

   **"First lootbox is empty"**

If the second loot box becomes empty print:

   **"Second lootbox is empty"**

In the end you need to determine the quality of your claimed items. If the sum of the claimed items is equal to or greater than 100, print:

   **"Your loot was epic! Value: {sum of claimed items}"**

Else print:

   **"Your loot was poor... Value: {sum of claimed items}"**

### Input

- On the **first line**, you will receive the integers representing the **first loot box, separated** by a **single space**.
- On the **second line**, you will receive the integers representing the **second loot box, separated** by a **single space**.

### Output

- On the **first** line of output - print which box got empty in the format described above.
- On the **second** line - the quality of your loot in the format described above.

### Constraints

- All of the given numbers will be valid integers in the range **[0, 100]**.
- There won't be a case where both loot boxes become empty at the same time.

### Examples

| **Input** | **Output** |
| --- | --- |
| 10 11 8 13 5 6 | Second lootbox is empty         |
| 0 4 7 3 6 23 3 | Your loot was poor... Value: 42 |
| **Input** | **Output** |
| 20 40 60 80 100   | First lootbox is empty         |
| 10 20 30 40 50 60 | Your loot was epic! Value: 500 |

# 2. Re-Volt

You will be given an integer N for the size of the square matrix and then an integer for the count of commands. On the next **n** lines, you will receive the rows of the matrix.
The player starts at a random position (the player is marked with **"f"**) and **all of the empty slots** will be filled with **"-" (dash)**. 
The goal is to reach the finish mark which will be marked with **"F"**. On the field there can also be bonuses and traps. 
Bonuses are marked with **"B"** and traps are marked with **"T"**.

Each turn you will be given commands for **the player's movement.** If the player **goes** **out** of the matrix, he comes in from **the other side**. 
For example, if the player is on 0, 0 and the next command is left, he goes to the last spot on the first row.

If the player steps on a **bonus**, he should move another step forward in the direction he is going. If the player steps on a **trap**, he should move a step backwards.

When the player reaches the **finish mark** or the **count of commands is reached**, the game ends.

### Input

- On the first line, you are given the integer N - the size of the square matrix.
- On the second you are given the count of commands.
- The next N lines hold the values for every row.
- On each of the next lines you will get commands for movement directions.

### Output

- If the player reaches the finish mark, print:

  o **"Player won!"**

- If the player reaches the commands count and hasn't reached the finish mark print:

  o **"Player lost!"**

- In the end print the matrix.

### Constraints

- The size of the matrix will be between **[2...20].**
- The players will always be indicated with **"f"**.
- If the player steps on the finish mark **at the same time** as his last command, he **wins** the game.
- Commands will be in the format **up**, **down**, **left** or **right**.
- There won't be a case where you bypass the finish while you are on a trap or a bonus.
- A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus.

### Examples

| **Input** | **Output** |
| --- | --- |
| 5     | Player won! |
| 5     | -----       |
| ----- | -----       |
| -f--- | -B---       |
| -B--- | --T--       |
| --T-- | -f---       |
| -F--- |
| down  |
| right |
| down  |
| **Input** | **Output** |
| 4    | Player lost! |
| 3    | ----         |      
| ---- | ---B         |
| -f-B | --T-         |
| --T- | f--F         |
| ---F | 
| up   |
| up   |
| left |

# 3. Guild

### Problem description

Your task is to create a repository which stores players by creating the classes described below.

**Player**

First, write a Java class **Player** with the following fields:

- **name: String**
- **clazz: String**
- **rank: String - "Trial" by default**
- **description: String - "n/a" by default**

The class **constructor** should receive **name and clazz**. You need to create the appropriate **getters and setters**. 
Override the **toString()** method in the following format:

**"Player {name}: {clazz}**

**Rank: {rank}**

**Description: {description}"**

### Guild

**Next**, write a Java class **Guild** that has **a roster** (a collection which stores **Player** entities). All entities inside the repository have the **same fields**. 
Also, the **Guild** class should have those **fields**:

- **name: String**
- **capacity: int**

The class **constructor** should receive **name** and **capacity**, also it should initialize the **roster** with a new instance of the collection.
Implement the following features:

- Method **addPlayer(Player player)** - **adds** an **entity** to the roster  **if there is room** for it
- Method **removePlayer(String name)** - removes a player by **given name,** if such **exists**, and **returns boolean**
- Method **promotePlayer(String name)** - **promote** (**set his rank to "Member"**) the **first player** with the **given name**. 
  If the player is **already** a "Member", **do nothing.**
- Method **demotePlayer(String name)** - demote (set his rank to "Trial") **the first player with the given** name. If the player is **already** a "Trial", **do nothing**.
- Method **kickPlayersByClass(String clazz)** - removes all the players by the given class and returns **all removed players** from that **class as an array**
- Method **count()** - **returns** the **number** of players
- Method **report()** - **returns** a **String** in the following **format:**

  o **"Players in the guild: {guildName}:**\
  &nbsp;&nbsp; **{Player~1~}**\
  &nbsp;&nbsp; **{Player~2~}**\
  &nbsp;&nbsp; **(...)**"

### Constraints

- The **names** of the players will be **always unique**.
- You will always have a player added before receiving methods manipulating the Guild's players.

### Examples

This is an example how the **Guild** class is **intended to be used**.

| **Sample code usage** | 
| --- | 
| package guild;                                                                             |
| <br>                                                                                       |
| public class Main {                                                                        |
| &nbsp;&nbsp; public static void main(String[] args) {                                      |
| &nbsp;&nbsp;&nbsp;&nbsp; //Initialize the repository (guild)                               |
| &nbsp;&nbsp;&nbsp;&nbsp; Guild guild = new Guild("Weekend Raiders", 20);                   |
| &nbsp;&nbsp;&nbsp;&nbsp; //Initialize entity                                               |
| &nbsp;&nbsp;&nbsp;&nbsp; Player player = new Player("Mark", "Rogue");                      |
| &nbsp;&nbsp;&nbsp;&nbsp; //Print player                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(player);                                       | 
| &nbsp;&nbsp;&nbsp;&nbsp; //Player Mark: Rogue                                              |
| &nbsp;&nbsp;&nbsp;&nbsp; //Rank: Trial                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; //Description: n/a                                                |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; //Add player                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.addPlayer(player);                                          |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(guild.count()); //1                            |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(guild.removePlayer("Gosho")); //false          |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; Player firstPlayer = new Player("Pep", "Warrior");                |
| &nbsp;&nbsp;&nbsp;&nbsp; Player secondPlayer = new Player("Lizzy", "Priest");              |
| &nbsp;&nbsp;&nbsp;&nbsp; Player thirdPlayer = new Player("Mike", "Rogue");                 |
| &nbsp;&nbsp;&nbsp;&nbsp; Player fourthPlayer = new Player("Marlin", "Mage");               |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; //Add description to player                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; secondPlayer.setDescription("Best healer EU");                    |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; //Add players                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.addPlayer(firstPlayer);                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.addPlayer(secondPlayer);                                    |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.addPlayer(thirdPlayer);                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.addPlayer(fourthPlayer);                                    |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; //Promote player                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp; guild.promotePlayer("Lizzy");                                     |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; //Remove Player                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(guild.removePlayer("Pep")); //true             |
| <br>                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; Player[] kickedPlayers = guild.kickPlayersByClass("Rogue");       |
| &nbsp;&nbsp;&nbsp;&nbsp; for (Player kickedPlayer : kickedPlayers) {                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; System.out.print(kickedPlayer.getName() + " "); |
| &nbsp;&nbsp;&nbsp;&nbsp; }                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp; //Mark Mike                                                       |
| <br>                                                                                       | 
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(guild.report());                               |
| &nbsp;&nbsp;&nbsp;&nbsp; //Players in the guild: Weekend Raiders:                          |
| &nbsp;&nbsp;&nbsp;&nbsp; //Player Lizzy: Priest                                            |
| &nbsp;&nbsp;&nbsp;&nbsp; //Rank: Member                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp; //Description: Best healer EU                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; //Player Marlin: Mage                                             |
| &nbsp;&nbsp;&nbsp;&nbsp; //Rank: Trial                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; //Description: n/a                                                |
| &nbsp;&nbsp; }                                                                             |
| }                                                                                          |
