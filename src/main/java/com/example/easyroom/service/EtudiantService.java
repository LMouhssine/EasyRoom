package com.example.easyroom.service;

import com.example.easyroom.model.Etudiant;
import java.util.List;

public interface EtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(int id);
    boolean deleteEtudiant(int id);
}