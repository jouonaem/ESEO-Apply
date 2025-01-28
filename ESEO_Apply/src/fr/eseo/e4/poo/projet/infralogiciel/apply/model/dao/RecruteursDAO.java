package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import fr.eseo.e4.poo.projet.infralogiciel.apply.sql.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecruteursDAO {

    // Ajouter un recruteur
    public void ajouterRecruteur(Recruteurs recruteur) {
        String query = "INSERT INTO Recruteurs (nom, prenom, email, mot_de_passe, type_utilisateur) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, recruteur.getNom());
            stmt.setString(2, recruteur.getPrenom()); // Prenom ajouté pour cohérence
            stmt.setString(3, recruteur.getEmail());
            stmt.setString(4, recruteur.getMot_de_passe());
            stmt.setString(5, recruteur.getType_utilisateur().name());
            stmt.executeUpdate();
            System.out.println("Recruteur ajouté avec succès.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Erreur : Cet email existe déjà dans la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du recruteur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Récupérer tous les recruteurs
    public List<Recruteurs> getAllRecruteurs() {
        List<Recruteurs> recruteursList = new ArrayList<>();
        String query = "SELECT * FROM Recruteurs";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                try {
                    // Conversion sécurisée avec Enum.valueOf
                    Type_utilisateur typeUtilisateur = Type_utilisateur.valueOf(rs.getString("type_utilisateur"));

                    Recruteurs recruteur = new Recruteurs(
                            rs.getInt("id_recruteur"),
                            rs.getString("nom"),
                            rs.getString("prenom"), // Assurez-vous que ce champ existe dans la table
                            rs.getString("email"),
                            rs.getString("mot_de_passe"),
                            typeUtilisateur
                    );
                    recruteursList.add(recruteur);
                } catch (IllegalArgumentException e) {
                    System.err.println("Erreur : Type_utilisateur invalide dans la base de données.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des recruteurs : " + e.getMessage());
            e.printStackTrace();
        }

        return recruteursList;
    }
}