package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import fr.eseo.e4.poo.projet.infralogiciel.apply.sql.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantsDAO {

    // Vérifier si un email existe déjà dans la base de données
    private boolean emailExiste(String email) {
        String query = "SELECT COUNT(*) FROM Etudiants WHERE email = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retourne true si un email existe
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification de l'email : " + e.getMessage());
        }
        return false;
    }

    // Ajouter un étudiant
    public void ajouterEtudiant(Etudiants etudiant) {
        if (emailExiste(etudiant.getEmail())) {
            System.err.println("Erreur : Cet email existe déjà dans la base de données.");
            return;
        }

        String query = "INSERT INTO Etudiants (nom, prenom, email, Mot_de_passe,numero, type_utilisateur) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, etudiant.getNom());
            stmt.setString(2, etudiant.getPrenom());
            stmt.setString(3, etudiant.getEmail());
            stmt.setString(4, etudiant.getMot_de_passe());
            stmt.setString(5, etudiant.getType_utilisateur().name());


            stmt.executeUpdate();
            System.out.println("Étudiant ajouté avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'étudiant : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Récupérer tous les étudiants
    public List<Etudiants> getAllEtudiants() {
        List<Etudiants> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiants";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Etudiants etudiant = new Etudiants(
                    rs.getInt("id_etudiant"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("Mot_de_passe"),
                    Type_utilisateur.valueOf(rs.getString("type_utilisateur"))
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des étudiants : " + e.getMessage());
            e.printStackTrace();
        }

        return etudiants;
    }

    // Récupérer un étudiant par ID
    public Etudiants getEtudiantById(int idEtudiant) {
        String query = "SELECT * FROM Etudiants WHERE id_etudiant = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, idEtudiant);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Etudiants(
                    rs.getInt("id_etudiant"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("Mot_de_passe"),
                    Type_utilisateur.valueOf(rs.getString("type_utilisateur"))
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'étudiant : " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // Supprimer un étudiant
    public void supprimerEtudiant(int idEtudiant) {
        String query = "DELETE FROM Etudiants WHERE id_etudiant = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, idEtudiant);
            stmt.executeUpdate();
            System.out.println("Étudiant supprimé avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'étudiant : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
