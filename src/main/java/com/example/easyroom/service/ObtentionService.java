package com.example.easyroom.service;

import com.example.easyroom.model.Obtention;

public interface ObtentionService {

    // Save an Obtention
    Obtention saveObtention(Obtention obtention);

    // Delete an Obtention by ID
    void deleteObtention(int idFormation, int idEtudiant); // Only one declaration here
}
