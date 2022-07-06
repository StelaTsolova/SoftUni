# Problem 1. Mails Delivery

**Use the provided skeleton to solve this problem.**

**Note**: You **can't** and you have no permission to **change** directly the given HTML code (index.html file).

![image](https://user-images.githubusercontent.com/87463484/177511843-a32ccbca-3f63-4eb3-9004-9250ea914609.png)

**Your Task**

**Write the missing JavaScript code** to make the **Mails Delivery** work as expected:

## 1. Getting the information from the form

![image](https://user-images.githubusercontent.com/87463484/177511921-6ce2e049-ef34-440c-b45a-cf9b45b0da0f.png)

- **All fields** are **non-empty strings**. If any of them are empty, the program should not do anything.

- When you click the **\["Add to the List"]** button, the information from the input fields must be added to the **ul** in **div** with **class ="list-mails"**, 
  and **inputs** must be cleared. The **structure** must be:

![image](https://user-images.githubusercontent.com/87463484/177511955-e438e7a3-2f1b-44d2-91a2-b25c8fa3cb6e.png)

- The **Title** and **Recipient Name** must be saved in the **h4** tag and the message in the **span** tag.

- The Buttons - **Send** and **Delete** - are in **div** with **id="list-action"**.

![image](https://user-images.githubusercontent.com/87463484/177512217-3dc1d01d-dcf4-44f2-8c6c-309f44200ced.png)

- When you click **\["Reset"]**, the information from the inputs should be **cleared**, without any other changes.

## 2. Send Mails

- When the **\["Send"]** button is clicked, the information must be sent to the **Sent Mails** and the **li** tag should be deleted from the **List of Mails**.

-	The **structure** must be:

![image](https://user-images.githubusercontent.com/87463484/177512440-bfe9e883-f399-4a53-a209-4dce853f143d.png)

- The **Title** and **Recipient Name** must both be saved in the **span** tag.
- The **Button, Delete**, is in **div** with **class="btn"**.

## 3. Delete Mails

- When you click the **\["Delete"]** button, the information on either the **List of mails** or the **Sent mails** div, 
  the information must be sent to the **Delete Mails** and the record should be deleted from the **List of Mails** or **Sent Mails**.

![image](https://user-images.githubusercontent.com/87463484/177512649-574d0edc-73d3-4bee-8840-efad7cabed1c.png)

![image](https://user-images.githubusercontent.com/87463484/177512701-9f5b2da0-e652-40c8-8412-0ccd757a53dd.png)

![image](https://user-images.githubusercontent.com/87463484/177512712-950a3920-ec95-48a8-82dc-b4511dba1c48.png)

- The **structure** must be:

![image](https://user-images.githubusercontent.com/87463484/177512770-9fe37f05-8c85-4450-a8f6-ad49f77672b2.png)

# Problem 2. Car Dealership

![image](https://user-images.githubusercontent.com/87463484/177512856-9223edd2-8f99-4f08-a16d-f86179bf1327.png)

Write a class **CarDealership**, which implements the following functionality:

## Functionality

**Constructor**

Should have these **4** properties:

- **name** - String
- **availableCars** - Array
- **soldCars** - Array
- **totalIncome** - **default: 0**

**At the initialization of the CarDealership class**, the **constructor** accepts the **name**. The **totalIncome** has a **default value of 0!** 
The rest of the properties must be **empty**!

**addCar (model, horsepower, price, mileage)** - This method should **add a new car** to the dealership. The method accepts **4 arguments**:

- If any of the following requirements is **NOT fulfilled**, an **error** with the following message should be **thrown**: **"Invalid input!"**
  - **Model** - non-empty string;
  - **Horsepower** - positive integer number;
  - **Price** - positive number;
  - **Mileage** - positive number.

**Hint**: Zero is also a positive number.

- Otherwise, you should **add the car**, with properties: **{model, horsepower, price, mileage}** to the **availableCars** array and **return**:

**"New car added: {model} - {horsepower} HP - {mileage} km - {price}$"**

- When **returning** the result, the **Mileage and Price** mustbe **rounded to the second decimal point!**

**sellCar (model, desiredMileage)** - This method should **search for a car** with the given **model** in the **availableCars** array, and then **sell** it.
Accepts **2 arguments**.

- If a car with the given **model** cannot be found, an error with the following message should be **thrown**:

**"{model} was not found!"**

- If you **find the car with the given model**, you should look up its **mileage**. The person who wants to buy it has a simple request. 
  He is looking for a car with a **mileage** that is **less or equal** to his **desired mileage**. To ensure the sale of the car you must make a bargain:
  - If the **found** car's mileage is **less than or equal to** the **desiredMileage** - the price stays the same!
  - If the **difference** between the **car's mileage** and the **desiredMileage** is less or equal to **40.000 km** - the price gets **deducted by 5%**!
  - If the **difference** between the **car's mileage** and the **desiredMileage** is more than **40.000 km** - the price gets **deducted by 10%**!

- You should **remove** the car from the **availableCars** array and **add** it to the **soldCars** array in the following format: **{model, horsepower, soldPrice}**

- Finally, you must add the **soldPrice** to the **totalIncome** and return:

**"{model} was sold for {soldPrice}$"**

**Note: soldPrice** must be **rounded** to the second decimal point!

**currentCar ()**  - This method should just return all available cars separated by a new line in format:

**"-Available cars:**\
**---{model} - {horsepower} HP - {mileage} km - {price}$**\
**---{model} - {horsepower} HP - {mileage} km - {price}$"**

**Note: mileage** and **price** must be **rounded** to the second decimal point!

- If there are **no available** cars, just return:

**"There are no available cars"**

**salesReport (criteria)** - This method accepts 1 argument. It should **sort** the sold cars, **based on a given criterion**. 
The two possible criteria are - **"horsepower"** or **"model"**

- If the given criteria **do not match** either of the possible criteria, an **error** with the following message should be **thrown**:

**"Invalid criteria!"**

- If the given criteria is **"horsepower"** - the sold **cars** must be **sorted** by their **horsepower** in **descending order**;

- If the given criteria is **"model"** - the sold cars must be **sorted alphabetically** by their **model**;

- Finally, **return all sorted** sold cars **separated** by **a new line** in format:

**"-{dealershipName} has a total income of {totalIncome}$**\
**-{soldCarsCount} cars sold:**\
**---{model} - {horsepower} HP - {price}$**\
**---{model} - {horsepower} HP - {price}$"**\
**...**

**Note: totalIncome and price must be rounded to the second decimal point!**

### Example

| **Input 1** | **Output 1** |
| --- | --- |
| let dealership = new CarDealership('SoftAuto');                      | New car added: Toyota Corolla - 100 HP - 190000.00 km - 3500.00$ |
| console.log(dealership.addCar('Toyota Corolla', 100, 3500, 190000)); | New car added: Mercedes C63 - 300 HP - 187000.00 km - 29000.00$  |
| console.log(dealership.addCar('Mercedes C63', 300, 29000, 187000));  | Uncaught Error Error: Invalid input!                             |
| console.log(dealership.addCar('', 120, 4900, 240000));               |                                                                  |

| **Input 2** | **Output 2** |
| --- | --- |
| let dealership = new CarDealership('SoftAuto');            | Toyota Corolla was sold for 3500.00$ |
| dealership.addCar('Toyota Corolla', 100, 3500, 190000);    | Mercedes C63 was sold for 26100.00$  |
| dealership.addCar('Mercedes C63', 300, 29000, 187000);     |                                      |
| dealership.addCar('Audi A3', 120, 4900, 240000);           |                                      |
| console.log(dealership.sellCar('Toyota Corolla', 230000)); |                                      |
| console.log(dealership.sellCar('Mercedes C63', 110000));   |                                      |

| **Input 3** | **Output 3** |
| --- | --- |
| let dealership = new CarDealership('SoftAuto');         | -Available cars:                                     |
| dealership.addCar('Toyota Corolla', 100, 3500, 190000); | ---Toyota Corolla - 100 HP - 190000.00 km - 3500.00$ |
| dealership.addCar('Mercedes C63', 300, 29000, 187000);  | ---Mercedes C63 - 300 HP - 187000.00 km - 29000.00$  |
| dealership.addCar('Audi A3', 120, 4900, 240000);        | ---Audi A3 - 120 HP - 240000.00 km - 4900.00$        |
| console.log(dealership.currentCar());                   |                                                      |

| **Input 4** | **Output 4** |
| --- | --- |
| let dealership = new CarDealership('SoftAuto');         | -SoftAuto has a total income of 29600.00$ |
| dealership.addCar('Toyota Corolla', 100, 3500, 190000); | -2 cars sold:                             |
| dealership.addCar('Mercedes C63', 300, 29000, 187000);  | ---Mercedes C63 - 300 HP - 26100.00$      |
| dealership.addCar('Audi A3', 120, 4900, 240000);        | ---Toyota Corolla - 100 HP - 3500.00$     |
| dealership.sellCar('Toyota Corolla', 230000);           |                                           |
| dealership.sellCar('Mercedes C63', 110000);             |                                           |
| console.log(dealership.salesReport('horsepower'));      |                                           |

# 3. Rent Car

## Your Task

Using **Mocha** and **Chai** write **JS Unit Tests** to test a variable named **rentCar**, which represents an object. You may use the following code as a template:

![image](https://user-images.githubusercontent.com/87463484/177515687-02d54cf3-6b23-42da-8b68-1433eb379c3e.png)

The object that should have the following functionality:

- **searchCar(shop, model)** - A function that accepts two parameters (one array and one string):
  - The function checks whether the submitted string **model** is present in the **shop** (example: **\["Volkswagen", "BMW", "Audi"])**, 
    and return number of matching elements and the model of the car in the message: **\`There is \$\{findModel\.length\} car of model \$\{model\} in the catalog!\`**;
  - There is a need for validation of the input, a shop and a model mаy not always be valid. In case of submitted invalid parameters, **throw** an error **"Invalid input!"**;
  - If there are no matching elements, the function **throw** an error: **'There are no such models in the catalog!'**

- **calculatePriceOfCar(model, days)** - A function that accepts two parameters (string and number):
  - There is a need for validation of the input, a **model**, and **days** mаy not always be valid. In case of submitted invalid parameters, 
    **throw** an error **"Invalid input!"**;
  - The function returns the model and the price it will cost for renting a car for the given days: **\`You choose ${model} and it will cost $${cost}!`**;
  - Otherwise, if there is no such model, the function **throw** an error: **'No such model in the catalog!'.**

- **checkBudget(costPerDay, days, budget)**  - A function that accepts three parameters (numbers):
  - There is a need for validation of the input, a **costPerDay, days, and a budget** mаy not always be valid. In case of submitted invalid parameters, 
    **throw** an error **"Invalid input!"**;
  - If the budget is bigger or equal to cost, function return: **\`You rent a car!`;**
  - If the budget is less than cost, the function returns the message: **'You need a bigger budget!'.**

### JS Code

To ease you in the process, you are provided with an implementation that meets all of the specification requirements for the **rentCar** object:

| **rentCar.js** |
| --- |
| ![image](https://user-images.githubusercontent.com/87463484/177516571-f75f9bdb-9e8d-4973-9f75-568661cfd99e.png) |








