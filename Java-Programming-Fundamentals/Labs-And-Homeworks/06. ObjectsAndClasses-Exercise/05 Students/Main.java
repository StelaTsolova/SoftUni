package Students_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int countStudents = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < countStudents; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstname = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstname, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student::getGrade));
        for (int i = students.size() - 1; i >= 0 ; i--) {
            System.out.println(students.get(i));
        }
    }
}
