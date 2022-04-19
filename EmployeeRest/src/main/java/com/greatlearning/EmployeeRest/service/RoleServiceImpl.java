package com.greatlearning.EmployeeRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.EmployeeRest.repo.EmployeeRepository;
import com.greatlearning.EmployeeRest.entity.Role;
import com.greatlearning.EmployeeRest.repo.RoleRepository;
import com.greatlearning.EmployeeRest.dao.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

}
