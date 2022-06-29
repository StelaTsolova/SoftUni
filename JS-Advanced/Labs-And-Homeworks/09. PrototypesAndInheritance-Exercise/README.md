# 1. Array Extension

Extend the built-in **Array** object with additional functionality. Implement the following functionality:

- **last()** - returns the last element of the array
- **skip(n)** - returns a new array which includes all original elements, except the first **n** elements; **n** is a **Number** parameter
- **take(n)** - returns a new array containing the first **n** elements from the original array; **n** is a **Number** parameter
- **sum()** - returns a sum of all array elements
- **average()** - returns the average of all array elements

### Input / Output

**Input** for functions that expect it will be passed as valid parameters. Output from functions should be their **return** value.

### Constraints

Structure your code as an **IIFE**.

# 2. String Extension

**Extend** the built-in String object with additional functionality. Implement the following functions:

- **ensureStart(str)** - if the current string doesn't start with the **str**parameter, return a new string in which **str** parameter **appended** to 
  the **beginning of the current string**, otherwise returns the **original string**
- **ensureEnd(str)** - if the current string doesn't end with **str** parameter, return a new stringin which **str** parameter **appended** to 
  the **end of the current string**, otherwise returns the **original string**
- **isEmpty()** - return **true** if the string is **empty** and **false** otherwise
- **truncate(n)** - returns the string truncated to **n** characters by **removing words** and appends an ellipsis (three periods) to the end. 
  If a string is less than **n** characters long, return the **same string**. If it is longer, split the string where a **space** occurs and append an ellipsis to 
  it so that the **total length** is less than or equal to **n**. If **no space** occurs anywhere in the string, return **n - 3** characters and an ellipsis. 
  If **n** is less than 4, return **n** amount of periods.
- **format(string, ...params)** - static method to replace placeholders with parameters. A placeholder is a number surrounded by curly braces. 
  If parameter index cannot be found for a certain placeholder, do not modify it. Note static methods are attached to the **String object** instead of its prototype. 
  See the examples for more info.

Note strings are **immutable**, so your functions will return new strings as a result.

### Input / Output

Your **main code** should be structured as an IIFE **without** input or output - it should modify the existing **String prototype** instead.

Input and output of the **extension functions** should be as described above.

### Example

| **Sample input** | **Value of str** |
| --- | --- |
| let str = 'my string';                                    | 'my string'       // 'my' already present |
| str = str.ensureStart('my');                              | 'hello my string'                         |
| str = str.ensureStart('hello ');                          | 'hello my string' // length is 15         |
| str = str.truncate(16);                                   | 'hello my...'     // length is 11         |
| str = str.truncate(14);                                   | 'hello...'                                |
| str = str.truncate(8);                                    | 'h...'                                    |
| str = str.truncate(4);                                    | '..'                                      |
| str = str.truncate(2);                                    | 'The quick brown fox'                     |
| str = String.format('The {0} {1} fox', 'quick', 'brown'); | 'jumps dog {1}'   // no parameter at 1    |
| str = String.format('jumps {0} {1}', 'dog');              |                                           |

# 3. Extensible Object

Create an object that can **clone** the **functionality** of another object into itself. Implement an extend(template) function that would copy all of 
the properties of the **template** to the parent object and if the property is a function, add it to the object's **prototype** instead.

### Input / Output

Your code should **return** the extensible **object instance**. The extend() function of your object will receive a valid object as an **input parameter** and 
has **no** output.

### Example

| **Sample execution** | **Result** |
| --- | --- |
| function extensibleObject() {     | myObj: {                             |
| &nbsp;&nbsp; //TODO:              | &nbsp;&nbsp; \_\_proto__: {}         |
| }                                 | &nbsp;&nbsp; extend: function () {…} |
| const myObj = extensibleObject(); |                                      |
| **Sample execution** | **Result** |
| const template = {                            | myObj: {                                    |
| &nbsp;&nbsp; extensionMethod: function () {}, | &nbsp;&nbsp; \_\_proto__: {}                 |
| &nbsp;&nbsp; extensionProperty: 'someString'  | &nbsp;&nbsp; extensionMethod: function () {} |
| }                                             | },                                          |
| myObj.extend(template);                       | &nbsp;&nbsp; extend: function () {},         | 
|                                               | &nbsp;&nbsp; extensionProperty: 'someString' |
|                                               | }                                           |

Note that **\_\_proto__** is a hidden property, representing the object's **prototype** - depending on your test environment, you may not have access to it directly, 
but you can use other functions to do that.

# 4. Balloons

You have been tasked to create several classes for balloons.

Implement a class **Balloon**, which is initialized with a **color** (String) and **hasWeight** (Number). These two arguments should be **public members**.

Implement another class **PartyBalloon**, which inherits the Balloon class and is initialized with **2 additional parameters** - **ribbonColor (String)** and 
**ribbonLength** (Number).\
The **PartyBalloon** class should have a **property ribbon**, which is an object with **color** and **length** - the ones given upon initialization. 
The ribbon property should have a **getter**.

Implement another class **BirthdayBalloon**, which inherits the **PartyBalloon** class and is initialized with **1 extra parameter** - **text** (String). 
The **text** should be a property and should have a **getter**.

### Example

| **Sample execution** | **Result** |
| --- | --- |
| let classes = solution();                                                      | Balloon {color: 'yellow', hasWeight: 20.5}                                               |
| let testBalloon = new classes.Balloon("yellow", 20.5);                         | PartyBalloon {color: 'yellow', hasWeight: 20.5, \_ribbon: {color: 'red', length: 10.25}} |
| let testPartyBalloon = new classes.PartyBalloon("yellow", 20.5, "red", 10.25); | {color: 'red', length: 10.25}                                                            |
| let ribbon = testPartyBalloon.ribbon;                                          |                                                                                          |
| console.log(testBalloon);                                                      |                                                                                          |
| console.log(testPartyBalloon);                                                 |                                                                                          |
| console.log(ribbon);                                                           |                                                                                          |

