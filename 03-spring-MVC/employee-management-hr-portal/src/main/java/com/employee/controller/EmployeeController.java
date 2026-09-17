package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {

		EmployeeResponse em = employeeService.createEmployee(employeeRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(em);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") int id) {

		EmployeeResponse em = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(em);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

		List<EmployeeResponse> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> patchEmployee(@PathVariable("id") int id,
			@RequestBody @Valid EmployeeRequest employeeRequest) {

		return ResponseEntity.ok("Employee " + id + " updated successfully");
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int id,
			@RequestBody @Valid EmployeeRequest employeeRequest) {

		boolean update = employeeService.UpdateEmployee(id, employeeRequest);

		if (!update) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Id: " + id + " Not found");
		}
		return ResponseEntity.ok("Employee " + id + " updated");
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {

		if (!employeeService.deleteEmployee(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with Id: " + id + " Not Found");
		}
		
		return ResponseEntity.ok("Employee " + id + " deleted successfully");
	}
}
