package com.example.turek.karol.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.turek.karol.DAO.UpdateCatDAO;

@Controller
public class UpdateCat {
	@Autowired private UpdateCatDAO updateCatDao;
	
	@GetMapping("/updatecat")
	public String updateCatGet(
			@ModelAttribute("id") String id, 
			HttpServletRequest request){
		request.getSession().setAttribute("id", id);
		return "updatecat";
	}

	@PostMapping("/updatecat")
	@ModelAttribute
	public String updateCat(
			@RequestParam String name,
			@RequestParam String age,
			@RequestParam String rase,
			Model model,
			HttpServletRequest request) {
		return updateCatDao.updateCat(name, age, rase, model, request);
	}
}
