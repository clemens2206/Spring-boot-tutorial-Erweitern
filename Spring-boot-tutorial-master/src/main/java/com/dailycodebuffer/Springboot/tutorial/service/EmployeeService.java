package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeeList();

    Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    void deleteEmployeeById(Long employeeId);
}
