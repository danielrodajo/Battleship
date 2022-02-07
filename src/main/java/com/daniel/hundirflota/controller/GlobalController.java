package com.daniel.hundirflota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.daniel.hundirflota.entity.User;
import com.daniel.hundirflota.service.UserService;

@Component
public class GlobalController {

	@Autowired private UserService userService;

    public User getUserDetails(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByEmail(email);
    }
	
}
