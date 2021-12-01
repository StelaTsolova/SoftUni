package EqualityLogic_7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> hashPerson = new HashSet<>();
        Set<Person> treePerson = new TreeSet<>();

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            Person person = new Person(name, age);
            hashPerson.add(person);
            treePerson.add(person);
        }

        System.out.println(hashPerson.size());
        System.out.println(treePerson.size());
    }
}