package com.daniel.hundirflota.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Board boardA;
    
    private Board boardB;
    
    
    private User winner;
	
}
