package com.example.easyroom.model;

import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_etudiant;

    private String prenom_etudiant;
    private String nom_etudiant;
    private String email_etudiant;
    private String motDePasse_etudiant;

    // Getters and Setters
    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public String getEmail_etudiant() {
        return email_etudiant;
    }

    public void setEmail_etudiant(String email_etudiant) {
        this.email_etudiant = email_etudiant;
    }

    public String getMotDePasse_etudiant() {
        return motDePasse_etudiant;
    }

    public void setMotDePasse_etudiant(String motDePasse_etudiant) {
        this.motDePasse_etudiant = motDePasse_etudiant;
    }
}