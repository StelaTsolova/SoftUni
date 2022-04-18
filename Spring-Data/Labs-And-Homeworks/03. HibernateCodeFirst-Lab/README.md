# 1. Vehicle Hierarchy

Your task is to **create a Vehicle hierarchy**.

### Vehicle - Abstract Class

- Has an **Id - Long**
- Has a **Type - String**
- Has a **Model - String**
- Has a **Price - BigDecimal**
- Has a **fuelType - String**

### Car

Extends from the **Vehicle** class

- Has **Seats - Integer**

### Truck

Extends from the **Vehicle** class

- Has **loadCapacity - Double**

### Bike

Extends from the **Vehicle** class

### Plane

Extends from the **Vehicle** class

- Has **passengerCapacity - Integer**

Use the appropriate **inheritance types** to reach **the diagrams** in the examples.

![image](https://user-images.githubusercontent.com/87463484/163786200-050e43b2-f8d8-468c-b0e7-1d7afbdb2549.png)

![image](https://user-images.githubusercontent.com/87463484/163786227-c29362f1-fea6-4e0b-9b90-cc5b6d17fbce.png)

![image](https://user-images.githubusercontent.com/87463484/163786251-e5affb0c-bc05-4604-88f7-36aeeb6527f7.png)

# 2. Relations

### Plate_number

- Has an **id - BigInteger**
- Has a **number - String**
- Has a **one to one** relations with **Cars**

![image](https://user-images.githubusercontent.com/87463484/163786295-6478e341-bc79-4fed-aa2e-1eb4a2cc62de.png)

### Companies

- Has an **id - BigInteger**
- Has a **name - String**
- Has a **one to many** relations with **Planes**

![image](https://user-images.githubusercontent.com/87463484/163786322-63b83ed9-5df3-4cc5-bc9a-65f647b98c9c.png)

### Drivers

- Has an **id** - **BigInteger**
- Has a **full_name - String**
- Has a **many to many** relations with **Cars**

![image](https://user-images.githubusercontent.com/87463484/163786354-f25385b2-a124-4766-b377-a3804af52da1.png)
