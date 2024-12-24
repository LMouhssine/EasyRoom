package com.example.easyroom.controller;

// Importations nécessaires
import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import com.example.easyroom.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Les annotations qui définissent ce contrôleur REST
@RestController                 // Indique que c'est un contrôleur REST
@RequestMapping("/api/salles")  // Définit l'URL de base pour toutes les méthodes
public class SalleController {

    // Injection du service
    private final SalleService salleService;

    @Autowired  // Injection de dépendance automatique
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    // Endpoint pour créer une nouvelle salle
    @PostMapping
    public ResponseEntity<Salle> creerSalle(@RequestBody Salle salle) {
        Salle nouvelleSalle = salleService.creerSalle(salle);
        return ResponseEntity.ok(nouvelleSalle);
    }

    // Endpoint pour obtenir toutes les salles
    @GetMapping
    public ResponseEntity<List<Salle>> getToutesSalles() {
        List<Salle> salles = salleService.getToutesSalles();
        return ResponseEntity.ok(salles);
    }

    // Endpoint pour obtenir une salle par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleParId(@PathVariable Long id) {
        Salle salle = salleService.getSalleParId(id);
        return ResponseEntity.ok(salle);
    }

    // Endpoint pour modifier une salle existante
    @PutMapping("/{id}")
    public ResponseEntity<Salle> modifierSalle(@PathVariable Long id, @RequestBody Salle salle) {
        Salle salleModifiee = salleService.modifierSalle(id, salle);
        return ResponseEntity.ok(salleModifiee);
    }

    // Endpoint pour supprimer une salle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerSalle(@PathVariable Long id) {
        salleService.supprimerSalle(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour obtenir les salles par type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Salle>> getSallesParType(@PathVariable TypeSalle type) {
        List<Salle> salles = salleService.getSallesParType(type);
        return ResponseEntity.ok(salles);
    }

    // Endpoint pour obtenir les salles par capacité minimum
    @GetMapping("/capacite/{places}")
    public ResponseEntity<List<Salle>> getSallesParCapacite(@PathVariable Integer places) {
        List<Salle> salles = salleService.getSallesParCapaciteMinimum(places);
        return ResponseEntity.ok(salles);
    }
}