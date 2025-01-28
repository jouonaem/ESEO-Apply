package fr.eseo.e4.poo.projet.infralogiciel.apply.view;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;

import java.util.List;

public class EtudiantsVue {

    // Afficher la liste des étudiants
    public void afficherEtudiants(List<Etudiants> etudiants) {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé.");
        } else {
            for (Etudiants etudiant : etudiants) {
                System.out.println("ID: " + etudiant.getId_utilisateur() +
                        ", Nom: " + etudiant.getNom() +
                        ", Email: " + etudiant.getEmail() +
                        ", Type: " + etudiant.getType_utilisateur());
            }
        }
    }

    // Afficher un message
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}