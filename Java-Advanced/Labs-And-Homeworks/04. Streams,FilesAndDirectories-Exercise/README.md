# 1.	Sum Lines

Write a program that reads a text file (**input.txt** from the Resources - Exercises) and prints on the console the **sum** of the ASCII symbols of each of its lines. 
Use **BufferedReader** in combination with **FileReader**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 ,          | 1452 |
| Michael Angelo,                | 1397 |
| then fifty-seven years old,    | 2606 |
| writes                         | 670  |
| from Florence to               | 1573 |
| Tommaso de' Cavalieri,         | 2028 |
| a youth of noble Roman family, | 2762 |

# 2.	Sum Bytes

Write a program that reads a text file (**input.txt** from the Resources - Exercises) and prints on the console the **sum** of the ASCII symbols of all characters inside of 
the file. Use **BufferedReader** in combination with **FileReader**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 ,          | 12488 |
| Michael Angelo,                |
| then fifty-seven years old,    |
| writes                         |
| from Florence to               |
| Tommaso de' Cavalieri,         |
| a youth of noble Roman family, |

# 3. ALL CAPITALS!

Write a program that reads a text file (**input.txt** from the Resources - Exercises) and changes the casing of **all** letters to **upper**. 
Write the output to another file (**output.txt**).

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 ,          | ON JANUARY 1 , 1533 ,          |
| Michael Angelo,                | MICHAEL ANGELO,                |
| then fifty-seven years old,    | THEN FIFTY-SEVEN YEARS OLD,    |
| writes                         | WRITES                         |
| from Florence to               | FROM FLORENCE TO               |
| Tommaso de' Cavalieri,         | TOMMASO DE' CAVALIERI,         |
| a youth of noble Roman family, | A YOUTH OF NOBLE ROMAN FAMILY, |

# 4.	Count Character Types

Write a program that reads a list of words from the file (**input.txt** from the Resources - Exercises) and finds the count of **vowels**, **consonants** and 
**punctuation** marks. Assume that:

- **a, e, i, o, u** are vowels, only lower case.
- **All others** are consonants.
- Punctuation marks are **(! , . ?)**.
- **Do not** count whitespace.

Write the results to another file - **output.txt**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| On January 1 , 1533 , Michael Angelo, then fifty-seven years old, writes | Vowels: 41     |
| from Florence to Tommaso de' Cavalieri, a youth of noble Roman family,   | Consonants: 72 |
|                                                                          | Punctuation: 6 |

# 5.	Line Numbers

Write a program that reads a text file (**inputLineNumbers.txt** from the Resources - Exercises) and **inserts** line numbers in front of each of its lines. 
The result should be written to **another** text file - **output.txt**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| Two households, both alike in dignity,          | 1. Two households, both alike in dignity,          |
| In fair Verona, where we lay our scene,         | 2. In fair Verona, where we lay our scene,         |
| From ancient grudge break to new,               | 3. From ancient grudge break to new,               |
| Where civil blood makes civil hands.            | 4. Where civil blood makes civil hands.            |
| From forth the fatal loins of these two         | 5. From forth the fatal loins of these two         |
| A pair of star-cross'd lovers take their life;  | 6. A pair of star-cross'd lovers take their life;  |
| Whose misadventured piteous overthrows          | 7. Whose misadventured piteous overthrows          |
| Do with their death bury their parents' strife. | 8. Do with their death bury their parents' strife. |
 
# 6.	Word Count

Write a program that reads a list of words from the file **words.txt** (from the Resources - Exercises) and finds how many times each of the words is **contained** in 
another file **text.txt** (from the Resources - Exercises). Matching should be case-**insensitive**.

Write the results in file **results.txt**. Sort the words by frequency in **descending order**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| of which The | of - 6    |
|              | which - 2 |
|              | The - 1   |

# 7.	Merge Two Files

Write a program that reads the contents of **two** text files (**inputOne.txt**, **inputTwo.txt** from Resources Exercises) and **merges** them together into a third one.

### Examples

| **File 1** | **File 2** | **Output** | 
| --- | --- | --- |
| 1 | 4 | 1 |
| 2 | 5 | 2 |
| 3 | 6 | 3 |
|   |   | 4 |
|   |   | 5 |
|   |   | 6 |

# 8.	Get Folder Size

Write a program that **traverses** a folder and **calculates** its size in bytes. Use Folder **Exercises Resources** in Resources.

### Examples

| **Input** | **Output** | 
| --- | --- |
| ![image](https://user-images.githubusercontent.com/87463484/140717310-965912d3-76d0-4e61-b03b-ad888092b3a9.png) | Folder size: 2878 |
