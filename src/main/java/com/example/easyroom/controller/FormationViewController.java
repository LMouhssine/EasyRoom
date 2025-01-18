package com.example.easyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormationViewController {

    // Endpoint pour afficher la page de gestion des formations
    @GetMapping("/formations")
    public String afficherFormations() {
        return "formations";  // Retourne le nom du template Thymeleaf (formations.html)
    }
}