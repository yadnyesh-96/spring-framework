package com.employee.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.employee.dto.EmployeeResponse;
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

		String sql = """
				SELECT id, name, department, salary, status
				FROM employees
				WHERE id = ?
				""";

		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Employee employee = new Employee();

			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setDepartment(rs.getString("department"));
			employee.setSalary(rs.getInt("salary"));
			employee.setStatus(rs.getString("status"));

			return employee;
		}, id);
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT id, name, department, salary, status FROM employees", (rs, rowNum) -> {
			Employee e = new Employee();
			e.setId(rs.getInt("Id"));
			e.setName(rs.getString("name"));
			e.setDepartment(rs.getString("department"));
			e.setSalary(rs.getInt("salary"));
			e.setStatus(rs.getString("status"));

			return e;
		});
	}

	@Override
	public boolean update(Employee employee) {

		int val = jdbcTemplate.update("UPDATE employees SET name=?,department=?,salary=?,status=? WHERE id=?",
				employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getStatus(),
				employee.getId());
		return val > 0;
	}

	@Override
	public boolean delete(int id) {
		int val = jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
		return val > 0;
	}

}
