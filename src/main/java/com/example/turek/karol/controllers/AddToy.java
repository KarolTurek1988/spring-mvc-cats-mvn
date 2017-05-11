package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.turek.karol.models.Toy;
import com.example.turek.karol.repositories.ICatsRepository;
import com.example.turek.karol.repositories.IToysRepository;

@RestController
public class AddToy {
	private ICatsRepository catsRepository;
	private IToysRepository toysRespository;

	@Autowired
	public AddToy(ICatsRepository catsRepository, IToysRepository toysRespository) {
		super();
		this.catsRepository = catsRepository;
		this.toysRespository = toysRespository;
	}

	@PostMapping("/{cat}/addtoy")
	public Toy addToy(@PathVariable String cat, @RequestParam String name, @RequestParam String type) {
		Toy toy = new Toy();
		toy.setName(name);
		toy.setType(type);
		toy.setCat(catsRepository.findByName(cat));
		toysRespository.save(toy);
		return toy;
	}
}
