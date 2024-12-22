package com.example.easyroom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String numero;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private Integer nombrePlaces;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeSalle type;

    // Constructeurs
    public Salle() {
    }

    public Salle(String numero, String nom, Integer nombrePlaces, TypeSalle type) {
        this.numero = numero;
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.type = type;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(Integer nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }
}