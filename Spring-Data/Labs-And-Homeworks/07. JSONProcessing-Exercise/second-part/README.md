# 4. Car Dealer

A car dealer needs information about cars, their parts, parts suppliers, customers and sales.

- **Cars** have **make**, **model**, **and travelled distance** in kilometers.
- **Parts** have **name**, **price** and **quantity**.
- Part **supplier** have **name** and info whether he **uses imported parts**.
- **Customer** has **name**, **date of birth** and info whether he/she **is a young driver** (Young driver is a driver that has **less than 2 years of experience**. 
  Those customers get **additional 5% off** for the sale.).
- **Sale** has **car**, **customer** and **discount percentage**.

A **price of a car** is formed by the **total price of its parts**.

Using Code First approach create a database following the above description.

![image](https://user-images.githubusercontent.com/87463484/166306738-be4efb37-44d7-4239-93c4-a38f398c4e4a.png)

Configure the following relations in your models:

- A **car** has **many parts** and **one part** can be placed **in many cars**
- **One supplier** can supply **many parts** and each **part** can be delivered by **only one supplier**
- In **one sale**, only **one car** can be sold
- **Each sale** has **one customer** and **a customer** can buy **many cars**

# 5. Car Dealer Import Data

Import data from the provided files (**suppliers.json, parts.json, cars.json, customers.json**).

First import the **suppliers**. When importing the **parts**, set to each part a **random supplier** from the already imported suppliers. 
Then, when importing the cars add **between 3 and 5 random parts** to each car. Then import **all customers**. Finally, import the **sales records** by **randomly** 
selecting a **car, customer** and the amount of **discount to be applied** (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).

# 6. Car Dealer Query and Export Data

Write the below described queries and **export** the returned data to the specified **format**.

### Query 1 - Ordered Customers

Get all **customers**, ordered by their **birthdate in ascending order**. If two customers are born on the same date, 
**first print those, who are not young drivers** (e.g. print experienced drivers first). **Export** the list of customers **to JSON** in the format provided below.

| **ordered-customers.json** |
| --- |
| \[                                                                        |
| &nbsp;&nbsp; {                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 29,                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Louann Holzworth",          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "BirthDate": " 1960-10-01T00:00:00", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "IsYoungDriver": false,              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Sales": \[],                        |
| &nbsp;&nbsp; },                                                           |
| &nbsp;&nbsp; {                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 28,                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Donnetta Soliz",            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "BirthDate": " 1963-10-01T00:00:00", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "IsYoungDriver": true,               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Sales": \[],                        |
| &nbsp;&nbsp; },                                                           |
| &nbsp;&nbsp; ...                                                          |
| ]                                                                         |

### Query 2 - Cars from Make Toyota

Get all **cars** from make **Toyota** and **order them by model alphabetically** and then by **travelled distance descending**. 
**Export** the list of **cars to JSON** in the format provided below.

| **toyota-cars.json** |
| --- |
| \[                                                                   |
| &nbsp;&nbsp; {                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 117,                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Toyota",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Model": "Camry Hybrid",        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "TravelledDistance": 954775807, |
| &nbsp;&nbsp; },                                                      |
| &nbsp;&nbsp; {                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 112,                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Toyota",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Model": "Camry Hybrid",        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "TravelledDistance": 92275807,  |
| &nbsp;&nbsp; },                                                      |
| &nbsp;&nbsp; ...                                                     |
| ]                                                                    |

### Query 3 - Local Suppliers

Get all **suppliers** that **do not import parts from abroad**. Get their **id**, **name** and the **number of parts** they can offer to supply. 
Export the list of suppliers to JSON in the format provided below.

| **local-suppliers.json** |
| --- |
| \[                                                           |
| &nbsp;&nbsp; {                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 2,                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Agway Inc.",   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "partsCount": 6         |
| &nbsp;&nbsp; },                                              |
| &nbsp;&nbsp; {                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Id": 4,                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Airgas, Inc.", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "partsCount": 5         |
| &nbsp;&nbsp; },                                              |
| &nbsp;&nbsp; ...                                             |
| ]                                                            |

### Query 4 - Cars with Their List of Parts

Get all **cars along with their list of parts**. For the **car** get only **make, model** and **travelled distance**. 
For the **parts** get only the **name** and the **price**. **Export** the list of **cars and their parts to JSON** in the format provided below.

| **cars-and-parts.json** |
| --- |
| \[                                                                                                                                |
| &nbsp;&nbsp; {                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "car": {                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Opel",                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Model": "Omega",                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "TravelledDistance": 2147483647,                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "parts": \[                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Front Left Side Outer door handle", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Price": 999.99                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Gudgeon pin",                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Price": 44.99                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Oil pump",                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Price": 100.19                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Transmission pan",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Price": 106.99                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]                                                                                            |
| &nbsp;&nbsp; },                                                                                                                   |
| &nbsp;&nbsp; {                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "car": {                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Opel",                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Model": "Astra",                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "TravelledDistance": 9223372036854775807                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "parts": \[                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Name": "Overflow tank",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Price": 1200.99                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]                                                                                            |
| &nbsp;&nbsp; },                                                                                                                   |
| &nbsp;&nbsp; ...                                                                                                                  |
| ]                                                                                                                                 |

### Query 5 - Total Sales by Customer

Get all **customers** that have bought **at least 1 car** and get their **names**, **count of cars bought** and **total money spent** on cars. 
**Order** the result list **by total money spent in descending order** then by **total cars bought** again in **descending** order. 
Export the list of customers to JSON in the format provided below.

| **customers-total-sales.json** |
| --- |
| \[                                                                      |
| &nbsp;&nbsp; {                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "fullName": "Hipolito Lamoreaux",  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "boughtCars": 5,                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "spentMoney": 8360.48              |
| &nbsp;&nbsp; },                                                         |
| &nbsp;&nbsp; {                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "fullName": "Francis Mckim",       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "boughtCars": 4,                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "spentMoney": 7115.50              |
| &nbsp;&nbsp; },                                                         |
| &nbsp;&nbsp; {                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "fullName": "Johnette Derryberry", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "boughtCars": 4,                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "spentMoney": 5337.72              |
| &nbsp;&nbsp; },                                                         |
| &nbsp;&nbsp; ...                                                        |
| ]                                                                       |

### Query 6 - Sales with Applied Discount

Get all **sales** with information about the **car**, the **customer** and the **price** of the sale **with and without discount**. 
Export the list of sales to JSON in the format provided below.

| **sales-discounts.json** |
| --- |
| \[                                                                                                       |
| &nbsp;&nbsp; {                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "car": {                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Make": "Peugeot",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Model": "405",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "TravelledDistance": 92036854775807 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "customerName": "Donnetta Soliz",                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Discount": 0.3,                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 1402.53,                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "priceWithDiscount": 981.771                                        |
| &nbsp;&nbsp; },                                                                                          |
| &nbsp;&nbsp; {                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "car": {                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Make": "Mercedes",                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "Model": "W124",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Make": "TravelledDistance": 2147647        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; },                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "customerName": "Carri Knapik",                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "Discount": 0.2,                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 254.96999999999997,                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "priceWithDiscount": 203.97599999999997                             |
| &nbsp;&nbsp; },                                                                                          |
| &nbsp;&nbsp; ...                                                                                         |
| ]                                                                                                        |
