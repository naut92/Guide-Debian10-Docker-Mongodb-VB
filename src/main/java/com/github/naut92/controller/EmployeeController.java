package com.github.naut92.controller;

import com.github.naut92.model.Employee;
import com.github.naut92.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService s) {
        this.employeeService = s;
    }

    //for dev-mode only:
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId) {
        log.info("Employee find: employeeId={}", employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/department/{departmentId}")
    public Collection<Employee> findEmployeeByDepartmentId(@PathVariable("departmentId") String departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/position/{positionId}")
    public Collection<Employee> findEmployeeByPositionId(@PathVariable("positionId") String  positionId) {
        log.info("Employee find: positionId={}", positionId);
        return employeeService.findEmployeeByPositionId(positionId);
    }

    //<-------- CRUD operations ----->

    @PutMapping("/upd/{employeeId}")
    public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable String employeeId, @Valid @RequestBody Employee employee) {
        System.out.println("employeeId " + employeeId);
        System.out.println("employee " + employee );
        log.warn("Request to update Employee={}", employee);
        Optional<Employee> result = employeeService.updateEmployee(employeeId, employee);
        return ResponseEntity.ok().body(result);
    }


    @PostMapping("/new/employee")
    public ResponseEntity<Employee> createEmployee
            (@Valid @RequestBody Employee employee) throws URISyntaxException {
        log.warn("Request to create Employee={}", employee);
        Employee result = employeeService.createEmployee(employee);
        return ResponseEntity.created(new URI("/employee/" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String employeeId) {
        log.info("Request to delete Employee={}", employeeId);
        try {
            employeeService.deleteById(employeeId);
        }catch (Exception e) {
            log.error("объект не удалён");
            e.getStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}