package com.employee.service;

import java.util.ArrayList;
import java.util.List;

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
		Employee e = employeeRepository.findById(id);

		EmployeeResponse res = new EmployeeResponse();
		res.setId(e.getId());
		res.setName(e.getName());
		res.setDepartment(e.getDepartment());
		res.setStatus(e.getStatus());

		return res;
	}

	public List<EmployeeResponse> getAllEmployees() {

		List<Employee> emp = employeeRepository.findAll();

		List<EmployeeResponse> res = new ArrayList<>();

		for (Employee em : emp) {
			EmployeeResponse r = new EmployeeResponse();
			r.setId(em.getId());
			r.setName(em.getName());
			r.setDepartment(em.getDepartment());
			r.setStatus(em.getStatus());

			res.add(r);
		}

		return res;
	}

	public boolean UpdateEmployee(int id, EmployeeRequest request) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(request.getName());
		employee.setDepartment(request.getDepartment());
		employee.setSalary(request.getSalary());
		employee.setStatus("ACTIVE");

		return employeeRepository.update(employee);
	}

	public boolean deleteEmployee(int id) {
		return employeeRepository.delete(id);
	}
}
