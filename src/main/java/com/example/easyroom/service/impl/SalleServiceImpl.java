package com.example.easyroom.service.impl;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import com.example.easyroom.repository.SalleRepository;
import com.example.easyroom.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    @Autowired
    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public Salle creerSalle(Salle salle) {
        if (salleRepository.existsByNumero(salle.getNumero())) {
            throw new IllegalArgumentException("Une salle avec ce numéro existe déjà");
        }
        return salleRepository.save(salle);
    }

    @Override
    public Salle modifierSalle(Long id, Salle salle) {
        Salle salleExistante = salleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Salle non trouvée avec l'id : " + id));
        
        salleExistante.setNom(salle.getNom());
        salleExistante.setNumero(salle.getNumero());
        salleExistante.setNombrePlaces(salle.getNombrePlaces());
        salleExistante.setType(salle.getType());
        
        return salleRepository.save(salleExistante);
    }

    @Override
    public void supprimerSalle(Long id) {
        if (!salleRepository.existsById(id)) {
            throw new EntityNotFoundException("Salle non trouvée avec l'id : " + id);
        }
        salleRepository.deleteById(id);
    }

    @Override
    public Salle getSalleParId(Long id) {
        return salleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Salle non trouvée avec l'id : " + id));
    }

    @Override
    public List<Salle> getToutesSalles() {
        return salleRepository.findAll();
    }

    @Override
    public List<Salle> getSallesParType(TypeSalle type) {
        return salleRepository.findByType(type);
    }

    @Override
    public List<Salle> getSallesParCapaciteMinimum(Integer nombrePlaces) {
        return salleRepository.findByNombrePlacesGreaterThanEqual(nombrePlaces);
    }
}
