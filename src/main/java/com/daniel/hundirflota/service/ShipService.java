package com.daniel.hundirflota.service;

import com.daniel.hundirflota.entity.Coordinates;

public interface ShipService {

	boolean hit();
	boolean isAlive();
	Coordinates getPosition();
	
}
