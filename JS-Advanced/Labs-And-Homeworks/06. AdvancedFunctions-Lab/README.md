# 1. Area and Volume Calculator

Write a function that **calculates** the **area** and the **volume** of a figure, which is **defined** by its **coordinates**\
(**x**, **y**, **z**).

| **area()** |
| --- |
| function area() {                                    |
| &nbsp;&nbsp;&nbsp; return Math.abs(this.x * this.y); |
| };                                                   |

| **vol()** |
| --- |
| function vol() {                                              |
| &nbsp;&nbsp;&nbsp; return Math.abs(this.x * this.y * this.z); |
| };                                                            |

| **solve()** |
| --- |
| function solve(area, vol, input) { |
| &nbsp;&nbsp;&nbsp; //ToDo....      |
| }                                  |

### Input

You will receive **3** parameters -  the **functions** **area** and **vol** and a **string**, which contains the figures' coordinates.

**For more information check the examples.**

### Output

The output should be **returned** as an **array** **of objects**. Each object has **two** **properties**: the figure's **area** and **volume**.

**\[**

&nbsp;&nbsp; **\{ area: \$\{area1\}, volume: $\{volume1\} \},**
 
&nbsp;&nbsp; **\{ area: $\{area2\}, volume: $\{volume2\} \},**

&nbsp;&nbsp; **. . .**

**]**

### Example

| **Sample Input** | **Output** |
| --- | --- |
| area, vol, `[               | [                                       |
| {"x":"1","y":"2","z":"10"}, | &nbsp;&nbsp; { area: 2, volume: 20 },   |
| {"x":"7","y":"7","z":"10"}, | &nbsp;&nbsp; { area: 49, volume: 490 }, |
| {"x":"5","y":"2","z":"10"}  | &nbsp;&nbsp; { area: 10, volume: 100 }  |
| ]`                          | ]                                       |
| **Sample Input** | **Output** |
| area, vol, `[                    | [                                              |
| {"x":"10","y":"-22","z":"10"},   | &nbsp;&nbsp; { area: 220, volume: 2200 },      |
| {"x":"47","y":"7","z":"-5"},     | &nbsp;&nbsp; { area: 329, volume: 1645 },      |
| {"x":"55","y":"8","z":"0"},      | &nbsp;&nbsp; { area: 440, volume: 0 },         |
| {"x":"100","y":"100","z":"100"}, | &nbsp;&nbsp; { area: 10000, volume: 1000000 }, |
| {"x":"55","y":"80","z":"250"}    | &nbsp;&nbsp; { area: 4400, volume: 1100000 }   |
| ]`                               | ]                                              |

# 2. Add

Write a program that keeps a number **inside its context** and **returns** a new function that **adds** a **given** number to the previous one.

### Input

Check the **examples below** to see how your code will be executed.

### Output

Your function should **return** the final result.

### Example

| **Sample Input** | **Output** |
| --- | --- |
| let add5 = solution(5); | 7 |
| console.log(add5(2));   | 8 |
| console.log(add5(3));   |   |
| **Sample Input** | **Output** |
| let add7 = solution(7); | 9  |
| console.log(add7(2));   | 10 |
| console.log(add7(3));   |    |

# 3. Currency Format

Write a **higher-order** function createFormatter that fixes some of the parameters of another function. Your program will **receive four parameters**: 
**threevalues**and a **function** that **takes 4 parameters** and **returns a formatted string** (a monetary value with currency symbol).

Your task is to **return a partially applied function**, based on the input function that has its **first three** parameters fixed and only **takes one parameter**.

You will receive the following function:

| **currencyFormatter** |
| --- |
| function currencyFormatter(separator, symbol, symbolFirst, value) { |
| &nbsp;&nbsp;&nbsp; let result = Math.trunc(value) + separator;      |
| &nbsp;&nbsp;&nbsp; result += value.toFixed(2).substr(-2,2);         |
| &nbsp;&nbsp;&nbsp; if (symbolFirst) return symbol + ' ' + result;   |
| &nbsp;&nbsp;&nbsp; else return result + ' ' + symbol;               |
| }                                                                   |

Receive and set the following parameters to fixed values:

**separator**

**symbol**

**symbolFirst**

The final parameter **value** is the one that the returned function must receive.

### Input

You will receive four parameters:

- **separator** (string)
- **symbol** (string)
- **symbolFirst** (Boolean)
- **formatter** (function)

### Output

You need to **return a function** that takes one parameter - **value**

### Example

| **Sample Input** |
| --- |
| let dollarFormatter = createFormatter(',', '$', true, currencyFormatter); |
| console.log(dollarFormatter(5345));   // $ 5345,00                        |
| console.log(dollarFormatter(3.1429)); // $ 3,14                           |
| console.log(dollarFormatter(2.709));  // $ 2,71                           |

# 4. Filter Employees

Write a program that filters the employees of your company. You should print the result in a specific format. 
You will receive **2** parameters (**data**, **criteria**). You should **parse** the input, find all employees that fulfill the criteria, and print them.

### Input

You will receive a **string** with all the employees, and **criteria** by which you should sort the employees. 
If the criteria are **"all"** print all the employees in the given format.

### Output

The output should be **printed** on the console.

For more information check the examples.

### Examples

