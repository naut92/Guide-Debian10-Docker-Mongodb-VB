package com.github.naut92.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    private String id;
    private String position_name;
    private String department_id;
    private Department departmentById;
    private List<Employee> employeeById;
}
