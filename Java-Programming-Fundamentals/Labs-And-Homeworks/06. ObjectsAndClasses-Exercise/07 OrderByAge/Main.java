package OrderByAge_7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Person> people = new ArrayList<>();
        while (!input[0].equals("End")) {
            String name = input[0];
            String ID = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(name, ID, age);
            people.add(person);
            input = scanner.nextLine().split("\\s+");
        }
        people.sort(Comparator.comparing(Person::getAge));
       // people.stream().forEach(person -> System.out.println(person));
        for (Person person : people){
            System.out.println(person);
        }
    }
}
