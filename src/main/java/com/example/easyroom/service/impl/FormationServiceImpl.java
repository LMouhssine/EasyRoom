package com.example.easyroom.service.impl;

import com.example.easyroom.model.Formation;
import com.example.easyroom.repository.FormationRepository;
import com.example.easyroom.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(int id) {
        Optional<Formation> formation = formationRepository.findById(id);
        return formation.orElse(null);  // Retourne null si la formation n'est pas trouvée
    }

    @Override
    public boolean deleteFormation(int id) {
        if (formationRepository.existsById(id)) {
            formationRepository.deleteById(id);
            return true;  // Suppression réussie
        } else {
            return false;  // Formation non trouvée
        }
    }
}