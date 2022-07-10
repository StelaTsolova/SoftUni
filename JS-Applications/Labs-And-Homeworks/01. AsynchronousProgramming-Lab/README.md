# 1. XHR (XmlHttpRequest)

Your task is to **write** a JS function that **loads** a github repository **asynchronously with AJAX**. You should **create** an instance of **XmlHttpRequest** and 
attach an **onreadystatechange** event to it. (An EventHandler that is called whenever the readyState attribute changes). Obtain the data by making a GET request to 
the following URL: **https://api.github.com/users/testnakov/repos.** In your event handler, when the **readyState** attribute reaches a value of **4** (it is ready), 
replace the text content of a **div** element with **id "res"** with the value of the **responseText** property of the request. **Do not format** the response in any way.

### Example

![image](https://user-images.githubusercontent.com/87463484/178144465-c1511920-c7bc-4a3d-ae30-97e10f67cb46.png)

![image](https://user-images.githubusercontent.com/87463484/178144467-236f2fd0-fe74-45e1-ad85-62fdc9cb7747.png)

# 2. Github Repos

Your task is to **write** a JS function that **executes** an **AJAX** request with **Fetch API** and loads all user **github repositories** by a given username 
(taken from an input field with **id "username"**) into a **list** (each repository as a **list-item**) with **id "repos"**. 
Use the properties full_name and html_url of the returned objects to create a link to each repo's GitHub page. If an **error** occurs (like 404 "Not Found"), 
**append** to the list a list-item with **text** the current instead. Clear the contents of the list before any new content is appended. 
See the **highlighted lines** of the skeleton for formatting details of each list item.

### Example

![image](https://user-images.githubusercontent.com/87463484/178144509-63b08566-aafc-4e1a-9dba-f4d0943c1354.png)

![image](https://user-images.githubusercontent.com/87463484/178144510-0b879fbd-8a3e-4e29-8256-19e38bb9503e.png)

# 3.	Github Commits

Write a JS program that loads all commit messages and their authors from a github repository using a given HTML.

The **loadCommits()** function should get the **username** and **repository** from the HTML textboxes with IDs **"username"** and 
**"repo"** and make a **GET** request to the **Github API**:\
**https://api.github.com/repos/<username\>/\<repository>/commits**

Swap **\<username>** and **\<repository>** with the ones from the HTML:

- In case of **success**, for **each** entry add a **list item** (**\<li>**) in the **unordered list** (**\<ul>**) with id **"commits"** with text in the following format:

**"\<commit.author.name>: \<commit.message>"**

- In case of an **error**, add a single **list item** (**\<li>**) with text in the following format:\
**"Error: \<error.status> (Not Found)"**

### Screenshots:

![image](https://user-images.githubusercontent.com/87463484/178144628-3e68895d-cfb3-4b31-a997-40cfa23ceda2.png)

![image](https://user-images.githubusercontent.com/87463484/178144632-13bd5d43-407e-4330-ad6e-08bc2b8e5724.png)
