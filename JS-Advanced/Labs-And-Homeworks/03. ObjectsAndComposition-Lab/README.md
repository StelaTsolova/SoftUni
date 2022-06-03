# 1. City Record

You will receive a city's **name** (string), **population** (number), and **treasury** (number)as arguments, 
which you will need to set as **properties** of an **object** and **return** it.

### Example

| **Input** | **Output** |
| --- | --- | 
| 'Tortuga', | {                              |
| 7000,      | &nbsp;&nbsp; name: 'Tortuga',  |
| 15000      | &nbsp;&nbsp; population: 7000, |
|            | &nbsp;&nbsp; reasury: 15000    |
|            | }                              |
| **Input** | **Output** |
| 'Santo Domingo', | {                                   |
| 12000,           | &nbsp;&nbsp; name: 'Santo Domingo', |
| 23500            | &nbsp;&nbsp; population: 12000,     |
|                  | &nbsp;&nbsp; treasury: 23500        |
|                  | }                                   |

# 2. Town Population

You have been tasked to create a registry for different **towns** and their **population**.

### Input

The **input** comes as array of strings. Each element will contain data for a town and its population in the following format: **"{townName} <-> {townPopulation}"**

If you receive the same town twice, **you should add** the **given population** to the **current one**.

### Output

As **output**, you must print all the towns and their population.

### Example

| **Input** | **Output** |
| --- | --- |
| \['Sofia <-> 1200000',    | Sofia : 1200000      |
| 'Montana <-> 20000',      | Montana : 20000      |
| 'New York <-> 10000000',  | New York : 10000000  |
| 'Washington <-> 2345000', | Washington : 2345000 |
| 'Las Vegas <-> 1000000']  | Las Vegas : 1000000  |
| **Input** | **Output** |
| \['Istanbul <-> 100000',    | Istanbul : 100000      |
| 'Honk Kong <-> 2100004',    | Honk Kong : 2100004    |
| 'Jerusalem <-> 2352344',    | Jerusalem : 2352344    |
| 'Mexico City <-> 23401925', | Mexico City : 23401925 |
| 'Istanbul <-> 1000']        | Istanbul : 1000        |

# 3.	City Taxes

*This task is an extension of Problem 1, you may use your solution from that task as a base.*

You will receive a city's **name** (string), **population** (number), and **treasury** (number)as arguments, which you will need to set as **properties** of 
an **object** and **return** it. In addition to the input parameters, the object must have a property taxRate with an initial value of **10**, 
and three **methods** for managing the city:

- **collectTaxes()** - Increase **treasury** by **population \* taxRate**
- **applyGrowth(percentage)** - Increase population by **given percentage**
- **applyRecession(percentage)** - Decrease treasury by **given percentage**

Round down the values after each calculation.

### Input

Your solution will receive three **valid** parameters. The methods that expect parameters will be tested with valid input.

### Output

Return an **object** as described above. The methods of the object modify the object and don't return anything.

| **Input** | **Output** |
| --- | --- |
| const city =                      | {                                                        |
| &nbsp;&nbsp; cityTaxes('Tortuga', | &nbsp;&nbsp; name: 'Tortuga',                            |
| &nbsp;&nbsp; 7000,                | &nbsp;&nbsp; population: 7000,                           |                          
| &nbsp;&nbsp; 15000);              | &nbsp;&nbsp; treasury: 15000,                            |
| console.log(city);                | &nbsp;&nbsp; taxRate: 10,                                |
|                                   | &nbsp;&nbsp; collectTaxes: \[Function: collectTaxes],    |
|                                   | &nbsp;&nbsp; applyGrowth: \[Function: applyGrowth],      |
|                                   | &nbsp;&nbsp; applyRecession: \[Function: applyRecession] |
|                                   | }                                                        |

| **Testing with code** | |
| --- | --- |
| **Input** | **Output** |
| const city =                      | 85000 |
| &nbsp;&nbsp; cityTaxes('Tortuga', | 7350  |
| &nbsp;&nbsp; 7000,                |       |                          
| &nbsp;&nbsp; 15000);              |       |
| city.collectTaxes();              |       |
| console.log(city.treasury);       |       |
| city.applyGrowth(5);              |       |
| console.log(city.population);     |       |

# 4.	Object Factory

Create a function that can compose objects by copying functions from a given library of functions. You will receive **two parameters** - a **library** of 
functions as an associative array (object) and an **array of orders**, represented as objects. You must **return** a new array - the fulfilled orders.

The **first parameter** will be an object where each property is a **function**. You will use this **library of functions** to compose new objects.

The **second parameter** is an **array of orders**. Each order is an **object** with the following shape:

**{**

&nbsp;&nbsp; **template: \[Object],**

&nbsp;&nbsp; **parts: string\[]**

**}**

