package ComparingObjects_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] information = input.split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            String town = information[2];
            Person person = new Person(name, age, town);
            persons.add(person);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person person = persons.get(n - 1);
        int countEquals = 0;
        for (Person currentPerson: persons){
            if (currentPerson.compareTo(person) == 0){
                countEquals++;
            }
        }

        if (countEquals == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", countEquals, persons.size() - countEquals, persons.size());
        }
    }
}