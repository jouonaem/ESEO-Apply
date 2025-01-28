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
    public void afficherOffres() {
        List<Offres> offres = offresDAO.getAllOffres();
        if (offres.isEmpty()) {
            System.out.println("Aucune offre disponible.");
        } else {
            System.out.println("\n--- Liste des Offres ---");
            for (Offres offre : offres) {
                System.out.println("ID: " + offre.getId_offre());
                System.out.println("Titre: " + offre.getTitre());
                System.out.println("Description: " + offre.getDescription());
                System.out.println("Entreprise: " + offre.getEntreprise());
                System.out.println("Date: " + offre.getDate_publication());
                System.out.println("------------------------");
            }
        }
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

			System.out.print("Date de publication (YYYY-MM-DD) : ");
			String dateInput = scanner.nextLine();

			try {
			    java.util.Date datePublication = java.sql.Date.valueOf(dateInput);
			    Offres nouvelleOffre = new Offres(0, titre, description, entreprise, datePublication);
			    offresDAO.ajouterOffre(nouvelleOffre);
			    System.out.println("Offre ajoutée avec succès !");
			} catch (IllegalArgumentException e) {
			    System.err.println("Erreur : Date invalide !");
			}
			
		}
    }
 // Afficher un message
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}
