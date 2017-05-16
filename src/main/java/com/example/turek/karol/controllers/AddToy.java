package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.turek.karol.models.Cat;
import com.example.turek.karol.models.Toy;
import com.example.turek.karol.repositories.IToysRepository;

@RestController
public class AddToy {
	private IToysRepository toysRespository;

	@Autowired
	public AddToy(IToysRepository toysRespository) {
		super();
		this.toysRespository = toysRespository;
	}

	@PostMapping("/addtoy")
	public Toy addToy(
			@RequestParam Cat cat, 
			@RequestParam String name, 
			@RequestParam String type) {
		Toy toy = new Toy();
		toy.setName(name);
		toy.setType(type);
		toy.setCat(cat);
		toysRespository.save(toy);
		return toy;
	}
}
