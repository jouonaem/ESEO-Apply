package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;

import fr.eseo.e4.poo.projet.infralogiciel.apply.view.RecruteursVue;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.RecruteursDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

public class RecruteursController {
RecruteursVue recrutvue = new RecruteursVue();
	
	public void RecruteursController(RecruteursVue recrutvue) {
		this.recrutvue=recrutvue;
	}
	
	// Crée et ajouter un recruteur
	
	public void ajouterRecruteur(int id_recruteur, String nom,String prenom, String email, String Mot_de_passe, Type_utilisateur type) {
		try {
			// Crée le recruteur
			Recruteurs recruteur = new Recruteurs(id_recruteur, nom, prenom, email, Mot_de_passe, type);
			
			// ajouter le recruteur
			
			RecruteursDAO recruteursDAO = new RecruteursDAO(); //Eclipse suggestion
			recruteursDAO.ajouterRecruteur(recruteur);
			
			// afficher un message que le recruteur à été ajouter avec succès à la vue
			
			recrutvue.afficherMessage("Le recruteurs à été ajouté avec succès !");
			
		}catch (Exception e){
			
			recrutvue.afficherMessage("Erreur lors de l'ajout du recruteur: " +e.getMessage());
		}
		
		
	}
	// Méthode pour afficher toutes les étudiants
    public void afficherEtudiants() {
    	try {
    		
    		recrutvue.afficherRecruteurs();
    		
    	}
    	
    	catch (Exception e) {
		
		// Afficher un message d'erreur via la vue
		
		recrutvue.afficherMessage("Erreur lors de l'affichage des recruteurs: " + e.getMessage());
    	}
    }
}
