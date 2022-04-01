package com.example.springdataautomappingobjects.services;

import com.example.springdataautomappingobjects.models.dtos.EmployeeDto;
import com.example.springdataautomappingobjects.models.dtos.ManagerDto;
import com.example.springdataautomappingobjects.models.entities.Employee;
import com.example.springdataautomappingobjects.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto getEmployeeDto(Long employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow();

        ModelMapper mapper = new ModelMapper();

        // different field names
//        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
//            @Override
//            protected void configure() {
//                map().setIncome(source.getSalary());
//            }
//        });

        // without ModelMapper
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setFirstName(employee.getFirstName());
//        employeeDto.setLastName(employee.getLastName());
//        employeeDto.setSalary(employee.getSalary());

        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<ManagerDto> getAllManagerDtos() {
        List<Employee> employees = this.employeeRepository.findAll();

        ModelMapper mapper = new ModelMapper();

        // mapper.map(employees, new TypeToken<List<ManagerDto>>() {}.getType())

        List<ManagerDto> managerDtos = employees.stream()
                .map(e -> mapper.map(e, ManagerDto.class))
                .filter(m -> !m.getSubordinates().isEmpty()).collect(Collectors.toList());

        return managerDtos;
    }
}
