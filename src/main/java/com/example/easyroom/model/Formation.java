package com.example.easyroom.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_formation;

    private String nom_formation;
    private Date dateDebut_formation;
    private Date dateFin_formation;

    @ManyToOne
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;

    // Getters and Setters
    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public Date getDateDebut_formation() {
        return dateDebut_formation;
    }

    public void setDateDebut_formation(Date dateDebut_formation) {
        this.dateDebut_formation = dateDebut_formation;
    }

    public Date getDateFin_formation() {
        return dateFin_formation;
    }

    public void setDateFin_formation(Date dateFin_formation) {
        this.dateFin_formation = dateFin_formation;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
}