package com.example.easyroom.controller;

import com.example.easyroom.model.Etudiant;
import com.example.easyroom.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    /**
     * Crée un nouvel étudiant.
     *
     * @param etudiant Les données de l'étudiant à créer.
     * @return L'étudiant créé avec le statut HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.saveEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    /**
     * Récupère tous les étudiants.
     *
     * @return Une liste de tous les étudiants avec le statut HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    /**
     * Récupère un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à récupérer.
     * @return L'étudiant correspondant avec le statut HTTP 200 (OK).
     *         Si l'étudiant n'est pas trouvé, retourne le statut HTTP 404 (Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable int id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Supprime un étudiant par son ID.
     *
     * @param id L'ID de l'étudiant à supprimer.
     * @return Le statut HTTP 204 (No Content) si la suppression est réussie.
     *         Si l'étudiant n'est pas trouvé, retourne le statut HTTP 404 (Not Found).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable int id) {
        boolean isDeleted = etudiantService.deleteEtudiant(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}