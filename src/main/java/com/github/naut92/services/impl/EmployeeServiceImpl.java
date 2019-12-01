package com.github.naut92.services.impl;

import com.github.naut92.model.Department;
import com.github.naut92.model.Employee;
import com.github.naut92.model.Position;
import com.github.naut92.repository.DepartmentRepository;
import com.github.naut92.repository.EmployeeRepository;
import com.github.naut92.repository.PositionRepository;
import com.github.naut92.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository repository, DepartmentRepository dr, PositionRepository pr) {
        this.employeeRepository = repository;
        this.departmentRepository = dr;
        this.positionRepository = pr;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee findEmployeeByEmail(String employeeEmail) {
        return employeeRepository.findEmployeeByEmail(employeeEmail);
    }

    @Override
    public Collection<Employee> findEmployeeByDepartmentId(String departmentId) {
        Optional<Department> d = departmentRepository.findById(departmentId);
        if(d.isPresent()) return d.get().getEmployeeById();
        else return new ArrayList<>();
    }

    @Override
    public Collection<Employee> findEmployeeByPositionId(String positionId) {
        Optional<Position> p = positionRepository.findById(positionId);
        if(p.isPresent()) return p.get().getEmployeeById();
        else return new ArrayList<>();
    }

    @Override
    public Optional<Employee> updateEmployee(String employeeId, Employee employee) {
        Optional<Employee> employeeUPD = employeeRepository.findById(employeeId);
        Optional<Position> position = positionRepository.findById(employee.getPosition_id());
        Optional<Department> department = departmentRepository.findById(employee.getDepartment_id());
        if (employeeUPD.isPresent() && position.isPresent() && department.isPresent()) {
            employeeUPD.get().setPositionById(position.get());
            employeeUPD.get().setDepartmentById(department.get());
            employeeUPD.get().setFirstname(employee.getFirstname());
            employeeUPD.get().setLastname(employee.getLastname());
            employeeUPD.get().setEmail(employee.getEmail());
            employeeUPD.get().setDepartment_id(employee.getDepartment_id());
            employeeUPD.get().setPosition_id(employee.getPosition_id());

            String encPassword = "12A34";
            //BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
            //String encPassword = pe.encode(employee.getPass());

            //System.out.println("encPassword: " + encPassword);
            employeeUPD.get().setPass(encPassword);

            employeeRepository.save(employeeUPD.get());
            System.out.println("new Employee pass: " + employeeRepository.findById(employeeId).get().getPass());

            return employeeUPD;
        } else return Optional.empty();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setDepartment_id(employee.getDepartment_id());
        employee.setPosition_id(employee.getPosition_id());
        //BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        //String encPassword = pe.encode(employee.getPass());
        //employee.setPass(encPassword);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
