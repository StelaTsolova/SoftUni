# 1. Calorie Object

Write a function that composes an object by given properties. The input comes as an **array of strings**. Every **even index** of the array represents 
the **name of the food**. Every **odd index** is a **number** that is equal to the **calories in 100 grams of the given product**. 
Assign each value to its corresponding property, and finally print the object.

The **input** comes as an **array of string elements**.

The **output** should be printed on the console.

### Example

| **Input** | **Output** |
| --- | --- | 
| \['Yoghurt', '48', 'Rise', '138', 'Apple', '52'] | { Yoghurt: 48, Rise: 138, Apple: 52 } |
| **Input** | **Output** |
| \['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42'] |	{ Potato: 93, Skyr: 63, Cucumber: 18, Milk: 42 } |

# 2. Construction Crew

Write a program that **receives** a worker **object** as a **parameter** and modifies its properties. Workers have the following structure:

**{**

&nbsp;&nbsp; **weight: Number,**

&nbsp;&nbsp; **experience: Number,**

&nbsp;&nbsp; **levelOfHydrated: Number,**

&nbsp;&nbsp; **dizziness: Boolean**

**}**

**Weight** is expressed in **kilograms**, **experience** in **years** and **levelOfHydrated** is in **milliliters**. 
If you receive a worker whose **dizziness** property is set to **true** it means he needs to intake some **water** to be able to work correctly. 
The required amount is 0.1ml per **kilogram** per year of **experience**. The required amount must be **added** to 
the **existing amount (to the levelOfHydrated)**. Once the water is administered, change the **dizziness** property to **false**.

Workers who **do not have dizziness** should **not** be modified in any way. Return them as they were.

### Input

Your function will receive a valid **object** as a **parameter**.

### Output

Return the **same object** that was passed in, **modified** as necessary.

### Example

| **Input** | **Output** |
| --- | --- | 
| { weight: 80,                    | { weight: 80,                        |
| &nbsp;&nbsp; experience: 1,      | &nbsp;&nbsp; experience: 1,          |
| &nbsp;&nbsp; levelOfHydrated: 0, | &nbsp;&nbsp; levelOfHydrated: 8,     |
| &nbsp;&nbsp; dizziness: true }   | &nbsp;&nbsp; dizziness: true } false |
| **Input** | **Output** |
| { weight: 120,                     | { weight: 120,                       |
| &nbsp;&nbsp; experience: 20,       | &nbsp;&nbsp; experience: 20,         |
| &nbsp;&nbsp; levelOfHydrated: 200, | &nbsp;&nbsp; levelOfHydrated: 440,   |
| &nbsp;&nbsp; dizziness: true }     | &nbsp;&nbsp; dizziness: true } false |
| **Input** | **Output** |
| { weight: 95,                    | { weight: 95,                    |
| &nbsp;&nbsp; experience: 3,      | &nbsp;&nbsp; experience: 3,      |
| &nbsp;&nbsp; levelOfHydrated: 0, | &nbsp;&nbsp; levelOfHydrated: 0, |
| &nbsp;&nbsp; dizziness: false }  | &nbsp;&nbsp; dizziness: false }  |

# 3. Car Factory

Write a program that assembles a car by **giving requirements** out of **existing components**. The client will place an order in 
the form of an **object describing** the car. You need to **determine** which parts to use to fulfill the client's order. You have the following parts in storage:

An **engine** has **power** (given in horsepower) and **volume** (given in cubic centimeters). Both of these values are **numbers**. 
When selecting an engine, pick the **smallest possible** that still meets the requirements.

**Small engine: { power: 90, volume: 1800 }**

**Normal engine: { power: 120, volume: 2400 }**

**Monster engine: { power: 200, volume: 3500 }**

A **carriage** has a **type** and **color**. Both of these values are **strings**. You have two types of carriages in storage and can paint them **any color**.

**Hatchback: { type: 'hatchback', color: \<as required> }**

**Coupe: { type: 'coupe', color: \<as required> }**

The **wheels** will be represented by an **array** of 4 **numbers**, each number represents the **diameter** of the wheel in inches. 
The size can only be an **odd number**. Round **down** any requirements you receive to the nearest odd number.

### Input

You will receive an **object** as an **argument** to your function. The format will be as follows:

**{ model: \<model name>,**

 **&nbsp;&nbsp; power: \<minimum power>,**

 **&nbsp;&nbsp; color: \<color>,**

 **&nbsp;&nbsp; carriage: \<carriage type>,**

 **&nbsp;&nbsp; wheelsize: \<size> }**

### Output

**Return** the resulting car **object** as a result of your function. See the examples for details.

### Example

