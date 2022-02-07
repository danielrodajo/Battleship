package com.daniel.hundirflota.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.hundirflota.entity.Board;
import com.daniel.hundirflota.entity.AppUser;
import com.daniel.hundirflota.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired private BoardRepository boardRepository;
	
	@Override
	public boolean initBoard() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Board> getUserBoards(AppUser user) {
		return boardRepository.findByUser(user);
	}

}
