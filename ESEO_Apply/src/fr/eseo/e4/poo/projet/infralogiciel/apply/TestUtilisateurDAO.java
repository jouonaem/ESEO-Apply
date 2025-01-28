package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.UtilisateursDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;



import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

public class TestUtilisateurDAO {
    public static void main(String[] args) {
        UtilisateursDAO utilisateurDAO = new UtilisateursDAO();

        // Ajouter un utilisateur
        Utilisateurs utilisateur = new Etudiants(1,"emm","boy", "choco.emmanuel@gmail.com","boy1234", Type_utilisateur.ETUDIANT);
        utilisateurDAO.ajouterUtilisateur(utilisateur);
        System.out.println("Utilisateur ajouté avec succès !");

        // Mettre à jour un utilisateur(
        utilisateur.setEmail("kwegueng.emmanuel@gmail.com");
        utilisateur.setMot_de_passe("chocoboy1234");
        utilisateurDAO.mettreAJourUtilisateur(utilisateur);
        System.out.println("Utilisateur mis à jour avec succès !");
    }
}