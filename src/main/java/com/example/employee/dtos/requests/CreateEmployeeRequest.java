package com.example.employee.dtos.requests;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String emailId;
}
