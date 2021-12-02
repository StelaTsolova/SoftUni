# 1.	ListyIterator

Create a class **ListyIterator**, it should receive the collection of **Strings** which it will iterate, through its constructor. You should store the elements in a **List**. 
The class should have three main functions:

- **Move** - should move an internal **index** position to the next index in the list, the method should **return true** if it successfully moved and **false** if 
there is no next index.
- **HasNext** - should **return** **true**if there is a next index **and** false if the index is alreadyat the last element of the list.
- **Print** - should **print** the element at the current internal index, calling **Print** on a collection without elements should **throw** an appropriate **exception** with 
the message "**Invalid Operation!**".

By default, the internal index should be pointing to the **0^th^ index** of the List. Your program should support the following commands:

| **Command** | **Return Type** | **Description** |
| --- | --- | --- |
| Create {e1 e2 …} | void	    | Creates a ListyIterator from the specified collection. In case of a Create command without any elements, you should create a ListyIterator with an empty collection.|
| Move             | boolean	| This command should move the internal index to the next index.                                                                                                      |
| Print            | void     |	This command should print the element at the current internal index.                                                                                                |
| HasNext          | boolean	| Returns whether the collection has a next element.                                                                                                                  |
| END              | void	    | Stops the input.                                                                                                                                                    |

### Input

Input will come from the console as **lines** of commands. The first line will **always** be **Create** command in the input. 
The last command received will **always** be **END** command.

### Output

For every command from the input (with the exception of the **END** and **Create** commands), print the result of that command on the console, each on a **new line**. 
In case of **Move** or **HasNext** commands, print the **returned value** of the method, in case of a **Print** command you don't have to do anything additional as 
the method itself should already print on the console. Your program should catch **any exceptions thrown** because of validations (calling Print on an empty collection) and 
print their messages instead.

### Constraints

- There will always be only **one Create** command and it will always be the first command passed.
- The number of commands received will be **between [1...100]**.
- The last command will always be the **END** command.

### Examples

| **Input** | **Output** | 
| --- | --- |
| Create | Invalid Operation! |
| Print  |
| END    |
| **Input** | **Output** |
| Create Peter George | true   |
| HasNext             | Peter  |
| Print               | true   |
| Move                | George |
| Print               |
| END                 |

# 2.	Collection

Using the ListyIterator from the last problem, extend it by implementing the **Iterable** interface, implement **all** methods desired by the interface manually. 
Add a new method to the class **PrintAll()**, the method should **foreach** the collection and print all elements on a **single line** separated by a space.

### Input

Input will come from the console as **lines** of commands. The first line will always be the **Create** command in the input. 
The **last** command received will always be the **END** command.

### Output

For every command from the input (with the exception of the **END** and **Create** commands) print the result of that command on the console, each on a **new line**. 
In case of **Move** or **HasNext** commands print the returned value of the method, in case of a **Print** command you don't have to do anything additional as 
the method itself should already print on the console. In case of a **PrintAll** command, you should print all elements on a single **line** separated by **spaces**. 
Your program should catch **any exceptions** thrown because of validations and print their messages instead.

### Constraints

- **Do not use the built in iterators!**
- There will always be only **one Create** command and it will **always** be the first command passed.
- The number of commands received will be **between [1...100]**.
- The **last** command will always be the **END** command.

### Examples

| **Input** | **Output** | 
| --- | --- |
| Create Sam George Peter | Sam George Peter |
| PrintAll                | true             |
| Move                    | true             |
| Move                    | Peter            |
| Print                   | false            |
| HasNext                 |
| END                     |
| **Input** | **Output** | 
| Create 1 2 3 4 5 | true      |
| Move             | 1 2 3 4 5 |
| PrintAll         |
| END              |

# 3.	Stack Iterator

