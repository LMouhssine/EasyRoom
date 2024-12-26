package com.example.easyroom.service.impl;

import com.example.easyroom.model.Admin;
import com.example.easyroom.repository.AdminRepository;
import com.example.easyroom.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin creerAdmin(Admin admin) {
        if (adminRepository.existsByEmailAdmin(admin.getEmailAdmin())) {
            throw new IllegalArgumentException("Un admin avec cet email existe déjà");
        }
        return adminRepository.save(admin);
    }

    @Override
    public Admin modifierAdmin(Long id, Admin admin) {
        Admin adminExistant = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin non trouvé avec l'id : " + id));

        adminExistant.setPrenomAdmin(admin.getPrenomAdmin());
        adminExistant.setNomAdmin(admin.getNomAdmin());
        adminExistant.setPermissionAdmin(admin.getPermissionAdmin());
        adminExistant.setEmailAdmin(admin.getEmailAdmin());
        adminExistant.setMotDePasseAdmin(admin.getMotDePasseAdmin());

        return adminRepository.save(adminExistant);
    }

    @Override
    public void supprimerAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new EntityNotFoundException("Admin non trouvé avec l'id : " + id);
        }
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdminParId(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin non trouvé avec l'id : " + id));
    }

    @Override
    public List<Admin> getTousLesAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminParEmail(String email) {
        return adminRepository.findByEmailAdmin(email);
    }

    @Override
    public List<Admin> rechercherAdmins(String recherche) {
        return adminRepository.findByNomAdminContainingOrPrenomAdminContainingOrEmailAdminContaining(
                recherche, recherche, recherche
        );
    }
}
