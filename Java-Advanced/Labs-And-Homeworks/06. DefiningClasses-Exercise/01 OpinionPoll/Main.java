package OpinionPoll_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }
        persons.stream().filter(e -> e.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.println(e.getName() + " - " + e.getAge()));
    }
}