package com.example.easyroom.model;

import jakarta.persistence.*;

@Entity
public class Obtention {

    @EmbeddedId
    private ObtentionId id;

    @ManyToOne
    @MapsId("id_formation")
    @JoinColumn(name = "id_formation")
    private Formation formation;

    @ManyToOne
    @MapsId("id_etudiant")
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    // Getters and Setters
    public ObtentionId getId() {
        return id;
    }

    public void setId(ObtentionId id) {
        this.id = id;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}