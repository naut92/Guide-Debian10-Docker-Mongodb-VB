package com.github.naut92.services;

import com.github.naut92.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Collection<Employee> getAllEmployees();

    Collection<Employee> findEmployeeByDepartmentId(String departmentId);

    Collection<Employee> findEmployeeByPositionId(String positionId);

    Optional<Employee> updateEmployee(String employeeId, Employee employee);

    Employee createEmployee(Employee employee);

    void deleteById(String employeeId);

    Optional<Employee> getEmployeeById(String employeeId);

    Employee findEmployeeByEmail(String employeeEmail);
}
