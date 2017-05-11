package com.example.turek.karol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turek.karol.DAO.AllCatsDAO;
import com.example.turek.karol.DTO.CatShowDTO;

@RestController
public class GetAllCats {
	@Autowired
	AllCatsDAO catsDao;

	@GetMapping("/getall")
	public List<CatShowDTO> getAll() {
		return catsDao.allCats();
	}
}
