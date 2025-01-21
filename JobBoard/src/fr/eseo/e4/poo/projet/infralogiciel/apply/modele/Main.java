package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.StatutCandidature;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// Initialiser le DAO
		CandidaturesDAO dao = new CandidaturesDAO();

		try {
			// Ajouter une nouvelle candidature
			System.out.println("Ajout d'une nouvelle candidature...");
			Candidatures nouvelleCandidature = new Candidatures(0, // id_candidature : sera ignoré car auto-incrémenté
																	// dans la base
					1, // id_utilisateur
					2, // id_offre
					new Date(), // date_candidature : initialisée à la date actuelle
					StatutCandidature.EN_COURS // statut initial
			);
			dao.ajouterCandidature(nouvelleCandidature);
			System.out.println("Candidature ajoutée avec succès !");

			// Initialiser le DAO pour les offres
			OffresDAO offreDAO = new OffresDAO();

			// Ajouter une nouvelle offre
			System.out.println("\nAjout d'une nouvelle offre...");
			Offres nouvelleOffre = new Offres(0, "Stage en dev web", "java, python ,c", "choco enterprise", new Date());
			offreDAO.ajouterOffre(nouvelleOffre);
			System.out.println("Offre ajoutée avec succès");

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
			dao.mettreAJourStatutCandidature(1, StatutCandidature.ACCEPTEE);
			System.out.println("Statut mis à jour avec succès !");

			// Supprimer une candidature
			System.out.println("\nSuppression de la candidature avec ID 1...");
			dao.supprimerCandidature(1);
			System.out.println("Candidature supprimée avec succès !");
		} catch (Exception e) {
			System.err.println("Une erreur s'est produite : " + e.getMessage());
			e.printStackTrace();
		}
	}
}