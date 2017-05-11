package com.example.turek.karol.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.turek.karol.models.User;
import com.example.turek.karol.repositories.IUserRespository;

@Repository
public class UserDAO {
	@Autowired
	private IUserRespository repository;

	public User login(String name) {
		User user = repository.findByName(name);
		if (user != null) {
			return user;
		} else
			return null;
	}
}
