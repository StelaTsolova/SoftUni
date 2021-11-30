# 1.	Book

Create a class **Book** from **UML diagram** below:

| **Book** |
| --- |
| -	title: String               |
| -	year: int                   |
| -	authors: List<String\>      |
|                               |
| -	setTitle(String)            |
| -	setYear(String)             |
| -	setAuthors(String…)         |
| +	getTitle(): String          |
| +	getYear(): int              |
| +	getAuthors(): List<String\> |

You can use only **one constructor**. There **can be no authors**, **one author** or **many authors**.

### Examples

| **Main.java** |
| --- |
| public static void main(String[] args) {                                                        |
| &nbsp; Book bookOne = new Book("Animal Farm", 2003, "George Orwell");                                  |
| &nbsp; Book bookThree = new Book("The Documents in the Case", 2002);                                   |
| &nbsp; Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace"); |
| <br>                                                                                            |
| &nbsp; List<Book\> books = new ArrayList<\>();                                                         |
| &nbsp; books.add(bookOne);                                                                             |
| &nbsp; books.add(bookTwo);                                                                             |
| &nbsp; books.add(bookThree);                                                                           |
| }                                                                                               |

# 2.	Library

Create a class **Library** from **UML diagram** below:

| **<<Iterable<Book\>>>** <br> **Library** |
| --- |
| -	books: Book[]              | 
| +	iterator(): Iterator<Book\> | 

Create a **nested class** **LibIterator** from **UML diagram** below:

| **<<Iterator<Book\>>>** <br> **LibIterator** |
| --- |
| -	counter: int       |
| +	hasNext(): boolean |
| +	next(): Book       |

### Examples

| **Main.java** |
| --- |
| public static void main(String[] args) {                                                               |
| &nbsp; Book bookOne = new Book("Animal Farm", 2003, "George Orwell");                                  |
| &nbsp; Book bookThree = new Book("The Documents in the Case", 2002);                                   |
| &nbsp; Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace"); |
| <br>                                                                                                   |
| &nbsp; Library library = new Library<>(bookOne, bookTwo, boоkThree);                                   |
| <br>                                                                                                   |
| &nbsp; for (Book book: library) {                                                                      |
| &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(book.getTitle());                                          |
| &nbsp;&nbsp; }                                                                                         |
| }                                                                                                      |

# 3.	Comparable Book

Expand Book by implementing **Comparable<Book\>**.

Book have to be **compared by title**. When title is equal, **compare** them by **year**.

Expand **Book** from **UML diagram** below:

| **<<Comparable<Book\>>>** <br> **Book** |
| --- |
| -	title: String               |
| -	year: int                   |
| -	authors: List<String\>      |
|                               |
| -	setTitle(String)            |
| -	setYear(String)             |
| -	setAuthors(String…)         |
| +	getTitle(): String          |
| +	getYear(): int              |
| +	getAuthors(): List<String\> |
| +	compareTo(Book): int        |

You can use only **one constructor**. There **can be no authors**, **one author** or **many authors**.

### Examples

| **Main.java** |
| --- |
| public static void main(String[] args) {                                                        | 
| &nbsp; Book bookOne = new Book("Animal Farm", 2003, "George Orwell");                                  |
| &nbsp; Book bookThree = new Book("The Documents in the Case", 2002);                                   |
| &nbsp; Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace"); |
| <br>                                                                                                   |
| &nbsp; if (bookOne.compareTo(bookTwo) > 0) {                                                           |
| &nbsp;&nbsp;&nbsp; System.out.println(String.format("%s is before %s", bookOne, bookTwo));             |
| &nbsp; } else if (bookOne.compareTo(bookTwo) < 0) {                                                    |
| &nbsp;&nbsp;&nbsp; System.out.println(String.format("%s is before %s", bookTwo, bookOne));             |
| &nbsp; } else {                                                                                        |
| &nbsp;&nbsp;&nbsp; System.out.println("Book are equal");                                               |
| &nbsp; }                                                                                               |
| }                                                                                                      |

# 4.	Book Comparator

Create a class **BookComparator** from **UML diagram** below:

| **<<Comparator<Book\>>>** <br> **BookComparator** |
| --- |
| + compare(Book, Book): int |

**BookComparator** have to **compare** two books by:
&nbsp; 1. Book title
&nbsp; 2. Year of publishing a book 
  
### Examples 
  
| **Main.java** |
| --- |
| public static void main(String[] args) {                                                               |
| &nbsp; Book bookOne = new Book("Animal Farm", 2003, "George Orwell");                                  |
| &nbsp; Book bookThree = new Book("The Documents in the Case", 2002);                                   |
| &nbsp; Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace"); |
| <br>                                                                                                   |
| &nbsp; List<Book\> books = new ArrayList<\>();                                                         |
| &nbsp; books.add(bookOne);                                                                             |
| &nbsp; books.add(bookTwo);                                                                             |
| &nbsp; books.add(bookThree);                                                                           |
| <br>                                                                                                   |
| &nbsp; books.sort(new BookComparator());                                                               |
| <br>                                                                                                   |
| &nbsp; for (Book : books) {                                                                            |
| &nbsp;&nbsp;&nbsp; System.out.println(book.getTitle() + book.getYear());                               |
| &nbsp; }                                                                                               |
| }                                                                                                      |
