package com.example.easyroom.service;

import com.example.easyroom.model.Formation;
import java.util.List;

public interface FormationService {
    Formation saveFormation(Formation formation);
    List<Formation> getAllFormations();
    Formation getFormationById(int id);
    boolean deleteFormation(int id);
}