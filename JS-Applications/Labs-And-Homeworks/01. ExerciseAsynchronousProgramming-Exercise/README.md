# 1. Bus Stop

Write a JS program that displays arrival times for all buses by a given bus stop ID when a button is clicked. Use the skeleton from the provided resources.

When the button with ID **'submit'** is clicked, the name of the bus stop appears and the list bellow gets filled with all the buses that are expected and their time of 
arrival. Take the **value** of the input field with id **'stopId'**. Submit a GET request to http://localhost:3030/jsonstore/bus/businfo/:busId 
(replace the highlighted part with the correct value) and parse the response. You will receive a JSON object in the format:

**stopId: {**\
&nbsp;&nbsp; **name: stopName,**\
&nbsp;&nbsp; **buses: { busId: time, ... }**\
**}**

Place the name property as text inside the div with ID **'stopName'** and each bus as a list item with text:

**"Bus {busId} arrives in {time} minutes"**

Replace all highlighted parts with the relevant value from the response. If the request is not successful, or the information is not in the expected format,
display **"Error"** as **stopName** and nothing in the list. The list should be cleared before every request is sent.

**Note:** The service will respond with valid data to IDs 1287, 1308, 1327 and 2334.

See examples on the next page.

### Example

![image](https://user-images.githubusercontent.com/87463484/178315696-7f4991de-a665-4386-93ac-4d9823cd7ee3.png)

![image](https://user-images.githubusercontent.com/87463484/178315710-b43670b4-ca90-435c-bdf6-34d3bf493b67.png)

When the button is clicked, the results are displayed in the corresponding elements:

![image](https://user-images.githubusercontent.com/87463484/178315731-6cc53637-7937-401f-9980-f700c09760fa.png)

![image](https://user-images.githubusercontent.com/87463484/178315746-2edcfa6d-4827-4caa-839f-6777224e2bfd.png)

If an error occurs, the stop name changes to Error:

![image](https://user-images.githubusercontent.com/87463484/178315770-2f8bd4c0-4c3d-4e55-8abb-2269a02ecc84.png)

![image](https://user-images.githubusercontent.com/87463484/178315785-eca1bbbd-7860-4fd6-9b3e-bc045ed98579.png)

# 2.	Bus Schedule

Write a JS program that tracks the progress of a bus on it's route and announces it inside an info box. The program should display which is the upcoming stop and 
once the bus arrives, to request from the server the name of the next one. Use the skeleton from the provided resources.

The bus has two states - **moving** and **stopped**. When it is **stopped**, only the button "**Depart**" is **enabled**, while the info box shows the name of 
the **current** stop. When it is **moving**, only the button "**Arrive**" is **enabled**, while the info box shows the name of the **upcoming** stop. 
Initially, the info box shows "**Not Connected**" and the "**Arrive**" button is **disabled**. The ID of the first stop is "**depot**".

When the "**Depart**" button is clicked, make a **GET** request to the server with the ID of the current stop to address http://localhost:3030/jsonstore/bus/schedule/:id 
(replace the highlighted part with the relevant value). As a response, you will receive a JSON object in the following format:

**stopId {**\
&nbsp;&nbsp; **name: stopName,**\
&nbsp;&nbsp; **next: nextStopId**\
**}**

Update the info box with the information from the response, disable the "Depart" button and enable the "Arrive" button. 
The info box text should look like this (replace the highlighted part with the relevant value):

**Next stop {stopName}**

When the "**Arrive**" button is clicked, update the text, disable the "Arrive" button and enable the "Depart" button. 
The info box text should look like this (replace the highlighted part with the relevant value):

**Arriving at {stopName}**

Clicking the buttons successfully will cycle through the entire schedule. 
If invalid data is received, show "**Error**" inside the info box and **disable** both buttons.

### Example

Initially, the info box shows "Not Connected" and the arrive button is disabled.

![image](https://user-images.githubusercontent.com/87463484/178316155-5521612b-9717-4d79-83f1-37292156c158.png)

![image](https://user-images.githubusercontent.com/87463484/178316166-9818e47b-da4c-42c5-ad8d-b2129a0bb207.png)

When Depart is clicked, a request is made with the first ID. The info box is updated with the new information and the buttons are changed:

![image](https://user-images.githubusercontent.com/87463484/178316198-03ab19ec-e001-4cc3-944b-4ea8722a2932.png)

![image](https://user-images.githubusercontent.com/87463484/178316206-0db6ea4d-37e4-460e-97b5-773262f300f0.png)

Clicking Arrive, changes the info box and swaps the buttons. This allows Depart to be clicked again, which makes a new request and updates the information:

![image](https://user-images.githubusercontent.com/87463484/178316234-ccf8d620-f86e-43ed-b563-6fbd5a4c8a79.png)

![image](https://user-images.githubusercontent.com/87463484/178316247-efc7cd1b-68fe-4bbb-923b-5b2ba580207d.png)

# 3.	Forecaster

Write a program that **requests** a weather report **from a server** and **displays** it to the user.

Use the skeleton from the provided resources.

When the user writes the name of a location and clicks **"Get Weather"**, make a **GET** request to the server at address 
http://localhost:3030/jsonstore/forecaster/locations. The response will be an array of objects, with the following structure:

**{**\
&nbsp;&nbsp; **name: locationName,**\
&nbsp;&nbsp; **code: locationCode**\
**}**

Find the object, corresponding to the name that the user submitted in the input field with ID "location" and use its **code** value to make **two more GET requests**:

- For current conditions, make a request to:

**http://localhost:3030/jsonstore/forecaster/today/:code**

The response from the server will be an object with the following structure:

**{**\
&nbsp;&nbsp; **name: locationName,**\
&nbsp;&nbsp; **forecast: { low: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **high: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **condition: condition }**\
**}**

- For a 3-day forecast, make a request to:

**http://localhost:3030/jsonstore/forecaster/upcoming/:code**

The response from the server will be an object with the following structure:

**{**\
&nbsp;&nbsp; **name: locationName,**\
&nbsp;&nbsp; **forecast: \[{ low: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **high: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **condition: condition }, ... ]**\
**}**

Use the information from these two objects to compose a forecast in HTML and insert it inside the page. 
Note that the **\<div>** with ID **"forecast"** must be set to visible.See the examples for details.

If an **error** occurs (the server doesn't respond or the location name cannot be found) or the data is not in the correct format, 
display "**Error**" in the **forecast section**.

Use the following codes for weather symbols:

-   Sunny **\&#x2600;** // ☀
-   Partly sunny **\&#x26C5;** // ⛅
-   Overcast **\&#x2601;** // ☁
-   Rain **\&#x2614;** // ☂
-   Degrees **\&#176;** // °

**Examples**

When the app starts, the **forecast div** is **hidden**. When the user **enters a name** and **clicks** on the button**Get Weather**, the requests being.

![image](https://user-images.githubusercontent.com/87463484/178316983-11d8dfa3-8156-470f-b09d-85f128b4460b.png)

![image](https://user-images.githubusercontent.com/87463484/178316991-1db38075-7666-4112-8ee3-243936f029a9.png)

![image](https://user-images.githubusercontent.com/87463484/178317000-e9b9a87c-0537-4333-b0e1-5d41e7e354e7.png)

![image](https://user-images.githubusercontent.com/87463484/178317007-7c6d35d4-be37-452c-b505-314d73175d37.png)

# 4.	Locked Profile

In this problem, you must **create a JS program** which **shows** and **hides** the additional information about users, 
which you can find by making a **GET** request to the server at address:

**http://localhost:3030/jsonstore/advanced/profiles**

The response will be an object with the information for all users. Create a profile card for every user and display it on the web page. Every item should have the following structure:

![image](https://user-images.githubusercontent.com/87463484/178317096-07cb6245-53b8-4757-8fd9-1ced1eed7907.png)

![image](https://user-images.githubusercontent.com/87463484/178317108-4e37f519-015c-4047-b18b-fb70eddc5966.png)

When one of the \[**Show more**] **buttons** is clicked, the **hiden information** inside the div should be shown, only if **the profile is not locked**! 
If the current profile is **locked,** nothing should happen.

![image](https://user-images.githubusercontent.com/87463484/178317214-82f9addb-4dac-4252-9672-88e835372bbf.png)

If the **hidden information is displayed** and we **lock the profile again**, the \[**Hide it**] button should **not be working**! 
Otherwise, when the profile is **unlocked** and we click on the **\[Hide it]** button, the new fields must hide again.

# 5.	Accordion

An **html** file is given and your task is to show **more**/**less** information for the selected article. At the start you should do a **GET** request to 
the server at adress: **http://localhost:3030/jsonstore/advanced/articles/list**  where the response will be an object with the titles of the articles.

By clicking the \[**More**] **button** for the selected **article**, it should **reveal** the content of a **hidden** div and **changes** the text of the button 
to \[**Less**]. Obtain the content by making a **GET** request to the server at adress: **http://localhost:3030/jsonstore/advanced/articles/details/:id** where 
the response will be an object with property **id**, **title**, **content.** When the same button is clicked **again** (now reading **Less**), **hide** the div and 
**change** the text of the button to **More**. Link action should be **toggleable** (you should be able to click the button infinite amount of times).

### Example 

![image](https://user-images.githubusercontent.com/87463484/178317711-f17ec663-9141-4eee-a68c-da7f5e581ae9.png)

![image](https://user-images.githubusercontent.com/87463484/178317726-6c6a5bb3-72a2-48ce-8aa9-43e833566d87.png)

Every item should have the **following structure**:

![image](https://user-images.githubusercontent.com/87463484/178317761-6f4ed31c-8d65-4875-adcd-07d794839049.png)

You are allowed to add new attributes, but do not change the existing ones.

# 6.	Blog

Write a program for reading blog content. It needs to make **requests** to the **server** and display **all blog posts** and their **comments**.\
Request URL's:

Posts - **http://localhost:3030/jsonstore/blog/posts**

Comments - **http://localhost:3030/jsonstore/blog/comments**

The button with ID "**btnLoadPosts**" should make a GET request to "**/posts**". The **response** from the **server** will be an **Object of objects**.

![image](https://user-images.githubusercontent.com/87463484/178317901-8e13b33b-f594-4cbd-b179-e923f862a11e.png)

Each object will be in the following format:

**{**\
&nbsp;&nbsp; **body: {postBody},**\
&nbsp;&nbsp; **id: {postId},**\
&nbsp;&nbsp; **title: {postTitle}**\
**}**

Create an **\<option>** for each post using its **object key** as value and **current object title property** as text inside the node with ID "**posts**".

![image](https://user-images.githubusercontent.com/87463484/178318112-ec99b5bb-463b-45ae-b5bf-fcd51ecfba56.png)

![image](https://user-images.githubusercontent.com/87463484/178318120-275f3380-6520-4680-9044-122016ad7aca.png)

When the button with ID "**btnViewPost**" is clicked, a **GET** request should be made to:

- "**/comments/:id**" to obtain the selected post (from the dropdown menu with ID "**posts**") - The following **request** will return 
  **a single object** as described above.
  
- "**/comments** - to obtain all comments. The request will **return** a **Object** of **objects**.

![image](https://user-images.githubusercontent.com/87463484/178318332-94069725-830c-4922-bd21-d57d7482046b.png)

Each object will be in the following format:

**{**\
&nbsp;&nbsp; **id: {commentId},**\
&nbsp;&nbsp; **postId: {postId},**\
&nbsp;&nbsp; **text: {commentText}**\
**}**

You have to find this comments that are for the current post (check the postId property)

Display the post title inside **h1** with ID "**post-title**" and the post content inside **p** with ID "**post-body**". 
Display **each comment** as a **\<li>** inside **ul** with ID "**post-comments**". Do not forget to clear its content beforehand.
  
![image](https://user-images.githubusercontent.com/87463484/178318498-c8c3f853-4be2-478e-89a8-8161277864e8.png)

![image](https://user-images.githubusercontent.com/87463484/178318513-3187fabc-2cb6-4192-9aac-f66964cf946d.png)
