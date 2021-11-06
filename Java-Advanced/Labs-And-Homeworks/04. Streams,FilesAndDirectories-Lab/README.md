# 1.	Read File

You are given a file named **"input.txt"**. Read and **print all** of its contents as a sequence of **bytes** (the binary representation of the **ASCII code** for each character) 
separated by a single comma.

### Examples

| **Input** | **Output** | 
| --- | --- |
|On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes… | 11101111 10111011 10111111 1001111 1101110 100000 1001010 1100001 1101110 1110101… |
| **Input** | **Output** |
| Two households, both alike in dignity,  |  1010100 1110111 1101111 100000 1101000 1101111 1110101 1110011 1100101 1101000… 
|  In fair Verona, where we lay our scene… |

# 2.	Write to File

Read the file named **"input.txt"** that is provided for this exercise and write all its content to a file while skipping any **punctuation**. 
Skip the following symbols: "**,**", "**.**","**!**", "**?**".

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes | On January 1  1533  Michael Angelo then fifty-seven years old writes |
| **Input** | **Output** | 
| Two households, both alike in dignity.  | Two households both alike in dignity  |
| In fair Verona, where we lay our scene. | In fair Verona where we lay our scene |

# 3.	Copy Bytes

Read the file named "**input.txt**" and write to another file every character's **ASCII representation**.

Write every **space** or **new line** as it is, e.g. as a **space** or a **new line**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes... | 79110 749711011797114121 49 44 49535151 44 771059910497101108 6511010310110811144 116104101110 10210510211612145115101118101110 12110197114115 11110810044 119114105116101115 |

# 4.	Extract Integers

Read the file provided, named "**input.txt**" and extracts all integers that are not a part of a word in a separate file. A **valid integer** is surrounded with **white spaces**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes | 1    |
| ...                                                                      | 1533 |
|                                                                          | ...  |

# 5.	Write Every Third Line

Read the file provided, named "**input.txt**" and write to another file all lines which number is **divisible by 3**. Line numbers start from one.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 ,          | then fifty-seven years old, |
| Michael Angelo,                | Tommaso de' Cavalieri,      |
| then fifty-seven years old,    |
| writes                         |
| from Florence to               |
| Tommaso de' Cavalieri,         |
| a youth of noble Roman family, |

# 6.	Sort Lines

Read the file provided, named "**input.txt**" and sort all lines. Write text to another text file. Use Path and Files Classes.

### Examples

| **Input** | **Output** | 
| --- | --- |
| C | A |
| A | B |
| B | C |
| D | D |

# 7.	List Files

You are provided a folder named "**Files-and-Streams**". Create a program that lists the names and file sizes (**in bytes**) of all files that are 
placed directly in it (**do not include files in nested folders**).

### Examples

| **Input** | **Output** | 
| --- | --- |
| ![image](https://user-images.githubusercontent.com/87463484/140621506-3dca75cb-dcb7-47c5-8d3e-b5707996e0a5.png) | input.txt: [size in bytes]  |
|                                                                                                                 | output.txt: [size in bytes] |

# 8.	Nested Folders

You are provided a folder named "**Files-and-Streams**". Create a program that lists the names of all directories in it (**including all nested directories**).

On the last line, print the count of all folders, including the root folder.

### Examples

| **Input** | **Output** | 
| --- | --- |
| ![image](https://user-images.githubusercontent.com/87463484/140621530-99a4f4ea-49b7-4920-93ae-818cd275e53e.png) | ...                        |
|                                                                                                                 | Streams-and-Files          |
|                                                                                                                 | Files-and-Streams          |
|                                                                                                                 | Streams-and-Files          |
|                                                                                                                 | Serialization              |
|                                                                                                                 | Streams-and-Files          |
|                                                                                                                 | **[folder count]** folders |

# 9.	Serialize Custom Object

Create a class called **"Cube"**. It should have properties for **color**, **width**, **height** and **depth**.

Create an instance of the class with the following values:

- Color: "green"
- Width: 15.3
- Height: 12.4
- Depth: 3.0

**Serialize** and **deserilalize** the instance created. When saved to a file the object should look like something like the example below.

### Examples

| **Input** | **Output** | 
| --- | --- |
| *(no input)* | ![image](https://user-images.githubusercontent.com/87463484/140621591-7ffd810c-86a5-497a-8ce1-3be46cb262ef.png) |






