package com.example.turek.karol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.turek.karol.models.Toy;

public interface IToysRepository extends JpaRepository<Toy, Long> {

}
