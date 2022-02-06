package com.daniel.hundirflota.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.User;
import com.daniel.hundirflota.models.LoginCredentials;
import com.daniel.hundirflota.repository.UserRepository;
import com.daniel.hundirflota.security.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired private UserRepository userRepository;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody User user) {
    	String encodedPass = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPass);
    	user = userRepository.save(user);
    	String token = jwtUtil.generateToken(user.getEmail());
    	
    	return Collections.singletonMap("jwt-token", token);
    }
    
    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body) {
    	try {
    		UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());
    		authManager.authenticate(authInputToken);
    		
    		String token = jwtUtil.generateToken(body.getEmail());
    		
    		return Collections.singletonMap("jwt-token", token);
    	} catch (AuthenticationException ex) {
    		throw new RuntimeException("Ivalid Login Credentials");
    	}
    }
}
