package com.greatlearning.EmployeeRest.dao;

import java.util.List;

import com.greatlearning.EmployeeRest.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Employee save(Employee employee);

	Employee findById(int employeeId);

	void deleteById(int id);

	List<Employee> findAllByOrderByFirstNameAsc();

	List<Employee> findAllByOrderByFirstNameDesc();

	List<Employee> findByFirstName(String firstName);

}
