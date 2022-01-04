# 1.	Car Shop

Build hierarchy from **classes** and **interfaces** for this UML diagram:

![1](https://user-images.githubusercontent.com/87463484/148085350-b7503660-ab4e-4cf2-8fc2-7b91b6ef617a.png)

Your hierarchy have to be used with this code

| **Main.java** |
| --- |
| public static void main(String[] args) {                  |
| &nbsp; Car seat = new Seat("Leon", "gray", 110, "Spain"); |
| <br>                                                      |
| &nbsp; System.out.println(String.format(               |
| &nbsp;&nbsp;&nbsp;&nbsp; "%s is %s color and have %s horse power",    |
| &nbsp;&nbsp;&nbsp;&nbsp; seat.getModel(),                             |
| &nbsp;&nbsp;&nbsp;&nbsp; seat.getColor(),                             |
| &nbsp;&nbsp;&nbsp;&nbsp; seat.getHorsePower()));                      |
| &nbsp; System.out.println(seat.toString());                |
| }                                                         |

### Examples

| **Input** | **Output** |  
| --- | --- |![148087678-6fe39e4c-f160-4e19-a6ae-1b8c4f282cf8](https://user-images.githubusercontent.com/87463484/148089430-fa71ab09-8719-47a6-a679-f5bb081b37c2.png)

| | Leon is gray color and have 110 horse power     |
| | This is Leon produced in Spain and have 4 tires |

# 2.	Car Shop Extend

Extend previous problem: 

![2](https://user-images.githubusercontent.com/87463484/148086151-5bb1855f-e9fc-4d76-95b1-09a875a9d579.png)

Your hierarchy has to be used with this code:

| **Main.java** |
| --- |
| public static void main(String[] args) {                                |
| &nbsp; Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1); |
| &nbsp; Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9); |
| <br>                                                                    |
| &nbsp; printCarInfo(seat);                                              |
| &nbsp; printCarInfo(audi);                                              |
| }                                                                       |
| <br>                                                                    |
| private static void printCarInfo(Car car) {                             |
| &nbsp;System.out.println(String.format(                                 |
| &nbsp;&nbsp;&nbsp;&nbsp; "%s is %s color and have %s horse power",      |
| &nbsp;&nbsp;&nbsp;&nbsp; car.getModel(),                                |
| &nbsp;&nbsp;&nbsp;&nbsp; car.getColor(),                                |
| &nbsp;&nbsp;&nbsp;&nbsp; car.getHorsePower()));                         |
| &nbsp; System.out.println(car.toString());                              |
| }                                                                       |

### Examples

| **Input** | **Output** |  
| --- | --- |
| | Leon is Gray color and have 110 horse power              |
| | This is Leon produced in Spain and have 4 tires          |
| | Leon sells for 11111,100000                              |
| | A4 is Gray color and have 110 horse power                |
| | This is A4 produced in Germany and have 4 tires          |
| | Minimum rental period of 3 days. Price per day 99,900000 |

# 3.	Say Hello

Build hierarchy from classes and interfaces for this **UML** diagram:

![3](https://user-images.githubusercontent.com/87463484/148086927-862286a8-b594-4e52-a04e-f39334ba01a4.png)

Your hierarchy have to be used with this code:

| **Main.java** |
| --- |
| public static void main(String[] args) {           |
| &nbsp; List<Person\> persons = new ArrayList<\>(); |
| <br>                                               |
| &nbsp; persons.add(new Bulgarian("Peter"));        |
| &nbsp; persons.add(new European("Peter"));         |
| &nbsp; persons.add(new Chinese("Peter"));          |
| <br>                                               |
| &nbsp; for (Person person : persons) {             |
| &nbsp;&nbsp;&nbsp; print(person);                  |
| &nbsp;}                                            |
| }                                                  |
| <br>                                               |
| private static void print(Person person) {         |
| &nbsp; System.out.println(person.sayHello());      |
| }                                                  |

### Examples

| **Input** | **Output** |  
| --- | --- |
| | Здравей     |
| | Hello       |
| | Djydjybydjy |

# 4.	Say Hello Extend

Build hierarchy from classes and interfaces for this **UML** diagram

![4](https://user-images.githubusercontent.com/87463484/148087678-6fe39e4c-f160-4e19-a6ae-1b8c4f282cf8.png)

Your hierarchy have to be used with this code:

| **Main.java** |
| --- |
| public static void main(String[] args) {           |
| &nbsp; List<Person\> persons = new ArrayList<\>(); |
| <br>                                               |
| &nbsp; persons.add(new Bulgarian("Peter"));        |
| &nbsp; persons.add(new European("Peter"));         |
| &nbsp; persons.add(new Chinese("Peter"));          |
| <br>                                               |
| &nbsp; for (Person person : persons) {             |
| &nbsp;&nbsp;&nbsp; print(person);                  |
| &nbsp;}                                            |
| }                                                  |
| <br>                                               |
| private static void print(Person person) {         |
| &nbsp; System.out.println(person.sayHello());      |
| }                                                  |

### Examples

| **Input** | **Output** |  
| --- | --- |
| | Здравей     |
| | Hello       |
| | Djydjybydjy |

# 5.	Border Control

It's the future, you're the ruler of a totalitarian dystopian society inhabited by **citizens** and **robots**, 
since you're afraid of rebellions you decide to implement strict control of who enters your city. Your soldiers check the **Id**s of everyone who enters and leaves.

You will receive from the console an **unknown** amount of lines until the command "**End**" is received, 
on each line there will be the information for either **a citizen** or **a robot** who tries to enter your city in the format\
**"{name} {age} {id}"** for citizens and "**{model} {id}**" for robots.

After the end command on the next line you will receive a single number representing **the last digits of fake ids**, 
all citizens or robots whose **Id** ends with the specified digits must be detained.

The output of your program should consist of all detained **Id**s each on a separate line (the order of printing doesn't matter).

![5](https://user-images.githubusercontent.com/87463484/148088381-62987fd8-d03e-4eb5-9f08-227d98433805.png)

### Examples

| **Input** | **Output** |  
| --- | --- |
| Peter 22 9010101122 | 9010101122 |
| MK-13 558833251     | 33283122   | 
| MK-12 33283122      |
| End                 |
| 122                 |
| **Input** | **Output** | 
| Teo 31 7801211340   | 7801211340 |
| Anna 29 8007181534  |
| IV-228 999999       |
| Simon 54 3401018380 |
| KKK-666 80808080    |
| End                 |
| 340                 |

# 6.	Ferrari

Model an application which contains a **class Ferrari** and an **interface**. Your task is simple, you have a **car - Ferrari**, its model is **"488-Spider"** and 
it has a **driver**. Your Ferrari should have functionality to **use brakes** and **push the gas pedal**. When the **brakes** are pushed down print **"Brakes!"**, 
and when the **gas pedal** is pushed down - **"brum-brum-brum-brrrrr"**. As you may have guessed this functionality is typical for all cars, 
so you should **implement an interface** to describe it.

Your task is to **create a Ferrari** and **set the driver's name** to the passed one in the input. After that, print the info. 
Take a look at the Examples to understand the task better.

![6](https://user-images.githubusercontent.com/87463484/148089046-de0d84c4-6a00-446c-a16e-aa23a6f854d3.png)

### Input

On the **single input line**, you will be given the **driver's name**.

### Output

On the **single output line**, print the model, the messages from the brakes and gas pedal methods and the driver's name. In the following format:

**"{model}/{brakes}/{gas}/{driver's name}"**

### Constraints

**The input will always be valid, no need to check it explicitly!** The Driver's name may contain any ASCII characters.

### Examples

| **Input** | **Output** |  
| --- | --- |
| Dominic Toretto | 488-Spider/Brakes!/brum-brum-brum-brrrrr/Dominic Toretto |
| **Input** | **Output** | 
| Brian O'Conner | 488-Spider/Brakes!/brum-brum-brum-brrrrr/Brian O'Conner |
