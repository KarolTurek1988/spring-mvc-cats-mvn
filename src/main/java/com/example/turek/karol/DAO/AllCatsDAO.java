package com.example.turek.karol.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.example.turek.karol.DTO.CatShowDTO;
import com.example.turek.karol.models.Cat;
import com.example.turek.karol.repositories.ICatsRepository;

@Repository
public class AllCatsDAO {
	private ICatsRepository catsRepository;

	@Autowired
	public AllCatsDAO(ICatsRepository catsRepository) {
		super();
		this.catsRepository = catsRepository;
	}

	public List<CatShowDTO> allCats() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		CatShowDTO catShow = new CatShowDTO();
		List<CatShowDTO> dto = new ArrayList<>();
		for (Cat cat : catsRepository.findByUserName(name)) {
			catShow.setName(cat.getName());
			catShow.setAge(cat.getAge());
			catShow.setRase(cat.getRase());
			dto.add(catShow);
		}
		return dto;
	}
}
