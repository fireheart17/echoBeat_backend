package com.echobeat.echobeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.echobeat.model.Employee;
import com.echobeat.echobeat.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<String> getEmployeeById(@PathVariable("id") long employeeID){
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeID).getFirstName(),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from db
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted Successfully.",HttpStatus.OK);
    }

}