# 1. Sections

You will receive an **array** of strings. For each string, create a **div** with a **paragraph** with the **string** in it. 
Each paragraph is initially **hidden (display:none)**. Add a **click event listener** to **each div** that **displays** the **hidden** paragraph. 
Finally, you should **append** all divs to the element with an **id "content**".

### Example

![image](https://user-images.githubusercontent.com/87463484/172585619-48a5e659-b5aa-414e-b606-f6023586c66c.png) **->** ![image](https://user-images.githubusercontent.com/87463484/172585660-6587759b-5337-40ec-8607-43aa60dc00cd.png)

# 2. Time Converter

Create a program that **converts** different time units. Your task is to add a **click** event listener to **all \[CONVERT] buttons**. 
When a button is **clicked**, read the **corresponding** input field, **convert** the value to the **three other** time units and **display** it in the input fields.

### Example

![image](https://user-images.githubusercontent.com/87463484/172585855-bd8e9b75-eff3-4540-aa8c-66977f720c8b.png)

![image](https://user-images.githubusercontent.com/87463484/172585874-7d4cecb6-765a-4850-9755-f075c128e1e6.png)

One day is equal to 24 hours/1440 minutes/86400 seconds. Whichever button we **click,** the input fields should **change** depending on the added value on the left. 
(For example, if we write 48 hours and click convert the days, the field value should change to 2).

# 3. Locked Profile

In this problem, you should **create a JS functionality** that **shows** and **hides** the additional information about users.

![image](https://user-images.githubusercontent.com/87463484/172586014-646ec45d-70b6-46cb-8fbc-9d54c7581b75.png)

When one of the **\[Show more ] buttons** is clicked, the **hidden information** inside the div should

be shown, only if **the profile is not locked**! If the current profile is **locked**, nothing should happen.

![image](https://user-images.githubusercontent.com/87463484/172586152-2279d658-4616-44dc-b164-dfbf6f6a1de4.png)

If the **hidden information is displayed** and we **lock the profile again**, the \[**Hide it**] button should **not be working**!

Otherwise, when the profile is **unlocked** and we click on the \[**Hide it**] button, the new fields must hide again.

# 4. Fill Dropdown

Your task is to take values from **input** fields with **ids "newItemText"** and **"newItemValue"**. 
Then you should create and append an **\<option>** to the **\<select>** with **id "menu"**.

### Example

![image](https://user-images.githubusercontent.com/87463484/172586483-205e975d-3cb9-4715-a112-7c76082e0c1e.png)

# 5. Encode and Decode Messages

In this problem, you should **create a JS functionality** that **encodes and decodes some messages which travel to the network.**

![image](https://user-images.githubusercontent.com/87463484/172586731-93997b04-328b-4767-99fa-00c9d32ca44a.png)

This program should contain **two functionalities**.

The first one is to **encode the given message** and **send it** to the **receiver**.

The second one is to **decode the received message** and **read it (display it)**.

When the \[**Encode and send it**] **button** is clicked, you should get the given message from the first **textarea**. 
When you get the current message, you should encode it as follows:

- **Change** the **ASCII CODE** on **every single character** in that message when you **add 1** to the current **ASCII NUMBER**, 
  that represents the current character in that message
- **Clear** the **sender textarea** and **add** the encoded message to the **receiver textarea**

![image](https://user-images.githubusercontent.com/87463484/172586874-d042675b-9f7c-4d1f-adea-8d25f17c3fe5.png)

After clicking the \[**Encode and send it**] **button** the result should be:

![image](https://user-images.githubusercontent.com/87463484/172586949-29cc54e7-c32c-4b25-b320-335aca6aa1c3.png)

After that, when the \[**Decode and read it**] **button** is clicked. You need to get the **encoded message** from **the receiver textarea** and 
do the **opposite logic** from encoding:

- **Subtract 1** from the current **ASCII NUMBER**, that represents the current character in that message
- Replace the **encoded message** with the already **decoded message** in the receiver **textarea**, to make it readable

![image](https://user-images.githubusercontent.com/87463484/172587081-0efc0d54-66b8-43a6-9a87-b187d76ee99a.png)

# 6. Furniture

You will be given some furniture as an **array of objects**. Each object will have a name, a price, and a decoration factor.

When the \[**"Generate"**] **button is clicked**, add a **new row to the table** for each piece of furniture with **image, name, price**, 
and **decoration factor** (code example below).

When the \[**"Buy"**] button is clicked, get all **checkboxes that are marked** and show in the **result textbox** the **names** of the piece of furniture that 
**were checked**, separated by a **comma** and **single space** (**", "**) in the following format: **"Bought furniture: {furniture1}, {furniture2}..."**.

On the next line, print the total price in the format: **"Total price: {totalPrice}"** (formatted to the second decimal point). 
Finally, print the average decoration factor in the format: **"Average decoration factor: {decFactor}"**

### Input Example

**\[{"name": "Sofa", "img": "https:\//\res.cloudinary.com\/maisonsdumonde/image/upload/q_auto,f_auto/w_200/img/grey-3-seater-sofa-bed-200-13-0-175521_9.jpg", 
"price": 150, "decFactor": 1.2}]**

### Example

![image](https://user-images.githubusercontent.com/87463484/172587812-3d53056a-a041-4891-87e2-ffc1eb1a7cbe.png)

![image](https://user-images.githubusercontent.com/87463484/172587827-a3f993e3-7822-4216-9e1e-39afd7dfa60d.png)

# 7. Distance Converter *

Your task is to convert from **one** distance unit to **another** by adding a **click** event listener to a button. When it is clicked, 
**read** the value from the input field and **get** the **selected** option from the **input** and **output** units dropdowns. 
Then **calculate** and **display** the converted value in the **disabled** output field.

### Example

![image](https://user-images.githubusercontent.com/87463484/172587911-d0f9ee37-79dd-4313-881b-b69aeff03f99.png)

# 8. Sudomu *

Write a function that implements **SUDOMU** (**Sudoku inside the DOM**).

![image](https://user-images.githubusercontent.com/87463484/172588001-73eee1df-6ad6-41d0-af0a-f86418f47210.png)

The rules are simple and they are **the same** as the **typical sudoku game**. 

If the table is filled with the **right numbers**, and the **\["Quick Check"]** button is **clicked**, the expected result should be:

![image](https://user-images.githubusercontent.com/87463484/172588201-531e26e5-e1b7-4854-8230-a12fba27e5c3.png)

The table borer should be changed to: "**2px solid green**". The **text content** of the **paragraph** inside the **div** with an **id "check"** must be: 
**"You solve it! Congratulations!"**

The text color of that paragraph must be **green**.

Otherwise, when the filled table **does not solve the sudomu**, the result should be:

![image](https://user-images.githubusercontent.com/87463484/172588618-18cee390-0699-4de1-886f-c7bfaa762b71.png)

The table border should be changed to: **"2px solid red"**. The **text content** of the **paragraph** inside the **div** with an **id "check"** must be: 
**"NOP! You are not done yet..."**

The text color of thatparagraph must be **red!**

The **\["Clear"]** button **clears the whole SUDOMU (removes all numbers)** and the **paragraph which contains the messages. It also removes the table border**.

![image](https://user-images.githubusercontent.com/87463484/172588985-c4273dd3-b900-446c-b247-0ed7e9472fbd.png)

# 9. JavaScript Quizz *

Write a function that has the functionality of a quiz. 

![image](https://user-images.githubusercontent.com/87463484/172589048-fae09e9d-4235-4782-8f48-c71c9f7fcd24.png)

Three sections contain **one question and 2 possible answers**.

**The right answer is only one!**

When one of the **list elements is clicked,** the next section **must appear (if any...)**.

After all three questions have been answered, the **results ul** must **appear,** (Use **'none'** and **'block**' to hide and show the question sections), 
and the **results** must be added in the **h1**.

If all questions are answered correctly, you should print the following message:\
**"You are recognized as top JavaScript fan!"**

Otherwise, just print **"You have {rightAnswers} right answers"**.

The right answers are:

- **onclick**
- **JSON.stringify()**
- **A programming API for HTML and XML documents**

![image](https://user-images.githubusercontent.com/87463484/172589274-acbacb0c-f159-4230-b01f-bb1a8d76b950.png)

![image](https://user-images.githubusercontent.com/87463484/172589286-ae648fb5-d4be-4b90-b9d8-ccb9d0899396.png)

![image](https://user-images.githubusercontent.com/87463484/172589301-a91f303c-5631-449b-8020-893e7ed4a26a.png)

![image](https://user-images.githubusercontent.com/87463484/172589315-534d681b-7d64-4325-a0f4-a026e2f0b082.png)

![image](https://user-images.githubusercontent.com/87463484/172589329-a425337f-2479-4374-8ab6-eaa06fdf1da2.png)
