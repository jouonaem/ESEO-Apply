package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.EtudiantsDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.EtudiantsVue;

import java.util.List;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

public class EtudiantsController {
EtudiantsVue etudvue = new EtudiantsVue();
	
	public void EtudiantsController(EtudiantsVue etudvue) {
		this.etudvue = etudvue;
	}
	
	// Crée et ajouter un nouvel étudiant
	
	public void ajouterEtudiant(int id_etudiant,String nom , String prenom,String email, String password,  Type_utilisateur type) {
		try {
			Etudiants etudiant = new Etudiants(id_etudiant, nom, prenom, email, password, type);
			
			// ajouter l'étudiant
			
			EtudiantsDAO etudiantsDAO = new EtudiantsDAO(); //Suggestion Eclipse
			etudiantsDAO.ajouterEtudiant(etudiant);
			
			// afficher un message que l'etudiant a bien été crée
			
			etudvue.afficherMessage("L'étudiant a été crée avec succès!");
			
		}catch (Exception e) {
			
			// Afficher un message d'erreur via la vue
			
			etudvue.afficherMessage("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
		}
		
	}
	// Méthode pour afficher toutes les étudiants
    public void afficherEtudiants() {
    	try {
    		
    		// Récupérer la liste des étudiants via le modèle
            List<Etudiants> etudiants = EtudiantsDAO.getAllEtudiants();
            
    		// Demander à la vue d'afficher toutes les offres
    		
    		etudvue.afficherEtudiants(etudiants);
    		
    	}
    	
    	catch (Exception e) {
		
		// Afficher un message d'erreur via la vue
		
		etudvue.afficherMessage("Erreur lors de l'affichage des étudiants: " + e.getMessage());
    	}
    	
    	
    }
}
