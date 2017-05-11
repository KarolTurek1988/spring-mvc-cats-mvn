package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.turek.karol.models.Cat;
import com.example.turek.karol.models.User;
import com.example.turek.karol.repositories.ICatsRepository;
import com.example.turek.karol.repositories.IUserRespository;

@RestController
public class AddCat {
	private ICatsRepository repository;
	private IUserRespository userRepository;

	@Autowired
	public AddCat(ICatsRepository repository, IUserRespository userRepository) {
		super();
		this.repository = repository;
		this.userRepository = userRepository;
	}

	@GetMapping("/add")
	@ModelAttribute
	public String addCatGet() {
		return "add";
	}

	@PostMapping("/add")
	@ModelAttribute
	public String addCat(@RequestParam("name") String name, @RequestParam("age") String age,
			@RequestParam("rase") String rase, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userRepository.findByName(userName);
		Cat cat = new Cat();
		cat.setName(name);
		cat.setAge(Integer.parseInt(age));
		cat.setRase(rase);
		cat.setUser(user);
		repository.save(cat);
		model.addAttribute("add", "add");
		return "add";
	}
}
