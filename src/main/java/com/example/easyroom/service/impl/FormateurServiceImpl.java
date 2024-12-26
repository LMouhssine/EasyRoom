package com.example.easyroom.service.impl;
import com.example.easyroom.model.Formateur;
import com.example.easyroom.repository.FormateurRepository;
import com.example.easyroom.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FormateurServiceImpl implements FormateurService {
    private final FormateurRepository formateurRepository;

    @Autowired
    public FormateurServiceImpl(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    @Override
    public Formateur creerFormateur(Formateur formateur) {
        if (formateurRepository.existsByEmailFormateur(formateur.getEmailFormateur())) {
            throw new IllegalArgumentException("Un formateur avec cet email existe déjà");
        }
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> getTousLesFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur getFormateurParId(Long id) {
        return formateurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Formateur non trouvé avec l'id : " + id));
    }

    @Override
    public Formateur modifierFormateur(Long id, Formateur formateur) {
        Formateur formateurExist = formateurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Formateur non trouvé avec l'id : " + id));
        
        formateurExist.setPrenomFormateur(formateur.getPrenomFormateur());
        formateurExist.setNomFormateur(formateur.getNomFormateur());
        formateurExist.setEmailFormateur(formateur.getEmailFormateur());
        formateurExist.setMotDePasseFormateur(formateur.getMotDePasseFormateur());
        
        return formateurRepository.save(formateurExist);
    }

    @Override
    public void supprimerFormateur(Long id) {
        if (!formateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Formateur non trouvé avec l'id : " + id);
        }
        formateurRepository.deleteById(id);
    }

    @Override
    public Formateur getFormateurParEmail(String email) {
        return formateurRepository.findByEmailFormateur(email);
    }

    @Override
    public List<Formateur> rechercherFormateurs(String recherche) {
        return formateurRepository.findByNomFormateurContainingOrPrenomFormateurContaining(recherche, recherche);
    }
}