package com.blackcat.soundfolio.soundfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vibe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
