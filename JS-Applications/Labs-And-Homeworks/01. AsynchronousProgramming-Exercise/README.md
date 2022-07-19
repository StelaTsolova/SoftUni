# 1. Bus Stop

Write a JS program that displays arrival times for all buses by a given bus stop ID when a button is clicked. Use the skeleton from the provided resources.

When the button with ID **'submit'** is clicked, the name of the bus stop appears and the list bellow gets filled with all the buses that are expected and
their time of arrival. Take the **value** of the input field with id **'stopId'**. Submit a **GET** request to **http://localhost:3030/jsonstore/bus/businfo/:busId** 
(replace the highlighted part with the correct value) and parse the response. You will receive a JSON object in the format:

**stopId: {**\
**&nbsp;&nbsp; name: stopName,**\
**&nbsp;&nbsp; buses: { busId: time, ... }**\
**}**

Place the name property as text inside the div with ID **'stopName'** and each bus as a list item with text:

**"Bus {busId} arrives in {time} minutes"**

Replace all highlighted parts with the relevant value from the response. If the request is not successful, or the information is not in the expected format, 
display **"Error"** as **stopName** and nothing in the list. The list should be cleared before every request is sent.

**Note:** The service will respond with valid data to IDs 1287, 1308, 1327 and 2334.

See examples on the next page.

### Example

