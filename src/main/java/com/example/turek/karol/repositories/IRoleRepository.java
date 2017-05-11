package com.example.turek.karol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.turek.karol.models.UserRole;

public interface IRoleRepository extends JpaRepository<UserRole, Long> {

}
