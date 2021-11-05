package com.dailycodebuffer.Springboot.tutorial.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private Long departmentId;
}
