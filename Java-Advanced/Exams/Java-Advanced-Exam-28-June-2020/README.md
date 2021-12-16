# 1. Bombs

*Ezio still is learning to make bombs. With their help, he will save civilization. We should help Ezio to make his perfect bombs.*

You will be given **a two sequence of integers, representing bomb effects** and **bomb casings**.

You need to start from the **first bomb effect** and try to mix it with the **last bomb casing**. If the **sum** of their values is **equal** to 
**any of the materials in the table below** - **create the bomb corresponding** to the **value** and **remove** the **both** bomb materials. 
Otherwise, just **decrease** the value of the **bomb casing** **by 5**. 
You need to **stop** combining when you have **no more bomb effects** or **bomb casings**, or you successfully filled the bomb pouch.

**Bombs:**

- **Datura Bombs: 40**
- **Cherry Bombs: 60**
- **Smoke Decoy Bombs: 120**

To fill the bomb pouch, Ezio needs **three of each** of the **bomb types**.

### Input

- On the **first line**, you will receive the integers representing the **bomb effects**, **separated** by **", "**.
- On the **second line**, you will receive the integers representing the **bomb casing**, **separated** by **", "**.

### Output

- On the **first** line of output - print one of these rows according whether Ezio succeeded fulfill the bomb pouch:

  o "**Bene! You have successfully filled the bomb pouch!**"

  o **"You don't have enough materials to fill the bomb pouch."**

- On the **second** line - print all bomb effects left:

  o If there are no bomb effects: "**Bomb Effects: empty**"

  o If there are effects: "**Bomb Effects: {bombEffect1}, {bombEffect2}, (...)**"

- On the **third** line - print all bomb casings left:

  o If there are no bomb casings: "**Bomb Casings: empty**"

  o If there are casings: "**Bomb Casings: {bombCasing1}, {bombCasing2}, (...)"**

- Then, you need to print **all** created bombs and the **count you have of them**, ordered **alphabetically**:

  o **"Cherry Bombs: {count}"**

  o **"Datura Bombs: {count}"**

  o **"Smoke Decoy Bombs: {count}"**

### Constraints

- All of the given numbers will be valid integers in the range **[0, 120]**.
- Don't have situation with negative material.

### Examples

| **Input** | **Output** |
| --- | --- |
| 5, 25, 50, 115 | You don't have enough materials to fill the bomb pouch. |
| 5, 15, 25, 35  | Bomb Effects: empty                                     |
|                | Bomb Casings: empty                                     |
|                | Cherry Bombs: 1                                         |
|                | Datura Bombs: 2                                         |
|                | Smoke Decoy Bombs: 1                                    |
| **Input** | **Output** |
| 30, 40, 5, 55, 50, 100, 110, 35, 40, 35, 100, 80 | Bene! You have successfully filled the bomb pouch! |
| 20, 25, 20, 5, 20, 20, 70, 5, 35, 0, 10          | Bomb Effects: 100, 80                              |
|                                                  | Bomb Casings: 20                                   |
|                                                  | Cherry Bombs: 3                                    |
|                                                  | Datura Bombs: 4                                    |
|                                                  | Smoke Decoy Bombs: 3                               |

# 2. Snake

*Everyone remembers the old snake games. Now is time to create our own snake game.*

You will be given an integer **n** for the **size** of the territory with **square** shape. On the next **n** lines, you will receive the **rows** of the territory. 
The snake will be placed on a **random position**, marked with the letter '**S**'. There will also be food on random positions, marked with **'\*'**. 
The territory may have **lair**. The lair will have two burrows **marked** with the **letter** - '**B**'. **All of the empty positions** will be marked with **'-'**.

Each turn, you will be given **command** for the **snake's movement**. When the snake moves it leaves a trail marked with **'.'**

Move commands will be: "**up**", "**down**", "**left**", "**right**".

If the snake **moves** to a **food**, it will eat the food, which will increase food quantity with one.

If it goes inside to a **burrow**, it **goes out** on the **position** of the **other burrow** and then **both** burrows **disappear**. 
If the snake **goes out** of its territory, the game is over. The snake needs **at least 10 food quantity** to be fed.

If **the snake goes outside of its territory or has eaten enough food**, the game should **end**.

### Input

- On the first line, you are given the integer **n** - the size of the **square** matrix.
- The **next n lines** holds the values for every **row**. 
- On each of the next lines you will get a move command.

### Output

- On the first line:

  o If the snake goes out of its territory, print: "**Game over!**"

  o If the snake eat enough food, print: "**You won! You fed the snake.**"

- On the second line print all food eaten: "**Food eaten: {food quantity}**"

- In the end print the matrix.

### Constraints

