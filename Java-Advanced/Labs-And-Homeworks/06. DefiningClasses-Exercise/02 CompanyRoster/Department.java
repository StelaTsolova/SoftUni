package CompanyRoster_2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getAverageSalary() {
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
}
