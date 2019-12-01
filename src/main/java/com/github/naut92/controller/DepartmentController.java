package com.github.naut92.controller;

import com.github.naut92.model.Department;
import com.github.naut92.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService service) {
        departmentService = service;
    }

    //for dev-mode only:
    @GetMapping("/departments")
    public Collection<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
}
