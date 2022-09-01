package com.example.demo.controller;

import com.example.demo.exception.ResourceAlreadyExistException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity handlerNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id "+id+" Not Found"));
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    Employee addNewEmployee(@RequestBody Employee employee){
        if (employeeRepository.existsById(employee.getId()))
            throw new ResourceAlreadyExistException("Employee with id "+employee.getId()+" Already Exist");
        else
            employeeRepository.save(employee);
        return employee;
    }
}