Since you have passed the basics algorithms course, now you have a task to create your custom stack. You are aware of the Stack structure. There is a collection to store 
the elements and two functions (not from the functional programming) - to **push** an element and to **pop** it. Keep in mind that the first element, which is popped, 
is the **last** in the collection. The push method adds an element to the **top** of the collection and the pop method returns the **top** element and **removes** it.

Write your custom implementation of **Stack<Integer\>** and implement your custom **iterator**. There is a way that IntelliJ could help you, your Stack class should 
implement the **Iterable<Integer\>** interface and your **Iterator Class** should implement **Iterator<Integer\>** interface. Your Custom Iterator should follow the rules of 
the **Abstract Data Type** - **Stack**. Like we said, the first element is the element at the top and so on. Iterators are used only for iterating through 
the collection, they **should not** remove or mutate the elements.

### Input

The input will come from the console as lines of commands. Commands will only be **push** and **pop**, 
followed by integers for the **push** command and **no another** input for the **pop** command.

Format:

- **"Push {element, secondElement...}"**
- **"Pop"**

### Output

When you receive "**END**", the input is over. Foreach the stack **twice** and print all elements. Each element should be on a **new line**.

### Constraints

- The elements in the push command will be **valid** integers **between [2^-32^...2^32^-1]**.
- The commands will always be **valid** (always be either **Push, Pop** or **END**).
- There will be no more than **16 elements** in **Push** command.
- If **Pop** command **could not** be executed as expected (e.g. no elements in the stack), print on the console: "**No elements**".

### Examples

| **Input** | **Output** | 
| --- | --- |
| Push 1, 2, 3, 4 | 2 |
| Pop             | 1 |
| Pop             | 2 |
| END             | 1 |            
| **Input** | **Output** | 
| Push 1, 2, 3, 4 | No elements |
| Pop             | 
| Pop             | 
| Pop             | 
| Pop             | 
| Pop             | 
| END             | 

# 4.	Froggy

Let's play a game. You have a tiny little **Frog**, and a **Lake** with numbers. The **Lake** and its numbers, you will get by an input from the console. Imagine, 
your **Frog** belongs to the **Lake**. The **Frog jumps** only when "**END**" command is received. When the **Frog** starts jumping, print on the console **each number** 
the **Frog** has stepped over. To calculate the jumps, use the guide lines:

The jumps start from the **0^th^ index**. And follows the pattern - first all even indexes in **ascending** order(0->2->4->6 and so on) and then all odd indexes in 
**ascending** order (1->3->5->7 and so on). Consider the **0^th^ index as  even**.

**Long story short:** Create a Class **Lake**, it should implement the interface - **Iterable**. Inside the **Lake**, 
create a Class - **Frog** and implement the interface **Iterator**. Keep in mind, you will be given **integers** only.

### Input

The input will consist of two lines. First line - the **initial** numbers of the lake, **separated** by comma and a single space. Second line command is "**END**".

### Output

When you receive "**END**", the input is over. **Foreach through** the collection of numbers the **Frog** has jumped over and print **each** element.

The output should be print on a **single** line. Format:

**{number}, {second number}, {third number} ...**

### Constraints

- **Lake's** numbers will be **valid** integers in the **range [2^-32^...2^32^-1]**.
- The command will always be **valid** - "**END**".

### Examples

| **Input** | **Output** | 
| --- | --- |
| 1, 2, 3, 4, 5, 6, 7, 8 | 1, 3, 5, 7, 2, 4, 6, 8 |
| END                    |
| **Input** | **Output** | 
| 1, 2, 3 | 1, 3, 2 |
| END     |

# 5.	Comparing Objects

There is a Comparable interface but probably you already know. Your task is simple. Create a **Class** **Person**. Each person should have **name**, **age** and **town**. 
You should implement the interface - **Comparable** and try to override the **compareTo** method. When you compare two people, first you should compare their **names**, 
after that - their **age** and last but not at least - compare their **town**.

### Input

On single lines, you will be given people in format:

**{name} {age} {town}**

Collect them till you receive **"END"**

