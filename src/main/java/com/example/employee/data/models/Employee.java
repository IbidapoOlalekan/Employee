package com.example.employee.data.models;

import lombok.*;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String emailId;
}
