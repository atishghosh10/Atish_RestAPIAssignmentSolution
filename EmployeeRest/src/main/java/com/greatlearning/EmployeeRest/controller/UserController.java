package com.greatlearning.EmployeeRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.greatlearning.EmployeeRest.dao.UserService;
import com.greatlearning.EmployeeRest.entity.Role;
import com.greatlearning.EmployeeRest.entity.User;

@RestController
@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/list")
	public List<User> listEmployee() {
		// get roles from db
		List<User> users = userService.findAll();
		System.out.println(users);
		return users;
	}

	@PostMapping("/save")
	public User save(@RequestBody User user) {
		user.setId(0l);
		return userService.save(user);
	}
}
