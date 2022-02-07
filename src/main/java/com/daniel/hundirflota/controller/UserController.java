package com.daniel.hundirflota.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.User;
import com.daniel.hundirflota.service.BoardService;
import com.daniel.hundirflota.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController extends GlobalController {
	
	@Autowired private UserService userService;
	@Autowired private BoardService boardService;

    @GetMapping("/info")
    public User getUser(){
        return getUserDetails();
    }
    
    
}
