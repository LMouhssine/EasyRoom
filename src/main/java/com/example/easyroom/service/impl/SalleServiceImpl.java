package com.example.easyroom.service.impl;

import com.example.easyroom.model.Salle;
import com.example.easyroom.model.TypeSalle;
import com.example.easyroom.repository.SalleRepository;
import com.example.easyroom.service.SalleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    @Autowired
    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public Salle creerSalle(Salle salle) {
        if (salleRepository.existsByNumeroSalle(salle.getNumeroSalle())) {
            throw new IllegalArgumentException("Une salle avec ce numéro existe déjà");
        }
        return salleRepository.save(salle);
    }

    @Override
    public Salle modifierSalle(Long id, Salle salle) {
        Salle salleExistante = salleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salle non trouvée avec l'id : " + id));

        salleExistante.setNomSalle(salle.getNomSalle());
        salleExistante.setNumeroSalle(salle.getNumeroSalle());
        salleExistante.setTypeSalle(salle.getTypeSalle());
        salleExistante.setNombrePlacesSalle(salle.getNombrePlacesSalle());

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
    public List<Salle> getToutesLesSalles() {
        return salleRepository.findAll();
    }

    @Override
    public List<Salle> getSallesParType(TypeSalle typeSalle) {
        return salleRepository.findByTypeSalle(typeSalle);
    }
}
