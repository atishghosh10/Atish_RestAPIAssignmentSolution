package com.greatlearning.EmployeeRest.dao;

import java.util.List;

import com.greatlearning.EmployeeRest.entity.User;

public interface UserService {
	public List<User> findAll();

	public User save(User user);

}
