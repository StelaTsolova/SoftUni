# 1. Database Models

Start by setting up the database models. Each one of them will be as follows:

- **User**
  - **Id** - long value, **primary key**
  - **Username** - **unique** for each user
  - **Age** - integer value
  - **Accounts** - each user can have **many accounts**, which will be **identified by their id**
 
- **Account**
  - **Id** - long value, **primary key**
  - **Balance** - BigDecimal
  - **User** - an account can be owned by a **single user**

Set up appropriate tables, columns, column properties and table relations.

# 2. Repositories

Spring Data reduces the amount of boiler-plate code by using a central interface **Repository**.\
The **JpaRepository** interface contains methods like:

- **save(E entity)**
- **findOne(Id primaryKey)**
- **findAll()**
- **count()**
- **delete(E entity)**
- **exists(Id primaryKey)**

You can define a **custom repository**, which extends the **JpaRepository** and defines several methods for operating with data besides those exposed by 
the greater interface. The query builder mechanism of Spring Data requires following several rules when you define custom methods. 
Query creation is done by parsing method names by prefixes like **find...By, read...By, query...By, count...By**, and **get...By**. 
You can add more criteria by concatenating **And** and **Or** or apply ordering with **OrderBy** with sorting direction **Asc** or **Desc**.

Create two Repository interfaces - **UserRepository** and **AccountRepository**.

![image](https://user-images.githubusercontent.com/87463484/163946986-f08ef87b-ac4b-4198-9222-bdc3c1f89271.png)

![image](https://user-images.githubusercontent.com/87463484/163946999-c17e2d0d-8dd9-4a1f-914b-f8eb09b1faaa.png)

Add several methods to help you look up the data source, for example **getByUsername(String username)** in the **UserRepository** interface.

# 4. Services

In bigger applications mixing business logic and crud operations to the database is not wanted. Having a repository objects is implementing 
the **Domain Driven Design**. Repositories are classes responsible **only for write/transactional operations** towards the data source. 
Any business logic like validation, calculations and so on is implemented by **a Service Layer**. One of the most important concepts to keep in mind is 
that a **service** should **never expose details of the internal processes,** or the business entities used within the application.

Define several service **interfaces**:

![image](https://user-images.githubusercontent.com/87463484/163947146-e86c720a-ae9d-45e9-ba7a-6db20ccd0a17.png)

![image](https://user-images.githubusercontent.com/87463484/163947160-468d565a-1c66-4230-a1c8-db579d0c1776.png)

Implement those services with classes **AccountServiceImpl** and **UserServiceImpl**. Those classes will do the business logic of the application. 
To do that, they should have certain type of **Repository** available - **AccountRepository** or **UserRepository** according to the service type.

![image](https://user-images.githubusercontent.com/87463484/163950849-9f940823-c2c4-4749-95fd-5c78153a79da.png)

![image](https://user-images.githubusercontent.com/87463484/163950908-870bb68e-ae89-4236-8f1e-41d3f82f2842.png)

In Spring Data Framework, the usage of **@Service, @Repository** or **@Component** annotations is needed to separate different "**layers**" in the application. 
They are mainly used for programmers to know a class's role and which logical layer it belongs to.

The **@Autowired** annotation is required when **injecting a resource**, e.g., **Repository** to **Service**.

The implementation of the methods is up to you. Here are some several tips:

- **AccountServiceImpl**
  - Money withdrawal - should only happen if account **is present** in the database, **belongs to user** and **has enough balance**
  - Money transfer - should only happen if **account belongs to user** and transfer value **is not negative**
  
- **UserServiceImpl**
  - User registration - should only happen if user does not exist in the database

# 5. ConsoleRunner and Application

We will test our application in a ConsoleRunner class. Create such and inject needed repositories:

![image](https://user-images.githubusercontent.com/87463484/163951192-4526c27a-b69b-483d-9a77-02511aca1459.png)

# 6. Test

Test the application by adding some logic in the **ConsoleRunner** class's method **run**:

![image](https://user-images.githubusercontent.com/87463484/163951249-d4d98282-341c-4a7d-a73b-bc8aa1fe344d.png)

If you have written everything correctly, an **account_system** database should be created with tables:

- **users**
- **accounts**
- **users_accounts**
