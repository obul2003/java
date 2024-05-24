package com.mvc.dao;

import java.util.List;

import com.mvc.model.Employee;

public interface EmployeeDao {

	void update(Employee emp);

	void delete(int id);

	Employee getEmpById(int id);

	List<Employee> getEmployees();

	void save(Employee emp);

}
