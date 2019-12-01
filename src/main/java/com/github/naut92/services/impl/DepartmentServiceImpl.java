package com.github.naut92.services.impl;

import com.github.naut92.model.Department;
import com.github.naut92.repository.DepartmentRepository;
import com.github.naut92.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        departmentRepository = repository;
    }

    @Override
    public Collection<Department> getAllDepartments() {
        //return departments.stream().map(Department::getDepart_name).collect(Collectors.toCollection(ArrayList::new));
        return departmentRepository.findAll();
    }
}
