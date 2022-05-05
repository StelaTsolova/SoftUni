Car Dealer Database
===================

In the next exercises you will be required to **use the models** from the previous exercise for JSON processing.

# 1. Car Dealer Import Data

Import data from the provided files (**suppliers.xml, parts.xml, cars.xml, customers.xml**).

First import the **suppliers**. When importing the **parts** set to each part a **random supplier** from the already imported suppliers. 
Then, when importing the cars add **between 10 and 20 random parts** to each car. Then import **all customers**. Finally, import the **sales records** by 
**randomly** selecting a **car,** a **customer** and the amount of **discount to be applied** (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).

# 2. Car Dealer Query and Export Data

Write the below described queries and **export** the returned data to the specified **format**.

### Query 1 - Ordered Customers

Get all **customers** ordered by their **birthdate in ascending order**. If two customers are born on the same date, 
**first print those, who are not young drivers** (e.g. print experienced drivers first). **Export** the list of customers **to XML** in the format provided below.

| **ordered-customers.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                        |
| \<customers>                                                                                   |
| &nbsp;&nbsp; \<customer>                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>29</id>                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Louann Holzworth</name>                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<birth-date>1960-10-01T00:00:00</birth-date> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<is-youn-driver>false</is-young-driver>      |
| &nbsp;&nbsp; \</customer>                                                                      |
| &nbsp;&nbsp; \<customer>                                                                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>28</id>                                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Donnetta Soliz</name>                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<birth-date>1963-10-01T00:00:00</birth-date> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<is-youn-driver>false</is-young-driver>      |
| &nbsp;&nbsp; \</customer>                                                                      |
| &nbsp;&nbsp; ...                                                                               |
| \</customers>                                                                                  |

### Query 2 - Cars from Make Toyota

Get all **cars** from make **Toyota** and **order them by model alphabetically** and by **travelled distance in descending order**. 
**Export** the list of **cars to XML** in the format provided below.

| **toyota-cars.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                          |
| \<cars>                                                                                          |
| &nbsp;&nbsp; \<car id="117" make="Toyota" model="Camry Hybrid" travelled-distance="954775807" /> |
| &nbsp;&nbsp; \<car id="112" make="Toyota" model="Camry Hybrid" travelled-distance="92275807" />  |
| &nbsp;&nbsp; ...                                                                                 |
| \</cars>                                                                                         |

### Query 3 - Local Suppliers

Get all **suppliers** that **do not import parts from abroad**. Get their **id**, **name** and **the number of parts they can offer to supply**. 
**Export** the list of suppliers **to XML** in the format provided below.

| **local-suppliers.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                              |
| \<suppliers>                                                         |
| &nbsp;&nbsp; \<suplier id="2" name="Agway Inc." parts-count="6" />   |
| &nbsp;&nbsp; \<suplier id="4" name="Airgas, Inc." parts-count="5" /> |
| &nbsp;&nbsp; ...                                                     |
| \</suppliers>                                                        |

### Query 4 - Cars with Their List of Parts

Get all **cars along with their list of parts**. For the **car** get only **make, model** and **travelled distance** and for the **parts** get only **name** and 
**price**. **Export** the list of **cars and their parts to XML** in the format provided below.

| **cars-and-parts.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>
| \<cars>
| &nbsp;&nbsp; \<car make="Opel" model="Omega" travelled-distance="2147483647" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<parts>
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<part name="Front Left Side Outer door handle" price="999.99" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<part name="Gudgeon pin" price="44.99" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<part name="Oil pump" price="100.19" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<part name="Transmission pan" price="106.99" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</parts>
| &nbsp;&nbsp; \</car>
| &nbsp;&nbsp; \<car make="Opel" model="Astra" travelled-distance="9223372036854775807" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<parts>
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<part name="Overflow tank" price="1200.99" />
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ...
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</parts>
| &nbsp;&nbsp; \</car>
| &nbsp;&nbsp; ...
| \</cars>

### Query 5 - Total Sales by Customer

Get all **customers** that have bought **at least 1 car** and get their **names**, **count of cars bought** and **total money spent** on cars. 
**Order** the result **by total money spent in descending order** and then by **total amount of cars bought** again in **descending** order. 
**Export** the list of customers **to XML** in the format provided below.

| **customers-total-sales.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                          |
| \<customers>                                                                                     |
| &nbsp;&nbsp; \<customer full-name="Hipolito Lamoreaux" bought-cars="5" spent-money="8360.48" />  |
| &nbsp;&nbsp; \<customer full-name="Francis Mckim" bought-cars="4" spent-money="7115.50" />       |
| &nbsp;&nbsp; \<customer full-name="Johnette Derryberry" bought-cars="4" spent-money="5337.72" /> |
| &nbsp;&nbsp; ...                                                                                 |
| \</customer>                                                                                     |

### Query 6 - Sales with Applied Discount

Get all **sales** with information about the **car**, the **customer** and the **price** of the sale **with and without discount**. 
**Export** the list of sales **to XML** in the format provided below.

| **sales-discounts.xml** |
| --- |
| \<?xml version="1.0" encoding="utf-8"?>                                                                                  |
| \<sales>                                                                                                                 |
| &nbsp;&nbsp; \<sale>                                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<car make="Peugeot" model="405" travelled-distance="92036854775807" /> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<customer-name>Donnetta Soliz</customer-name>                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<discount>0.3</discount>                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>1402.53</price>                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price-with-discount>981.771</price-with-discount>                     |
| &nbsp;&nbsp; \</sale>                                                                                                    |
| &nbsp;&nbsp; \<sale>                                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<car make="Mercedes" model="W124" travelled-distance="2147647" />      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<customer-name>Carri Knapik</customer-name>                            |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<discount>0.2</discount>                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>254.96999999999997</price>                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price-with-discount>203.97599999999997</price-with-discount>          |
| &nbsp;&nbsp; \</sale>                                                                                                    |
| &nbsp;&nbsp; \...                                                                                                        |
| \</sales>                                                                                                                |
