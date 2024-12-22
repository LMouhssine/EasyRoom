package com.example.easyroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data  // Cette annotation Lombok génère automatiquement getters, setters, toString, etc.
@Entity  // Indique que c'est une entité JPA
@Table(name = "salle")  // Spécifie le nom de la table dans la base de données
public class Salle {
    
    @Id  // Indique que c'est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incrémentation
    private Long id;
    
    @Column(nullable = false)  // La colonne ne peut pas être null
    private String numero;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private Integer nombrePlaces;
    
    @Enumerated(EnumType.STRING)  // Stocke l'enum comme une chaîne dans la BD
    @Column(nullable = false)
    private TypeSalle type;
}
