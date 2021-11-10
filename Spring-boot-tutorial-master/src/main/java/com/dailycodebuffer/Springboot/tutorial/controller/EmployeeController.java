package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.EmployeeRepository;
import com.dailycodebuffer.Springboot.tutorial.service.EmployeeDTO;
import com.dailycodebuffer.Springboot.tutorial.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody EmployeeDTO employee) throws DepartmentNotFoundException {
        LOGGER.info("Inside saveEmployee of EmloyeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList(){
        LOGGER.info("Inside fetchEmployeeList of EmployeeController");
        return employeeService.fetchEmployeeList();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException{
        return employeeService.fetchEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted Successfully!!";
    }

}
