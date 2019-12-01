package com.github.naut92.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private String id;
    private String depart_name;
    private List<Position> positionById;
    private List<Employee> employeeById;
}
