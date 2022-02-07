package com.daniel.hundirflota.service;

import java.util.List;

import com.daniel.hundirflota.entity.Board;
import com.daniel.hundirflota.entity.User;

public interface BoardService {

	boolean initBoard();
	List<Board> getUserBoards(User user);
	
}
