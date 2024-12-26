package com.example.easyroom.repository;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findByTypeSalle(TypeSalle typeSalle);
    List<Salle> findByNombrePlacesSalleGreaterThanEqual(Integer nombrePlacesSalle);
    Salle findByNumeroSalle(Integer numeroSalle);
    boolean existsByNumeroSalle(Integer numeroSalle);
}
