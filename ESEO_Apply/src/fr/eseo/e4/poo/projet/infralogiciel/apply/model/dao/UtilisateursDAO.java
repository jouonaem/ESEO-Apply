package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.sql.DataBaseConnection;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Etudiants;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Recruteurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;

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
                String typeStr = rs.getString("type_utilisateur");
                Type_utilisateur type = Type_utilisateur.valueOf(typeStr.toUpperCase());
                Utilisateurs utilisateur;

                if (type == Type_utilisateur.ETUDIANT) {
                    utilisateur = new Etudiants(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("Mot_de_passe"),
                        type
                    );
                } else if (type == Type_utilisateur.ADMIN) {  // Correction ici : RECRUTEUR au lieu d'Admin
                    utilisateur = new Recruteurs(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),  // Ajout du nom ici
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("Mot_de_passe"),
                       type
                    );
                } else {
                    // Si le type n'est pas reconnu, on passe à l'utilisateur suivant
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
            String query = "INSERT INTO Utilisateurs (id_utilisateur, nom,prenom, email, Mot_de_passe, type_utilisateur) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, utilisateur.getId_utilisateur());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getEmail());
            stmt.setString(5, utilisateur.getMot_de_passe());
            stmt.setString(6, utilisateur.getType_utilisateur().name());  // Utiliser name() pour convertir l'énumération en String   //la méthode toString() ne marche pas?
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un utilisateur
    public void supprimerUtilisateur(int id_utilisateur) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "DELETE FROM Utilisateurs WHERE id_utilisateur = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id_utilisateur);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un utilisateur
    public void mettreAJourUtilisateur(Utilisateurs utilisateur) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "UPDATE Utilisateurs SET nom = ?,prenom = ?, email = ?, Mot_de_passe = ?, type_utilisateur = ? WHERE id_utilisateur = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getEmail());
            stmt.setString(3, utilisateur.getMot_de_passe());
            stmt.setString(4, utilisateur.getType_utilisateur().name());
            stmt.setInt(5, utilisateur.getId_utilisateur());  // Correction de l'index ici
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
