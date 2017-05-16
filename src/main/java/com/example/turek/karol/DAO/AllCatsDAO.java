package com.example.turek.karol.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

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

	public List<Cat> allCats() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return catsRepository.findByUserName(name);
	}
}
