package com.example.employee.dtos.responses;

import com.example.employee.data.models.Employee;
import lombok.Data;

@Data
public class FindEmployeeResponse {
    private String fullName;
    private String emailId;

    public FindEmployeeResponse(Employee employees) {
        fullName = employees.getLastName() + employees.getFirstName();
        emailId = employees.getEmailId();
    }

    public FindEmployeeResponse() {

    }
}
