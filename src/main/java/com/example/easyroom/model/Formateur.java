package com.example.easyroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formateur")  // Assurer que le nom de la colonne est correct
    private Long idFormateur;

    @Column(name = "prenom_formateur", nullable = false)
    private String prenomFormateur;

    @Column(name = "nom_formateur", nullable = false)
    private String nomFormateur;

    @Column(name = "email_formateur", nullable = false)
    private String emailFormateur;

    @Column(name = "motDePasse_formateur", nullable = false)
    private String motDePasseFormateur;

    // Constructeur
    public Formateur() {
    }

    public Formateur(String prenomFormateur, String nomFormateur, String emailFormateur, String motDePasseFormateur) {
        this.prenomFormateur = prenomFormateur;
        this.nomFormateur = nomFormateur;
        this.emailFormateur = emailFormateur;
        this.motDePasseFormateur = motDePasseFormateur;
    }

    // Getters et setters
    public Long getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(Long idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getPrenomFormateur() {
        return prenomFormateur;
    }

    public void setPrenomFormateur(String prenomFormateur) {
        this.prenomFormateur = prenomFormateur;
    }

    public String getNomFormateur() {
        return nomFormateur;
    }

    public void setNomFormateur(String nomFormateur) {
        this.nomFormateur = nomFormateur;
    }

    public String getEmailFormateur() {
        return emailFormateur;
    }

    public void setEmailFormateur(String emailFormateur) {
        this.emailFormateur = emailFormateur;
    }

    public String getMotDePasseFormateur() {
        return motDePasseFormateur;
    }

    public void setMotDePasseFormateur(String motDePasseFormateur) {
        this.motDePasseFormateur = motDePasseFormateur;
    }
}
