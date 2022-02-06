package com.daniel.hundirflota.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.User;
import com.daniel.hundirflota.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return userRepository.save(user);
	}

	@Override
	public User edit(User u) {
		return userRepository.save(u);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}
