package com.example.employee.data.repository;

import com.example.employee.data.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;


public interface EmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee> findEmployeeByFirstNameOrLastName(String firstName);

    Employee findEmployeeByFirstName(String firstName);

    Employee findEmployeeByLastName(String lastName);
}
