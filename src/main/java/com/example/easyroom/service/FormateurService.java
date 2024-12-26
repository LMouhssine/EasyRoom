package com.example.easyroom.service;
import com.example.easyroom.model.Formateur;
import java.util.List;
public interface FormateurService {
   Formateur creerFormateur(Formateur formateur);
   List<Formateur> getTousLesFormateurs();
   Formateur getFormateurParId(Long id);
   Formateur modifierFormateur(Long id, Formateur formateur);
   void supprimerFormateur(Long id);
   Formateur getFormateurParEmail(String email);
   List<Formateur> rechercherFormateurs(String recherche);
}