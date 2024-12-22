package com.example.easyroom.service;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import java.util.List;

public interface SalleService {
    Salle creerSalle(Salle salle);
    Salle modifierSalle(Long id, Salle salle);
    void supprimerSalle(Long id);
    Salle getSalleParId(Long id);
    List<Salle> getToutesSalles();
    List<Salle> getSallesParType(TypeSalle type);
    List<Salle> getSallesParCapaciteMinimum(Integer nombrePlaces);
}
