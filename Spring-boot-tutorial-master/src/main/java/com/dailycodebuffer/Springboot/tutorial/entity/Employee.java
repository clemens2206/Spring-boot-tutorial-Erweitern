package com.dailycodebuffer.Springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "employee_sequence"
    )
    private Long employeeId;

    private String employeeFirstName;
    private String employeeLastName;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmentId"
    )
    private Department department;


}
