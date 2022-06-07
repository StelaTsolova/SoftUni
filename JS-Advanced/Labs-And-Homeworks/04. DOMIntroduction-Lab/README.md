# 1. Edit Element 

Create function **edit()** that takes **three** parameters.

### Input/Output

**The first** parameter is a **reference** to an **HTML** element, the other two parameters are string-**match** and **replacer.**

You have to **replace** all occurrences of the **match** inside the **text content** of the given element with a **replacer.**

### Example

![image](https://user-images.githubusercontent.com/87463484/172316820-6a7f7b42-8eac-49b0-81d8-d459fa197c35.png)

**↓**

![image](https://user-images.githubusercontent.com/87463484/172316849-6fe5296b-de1b-47de-bb93-31d2d502a3e3.png)

# 2. Collect List Items

Write a JS function that scans a given **HTML list** and **appends** all collected list items' text to a **textarea** on the same page 
when the user **clicks** on a button.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/172316984-89170328-3d86-45c6-9b9d-7d3c167d0ea8.png) 

**↓**

![image](https://user-images.githubusercontent.com/87463484/172316997-36bbef5f-a6db-4411-b950-d2ab771bef7a.png)

# 3. Sum Numbers

Write a JS function that **reads** two numbers from input fields in a **web page** and puts their **sum in another field** when the user **clicks** on a button.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/172317174-c2e9290a-a284-4a76-8b19-55a853ea1249.png)

# 4. Show More

Write a JS function that **expands** a hidden section of text when a link is **clicked**. The link should **disappear** as the rest of the text shows up.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/172317523-d783c02f-00e4-48eb-8b5f-1dadcdae1cd3.png)

**↓**

![image](https://user-images.githubusercontent.com/87463484/172317538-ec9e353d-3cd7-4950-8a97-6b64807b8503.png)

# 5. Colorize Table

Write a JS function that **changes the color** of all **even** rows when the user **clicks** a button. Apply the color "**Teal**" to the target rows.

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/172317613-973f73b8-9c49-4d8f-846d-6723c168ec04.png) **->** ![image](https://user-images.githubusercontent.com/87463484/172317653-76c8b9b5-8d8d-4604-8bd5-f2d3d2f22b6b.png)

# 6. Sum Table

Write a JS function that finds the first table in a document and sums the values in the last column. The result is then displayed in an element with ID "**sum**".

### Input/Output

There will be no input/output, your program should instead **modify** the DOM of the given HTML document.

### Example

![image](https://user-images.githubusercontent.com/87463484/172317721-504643e2-1dc8-41cc-9bf0-70645dd4b970.png) **->** ![image](https://user-images.githubusercontent.com/87463484/172317737-c7724847-e599-4d03-8a5c-8cb436194d52.png)

# 7. Extract Parenthesis

Write a JS function that when **executed**, extracts all parenthesized text from a target paragraph by given element ID. 
The result is a string, joined by ";" (semicolon, space).

### Input

Your function will receive a **string parameter**, representing the target element ID, from which text must be extracted. The text should be extracted from the DOM.

### Output

**Return a string** with all matched text, separated by ";" (semicolon, space).

### Example

![image](https://user-images.githubusercontent.com/87463484/172317932-236e6bcd-b8f6-4e2b-a27c-92293b174778.png)

| **Sample call** |
| --- |
| let text = extract("content");          |
| **Result (stored in variable text)**    |
| Bulgaria; Kazanlak; Rosa demascena Mill |
