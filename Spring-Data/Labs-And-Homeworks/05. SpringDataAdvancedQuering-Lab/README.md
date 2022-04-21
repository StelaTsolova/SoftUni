You are **given** a simpler implementation of the **Shampoo Company**. Now it's time to start writing some query methods to retrieve data.\
**Before you start, insert the data from the "shampoo-company-insert.sql" file!**

# 1. Select Shampoos by Size

Create a method that selects all shampoos with a **given size**, **ordered by shampoo id.**

### Example

| **Input** | **Output** |
| --- | --- |
| MEDIUM | Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv. |
|        | Volume & Fullness Lavender MEDIUM 5.50lv.                         |
|        | Rose Shine & Hydration MEDIUM 6.50lv.                             |
|        | Color Protection & Radiance MEDIUM 6.75lv.                        |
|        | Heavenly Long Long-Hair MEDIUM 7.50lv.                            |
|        | Sea Buckthorn Vital MEDIUM 6.50lv.                                |
|        | Fresh it Up! MEDIUM 7.65lv.                                       |
|        | Nectar Nutrition MEDIUM 6.85lv.                                   |

# 2. Select Shampoos by Size or Label

Create a method that selects all shampoos with a **given size or label id**. Sort the result **ascending by price**.

### Example

| **Input** | **Output** |
| --- | --- |
| MEDIUM | Volume & Fullness Lavender MEDIUM 5.50lv.                         |
| 10     | Intense-Charm Brunette SMALL 5.50lv.                              |
|        | Nature Moments Mediterranean Olive Oil & Aloe Vera MEDIUM 6.50lv. |
|        | Rose Shine & Hydration MEDIUM 6.50lv.                             |
|        | Sea Buckthorn Vital MEDIUM 6.50lv.                                |
|        | Color Protection & Radiance MEDIUM 6.75lv.                        |
|        | Nectar Nutrition MEDIUM 6.85lv.                                   |
|        | Heavenly Long Long-Hair MEDIUM 7.50lv.                            |
|        | Fresh it Up! MEDIUM 7.65lv.                                       |
|        | Active-Caffeine SMALL 7.80lv.                                     |

# 3. Select Shampoos by Price

Create a method that selects all shampoos, which price is **higher than a given price**. Sort the result **descending by price**.

### Example

| **Input** | **Output** |
| --- | --- |
| 5	| Superfruit Nutrition LARGE 13.80lv.        |
|   | Cotton Fresh LARGE 13.60lv.                |
|   | Color Protection & Radiance LARGE 11.50lv. |
|   | Rose Shine & Hydration LARGE 10.70lv.      |
|   | Nectar Nutrition LARGE 10.50lv.            |
|   | Keratin Strong SMALL 8.80lv.               |
|   | Superfruit Nutrition SMALL 8.80lv.         |
|   | Cotton Fresh SMALL 8.80lv.                 |
|   | Keratin Strong LARGE 8.80lv.               |
|   | Volume & Fullness Lavender LARGE 8.50lv.   |
|   | …                                          |

# 4. Select Ingredients by Name

Create a method that selects all **ingredients**, which **name starts with given letters**.

### Example

| **Input** | **Output** |
| --- | --- |
| M	| Macadamia Oil    |
|   | Mineral-Collagen |
|   | Micro Crystals   |

# 5. Select Ingredients by Names

Create a method that selects all **ingredients**, which are **contained in a given list**. Sort the result **ascending by price**.

### Example

| **Input** | **Output** |
| --- | --- |
| Lavender | Apple    |
| Herbs    | Lavender |
| Apple    | Herbs    |

# 6. Count Shampoos by Price

Create a method that **counts all shampoos** with **price lower than a given price**.

### Example

| **Input** | **Output** |
| --- | --- |
| 8.50 | 15 |

JPQL Querying
=============

# 7. Select Shampoos by Ingredients

Create a method that selects all **shampoos with ingredients** includedin a **given list**.

### Example

| **Input** | **Output** |
| --- | --- |
| Berry            | Superfruit Nutrition                               |
| Mineral-Collagen | Color Protection & Radiance                        |
|                  | Volume & Fullness Lavender                         |
|                  | Keratin Strong                                     |
|                  | Nature Moments Mediterranean Olive Oil & Aloe Vera |
|                  | Nectar Nutrition                                   |
|                  | Fresh it Up!                                       |

# 8. Select Shampoos by Ingredients Count

Create a method that selects all **shampoos with ingredients less than a given number**.

### Example

| **Input** | **Output** |
| --- | --- |
| 2	| Moroccan Argan Oil & Macadamia |
|   | Volume & Fullness Lavender     |
|   | Sea Buckthorn Vital            |
|   | Active-Caffeine                |

# 9. Delete Ingredients by Name

Create a method that **deletes ingredients by a given name**. Use named query.

# 10. Update Ingredients by Price

Create a method that **increases the price of all ingredients by 10%**. Use named query.

# 11. Update Ingredients by Names

Create a method that **updates the price** of all ingredients, which names are in a given list.
