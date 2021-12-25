# 1.	Sort by Name and Age 

Create a class **Person**, which should have **private** fields for:

- **firstName: String**
- **lastName: String**
- **age: int**
- **toString() - override**

You should be able to use the class like this:

| **Main.java** |
| --- |
| public static void main(String[] args) throws IOException {                                               |
| &nbsp;&nbsp;BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                 |
| &nbsp;&nbsp;int n = Integer.parseInt(reader.readLine());                                                  |
| <br>                                                                                                      |
| &nbsp;&nbsp;List<Person\> people = new ArrayList<>();                                                     |
| <br>                                                                                                      |
| &nbsp;&nbsp;for (int i = 0; i < n; i++) {                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp; String[] input = reader.readLine().split(" ");                                   |
| &nbsp;&nbsp;&nbsp;&nbsp; people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));          |
| &nbsp;&nbsp;}                                                                                             |
| <br>                                                                                                      |
| &nbsp;&nbsp;Collections.sort(people, (firstPerson, secondPerson) -> {                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());   |
| <br>                                                                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp;if (sComp != 0) {                                                                 |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return sComp;                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp;} else {                                                                          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return Integer.compare(firstPerson.getAge(), secondPerson.getAge()); |
| &nbsp;&nbsp;&nbsp;&nbsp;}                                                                                 |
| &nbsp;&nbsp;});                                                                                           |
| <br>                                                                                                      |
| &nbsp;&nbsp;for (Person person : people) {                                                                |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(person.toString());                                           |
| &nbsp;&nbsp;}                                                                                             |
| }                                                                                                         |

### Examples

| **Input** | **Output** |
| --- | --- |
| 5                  | Angel Harizanov is 44 years old. |
| Angel Ivanov 65    | Angel Ivanov is 65 years old.    |
| Boris Georgiev 57  | Boris Angelov is 35 years old.   |
| Veny Ivanov 27     | Boris Georgiev is 57 years old.  |
| Angel Harizanov 44 | Veny Ivanov is 27 years old.     |
| Boris Angelov 35   |
| **Input** | **Output** |
| 4                   | Anna Glen is 21 years old.        |
| Sara Cameron 21     | John Alekseevich is 43 years old. |
| John Petrovich 53   | John Petrovich is 53 years old.   |
| Anna Glen 21        | Sara Cameron is 21 years old.     |
| John Alekseevich 43 |

# 2.	Salary Increase

Read person with their **names**, **age** and **salary**. Read **percent bonus** to every person salary. People younger **than 30** get half bonus. 
Expand **Person** from previous task. Add **salary field** and **getter** and **setter** with proper **access**.

New **fields** and **methods**

- **salary: double**
- **increaseSalary(double bonus)**

You should be able to use the class like this:

| **Main.java** |
| --- |
| public static void main(String[] args) throws IOException {                                                                    |
| &nbsp;&nbsp;BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                      |
| &nbsp;&nbsp;int n = Integer.parseInt(reader.readLine());                                                                       |
| &nbsp;&nbsp;List<Person\> people = new ArrayList<\>();                                                                         |
| &nbsp;&nbsp;for (int i = 0; i < n; i++) {                                                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp; String[] input = reader.readLine().split(" ");                                                        |
| &nbsp;&nbsp;&nbsp;&nbsp; people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]))); |
| &nbsp;&nbsp;}                                                                                                                  |
| &nbsp;&nbsp;double bonus = Double.parseDouble(reader.readLine());                                                              |
| &nbsp;&nbsp;for (Person person : people) {                                                                                     |
| &nbsp;&nbsp;&nbsp;&nbsp; person.increaseSalary(bonus);                                                                         |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(person.toString());                                                                |
| &nbsp;&nbsp;}                                                                                                                  |
| }                                                                                                                              |

### Examples

| **Input** | **Output** |
| --- | --- |
| 5                         | Angel Ivanov gets 2640.0 leva     |
| Angel Ivanov 65 2200      | Boiko Georgiev gets 3999.6 leva   |
| Boris Georgiev 57 3333    | Veny Ivanov gets 660.0 leva       |
| Veny Ivanov 27 600        | Angel Harizanov gets 799.992 leva |
| Angel Harizanov 44 666.66 | Boris Angelov gets 671.28 leva    |
| Boris Angelov 35 559.4    |
| 20                        |
| **Input** | **Output** |
| 4                        | Sara Cameron gets 1278.0 leva     |
| Sara Cameron 21 1200     | John Petrovich gets 961.065 leva  |
| John Petrovich 53 850.50 | Anna Glen gets 1746.6 leva        |
| Anna Glen 21 1640        | John Alekseevich gets 2373.0 leva |
| John Alekseevich 43 2100 |
| 13                       |

# 3.	Validation Data

Expand Person with proper validation for every field:

- **Names must be at least 3 symbols**
- **Age must not be zero or negative**
- **Salary can't be less than 460.0**

Print proper message to end user (look at example for messages).

Don't use **System.out.println()**  in Person class.

### Examples

| **Input** | **Output** |
| --- | --- |
| 5                        | Age cannot be zero or negative integer   |
| Asen Ivanov -6 2200      | First name cannot be less than 3 symbols |
| B Borisov 57 3333        | Last name cannot be less than 3 symbols  |
| Ventsislav Ivanov 27 600 | Salary cannot be less than 460 leva      |
| Asen H 44 666.66         | Ventsislav Ivanov gets 660.0 leva        |
| Boiko Angelov 35 300     |
| 20                       |
| **Input** | **Output** |
| 4                         | Age cannot be zero or negative integer |
| Sara Cameron 21 1200      | Salary cannot be less than 460 leva    |
| John Petrovich -53 850.50 | Age cannot be zero or negative integer |
| Anna Glen 21 430          | Sara Cameron gets 1278.0 leva          |
| John Alekseevich 0 2100   |
| 13                        |

# 4.	First and Reserve Team

Create a **Team** class. Add to this team all person you read. All person **younger** than 40 go in **first team**, others go in **reverse team**. 
At the end print first and reserve team sizes.

The class should have **private fields** for:

- **name: String**
- **firstTeam: List<Person\>**
- **reserveTeam: List<Person\>**

The class should have **constructors**:

- **Team(String name)**

The class should also have private method for setName and **public methods** for:

- **getName(): String**
- **addPlayer(Person person): void**
- **getFirstTeam(): List<Person\> (Collections.unmodifiableList)**
- **getReserveTeam(): List<Person\> (Collections.unmodifiableList)**

You should be able to use the class like this:

![image](https://user-images.githubusercontent.com/87463484/147392597-85dfdec4-b9d4-4b8a-8b31-fb784f93ea8f.png)

### Examples

| **Input** | **Output** |
| --- | --- |
| 5                         | First team have 4 players   |
| Asen Ivanov 20 2200       | Reserve team have 1 players |
| Boiko Borisov 57 3333     |
| Ventsislav Ivanov 27 600  |
| Grigor Dimitrov 25 666.66 |
| Boiko Angelov 35 555      |
| **Input** | **Output** |
| 4                        | First team have 3 players   |
| Sara Cameron 21 1200     | Reserve team have 1 players |
| John Petrovich 53 850.50 |
| Anna Glen 21 475         |
| John Alekseevich 27 2100 |
