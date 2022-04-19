package com.greatlearning.EmployeeRest.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.EmployeeRest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findAllByOrderByFirstNameAsc();

	List<Employee> findAllByOrderByFirstNameDesc();

	List<Employee> findByFirstName(String firstName);

}
