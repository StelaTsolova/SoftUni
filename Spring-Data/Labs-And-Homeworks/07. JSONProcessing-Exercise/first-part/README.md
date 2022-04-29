# 1. Products Shop   

A products shop holds **users**, **products** and **categories for the products**. Users can **sell** and **buy** products.

- Users have an **id**, **first name** (optional) and **last name** (at least 3 characters) and **age** (optional).
- Products have an **id**, **name** (at least 3 characters), **price**, **buyerId** (optional) and **sellerId** as IDs of users.
- Categories have an **id** and **name** (from **3** to **15** characters)

Using Code First approach create a database following the above description.

![image](https://user-images.githubusercontent.com/87463484/165920703-15c3342c-14c6-443c-8673-1751b37aa306.png)

Configure the following relations in your models:

- **Users** should have **many products sold** and **many products bought**.
- **Products** should have **many categories**.
- **Categories** should have **many products**.
- **Users** should have **many friends** (i.e. users).

# 2. Seed the Database

**Import** the data from the provided files (**users.json**, **products.json**, **categories.json**).

Import the **users** first. When importing the products, randomly **select the buyer** and **seller** from the existing users. 
Leave out some **products** that have **not been sold** (i.e. buyer is null).

Randomly **generate categories** for each product from the existing categories.

# 3. Query and Export Data

Write the below described queries and **export** the returned data to the specified **format**.

### Query 1 - Products in Range

Get all products in a specified **price range** (e.g. 500 to 1000), which have **no buyer**. Order them by price (from lowest to highest). 
Select only the **product name**, **price** and the **full name of the seller**. Export the result to JSON.

| **products-in-range.json** |
| --- |
| \[                                                                     |
| &nbsp;&nbsp; {                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "TRAMADOL HYDROCHLORIDE", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 516.48,                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "seller": "Christine Gomez"       |
| &nbsp;&nbsp; },                                                        |
| &nbsp;&nbsp; {                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Allopurinol",            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 518.50,                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "seller": "Kathy Gilbert"         |
| &nbsp;&nbsp; },                                                        |
| &nbsp;&nbsp; {                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Parsley",                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 519.06,                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "seller": "Jacqueline Perez"      |
| &nbsp;&nbsp; },                                                        |
| &nbsp;&nbsp; ...                                                       |
| ]                                                                      |

### Query 2 - Successfully Sold Products

Get all users who have **at least 1 item sold** with a **buyer**. Order them by **last name**, then by **first name**. Select the person's **first** and **last name**.
For each of the **products sold** (products with buyers), select the product's **name**, **price** and the buyer's **first** and **last name**.

| **users-sold-products.json** |
| --- |
| \[                                                                                                                              |
| &nbsp;&nbsp; {                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Carl",                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Daniels",                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "soldProducts": \[                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Peter Island Continous sunscreen kids", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 471.30,                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "buyerFirstName": "Anna",                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "buyerLastName": "Parker"                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Warfarin Sodium",                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 1379.79,                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "buyerFirstName": "Brandon",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "buyerLastName": "Fuller"                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]                                                                                          |
| &nbsp;&nbsp; },                                                                                                                 |
| &nbsp;&nbsp; ...                                                                                                                |
| ]                                                                                                                               |

### Query 3 - Categories by Products Count

Get **all categories**. Order them by the **number of products** in each category (a product can be in many categories). 
For each category select its **name**, the **number of products**, the **average price of those products** and 
the **total revenue** (total price sum) of those products (regardless if they have a buyer or not).


| **categories-by-products.json** |
| --- |
| \[                                                               |
| &nbsp;&nbsp; {                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "category": "Sports",       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "productsCount": 49,        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "averagePrice": 754.327755, |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "totalRevenue": 36962.06    |
| &nbsp;&nbsp; },                                                  |
| &nbsp;&nbsp; {                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "category": "Adult",        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "productsCount": 46,        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "averagePrice": 905.283478, |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "totalRevenue": 41643.04    |
| &nbsp;&nbsp; },                                                  |
| &nbsp;&nbsp; ...                                                 |
| ]                                                                |

### Query 4 - Users and Products

Get all users who have **at least 1 product sold**. Order them by the **number of products sold** (from highest to lowest), then by **last name** (ascending). 
Select only their **first** and **last name**, **age** and for each product - **name** and **price**.

Export the results to **JSON**. Follow the format below to better understand how to structure your data.

| **users-and-products.json** |
| --- |
| {                                                                                                                                                                                                                         |
| "usersCount":35,                                                                                                                                                                                                          |
| "users":                                                                                                                                                                                                                  |
| \[                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName":"Carl",                                                                                                                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName":"Daniels",                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "age":59,                                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "soldProducts":                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "count":10,                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "products":                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \[                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Finasteride",                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":1374.01                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Peter Island Continous sunscreen kids",        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":471.30                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Warfarin Sodium",                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":1379.79                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Gilotrif",                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":1454.77                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Cold and Cough",                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":218.14                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                                                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": null,                                                                                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Harris",                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "age": 0,                                                                                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "soldProducts":                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "count":9,                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "products":                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \[                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name":"Clarins Paris Skin Illusion – 114 cappuccino", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price":811.42                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]                                                                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; },                                                                                                                                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp; ...                                                                                                                                                                                              |
| ]                                                                                                                                                                                                                         |
| }                                                                                                                                                                                                                         |
