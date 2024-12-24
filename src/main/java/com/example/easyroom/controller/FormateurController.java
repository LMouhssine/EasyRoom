package com.example.easyroom.controller;

import com.example.easyroom.model.Formateur;
import com.example.easyroom.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs") // URL de base pour le contrôleur des formateurs
public class FormateurController {

    private final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    // Endpoint pour créer un nouveau formateur
    @PostMapping
    public ResponseEntity<Formateur> creerFormateur(@RequestBody Formateur formateur) {
        Formateur nouveauFormateur = formateurService.creerFormateur(formateur);
        return ResponseEntity.ok(nouveauFormateur);
    }

    // Endpoint pour obtenir tous les formateurs
    @GetMapping
    public ResponseEntity<List<Formateur>> getTousLesFormateurs() {
        List<Formateur> formateurs = formateurService.getTousLesFormateurs();
        return ResponseEntity.ok(formateurs);
    }

    // Endpoint pour obtenir un formateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurParId(@PathVariable Long id) {
        Formateur formateur = formateurService.getFormateurParId(id);
        return ResponseEntity.ok(formateur);
    }

    // Endpoint pour modifier un formateur existant
    @PutMapping("/{id}")
    public ResponseEntity<Formateur> modifierFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        Formateur formateurModifie = formateurService.modifierFormateur(id, formateur);
        return ResponseEntity.ok(formateurModifie);
    }

    // Endpoint pour supprimer un formateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFormateur(@PathVariable Long id) {
        formateurService.supprimerFormateur(id);
        return ResponseEntity.ok().build();
    }
}
