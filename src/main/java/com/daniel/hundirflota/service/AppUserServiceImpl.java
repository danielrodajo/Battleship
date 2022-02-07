package com.daniel.hundirflota.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	AppUserRepository userRepository;
	
	@Override
	public AppUser save(AppUser user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return userRepository.save(user);
	}

	@Override
	public AppUser edit(AppUser u) {
		return userRepository.save(u);
	}

	@Override
	public AppUser findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	@Override
	public AppUser findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}
