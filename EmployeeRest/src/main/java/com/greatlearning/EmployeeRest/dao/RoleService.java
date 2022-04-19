package com.greatlearning.EmployeeRest.dao;

import java.util.List;

//import com.greatlearning.EmployeeRest.entity.Employee;
import com.greatlearning.EmployeeRest.entity.Role;

public interface RoleService {
	public List<Role> findAll();

	public void save(Role role);

}
