package com.example.turek.karol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.example.turek.karol.DAO.AllCatsDAO;

@RestController
public class GetAllCats {
	@Autowired
	AllCatsDAO catsDao;

	@GetMapping("/getall")
	@ModelAttribute
	public String getAll(Model model) {
		model.addAttribute("cats", catsDao.allCats());
		return "getall";
	}
}
