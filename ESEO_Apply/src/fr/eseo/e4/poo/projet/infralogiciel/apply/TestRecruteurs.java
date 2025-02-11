package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.RecruteursDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import java.util.List;

public class TestRecruteurs {

    public static void main(String[] args) {
        // Initialiser le DAO pour les recruteurs
        RecruteursDAO recruteursDAO = new RecruteursDAO();

        // 1. Ajouter un recruteur
        System.out.println("Ajout d'un recruteur...");
        // ID 0 est généralement utilisé pour une auto-incrémentation dans la base de données
        Recruteurs recruteur1 = new Recruteurs(0, "Dupont", "Jean", "jean.dupont@email.com", "password123", Type_utilisateur.ADMIN);
        recruteursDAO.ajouterRecruteur(recruteur1);
        System.out.println("Recruteur ajouté avec succès !");

        // 2. Afficher la liste des recruteurs
        System.out.println("\nListe des recruteurs :");
        List<Recruteurs> recruteursList = recruteursDAO.getAllRecruteurs();
        for (Recruteurs recruteur : recruteursList) {
            // Utilisation du bon getter pour l'ID (vérifiez si c'est 'id_recruteur' ou 'id_utilisateur' dans la classe)
            System.out.println("ID : " + recruteur.getId_utilisateur());
            System.out.println("Nom : " + recruteur.getNom());
            System.out.println("Prénom : " + recruteur.getPrenom());
            System.out.println("Email : " + recruteur.getEmail());
            System.out.println("Type : " + recruteur.getType_utilisateur());
            System.out.println("Numero de Telephone : " + recruteur.getType_utilisateur());
            System.out.println("----------------------------");
        }
    }
}