| **Sample Input** | **Output** |
| --- | --- |
| `[{                                                   | 0. Ardine Bassam - abassam0@cnn.com |
| &nbsp;&nbsp;&nbsp; "id": "1",                         | 1. Kizzee Jost - kjost1@forbes.com  |
| &nbsp;&nbsp;&nbsp; "first_name": "Ardine",            |                                     |
| &nbsp;&nbsp;&nbsp; "last_name": "Bassam",             |                                     |
| &nbsp;&nbsp;&nbsp; "email": "abassam0@cnn.com",       |                                     |
| &nbsp;&nbsp;&nbsp; "gender": "Female"                 |                                     |
|   }, {                                                |                                     |
| &nbsp;&nbsp;&nbsp; "id": "2",                         |                                     |
| &nbsp;&nbsp;&nbsp; "first_name": "Kizzee",            |                                     |
| &nbsp;&nbsp;&nbsp; "last_name": "Jost",               |                                     |
| &nbsp;&nbsp;&nbsp; "email": "kjost1@forbes.com",      |                                     |
| &nbsp;&nbsp;&nbsp; "gender": "Female"                 |                                     |
|   },                                                  |                                     |
| {                                                     |                                     |
| &nbsp;&nbsp;&nbsp; "id": "3",                         |                                     |
| &nbsp;&nbsp;&nbsp; "first_name": "Evanne",            |                                     |
| &nbsp;&nbsp;&nbsp; "last_name": "Maldin",             |                                     |
| &nbsp;&nbsp;&nbsp; "email": "emaldin2@hostgator.com", |                                     |
| &nbsp;&nbsp;&nbsp; "gender": "Male"                   |                                     |
|   }]`,                                                |                                     |
| 'gender-Female'                                       |                                     |
| **Sample Input** | **Output** |
| `[{                                                   | 0. Kaylee Johnson - k0@cnn.com        |
| &nbsp;&nbsp;&nbsp; "id": "1",                         | 1. Kizzee Johnson - kjost1@forbes.com |
| &nbsp;&nbsp;&nbsp; "first_name": "Kaylee",            | 2. Evanne Johnson - ev2@hostgator.com |
| &nbsp;&nbsp;&nbsp; "email": "k0@cnn.com",             |                                       |
| &nbsp;&nbsp;&nbsp; "gender": "Female"                 |                                       |
|   }, {                                                |                                       |
| &nbsp;&nbsp;&nbsp; "id": "2",                         |                                       |
| &nbsp;&nbsp;&nbsp; "first_name": "Kizzee",            |                                       |
| &nbsp;&nbsp;&nbsp; "last_name": "Johnson",            |                                       |
| &nbsp;&nbsp;&nbsp; "email": "kjost1@forbes.com",      |                                       |
| &nbsp;&nbsp;&nbsp; "gender": "Female"                 |                                       |
|   }, {                                                |                                       |
| &nbsp;&nbsp;&nbsp; "id": "3",                         |                                       |
| &nbsp;&nbsp;&nbsp; "first_name": "Evanne",            |                                       |
| &nbsp;&nbsp;&nbsp; "last_name": "Maldin",             |                                       |
| &nbsp;&nbsp;&nbsp; "email": "emaldin2@hostgator.com", |                                       |
| &nbsp;&nbsp;&nbsp; "gender": "Male"                   |                                       |
|   }, {                                                |                                       |
| &nbsp;&nbsp;&nbsp; "id": "4",                         |                                       |
| &nbsp;&nbsp;&nbsp; "first_name": "Evanne",            |                                       |
| &nbsp;&nbsp;&nbsp; "last_name": "Johnson",            |                                       |
| &nbsp;&nbsp;&nbsp; "email": "ev2@hostgator.com",      |                                       |
| &nbsp;&nbsp;&nbsp; "gender": "Male"                   |                                       |
|   }]`,                                                |                                       |
|  'last_name-Johnson'                                  |                                       |

# 5. Command Processor

Write a program that keeps a string **inside its context** and can execute different **commands** that modify or print the string on the console.

**append(string)** - append the given **string** at the end of the internal string

**removeStart(n)** - **remove** the **first n** characters from the string, n is an integer

**removeEnd(n)** - **remove** the **last n** characters from the string, n is an integer

print - **print** the stored string on the **console**

### Input

Check the examples below to see how your code will be executed.

### Output

Whenever you receive the command **print**, the output should be **printed** on the console.

### Example

| **Sample Input** | **Output** |
| --- | --- |
| let firstZeroTest = solution(); | loa |
| <br>                            |     |
| firstZeroTest.append('hello');  |     |
| firstZeroTest.append('again');  |     |
| firstZeroTest.removeStart(3);   |     |
| firstZeroTest.removeEnd(4);     |     |
| firstZeroTest.print();          |     |
| **Sample Input** | **Output** |
| let secondZeroTest = solution(); | 34 |
| <br>                             |    |
| secondZeroTest.append('123');    |    |
| secondZeroTest.append('45');     |    |
| secondZeroTest.removeStart(2);   |    |
| secondZeroTest.removeEnd(1);     |    |
| secondZeroTest.print();          |    |

# 6. List Processor

Using a closure, create an inner object to process list commands. The commands supported should be the following:

- **add \<string>** - adds the following string in an inner collection.
- **remove \<string>** - removes all occurrences of the supplied **\<string>** from the inner collection.
- **print** - prints all elements of the inner collection joined by **","**.

### Input

The **input** will come as an **array of strings** - each string represents a **command** to be executed from the command execution engine.

### Output

For every print command - you should print on the console the inner collection joined by **","**.

### Example

| **Input** | **Output** |
| --- | --- |
| \['add hello', 'add again', 'remove hello', 'add again', 'print'] | again,again |
| **Input** | **Output** |
| \['add pesho', 'add george', 'add peter', 'remove peter','print'] | pesho,george |
