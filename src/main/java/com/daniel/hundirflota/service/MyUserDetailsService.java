package com.daniel.hundirflota.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.daniel.hundirflota.entity.User;
import com.daniel.hundirflota.repository.UserRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userRes = userRepository.findByEmail(email);
		if (userRes.isEmpty()) {
			throw new UsernameNotFoundException(String.format("No existe ningún usuario con el siguiente correo: %s", email));
		}
		User user = userRes.get();
		return new org.springframework.security.core.userdetails.User(
				email,
				user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
		);
	}

}
