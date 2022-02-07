package com.daniel.hundirflota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
