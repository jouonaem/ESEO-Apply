package fr.eseo.e4.poo.projet.infralogiciel.apply.view;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.RecruteursDAO;
import java.util.List;
import java.util.Scanner;

public class RecruteursVue {

    private static final Scanner scanner = new Scanner(System.in);
    private final RecruteursDAO recruteursDAO;

    public RecruteursVue() {
        this.recruteursDAO = new RecruteursDAO();
    }

    // Afficher la liste des recruteurs
    public void afficherRecruteurs() {
        List<Recruteurs> recruteursList = recruteursDAO.getAllRecruteurs();
        if (recruteursList.isEmpty()) {
            System.out.println("Aucun recruteur trouvé.");
        } else {
            System.out.println("Liste des recruteurs :");
            for (Recruteurs recruteur : recruteursList) {
                System.out.println("ID : " + recruteur.getId_utilisateur());
                System.out.println("Nom : " + recruteur.getNom());
                System.out.println("Prenom : " + recruteur.getPrenom());
                System.out.println("Email : " + recruteur.getEmail());
                System.out.println("Type : " + recruteur.getType_utilisateur());
                System.out.println("-------------------------");
            }
        }
    }

    // Ajouter un recruteur
    public void ajouterRecruteur() {
        System.out.println("Ajout d'un nouveau recruteur :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prenom : ");
        String prenom =  scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        System.out.print("Numero de Telephone: ");

        Recruteurs recruteur = new Recruteurs(0, nom,prenom, email, motDePasse, Type_utilisateur.ADMIN);
        recruteursDAO.ajouterRecruteur(recruteur);
        System.out.println("Recruteur ajouté avec succès !");
    }

    /* Supprimer un recruteur
    public void supprimerRecruteur() {
        System.out.print("Entrez l'ID du recruteur à supprimer : ");
        int idRecruteur = scanner.nextInt();
        scanner.nextLine();  // Consommer le retour à la ligne

        recruteursDAO.supprimerRecruteur(idRecruteur);
        System.out.println("Recruteur supprimé avec succès !");
    }*/

    /*Mettre à jour un recruteur
    public void mettreAJourRecruteur() {
        System.out.print("Entrez l'ID du recruteur à mettre à jour : ");
        int idRecruteur = scanner.nextInt();
        scanner.nextLine();  // Consommer le retour à la ligne

        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();
        System.out.print("Nouveau email : ");
        String email = scanner.nextLine();
        System.out.print("Nouveau mot de passe : ");
        String motDePasse = scanner.nextLine();

        Recruteurs recruteur = new Recruteurs(idRecruteur, nom, email, motDePasse, Type_utilisateur.Admin);
        recruteursDAO.mettreAJourRecruteur(recruteur);
        System.out.println("Recruteur mis à jour avec succès !");
    }*/

       
 }
