package Openning_3_16December2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name)  {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report(){
        StringBuilder info = new StringBuilder();
        info.append(String.format("Employees working at Bakery %s:", this.name)).append(System.lineSeparator());
        employees.forEach(e -> info.append(e).append(System.lineSeparator()));
        return info.toString();
    }
}