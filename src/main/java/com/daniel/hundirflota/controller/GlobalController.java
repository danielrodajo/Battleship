package com.daniel.hundirflota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.service.AppUserService;

@Component
public class GlobalController {

	@Autowired private AppUserService userService;

    public AppUser getAppUserDetails(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByEmail(email);
    }
	
}
