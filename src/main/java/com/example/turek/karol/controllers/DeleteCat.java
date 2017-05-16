package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.turek.karol.DAO.DeleteCatDAO;

@Controller
public class DeleteCat {
	@Autowired private DeleteCatDAO deleteCat;
	
	@GetMapping("/deletecat")
	public String deleteCat(
			@ModelAttribute("id") String id,
			Model model){
		return deleteCat.deleteCat(id, model);
	}
}