A **template** is an object that must be **copied**. The **parts array** contains the names of **required functions** as **strings**.

You must **create and return a new array**, by fulfilling all orders from the **orders array**. To fulfill an order, create a copy of the object's template and
then add to it all functions, listed in the **parts array** of the order, by taking them from the **function library** (the first parameter to your solution).

### Input

You will receive two parameters:

- **library** - an object
- **orders** - an array of objects

### Output

Your solution must **return an array** of objects.

### Example

| **Input** |
| --- |
| const library = {                                                                        |
| &nbsp;&nbsp; print: function () {                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; console.log(\`${this.name} is printing a page`);                |
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; scan: function () {                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp; console.log(\`${this.name} is scanning a document`);            |
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; play: function (artist, track) {                                            |
| &nbsp;&nbsp;&nbsp;&nbsp; console.log(\`${this.name} is playing '${track}' by ${artist}`);|
| &nbsp;&nbsp; },                                                                          |
| };                                                                                       |
| const orders = \[                                                                        |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; template: { name: 'ACME Printer'},                              |
| &nbsp;&nbsp;&nbsp;&nbsp; parts: \['print']                                               |  
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; template: { name: 'Initech Scanner'},                           |
| &nbsp;&nbsp;&nbsp;&nbsp; parts: \['scan']                                                |   
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; template: { name: 'ComTron Copier'},                            |
| &nbsp;&nbsp;&nbsp;&nbsp; parts: \['scan', 'print']                                       |     
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; template: { name: 'BoomBox Stereo'},                            |
| &nbsp;&nbsp;&nbsp;&nbsp; parts: \['play']                                                | 
| &nbsp;&nbsp; }                                                                           |
| ];                                                                                       |
| const products = factory(library, orders);                                               |
| console.log(products);                                                                   |
| **Output** |
| \[                                                                                       |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; name: 'ACME Printer',                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; print: \[Function: print]                                       |
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; name: 'Initech Scanner',                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; scan: \[Function: scan]                                         |
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; name: 'ComTron Copier',                                         |
| &nbsp;&nbsp;&nbsp;&nbsp; scan: \[Function: scan],                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; print: \[Function: print]                                       |
| &nbsp;&nbsp; },                                                                          |
| &nbsp;&nbsp; {                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp; name: 'BoomBox Stereo',                                         |
| &nbsp;&nbsp;&nbsp;&nbsp; play: \[Function: play]                                         |
| &nbsp;&nbsp; }                                                                           |
| ]                                                                                        |

# 5.	Assembly Line

Create a function that **returns** a **library of decorator functions**. They can be used to **compose** different functionality in a **car object** that 
they receive as an argument.

Your solution must **return an object**, containing **three decorator functions**:

hasClima - compose air conditioning controls into the passed-in object. This function takes an **object as a parameter** and adds to it the following properties:

- **temp** - **number** with default value **21**;
- **tempSettings** - **number** with default value **21**;
- **adjustTemp** - **function** which takes **no arguments**. If temp is less than **tempSettings**, this function adds 1 to **temp**. 
  If **temp** is more than **tempSettings**, it decreases **temp** by 1. If **temp** and **tempSettings** are equal, the function does nothing.

**hasAudio** - compose audio player functionality into the passed-in object. This function takes an **object as a parameter** and adds to it the following properties:

- **currentTrack** - **object** with properties **name** (string) and **artist** (string). The default value is **null**;
- **nowPlaying** - **function**, which **prints** on the console the text:

  **\`Now playing '${currentTrack.name}' by ${currentTrack.artist}`** , where **name** and **artist** are properties of the **currentTrack** object. 
  If **currentTrack** is **null**, this function does nothing.

**hasParktronic** - compose parking aid functionality into the passed in object. This function takes an **object as a parameter** and 
adds to it the following properties:

- **checkDistance** - **function**, which takes a **single argument distance** (number) and **prints** a message on the console, depending on its value:

**distance** < 0.1 - **"Beep! Beep! Beep!"**

0.1 <= **distance** < 0.25 - **"Beep! Beep!"**

0.25 <= **distance** < 0.5 - **"Beep!"**

In any other case, print an **empty string**.

### Input

Your **solution** will receive **no arguments**. All the methods in the returned library must take an **object as an argument**. 
Any methods that you compose into this object must meet the input requirements listed in the description above.

### Output

Your **solution** must **return an object** containing the **three decorators** described above.

### Example

| **Setup** |
| --- |
| const assemblyLine = createAssemblyLine(); |
| <br>                                       |
| const myCar = {                            |
| &nbsp;&nbsp; make: 'Toyota',               |
| &nbsp;&nbsp; model: 'Avensis'              |
| };                                         |

