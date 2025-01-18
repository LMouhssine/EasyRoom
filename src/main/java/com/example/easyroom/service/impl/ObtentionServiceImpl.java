package com.example.easyroom.service.impl;

import com.example.easyroom.model.Obtention;
import com.example.easyroom.model.ObtentionId;
import com.example.easyroom.repository.ObtentionRepository;
import com.example.easyroom.service.ObtentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtentionServiceImpl implements ObtentionService {

    @Autowired
    private ObtentionRepository obtentionRepository;

    @Override
    public Obtention saveObtention(Obtention obtention) {
        return obtentionRepository.save(obtention);
    }

    @Override
    public void deleteObtention(int idFormation, int idEtudiant) {
        ObtentionId id = new ObtentionId();
        id.setId_formation(idFormation);
        id.setId_etudiant(idEtudiant);
        obtentionRepository.deleteById(id);
    }
}