package com.example.turek.karol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.turek.karol.DAO.UserDAO;
import com.example.turek.karol.DTO.UserPrincipalDTO;
import com.example.turek.karol.models.User;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDAO userDao;

	@Transactional
	@Override
	@PostMapping
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userDao.login(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipalDTO(user);
	}

}
