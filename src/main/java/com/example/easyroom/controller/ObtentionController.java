package com.example.easyroom.controller;

import com.example.easyroom.model.Obtention;
import com.example.easyroom.service.ObtentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obtentions")
public class ObtentionController {

    @Autowired
    private ObtentionService obtentionService;

    /**
     * Crée une nouvelle obtention (relation entre une formation et un étudiant).
     *
     * @param obtention Les données de l'obtention à créer.
     * @return L'obtention créée avec le statut HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Obtention> createObtention(@RequestBody Obtention obtention) {
        Obtention savedObtention = obtentionService.saveObtention(obtention);
        return new ResponseEntity<>(savedObtention, HttpStatus.CREATED);
    }

    /**
     * Supprime une obtention (relation entre une formation et un étudiant).
     *
     * @param idFormation L'ID de la formation.
     * @param idEtudiant  L'ID de l'étudiant.
     * @return Le statut HTTP 204 (No Content) si la suppression est réussie.
     */
    @DeleteMapping("/{idFormation}/{idEtudiant}")
    public ResponseEntity<Void> deleteObtention(@PathVariable int idFormation, @PathVariable int idEtudiant) {
        obtentionService.deleteObtention(idFormation, idEtudiant);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}