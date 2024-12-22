package com.example.easyroom.repository;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    // Méthodes de recherche personnalisées
    List<Salle> findByType(TypeSalle type);
    List<Salle> findByNombrePlacesGreaterThanEqual(Integer nombrePlaces);
    Salle findByNumero(String numero);
    boolean existsByNumero(String numero);
}