package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.StatutCandidature;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;
import java.util.Date;


public class TestCandidatureDAO {
	public static void main(String[] args) {
		// Initialiser le DAO
		CandidaturesDAO dao = new CandidaturesDAO();

		try {
			// Ajouter une nouvelle candidature
			System.out.println("Ajout d'une nouvelle candidature...");
			Candidatures nouvelleCandidature = new Candidatures(0,1,2,new Date(),StatutCandidature.ACCEPTEE// statut initial
					);
				
			dao.ajouterCandidature(nouvelleCandidature);
			System.out.println("Candidature ajoutée avec succès !");

	
			// Récupérer toutes les candidatures
			System.out.println("\nListe des candidatures :");
			dao.getAllCandidatures().forEach(candidature -> {
				System.out.println("ID: " + candidature.getId_candidature());
				System.out.println("Utilisateur: " + candidature.getId_utilisateur());
				System.out.println("Offre: " + candidature.getId_offre());
				System.out.println("Date: " + candidature.getDate_candidature());
				System.out.println("Statut: " + candidature.getStatut());
				System.out.println("-------------------");
			});
			
			

			// Mettre à jour le statut d'une candidature
			System.out.println("\nMise à jour du statut de la candidature avec ID 1...");
			dao.mettreAJourStatutCandidature(2, StatutCandidature.EN_COURS);
			System.out.println("Statut mis à jour avec succès !");
			
	
			
			// Supprimer une candidature
			System.out.println("\nSuppression de la candidature avec ID 24...");
			dao.supprimerCandidature(24);
			System.out.println("Candidature supprimée avec succès !");
			
			
			
		} catch (Exception e) {
			System.err.println("Une erreur s'est produite : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
   
}