package com.example.turek.karol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.turek.karol.models.Cat;

public interface ICatsRepository extends JpaRepository<Cat, Long> {
	Cat findByName(String name);
	List<Cat> findByUserName(String name);
}
