package com.example.easyroom.model;
import jakarta.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_salle")
   private Long idSalle;
   
   @Column(name = "nom_salle", nullable = false)
   private String nomSalle;
   
   @Column(name = "numero_salle", nullable = false)
   private Integer numeroSalle;
   
   @Enumerated(EnumType.STRING)
   @Column(name = "type_salle", nullable = false)
   private TypeSalle typeSalle;
   
   @Column(name = "nombrePlaces_salle", nullable = false)
   private Integer nombrePlacesSalle;
   
   @ManyToOne
   @JoinColumn(name = "id_admin")
   private Admin admin;

   // Constructeurs
   public Salle() {}
   
   public Salle(String nomSalle, Integer numeroSalle, TypeSalle typeSalle, Integer nombrePlacesSalle, Admin admin) {
       this.nomSalle = nomSalle;
       this.numeroSalle = numeroSalle;
       this.typeSalle = typeSalle;
       this.nombrePlacesSalle = nombrePlacesSalle;
       this.admin = admin;
   }

   // Getters et Setters
   public Long getIdSalle() { return idSalle; }
   public void setIdSalle(Long idSalle) { this.idSalle = idSalle; }
   
   public String getNomSalle() { return nomSalle; }
   public void setNomSalle(String nomSalle) { this.nomSalle = nomSalle; }
   
   public Integer getNumeroSalle() { return numeroSalle; }
   public void setNumeroSalle(Integer numeroSalle) { this.numeroSalle = numeroSalle; }
   
   public TypeSalle getTypeSalle() { return typeSalle; }
   public void setTypeSalle(TypeSalle typeSalle) { this.typeSalle = typeSalle; }
   
   public Integer getNombrePlacesSalle() { return nombrePlacesSalle; }
   public void setNombrePlacesSalle(Integer nombrePlacesSalle) { this.nombrePlacesSalle = nombrePlacesSalle; }
   
   public Admin getAdmin() { return admin; }
   public void setAdmin(Admin admin) { this.admin = admin; }
}