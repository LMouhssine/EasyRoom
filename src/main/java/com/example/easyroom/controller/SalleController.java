package com.example.easyroom.controller;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import com.example.easyroom.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleController {

    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping
    public Salle creerSalle(@RequestBody Salle salle) {
        return salleService.creerSalle(salle);
    }

    @PutMapping("/{id}")
    public Salle modifierSalle(@PathVariable Long id, @RequestBody Salle salle) {
        return salleService.modifierSalle(id, salle);
    }

    @DeleteMapping("/{id}")
    public void supprimerSalle(@PathVariable Long id) {
        salleService.supprimerSalle(id);
    }

    @GetMapping("/{id}")
    public Salle getSalleParId(@PathVariable Long id) {
        return salleService.getSalleParId(id);
    }

    @GetMapping
    public List<Salle> getToutesLesSalles() {
        return salleService.getToutesLesSalles();
    }

    @GetMapping("/type")
    public List<Salle> getSallesParType(@RequestParam TypeSalle typeSalle) {
        return salleService.getSallesParType(typeSalle);
    }
}
