package com.vn.dao;

import java.util.List;

import com.vn.entities.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAll();

	public Employee insert(Employee employee);
}
