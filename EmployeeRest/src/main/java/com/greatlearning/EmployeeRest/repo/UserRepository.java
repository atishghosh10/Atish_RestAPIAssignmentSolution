package com.greatlearning.EmployeeRest.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.EmployeeRest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("FROM User u WHERE u.username = :username")
	User getByUsername(String username);

}
