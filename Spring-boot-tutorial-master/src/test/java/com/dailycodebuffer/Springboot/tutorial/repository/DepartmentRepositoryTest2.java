package com.dailycodebuffer.Springboot.tutorial.repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest2 {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void saveDepartment(){
    Employee employee1 = Employee.builder()
            .employeeFirstName("Paul")
            .employeeLastName("Schonger")
            .build();

    Employee employee2 = Employee.builder()
            .employeeFirstName("Julian")
            .employeeLastName("Berger")
            .build();

    Employee employee3 = Employee.builder()
            .employeeFirstName("Jakob")
            .employeeLastName("Falch")
            .build();


    Department department = Department.builder()
            .departmentCode("IT-10")
            .departmentName("IT")
            .departmentAddress("London")
            .employeeList(List.of(employee1, employee2, employee3)).build();

            departmentRepository.save(department);
   }
}