package fr.eseo.e4.poo.projet.infralogiciel.apply;

import java.util.Date;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;

public class TestOffresDAO {
	 public static void main(String[] args) {
	
	// Initialiser le DAO pour les offres
				OffresDAO offreDAO = new OffresDAO();
				// Ajouter une nouvelle offre
				System.out.println("\nAjout d'une nouvelle offre...");
				Offres nouvelleOffre = new Offres(0, "Alternance en programmation", "java, python ,c", "choco enterprise", new Date());
				
				offreDAO.ajouterOffre(nouvelleOffre);
				System.out.println("Offre ajoutée avec succès");
				
				// Récupérer toutes les offres
				System.out.println("\nListe des offres :");
				offreDAO.getAllOffres().forEach(offre -> {
					System.out.println("ID: " + offre.getId_offre());
					System.out.println("Titre: " + offre.getTitre());
					System.out.println("Description: "+ offre.getDescription());
					System.out.println("Entreprise: " + offre.getEntreprise());
					System.out.println("Date: " +offre.getDate_publication());
				});
				
				//Mettre à jour une offre
				System.out.println("\nMise à jour une offre avec ID 1...");
				offreDAO.mettreAJourOffre(nouvelleOffre);
				System.out.println("offre mis à jour avec succès");
				
				//Supprimer une offre
				System.out.println("\nSuppression de l'offre avec ID 1...");
				offreDAO.supprimerOffre(1);
				System.out.println("offre supprimée avec succès !");
				



	 }
}
