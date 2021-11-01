# 1.	Parking Lot

Write a program that:

   o Records **car number** for every car that enter in the **parking lot**.

   o Removes **car number** when the car go out.

When the parking lot is empty, print  **"Parking Lot is Empty"**.

### Input

The input will be string in format **{direction, carNumber}**.
The input ends with string **"END"**.

### Output

Print the output with all car numbers, which are in parking lot.

### Examples

| **Input** | **Output** | 
| --- | --- |
| IN, CA2844AA  | CA9999TT |
| IN, CA1234TA  | CA2844AA |
| OUT, CA2844AA | CA9876HH |
| IN, CA9999TT  | CA2822UU |
| IN, CA2866HI  |
| OUT, CA1234TA |
| IN, CA2844AA  |
| OUT, CA2866HI |
| IN, CA9876HH  |
| IN, CA2822UU  |
| END           |
| **Input** | **Output** | 
| IN, CA2844AA  | Parking Lot is Empty |
| IN, CA1234TA  |
| OUT, CA2844AA |
| OUT, CA1234TA |
| END           |

# 2.	SoftUni Party

There is a party in SoftUni. Many guests are invited, and they are two types: **VIP** and **regular**.\
When guest comes, you have to check if he/she **exist** in any of two reservation lists. All reservation numbers will be with **8 chars**. All **VIP** numbers start with **digit**.

There will be 2 command lines:

- First is **"PARTY"** - party is on and guests start coming.
- Second is **"END"** - then party is over, and no more guest will come.

Output shows all guests, who didn't come to the party (**VIP** must be first).

### Examples

| **Input** | **Output** | | **Input** | **Output** |
| --- | --- | --- | --- | --- |
| 7IK9Yo0h | 2        | | m8rfQBvl | 2        |
| 9NoBUajQ | 7IK9Yo0h | | fc1oZCE0 | MDzcM9ZK |
| Ce8vwPmE | tSzE5t0p | | UgffRkOn | xys2FYzn |
| SVQXQCbc |          | | 7ugX7bm0 |
| tSzE5t0p |          | | 9CQBGUeJ |
| PARTY    |          | | 2FQZT3uC |
| 9NoBUajQ |          | | dziNz78I |
| Ce8vwPmE |          | | mdSGyQCJ |
| SVQXQCbc |          | | LjcVpmDL |
| END      |          | | fPXNHpm1 |
|          |          | | HTTbwRmM |
|          |          | | B5yTkMQi |
|          |          | | 8N0FThqG |
|          |          | | xys2FYzn |
|          |          | | MDzcM9ZK |
|          |          | | PARTY    |
|          |          | | 2FQZT3uC |
|          |          | | dziNz78I |
|          |          | | mdSGyQCJ |
|          |          | | LjcVpmDL |
|          |          | | fPXNHpm1 |
|          |          | | HTTbwRmM |
|          |          | | B5yTkMQi |
|          |          | | 8N0FThqG |
|          |          | | m8rfQBvl |
|          |          | | fc1oZCE0 |
|          |          | | UgffRkOn |
|          |          | | 7ugX7bm0 |
|          |          | | 9CQBGUeJ |
|          |          | | END      |

# 3.	"Voina" – Number Game

Write a program that:

- Reads 20 numbers for both players, separated with "  " (single space).

   o Every player can hold only **unique** numbers.

Each Round both players get the **top number** from their own deck. Player with the bigger number get both numbers and add it on the **bottom** of his own sequence.

Game ends after **50 rounds** or if any player **lose all** of his numbers.

### Input

- Numbers - **Integer**

### Output

- Output must be **"First player win!"**, **"Second player win!"** or **"Draw!"**

### Examples

| **Input** | **Output** | 
| --- | --- |
| 26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23 | Second player win! |
| 43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97 |
| **Input** | **Output** | 
| 74 78 82 42 19 39 29 69 20 42 31 77 57 36 76 26 4 9 83 42   | First player win! |
| 15 43 80 71 22 88 78 35 28 30 46 41 76 51 76 18 14 52 47 38 |

# 4.	Count Real Numbers

Write a program that counts the occurrence of real **numbers**. The input is a single line with real numbers separated by a space. Print the numbers in the order of appearance. 
All **numbers** must be formatted to **one digit** after the decimal point.

### Examples

| **Input** | **Output** | 
| --- | --- |
| -2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3 | -2.5 -> 3 |
|                                 | 4.0 -> 2  |
|                                 | 3.0 -> 4  |
|                                 | -5.5 -> 1 |
| **Input** | **Output** | 
| 2.3 4.5 4.5 5.5 5.5 2.3 3.0 3.0 4.5 4.5 3.0 3.0 4.0 3.0 5.5 3.0 2.3 5.5 4.5 3.0 | 2.3 -> 3 |
|                                                                                 | 4.5 -> 5 |
|                                                                                 | 5.5 -> 4 |
|                                                                                 | 3.0 -> 7 |
|                                                                                 | 4.0	-> 1 |

# 5.	Average Students Grades

Write a program, which reads the **name** of a student and their **grades** and **adds** them to the **student record**, 
then **prints grades** along with their **average grade - ordered the output by the names of the students**.

### Input

