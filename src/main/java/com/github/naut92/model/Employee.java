package com.github.naut92.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String department_id;
    private String position_id;
    private String pass;
    private Department departmentById;
    private Position positionById;
}