| **Input** | **Output** |
| --- | --- |
| { model: 'VW Golf II',              | { model: 'VW Golf II',                                                                                                              |
| &nbsp;&nbsp; power: 90,             | &nbsp;&nbsp; engine: { power: 90,                                                                                                   |
| &nbsp;&nbsp; color: 'blue',         | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; volume: 1800 },              |
| &nbsp;&nbsp; carriage: 'hatchback', | &nbsp;&nbsp; carriage: { type: 'hatchback',                                                                                         |
| &nbsp;&nbsp; wheelsize: 14 }        | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; color: 'blue' }, |
|                                     | &nbsp;&nbsp; wheels: \[13, 13, 13, 13] }                                                                                            |
| **Input** | **Output** |
| { model: 'Opel Vectra',         | { model: 'Opel Vectra',                                                                                                             |
| &nbsp;&nbsp; power: 110,        | &nbsp;&nbsp; engine: { power: 120,                                                                                                  |
| &nbsp;&nbsp; color: 'grey',     | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; volume: 2400 },              |  
| &nbsp;&nbsp; carriage: 'coupe', | &nbsp;&nbsp; carriage: { type: 'coupe',                                                                                             |
| &nbsp;&nbsp; wheelsize: 17 }    | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; color: 'grey' }, |
|                                 | &nbsp;&nbsp; wheels: \[17, 17, 17, 17] }                                                                                            |

# 4. Heroic Inventory

In the era of heroes, every hero has his items that make him unique. Create a function that creates a **register for the heroes**, with their **names**, **level**, 
and **items**, if they have such. The register should accept data in a specified format, and return it presented in a specified format.

### Input

The **input** comes as an array of strings. Each element holds data for a hero, in the following format:

**"{heroName} / {heroLevel} / {item1}, {item2}, {item3}..."**

You must store the data about every hero. The **name** is a **string**, a **level** is a **number** and the items are all **strings.**

### Output

The **output** is a **JSON representation** of the data for all the heroes you've stored. The data must be an **array of all the heroes**. 
Check the examples for more info.

### Example

| **Input** | **Output** |
| --- | --- |
| \['Isacc / 25 / Apple, GravityGun',          | \[{"name":"Isacc","level":25,"items":\["Apple","GravityGun"]},{"name":"Derek","level":12,"items":\["BarrelVest","DestructionSword"]},{"name":"Hes","level":1,"items":\["Desolator","Sentinel","Antara"]}] |
| 'Derek / 12 / BarrelVest, DestructionSword', |                                                                                                                                                                                                           |
| 'Hes / 1 / Desolator, Sentinel, Antara']     |                                                                                                                                                                                                           |
| **Input** | **Output** |
| \['Jake / 1000 / Gauss, HolidayGrenade'] | \[{"name":"Jake","level":1000,"items":\["Gauss","HolidayGrenade"]}] |

# 5. Lowest Prices in Cities

You will be given several towns, with products and their price. 
You need to find **the lowest price** for **every product** and **the town it is sold at** for that price.

### Input

The **input** comes as an array of strings. Each element will hold data about a **town**, **product**, and **its price** at that town. 
The **town** and **product** will be **strings**, the **price** will be a **number**. The input will come in the following format:

**{townName} | {productName} | {productPrice}**

### Output

As **output**, you must print **each product** with its **lowest price** and **the town** at which the product is **sold at that price**. 
If **two towns share** the **same lowest price**, print the one that was **entered first**.\
The output, for every product, should be in the following format:

**{productName} -> {productLowestPrice} ({townName})**

The **order of output** in - **order of entrance**. See the examples for more info.

### Example

| **Input** | **Output** |
| --- | --- |
| \['Sample Town \| Sample Product \| 1000', | Sample Product -> 1000 (Sample Town) |
| 'Sample Town \| Orange \| 2',              | Orange -> 2 (Sample Town)            |
| 'Sample Town \| Peach \| 1',               | Peach -> 1 (Sample Town)             |
| 'Sofia \| Orange \| 3',                    | Burger -> 10 (New York)              |
| 'Sofia \| Peach \| 2',                     |                                      |
| 'New York \| Sample Product \| 1000.1',    |                                      |
| 'New York \| Burger \| 10']                |                                      |

# 6. Store Catalogue

You have to create a sorted catalog of store products. You will be given the products' names and prices. You need to order them in **alphabetical order**.

### Input

The **input** comes as an array of strings. Each element holds info about a product in the following format:

**"{productName} : {productPrice}"**

The **product's name** will be a **string**, which will **always start with a capital letter**, and the **price** will be **a number**. 
There will be **NO duplicate product input**. The comparison for alphabetical order is **case-insensitive**.

