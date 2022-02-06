package com.daniel.hundirflota.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
class Coordinates{
    int x;
    int y;
}

@Entity
@Data
@NoArgsConstructor
public class Ship {
    
    public enum ShipType {
        CARRIER,BATTLESHIP,CRUISER,SUBMARINE,DESTROYER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="resourceType")
    private ShipType shipType;
    
    private short lives;

    @Embedded
    private Coordinates coordinates;

}
