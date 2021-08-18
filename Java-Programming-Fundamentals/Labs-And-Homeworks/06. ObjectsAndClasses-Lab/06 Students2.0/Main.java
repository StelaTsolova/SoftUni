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
            updateStudentList(information, student);
            input = scanner.nextLine();
        }
        String targetCity = scanner.nextLine();
        printResult(information, targetCity);
    }

    private static void updateStudentList(List<Student> information, Student currentStudent) {
        boolean isFound = false;
        for (Student student : information) {
            if (student.getFirstName().equals(currentStudent.getFirstName()) && student.getLastName().equals(currentStudent.getLastName())) {
                student.setAge(currentStudent.getAge());
                student.setHometown(currentStudent.getHometown());
                isFound = true;
            }
        }
        if(!isFound){
            information.add(currentStudent);
        }
    }

    private static void printResult(List<Student> information, String targetCity) {
        for (Student student: information){
            if (student.getHometown().equals(targetCity)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
