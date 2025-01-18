package com.example.easyroom.service.impl;

import com.example.easyroom.model.Etudiant;
import com.example.easyroom.repository.EtudiantRepository;
import com.example.easyroom.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(int id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.orElse(null);  // Retourne null si l'étudiant n'est pas trouvé
    }

    @Override
    public boolean deleteEtudiant(int id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
            return true;  // Suppression réussie
        } else {
            return false;  // Étudiant non trouvé
        }
    }
}