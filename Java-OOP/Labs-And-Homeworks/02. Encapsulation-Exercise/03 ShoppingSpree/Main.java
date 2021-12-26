package ShoppingSpree_3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = readPeople(scanner);
        Map<String, Product> products = readProduct(scanner);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            String personName = command[0];
            String productName = command[1];
            Person person = people.get(personName);
            Product product = products.get(productName);
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }

        people.values().forEach(System.out::println);

    }

    private static Map<String, Person> readPeople(Scanner scanner) {
        Map<String, Person> people = new LinkedHashMap<>();
        String[] information = scanner.nextLine().split(";");
        for (String info : information) {
            String name = info.split("=")[0];
            double money = Double.parseDouble(info.split("=")[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return people;
    }

    private static Map<String, Product> readProduct(Scanner scanner) {
        Map<String, Product> products = new LinkedHashMap<>();
        String[] information = scanner.nextLine().split(";");
        for (String info : information) {
            String name = info.split("=")[0];
            double cost = Double.parseDouble(info.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }
}