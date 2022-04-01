package com.example.springdataautomappingobjects.repositories;

import com.example.springdataautomappingobjects.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