### Output

As **output**, you must print all the products in a specified format. They must be ordered **exactly as specified above**. 
The products must be **divided into groups**, by the **initial of their name**. 
The **group's initial should be printed**, and after that, the products should be printed with **2 spaces before their names**. For more info check the examples.

### Example

| **Input** | **Output** || **Input** | **Output** |
| --- | --- | --- | --- | --- |
| \['Appricot : 20.4',   | A                         || \['Banana : 2',       | B                        |
| 'Fridge : 1500',       | &nbsp; Anti-Bug Spray: 15 || 'Rubic's Cube : 5',   | &nbsp; Banana: 2         |
| 'TV : 1499',           | &nbsp; Apple: 1.25        || 'Raspberry P : 4999', | &nbsp; Barrel: 10        |
| 'Deodorant : 10',      | &nbsp;&nbsp;  Appricot: 20.4     || 'Rolex : 100000',     | P                        |
| 'Boiler : 300',        | B                         || 'Rollon : 10',        | &nbsp; Pesho: 0.000001   |
| 'Apple : 1.25',        | &nbsp; Boiler: 300        || 'Rali Car : 2000000', | R                        |
| 'Anti-Bug Spray : 15', | D                         || 'Pesho : 0.000001',   | &nbsp; Rali Car: 2000000 |
| 'T-Shirt : 10']        | &nbsp; Deodorant: 10      || 'Barrel : 10']        | &nbsp; Raspberry P: 4999 |
|                        | F                         ||                       | &nbsp; Rolex: 100000     |
|                        | &nbsp; Fridge: 1500       ||                       | &nbsp; Rollon: 10        |
|                        | T                         ||                       | &nbsp; Rubic's Cube: 5   |
|                        | &nbsp; T-Shirt: 10        ||                       |
|                        | &nbsp; TV: 1499           ||                       |

# 7. Towns to JSON

You're tasked to create and print a JSON from a text table. You will receive input as an array of strings, where each string represents a row of a table, 
with values on the row encompassed by pipes **"|"** and optionally spaces. The table will consist of exactly 3 columns **"Town"**, **"Latitude"** and **"Longitude"**. 
The **Latitude** and **Longitude** columns will always contain **valid numbers**. Check the examples to get a better understanding of your task.

### Input

The **input** comes as an array of strings - the first string contains the table's headings, each next string is a row from the table.

### Output

- The **output** should be an array of objects wrapped in **JSON.stringify()**.
- **Latitude** and **Longitude** must be parsed to **numbers,** and represented till the **second digit after the decimal point**!

### Example

| **Input** | **Output** |
| --- | --- |
| \['\| Town \| Latitude \| Longitude \|',    | \[{"Town":"Sofia",              |
| '\| Sofia \| 42.696552 \| 23.32601 \|',     | &nbsp;&nbsp; "Latitude":42.7,   |
| '\| Beijing \| 39.913818 \| 116.363625 \|'] | &nbsp;&nbsp; "Longitude":23.32  |
|                                             | },                              |
|                                             | {"Town":"Beijing",              |
|                                             | &nbsp;&nbsp; "Latitude":39.91,  | 
|                                             | &nbsp;&nbsp; "Longitude":116.36 |
|                                             | }]                              |
| **Input** | **Output** |
| \['\| Town \| Latitude \| Longitude \|',      | \[{"Town":"Veliko Turnovo",    |
| '\| Veliko Turnovo \| 43.0757 \| 25.6172 \|', | &nbsp;&nbsp; "Latitude":43.08, |
| '\| Monatevideo \| 34.50 \| 56.11 \|']        | &nbsp;&nbsp; "Longitude":25.62 |
|                                               | },                             |
|                                               | {"Town":"Monatevideo",         |
|                                               | &nbsp;&nbsp; "Latitude":34.5,  |
|                                               | &nbsp;&nbsp; "Longitude":56.11 |
|                                               | }]                             |

# 8. Rectangle

Write a **function** that creates and returns a rectangle object. The rectangle needs to have a **width** (Number), **height** (Number), 
and **color** (String) properties, which are set via arguments during creation, and a **calcArea()** method, that calculates and **returns** the rectangle's area.

### Input

The function will receive three valid parameters - **width** (Number), **height** (Number), and **color** (String).

### Output

Your function must return an object with all properties and methods as described. The **calcArea()** method of the object should **return** a number. 
The first letter in the color must be **upperCase().**

### Example

| **Input** | **Output** |
| --- | --- |
| let rect = rectangle(4, 5, 'red'); | 4   |
| console.log(rect.width);           | 5   |
| console.log(rect.height);          | Red |
| console.log(rect.color);           | 20  |
| console.log(rect.calcArea());      |     |

