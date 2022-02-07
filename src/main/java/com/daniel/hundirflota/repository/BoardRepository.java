package com.daniel.hundirflota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.Board;
import com.daniel.hundirflota.entity.AppUser;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByUser(AppUser user);
}
