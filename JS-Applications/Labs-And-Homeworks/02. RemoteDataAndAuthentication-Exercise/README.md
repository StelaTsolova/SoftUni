# 1. Messenger

Write a JS program that records and displays messages. The user can post a message, supplying a name and content and retrieve all currently recorded messages.

**The url** for the requests - **http://localhost:3030/jsonstore/messenger**

When \[**Send**] **button** is clicked you should create a **new object** and send a **post request** to the given url. Use the following message structure:

**{**\
&nbsp;&nbsp; **author: authorName,**\
&nbsp;&nbsp; **content: msgText,**\
**}**

If you click over \[**Refresh**] **button** you should **get all** messages with **GET request** and display them into the textarea. Use the following message format:

"**{author}: {message}**"

### Examples

![image](https://user-images.githubusercontent.com/87463484/180052772-07470b66-4b92-4c0f-852c-0c831ada517c.png)

![image](https://user-images.githubusercontent.com/87463484/180052821-4d3c01b5-9dda-4a59-8175-84293002685d.png)

# 2.	Phonebook

Write a JS program that can load, create and delete entries from a Phonebook. You will be given an HTML template to which you must bind the needed functionality.

When the **\[Load]** button is clicked, a **GET** request should be made to the server to get all phonebook entries.Each  received entry should be in a **li** inside 
the **ul** with **id="phonebook"** in the following format with text **"\<person>: \<phone>"** and a **\[Delete]** button attached. 
Pressing the **\[Delete]** button should send a **DELETE** request to the server and delete the entry. 
The received response will be an object in the following format:\
**{\<key>:{person:\<person>, phone:\<phone>}, \<key2>:{person:\<person2>, phone:\<phone2>,...}** where **\<key>** is an unique key given by the server and 
**\<person>** and **\<phone>** are the actual values.

When the **\[Create]** button is clicked, a new **POST** request should be made to the server with the information from the Person and Phone textboxes, 
the Person and Phone textboxes should be cleared and the Phonebook should be automatically reloaded (like if the **\[Load]** button was pressed).

The data sent on a POST request should be a valid JSON object, containing properties person and phone. Example format:\
**{**\
&nbsp;&nbsp; **"person": "\<person>",**\
&nbsp;&nbsp; **"phone": "\<phone>"**\
**}**

The **url** to which your program should make requests is:

**http://localhost:3030/jsonstore/phonebook**

**GET** and **POST** requests should go to **http://localhost:3030/jsonstore/phonebook**, while **DELETE** requests should go to 
**http://localhost:3030/jsonstore/phonebook/:key>** , where **:key** is the unique **key** of the entry (you can find out the key from the key property in the **GET** request)

### Screenshots

![image](https://user-images.githubusercontent.com/87463484/180053593-2a80c3aa-fd3d-4d63-aba2-1ead69c0b5f1.png) ![image](https://user-images.githubusercontent.com/87463484/180053607-38022eb9-6af3-47e7-a045-e641c729767c.png)

# 3.	Students

Your task is to implement functionality for creating and listing students from a database. Create a new collection called "**students**",

Each student has:

- **FirstName - string**, non-empty
- **LastName - string**, non-empty
- **FacultyNumber - string of numbers**, non-empty
- **Grade** - number, non-empty

You need to write functionality for creating students. When creating a new student, make sure you name the properties accordingly.

You will also need to extract students. You will be given an **HTML template** with a table in it. Create an **AJAX request** that extracts all the students.

URL for this task: **http://localhost:3030/jsonstore/collections/students**

### Screenshots

![image](https://user-images.githubusercontent.com/87463484/180053861-fa71b7de-d212-40d7-a3a3-633803ad704e.png)

# 4.	Book Library

First task is to "**GET**" all books. To consume the request with **POSTMAN** your **url** should be the **following**: 
**http://localhost:3030/jsonstore/collections/books**

Using the provided skeleton, write the missing functionalities.

Load all books by clicking the button "LOAD ALL BOOKS"

![image](https://user-images.githubusercontent.com/87463484/180053982-bfad034e-553b-4325-b4b9-9374aba45f6c.png)

## Get Book

This functionality is not needed in this task, but you can try it with postman by sending request to "GET" the Book with id:" d953e5fb-a585-4d6b-92d3-ee90697398a0". Send a GET request to this URL:

**http://localhost:3030/jsonstore/collections/books/:id**

## Create Book

Write functionality to create a new book, when the submit button is clicked. Before sending the request be sure the fields are not empty (make validation of the input).
To **create** a book, you have to send a "**POST**" request and the JSON body should be in the **following** format:

**{**\
&nbsp;&nbsp; **"author": "New Author",**\
&nbsp;&nbsp; **"title": "New Title"**\
**}**

## Update Book

By clicking the edit button of a book, change the form like this:

![image](https://user-images.githubusercontent.com/87463484/180054249-ad880fdb-fcf2-4f46-b7cc-7f6da13b6002.png)

The HTTP command "**PUT**" **modifies** an existing HTTP **resource**. The URL is:

**http://localhost:3030/jsonstore/collections/books/:id**

The JSON body should be in the **following** format:

**{**\
&nbsp;&nbsp; **"author": "Changed Author",**\
&nbsp;&nbsp; **"title": "Changed Title"**\
**}**

### Delete Book

By clicking the delete button you have to delete the book, without any confirmation. To delete a book use "**DELETE**" command and send **REQUEST**: 
**\[http://localhost:3030/jsonstore/collections/books/:id]**

# 5.	Fisher Game

Use the provided skeleton and the server.

![image](https://user-images.githubusercontent.com/87463484/180054498-5119572a-8910-4216-9111-4cddc8563542.png)

## Login User

The **Login** page contains a form for existing user authentication. By given **username** and **password,** the app should login an existing user.

- After a **successful login** the **home page should be displayed**.
- In case of **error**, an appropriate error **message** should be displayed and the user should be able to fill in the login form again.
- Keep the user data in the browser's **session or locale storage**.
- Get request: **http://localhost:3030/users/login**

![image](https://user-images.githubusercontent.com/87463484/180054572-4c9a29d5-c369-4352-9f56-f0fa171fc2e1.png)

If the user is not logged in, all the buttons should be disabled except the "LOAD" button.

## Register User

By given **email** and **password,** the app should register a new user in the system.

- In case of **error** (eg. invalid username/password), an appropriate error **message** should be displayed, and the user should be able to **try** to register again.
- Keep the user data in the browser's **session or local storage**.
- After a **successful registration** the **home page should be displayed**.
- Post request: **http://localhost:3030/users/register**

![image](https://user-images.githubusercontent.com/87463484/180054662-61d9d5e6-e198-4cde-b0b2-e80cd3ab4714.png)

### Logout

The logout action is available to **logged-in users**. Send the following **request** to perform logout:

- Get: **http://localhost:3030/users/logout**

Required **headers** are described in the documentation. Upon success, the **REST service** will return an **empty response**. Clear any session information you've stored in browser storage.

If the logout was successful, **redirect** the user to the **Home** page and change the button in navigation.

### Load catches

By clicking it you have to load all the catches from the server and render them like on the picture:

- Pressing the **\[Load]** button should **list all** catches. (For all users)
- Pressing the **\[Update]** button should send a **PUT** request, updating the catch in **http://localhost:3030/data/catches/:id**. 
  (**Only for the creator of the catch**)
- Pressing the **\[Delete]** button should delete the catch from **http://localhost:3030/data/catches/:id**. (**Only for the creator of the catch**)
- Pressing the **\[Add]** button should submit a new catch with the values of the inputs in the fieldset with **id="addFrom"**. (**Only for logged in users**)
- Button **\[Add]** should be **disabled** in there are no **logged in user**.
- Buttons **\[Update]** and **\[Delete]** should be **disabled** if the currently logged-in user is not the **author** of the catch.

![image](https://user-images.githubusercontent.com/87463484/180054932-bb8f2e20-b793-43f2-953a-a86864521881.png)

Each catch should have:

- **angler - string** representing the name of the person who caught the fish
- **weight - floating-point number** representing the weight of the fish in kilograms
- **species - string** representing the name of the fish species
- **location - string** representing the location where the fish was caught
- **bait - string** representing the bait used to catch the fish
- **captureTime - integer number** representing the time needed to catch the fish in minutes

Use the following requests to access your data:

- **List All Catches**
  - Endpoint - **http://localhost:3030/data/catches**
  - Method: **GET**

- **Create a New Catch**
  - Endpoint: **http://localhost:3030/data/catches**
  - Method: **POST**
  - Request body (JSON): **{"angler":"...", "weight":..., "species":"...", "location":"...", "bait":"...", "captureTime":...}**

- **Update a Catch**
  - Endpoint: **http://localhost:3030/data/catches/:catchId**
  - Method: **PUT**
  - Request body (JSON): **{"angler":"...", "weight":..., "species":"...", "location":"...", "bait":"...", "captureTime":...}**

- **Delete a Catch**
  - Endpoint: **http://localhost:3030/data/catches /:catchId**
  - Method: **DELETE**

# 6.	Furniture *

Your task is to write the functionality of app, which shows list of furniture. By logged in user there is a possibility to buy furniture and 
list the bought products of the logged user. Also logged user can create new products (offers).

![image](https://user-images.githubusercontent.com/87463484/180055336-1d6bb7dc-9aa5-4789-94ca-91264ad100f8.png)

## Home page (not logged)

When the page is loaded the app should list all the furnitures in a table:

![image](https://user-images.githubusercontent.com/87463484/180055381-2a7cf0c6-a375-4287-808b-044347bbb7ba.png)

The checkbox should be disabled. You can send GET request on the URL: **http://localhost:3030/data/furniture**

## Auth page

When "Login" is clicked, the app should redirect to "Login page". There are two possibilities:

- to register a new user, send a POST request to the URL: **http://localhost:3030/users/register**
- to login, send a POST request to the URL: **http://localhost:3030/users/login**

![image](https://user-images.githubusercontent.com/87463484/180055446-e442c7fe-7274-4151-86c6-afa048577062.png)

## Home page (logged in)

When the **"Create" button is clicked**, add a **new row to the table** for each piece of furniture with **name, price, factor and img**. 
Send POST request to: **http://localhost:3030/data/furniture**

![image](https://user-images.githubusercontent.com/87463484/180055571-40a2aeea-f0f9-452c-9300-c3959dd99ca3.png)

When the **"Buy"** button is clicked, get all **checkboxes that are marked** and save the information for these orders on the server. 
Make POST request to: **http://localhost:3030/data/orders**

When the "**All orders**" button is clicked, get all bought furniture of the current user, and show their names and the total price, as shown on the picture:

![image](https://user-images.githubusercontent.com/87463484/180055671-eaa62826-b8ee-4e65-9578-b3a8edafab44.png)

This could happen with GET request on this URL: **http://localhost:3030/data/orders?where=_ownerId%3D{userId}**
