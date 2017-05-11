package com.example.turek.karol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.turek.karol.models.User;

public interface IUserRespository extends JpaRepository<User, Long> {
	User findByName(String name);
}
