package com.greatlearning.EmployeeRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.greatlearning.EmployeeRest.dao.RoleService;
import com.greatlearning.EmployeeRest.entity.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;

	@GetMapping("/list")
	public List<Role> listEmployee() {
		// get roles from db
		List<Role> roles = roleService.findAll();
		System.out.println(roles);
		return roles;
	}

	@PostMapping("/save")
//    public String save(@RequestParam("role_id") int role_id , @RequestParam("name") String name) 
	public Role save(@RequestBody Role role) {
//        role.setId(0);
		roleService.save(role);
		return role;

	}

}
