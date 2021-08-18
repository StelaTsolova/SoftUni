package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> information = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] infoStudent = input.split(" ");
            String firstName = infoStudent[0];
            String lastName = infoStudent[1];
            int age = Integer.parseInt(infoStudent[2]);
            String hometown = infoStudent[3];
            Student student = new Student(firstName, lastName, age, hometown);
            information.add(student);
            input = scanner.nextLine();
        }
        String targetCity = scanner.nextLine();
        for (Student student:information){
            if (student.getHometown().equals(targetCity)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
