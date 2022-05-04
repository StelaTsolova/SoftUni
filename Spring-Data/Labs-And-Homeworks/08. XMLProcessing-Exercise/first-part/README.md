Product Shop Database
=====================

In the next exercises you will be required to **use the models** from the previous exercise for JSON processing.

# 1. Seed the Database

**Import** the data from the provided files (**users.xml**, **products.xml**, **categories.xml**).

Import the **users** first. When importing the products, randomly **select the buyer** and **the seller** from the existing users. 
Leave out some **products** that have **not been sold** (i.e. buyer is null).

Randomly **generate categories** for each product from the existing categories.

# 2. Query and Export Data

Write the below described queries and **export** the returned data to the specified **format**.

### Query 1 - Products in Range

Get all products in a specified **price range** (e.g. 500 to 1000) which have **no buyer**. Order them by price (from lowest to highest).  
Select only the **product name**, **the price** and **the full name of the seller**. Export the result to XML.

| **products-in-range.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                               |
| \<products>                                                                                           |
| &nbsp;&nbsp;&nbsp; \<product name="TRAMADOL HYDROCHLORIDE" price="516.46" seller="Christine Gomez" /> |
| &nbsp;&nbsp;&nbsp; \<product name="Allopurinol" price="518.50" seller="Kathy Gilbert" />              |
| &nbsp;&nbsp;&nbsp; \<product name="Parsley" price="519.06" seller="Jacqueline Perez" />               |
| &nbsp;&nbsp;&nbsp; ...                                                                                |
| \</products>                                                                                          |

### Query 2 - Successfully Sold Products

Get all users, who have **at least 1 item sold** with a **buyer**. Order them by **last name**, then by **first name**. Select the person's **first** and **last name**.
For each of the **products sold** (products with buyers), select the product's **name**, **price** and the buyer's **first** and **last name**.

| **users-sold-products.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?\>                                                                                                                                                                   |
| \<users>                                                                                                                                                                                                   |
| &nbsp;&nbsp;&nbsp; \<user first-name="Carl" last\-name="Daniels">                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<sold\-products>                                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product>                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Peter Island Continous sunscreen kids</name> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>471.30</price>                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<buyer-first-name>Anna</buyer-first-name>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<buyer-last-name>Parker</buyer-last-name>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</product>                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product>                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Warfarin Sodium</name>                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>1379.79</price>                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<buyer-first-name>Brandon</buyer-first-name>       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<buyer-last-name>Fuller</buyer-last-name>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</product>                                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</sold-products>                                                                                                                             |
| \</user>                                                                                                                                                                                                   |
| ...                                                                                                                                                                                                        |
| \</users>                                                                                                                                                                                                  |

### Query 3 - Categories by Products Count

Get **all** **categories**. Order them by the **number of products** in that category (a product can be in many categories). 
For each category select its **name**, the **number of products**, the **average price of those products** and 
the **total revenue** (total price sum) of those products (regardless if they have a buyer or not).

| **categories-by-products.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                                 |
| \<categories>                                                                                           |
| &nbsp;&nbsp;&nbsp; \<category name="Sports">                                                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<products-count>49</products-count>       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<average-price>754.327755</average-price> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<total-revenue>36962.06</total-revenue>   |
| &nbsp;&nbsp;&nbsp; \</category>                                                                         |
| &nbsp;&nbsp;&nbsp; \<category name="Adult">                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<products-count>46</products-count>       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<average-price>905.283478</average-price> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<total-revenue>41643.04</total-revenue>   |
| &nbsp;&nbsp;&nbsp; \</category>                                                                         |
| ...                                                                                                     |
| \</categories>                                                                                          |

### Query 4 - Users and Products

Get all users, who have **at least 1 product sold**. Order them by the **number of products sold** (from highest to lowest), 
then by **last name** (ascending). Select only their **first** and **last name**, **age** and for each product - **name** and **price**.

Export the results to **XML**. Follow the format below to better understand how to structure your data.

| **users-and-products.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                                                                                                                |
| \<users count="35">                                                                                                                                                                    |
| &nbsp;&nbsp;&nbsp; \<user first-name="Carl" last-name="Daniels" age="59">                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<sold-products count="10">                                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Finasteride" price="1374.01" />                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Peter Island Continous sunscreen kids" price="471.30" />        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Warfarin Sodium" price="1379.79" />                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Gilotrif" price="1454.77" />                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Cold and Cough" price="218.14" />                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</sold-products>                                                                                                         |
| &nbsp;&nbsp;&nbsp; \</user>                                                                                                                                                            |
| &nbsp;&nbsp;&nbsp; \<user last-name="Harris">                                                                                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<sold-products count="9">                                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<product name="Clarins Paris Skin Illusion - 114 cappuccino" price="811.42" /> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</sold-products>                                                                                                         |
| &nbsp;&nbsp;&nbsp; \</user>                                                                                                                                                            |
| &nbsp;&nbsp;&nbsp; ...                                                                                                                                                                 |
| \</users>                                                                                                                                                                              |
