package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import com.dailycodebuffer.Springboot.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Employee saveEmployee(EmployeeDTO employee) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(employee.getDepartmentId());

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Availabel");
        }

        Employee employeeOptional = Employee.builder()
                .employeeId(employee.getEmployeeId())
                .employeeLastName(employee.getEmployeeLastName())
                .employeeFirstName(employee.getEmployeeFirstName())
                .department(department.get())
                .build();

        return employeeRepository.save(employeeOptional);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);

    }
}
