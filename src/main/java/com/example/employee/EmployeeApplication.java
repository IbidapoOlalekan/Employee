package com.example.employee;

import com.example.employee.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {
    public static EmployeeController contactController = new EmployeeController();
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
