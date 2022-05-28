# 1. Echo Function

Write a JS function that takes **one string parameter** and **prints** on two lines the **length** of the parameter and then the **unchanged parameter** itself.

### Example

| **Input** | **Output** |
| --- | --- |
| 'Hello, JavaScript!' | 18                 |
|                      | Hello, JavaScript! |
| **Input** | **Output** |
| 'strings are easy' | 16               |
|                    | strings are easy |

# 2. String Length

Write a JS function that takes **three string arguments** as an input. Calculate the **sum** of the **length** of the **strings** and 
the **average length** of the strings **rounded down** to the nearest integer.

The **input** comes as **three string arguments** passed to your function.

The **output** should be printed on the console in two lines.

### Example

| **Input** | **Output** |
| --- | --- |
| 'chocolate', 'ice cream', 'cake' | 22 |
|                                  | 7  |
| **Input** | **Output** |
| 'pasta', '5', '22.3' | 10 |
|                      | 3  |

# 3. Largest Number

Write a function that takes **three number arguments** as input and finds the **largest** of them. 
Print the following text on the console:\
**\`The largest number is {number}.\`**.

The **input** comes as **three number arguments** passed to your function.

The **output** should be printed to the console.

### Example

| **Input** | **Output** |
| --- | --- |
| 5, -3, 16 |	The largest number is 16. |
| **Input** | **Output** |
| -3, -5, -22.5	| The largest number is -3. |

# 4. Circle Area

Write a function that takes **a single argument** as an input. **Check the type**  of input argument. 
If it is a **number**, assume it is the radius of a circle and **calculate the circle area**. Print the **area rounded** to **two decimal places**.

If the argument type is **NOT** a number, print the following text on the console:\
**\`We can not calculate the circle area, because we receive a {type of argument}.\`**

The **input** comes as a **single argument** passed to your function.

The **output** should be printed on the console.

### Example

| **Input** | **Output** |
| --- | --- |
| 5 | 78.54 | 
| **Input** | **Output** |
| 'name'| We can not calculate the circle area, because we receive a string. | 

# 5. Math Operations

Write a JS function that takes **two numbers** and **a string** as an input.

The string may be one of the following: **'+', '-', '\*', '/', '%', '\*\*'**.

Print on the console the result of the mathematical **operation** between **both numbers** and the **operator** you receive as a string.

The **input** comes as **two numbers** and **a string argument** passed to your function.

The **output** should be printed on the console.

### Example

| **Input** | **Output** |
| --- | --- |
| 5, 6, '\+'	| 11 |  
| **Input** | **Output** |
| 3, 5.5, '\*' | 16.5 | 

# 6. Sum of Numbers N…M

Write a JS function that takes two numbers **n and m** as an input and **prints the sum**  of all numbers from **n** to **m**.

The **input** comes as **two string elements** that need to be **parsed** as numbers.

The **output** should return  the **sum**.

### Example

| **Input** | **Output** |
| --- | --- |
| '1', '5' | 15 | 
| **Input** | **Output** |
| '-8', '20' | 174 | 

# 7. Day of Week

Write a function that prints a number between 1 and 7 when a **day of the week** is passed to it as a string and an **error message** if the string is **not recognized**.

The **input** comes as a single-string argument.

The **output** should be returned as a result.

### Example

| **Input** | **Output** |
| --- | --- |
| 'Monday' | 1 | 
| **Input** | **Output** |
| 'Friday' | 5 |
| **Input** | **Output** |
| 'Invalid'	| error| 

# 8. Days in a month

Write a JavaScript function to get the number of days in a month.

The input comes as two numeric parameters. The first element is the month, the second is the year.

The output must return the number of days in a month for a given year.

### Example

| **Input** | **Output** |
| --- | --- |
| 1, 2012	| 31 | 
| 2, 2021	| 28 | 

# 9. Square of Stars

Write a function that **prints a rectangle** made of **stars** with variablesize, depending on an input parameter. 
If there is **no parameter** specified, the rectangle should **always** be of **size 5**. Look at the examples to get an idea.

The **input** comes as a single **number** argument.

The **output** is a series of lines printed on the console, forming a rectangle of variable size.

### Example

| **Input** | **Output** || **Input** | **Output** || **Input** | **Output** || **Input** | **Output** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1	| * || 2 | * * || 5	| * * * * * || 7 | * * * * * * * |
|   |   ||   | * * ||   | * * * * * || 	 | * * * * * * * |
|   |   ||   |     ||   | * * * * * || 	 | * * * * * * * |
|   |   ||   |     ||   | * * * * * || 	 | * * * * * * * |
|   |   ||   |     ||   | * * * * * || 	 | * * * * * * * |

# 10.	Aggregate Elements

Write a program that performs different operations on an array of elements. Implement the following operations:

- **Sum(a~i~)** - calculates the sum of all elements from the input array
- **Sum(1/a~i~)** - calculates the sum of the inverse values (1/a~i~) of all elements from the array
- **Concat(a~i~)** - concatenates the string representations of all elements from the array

The **input** comes as an array of number elements.

The **output** should be printed on the console on a new line for each of the operations.

### Example

| **Input** | **Output** || **Input** | **Output** |
| --- | --- | --- | --- | --- |
| [1, 2, 3]	| 6                  || [2, 4, 8, 16] | 30     |
|           | 1.8333333333333333 ||               | 0.9375 |
|           | 123                ||               | 24816  |
