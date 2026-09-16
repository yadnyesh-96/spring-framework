package com.employee.repository;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeRepository {

	Employee save(Employee employee);

	Employee findById(int id);

	List<Employee> findAll();

	boolean update(Employee employee);

	boolean delete(int id);
}
