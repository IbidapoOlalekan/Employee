package com.example.employee.controller;

import com.example.employee.data.models.Employee;
import com.example.employee.dtos.requests.CreateEmployeeRequest;
import com.example.employee.dtos.responses.ApiResponse;
import com.example.employee.exceptions.ResourceNotFoundException;
import com.example.employee.services.CreateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private CreateEmployeeService createEmployeeService;
    @PostMapping("/create")
    public ResponseEntity<?> createEmployees(@RequestBody CreateEmployeeRequest request) {
        try {
            return new ResponseEntity<>(createEmployeeService.create(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        try {
            return new ResponseEntity<>(createEmployeeService.findAllEmployees(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestBody  CreateEmployeeRequest request){
        try {
            createEmployeeService.deleteEmployee(request);
            return new ResponseEntity<>(new ApiResponse(true,"Deleted Successfully"), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{name}")
    public ResponseEntity<?> getEmployeesByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(createEmployeeService.findEmployeeByName(name),HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/FirstName/{keyword}")
    public ResponseEntity<?> getEmployeeByFirstName(@PathVariable ("keyword") String firstName){
        try{
            return new ResponseEntity<>(createEmployeeService.findEmployeeByFirstName(firstName),HttpStatus.OK);
        }
        catch(ResourceNotFoundException ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{name}")
    public ResponseEntity<?> updateEmployee(@PathVariable String name, @RequestBody Employee employeeDetails){
        try {
            return new ResponseEntity<>(createEmployeeService.updateEmployee(name,employeeDetails),HttpStatus.OK);
        }
        catch (ResourceNotFoundException ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


}

