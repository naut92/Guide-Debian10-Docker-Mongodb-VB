package com.github.naut92;

import com.github.naut92.model.Department;
import com.github.naut92.model.Employee;
import com.github.naut92.model.Position;
import com.github.naut92.repository.DepartmentRepository;
import com.github.naut92.repository.EmployeeRepository;
import com.github.naut92.repository.PositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GuideDebianApp implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(GuideDebianApp.class);

	public GuideDebianApp(EmployeeRepository er, PositionRepository pr, DepartmentRepository dr) {
		this.er = er;
		this.pr = pr;
		this.dr = dr;
	}

	public static void main(String[] args) {
		SpringApplication.run(GuideDebianApp.class, args);
	}


	private final EmployeeRepository er;
	private final PositionRepository pr;
	private final DepartmentRepository dr;

	public void run(String... strings){
		dr.deleteAll();
		pr.deleteAll();
		er.deleteAll();

		List<Employee> le = new ArrayList<>();
		List<Position> lp = new ArrayList<>();
		List<Department> ld = new ArrayList<>();

		Employee employee = new Employee("1", "firstname", "lastname", "email@email.com",
				"2", "3", "pass123", new Department(), new Position());
		le.add(employee);
		Position position = new Position("3", "position name", "2", new Department(), le);
		lp.add(position);
		Department department = new Department("2", "depart name", lp, le);
		ld.add(department);

		dr.saveAll(ld);
		pr.saveAll(lp);
		er.saveAll(le);

		log.info("department: " + dr.findAll());
	}
}
