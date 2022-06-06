# 1. Subtraction

An HTML page holds **two text fields** with ids "**firstNumber**" and "**secondNumber**". 
Write a function to **subtract** the values from these text fields and display the result in the **div** named "**result**".

### HTML and JavaScript Code

Implement the aboveto provide the following functionality:

- Your function should take the values of "**firstNumber**" and "**secondNumber**", **convert** them to numbers, 
  **subtract** the first number from the second one and then append the result to the **\<div>** with **id="result"**.
- Your function should be able to work with **any 2 numbers** in the inputs, not only the ones given in the example.
  
### Example

![image](https://user-images.githubusercontent.com/87463484/172236185-acefa1b4-44a7-4cd8-9dce-527b737584e6.png)

# 2. Pascal or Camel Case

An **HTML** file is given and your task is to write a function that takes **two string parameters** as an input and transforms the **first parameter** to 
the type required by the **second parameter**.

- **The first parameter** will be the text that you need to modify depending on the second parameter. The words in it will **always** be **separated by space**.
- **The second parameter** will be either **"Camel Case"** or **"Pascal Case"**. In case of different input, your **output** should be **"Error!"**

When the button is clicked the function should convert the first string to either of the cases. The **output** should consist of only **one word** - 
the string you have modified. Once your **output** is done, you should set it as HTML to the **\<span> element**. For more information, see the examples below:

### Example

| **Input** | **Output** |
| --- | --- |
| "this is an example", "Camel Case" | thisIsAnExample | 
| **Input** | **Output** |
| "secOND eXamPLE", "Pascal Case"	| SecondExample |
| **Input** | **Output** |
| "Invalid Input", "Another Case"	| Error! | 

# 3. Accordion

An **HTML** file is given and your task is to show **more/less** information. By clicking the **\[More] button**, it should **reveal** the content of 
a **hidden** div and **changes** the text of the button to **\[Less]**. When the same link is clicked **again** (now reading **Less**), **hide** the div and 
**change** the text of the link to **More**. Link action should be **toggleable** (you should be able to click the button an infinite amount of times).

### Example

![image](https://user-images.githubusercontent.com/87463484/172236893-65bd0d79-8bbc-4755-a55e-90d1faf064e8.png)

![image](https://user-images.githubusercontent.com/87463484/172236914-a0fa280a-c614-44b1-8b85-6ee798221f46.png)


# 4. Search in List

An HTML page holds a **list** of towns, a **search** box, and a **\[Search]** button. Implement the search function to **bold** and **underline** the items from 
the list which include the text from the **search** box. Also, print the number of items the current search **matches** in the format **\`${matches} matches found`**.

**Note:** It is necessary to clear the results of the previous search.

Write your **JavaScript** code in this file:

| **search.js** |
| --- |
| function search() {              | 
| &nbsp;&nbsp;&nbsp;&nbsp; // TODO | 
| }                                | 

### Screenshots

![image](https://user-images.githubusercontent.com/87463484/172237328-83a84fd9-0abb-4e42-a158-0d735403da3b.png)  ![image](https://user-images.githubusercontent.com/87463484/172237346-cdc75573-3c07-4154-bf42-08e419ad5f3b.png)

# 5. Table - Search Engine

Write a function that **searches** in a **table** by given input.

![image](https://user-images.githubusercontent.com/87463484/172237419-b5de2629-c877-4ce5-a51b-a93abfef13c6.png)

When the "**Search**" **button** is **clicked**, go through all cells in the table except for the first row (Student name, Student email, and Student course) and 
check if the given input has a match (check for both **full words** and **single letters**).

If any of the rows contain the submitted string, add a class select to that row. Note that more than one row may contain the given string.

Оtherwise, if there is no match, **nothing should happen**.

**Note:** After every search ("Search" button is clicked), **clear the input field** and **remove all already selected classes** (if any) from the previous search, 
for the **new search** to contain only the **new result**.

For instance, if we try to find **eva:**

![image](https://user-images.githubusercontent.com/87463484/172237561-2d057c5c-648f-4dfc-afea-dc5d6890efe0.png)

The result should be:

![image](https://user-images.githubusercontent.com/87463484/172237584-99a32444-0911-4035-8774-5a971b71ce3e.png)

If we try to find all students who have email addresses in **softuni** domain, the expected result should be:

![image](https://user-images.githubusercontent.com/87463484/172237622-ae03efbf-e15b-4684-b37a-5a9f405435e9.png)

# 6. Format the Text

**Create a functionality** that gets a text from **textarea**, formats the given **text** - you need to find out how many **sentences** there are in the text, 
simply **split** the whole text by **'.'**\
Also, every sentence must have at **least 1 character**.

![image](https://user-images.githubusercontent.com/87463484/172237715-8a381a37-08c7-4f07-b957-f1240f7bc5c5.png)

Generate HTML paragraphs as a string (Use interpolation **string** to create paragraph element: **\`\<p> {text} \</p>`**) and append it to the div with an **id = "output"**.

![image](https://user-images.githubusercontent.com/87463484/172237864-75ba5109-0641-415b-91d1-cc5a7272a85f.png)

![image](https://user-images.githubusercontent.com/87463484/172237871-2df65836-c036-461b-93ad-5ac5b1010255.png)

When the \[**Format**] button is **clicked**, get the text inside the **textarea** with an **id="input"** and **format it**. The formatting is **done** as **follows:**

- Create a **new paragraph element** that holds no more than **3 sentences** from the given input.
- **Hint: Use interpolation string to create paragraph element. (\`\<p> {text} \</p>`)**
- If the given input contains **less** or **3 sentences**, you need to create only 1 paragraph, fill it with these sentences and append this paragraph to 
  the div with an **id="output"**.

Otherwise, when you have more than 3 sentences, create enough paragraphs to get all sentences from the **textarea**.

Just remember to **restrict** the **sentences** in **each paragraph to 3.**

### Example

- If the input textarea **contains 2 sentences**, create only **1 paragraph** with these 2 sentences

![image](https://user-images.githubusercontent.com/87463484/172238147-87800ec7-4ab5-4cd3-ae41-c90e6d7598db.png)

- If the input textarea **contains 7 sentences,** create **3 paragraphs**
- The **first paragraph** must contain **the first 3 sentences**
- The **second paragraph** must contain **the other three sentences** of the whole text
- The **third paragraph** will contain **only the last sentence**

![image](https://user-images.githubusercontent.com/87463484/172238210-c5b438ef-4176-45bd-b522-38e473404afc.png)

### Output

| **Input** | **Output** |
| --- | --- |
| JavaScript, often abbreviated as JS, is a high-level, interpreted programming language. It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm. | \<p>JavaScript, often abbreviated as JS, is a high-level, interpreted programming language. It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm.\</p> |
| **Input** | **Output** |
| JavaScript, often abbreviated as JS, is a high-level, interpreted programming language. It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm. Alongside HTML and CSS, JavaScript is one of the three core technologies of the World Wide Web. JavaScript enables interactive web pages and thus is an essential part of web applications. The vast majority of websites use it, and all major web browsers have a dedicated JavaScript engine to execute it. As a multi-paradigm language, JavaScript supports event-driven, functional, and imperative (including object-oriented and prototype-based) programming styles. It has an API for working with text, arrays, dates, regular expressions, and basic manipulation of the DOM, but the language itself does not include any I/O, such as networking, storage, or graphics facilities, relying for these upon the host environment in which it is embedded. | \<p>JavaScript, often abbreviated as JS, is a high-level, interpreted programming language.It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm.Alongside HTML and CSS, JavaScript is one of the three core technologies of the World Wide Web.\</p> <br> \<p>JavaScript enables interactive web pages and thus is an essential part of web applications.The vast majority of websites use it, and all major web browsers have a dedicated JavaScript engine to execute it.As a multi-paradigm language, JavaScript supports event-driven, functional, and imperative (including object-oriented and prototype-based) programming styles.\</p> <br> \<p>It has an API for working with text, arrays, dates, regular expressions, and basic manipulation of the DOM, but the language itself does not include any I/O, such as networking, storage, or graphics facilities, relying for these upon the host environment in which it is embedded.\</p> |


# 7. Hell's Kitchen

You will be given an **array of strings**, which represents a **list** of **all** the **restaurants** with their workers.

![image](https://user-images.githubusercontent.com/87463484/172238556-1e416939-c2a7-414d-a2a6-af30bcbecd6e.png)

When the \[**Send**] button is clicked:

- Display the **best restaurant** of all the **added restaurants** with its **average salary** and **best salary**.
- If there is a restaurant in the input array that is added more than once, you need to add new workers to the old ones and **update** the values of 
  the **average salary** and the **best salary**.
- The best restaurant is the restaurant with the **highest average** salary. If two restaurants have the **same** average salary the best restaurant is 
  the **first** one added.
- Display **all** workers in the **best restaurant** with their **salaries**.

The best restaurant's workers should be **sorted** by their **salaries** in **descending** order.

![image](https://user-images.githubusercontent.com/87463484/172238720-cca98373-2749-4eb7-a11d-1300a68c1df8.png)

### Input

The input will be received from the given **textarea** in the form of an **array** of **strings**. Each string represents a **restaurant** with its **workers**: 
**\["Mikes - Steve 1000, Ivan 200, Paul 800", "Fleet - Maria 850, Janet 650"]**

![image](https://user-images.githubusercontent.com/87463484/172238787-d11f784e-5662-4814-8309-ced07aa3850f.png)

![image](https://user-images.githubusercontent.com/87463484/172238796-5532dd32-f03c-4630-8425-e46a46a0dfc8.png)

### Output

- The output contains **two strings**
 o The first one is **the best restaurant** in the format:

**\`Name: {restaurant name} Average Salary: {restaurant avgSalary} Best Salary: {restaurant bestSalary}`**

**avgSalary** and **bestSalary** must be formatted to the **second decimal point.**

 o The second one is all the workers in that restaurant in the following format:

**\`Name: {worker name} With Salary: {worker salary} Name: {worker2 name} With Salary: {worker2 salary} Name: {worker3 name} With Salary: {worker3 salary}...`**

Output strings must be set like **text content** in the following elements:

![image](https://user-images.githubusercontent.com/87463484/172238949-e093109f-0319-43a6-84c2-8e852d195b14.png)

### Constraints

- The workers will be always **unique**

### Example

| **Input** | **Output** |
| --- | --- |
| \["PizzaHut - Peter 500, George 300, Mark 800", "TheLake - Bob 1300, Joe 780, Jane 660"] | Name: TheLake Average Salary: 913.33 Best Salary: 1300.00                          |
|                                                                                          | Name: Bob With Salary: 1300 Name: Joe With Salary: 780 Name: Jane With Salary: 660 |
| **Input** | **Output** |
| \["Mikes - Steve 1000, Ivan 200, Paul 800","Fleet - Maria 850, Janet 650"] | Name: Fleet Average Salary: 750.00 Best Salary: 850.00    |
|                                                                            | Name: Maria With Salary: 850 Name: Janet With Salary: 650 |         
 
# 8. Generate Report

You will be given a **web page**, containing a **table** and **output area**.

![image](https://user-images.githubusercontent.com/87463484/172239602-552a8f48-7676-437e-b265-8480f9aa388c.png)

When the **"Generate Report"** button is **pressed**:

- You must generate a **JSON report** from the data inside the table, by **only taking the columns**, which are **selected**.

Each table header has a **checkbox**. If the checkbox is **checked**, then the data from this column must be included in the **report**. 
**Unchecked** columns must be **omitted**.

![image](https://user-images.githubusercontent.com/87463484/172239682-99611f83-84ab-4ca3-9c14-aab4f25f7807.png)

For **every row** (excluding the header):

- Create an **object** with **properties for each** of its columns.
- The name of each property is the name attribute of the column's header, and the value is the text content of the cell.
- Store the result in an array and output it as a JSON string display it inside the **\<textarea>** with **id "output"**. See the example for details.

![image](https://user-images.githubusercontent.com/87463484/172239791-5fe6c5b9-1b75-4cc4-a08c-94475cd112ee.png)

### Input/Output

There will be input, your program must execute based on the page content. The output must be a **JSON string**, displayed in the **\<textarea>** with **id "output"**.

![image](https://user-images.githubusercontent.com/87463484/172239891-3b904cf6-57b1-4b43-9bce-41d9707c3645.png)

### Example

![image](https://user-images.githubusercontent.com/87463484/172239919-ba8708e3-8a4c-4ff8-94b3-473f4020cd68.png)

# 9. *Number Convertor

Write a functionthat **converts** a **decimal number** to **binary** and **hexadecimal**.

![image](https://user-images.githubusercontent.com/87463484/172240016-77c4b5ad-2deb-4192-81bf-4937f0ae06db.png)

The given number will always be in **decimal format.** The "From" select menu will only have a Decimal option,

but the **"To"** select menu will have **two options**: Binary and **Hexadecimal**.

This means that our program should have the functionality to **convert decimal** to **binary** and **decimal** to **hexadecimal**. 
When you convert to **hexadecimal** it must be **upper case**.

Note that the **"To" select menu** by default is empty. You have to insert the two options (**'Binary'** and **'Hexadecimal'**) inside before continuing. 
Also, they should have **values** ('**binary**' and '**hexadecimal**').

- When the **\[Convert it]** button is **clicked**, the expected result should appear in the **\[Result]** input field.

![image](https://user-images.githubusercontent.com/87463484/172240228-92e246c8-010f-4b23-b15f-c433d9f5fd02.png)

![image](https://user-images.githubusercontent.com/87463484/172240238-9ebb0a76-4f6d-4f64-a887-83308e642d5e.png)