# 9. Sorted List*

Create a function that returns a special **object**, which **keeps** a list of numbers, sorted in **ascending order**. It must support the following functionality:

-   **add(element)** - adds a new element to the collection
-   **remove(index)** - removes the element at position **index**
-   **get(index)** - returns the value of the element at position **index**
-   **size** - number of elements stored in the collection

The **correct order** of the elements must be kept **at all times**, regardless of which operation is called. **Removing** and **retrieving** elements 
**shouldn't work** if the provided index points **outside the length** of the collection (either throw an error or do nothing). 
Note the **size** of the collection is **not** a function.

### Input / Output

The initial function takes no arguments and must **return** an **object**.

All methods on the object that expect **input** will receive data as **parameters**. Methods that have **validation** will be tested with 
both **valid and invalid** data. Any result expected from a method should be **returned** as its result.

### Example

| **Input** | **Output** |
| --- | --- |
| let list = createSortedList(); | 6 |
| list.add(5);                   | 7 |
| list.add(6);                   |   |
| list.add(7);                   |   |
| console.log(list.get(1));      |   |
| list.remove(1);                |   |
| console.log(list.get(1));      |   |

# 10.	Heroes

Create a function that **returns** an **object** with 2 methods (**mage** and **fighter**). 
This object should be able to **create** heroes (fighters and mages). Every hero has a **state**.

- Fighters have a **name**, **health = 100,** and **stamina = 100** and every fighter can fight.  When he **fights** his **stamina decreases** by **1** and 
  the following message is **printed** on the console:

  **`${fighter's name} slashes at the foe!`**

- Mages also have state (**name**, **health = 100** and **mana = 100**). Every mage can **cast spells**. 
  When a spell is cast the mage's **mana decreases** by **1** and the following message is **printed** on the console:

  **`${mage's name} cast ${spell}`**

### Example

| **Input** | **Output** |
| --- | --- |
| let create = solve();                           | Scorcher cast fireball         |
| const scorcher = create.mage("Scorcher");       | Scorcher cast thunder          |
| scorcher.cast("fireball")                       | Scorcher cast light            |
| scorcher.cast("thunder")                        | Scorcher 2 slashes at the foe! |
| scorcher.cast("light")                          | 99                             |
| <br>                                            | 97                             |
| const scorcher2 = create.fighter("Scorcher 2"); |                                |
| scorcher2.fight()                               |                                |
| <br>                                            |                                |
| console.log(scorcher2.stamina);                 |                                |
| console.log(scorcher.mana);                     |                                |

# 11.	Jan's Notation *

Write a program that parses a series of instructions written in **postfix notation** and executes them (postfix means the operator is written **after** the operands). 
You will receive a **series of instructions** - if the instruction is a **number**, **save it**; otherwise, the instruction is an **arithmetic operator** (**+-\*/**) 
and you must apply it to the most two **most recently saved** numbers. **Discard** these two numbers and in their place, **save the result** of the operation - this 
number is now eligible to be an **operand** in a subsequent operation. Keep going until all input instructions have been exhausted, or you encounter an **error**.

In the end, if you're left with a **single saved number**, this is the **result** of the calculation and you must **print** it. If there are more numbers saved, 
then the user-supplied **too many instructions** and you must print "**Error: too many operands!**". If at any point during the calculation you **don't have** 
two numbers saved, the user-supplied **too few instructions** and you must print "**Error: not enough operands!**".  *See the examples for more details.*

### Input

You will receive an array with numbers **and** strings - the numbers will be **operands** and must be saved; 
the strings will be **arithmetic operators** that must be applied to the operands.

### Output

Print on the **console** on a single line the **final result** of the calculation or an **error message**, as instructed above.

### Constraints

-   The **numbers** (operands) will be integers
-   The **strings** (operators) will always be one of **+-\*/**
-   The result of each operation will be in the range \[-2^53^...2^53^-1] (**MAX_SAFE_INTEGER** will **never** be exceeded)

### Example

| **Input** | **Output** |
| --- | --- |
| \[3,       | 7 |
| &nbsp;4,   |   |
| &nbsp;'+'] |   |
| **Input** | **Output** |
| \[5,        | -7 |
| &nbsp;3,    |    |
| &nbsp;4,    |    |
| &nbsp;'\*', |    |
| &nbsp;'-']  |    |
| **Input** | **Output** |
| \[7,       | Error: too many operands! |
| &nbsp;33,  |                           |
| &nbsp;8,   |                           |
| &nbsp;'-'] |                           |
| **Input** | **Output** |
| \[15,      | Error: not enough operands! |
| &nbsp;'/'] |                             |
