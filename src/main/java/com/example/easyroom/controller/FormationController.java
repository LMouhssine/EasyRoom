package com.example.easyroom.controller;

import com.example.easyroom.model.Formation;
import com.example.easyroom.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

    /**
     * Crée une nouvelle formation.
     *
     * @param formation Les données de la formation à créer.
     * @return La formation créée avec le statut HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
        Formation savedFormation = formationService.saveFormation(formation);
        return new ResponseEntity<>(savedFormation, HttpStatus.CREATED);
    }

    /**
     * Met à jour une formation existante.
     *
     * @param id        L'ID de la formation à mettre à jour.
     * @param formation Les nouvelles données de la formation.
     * @return La formation mise à jour avec le statut HTTP 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable int id, @RequestBody Formation formation) {
        formation.setId_formation(id);  // Assurez-vous que l'ID est correctement défini
        Formation updatedFormation = formationService.saveFormation(formation);
        return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
    }

    /**
     * Récupère toutes les formations.
     *
     * @return Une liste de toutes les formations avec le statut HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    /**
     * Récupère une formation par son ID.
     *
     * @param id L'ID de la formation à récupérer.
     * @return La formation correspondante avec le statut HTTP 200 (OK).
     *         Si la formation n'est pas trouvée, retourne le statut HTTP 404 (Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable int id) {
        Formation formation = formationService.getFormationById(id);
        if (formation != null) {
            return new ResponseEntity<>(formation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Supprime une formation par son ID.
     *
     * @param id L'ID de la formation à supprimer.
     * @return Le statut HTTP 204 (No Content) si la suppression est réussie.
     *         Si la formation n'est pas trouvée, retourne le statut HTTP 404 (Not Found).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable int id) {
        boolean isDeleted = formationService.deleteFormation(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}