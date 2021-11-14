# 1.	Sort Even Numbers

Write a program that reads one line of **Integers** separated by **", "**.

- Print the **even** numbers.
- **Sort** them in ascending order.
- Print them again.

Use 2 **Lambda Expresions** to do so.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 4, 2, 1, 3, 5, 7, 1, 4, 2, 12 | 4, 2, 4, 2, 12 |
|                               | 2, 2, 4, 4, 12 |
| **Input** | **Output** | 
| 1, 3, 5 | *(no output)* |
| **Input** | **Output** | 
| 2, 4, 6 | 2, 4, 6 |
|         | 2, 4, 6 |

# 2.	Sum Numbers

Write a program that reads one line of **Integers** separated by **", "**. Print the **count** of the numbers and their **sum.**

Use a **Function<String, Integer>.**

### Examples

| **Input** | **Output** | 
| --- | --- |
| 4, 2, 1, 3, 5, 7, 1, 4, 2, 12 | Count = 10 |
|                               | Sum = 41   |
| **Input** | **Output** | 
| 2, 4, 6 | Count = 3 |
|         | Sum = 12  |

# 3.	Count Uppercase Words

Write a program that reads one line of **text** from the console. Print the **count** of words that start with a **Uppercase letter**, 
after that print all these **words** in the **same order,** like you found them in the text.

Use a **Predicate<String\>**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| The following example shows how to use Predicate | 2         |
|                                                  | The       |
|                                                  | Predicate |
| **Input** | **Output** | 
| Write a program that reads one line of text from console. <br> Print count of words that start with Uppercase, after that <br> print all those words in the same order like you find them in text. | 3          |
|                                                                                                                                                                                                    | Write      |
|                                                                                                                                                                                                    | Print      |
|                                                                                                                                                                                                    | Uppercase, |

# 4.	Add VAT

Write a program that reads one line of **Double** prices separated by **", "**. Print the prices with added **VAT**s for all of them. 
Format them to the **2^nd^** digit after the decimal point. The order of the prices must remain the same.

Use an **UnaryOperator<Double\>**.

### Examples

| **Input** | **Output** | 
| --- | --- |
| 1.38, 2.56, 4.4 | Prices with VAT: |
|                 | 1.66             |
|                 | 3.07             |
|                 | 5.28             |
| **Input** | **Output** | 
| 1, 3, 5, 7 | Prices with VAT: |
|            | 1.20             |
|            | 3.60             |
|            | 6.00             |
|            | 8.40             |
            
# 5.	Filter by Age

Write a program that reads an integer **N** on the first line. And on next **N** lines read pairs of **"{name}, {age}".** Then read three more lines with:

- Condition - "**younger**" or "**older**"
- Age - **Integer**
- Format - "**name**", "**age**" or "**name age**"

Depending on the **condition,** print the **pairs** in the right **format**.

**Don't use any build-in functionality. Write your own methods.**

### Examples

| **Input** | **Output** | | **Input** | **Output** | | **Input** | **Output** |
| --- | --- | --- | --- | --- | --- | --- | --- |  
| 5          | Peter - 20 | | 5          | Peter  | | 5          | 20 |
| Peter, 20  | Maria - 29 | | Peter, 20  | George | | Peter, 20  | 18 |
| George, 18 | Idan - 31  | | George, 18 | Simeon | | George, 18 | 29 |
| Maria, 29  |            | | Maria, 29  |        | | Maria, 29  | 31 |
| Idan, 31   |            | | Idan, 31   |        | | Idan, 31   | 16 |
| Simeon, 16 |            | | Simeon, 16 |        | | Simeon, 16 |
| older      |            | | younger    |        | | younger    |
| 20         |            | | 20         |        | | 50         |
| name age   |            | | name       |        | | age        |
 
# 6.	Find Evens or Odds

You are given a **lower** and an **upper bound** for a range of integer numbers. Then a command specifies if you need to list all **even or odd** numbers in the given range. 
Use **predicates** that need to be **passed to a method.**

### Examples

| **Input** | **Output** | 
| --- | --- |
| 1 10 | 1 3 5 7 9 |
| odd  |
| **Input** | **Output** | 
| 20 30 | 20 22 24 26 28 30 |
| even  |
