package WildFarm_3;

import WildFarm_3.Animal.*;
import WildFarm_3.Food.Food;
import WildFarm_3.Food.Meat;
import WildFarm_3.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        String[] animalInfo = scanner.nextLine().split("\\s+");
        while (!animalInfo[0].equals("End")) {
            Animal animal = null;
            switch (animalInfo[0]) {
                case "Mouse":
                    animal = new Mouse(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
                case "Cat":
                    animal = new Cat(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]),
                            animalInfo[3], animalInfo[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food = null;
            switch (foodInfo[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodInfo[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodInfo[1]));
                    break;
            }

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            animalInfo = scanner.nextLine().split("\\s+");
        }
        animals.forEach(System.out::println);
    }
}
