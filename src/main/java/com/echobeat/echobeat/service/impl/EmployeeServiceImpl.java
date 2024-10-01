package com.echobeat.echobeat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echobeat.echobeat.model.Employee;
import com.echobeat.echobeat.repository.EmployeeRepository;
import com.echobeat.echobeat.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //save employee in database
    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //get all employee form database
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    //get employee using id
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee =  employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update employee
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    //delete employee
    @Override
    public void deleteEmployee(long id) {
        //check
        employeeRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        employeeRepository.deleteById(id);
    }
}