After that, you will receive an integer **N** - the **N^th^** person in your collection.

### Output

On the single output line, you should bring statistics, how many people are **equal** to him, how many people are **not** equal to him and the **total** people in your collection.

Format:

**{number of equal people} {number of not equal people} {total number of people}**

### Constraints

- Names, ages and addresses will be **valid.**
- Input number will be always а **valid** integer in **range [2...100].**
- If there are no equal people print: **"No matches".**

### Examples

| **Input** | **Output** | 
| --- | --- |
| Peter 22 Varna  | No matches |
| George 14 Sofia |
| END             |
| 2               |
| **Input** | **Output** | 
| Peter 22 Varna  | 2 1 3 |
| George 22 Varna |
| George 22 Varna |
| END             |
| 2               |

# 6.	Strategy Pattern

An interesting pattern you may have heard of is the Strategy Pattern, if we have multiple ways to do a task (let's say sort a collection) it allows the client to choose 
the way that most fits his needs. A famous implementation of the pattern in Java is the **Collections**.**sort()** method that takes a Comparator.

Create a class **Person** that holds **name** and **age**. Create 2 Comparators for Person (classes which implement the **Comparator<Person\> interface**). 
The first comparator should compare people based on the **length of their name** as a first parameter, if 2 people have a name with the **same** length, 
perform a **case-insensitive** compare based on the **first letter of their name** instead. The second comparator should compare them based on their **age**. 
Create 2 **TreeSets** of type Person, the first should implement the name comparator and the second should implement the age comparator.
  
### Input

On the first line of input you will receive a number **N**. On each of the next **N** lines you will receive information about people in the format **"{name} {age}"**. 
Add the people from the input into **both** sets (both sets should hold all the people passed in from the input).
  
### Output

**Foreach** the sets and print each person from the set on a **new line** in the same format that you received them. Start with the set that implements the name comparator.
  
### Constraints

- A person's name will be a string that contains **only** alphanumerical characters with a length **between [1...50]** symbols.
- A person's age will be a **positive** integer **between [1...100]**.
- The number of people **N** will be a **positive** integer **between [0...100]**.
  
### Examples

| **Input** | **Output** | 
| --- | --- |
| 3          | Sam 1      |
| Peter 20   | Peter 20   |
| George 100 | George 100 |
| Sam 1      | Sam 1      |
|            | Peter 20   |
|            | George 100 |
| **Input** | **Output** | 
| 5         | Sam 99    |
| John 17   | Alex 33   |
| Alex 33   | John 17   |
| Samuel 25 | George 3  |
| Sam 99    | Samuel 25 |
| George 3  | George 3  |
|           | John 17   |
|           | Samuel 25 |
|           | Alex 33   |
|           | Sam 99    |
  
# 7.	*Equality Logic

Create a **class Person** holding **name** and **age**. A person with the **same** name and age should be considered the same, override any methods needed to enforce 
this logic. Your class should work with **both** standard and hashed collections. Create a **TreeSet** and a **HashSet** of type Person.

### Input

On the first line of input, you will receive a number **N**. On each of the next **N** lines, you will receive information about people in the format **"{name} {age}"**.  
Add the people from the input into **both** sets (both sets should hold all the people passed in from the input).

### Output

The output should consist of **exactly** 2 lines. On the first, you should print the **size** of the **TreeSet** and on the second - the **size** of the **HashSet**.

### Constraints

- A person's name will be a string that contains **only** alphanumerical characters with a length **between [1...50]** symbols.
- A person's age will be a **positive** integer **between [1...100]**.
- The number of people **N** will be a positive integer **between [0...100]**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 4         | 4 |
| Peter 20  | 4 |
| Petter 20 |
| George 15 |
| Peter 21  |
| **Input** | **Output** | 
| 7         | 5 |
| George 17 | 5 |
| george 17 |
| Peter 25  |
| George 18 |
| George 17 |
| Petter 25 |
| Peter 25  |
