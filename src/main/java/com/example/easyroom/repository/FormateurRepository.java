package com.example.easyroom.repository;
import com.example.easyroom.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    Formateur findByEmailFormateur(String email);
    boolean existsByEmailFormateur(String email);
    List<Formateur> findByNomFormateurContainingOrPrenomFormateurContaining(String nom, String prenom);
}