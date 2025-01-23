package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.EtudiantsDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

import java.util.List;

public class TestEtudiantsDAO {

    public static void main(String[] args) {
        // Création d'un objet EtudiantsDAO
        EtudiantsDAO etudiantsDAO = new EtudiantsDAO();

        // Test de l'ajout d'un étudiant
        Etudiants etudiant = new Etudiants(0, "John Doe", "Kim", "john.doe@example.com", "password123",  Type_utilisateur.ETUDIANT);
        etudiantsDAO.ajouterEtudiant(etudiant);
        System.out.println("Étudiant ajouté avec succès.");

        // Test de la récupération de tous les étudiants
        List<Etudiants> etudiantsList = etudiantsDAO.getAllEtudiants();
        System.out.println("Liste des étudiants : ");
        for (Etudiants e : etudiantsList) {
            System.out.println("ID: " + e.getId_utilisateur() +
                               ", Nom: " + e.getNom() +
                               ", Prenom: " + e.getPrenom() +
                               ", Email: " + e.getEmail());
                               
            	
        }

        // Test de la récupération d'un étudiant par ID
        if (!etudiantsList.isEmpty()) {
            Etudiants etudiantById = etudiantsDAO.getEtudiantById(etudiantsList.get(0).getId_utilisateur());
            if (etudiantById != null) {
                System.out.println("Étudiant récupéré par ID: ");
                System.out.println("ID: " + etudiantById.getId_utilisateur() +
                                   ", Nom: " + etudiantById.getNom() +
                                   ", Prenom: " + etudiantById.getPrenom() +
                                   ", Email: " + etudiantById.getEmail());
           
            } else {
                System.out.println("Aucun étudiant trouvé avec cet ID.");
            }
        } else {
            System.out.println("La liste des étudiants est vide. Aucun étudiant à récupérer par ID.");
        }

        /* Test de la suppression d'un étudiant
        if (!etudiantsList.isEmpty()) {
            int idEtudiantASupprimer = etudiantsList.get(0).getId_utilisateur();
            etudiantsDAO.supprimerEtudiant(idEtudiantASupprimer);
            System.out.println("Étudiant supprimé avec succès.");
        }*/
    }
}