- The size of the **square** matrix will be between **[2...10].**
- There will **always** be **0** or **2** burrows, marked with - '**B**'.
- The snake position will be marked with '**S**'.
- The snake will **always** either go out of its territory or eat enough food.
- There will be no case in which the snake will go through itself.

### Examples

| **Input** | **Output** |
| --- | --- |
| 6       | Game over!    |
| -----S  | Food eaten: 1 |
| ----B-  | ----..        |
| ------  | ----.-        |
| ------  | ------        |
| --B---  | ------        |
| --\*--- | --.---        |
| left    | --.---        |
| down    |
| down    |
| down    |
| left    |
| **Input** | **Output** |
| 7          | You won! You fed the snake. |
| --\*\*\*S- | Food eaten: 10              |
| --\*----   | --....-                     |
| --\*\*\*-- | --.----                     |
| ---\*\*--  | --...--                     |
| ---\*---   | ---..--                     |
| ---\*---   | ---S---                     |
| ---\*---   | ---\*---                    |
| left       | ---\*---                    |
| left       |
| left       |
| down       |
| down       |
| right      |
| right      |
| down       |
| left       |
| down       |

# 3. Parking

### Problem description

Your task is to create a repository, which stores items by creating the classes described below.

### Car

First, write a Java class **Car** with the following fields:

- **manufacturer: String**
- **model: String**
- **year: int**

The class **constructor** should receive **manufacturer, model** and **year**.You need to create the appropriate **getters and setters**. 
Override the **toString()** method in the following format:

**"{manufacturer} {model} ({year})"**

### Parking

**Next**, write a Java class **Parking** that has **data** (**Collection**, which stores the entity **Car**). All entities inside the repository have the **same fields**. 
Also, the Parking class should have those fields:

- **type: String**
- **capacity: int**

The class **constructor** should receive **type** and **capacity**, also it should initialize the **data** with a new instance of the collection. Implement the following features:

- Field **data** - **Collection** that holds added cars
- Method **add(Car car)** - **adds** an **entity** to the data **if there is** an **empty cell** for the car.
- Method **remove(String manufacturer, String model)** - removes the car by **given manufacturer and model,** if such **exists**, and **returns boolean**.
- Method **getLatestCar()** - returns the **latest** car (by year) or null if have no cars.
- Method **getCar(String manufacturer, String model)** - returns the car with the **given manufacturer** and **model**  or **null** if there is no such car.
- Getter **getCount()** - **returns** the **number** of cars.
- **getStatistics()** - **returns** a **String** in the following **format**:

  o **"The cars are parked in {parking type}:**\
&nbsp;&nbsp; **{Car1}**\
&nbsp;&nbsp; **{Car2}**\
&nbsp;&nbsp; **(...)**"

### Constraints

- The **combinations** of **manufacturers** and **models** will be **always unique**.
- The **year** of the cars will always be **positive**.
- There won't be cars with the same years.

### Examples

This is an example how the **Parking** class is **intended to be used**.

| **Sample code usage** | 
| --- | 
| // Initialize the repository                                    |
| Parking parking = new Parking("Underground parking garage", 5); |
| <br>                                                            |
| // Initialize entity                                            |
| Car volvo = new Car("Volvo", "XC70", 2010);                     |
| <br>                                                            |
| // Print Car                                                    |
| System.out.println(volvo); // Volvo XC70 (2010)                 |
| <br>                                                            |
| // Add Car                                                      |
| parking.add(volvo);                                             |
| <br>                                                            |
| // Remove Car                                                   |
| System.out.println(parking.remove("Volvo", "XC90")); // false   |
| System.out.println(parking.remove("Volvo", "XC70")); // true    |
| <br>                                                            |
| Car peugeot = new Car("Peugeot", "307", 2011);                  |
| Car audi = new Car("Audi", "S4", 2005);                         |
| <br>                                                            |
| parking.add(peugeot);                                           |
| parking.add(audi);                                              |
| <br>                                                            |
| // Get Latest Car                                               |
| Car latestCar = parking.getLatestCar();                         |
| System.out.println(latestCar); // Peugeot 307 (2011)            |
| <br>                                                            |
| // Get Car                                                      |
| Car audiS4 = parking.getCar("Audi", "S4");                      |
| System.out.println(audiS4); // Audi S4 (2005)                   |
| <br>                                                            |
| // Count                                                        |
| System.out.println(parking.getCount()); // 2                    |
| <br>                                                            |
| // Get Statistics                                               |
| System.out.println(parking.getStatistics());                    |
| // The cars are parked in Underground parking garage:           |
| // Peugeot 307 (2011)                                           |
| // Audi S4 (2005)                                               |
