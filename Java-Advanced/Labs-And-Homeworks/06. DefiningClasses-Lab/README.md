# 1.	Car Info

Create a class named Car.

The class should have **public** fields for:

- Brand: **String**
- Model: **String**
- Horsepower: **int**

### Create Car Info Method

This method should return the info about any car object in the following format:

**"The car is: {brand} {model} - {horsePower} HP."**

You have to figure out how to create a method and to use it in the outside code as shown below:

![image](https://user-images.githubusercontent.com/87463484/142365680-afd139e4-39cb-4a9a-bb2b-cc2b6dc43c68.png)

### Test the Program 

Read a cars objects, add them to collection of your choice and the print each one on the console using the **carInfo()** method. The input consists of single integer **N** 
the number of lines representing car objects. One each line you will read car info in the following format **{brand} {model} {horsePower}** separated by single space.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 3                    | The car is: Chevrolet Impala - 390 HP. |
| Chevrolet Impala 390 | The car is: Mercedes Benz - 500 HP.    |
| Mercedes Benz 500    | The car is: Volga 24 - 49 HP.          |
| Volga 24 49          |
| **Input** | **Output** | 
| 5               | The car is: This Car - 1 HP.      |
| This Car 1      | The car is: Was Made - 2 HP.      |
| Was Made 2      | The car is: Only For - 3 HP.      |
| Only For 3      | The car is: Test Purposes - 4 HP. |
| Test Purposes 4 | The car is: No Way - 5 HP.        |
| No Way 5        |

# 2.	Car Constructors

Make proper constructors for the Car class so you can create car objects with different type of input information.

If you miss information about field of **type String** set the value to **"unknown"**,and for **integer** field set **-1.**

Read information about car the same way as the previous task, however this time use **constructors** to create the objects, not creating object with the **default** constructor.
You should be able to handle **different types** of input, the format will be the same as the previous task, but this time some of the data may be missing. 
For an example you can get only the car **brand** - which means you have to set the car model to **"unknown"** and the Horsepower value to **-1**. 
There will be lines with **complete** car data, declare constructor which sets all the fields.

You have to add the car objects to a **collection** of your choice and print the data as in the previous task. The input will **always** have one or three elements on each line.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 2            | The car is: Chevrolet unknown - -1 HP. |
| Chevrolet    | The car is: Golf Polo - 49 HP.         |
| Golf Polo 49 |
| **Input** | **Output** | 
| 4               | The car is: Was unknown - -1 HP.  |
| Was             | The car is: Only For - 3 HP.      |
| Only For 3      | The car is: Test Purposes - 4 HP. |
| Test Purposes 4 | The car is: No Way - 5 HP.        |
| No Way 5        |

# 3.	Bank Account

Create class **BankAccount**.

The class should have **private fields** for:

- Id: **int** (Starts from **1** and **increments** for every **new account**)
- Balance: **double**
- Interest rate: **double** (Shared for all accounts. **Default value: 0.02**)

The class should also have **public** methods for:

- **setInterestRate(double interest): void (static)**
- **getInterest(int Years): double**
- **deposit(double amount): void**

Create a test client supporting the following commands:

- **Create**
- **Deposit {Id} {Amount}**
- **SetInterest {Interest}**
- **GetInterest {ID} {Years}**
- **End**

### Examples

| **Input** | **Output** | 
| --- | --- |
| Create           | Account ID1 created |
| Deposit 1 20     | Deposited 20 to ID1 |
| GetInterest 1 10 | 4.00                |
| End              |
| **Input** | **Output** | 
| Create          | Account ID1 created    |
| Create          | Account ID2 created    |
| Deposit 1 20    | Deposited 20 to ID1    |
| Deposit 3 20    | Account does not exist |
| Deposit 2 10    | Deposited 10 to ID2    |
| SetInterest 1.5 | 30.00                  |
| GetInterest 1 1 | 15.00                  |
| GetInterest 2 1 | Account does not exist |
| GetInterest 3 1 |
| End             |
