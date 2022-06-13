# 1. List of Items

Write a function that **reads** the text inside an input field and **appends** the specified text to a list inside an HTML page.

### Example

![image](https://user-images.githubusercontent.com/87463484/173429098-79e9db66-cfe6-4f2a-8b44-5fc72e298d86.png) 

![image](https://user-images.githubusercontent.com/87463484/173429223-28892c07-2b2c-48a4-9f5d-1513c723c9f9.png)

![image](https://user-images.githubusercontent.com/87463484/173429364-b4960c10-50a2-482a-a1f9-5b2c6bbb433b.png)

# 2. Delete from Table

Write a program that **takes** an **email** from an **input field** and **deletes** the matching row from a table.

- If entry is found, the **textContent** in the element with **id="result"** must be set to **"Deleted"**.
- Otherwise, an **error** should be displayed in a **\<div>** with **id="result"**. The error should be **"Not found"**.

Submit **only** the **deleteByEmail()** function in Judge.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.
  
### Example  

![image](https://user-images.githubusercontent.com/87463484/173429542-8d52c8a2-3a9b-4721-bb33-72c9ba8f33c5.png)

![image](https://user-images.githubusercontent.com/87463484/173429560-f4d531dd-25e1-4d3b-94eb-54bafcb114cf.png)

# 3. Add / Delete

Extend the previous problem to display **a \[Delete] link** after each list item. **Clicking** it should **delete** the item with no confirmation. 
You have to add **href="#"** to the link element.

### Example

![image](https://user-images.githubusercontent.com/87463484/173429657-b97ec84d-d8c5-450f-a5c8-e0b3dfd6dca8.png) **->** ![image](https://user-images.githubusercontent.com/87463484/173429685-e3bd0ab9-8391-42ea-88ed-b622e1df4217.png)

# 4. Mouse Gradient

Write  a program that **detects** and **displays** how far along a gradient the user has **moved** their **mouse**. 
The result should be **rounded down** and displayed as a **percentage** inside the **\<div>** with id "**result**".

Submit **only** the **attachGradientEvents()** function in Judge.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/173429776-704deca5-a847-4e8f-a21d-5b3b086a62de.png)

# 5. Highlight Active

Write a **function** that **highlights** the **currently active** section of a document. There will be **multiple** divs with **input fields** inside them. 
Set the **class** of the **div** that contains the **currently focused** input field to "**focused**". 
When the focus is lost (**blurred**), **remove the class** from the element.

Submit only the **focused()** function in Judge.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/173429860-d0c982b2-fc8d-4de7-85e6-0115f8d4a435.png) **->** ![image](https://user-images.githubusercontent.com/87463484/173429880-9a45549d-b3a0-494a-9ecd-c8f9e9ea9be9.png)

# 6. Dynamic Validation

Write a **function** that **dynamically validates** an **email** input field when it is **changed**. If the input is **invalid**, apply the class "**error**". 
Do **not** validate on every keystroke, as it is annoying for the user, consider only **change** events.

A valid email is considered to be in the format: **\<name>@\<domain>.\<extension>**

Only **lowercase Latin characters** are allowed for any of the parts of the email. If the input is valid, **clear** the style. 
Submit **only** the **validate()** function in Judge.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.
  
### Example

![image](https://user-images.githubusercontent.com/87463484/173429999-b3a0b709-f9dc-4316-9026-d4ff58ece884.png) **->** ![image](https://user-images.githubusercontent.com/87463484/173430017-7459e401-d4fa-4d3d-a8be-1cd917a77f13.png)

# 7.	Shopping Cart

You will be given some products that you should be able to add to your cart. Each product will have a **name**, **pictur**, and **price**.

When the **"Add"** button is clicked, append the current product to the **textarea** in the following format: 
**"Added {name} for {money} to the cart.\n"**. The price must be fixed to the second digit.

When the button **"Checkout"** is clicked, calculate the **total money** that you need to pay for the products that are currently in your cart. 
Append the result to the **textarea** in the following format:

**"You bought {list} for {totalPrice}."**

The list should contain only the **unique products**, separated by **", "**. The total price should be rounded to the second decimal point.

Also, after clicking over "**Checkout**" and every from above is done you should **disable all buttons**. 
(You **can't** add products or checkout again if once the checkout button is clicked).

### Example

![image](https://user-images.githubusercontent.com/87463484/173430350-44f3b541-b383-482d-aa1b-cfbc1008a3c1.png)
