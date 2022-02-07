package com.daniel.hundirflota.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.models.LoginCredentials;
import com.daniel.hundirflota.security.JWTUtil;
import com.daniel.hundirflota.service.AppUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired private AppUserService userService;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    
    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody AppUser user) {
    	user = userService.save(user);
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
