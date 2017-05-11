package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.turek.karol.models.User;
import com.example.turek.karol.models.UserRole;
import com.example.turek.karol.repositories.IRoleRepository;
import com.example.turek.karol.repositories.IUserRespository;

@RestController
public class Registration {
	@Autowired
	IUserRespository repository;
	@Autowired
	IRoleRepository roleRepository;
	
	@GetMapping("/registration")
	@ModelAttribute
	public String getRegistration(Model model){
		return "registration";
	}
	
	@PostMapping("/registration")
	@ModelAttribute
	public String registration(@RequestParam("username") String name, 
			@RequestParam("password") String password,
			Model model) {
		User user = new User();
		UserRole role = new UserRole();
		if (repository.findByName(name) != null) {
			model.addAttribute("error", "error");
			return "error";
		} else {
			user.setName(name);
			user.setPassword(password);
			role.setRole("ROLE_USER");
			role.setUser(user);
			repository.save(user);
			roleRepository.save(role);
			model.addAttribute("message", "message");
			return "message";
		}
	}
}
