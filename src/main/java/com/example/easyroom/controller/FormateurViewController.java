package com.example.easyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormateurViewController {

    // Endpoint pour afficher la page de gestion des formateurs
    @GetMapping("/formateurs")
    public String afficherFormateurs() {
        return "formateurs";  // Le nom de votre fichier HTML dans "src/main/resources/templates"
    }
}
