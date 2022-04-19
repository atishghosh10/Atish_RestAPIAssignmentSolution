package com.greatlearning.EmployeeRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.greatlearning.EmployeeRest.dao.EmployeeService;
import com.greatlearning.EmployeeRest.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> listEmployee() {
//		throw new RuntimeException("Employee id is invalid");
		return employeeService.findAll();
	}

	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id is invalid");
		}
		return employee;
	}

	@PutMapping("/{employeeId}")
	public Employee update(@PathVariable int employeeId, @RequestBody Employee newEmployee) {
		Employee employee = employeeService.findById(employeeId);
		employee.setFirstName(newEmployee.getFirstName());
		employee.setLastName(newEmployee.getLastName());
		employee.setEmail(newEmployee.getEmail());
		return employeeService.save(employee);
	}

	@DeleteMapping("/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id is invalid");
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id -" + employeeId;
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeeSorted(@RequestParam("order") String order) {
		List<Employee> employee = null;
		if (order.equalsIgnoreCase("asc")) {
			employee = employeeService.findAllByOrderByFirstNameAsc();
		} else if (order.equalsIgnoreCase("desc")) {
			employee = employeeService.findAllByOrderByFirstNameDesc();
		}
		return employee;
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> searchBy(@PathVariable("firstName") String firstName) {
		List<Employee> employee = employeeService.findByFirstName(firstName);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		return employee;
	}
}
