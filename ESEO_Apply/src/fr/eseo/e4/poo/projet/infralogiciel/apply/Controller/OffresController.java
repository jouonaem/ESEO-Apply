package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;
import java.util.Date;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.OffresVue;

public class OffresController {
	private OffresDAO offresdao;
	private OffresVue offrevue;
	
	public OffresController(OffresVue offrevue) {
		this.offrevue=offrevue;
		this.offresdao = new OffresDAO();
	}

	// Méthode pour ajouter une offre
	
	public void  ajouterOffres(String titre, String description, String entreprise, Date date_publication) {
		try {
			
			// creer une offre
			
			Offres offre = new Offres(9, "CDI en communication", "verification et validation", "Rice and stew", new Date());
			
			// ajouter l'offre via le modele
			
			OffresDAO.ajouterOffre(offre);
			
			// Afficher le message que l'offre a été ajoutée avec succès via la vue
			
			offrevue.afficherMessage("Offre ajoutée avec succès !");
		} catch (Exception e) {
			
			// Afficher un message d'erreur via la vue
			
			offrevue.afficherMessage("Erreur lors de l'ajour de l'offre : " + e.getMessage());
		}
	}
	 // Méthode pour afficher toutes les offres
    public void afficherOffres() {
    	try {
    		
    		// récuperer les toutes les offres depuis le modèle
    		var offres = offresdao.getAllOffres();
    		
    		// Demander à la vue d'afficher toutes les offres
    		
    		offrevue.afficherOffres();
    		
    	}
    	
    	catch (Exception e) {
		
		// Afficher un message d'erreur via la vue
		
		offrevue.afficherMessage("Erreur lors de l'affichage des l'offre : " + e.getMessage());
    	}
    	
    	
    }
	
  
}