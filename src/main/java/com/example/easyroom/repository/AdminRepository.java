package com.example.easyroom.repository;

import com.example.easyroom.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmailAdmin(String emailAdmin);
    Admin findByEmailAdmin(String emailAdmin);
    List<Admin> findByNomAdminContainingOrPrenomAdminContainingOrEmailAdminContaining(String nom, String prenom, String email);
}
