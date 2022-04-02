package com.example.employee.services;

import com.example.employee.data.models.Employee;
import com.example.employee.data.repository.EmployeeRepository;
import com.example.employee.dtos.requests.CreateEmployeeRequest;
import com.example.employee.dtos.responses.CreateEmployeeResponse;
import com.example.employee.dtos.responses.FindEmployeeResponse;
import com.example.employee.exceptions.ResourceNotFoundException;
import com.example.employee.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class CreateEmployeeServiceImpl implements CreateEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest requests) {
        Employee employee = ModelMapper.map(requests);
        Employee savedEmployee = employeeRepository.save(employee);
        return ModelMapper.map(savedEmployee);
    }

    @Override
    public List<FindEmployeeResponse> findEmployeeByName(String name) {
        List<Employee> employee = findEmployeeByFirstNameOrLastName(name);
        if (employee.isEmpty()) throw new ResourceNotFoundException("Employee Not Found");
        List<FindEmployeeResponse> responses = new ArrayList<>();
        employee.forEach(employees->{
                    responses.add(new FindEmployeeResponse(employees));
                    responses.add(ModelMapper.employeeToFindEmployeeResponse(employees));
                }
        );
        return responses;
    }

    @Override
    public FindEmployeeResponse findEmployeeByFirstName(String firstName) {
        Employee employee = employeeRepository.findEmployeeByFirstName(firstName);
        if (employee == null) throw new ResourceNotFoundException("Employee Not Found");
        FindEmployeeResponse response = new FindEmployeeResponse();
        response.setFullName(employee.getLastName() + " " + employee.getFirstName());
        response.setEmailId(employee.getEmailId());
        return response;
    }

    @Override
    public Employee updateEmployee(String name,Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findEmployeeByFirstName(name);
        if (updateEmployee == null) throw new ResourceNotFoundException("Employee not exists with name: " + name);

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return updateEmployee;
    }

    @Override
    public void deleteEmployee(CreateEmployeeRequest requests) {
        Employee employee = new Employee(requests.getFirstName(), requests.getLastName(),requests.getEmailId());
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    private List<Employee> findEmployeeByFirstNameOrLastName(String name) {
        List<Employee> employee = new ArrayList<>();
        employee.add(employeeRepository.findEmployeeByFirstName(name));
        employee.add(employeeRepository.findEmployeeByLastName(name));
        return employee;
    }
}
