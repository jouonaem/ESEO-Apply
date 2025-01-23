package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import com.eseo.backend.mvc.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateursDAO {

    // Récupérer tous les utilisateurs
    public List<Utilisateurs> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Utilisateurs";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Instancier l'utilisateur en fonction de son type
                String type = rs.getString("type");
                Utilisateurs utilisateur;

                if ("Étudiant".equalsIgnoreCase(type)) {
                    utilisateur = new Etudiants(
                        rs.getInt("id_etudiant"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
                    );
                } else if ("Recruteur".equalsIgnoreCase(type)) {
                    utilisateur = new Recruteurs(
                        rs.getInt("id_etudiant"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
                    );
                } else {
                    // Si le type n'est pas reconnu, passe à l'utilisateur suivant
                    continue;
                }

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    // Ajouter un utilisateur
    public void ajouterUtilisateur(Utilisateurs utilisateur) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "INSERT INTO Utilisateurs (id_etudiant, email, password, type) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, utilisateur.getId_etudiant());
            stmt.setString(2, utilisateur.getEmail());
            stmt.setString(3, utilisateur.getPassword());
            stmt.setString(4, utilisateur.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un utilisateur
    public void supprimerUtilisateur(int id_etudiant) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "DELETE FROM Utilisateurs WHERE id_etudiant = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id_etudiant);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un utilisateur
    public void mettreAJourUtilisateur(Utilisateurs utilisateur) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "UPDATE Utilisateurs SET email = ?, password = ?, type = ? WHERE id_etudiant = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, utilisateur.getEmail());
            stmt.setString(2, utilisateur.getPassword());
            stmt.setString(3, utilisateur.getType());
            stmt.setInt(4, utilisateur.getId_etudiant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}