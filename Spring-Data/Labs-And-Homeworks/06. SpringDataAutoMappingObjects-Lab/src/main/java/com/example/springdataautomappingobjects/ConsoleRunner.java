package com.example.springdataautomappingobjects;

import com.example.springdataautomappingobjects.models.dtos.EmployeeDto;
import com.example.springdataautomappingobjects.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private EmployeeService employeeService;

    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Simple Mapping
        EmployeeDto employeeDto = this.employeeService.getEmployeeDto(1L);

        System.out.printf("%s %s - %.2f%n", employeeDto.getFirstName(),
                employeeDto.getLastName(), employeeDto.getSalary());

        // 2. Advanced Mapping
        this.employeeService.getAllManagerDtos().forEach(m -> {
            System.out.printf("%s %s | Employees: %d%n",
                    m.getFirstName(), m.getLastName(), m.getSubordinates().size());
            m.getSubordinates().forEach(e -> System.out.printf("    - %s %s %.2f%n",
                    e.getFirstName(), e.getLastName(), e.getSalary()));
        });
    }
}
