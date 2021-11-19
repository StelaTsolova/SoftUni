package CompanyRoster_2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String department = information[3];
            Employee employee = null;

            if (information.length == 6) {
                String email = information[4];
                int age = Integer.parseInt(information[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (information.length == 5) {
                if (information[4].contains("@")) {
                    String email = information[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(information[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (information.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department maxDepartment = departments.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().getAverageSalary())).get().getValue();

        System.out.println("Highest Average Salary: " + maxDepartment.getDepartmentName());
        maxDepartment.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        maxDepartment.getEmployees()
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}