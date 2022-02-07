package com.daniel.hundirflota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.Board;
import com.daniel.hundirflota.entity.User;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByUser(User user);
}
