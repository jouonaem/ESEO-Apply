package fr.eseo.e4.poo.projet.infralogiciel.apply.view;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;

import java.util.List;
import java.util.Scanner;

public class OffresVue {

    private final OffresDAO offresDAO;

    public OffresVue(OffresDAO offresDAO) {
        this.offresDAO = offresDAO;
    }

    // Afficher toutes les offres
    public String afficherOffres() {
        List<Offres> offres = offresDAO.getAllOffres();
        StringBuilder sb = new StringBuilder();

        if (offres.isEmpty()) {
            sb.append("Aucune offre disponible.\n");
        } else {
            sb.append("\n--- Liste des Offres ---\n");
            for (Offres offre : offres) {
                sb.append("ID: ").append(offre.getId_offre()).append("\n")
                  .append("Titre: ").append(offre.getTitre()).append("\n")
                  .append("Description: ").append(offre.getDescription()).append("\n")
                  .append("Entreprise: ").append(offre.getEntreprise()).append("\n")
                  .append("Lieu: ").append(offre.getLieu()).append("\n")
                  .append("Date: ").append(offre.getDate_publication()).append("\n")
                  .append("------------------------\n");
            }
        }
        return sb.toString();
    }

    // Ajouter une offre via l'entrée utilisateur
    public void ajouterOffre() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Titre de l'offre : ");
			String titre = scanner.nextLine();

			System.out.print("Description de l'offre : ");
			String description = scanner.nextLine();

			System.out.print("Entreprise : ");
			String entreprise = scanner.nextLine();
			
			System.out.print("Lieu : ");
			String lieu = scanner.nextLine();

			System.out.print("Date de publication (YYYY-MM-DD) : ");
			String dateInput = scanner.nextLine();

			try {
			    java.util.Date datePublication = java.sql.Date.valueOf(dateInput);
			    Offres nouvelleOffre = new Offres(0, titre, description, entreprise, lieu, datePublication);
			    offresDAO.ajouterOffre(nouvelleOffre);
			    System.out.println("Offre ajoutée avec succès !");
			} catch (IllegalArgumentException e) {
			    System.err.println("Erreur : Date invalide !");
			}
			
		}
    }
 // Afficher un message
    public String afficherMessage(String message) {
        return message;
    }
}
