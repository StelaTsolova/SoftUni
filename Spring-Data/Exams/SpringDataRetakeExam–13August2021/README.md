Laptop Shop
===========

Yes, another specialty laptop store, but only at first glance. Here you will find a large selection of the best office, professional or gaming computers and of course, 
they will all be mobile because mobility is most important nowadays. To offer a better experience to its customers, the store urgently needs a good enough application 
that collects all the information about all available laptops and can, with one click, dig through the sorted best offers. The store owner has turned to SoftUni for help.
Now a small team led by you must take on this task.

# 1. Functionality Overview

The application should be able to easily **import** hard-formatted data and **support functionalities** for also **exporting** the imported data. 
The application is called - **Laptop Shop**.

Look at the pictures below to see what must happen:

- The home page before importing anything:

![image](https://user-images.githubusercontent.com/87463484/167372217-36727e63-c02f-4557-b712-ebccbf803bdd.png)

- The import XML page before importing anything:

![image](https://user-images.githubusercontent.com/87463484/167372329-ad56e3f0-c067-45a3-a515-37034b50021c.png)

-	Import the towns first:

![image](https://user-images.githubusercontent.com/87463484/167372363-722c67c1-5147-4a71-bcbf-5f3377084893.png)

-	Import the shops second:

![image](https://user-images.githubusercontent.com/87463484/167372418-19ec8bb6-c4a3-4ead-a488-bf3fb2dbe348.png)

-	The import XML page after importing both files:

![image](https://user-images.githubusercontent.com/87463484/167372465-c4d6b38f-867c-4171-88f0-b5ae08477854.png)

- The import JSON page before importing the given data:

![image](https://user-images.githubusercontent.com/87463484/167372494-072e2d2f-610d-44a5-b483-6c83df8f7582.png)

-	Import the customers' data:

![image](https://user-images.githubusercontent.com/87463484/167372533-c466e987-96c7-4769-be54-e94bc92dfbb2.png)

-	Import the laptops' data:

![image](https://user-images.githubusercontent.com/87463484/167372563-862268e3-300b-4b44-b4cd-2153c38b6d35.png)

- The import JSON page after importing the data:

![image](https://user-images.githubusercontent.com/87463484/167372604-4a9c5028-6b27-4250-a456-fffedd7369a7.png)

- The home page after the data is imported:

![image](https://user-images.githubusercontent.com/87463484/167372666-297cf006-e2e6-4268-b3f3-0451fad2868d.png)

- Export laptops by their characteristics:

![image](https://user-images.githubusercontent.com/87463484/167372700-7503fcf0-a6ab-4354-bf06-1031dbedb8be.png)

# 2. Project Skeleton Overview

You will be given a **skeleton**, containing a **certain architecture (MVC)** with **several classes**, some of which are completely empty. 
The **Skeleton** will include the **files** with which you will **seed** the **database**.

# 3. Model Definition

There are 4 main models that the **Laptop Shop database** application should contain in its functionality.

Design them in the **most appropriate** way, considering the following **data constraints**:

### Town

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 2.** The values are **unique in the database**.
- **population** - accepts **number** values (must be positive), 0 as a value is **exclusive**.
- **travel guide** - a long and **detailed** **description** of all known places with a character length value **higher than or equal to 10.**

### Shop

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 4.** The values are **unique in the database**.
- **income** - accepts **number** values that are **more** than or **equal** to **20000.**
- **address** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 4.**
- **employee count** - accepts **number** values that are between 1 and 50
  - **(Larger than** or **equal** to **1** and **less than** or **equal** to **50**).
- **shop area** - accepts **number** values that are **more** than or **equal** to **150.**
- **Constraint**: The shops table has a relation with the towns table. 

### Customer

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **first name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 2.**
- **last name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 2**.
- **email**  - accepts valid **email addresses** (must contains '@' and '.' - a dot). The values are **unique in the database.**
- **registered on - a date when а customer registers in the shop**.
- **Constraint**: The customers table has а relation with the towns table. 

### Laptop 

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **mac address** - accepts **char sequences** as valueswhere their character length value **higher than 8**.\
  The values are **unique in the database.**
- **cpu speed** - accepts positive floating-point numbers.
- **ram** - accepts **number** values that are **more** than or **equal** to **8 and less than or equal to 128**
- **storage** - accepts **number** values that are **more** than or **equal** to **128 and less than or equal to 1024**
- **description - a long and detailed description** of all known places with a character length value **higher than or equal to 10**.
- **price** - accepts a **positive number**.
- **warranty type** - the enumeration, one of the following - **BASIC, PREMIUM, LIFETIME**.
- **Constraint**: The laptops table has a relation with the shops table.  

**Constraint**:

- Name the entities and their class members **exactly** in the **format stated** above.
- All fields are **NOT NULL** unless explicitly stated to be nullable.

![image](https://user-images.githubusercontent.com/87463484/167373391-ddbfec75-6eed-4cb1-a5c5-9d6877f4a58d.png)

# 4. Data Import

Use the provided files to populate the database with data. Import all the information from those files into the database.

**You are not allowed to modify the provided files.**

**ANY INCORRECT** data should be **ignored** and a message:

 "**Invalid {Town / Shop / Customer/ Laptop}**" should be printed.

**When the import is finished:**

"**Successfully imported {Town/ Shop / Customer/ Laptop} {town name / shop name - income / first name - last name - email / laptop mac address - cpu - ram -hdd}**"

### XML Import

Your new colleagues have prepared some XML data for you to import.
                   
| **Towns (towns.xml)** |
| --- |                   
| \<?xml version="1.0" encoding="UTF-8" ?>                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| \<towns>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| &nbsp;&nbsp;&nbsp; \<town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>I\</name>                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<population>15462452\</population>                                                                                                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<travel-guide>Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.\</travel-guide>                                                                                                           |
| &nbsp;&nbsp;&nbsp; \</town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp; \<town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Moscow\</name>                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<population>12195221\</population>                                                                                                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<travel-guide>Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.\</travel-guide> |
| &nbsp;&nbsp;&nbsp; \</town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp; \<town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>London\</name>                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<population>9126366\</population>                                                                                                                                                                                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<travel-guide>Short.\</travel-guide>                                                                                                                                                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp; \</town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp; \<town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Saint Petersburg\</name>                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<population>-5383890\</population>                                                                                                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<travel-guide>Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.\</travel-guide>                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp; \</town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp; \<town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Berlin\</name>                                                                                                                                                                                                                                                                                                                                                                                                                                        |   
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<population>3748148\</population>                                                                                                                                                                                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<travel-guide>Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\</travel-guide>                                                                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp; \</town>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ...                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | 
| Invalid town                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| Successfully imported Town Moscow                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |   
| Invalid town                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| Invalid town                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| Successfully imported Town Berlin                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| …                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
                                                                                                                                                                                                                                                                                  
**Constraint:**

- **If the shop's name already exists in the DB return "Invalid Shop".**
- **The provided town names will always be valid.**
                                                                                                            
| **Shops (shops.xml)** |
| --- |                                                                                                             
| \<?xml version='1.0' encoding='UTF-8'?>                                                                                                                        |
| \<shops>                                                                                                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>04 Pond Junction\</address>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>47\</employee-count>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>625273\</income>                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Er\</name>                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>278\</shop-area>                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Hamburg\</name>    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>779 Parkside Park\</address>                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>48\</employee-count>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>10\</income>                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Raynor\</name>                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>108\</shop-area>                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Birmingham\</name> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>15c\</address>                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>40\</employee-count>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>2710190\</income>                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Lockman-Stroman\</name>                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>419\</shop-area>                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>New York\</name>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>6 Kennedy Lane\</address>                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>47\</employee-count>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>2078882</income>                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Nader-Wehner\</name>                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>50\</shop-area>                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
|  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Barcelona\</name> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>95 Delaware Avenue\</address>                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>0\</employee-count>                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>387613\</income>                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Langosh-Mraz\</name>                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>445\</shop-area>                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>New York\</name>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop>                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<address>340 Londonderry Junction\</address>                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<employee-count>31\</employee-count>                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<income>1511525\</income>                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Treutel\</name>                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<shop-area>164\</shop-area>                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Moscow\</name>     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</town>                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</shop>                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; . . .                                                                                                                     |
|                                                                                                                                                                |
| Invalid shop                                                                                                                                                   |
| Invalid shop                                                                                                                                                   |
| Invalid shop                                                                                                                                                   |
| Invalid shop                                                                                                                                                   |
| Invalid shop                                                                                                                                                   |
| Successfully imported Shop Treutel - 1511525                                                                                                                   |
| …                                                                                                                                                              |

### JSON Import

Your new colleagues have prepared some JSON data for you to import.

**Constraint:**

- **If the Customer email already exists in the DB return "Invalid Customer".**
- **The provided town names will always be valid.**

| **Customers (customers.json)** |
| --- |
| \[  |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "A",                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Duell",                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "aduell0@nifty.com",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "26/07/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Rome"     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Lorne",                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "C",                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "lcurtayne1@nbcnews.com",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "27/06/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Kyiv"     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Mil",                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Armitty",                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "marmit2@digg.com",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "03/07/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Chicago"  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Odella",                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Scully",                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "notValidMail.com",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "21/11/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Paris"    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "L",                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Healks",                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "lhealks4@yahoo.com",                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "13/12/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Chicago"  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| &nbsp;&nbsp; {                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Bil",                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Sadat",                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "bsadat5@cyberchimps.com",              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "registeredOn": "21/01/2020",                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": {                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Belgrade" |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                |
| &nbsp;&nbsp; },                                                                       |
| ...                                                                                   |
|                                                                                       |
| Invalid Customer                                                                      |
| Invalid Customer                                                                      |
| Successfully imported Customer Mil Armitty - marmit2@digg.com                         |
| Invalid Customer                                                                      |
| Invalid Customer                                                                      |
| Successfully imported Customer Bil Sadat - bsadat5@cyberchimps.com                    |
| ...                                                                                   |

**Constraint:**

- **If the laptop's mac address already exists in the DB return "Invalid Laptop".**
- **The provided shop names will always be valid.**
- **Format the cpu speed to the second digit after the decimal point.**

| **Laptops (laptops.json)** |
| --- |
| \[
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "B6-34",                                                                                                                                                                                                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 4.9,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 32,                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 1024,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.",                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 7443.63,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "PREMIUM",                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Becker"                                                                                                                                                                                                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "45-F8-0F-D3-A9-FC",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": -5.65,                                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 8,                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 1024,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.",                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 6591.95,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "LIFETIME",                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Ferry"                                                                                                                                                                                                                                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "8C-B5-5E-F9-E1-0E",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 2.09,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 2,                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 1024,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 1103.69,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "BASIC",                                                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Towne-Jast"                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "DC-85-FA-B8-55-93",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 4.21,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 8,                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 64,                                                                                                                                                                                                                                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.",                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 6218.74,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "PREMIUM",                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Watsica"                                                                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "F0-4F-A5-06-9F-1E",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 3.65,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 16,                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 128,                                                                                                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Short.",                                                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 6308.28,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "PREMIUM",                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "O'Reilly"                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "95-FF-4C-B2-E2-25",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 4.84,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 64,                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 1024,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante.",                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": -50.00,                                                                                                                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "PREMIUM",                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Walker Inc"                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "C4-90-3F-52-5D-83",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 3.99,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 64,                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 512,                                                                                                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.",                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 4401.56,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "INVALID WARRANTY TYPE",                                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Kerluke"                                                                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp; {                                                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "macAddress": "B5-42-0A-AC-F0-19",                                                                                                                                                                                                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "cpuSpeed": 1.46,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ram": 128,                                                                                                                                                                                                                                                                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "storage": 128,                                                                                                                                                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "description": "Aenean lectus. Pellentesque eget nunc.",                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "price": 4081.54,                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "warrantyType": "PREMIUM",                                                                                                                                                                                                                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "shop": {                                                                                                                                                                                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "name": "Jacobi and Bayer"                                                                                                                                                                                                                                                           |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }                                                                                                                                                                                                                                                                                                                  |
| &nbsp;&nbsp; },                                                                                                                                                                                                                                                                                                                                         |
| ...                                                                                                                                                                                                                                                                                                                                                     |
|                                                                                                                                                                                                                                                                                                                                                         |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Invalid Laptop                                                                                                                                                                                                                                                                                                                                          |
| Successfully imported Laptop B5-42-0A-AC-F0-19 - 1.46 - 128 - 128                                                                                                                                                                                                                                                                                       |
| . . .                                                                                                                                                                                                                                                                                                                                                   |

# 5. Data Export

Get ready to export the data you have imported in the previous task. Here you will have some complex database querying. Export the data in the formats specified below.

#### Export Best Laptops from the Data Base

- Extract from the database, the **mac address, CPU speed (to second digit after decimal point), ram, storage,** and 
  the **price (to second digit after decimal point)** of the **laptop**. Also, we need to show the **name** of the **shop** and the **name** of the **town**.
- **Order Them by the cpu speed in descending order, Then by the ram in descending order, then by the storage in descending order and finally by the MAC Address**
- Return the information in this format:
- **"Laptop - {mac address}**\
**\*Cpu speed - {cpu speed}**\
**\*\*Ram - {ram}**\
**\*\*\*Storage - {storage}**\
**\*\*\*\*Price - {price}**\
**#Shop name - {name of the shop}**\
**##Town - {the name of the town of shop}**\
**. . . "**
