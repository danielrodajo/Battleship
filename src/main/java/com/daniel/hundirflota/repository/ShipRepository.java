package com.daniel.hundirflota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.hundirflota.entity.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long> {

}
