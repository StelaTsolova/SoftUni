import Google_7.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] information = input.split("\\s+");
            String name = information[0];
            people.putIfAbsent(name, new Person(name));
            switch (information[1]) {
                case "company":
                    String companyName = information[2];
                    String department = information[3];
                    double salary = Double.parseDouble(information[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = information[2];
                    String pokemonType = information[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = information[2];
                    String parentBirthday = information[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = information[2];
                    String childBirthday = information[3];
                    Child child = new Child(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = information[2];
                    int carSpeed = Integer.parseInt(information[3]);
                    Car car = new Car(carModel, carSpeed);
                    people.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        System.out.println(people.get(name).toString());
    }
}