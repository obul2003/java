package com.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	String query;

	@Autowired
	JdbcTemplate template;

	// Constructor for initializing JdbcTemplate
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void update(Employee emp) {
		query = "update mvc_employeei210 set first_name=?, last_name=?, email=? where id=?";
		template.update(query, emp.getFirst_name(), emp.getLast_name(), emp.getEmail(), emp.getId());
	}

	public void delete(int id) {
		query = "delete from mvc_employeei210 where id=?";
		template.update(query, id);
	}

	public Employee getEmpById(int id) {
		query = "select * from mvc_employeei210 where id=?";
		return template.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployees() {
		query = "select * from mvc_employeei210";
		return template.query(query, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setEmail(rs.getString("email"));
				return e;
			}
		});
	}

	public void save(Employee emp) {
		query = "insert into mvc_employeei210 (first_name, last_name, email) values (?, ?, ?)";
		template.update(query, emp.getFirst_name(), emp.getLast_name(), emp.getEmail());
	}
}