| **Input** | **Output** |
| --- | --- |
| assemblyLine.hasClima(myCar); | 21 |
| console.log(myCar.temp);      | 20 |
| myCar.tempSettings = 18;      |    |
| myCar.adjustTemp();           |    |
| console.log(myCar.temp);      |    |
| **Input** | **Output** |
| assemblyLine.hasAudio(myCar);                 | Now playing 'Never Gonna Give You Up' by Rick Astley |
| myCar.currentTrack = {                        |                                                      |
| &nbsp;&nbsp; name: 'Never Gonna Give You Up', |                                                      |
| &nbsp;&nbsp; artist: 'Rick Astley'            |                                                      |
| };                                            |                                                      |
| myCar.nowPlaying();                           |                                                      |
| **Input** | **Output** |
| assemblyLine.hasParktronic(myCar); | Beep!       |
| myCar.checkDistance(0.4);          | Beep! Beep! |
| myCar.checkDistance(0.2);          |             |
| **Input** | **Output** |
| console.log(myCar); | {                                                         |
|                     | &nbsp;&nbsp; make: 'Toyota',                              |
|                     | &nbsp;&nbsp; model: 'Avensis',                            |
|                     | &nbsp;&nbsp; temp: 20,                                    |
|                     | &nbsp;&nbsp; tempSettings: 18,                            |
|                     | &nbsp;&nbsp; adjustTemp: \[Function],                     |
|                     | &nbsp;&nbsp; currentTrack: {                              |
|                     | &nbsp;&nbsp;&nbsp;&nbsp; name: 'Never Gonna Give You Up', |
|                     | &nbsp;&nbsp;&nbsp;&nbsp; artist: 'Rick Astley'            |
|                     | &nbsp;&nbsp; },                                           |
|                     | &nbsp; nowPlaying: \[Function],                           |
|                     | &nbsp; checkDistance: \[Function]                         |
|                     | }                                                         |

# 6.	From JSON to HTML Table

You're tasked with creating an HTML table of students and their scores. You will receive a single string representing an **array of objects**, 
the **table's headings** should be equal to the **object's keys**, while **each object's values** should be a **new entry** in the table. 
Any **text values** in an object should be **escaped**, to avoid introducing dangerous code into the HTML.

### Input

The **input** comes with a **single string argument** (the array of objects).

### Output

The **output** should be printed on the console - for each **entry** **row** in the input print the **object** **representing** **it**.

### HTML

You are provided with an HTML file to test your table in the browser.

| **index.html** |
| --- |
| \<!DOCTYPE html>                                                                                                                                                                                              |
| \<html lang="en">                                                                                                                                                                                             |
| \<head>                                                                                                                                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; \<meta charset="UTF-8">                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp; \<title>FromJSONToHTMLTable</title>                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp; \<style>                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; table,th{                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; border: groove;                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; border-collapse: collapse;                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                |           
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; td{                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; border: 1px solid black;                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; td,th{                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; padding: 5px;                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp; \</style>                                                                                                                                                                            |
| \</head>                                                                                                                                                                                                      |
| \<body>                                                                                                                                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp; \<div id="wrapper">                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp; \</div>                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp; \<script>                                                                                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; function fromJSONToHTMLTable(input){                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; //Write your code here                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp; window.onload = function(){                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; let container = document.getElementById('wrapper');                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; container.innerHTML = fromJSONToHTMLTable(\['\[{"Name":"Stamat","Price":5.5},{"Name":"Rumen","Price":6}]']); |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; };                                                                                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp; \</script>                                                                                                                                                                           |
| \</body>                                                                                                                                                                                                      |
| \</html>                                                                                                                                                                                                      |

### Example

| **Input** | **Output** |
| --- | --- |
| `\[{"Name":"Stamat", | \<table>                                   |
|     "Score":5.5},    | \<tr>\<th>Name\</th>\<th>Score\</th>\</tr> |
|    {"Name":"Rumen",  | \<tr>\<td>Stamat\</td>\<td>5.5\</td>\</tr> |
|     "Score":6}]`     | \<tr>\<td>Rumen\</td>\<td>6\</td>\</tr>    |
|                      | \</table>                                  |
| **Input** | **Output** |
| `[{"Name":"Pesho",  | \<table>                                                   |
|     "Score":4,      | \<tr>\<th>Name\</th>\<th>Score\</th>\<th>Grade\</th>\</tr> |
|     " Grade":8},    | \<tr>\<td>Pesho\</td>\<td>4\</td>\<td>8\</td>\</tr>        |
|    {"Name":"Gosho", | \<tr>\<td>Gosho\</td>\<td>5\</td>\<td>8\</td>\</tr>        |
|     "Score":5,      | \<tr>\<td>Angel\</td>\<td>5.5\</td>\<td>10\</td>\</tr>     |
|     " Grade":8},    | \</table>                                                  |
|    {"Name":"Angel", |                                                            |
|     "Score":5.50,   |                                                            |
|     " Grade":10}]`  |                                                            |
