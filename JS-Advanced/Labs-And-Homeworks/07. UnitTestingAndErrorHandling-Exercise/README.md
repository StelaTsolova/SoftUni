# 1. Request Validator

Write a function that **validates** an HTTP request object. The object has the properties method, uri, version, and message. 
Your function will receive **the object as a parameter** and has to **verify** that **each property** meets the following **requirements**:

- **method** - can be **GET, POST, DELETE** or **CONNECT**
- **uri** - must be a valid resource address or an asterisk (**\***); a resource address is a combination of alphanumeric characters and periods; all letters are Latin; 
  the **URI cannot** be an empty string
- **version** - can be **HTTP/0.9, HTTP/1.0, HTTP/1.1** or **HTTP/2.0** supplied as a string
- **message** - may contain **any number** of non-special characters (special characters are **<, >, \, &, ', "**)

If a request is **valid**, return it **unchanged**.

If any part **fails** the check, throw an Error with the message **"Invalid request header: Invalid {Method/URI/Version/Message}"**.

Replace the part in curly braces with the relevant word. Note that some of the **properties may be missing**, in which case the request is **invalid**. 
Check the properties **in the order** in which they are listed above. If **more than** one property is **invalid**, throw an error for the **first** encountered.

### Input / Output

Your function will receive an **object** as a parameter. **Return** the same object or **throw an Error** as described above as an output.

### Example

| **Input** | **Output** |
| --- | --- |
| {                                       | {                                       |
| &nbsp;&nbsp; method: 'GET',             | &nbsp;&nbsp; method: 'GET',             |
| &nbsp;&nbsp; uri: 'svn.public.catalog', | &nbsp;&nbsp; uri: 'svn.public.catalog', |
| &nbsp;&nbsp; version: 'HTTP/1.1',       | &nbsp;&nbsp; version: 'HTTP/1.1',       |
| &nbsp;&nbsp; message: ''                | &nbsp;&nbsp; message: ''                |
| }                                       | }                                       |
| **Input** | **Output** |
| {                                  | Invalid request header: Invalid Method |
| &nbsp;&nbsp; method: 'OPTIONS',    |                                        |
| &nbsp;&nbsp; uri: 'git.master',    |                                        |
| &nbsp;&nbsp; version: 'HTTP/1.1',  |                                        |
| &nbsp;&nbsp; message: '-recursive' |                                        |
| }                                  |                                        |
| **Input** | **Output** |   
| {                                  | Invalid request header: Invalid Version |
| &nbsp;&nbsp; method: 'POST',       |                                         |
| &nbsp;&nbsp; uri: 'home.bash',     |                                         |
| &nbsp;&nbsp; message: 'rm -rf /\*' |                                         |
| }                                  |                                         |
   
Unit Testing
============

You are required to **submit only the unit tests** for the object/function you are testing.

# 2. Even or Odd

You need to write **unit tests** for a function **isOddOrEven()** that checks whether the **length** of a passed string is **even** or **odd**.

If the passed parameter is **NOT** a string **return undefined**. 
If the parameter is a string **return** either **"even"** or **"odd"** based on the **length** of the string.

### JS Code

You are provided with an implementation of the **isOddOrEven()** function:   

| **isOddOrEven.js** | 
| --- |    
| function isOddOrEven(string) {                                           |
| &nbsp;&nbsp;&nbsp; if (typeof(string) !== 'string') {                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return undefined; |
| &nbsp;&nbsp;&nbsp; }                                                     |
| &nbsp;&nbsp;&nbsp; if (string.length % 2 === 0) {                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return "even";    |
| &nbsp;&nbsp;&nbsp; }                                                     |
| <br>                                                                     |
| &nbsp;&nbsp;&nbsp; return "odd";                                         |
| }                                                                        |
   
# 3. Char Lookup

Write **unit tests** for a function that **retrieves a character** at a given **index** from a passed-in **string**.

You are given a function named **lookupChar()**, which has the following functionality:

- **lookupChar(string, index)**- accepts a **string** and an **integer** (the **index** of the char we want to lookup):
  - If the **first parameter** is **NOT a string** or the **second parameter** is **NOT a number** - return undefined.
  - If **both parameters** are of the **correct type** but the value of the **index is incorrect** (bigger than or equal to the string length or a negative number) - 
    **return "Incorrect index"**.
  - If **both parameters** have **correct types** and **values** - **return** the **character at the specified index** in the string.

### JS Code

You are provided with an implementation of the **lookupChar()** function:   
   
| **charLookUp.js** | 
| --- |       
| function lookupChar(string, index) {                                              |
| &nbsp;&nbsp;&nbsp; if (typeof(string) !== 'string' || !Number.isInteger(index)) { |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return undefined;          |
| &nbsp;&nbsp;&nbsp; }                                                              |
| &nbsp;&nbsp;&nbsp; if (string.length <= index || index < 0) {                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return "Incorrect index";  |
| &nbsp;&nbsp;&nbsp; }                                                              |
| <br>                                                                              |
| &nbsp;&nbsp;&nbsp; return string.charAt(index);                                   |
| }                                                                                 |
   
# 4. Math Enforcer   
   
Your task is to test an object named **mathEnforcer**, which should have the following functionality:

- **addFive(num)** - A function that accepts a **single** parameter:
  - If the **parameter** is **NOT a number**, the function should return **undefined**.
  - If the **parameter** is a **number**, **add 5** to it, and **return the result**.

- **subtractTen(num)** - A function that accepts a **single** parameter:
  - If the **parameter** is **NOT a number**, the function should return **undefined**.
  - If the **parameter** is a **number**, **subtract 10** from it, and **return the result**.

- **sum(num1, num2)** - A function that accepts **two** parameters:
  - If **any** of the 2 parameters is **NOT a number**, the function should return **undefined**.
  - If **both** parameters are **numbers**, the function should **return their sum**.

### JS Code

You are provided with an implementation of the **mathEnforcer** object:   
   
| **mathEnforcer.js** | 
| --- |    
| let mathEnforcer = {                                                                                                            |
| &nbsp;&nbsp;&nbsp; addFive: function (num) {                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (typeof(num) !== 'number') {                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return undefined;                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return num + 5;                                                          |
| &nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp; subtractTen: function (num) {                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (typeof(num) !== 'number') {                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return undefined;                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return num - 10;                                                         |
| &nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp; sum: function (num1, num2) {                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return undefined;                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return num1 + num2;                                                      |
| &nbsp;&nbsp;&nbsp; }                                                                                                            |
| };                                                                                                                              |
   
The methods should function correctly for **positive**, **negative**, and **floating-point** numbers. In the case of **floating-point** numbers, 
the result should be considered correct if it is **within 0.01** of the correct value.

### Screenshots

When testing a **more complex** object write a **nested description** for each function:

![image](https://user-images.githubusercontent.com/87463484/174886441-77460b20-e52b-44d6-bbea-284b95fc351f.png)

Your tests will be supplied with a variable named **"mathEnforcer"** which contains the mentioned above logic. All test cases you write should reference this variable.

DOM Error Handling
==================

# 5. Notification

Write a JS function that receives a string **message** and **displays** it inside a div with id "**notification**. The div starts **hidden** and 
when the function is called, **reveal** it. After the user clicks on it, **hide** the div. In the example document, 
a notification is shown when you click on the button \["**Get notified**"].

### Example

![image](https://user-images.githubusercontent.com/87463484/174886797-d35a471e-8a78-491c-97e7-075ae1945dd2.png)

# 6. Dynamic Validation

Write a JS function that dynamically validates an email input field when it is **changed**. If the input is invalid, apply to it the class "**error**".
Do not validate on every keystroke, as it is annoying for the user, consider only **change** events.

A valid email will be in format: **\<name>@\<domain>.\<extension>**

Only lowercase Latin characters are allowed for any of the parts of the email. If the input is valid, clear the style.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/174886908-76869eac-f434-4268-9393-0f856a36fadf.png) **->** ![image](https://user-images.githubusercontent.com/87463484/174886940-d53698c4-ee97-430f-836d-c0c44bbc748b.png)

# 7. Form Validation

You are given the task to write **validation** for the fields of a simple form.

### HTML and JavaScript Code

You are provided a **skeleton** containing the necessary files for your program.

The validations should be as follows:

- The **username** needs to be between **3** and **20** symbols **inclusively** and only **letters** and **numbers** are allowed.
- The **password** and **confirm-password** must be between **5** and **15 inclusively** symbols and only **word characters** are 
  allowed (**letters**, **numbers,** and **_**).
- The **inputs** of the **password** and **confirm-password** field **must match**.
- The **email** field must contain the "**@**" symbol and **at least one "."** (**dot**) after it.

If the **"Is company?"** checkbox is **checked**, the **CompanyInfo** fieldset should become **visible** and the **Company Number** field must also be **validated**, 
if it isn't checked the **Company** fieldset should have the style **"display: none;"** and the **value** of the **Company Number** field shouldn't matter.

- The **Company Number** field must be a number between **1000** and **9999**.
- Use **addEventListener()** function to **attach** an **event listener** for the **"change"** event to the **checkbox**.

Every field with an **incorrect** value when the **\[Submit]** button is **pressed** should have the following style applied **border-color: red;**, alternatively, 
if it's correct it should have style **border: none**;.If there are **required fields** with an incorrect value when the **\[Submit]** button is pressed, 
the **div** with **id="valid"** should become **hidden** (**"display: none;"**), **alternatively** if all fields are correct the **div** should become **visible**.

### Constraints

- **You are NOT allowed to change the HTML or CSS files provided.**

### Screenshots

![image](https://user-images.githubusercontent.com/87463484/174887807-4bf0d374-ae59-4058-a633-395f95906a1d.png)

![image](https://user-images.githubusercontent.com/87463484/174887815-a9f8ba90-1e23-49fd-9d02-c1932ce66a2d.png)

![image](https://user-images.githubusercontent.com/87463484/174887827-d1c1ba4f-0492-45bf-a3be-a6756e55aa7a.png)

![image](https://user-images.githubusercontent.com/87463484/174887835-26dc9f27-1218-417f-8e8c-0a3a97c6fc97.png)  
