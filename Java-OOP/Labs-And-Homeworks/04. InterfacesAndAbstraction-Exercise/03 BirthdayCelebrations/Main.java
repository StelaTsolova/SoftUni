package BirthdayCelebrations_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Citizen")) {
                String name = command[1];
                int age = Integer.parseInt(command[2]);
                String id = command[3];
                String birthDate = command[4];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                birthables.add(citizen);
            } else if (command[0].equals("Pet")) {
                String name = command[1];
                String birthDate = command[2];
                Pet pet = new Pet(name, birthDate);
                birthables.add(pet);
            }
            input = scanner.nextLine();
        }
        String specificYear = scanner.nextLine();

        birthables.stream().filter(b -> b.getBirthDate().endsWith(specificYear))
                .forEach(b -> System.out.println(b.getBirthDate()));
    }
}