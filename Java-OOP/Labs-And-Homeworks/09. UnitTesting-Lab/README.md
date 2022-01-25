# 1. Test Axe

In **test/java** folder, create a package called **rpg_tests**.

Create a class **AxeTests**.

Create the following tests:

- Test if weapon loses durability after each attack;
- Test attacking with a broken weapon.

# 2. Test Dummy

Create a class **DummyTests**.

Create the following tests:

- Dummy loses health if attacked.
- Dead Dummy throws exception if attacked.
- Dead Dummy can give XP.
- Alive Dummy can't give XP.

# 3. Refactor Tests

Refactor the tests for **Axe** and **Dummy** classes.

Make sure that:

- **Names** of test methods are **descriptive**.
- You use **appropriate assertions** (assert equals vs assert true).
- You use **assertion messages.**
- There are **no magic numbers.**
- There is **no code duplication** (Don't Repeat Yourself).

# 4. Fake Axe and Dummy

Test if hero gains XP when target dies.

To do this, you need to:

- Make **Hero** class **testable** (use **Dependency Injection**).
- Introduce **Interfaces** for Axe and Dummy:

  o Interface Weapon

  o Interface Target

Create fake Weapon and fake Dummy for the test.

# 5. Mocking

Include Mockito in the project dependencies, then:

1. Mock fakes from previous problem.

2. Implement **Hero Inventory**, holding unequipped weapons:

  a. method - **Iterable<Weapon\> getInventory()**

3. Implement Target giving random weapon upon death:

  a. field - **private List<Weapon\> possibleLoot**

4. Test Hero killing a target getting loot in his inventory
