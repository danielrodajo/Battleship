package com.daniel.hundirflota.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Invitation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private User transmitter;
	
	private User receiver;
    
    private Instant issuedAt;
    
    private Boolean accepted;
}
