package com.employee.service;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public EmployeeResponse createEmployee(EmployeeRequest req) {

		Employee e = new Employee();
		e.setName(req.getName());
		e.setDepartment(req.getDepartment());
		e.setSalary(req.getSalary());
		e.setStatus("ACTIVE");

		Employee saveEmployee = employeeRepository.save(e);

		EmployeeResponse em = new EmployeeResponse();
		em.setId(saveEmployee.getId());
		em.setName(saveEmployee.getName());
		em.setDepartment(saveEmployee.getDepartment());
		em.setStatus(saveEmployee.getStatus());

		return em;
	}

	public EmployeeResponse getEmployeeById(int id) {

		return null;
	}
}