![image](https://user-images.githubusercontent.com/87463484/179839379-7e2d8b13-7551-415c-8e60-764e03c680e3.png)

![image](https://user-images.githubusercontent.com/87463484/179839393-ff32c653-033e-4a26-9ff5-823df694fef9.png)

When the button is clicked, the results are displayed in the corresponding elements:

![image](https://user-images.githubusercontent.com/87463484/179839438-04746886-b764-4209-a17c-3212f508fd0a.png)

![image](https://user-images.githubusercontent.com/87463484/179839476-8acb9f2f-3c22-4c31-98c3-ea8177168ede.png)

If an error occurs, the stop name changes to Error:

![image](https://user-images.githubusercontent.com/87463484/179839512-2ae62528-d07b-4428-a293-3691c0418e9b.png)

![image](https://user-images.githubusercontent.com/87463484/179839525-57f2ede0-5804-4c7e-9d4b-8e4b48ae14ee.png)

# 2.	Bus Schedule

Write a JS program that tracks the progress of a bus on it's route and announces it inside an info box. The program should display which is the upcoming stop and 
once the bus arrives, to request from the server the name of the next one. Use the skeleton from the provided resources.

The bus has two states - **moving** and **stopped**. When it is **stopped**, only the button "**Depart**" is **enabled**, while the info box shows the name of 
the **current** stop. When it is **moving**, only the button "**Arrive**" is **enabled**, while the info box shows the name of the **upcoming** stop.
Initially, the info box shows "**Not Connected**" and the "**Arrive**" button is **disabled**. The ID of the first stop is "**depot**".

When the "**Depart**" button is clicked, make a **GET** request to the server with the ID of the current stop to address **http://localhost:3030/jsonstore/bus/schedule/:id** 
(replace the highlighted part with the relevant value). As a response, you will receive a JSON object in the following format:

**stopId {**\
**&nbsp;&nbsp; name: stopName,**\
**&nbsp;&nbsp; next: nextStopId**\
**}**

Update the info box with the information from the response, disable the "Depart" button and enable the "Arrive" button. 
The info box text should look like this (replace the highlighted part with the relevant value):

**Next stop {stopName}**

When the "**Arrive**" button is clicked, update the text, disable the "Arrive" button and enable the "Depart" button. 
The info box text should look like this (replace the highlighted part with the relevant value):

**Arriving at {stopName}**

Clicking the buttons successfully will cycle through the entire schedule. If invalid data is received, show "**Error**" inside the info box and **disable** both buttons.

### Example

Initially, the info box shows "Not Connected" and the arrive button is disabled.  

![image](https://user-images.githubusercontent.com/87463484/179839924-91651877-f951-401b-b008-71efdfaf1075.png)

![image](https://user-images.githubusercontent.com/87463484/179839947-88b98332-c6c9-4880-bafa-7b23f0a51867.png)

When Depart is clicked, a request is made with the first ID. The info box is updated with the new information and the buttons are changed:

![image](https://user-images.githubusercontent.com/87463484/179839983-d4f0d3b4-cb06-46f4-a53d-1acf1fe4744f.png)

![image](https://user-images.githubusercontent.com/87463484/179839996-7140af6c-3a04-49e2-9ffc-94f4d3f10a42.png)

Clicking Arrive, changes the info box and swaps the buttons. This allows Depart to be clicked again, which makes a new request and updates the information:

![image](https://user-images.githubusercontent.com/87463484/179840036-bd07aad7-cb78-4a37-97bb-823576ececea.png)

![image](https://user-images.githubusercontent.com/87463484/179840044-b1803fb8-5755-4010-ac4c-a92fac0842dd.png)

# 3.	Forecaster

Write a program that **requests** a weather report **from a server** and **displays** it to the user.

Use the skeleton from the provided resources.

When the user writes the name of a location and clicks **"Get Weather"**, make a **GET** request to the server at address **http://localhost:3030/jsonstore/forecaster/locations**. 
The response will be an array of objects, with the following structure:

**{**\
**&nbsp;&nbsp; name: locationName,**\
**&nbsp;&nbsp; code: locationCode**\
**}**

Find the object, corresponding to the name that the user submitted in the input field with ID **"location"** and use its **code** value to make **two more GET requests**:

-   For current conditions, make a request to:

**http://localhost:3030/jsonstore/forecaster/today/:code**

The response from the server will be an object with the following structure:

**{**\
&nbsp;&nbsp; **name: locationName,**\
&nbsp;&nbsp; **forecast: { low: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **high: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **condition: condition }**\
**}**

-   For a 3-day forecast, make a request to:

**http://localhost:3030/jsonstore/forecaster/upcoming/:code**

The response from the server will be an object with the following structure:

**{**\
&nbsp;&nbsp; **name: locationName,**\
&nbsp;&nbsp; **forecast: \[{ low: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **high: temp,**\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **condition: condition }, ... ]**\
**}**

Use the information from these two objects to compose a forecast in HTML and insert it inside the page. 
Note that the **\<div>** with ID **"forecast"** must be set to **visible**. See the examples for details.

If an **error** occurs (the server doesn't respond or the location name cannot be found) or the data is not in the correct format, 
display "**Error**" in the **forecast section**.

Use the following codes for weather symbols:

-   Sunny **\&#x2600;** // ☀
-   Partly sunny **\&#x26C5;** // ⛅
-   Overcast **\&#x2601;** // ☁
-   Rain **\&#x2614;** // ☂
-   Degrees **\&#176;** // °

### Example

When the app starts, the **forecast div** is **hidden**. When the user **enters a name** and **clicks** on the button**Get Weather**, the requests being.

![image](https://user-images.githubusercontent.com/87463484/179841005-da9fcbe2-5d2b-4e65-8289-faa729c5e842.png)

![image](https://user-images.githubusercontent.com/87463484/179841020-279aaf33-1abd-40b1-aec1-b920fe610199.png)

![image](https://user-images.githubusercontent.com/87463484/179841032-7cd16ff7-2600-4955-b4d3-19af0c58dd7a.png)

![image](https://user-images.githubusercontent.com/87463484/179841043-cab6cdbe-462e-4af1-a5f6-586b0d054e5c.png)

# 4.	Locked Profile

In this problem, you must **create a JS program** which **shows** and **hides** the additional information about users, 
which you can find by making a **GET** request to the server at address:

**http://localhost:3030/jsonstore/advanced/profiles**

The response will be an object with the information for all users. Create a profile card for every user and display it on the web page. 
Every item should have the following structure:

![image](https://user-images.githubusercontent.com/87463484/179841221-42ef38d4-d05c-4d53-926d-0ed963f15f89.png)

![image](https://user-images.githubusercontent.com/87463484/179841235-1b1ac5a2-1ca5-473d-bbc0-84fc70f0e056.png)

When one of the \[**Show more**] **buttons** is clicked, the **hiden information** inside the div should be shown, only if **the profile is not locked**! 
If the current profile is **locked,** nothing should happen.

![image](https://user-images.githubusercontent.com/87463484/179841309-5ded9fd8-8f65-489f-ad4f-1f23a6905bf4.png)

If the **hidden information is displayed** and we **lock the profile again**, the \[**Hide it**] button should **not be working**! 
Otherwise, when the profile is **unlocked** and we click on the \[**Hide it**] button, the new fields must hide again.

# 5.	Accordion

An **html** file is given and your task is to show **more**/**less** information for the selected article. At the start you should do a **GET** request to the server 
at adress: **http://localhost:3030/jsonstore/advanced/articles/list**  where the response will be an object with the titles of the articles.

By clicking the **\[More] button** for the selected **article**, it should **reveal** the content of a **hidden** div and **changes** the text of the button to 
\[**Less**]. Obtain the content by making a **GET** request to the server at adress: **http://localhost:3030/jsonstore/advanced/articles/details/:id** where 
the response will be an object with property **id**, **title**, **content.** When the same button is clicked **again** (now reading **Less**), **hide** the div and 
**change** the text of the button to **More**. Link action should be **toggleable** (you should be able to click the button infinite amount of times).

### Example

![image](https://user-images.githubusercontent.com/87463484/179841594-0a923848-1a51-4057-9f73-46f8cd2d429b.png)

![image](https://user-images.githubusercontent.com/87463484/179841611-68699bd3-5114-496f-a9d0-b28b3c8ed20e.png)

Every item should have the **following structure**:

![image](https://user-images.githubusercontent.com/87463484/179841648-afb896fb-1a19-4f0b-b8a6-f44f4415ddf7.png)

You are allowed to add new attributes, but do not change the existing ones.

# 6.	Blog

Write a program for reading blog content. It needs to make **requests** to the **server** and display **all blog posts** and their **comments**. Request URL's:

Posts - **http://localhost:3030/jsonstore/blog/posts**

Comments - **http://localhost:3030/jsonstore/blog/comments**

The button with ID "**btnLoadPosts**" should make a GET request to "**/posts**". The **response** from the **server** will be an **Object of objects**.

![image](https://user-images.githubusercontent.com/87463484/179841775-95d0a132-a29f-4601-a53a-7a3943dd322c.png)

Each object will be in the following format:

**{**\
&nbsp;&nbsp; **body: {postBody},**\
&nbsp;&nbsp; **id: {postId},**\
&nbsp;&nbsp; **title: {postTitle}**\
**}**

Create an **\<option>** for each post using its **object key** as value and **current object title property** as text inside the node with ID "**posts**".

![image](https://user-images.githubusercontent.com/87463484/179842012-d53b9a9c-e60a-46db-b84c-fe2a57d6e968.png)

![image](https://user-images.githubusercontent.com/87463484/179842023-16559d98-b4b3-4adc-98d4-516419b46bfb.png)

When the button with ID "**btnViewPost**" is clicked, a **GET** request should be made to:

- "**/comments/:id**" to obtain the selected post (from the dropdown menu with ID "**posts**") - The following **request** will return 
  **a single object** as described above.

- "**/comments**** - to obtain all comments. The request will **return** a **Object** of **objects**.

![image](https://user-images.githubusercontent.com/87463484/179842158-ecc0634a-520c-4bb3-ad75-e0c6971ecb29.png)

Each object will be in the following format:

**{**\
&nbsp;&nbsp; **id: {commentId},**\
&nbsp;&nbsp; **postId: {postId},**\
&nbsp;&nbsp; **text: {commentText}**\
**}**

You have to find this comments that are for the current post (check the postId property)

Display the post title inside **h1** with ID "**post-title**" and the post content inside **p** with ID "**post-body**". 
Display **each comment** as a **\<li>** inside **ul** with ID "**post-comments**". Do not forget to clear its content beforehand.

![image](https://user-images.githubusercontent.com/87463484/179842331-10e765ca-4313-4083-8795-24ab9ab1cf58.png)

![image](https://user-images.githubusercontent.com/87463484/179842338-1630f75d-a4e8-40e5-b4ca-5a7eb2f68db8.png)
