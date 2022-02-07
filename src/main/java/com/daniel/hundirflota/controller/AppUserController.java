package com.daniel.hundirflota.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.service.BoardService;
import com.daniel.hundirflota.service.AppUserService;

@RestController
@RequestMapping("/api/user")
public class AppUserController extends GlobalController {
	
	@Autowired private AppUserService userService;
	@Autowired private BoardService boardService;

    @GetMapping("/info")
    public AppUser getAppUser(){
        return getAppUserDetails();
    }
    
    
}
