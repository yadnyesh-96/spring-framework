package com.employee.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.employee.model.Employee;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee save(Employee employee) {

		String sql = """
				INSERT INTO employees
				(name, department, salary, status)
				VALUES (?, ?, ?, ?)
				""";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDepartment());
			ps.setInt(3, employee.getSalary());
			ps.setString(4, employee.getStatus());

			return ps;

		}, keyHolder);

		employee.setId(keyHolder.getKey().intValue());

		return employee;
	}

	@Override
	public Employee findById(int id) {
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Override
	public boolean update(Employee employee) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
