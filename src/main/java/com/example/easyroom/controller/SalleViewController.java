package com.example.easyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalleViewController {

    // Nouveau mapping pour éviter le conflit avec SalleController
    @GetMapping("/salles")
    public String getSallesPage() {
        return "salles"; // Retourne le fichier salles.html depuis le dossier templates
    }
}
