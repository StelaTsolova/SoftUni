package PizzaCalories_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String pizzaName = input[1];
        int numberOfToppings = Integer.parseInt(input[2]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        input = scanner.nextLine().split("\\s+");
        String flourType = input[1];
        String bakingTechnique = input[2];
        double weightInGrams = Double.parseDouble(input[3]);
        Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
        pizza.setDough(dough);

        input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            String toppingType = input[1];
            double weightGrams = Double.parseDouble(input[2]);
            Topping topping = new Topping(toppingType, weightGrams);
            pizza.addTopping(topping);

            input = scanner.nextLine().split("\\s+");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }
}
