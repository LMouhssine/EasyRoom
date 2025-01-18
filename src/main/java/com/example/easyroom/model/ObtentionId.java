package com.example.easyroom.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObtentionId implements Serializable {

    private int id_formation;
    private int id_etudiant;

    // Getters and Setters
    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObtentionId that = (ObtentionId) o;
        return id_formation == that.id_formation && id_etudiant == that.id_etudiant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_formation, id_etudiant);
    }
}