package com.example.springdataautomappingobjects.services;

import com.example.springdataautomappingobjects.models.dtos.EmployeeDto;
import com.example.springdataautomappingobjects.models.dtos.ManagerDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeDto(Long employeeId);

    List<ManagerDto> getAllManagerDtos();
}
