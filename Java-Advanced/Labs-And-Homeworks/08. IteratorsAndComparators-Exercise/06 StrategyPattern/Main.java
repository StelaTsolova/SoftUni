package StrategyPattern_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> sortByName = new TreeSet<>(new ComparatorByName());
        Set<Person> sortByAge = new TreeSet<>(new ComparatorByAge());

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            Person person = new Person(name, age);
            sortByName.add(person);
            sortByAge.add(person);
        }

        sortByName.forEach(System.out::println);
        sortByAge.forEach(System.out::println);
    }
}