On the first line **N** - the number of students, then on the next **N** lines student name with grade.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 7            | Alex -> 2.00 3.00 (avg: 2.50)       |
| Stephan 5.20 | Maria -> 5.50 2.50 3.46 (avg: 3.82) |
| Maria 5.50   | Stephan -> 5.20 3.20 (avg: 4.20)    |
| Stephan 3.20 |
| Maria 2.50   |
| Alex 2.00    |
| Maria 3.46   |
| Alex 3.00    |
| **Input** | **Output** | 
| 4          | Alex -> 4.50 5.00 (avg: 4.75)  |
| Alex 4.50  | Peter -> 3.00 3.66 (avg: 3.33) |
| Peter 3.00 |
| Alex 5.00  |
| Peter 3.66 |
| **Input** | **Output** | 
| 5           | Alex -> 4.40 (avg: 4.40)             |
| George 6.00 | George -> 6.00 5.50 6.00 (avg: 5.83) |
| George 5.50 | Peter -> 3.30 (avg: 3.30)            |            
| George 6.00 |
| Alex 4.40   |
| Peter 3.30  |
| Peter 4.50  |

# 6.	Product Shop

Write a program that prints information about food shops in Sofia and the products they store. Until the **"Revision"** command you will receive an input in the format: 
**"{shop}, {product}, {price}"**

Keep in mind that if you get a store that already exists, you need to gather product information in it.

Your output must be ordered by shop name and must be in the format:

**"{shop}->**\
**Product: {product}, Price: {price}"**

The price should be formated to **one digit** after the decimal point.

### Examples

| **Input** | **Output** | 
| --- | --- |
| lidl, peach, 1.20       | fantastico->
| lidl, juice, 2.30       | Product: apple, Price: 1.2
| fantastico, apple, 1.20 | Product: grape, Price: 2.2
| kaufland, banana, 1.10  | kaufland->
| fantastico, grape, 2.20 | Product: banana, Price: 1.1
| Revision                | lidl->
|                         | Product: peach, Price: 1.2
|                         | Product: juice, Price: 2.3
| **Input** | **Output** |
| tmarket, peanuts, 2.20   | GoGrill->                      |
| GoGrill, meatballs, 3.30 | Product: meatballs, Price: 3.3 |
| GoGrill, HotDog, 1.40    | Product: HotDog, Price: 1.4    |
| tmarket, sweets, 2.20    | tmarket->                      |
| Revision                 | Product: peanuts, Price: 2.2   |
|                          | Product: sweets, Price: 2.2    | 

# 7.	Cities by Continent and Country

Write a program to read **continents**, **countries** and their **cities**, put them in a **nested map** and **print** them in the order of first appearance.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 9                       | Europe:                                |
| Europe Bulgaria Sofia   | &nbsp;&nbsp;Bulgaria -> Sofia, Plovdiv |
| Asia China Beijing      | &nbsp;&nbsp;Poland -> Warsaw, Poznan   |   
| Asia Japan Tokyo        | &nbsp;&nbsp;Germany -> Berlin          |
| Europe Poland Warsaw    | Asia:                                  |
| Europe Germany Berlin   | &nbsp;&nbsp;China -> Beijing, Shanghai |
| Europe Poland Poznan    | &nbsp;&nbsp;Japan -> Tokyo             |
| Europe Bulgaria Plovdiv | Africa:                                |
| Africa Nigeria Abuja    | &nbsp;&nbsp;Nigeria -> Abuja           |
| Asia China Shanghai     |
| **Input** | **Output** | 
| 3                     | Europe:                       |
| Europe Germany Berlin | &nbsp;&nbsp;Germany -> Berlin |
| Europe Bulgaria Varna | &nbsp;&nbsp;Bulgaria -> Varna |
| Africa Egypt Cairo    | Africa:                       |
|                       | &nbsp;&nbsp;Egypt -> Cairo    |
| **Input** | **Output** | 
| 8                        | Africa:                                    |
| Africa Somalia Mogadishu | &nbsp;&nbsp;Somalia -> Mogadishu           |
| Asia India Mumbai        | Asia:                                      |
| Asia India Delhi         | &nbsp;&nbsp;India -> Mumbai, Delhi, Nagpur |
| Europe France Paris      | Europe:                                    |
| Asia India Nagpur        | &nbsp;&nbsp;France -> Paris                |
| Europe Germany Hamburg   | &nbsp;&nbsp;Germany -> Hamburg, Danzig     |
| Europe Poland Gdansk     | &nbsp;&nbsp;Poland -> Gdansk               |
| Europe Germany Danzig    |

# 8.	Academy Graduation

Write a program that:

- Reads from console **number** of students for a track.
- Reads on **pair of rows**:

  o First line is the **name** of student.

  o Second line is his **score** for different number of courses.

- Print on console "**{name} is graduated with {average scores)**".

### Examples

| **Input** | **Output** | 
| --- | --- |
| 3      | George is graduated with 4.375 |
| George | Maria is graduated with 5.125  |
| 3.75 5 | Peter is graduated with 5.25   |
| Maria  |
| 4.25 6 |
| Peter  |
| 6 4.5  |
| **Input** | **Output** |
| 5                                       | George is graduated with 4.351249999999999 |
| George                                  | John is graduated with 4.09375             |
| 4.36 5.50 3.30 5.63 2.57 5.75 2.81 4.89 | Maria is graduated with 4.11875            |
| Peter                                   | Peter is graduated with 4.145              |
| 3.10 5.35 3.30 3.35 5.64 4.99 2.75 4.68 | Rosalia is graduated with 3.3375           |
| Maria                                   | 
| 3.45 3.23 3.03 5.42 5.46 4.15 2.26 5.95 |
| Rosalia                                 |
| 2.08 3.48 3.36 2.73 2.96 4.54 3.70 3.85 |
| John                                    |
| 4.75 4.92 3.78 4.79 4.82 4.75 2.81 2.13 |
