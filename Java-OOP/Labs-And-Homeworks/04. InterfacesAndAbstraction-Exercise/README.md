# 1.	Define an Interface Person

Define an interface **Person** with methods getName and getAge. Define a class **Citizen** which implements **Person** and 
has a constructor which takes a String **name** and an int **age**.

| **<<Interface\>\>** <br> **Person** | | **Citizen** |
| --- | --- | --- |
| +	getName() : String | | -	name: String        |
| +	getAge() : int     | | -	age: int            |
|                      | |                        |
|                      | |+	Citizen (String, int) |
|                      | |+	getName() : String    |
|                      | |+	getAge() : int        |

~~~
public static void main(String[] args) {
    Class[] citizenInterfaces = Citizen.class.getInterfaces();
    if(Arrays.asList(citizenInterfaces).contains(Person.class)){
        Method[] fields = Person.class.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Person person = new Citizen(name,age);
        System.out.println(fields.length);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
~~~

### Examples

| **Input** | **Output** |   
| --- | --- |
| Peter | 2     |
| 25    | Peter |
|       | 25    | 
| **Input** | **Output** |  
| John | 2    |
| 34   | John |
|      | 34   |

# 2.	Multiple Implementation

Using the code from the previous task, define an interface Identifiablewith a **String** method getId and an interface Birthable with a **String** method getBirthDate and 
implement them in the Citizen class. Rewrite the **Citizen** constructor to accept the new parameters.

| **<<Interface\>\>** <br> **Identifiable** | | **<<Interface\>\>** <br> **Birthable** | | **<<Interface\>\>** <br> **Person** |
| --- | --- | --- | --- | --- |
| +	getId(): String | | +	getBirthDate(): String | | +	getName(): String |
|                   | |                          | | +	getAge(): int     |

| **Citizen** | 
| --- |
| -	name: String                         |
| -	age: int                             |
| -	id: String                           |
| -	birthDate: String                    |
|                                        |
| +	Citizen(String, int, String, String) |
| +	getName(): String                    |
| +	getAge(): int                        |
| +	getId(): String                      |
| +	getBirthDate(): String               |
| +	toString(): String                   |

~~~
public static void main(String[] args) {
    Class[] citizenInterfaces = Citizen.class.getInterfaces();
    if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
            && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
        Method[] methods = Birthable.class.getDeclaredMethods();
        Method[] methods1 = Identifiable.class.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String id = scanner.nextLine();
        String birthDate = scanner.nextLine();
        Identifiable identifiable = new Citizen(name,age,id,birthDate);
        Birthable birthable = new Citizen(name,age,id,birthDate);
        System.out.println(methods.length);
        System.out.println(methods[0].getReturnType().getSimpleName());
        System.out.println(methods1.length);
        System.out.println(methods1[0].getReturnType().getSimpleName());
    }
}
~~~

### Examples

| **Input** | **Output** |   
| --- | --- |
| Peter      | 1      |
| 25         | String |
| 9105152287 | 1      |
| 15/05/1991 | String |

# 3.	Birthday Celebrations

It is a well known fact that people celebrate birthdays, it is also known that some people also celebrate their pets birthdays. 
Extend the program from your last task to add **birthdates** to citizens and include a class **Pet**, pets have a **name** and a **birthdate**. 
Also create class Robot which has an **id** and **model**. Encompass repeated functionality into interfaces and implement them in your classes.

You will receive from the console an unknown amount of lines until the command "**End**" is received,  each line will contain information in one of the following formats 
**"Citizen {name} {age} {id} {birthdate}"** for citizens, "**Robot {model} {id}**" for robots or "**Pet {name} {birthdate}**" for pets. 
After the end command on the next line you will receive a single number representing **a specific year**, 
your task is to print all birthdates (of both citizens and pets) in that year in the format "**{day}/{month}/{year}**" (the order of printing doesn't matter).

| **<<Interface\>\>** <br> **Identifiable** | | **<<Interface\>\>** <br> **Birthable** | 
| --- | --- | --- |
| +	getId(): String | | +	getBirthDate(): String |

| **Citizen** | | **Robot** | | **Pet** | 
| --- | --- | --- | --- | --- |
| -	name: String                         | | -	id: String            | | -	name: String           |
| -	age: int                             | | -	model: String         | | -	birthDate: String      |
| -	id: String                           | |                          | |                          |
| -	birthDate: String                    | | +	Robot(Stirng, String) | | +	Pet(Stirng, String)    |
|                                        | | +	getId(): String       | | +	getName(): String      |
| +	Citizen(String, int, String, String) | | +	getModel(): String    | |+	getBirthDate(): String |
| +	getName(): String                    |
| +	getAge(): int                        |
| +	getId(): String                      |

### Examples

| **Input** | **Output** |   
| --- | --- |
| Citizen Peter 22 9010101122 10/10/1990 | 10/10/1990 |
| Pet Sharo 13/11/2005                   | 
| Robot MK-13 558833251                  |
| End                                    |
| 1990                                   |
| **Input** | **Output** |   
| Citizen Stamo 16 0041018380 01/01/2000 | 01/01/2000 |
| Robot MK-10 12345678                   | 24/12/2000 |
| Robot PP-09 00000001                   |
| Pet Topcho 24/12/2000                  |
| Pet Kosmat 12/06/2002                  |
| End                                    |
| 2000                                   |
| **Input** | **Output** |   
| Robot VV-XYZ 11213141                 | <no output\> |
| Citizen Penk 35 7903210713 21/03/1979 |
| Citizen Kane 40 7409073566 07/09/1974 |
| End                                   |
| 1975                                  |

# 4.	Food Shortage

Your totalitarian dystopian society suffers a shortage of food, so many rebels appear. Extend the code from your previous (Problem 2. **Multiple Implementation**) task with 
new functionality to solve this task.

Define a class **Rebel** which has a **name**, **age** and **group** (String)**,** names are **unique -** there will never be 2 Rebels/Citizens or a Rebel and Citizen with 
the same name. Define an interface **Buyer** which defines a methods **buyFood()** and a **getFood()**. Implement the **Buyer** interface in the **Citizen** and **Rebel** class,
both Rebels and Citizens **start with 0 food**, when a Rebel buys food his **food** increases by **5**, when a Citizen buys food his **food** increases by **10**.

On the first line of the input you will receive an integer **N** - the number of people, on each of the next **N** lines you will receive information in 
one of the following formats "**{name} {age} {id} {birthdate}**" for a Citizen or "**{name} {age}{group}**" for a Rebel. After the **N** lines until the command "**End**" is 
received, you will receive names of people who bought food, each on a new line. Note that not all names may be valid, in case of an incorrect name - nothing should happen.

On the only line of output, you should print the total amount of food purchased.

| **<<Interface\>\>** <br> **Buyer** | | **<<Interface\>\>** <br> **Identifiable** | | **<<Interface\>\>** <br> **Person** | 
| --- | --- | --- | --- | --- |
| +	buyFood() : void | | +	getId() : String | | +	getName() : String |  
| +	getFood() : int  | |                     | | +	getAge() : int     |  

| **Citizen** | | **Rebel** | 
| --- | --- | --- |
| -	name: String                         | | -	name: String               |
| -	age: int                             | | -	age: int                   |
| -	id: String                           | | -	group: String              |
| -	birthDate: String                    | | -	food: int                  |    
| -	food: int                            | |                               |
|                                        | | +	Rebel(Stirng, int, String) |
| +	Citizen(String, int, String, String) | | +	getName() : String         |
| +	getName(): String                    | | +	getAge(): int              |
| +	getAge(): int                        | | +	getGroup() : String        |
| +	getId(): String                      | | +	getFood() : int            |
| +	getFood() : int                      | | +	buyFood() : void           |
| +	buyFood() : void                     |

### Examples

| **Input** | **Output** |   
| --- | --- |
| 2                              | 20 |
| Peter 25 8904041303 04/04/1989 |
| Stan 27 WildMonkeys            |
| Peter                          |
| George                         |
| Peter                          |
| End                            |
|  **Input** | **Output** |   
| 4                             | 25 |
| Stam 23 TheSwarm              | 
| Tony 44 7308185527 18/08/1973 |
| Joro 31 Terrorists            |
| Peny 27 881222212 22/12/1988  |
| Jaguar                        |
| Joro                          |
| Jaguar                        |
| Joro                          |
| Stam                          |
| Peny                          |
| End                           |

# 5. Telephony

You have a business - **manufacturing cell phones**. But you have no software developers, so you call your friends and ask them to help you create a cell phone software. 
They agree and you start working on the project. The project consists of one main **model - a Smartphone**.
Each of your smartphones should have functionalities of **calling other phones** and **browsing in the world wide web.**

Your friends are very busy, so you decide to write the code on your own. Here is the mandatory assignment:

You should have a **model** - **Smartphone** and two separate functionalities which your smartphone has - to **call other phones** and to **browse in the world wide web**. 
You should end up with **one class** and **two interfaces**.

| **<<Interface\>\>** <br> **Callable** | | **<<Interface\>\>** <br> **Browsable** | 
| --- | --- | --- |
| +	call(): String | | +	browse(): String |

| **Smartphone** | 
| --- |
| -	numbers: List<String\>                   |
| -	urls: List<String\>                      |
|                                            |
| +	Smartphone(List<String\>, List<String\>) |
| +	call(): String                           |
| +	browse(): String                         |

### Input

The input comes from the console. It will hold two lines:

- **First line**: **phone numbers** to call (String), separated by spaces.
- **Second line: sites** to visit (String), separated by spaces.

### Output

-   First **call all numbers** in the order of input then **browse all sites** in order of input
-   The functionality of calling phones is printing on the console the number which are\
    being called in the format: **"Calling... {number}"**
-   The functionality of the browser should print on the console the site in format:
   **"Browsing: {site}!"** (pay attention to the exclamation mark when printing URLs)

-   If there is a number in the input of the URLs, print: **"Invalid URL!"** and continue printing the rest of the URLs.
-   If there is a character different from a digit in a number, print: **"Invalid number!"** and continue to the next number.

### Constraints

-   Each site's URL should consist only of letters and symbols (**No digits are allowed** in the URL address)

### Examples

| **Input** | **Output** |   
| --- | --- |
| 0882134215 0882134333 08992134215 0558123 3333 1                                                               | Calling... 0882134215                      |
| ht<span>tp://</span>softuni.bg ht<span>tp://</span>youtube.com ht<span>tp://</span>w<span>ww.</span>g00gle.com | Calling... 0882134333                      |
|                                                                                                                | Calling... 08992134215                     |
|                                                                                                                | Calling... 0558123                         |
|                                                                                                                | Calling... 3333                            |
|                                                                                                                | Calling... 1                               |
|                                                                                                                | Browsing: ht<span>tp://</span>softuni.bg!  |
|                                                                                                                | Browsing: ht<span>tp://</span>youtube.com! |
|                                                                                                                | Invalid URL!                               |
| **Input** | **Output** |   
| 0884542465 0895321654 25632 06014532 123                                                                             | Calling... 0884542465                       |
|  ht<span>tp://</span>softuni.bg ht<span>tp://</span>w<span>ww.</span>g00gle.com ht<span>tp://</span>facebook.com bar | Calling... 0895321654                       |
|                                                                                                                      | Calling... 25632                            |
|                                                                                                                      | Calling... 06014532                         |
|                                                                                                                      | Calling... 123                              |
|                                                                                                                      | Browsing: ht<span>tp://</span>softuni.bg!   |
|                                                                                                                      | Invalid URL!                                |
|                                                                                                                      | Browsing: ht<span>tp://</span>facebook.com! |

# 6. * Military Elite

Create the following class hierarchy:

- **SoldierImpl** - general class for soldiers, holding **id** (int), **first name** and **last name**

  o **PrivateImpl** - lowest base soldier type, holding the field **salary**(double)

    § **LieutenantGeneralImpl** - holds a set of **PrivatesImpl** under his command

     - **public void addPrivate(Private priv)**

    § **SpecialisedSoldierImpl** - general class for all specialised soldiers - holds the **corps** of the soldier. The corps can only be one of the following: 
    **"Airforces"** or **"Marines"** (Enumeration)

     - **EngineerImpl** - holds a set of **repairs**. A **repair** holds a **part name** and**hours worked** (int)

       o **public void addRepair(Repair repair)**

       o **public Collection<Repair\> getRepairs()**

     - **CommandoImpl** - holds a set of **missions**. A mission holds **code name** and a **state** (Enumeration: **"inProgress"** or **"finished"**).
       A mission can be finished through the method **completeMission()**

       o **public void addMission(Mission mission)**

       o **public Collection<Mission\> getMissions()**

  o **SpyImpl** - holds the **code number** of the spy.

Extract **interfaces** for each class. (e.g. **Soldier**, **Private**, **LieutenantGeneral**, etc.) The interfaces should hold their public get methods (e.g. **Soldier** should 
hold **getId**, **getFirstName** and **getLastName**). Each class should implement its respective interface. Validate the input where necessary (corps, mission state) - input 
should match **exactly** one of the required values, otherwise it should be treated as **invalid**. In case of **invalid corps** the entire line should be skipped, 
in case of an **invalid mission state** only the mission should be skipped.

You will receive from the console an unknown amount of lines containing information about soldiers until the command "**End**" is received. 
The information will be in one of the following formats:

- Private: "**Private {id} {firstName} {lastName} {salary}**"
- LieutenantGeneral: "**LieutenantGeneral {id} {firstName} {lastName} {salary} {private1Id} {private2Id} ... {privateNId}**" where privateXId will **always** be an **Id** of 
  a private already received through the input
- Engineer: "**Engineer {id} {firstName} {lastName} {salary} {corps} {repair1Part} {repair1Hours} ... {repairNPart} {repairNHours}**" where repairXPart is 
  the name of a repaired part and repairXHours the hours it took to repair it (the two parameters will always come paired)
- Commando: "**Commando {id} {firstName} {lastName} {salary} {corps} {mission1CodeName}  {mission1state} ... {missionNCodeName} {missionNstate}**" a missions code name, 
  description and state will always come together
- Spy: "**Spy {id} {firstName} {lastName} {codeNumber}**"

Define proper constructors. Avoid code duplication through abstraction. Override **toString()** in all classes to print detailed information about the object.

Privates:<br>
**"Name: {firstName} {lastName} Id: {id} Salary: {salary}"**

Spy: <br>
**"Name: {firstName} {lastName} Id: {id}** <br>
**Code Number: {codeNumber}"**

LieutenantGeneral:<br>
**"Name: {firstName} {lastName} Id: {id} Salary: {salary}** <br>
**Privates:** <br>
&nbsp;&nbsp;**{private1 ToString()}** <br> 
&nbsp;&nbsp;**{private2 ToString()}** <br>
&nbsp;&nbsp;**...** <br>
&nbsp;&nbsp;**{privateN ToString()}"**

**Note**: privates must be sorted by id in **descending order**.

Engineer: <br>
**"Name: {firstName} {lastName} Id: {id} Salary: {salary** <br>
**Corps: {corps}** <br>
**Repairs:** <br> 
&nbsp;&nbsp;**{repair1 ToString()}** <br> 
&nbsp;&nbsp;**{repair2 ToString()}** <br> 
&nbsp;&nbsp;**...** <br> 
&nbsp;&nbsp;**{repairN ToString()}"**

Commando: <br> 
**"Name: {firstName} {lastName} Id: {id} Salary: {salary}** <br>
**Corps: {corps}** <br>
**Missions:** <br>
&nbsp;&nbsp;**{mission1 ToString()}** <br>
&nbsp;&nbsp;**{mission2 ToString()}** <br> 
&nbsp;&nbsp;**...** <br>
&nbsp;&nbsp;**{missionN ToString()}"**

Repair:<br>
**"Part Name: {partName} Hours Worked: {hoursWorked}"**

Mission:<br>
**"Code Name: {codeName} State: {state}"**

**NOTE**: Salary should be printed rounded to **two decimal places** after the separator.

### Examples

| **Input** | **Output** |   
| --- | --- |
| Private 1 Peter Petrov 22.22               | Name: Peter Petrov Id: 1 Salary: 22.22              |
| Commando 13 Stam Stamov 13.1 Airforces     | Name: Stam Stamov Id: 13 Salary: 13.10              |
| Private 222 Tom Tomson 80.08               | Corps: Airforces                                    |
| LieutenantGeneral 3 John Johnson 100 222 1 | Missions:                                           |
| End                                        | Name: Tom Tomson Id: 222 Salary: 80.08              |
|                                            | Name: John Johnson Id: 3 Salary: 100.00             |
|                                            | Privates:                                           |
|                                            | &nbsp;&nbsp;Name: Tom Tomson Id: 222 Salary: 80.08 |
|                                            | &nbsp;&nbsp;Name: Peter Petrov Id: 1 Salary: 22.22 |
| **Input** | **Output** |   
| Engineer 7 Peter Petrov 12.23 Marines Boat 2 Crane 17                           | Name: Peter Petrov Id: 7 Salary: 12.23            |
| Commando 19 Sara Johnson 150.15 Airforces HairyFoot finished Freedom inProgress | Corps: Marines                                    |
| End                                                                             | Repairs:                                          |
|                                                                                 | &nbsp;&nbsp;Part Name: Boat Hours Worked: 2      |
|                                                                                 | &nbsp;&nbsp;Part Name: Crane Hours Worked: 17    |
|                                                                                 | Name: Sara Johnson Id: 19 Salary: 150.15          |
|                                                                                 | Corps: Airforces                                  |
|                                                                                 | Missions:                                         |
|                                                                                 | &nbsp;&nbsp;Code Name: HairyFoot State: finished |
|                                                                                 | &nbsp;&nbsp;Code Name: Freedom State: inProgress |
| **Input** | **Output** |   
| LieutenantGeneral 17 No Units 500.01 | Name: No Units Id: 17 Salary: 500.01 |
| Spy 7 James Bond 007                 | Privates:                            |
| Spy 8 James Boned 008                | Name: James Bond Id: 7               |
| End                                  | Code Number: 007                     |
|                                      | Name: James Boned Id: 8              |
|                                      | Code Number: 008                     |
