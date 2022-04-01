package com.example.employee.services;

import com.example.employee.data.models.Employee;
import com.example.employee.dtos.requests.CreateEmployeeRequest;
import com.example.employee.dtos.responses.CreateEmployeeResponse;
import com.example.employee.dtos.responses.FindEmployeeResponse;

import java.util.List;

public interface CreateEmployeeService {
    CreateEmployeeResponse create(CreateEmployeeRequest requests);
    List<FindEmployeeResponse> findEmployeeByName(String name);
    FindEmployeeResponse findEmployeeByFirstName(String firstName);
    Employee updateEmployee(Employee employeeDetails, String name);
    void deleteEmployee(CreateEmployeeRequest employee);
    List<Employee> findAllEmployees();
}
