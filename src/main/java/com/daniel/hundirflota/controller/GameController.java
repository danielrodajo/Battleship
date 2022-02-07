package com.daniel.hundirflota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.hundirflota.entity.Board;
import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.service.BoardService;

@RestController
@RequestMapping("/api/game")
public class GameController extends GlobalController {

	@Autowired private BoardService boardService;
    
    @GetMapping("/currentgames")
    public List<Board> getUserBoards() {
    	AppUser user = getAppUserDetails();
    	return boardService.getUserBoards(user);
    }
    
    
    
}
