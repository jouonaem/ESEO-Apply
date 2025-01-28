package fr.eseo.e4.poo.projet.infralogiciel.apply.view;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import java.util.List;

public class UtilisateurVue {

    // Méthode pour afficher un utilisateur
    public void afficherUtilisateur(Utilisateurs utilisateur) {
        System.out.println("ID Utilisateur: " + utilisateur.getId_utilisateur());
        System.out.println("Email: " + utilisateur.getEmail());
        
        // Vérifier le type d'utilisateur pour afficher des informations spécifiques
        
        if (utilisateur.getType_utilisateur() == Type_utilisateur.ETUDIANT) {
            System.out.println("Type: Étudiant");
            
            // Affichez ici des informations supplémentaires spécifiques aux étudiants si nécessaire
        } 
        else if (utilisateur.getType_utilisateur() == Type_utilisateur.Admin) {
            System.out.println("Type: Recruteur");
            // Affichez ici des informations supplémentaires spécifiques aux recruteurs si nécessaire
        } else {
            System.out.println("Type: Inconnu");
        }

        System.out.println("Mot de passe: " + utilisateur.getMot_de_passe());
        System.out.println("-------------------------");
    }

    // Méthode pour afficher la liste d'utilisateurs
    public void afficherListeUtilisateurs(List<Utilisateurs> utilisateurs) {
        for (Utilisateurs utilisateur : utilisateurs) {
            afficherUtilisateur(utilisateur); // Appel de la méthode afficherUtilisateur pour chaque utilisateur
        }
    }
}
