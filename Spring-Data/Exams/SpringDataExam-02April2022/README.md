Real Estate Agency
==================

Find the best home, investment or commercial property or speak to our estate agents today. Here you will find a large selection of the best apartments, 
houses or garages and of course, they will all be at best prices. To offer a better experience to its customers, the agency urgently needs a good enough application that 
collects all the information about all available estates and can, with one click, dig through the sorted best offers. 
The real estate agency owner has turned to SoftUni for help. Now a small team led by you must take on this task.

# 1. Functionality Overview

The application should be able to easily **import** hard-formatted data and **support functionalities** for also **exporting** the imported data. 
The application is called - **Real Estate Agency**.

Look at the pictures below to see what must happen:

- The home page before importing anything:

![image](https://user-images.githubusercontent.com/87463484/167253134-d348f67e-bd3c-42dc-9e1a-b9100d95e991.png)

-	The import JSON page before importing anything:

![image](https://user-images.githubusercontent.com/87463484/167253148-3f884495-5a84-454d-9f1c-c6531269cd08.png)

- Import the towns first:

![image](https://user-images.githubusercontent.com/87463484/167253155-268fa2b3-57b9-4eca-ab9c-f46f7f30c5b9.png)

- Import the agents second:

![image](https://user-images.githubusercontent.com/87463484/167253170-5bbef533-85fe-4a5f-9966-3501c9c839cc.png)

- The import JSON page after importing both files:

![image](https://user-images.githubusercontent.com/87463484/167253178-74c4ebe4-ca2a-41ea-b21f-a3d22a35aee2.png)

- The import XML page before importing the given data:

![image](https://user-images.githubusercontent.com/87463484/167253207-0205053d-1d18-4a5d-85be-f45d56d8aae8.png)

- Import the apartments data:

![image](https://user-images.githubusercontent.com/87463484/167253223-749c2ca3-79ec-40ed-b5bb-9e9e60bc35e9.png)

- Import the offers data:

![image](https://user-images.githubusercontent.com/87463484/167253235-a3400857-63cb-498b-b2ef-5cf5a4f65cab.png)

- The import XML page after importing the data:

![image](https://user-images.githubusercontent.com/87463484/167253243-6d84d659-c5d5-4313-9eb5-4c592a7248f2.png)

- The home page after the data is imported:

![image](https://user-images.githubusercontent.com/87463484/167253276-7b9cba18-afa6-4bd1-9fd4-692c0c4783de.png)

- Export offers for three_rooms apartments:

![image](https://user-images.githubusercontent.com/87463484/167253283-96ab65f6-7293-4d3e-8b27-eae61ba75824.png)

# 2. Project Skeleton Overview

You will be given a **skeleton**, containing a **certain architecture (MVC)** with **several classes**, some of which are completely empty. 
The **Skeleton** will include the **files** with which you will **seed** the **database**.

# 3. Model Definition

There are 4 main models that the **Real Estate Agency database** application should contain in its functionality.

Design them in the **most appropriate** way, considering the following **data constraints**:

### Town

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **town name** - accepts **char sequences** as valueswhere their character length value is **higher than or equal to 2**. The values are **unique in the database**.
- **population** - accepts **number** values (must be positive), 0 as a value is **exclusive**.

### Agent

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **first name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 2.** The values are **unique in the database**.
- **last name** - accepts **char sequences** as valueswhere their character length value **higher than or equal to 2**.
- **email** - an **email** - (must contains '@' and '.' -- dot). The email of a seller is **unique**.
- **Constraint**: The agents table has а relation with the towns table. 

### Apartment

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **apartment type** - the enumeration, one of the following - **two_rooms, three_rooms, four_rooms**
- **area** - accepts **number** values that are **more** than or **equal** to **40.00.**
- **Constraint**: The apartment table has а relation with the towns table. 

### Offer    

- **id** - accepts **integer** values, a **primary identification field, an auto incremented field**.
- **price** - accepts a **positive number**.
- **published on** - a date in the "**dd/MM/yyyy**" format.
- **Constraint**: The offers table has a relation with the apartments table.  
- **Constraint**: The offers table has a relation with the agents table.  

#### Relationships

Your partners gave you a little hint about the more complex relationships in the database, so that you can implement it correctly.

One **Agent** may have only one **Town**, but one **Town** may have many **Agents**.

One **Apartment** may have only one **Town**, but one **Town** may have many **Apartments**.

One **Offer** may have only one **Apartment**, but one **Apartment** can be in many **Offers**.

One **Offer** may have only one **Agent**, but one **Agent** can have many **Offers**.

**Constraint**:

- Name the entities and their class members **exactly** in the **format stated** above.
- All fields are **NOT NULL** unless explicitly stated to be nullable.

![image](https://user-images.githubusercontent.com/87463484/167253403-712d1522-9435-4eb6-bb09-c7344b836d6c.png)

# 4. Data Import

Use the provided files to populate the database with data. Import all the information from those files into the database.

**You are not allowed to modify the provided files.**

**ANY INCORRECT** data should be **ignored** and a message:

   "**Invalid {town / agent / apartment / offer}**" should be printed.

**When the import is finished:**

"**Successfully imported {town / agent / apartment / offer} {name - population / first name last name / type - area / price}**"

### JSON Import

Your new colleagues have prepared some JSON data for you to import.

| **Towns (towns.json)** |
| --- |
| \[                                                                |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "Matingain",     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": 2162142        |
| &nbsp;&nbsp; },                                                   |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "Frankfurt",     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": -140256        |
| &nbsp;&nbsp; },                                                   |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "Prague",        |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": 2651904        |
| &nbsp;&nbsp; },                                                   |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "Tubuhue",       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": 1886927        |
| &nbsp;&nbsp; },                                                   |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "General Vedia", |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": 1592612        |
| &nbsp;&nbsp; },                                                   |
| &nbsp;&nbsp; {                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "townName": "Xunzhong",      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "population": 3091280        |
| &nbsp;&nbsp; },                                                   |
| ...                                                               |
|                                                                   |
| Successfully imported town Matingain - 2162142                    |
| Invalid town                                                      |
| Successfully imported town Prague - 2651904                       |
| Successfully imported town Tubuhue - 1886927                      |
| Successfully imported town General Vedia - 1592612                |
| Successfully imported town Xunzhong - 3091280                     |
| …                                                                 |

**Constraint:**

- **If the agent's first name already exists in the DB return "Invalid agent".**

| **Agents (agents.json)** |
| --- |
| \[                                                                         |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Rodrique",              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Scoffham",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Skopje",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "nbattman0@reverbnation.com" |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Griffie",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Fuzzens",                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Amsterdam",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "cfitchell1@edublogs.org"    |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Griffie",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Bergman",                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Oslo",                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "cfitcl1@ublogs.com"         |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Kimberlee",             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Goshawk",                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Oslo",                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "alosty2@slate.com"          |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "s",                     |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Petet",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Amsterdam",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "fal1@edugs.org"             |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Rickys",                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "D",                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Minsk",                      |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "shell1@blogs.org"           |
| &nbsp;&nbsp; },                                                            |
| &nbsp;&nbsp; {                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "firstName": "Erastus",               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "lastName": "Clute",                  |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "town": "Oslo",                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "email": "blefeaver3@cpanel.net"      |
| &nbsp;&nbsp; },                                                            |
|   . . .                                                                    |
|                                                                            |
| Successfully imported agent - Rodrique Scoffham                            |
| Successfully imported agent - Griffie Fuzzens                              |
| Invalid agent                                                              |
| Successfully imported agent - Kimberlee Goshawk                            |
| Invalid agent                                                              |
| Invalid agent                                                              |
| Successfully imported agent - Erastus Clute                                |
| …                                                                          |

### XML Import

Your new colleagues have prepared some XML data for you to import.

**Constraint:**

- **If the apartment with the same town name and area already exists in the DB return "Invalid apartment".**
- **The provided town names will always be valid**.

| **Apartments (apartments.xml)** |
| --- |
| \<?xml version='1.0' encoding='UTF-8'?>                                                                                          |
| \<apartments>                                                                                                                    |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartmentType>three_rooms</apartmentType> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<area>53.47</area>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>Lille</town>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartmentType>two_rooms</apartmentType>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<area>87.72</area>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>Nicosia</town>                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartmentType>three_rooms</apartmentType> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<area>63.52</area>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>Sofia</town>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartmentType>two_rooms</apartmentType>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<area>53.47</area>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>Lille</town>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                                               |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartmentType>two_rooms</apartmentType>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<area>40.45</area>                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<town>Nicosia</town>                       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                                               |
| ...                                                                                                                              |
|                                                                                                                                  |
| Successfully imported apartment three_rooms - 53.47                                                                              |
| Successfully imported apartment two_rooms - 87.72                                                                                |
| Successfully imported apartment three_rooms - 63.52                                                                              |
| Invalid apartment                                                                                                                |
| Successfully imported apartment two_rooms - 40.45                                                                                |
| ...                                                                                                                              |

**Constraint:**

- **If agent with the given name doesn't already exist in the DB return "Invalid offer".**
- **The provided apartment ids will always be valid.**
- **Format the price to the second digit after the decimal point.**

| **Offers (offer.xml)** |
| --- |
| \<?xml version='1.0' encoding='UTF-8'?>                                                                                                                    | 
| \<offers>                                                                                                                                                  | 
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<offer>                                                                                                              | 
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>206934.00</price>                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<agent>                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Dotti</name>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</agent>                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>56</id>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<publishedOn>28/12/2005</publishedOn>                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</offer>                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<offer>                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>178562.00</price>                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<agent>                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Pablo</name>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</agent>                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>21</id>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<publishedOn>18/11/2011</publishedOn>                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</offer>                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<offer>                                                                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>857076.00</price>                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<agent>                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Glennie</name> |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</agent>                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>49</id>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<publishedOn>26/07/2005</publishedOn>                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</offer>                                                                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<offer>                                                                                                              | 
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<price>648855.00</price>                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<agent>                                                              |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<name>Chadd</name>   |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</agent>                                                             |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<apartment>                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<id>58</id>          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</apartment>                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<publishedOn>25/08/2014</publishedOn>                                |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \</offer>                                                                                                             |
| ...                                                                                                                                                        |
| Successfully imported offer 206934.00                                                                                                                      |
| Invalid offer                                                                                                                                              |
| Successfully imported offer 857076.00                                                                                                                      |
| Successfully imported offer 648855.00                                                                                                                      |

# 5. Data Export

Get ready to export the data you have imported in the previous task. Here you will have some complex database querying. Export the data in the formats specified below.

#### Export The Best Offers from the Data Base

- Extract from the database, the **agent full name, offer's id, apartment area (to second digit after decimal point), town name of the apartment** and 
  the **price (to second digit after decimal point)** of the **offer**.
- **Filter only three_rooms apartments and order them by the area in descending order, then by the price in ascending order.**
- Return the information in this format:
- **"Agent {firstName} {lastName} with offer №{offerId}:** <br>
          **-Apartment area: {area}** <br>
          **--Town: {townName}** <br>
          **---Price: {price}$** <br>
**. . . "**

![image](https://user-images.githubusercontent.com/87463484/167254524-84481090-4cea-429f-9a37-f20eec8b90cb.png)

