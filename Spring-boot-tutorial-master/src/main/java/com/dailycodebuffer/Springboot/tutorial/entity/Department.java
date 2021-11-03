package com.dailycodebuffer.Springboot.tutorial.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;




}
