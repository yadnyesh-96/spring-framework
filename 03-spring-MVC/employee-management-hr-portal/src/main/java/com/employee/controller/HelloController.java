package com.employee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;

public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Employee Management HR Portal ...!";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Employee HR Portal!";
	}

	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable("id") int id) {
		return "Employee ID: " + id;
	}

	@GetMapping("/employees")
	public String getDepartment(@RequestParam("department") String department) {
		return "Department " + department;
	}

	@PostMapping("/employees")
	public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {

		return "Name: " + employeeRequest.getName() + ", Department: " + employeeRequest.getDepartment() + ", Salary: "
				+ employeeRequest.getSalary();
	}

	@GetMapping("/employee")
	public Map<String, Object> getEmployee() {
		Map<String, Object> map = new HashMap<>();

		map.put("id", 1001);
		map.put("name", "Anuj");
		map.put("department", "IT");
		map.put("salary", 52000);

		return map;
	}

	@GetMapping("/employee/check")
	public ResponseEntity<String> checkEmployee() {

		boolean employeeExits = false;

		if (employeeExits) {
			return ResponseEntity.ok("Employee Exits");
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/employee/details")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails() {

		EmployeeResponse em = new EmployeeResponse();

		em.setId(1001);
		em.setName("Anuj");
		em.setDepartment("IT");
		em.setStatus("ACTIVE");

		return ResponseEntity.ok(em);

	}

}
