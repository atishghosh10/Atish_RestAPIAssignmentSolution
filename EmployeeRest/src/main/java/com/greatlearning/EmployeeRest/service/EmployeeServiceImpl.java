package com.greatlearning.EmployeeRest.service;

import java.util.List;

import com.greatlearning.EmployeeRest.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeRest.entity.Employee;
import com.greatlearning.EmployeeRest.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeRepository.getById(employeeId);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findAllByOrderByFirstNameAsc() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public List<Employee> findAllByOrderByFirstNameDesc() {
		return employeeRepository.findAllByOrderByFirstNameDesc();
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

}
