package com.example.turek.karol.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.turek.karol.models.Cat;
import com.example.turek.karol.repositories.ICatsRepository;

@Repository
public class DeleteCatDAO {
	private ICatsRepository repository;
	
	@Autowired
	public DeleteCatDAO(ICatsRepository repository) {
		super();
		this.repository = repository;
	}

	public String deleteCat(
			String id,
			Model model){
		Cat cat = repository.findById(Long.parseLong(id));
		repository.delete(cat);
		model.addAttribute("delete", "delete");
		return "home";
	}
}
