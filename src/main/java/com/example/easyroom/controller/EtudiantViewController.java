package com.example.easyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EtudiantViewController {

    // Endpoint pour afficher la page de gestion des étudiants
    @GetMapping("/etudiants")
    public String afficherEtudiants() {
        return "etudiants";  // Retourne le nom du template Thymeleaf (etudiants.html)
    }
}