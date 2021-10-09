# 1. World Tour

*You are a world traveler, and your next goal is to make a world tour. To do that, you have to plan out everything first. To start with, you would like to plan out 
all of your stops where you will have a break.*

On the **first line,** you will be given a string containing all of your **stops**. Until you receive the command **"Travel"**, you will be given some commands to **manipulate** 
that initial string. The **commands can be**:

- **"Add Stop:{index}:{string}"**:

   o **Insert** the given **string** at that **index** only if the index **is valid**

- **"Remove Stop:{start_index}:{end_index}"**:

   o **Remove** the elements of the string from the **starting index** to the **end index** (**inclusive**) if **both** indices are **valid**

- **"Switch:{old_string}:{new_string}"**:

   o If the **old string** is in the initial string, **replace** it with the **new one** (all **occurrences**)

***Note: After each command, print the current state of the string***

After the **"Travel"** command, print the following: **"Ready for world tour! Planned stops: {string}"**

### Input / Constraints

- **JavaScript**: you will receive a **list of strings**
- An **index is valid** if it is **between the  first and the last element index (inclusive)** in the sequence.

### Output

- Print the proper output messages in the proper cases as described in the problem description

### Examples

| **Input** | **Output** | 
| --- | --- |
| Hawai::Cyprys-Greece  | Hawai::RomeCyprys-Greece                                   |
| Add Stop:7:Rome       | Hawai::Rome-Greece                                         |
| Remove Stop:11:16     | Bulgaria::Rome-Greece                                      |
| Switch:Hawai:Bulgaria | Ready for world tour! Planned stops: Bulgaria::Rome-Greece |
| Travel                |

# 2. Destination Mapper

*Now that you have planned out your tour, you are ready to go! Your next task is to mark all the points on the map that you are going to visit.*

You will be given a **string** representing some **places** on the map. You have to **filter** only the **valid ones**. A valid location is:

- Surrounded by **"="** or **"/"** on **both sides** (the **first** and the **last** symbols must **match**)
- After the **first** **"="** or **"/"** there should be **only letters** (the **first** must be **upper-case**, other letters could be upper or lower-case)
- The **letters** must be **at least 3**

**Example**: In the string **"=Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i="** only the **first two** locations are valid.

After you have **matched** all the **valid locations**, you have to **calculate travel points**. They are calculated by **summing** the **lengths** of 
all the **valid destinations** that you have found on the map.

In the end, on the **first line,** print: **"Destinations: {destinations joined by ', '}"**.

On the **second line,** print **"Travel Points: {travel_points}"**.

### Input / Constraints

- You will receive a string representing the **locations on the map**
- **JavaScript**: you will receive a **single parameter: string**

### Output

- Print the **messages described above**

### Examples

| **Input** | **Output** | 
| --- | --- |
| =Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i= | Destinations: Hawai, Cyprus |
|                                                       | Travel Points: 11           |
| **Input** | **Output** | 
| ThisIs some InvalidInput | Destinations:    |
|                          | Travel Points: 0 |

# 3. Plant Discovery

*You have now returned from your world tour. On your way, you have discovered some new plants, and you want to gather some information about them and create an exhibition to 
see which plant is highest rated.*

On the **first line,** you will receive a number **n**. On the next **n lines**, you will be given some information about the plants that you have discovered in the format: 
**"{plant}<->{rarity}"**. **Store** that **information** because you will need it later. If you receive a plant **more than once**, **update** its rarity.

After that, until you receive the **command** **"Exhibition"**, you will be given some of these **commands**:

- **"Rate: {plant} - {rating}"** - **add** the given **rating** to the plant (**store all ratings**)
- **"Update: {plant} - {new_rarity}"** - **update** the **rarity** of the plant with the **new one**
- **"Reset: {plant}"** - **remove all** the **ratings** of the given plant

**Note: If any given command is invalid, print "error"**

After the command **"Exhibition"**, print the information that you have about the plants in the following format:

**"Plants for the exhibition:**\
**- {plant_name1}; Rarity: {rarity}; Rating: {average_rating}**

**- {plant_name2}; Rarity: {rarity}; Rating: {average_rating}**\
**...**

**- {plant_nameN}; Rarity: {rarity}; Rating: {average_rating}"**

The plants should be **sorted** by **rarity in descending order**. If two or more plants have the same rarity value sort them by **average rating in descending order**.
The **average rating** should be formatted to the **second decimal place.**


### Input / Constraints

- You will receive the input as **described above**
- **JavaScript**: you will receive a **list of strings**

### Output

- Print the **information** about all plants as **described above**
 
### Examples

| **Input** | **Output** | 
| --- | --- | 
| 3                     | Plants for the exhibition:             |  
| Arnoldii<->4          | - Woodii; Rarity: 5; Rating: 7.50      |
| Woodii<->7            | - Arnoldii; Rarity: 4; Rating: 0.00    |
| Welwitschia<->2       | - Welwitschia; Rarity: 2; Rating: 7.00 | 
| Rate: Woodii - 10     |  
| Rate: Welwitschia - 7 |
| Rate: Arnoldii - 3    |  
| Rate: Woodii - 5      |  
| Update: Woodii - 5    |  
| Reset: Arnoldii       |  
| Exhibition            |  
| **Input** | **Output** |
| 2                    | Plants for the exhibition:             |
| Candelabra<->10      | - Oahu; Rarity: 10; Rating: 7.00       |
| Oahu<->10            | - Candelabra; Rarity: 10; Rating: 6.00 |
| Rate: Oahu - 7       |
| Rate: Candelabra - 6 |
| Exhibition           |
