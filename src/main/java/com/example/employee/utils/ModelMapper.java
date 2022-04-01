package com.example.employee.utils;

import com.example.employee.data.models.Employee;
import com.example.employee.dtos.requests.CreateEmployeeRequest;
import com.example.employee.dtos.responses.CreateEmployeeResponse;
import com.example.employee.dtos.responses.FindEmployeeResponse;

public class ModelMapper {
    public static Employee map(CreateEmployeeRequest requests){
        Employee employee = new Employee();
        employee.setFirstName(requests.getFirstName());
        employee.setLastName(requests.getLastName());
        employee.setEmailId(requests.getEmailId());
        return employee;
    }

    public static CreateEmployeeResponse map(Employee savedEmployee) {
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setFullName(savedEmployee.getLastName() +" " + savedEmployee.getFirstName());
        response.setEmailId(savedEmployee.getEmailId());
        return response;
    }

    public static FindEmployeeResponse employeeToFindEmployeeResponse(Employee employees) {
        FindEmployeeResponse response = new FindEmployeeResponse();

        response.setFullName(employees.getLastName() + " " + employees.getFirstName());
        response.setEmailId(employees.getEmailId());

        return response;

    }
}
