package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.UtilisateursDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.UtilisateurVue;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

import java.util.List;

public class UtilisateursController {
	 private UtilisateurVue utilisateurVue;
	    private UtilisateursDAO utilisateursDAO;

	    public UtilisateursController(UtilisateurVue utilisateurVue) {
	        this.utilisateurVue = utilisateurVue;
	        this.utilisateursDAO = new UtilisateursDAO(); // Initialiser le DAO
	    }

	    // Méthode pour ajouter un étudiant
	    public void ajouterEtudiant(int id_utilisateur, String nom, String prenom, String email, String password) {
	        try {
	            Utilisateurs utilisateur = new Etudiants(id_utilisateur, nom, prenom, email, password, Type_utilisateur.ETUDIANT);
	            utilisateursDAO.ajouterUtilisateur(utilisateur);
	            utilisateurVue.afficherMessage("L'étudiant a été créé avec succès !");
	        } catch (Exception e) {
	            utilisateurVue.afficherMessage("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
	        }
	    }

	    // Méthode pour ajouter un recruteur
	    public void ajouterRecruteur(int id_utilisateur, String nom, String prenom, String email, String password) {
	        try {
	            Utilisateurs utilisateur = new Recruteurs(id_utilisateur, nom, prenom, email, password, Type_utilisateur.ADMIN);
	            utilisateursDAO.ajouterUtilisateur(utilisateur);
	            utilisateurVue.afficherMessage("Le recruteur a été créé avec succès !");
	        } catch (Exception e) {
	            utilisateurVue.afficherMessage("Erreur lors de l'ajout du recruteur : " + e.getMessage());
	        }
	    }

	    // Méthode pour afficher tous les utilisateurs
	    public void afficherUtilisateurs() {
	        try {
	            List<Utilisateurs> utilisateurs = utilisateursDAO.getAllUtilisateurs();
	            utilisateurVue.afficherListeUtilisateurs(utilisateurs);
	        } catch (Exception e) {
	            utilisateurVue.afficherMessage("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
	        }
	    }

	    // Méthode pour supprimer un utilisateur
	    public void supprimerUtilisateur(int id_utilisateur) {
	        try {
	            utilisateursDAO.supprimerUtilisateur(id_utilisateur);
	            utilisateurVue.afficherMessage("L'utilisateur a été supprimé avec succès !");
	        } catch (Exception e) {
	            utilisateurVue.afficherMessage("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
	        }
	    }

	    // Méthode pour mettre à jour un utilisateur
	    public void mettreAJourUtilisateur(Utilisateurs utilisateur) {
	        try {
	            utilisateursDAO.mettreAJourUtilisateur(utilisateur);
	            utilisateurVue.afficherMessage("L'utilisateur a été mis à jour avec succès !");
	        } catch (Exception e) {
	            utilisateurVue.afficherMessage("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
	        }
	    } 
}
