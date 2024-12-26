package com.example.easyroom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idAdmin;
    
    @Column(name = "prenom_admin", nullable = false)
    private String prenomAdmin;
    
    @Column(name = "nom_admin", nullable = false)
    private String nomAdmin;
    
    @Column(name = "permission_admin", nullable = false)
    private String permissionAdmin;
    
    @Column(name = "email_admin", nullable = false)
    private String emailAdmin;
    
    @Column(name = "motDePasse_admin", nullable = false)
    private String motDePasseAdmin;
    
    // Constructeurs
    public Admin() {}
    
    public Admin(String prenomAdmin, String nomAdmin, String permissionAdmin, String emailAdmin, String motDePasseAdmin) {
        this.prenomAdmin = prenomAdmin;
        this.nomAdmin = nomAdmin;
        this.permissionAdmin = permissionAdmin;
        this.emailAdmin = emailAdmin;
        this.motDePasseAdmin = motDePasseAdmin;
    }
    
    // Getters et Setters
    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPermissionAdmin() {
        return permissionAdmin;
    }

    public void setPermissionAdmin(String permissionAdmin) {
        this.permissionAdmin = permissionAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getMotDePasseAdmin() {
        return motDePasseAdmin;
    }

    public void setMotDePasseAdmin(String motDePasseAdmin) {
        this.motDePasseAdmin = motDePasseAdmin;
    }
}