# 5. People

Define several classes, that represent a company's employee records. Every employee has a **name** and **age**, a **salary,** and a list of **tasks**, 
while every position has specific properties not present in the others. Place all common functionality in a **parent abstract** class. Follow the diagram below:

![image](https://user-images.githubusercontent.com/87463484/176513246-5043dafd-b4a7-4f92-8064-d0cc36fac148.png)

Every position has different tasks. In addition to all common properties, the manager position has a **dividend** he can collect along with his salary.

All employees have a **work()** function that when called cycles through the list of responsibilities for that position and prints the current one. 
When all tasks have been printed, the list starts over from the beginning. Employees can also **collect salary**, which outputs the amount, plus any **bonuses**.

Your program needs to expose a module, containing the three classes **Employee**, **Junior**, **Senior**, and **Manager**. 
The property's **name** and **age** are set through the constructor, while the **salary** and a manager's dividend are initially set to zero and can be changed later.
The list of tasks is filled by each position. The resulting objects also expose the functions **work()** and **collectSalary()**. 
When **work()** is called, one of the following lines is printed on the console, depending on the current task in the list:

**"{employee name} is working on a simple task."**\
**"{employee name} is working on a complicated task."**\
**"{employee name} is taking time off work."**\
**"{employee name} is supervising junior workers."**\
**"{employee name} scheduled a meeting."**\
**"{employee name} is preparing a quarterly report."**

And when **collectSalary()** is called, print the following:

**"{employee name} received {salary + bonuses} this month."**

### Input / Output

Any input will be passed as valid arguments, where applicable. Print any output that is required to the console as a **string**.

### Example

| **Sample execution** | **Result** |
| --- | --- |
| const classes = solution ();                    |                                        |
| const junior = new classes.Junior('Ivan',25);   |                                        |
| <br>                                            |                                        | 
| junior.work();                                  | Ivan is working on a simple task.      |
| junior.work();                                  | Ivan is working on a simple task.      |
| <br>                                            |                                        |
| junior.salary = 5811;                           |                                        |
| junior.collectSalary();                         | Ivan received 5811 this month.         |
| <br>                                            |                                        |
| const sinior = new classes.Senior('Alex', 31);  |                                        |
| <br>                                            |                                        |
| sinior.work();                                  | Alex is working on a complicated task. |
| sinior.work();                                  | Alex is taking time off work.          |
| sinior.work();                                  | Alex is supervising junior workers.    |
| sinior.work();                                  | Alex is working on a complicated task. |
| <br>                                            |                                        |
| sinior.salary = 12050;                          |                                        |
| sinior.collectSalary();                         | Alex received 12050 this month.        |
| <br>                                            |                                        |
| const manager = new classes.Manager('Tom', 55); |                                        |
| <br>                                            |                                        |
| manager.salary = 15000;                         |                                        |
| manager.collectSalary();                        | Tom received 15000 this month.         |
| manager.dividend = 2500;                        |                                        |
| manager.collectSalary();                        | Tom received 17500 this month.         |

# 6. Posts

You need to create several classes for **Posts**.

Implement the following classes:

- **Post**, which is initialized with the **title** (String) and **content** (String)
  - The **2** arguments should be **public members**
  - The **Post** class should also have **toString()** function which returns the following result:

**"Post: {postTitle}"**\
**"Content: {postContent}"**

- **SocialMediaPost**, which inherits the Post class and should be initialized with **2 additional arguments - likes** (Number) and **dislikes** (Number). 
  The class should hold:
  - **comments** (Strings) -  an array of strings
  - **addComment** (comment) - a function, which **adds** commentsto that array
  - The class should extend the **toString()** function of the **Post** class, and should return the following result:

**"Post: {postTitle}"**\
**"Content: {postContent}"**\
**"Rating: {postLikes - postDislikes}"**\
**"Comments:"**\
**" * {comment1}"**\
**" * {comment2}"**\
**. . .**

In case **there are no comments**, return information only about the **title**, **content,** and **rating** of the **post**.

- BlogPost, which inherits the **Post** class:
  - The **BlogPost** class should be initialized with **1 additional argument - views** (Number).
  - The **BlogPost** class should hold

- **view()** - which **increments** the **views** of the object with **1**, every time it is called. The function should **return the object** so that 
  **chaining is supported**.
  - The **BlogPost** class should extend the **toString()** function of the **Post** class, and should return the following result:

**"Post: {postTitle}"**\
**"Content: {postContent}"**\
**"Views: {postViews}"**

### Example

| **posts.js** | 
| --- | 
| const classes = solution();                                                |
| let post = new classes.Post("Post", "Content");                            |
| <br>                                                                       |
| console.log(post.toString());                                              |
| <br>                                                                       |
| // Post: Post                                                              |
| // Content: Content                                                        |
| <br>                                                                       |
| let scm = new classes.SocialMediaPost("TestTitle", "TestContent", 25, 30); |
| <br>                                                                       |
| scm.addComment("Good post");                                               |
| scm.addComment("Very good post");                                          |
| scm.addComment("Wow!");                                                    |
| <br>                                                                       |
| console.log(scm.toString());                                               |
| <br>                                                                       |
| // Post: TestTitle                                                         |
| // Content: TestContent                                                    |
| // Rating: -5                                                              |
| // Comments:                                                               |
| //  * Good post                                                            |
| //  * Very good post                                                       |
| //  * Wow!                                                                 |
