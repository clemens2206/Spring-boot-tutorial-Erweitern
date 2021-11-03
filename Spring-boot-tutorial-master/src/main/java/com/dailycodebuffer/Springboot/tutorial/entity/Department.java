package com.dailycodebuffer.Springboot.tutorial.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

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
            strategy = GenerationType.AUTO,
            generator = "department_sequence"
    )
    private Long departmentId;

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

 @OneToMany(
            cascade = CascadeType.ALL
    )
@JoinColumn(
        name = "department_id",
        referencedColumnName = "departmentId"
)
    private List<Employee> employeeList;


}
