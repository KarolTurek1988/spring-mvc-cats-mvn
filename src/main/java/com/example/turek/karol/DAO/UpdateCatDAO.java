package com.example.turek.karol.DAO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.turek.karol.models.Cat;
import com.example.turek.karol.repositories.ICatsRepository;

@Repository
public class UpdateCatDAO {
	private ICatsRepository repository;
	
	@Autowired
	public UpdateCatDAO(ICatsRepository repository) {
		super();
		this.repository = repository;
	}
	
	public String updateCat(
			String name,
			String age,
			String rase,
			Model model,
			HttpServletRequest request){
		String id = (String) request.getSession().getAttribute("id");
		Cat cat = repository.findById(Long.parseLong(id));
		if(!(name.isEmpty() || age.isEmpty() || rase.isEmpty())){
			cat.setName(name);
			cat.setAge(Integer.parseInt(age));
			cat.setRase(rase);
			repository.save(cat);
			model.addAttribute("update", "update");
			return "updatecat";
		}
			model.addAttribute("error", "error");
			return "updatecat";
	}
}
