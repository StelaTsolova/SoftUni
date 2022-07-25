# 1. SoftForum

This task is to write functionality for a public forum. This app doesn't need any registration. Every user is able to read and write in the forum, 
and by creating a post or topic, the user should write also his/her own name.

![image](https://user-images.githubusercontent.com/87463484/180867320-c08a9cf4-c3c4-422b-a792-e4bd5c48e8fb.png)

### Creating topic with post

On the home page there are all topics visible. Also there is a form for creating a new topic with a title, username and post (comment) in it. 
The button "Post" should create the new topic if all the fields are correctly filled up (and cleans up the input fields after that). 
The button "Cancel" only clears all the input fields, without sending any request to the server.

Use this URL to create topics: **http://localhost:3030/jsonstore/collections/myboard/posts**

![image](https://user-images.githubusercontent.com/87463484/180867389-216da3ff-a4c4-4893-840c-ae8f8648a86c.png)

### Comment on Topic

When the user selects a topic by clicking on it, the app should redirect to a page with all posts (comments) for the selected topic and a form for creating new post (comment).

The structure for the post should be as the following:

![image](https://user-images.githubusercontent.com/87463484/180867414-563f9605-4f56-416a-9c25-a3b31ccf8d48.png)

After typing in the comment and sending the POST request to the server the page should render updated view with the new post.

![image](https://user-images.githubusercontent.com/87463484/180867472-5713ba9c-374d-4605-a307-0166ed37552d.png)

You can use this URL: **http://localhost:3030/jsonstore/collections/myboard/comments**

![image](https://user-images.githubusercontent.com/87463484/180867538-0255a22a-0f37-47ca-879e-e6176c298269.png)

![image](https://user-images.githubusercontent.com/87463484/180867567-13c96313-4cf8-4c14-9873-5c34d6828079.png)

# 2. Movies - SPA

You are assigned to implement a **Single Page Web Application**. The app keeps **users** and **movies**. Logged-in users should be able to view **add movies** and 
**like movies**. Logged-in users should also be able to **edit** or **delete** the movies **they have added**.

**REST Service**

You can use the provided server to store your data. Use the following endpoints:

- Get all movies: **/data/movies** (GET)
- Create movie: **/data/movies** (POST)
- Update movie: **/data/movies/:id** (PUT)
- Delete movie: **/data/movies/:id** (DELETE)
- Get number of likes for a movie: **/data/likes?where=movieId%3D%22{movieId}%22&distinct=\_ownerId&count** (GET)
- Get like for a movie from specific user: **/data/likes?where=movieId%3D%22{movieId}%22%20and%20_ownerId%3D%22{userId}%22** (GET)
- Add a like: **/data/likes** (POST)
- Revoke a like: **/data/likes/:id** (DELETE)

Note that the provided service automatically limits the number of results from every request to 10. You may need to use pagination options, to get all entries.

**HTML and CSS**

You have been given the web design of the application as **HTML** + **CSS** files. Initially all views and forms are shown by the HTML. 
Your application may **hide/show elements** by CSS (display: none) or **delete/reattach** from and to the DOM all unneeded elements, 
or just display the views it needs to display.

**Important**: Don't change the elements' **class names** and **ids**. Don't rename form fields/link/ids. You are **allowed** to add **data attributes** to any 
elements. You may modify **href attributes** of links and add **action/method attributes** to **forms**.

### Navigation Bar

Navigation links should correctly change the current page (view).

- Clicking on the links in the **NavBar** should display the view behind the navigation link.
- Your application may **hide**/**show elements** by CSS (**display: none**) or **delete/reattach** from and to the DOM all unneeded elements, 
  or just display the views it needs to display.
- **The Logged-in** user navbar should contain the following elements:\[**Movies**] a **link** to the **Home page**, the user caption ("Welcome, {**email**}"), 
  \[**Logout**]. Each link navigates to the named page.
  ![image](https://user-images.githubusercontent.com/87463484/180868156-8d7820c9-0fb1-4626-ae30-682946bc4f18.png)
- The guest users navbar should contain the following elements: : \[**Movies**] which is a **link** to the **Home page** and \[**Login**], \[**Register**].
  ![image](https://user-images.githubusercontent.com/87463484/180868197-bd6e0bbf-06dc-4c28-ae74-a4fb2f868374.png)

### Register User

By given **email** and **password,** the app should register a new user in the system.

- The following validations should be made:
  - The **email** input must be **filled**
  - The **password** should be **at least 6 characters** long
  - The **repeat password** should be **equal to the password**

- After a **successful registration** the app should **redirect** to the **home page with the right navbar**.

- In case of **error** (eg. invalid username/password), an appropriate error **message** should be displayed, and the user should be able to **try** to register again.

- Keep the user data in the browser's **session or local storage**.

- After a **successful registration** redirect to **Home page.**

![image](https://user-images.githubusercontent.com/87463484/180868402-a5af175b-f2e5-41ba-a644-b3253fdd8413.png)

### Login User

By given **username** and **password,** the app should login an existing user.

- After a **successful login** the user **home page should be displayed**.
- In case of **error**, an appropriate error **message** should be displayed and the user should be able to fill in the login form again.
- Keep the user data in the browser's **session or locale storage**.
- After a **successful login** redirect to **Home page.**

![image](https://user-images.githubusercontent.com/87463484/180868491-9f30ff1f-da7f-4f15-89b7-c59902f081cb.png)

### Logout

Successfully logged in users should be able to **logout** from the app.

- After a **successful** logout the **anonymous screen** should be shown
- The **"logout" REST service** at the back-end  **must** be called at logout
- All local information in the browser (**user session data**) about the current user should be deleted
- After a **successful logout** redirect to **Login page.**

### Home Page

Users should be welcomed by the **Home page**. They should be able to see all added movies:

![image](https://user-images.githubusercontent.com/87463484/180868729-2c1eca9e-bc04-4c22-a14b-b41fad4e0c62.png)

\[**Add Movie**] **button** should refer to the **add movie form**. It should only be visible if there is a logged-in user.

### Add Movie

Logged-in users should be able to **add movie**.

Clicking the \[**Add Movie**] **button** in the **Home page** should **display** the Add Movie page.

- The form should contain the following validations:
  - The **title, description and image** shouldn't be **empty**. 
  - After a **successful** movie adding the Home pageshould be shown.

- The newly added movie should be stored in the database collection "movies".

![image](https://user-images.githubusercontent.com/87463484/180868937-7432a1d6-f3ef-4bf2-97f8-a55153b72123.png)

Trying to submit empty feelds should **NOT** be possible.

### Movie Details

Logged-in users should be able to **view details** aboutmovies.

Clicking the \[**Details**] **button** of a **particular movie** should **display** the Movie Details page.

- If the currently logged-in user is the creator of the movie, the \[**Delete**] and \[**Edit**] **buttons** should be shown, otherwise show the \[**Like**] button.
- When displaying the number of likes a movies has, make sure to only count each user once!

![image](https://user-images.githubusercontent.com/87463484/180869076-156e02ab-e3c7-428f-9a39-329966142f0f.png)

![image](https://user-images.githubusercontent.com/87463484/180869090-8025058e-ee13-456e-a7c8-e01ecb826611.png)

### Edit Movie

Logged-in users should be able to **edit** movies, added by them.

Clicking the \[**Edit**] **button** of a **particular movie** on the Movie Details page should **display** the Edit Movie page inserting the additional 
information of the movie in the input feelds:

![image](https://user-images.githubusercontent.com/87463484/180869164-685a6773-a51c-426c-b2fb-3e3875dd9ff4.png)

- After a **successful edit** the user should be redirected to the current movie Details page.

### Like Movie

Logged-in users should be able to **like** movie, added by **other user**.

**NOTE**: A user should **NOT** be able to like a **movie**, created by **himself**.

Clicking the [Like] **button** of an **movie** (on the **Movie Details page**) should **make a POST request to the following URL: http://localhost:3030/data/likes  
with body { movieId: id } ( id - this is the id to the current movie )** . After **successfully like**:

- \[**Like**] **button** changes to \[**Liked {number of likes}**] **span so** users can't **like a movie** multiple times.

![image](https://user-images.githubusercontent.com/87463484/180869453-78f6f729-9209-4ebe-a2c9-0ff110b61d2d.png) ![image](https://user-images.githubusercontent.com/87463484/180869473-fcb5bdfb-eda8-43e8-b6a0-fe14420b5165.png)

### Delete Movie

Logged-in users should be able to **delete their** movies.

Clicking the \[**Delete**] **button** of an **movie** (on the **Movie Details page**) should **delete** the **movie**.

After **successful movie delete** the **Home page** should be **shown**
