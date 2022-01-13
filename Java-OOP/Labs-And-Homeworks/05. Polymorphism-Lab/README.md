# 1.	Math Operation

Create a class MathOperation, which should have method **add()**. Method **add()** have to be invoked with **two, three** or **four Integers.**

You should be able to use the class like this:

| **Main.java** |
| --- |
| public static void main(String[] args) throws IOException { |
| &nbsp;&nbsp; MathOperation math = new MathOperation();      |
| &nbsp;&nbsp; System.out.println(math.add(2, 2));            |
| &nbsp;&nbsp; System.out.println(math.add(3, 3, 3));         |
| &nbsp;&nbsp; System.out.println(math.add(4, 4, 4, 4));      |
| }                                                           |

### Examples

| **Input** | **Output** |  
| --- | --- |
| | 4  |
| | 9  |
| | 16 |

# 2.	Shapes

Create class hierarchy, starting with abstract class **Shape**:

- **Fields:**

  o **perimeter: Double**

  o **area: Double**

- **Encapsulation for this fields**
- **Abstract methods:**

  o **calculatePerimeter()**

  o **calculateArea()**

Extend Shape class with two children:

- **Rectangle**
- **Circle**

Each of them needs to have:

- **Fields:**

  For **Rectangle**

  o **height: Double**

  o **width: Double**

  For **Circle**

  o **radius: Double**

- **Encapsulation for this fields**
- **Public constructor**
- **Concrete methods for calculations (perimeter and area)**

# 3.	Animals

Create a class Animal, which holds two fields:

- **name: String**
- **favouriteFood: String**

Animal has one abstract method **explainSelf(): String.**\
You should add two new classes - **Cat** and **Dog. Override** the **explainSelf()**  method by adding concrete animal sound on a new line.

You should be able to use the class like this:

| **Main.java** |
| --- |
| public static void main(String[] args) {               |
| &nbsp;&nbsp; Animal cat = new Cat("Oscar", "Whiskas"); |
| &nbsp;&nbsp; Animal dog = new Dog("Rocky", "Meat");    |
| &nbsp;&nbsp; System.out.println(cat.explainSelf());    |
| &nbsp;&nbsp; System.out.println(dog.explainSelf());    |
| }                                                      |
 
### Examples

| **Input** | **Output** |  
| --- | --- |
| | I am Oscar and my favourite food is Whiskas |
| | MEEOW                                       |
| | I am Rocky and my favourite food is Meat    |
| | DJAAF                                       |
