package com.example.easyroom.service;

import com.example.easyroom.model.Admin;
import java.util.List;

public interface AdminService {
    Admin creerAdmin(Admin admin);
    List<Admin> getTousLesAdmins();
    Admin getAdminParId(Long id);
    Admin modifierAdmin(Long id, Admin admin);
    void supprimerAdmin(Long id);
    Admin getAdminParEmail(String email);
    List<Admin> rechercherAdmins(String recherche);
}
