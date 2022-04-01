package com.example.employee.dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateEmployeeResponse {
    private String fullName;
    private String emailId;
}
