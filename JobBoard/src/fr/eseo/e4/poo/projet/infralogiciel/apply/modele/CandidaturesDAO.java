package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.StatutCandidature;
import com.eseo.backend.mvc.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidaturesDAO {

    // Récupérer toutes les candidatures
    public List<Candidatures> getAllCandidatures() {
        List<Candidatures> candidatures = new ArrayList<>();
        String query = "SELECT * FROM Candidatures";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Candidatures candidature = new Candidatures(
                    rs.getInt("id_candidature"),
                    rs.getInt("id_utilisateur"),
                    rs.getInt("id_offre"),
                    rs.getDate("date_candidature"),
                    StatutCandidature.valueOf(rs.getString("statut"))
                );
                candidatures.add(candidature);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des candidatures : " + e.getMessage());
            e.printStackTrace();
        }

        return candidatures;
    }

 // Ajouter une candidature
    public void ajouterCandidature(Candidatures candidature) {
        String query = "INSERT INTO Candidatures (id_utilisateur, id_offre, date_candidature, statut) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, candidature.getId_utilisateur());
            stmt.setInt(2, candidature.getId_offre());

            if (candidature.getDate_candidature() == null) {
                throw new NullPointerException("La date de candidature (date_candidature) est null.");
            }
            stmt.setDate(3, new Date(candidature.getDate_candidature().getTime()));

            stmt.setString(4, candidature.getStatut().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la candidature : " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    // Supprimer une candidature
    public void supprimerCandidature(int id_candidature) {
        String query = "DELETE FROM Candidatures WHERE id_candidature = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id_candidature);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la candidature : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Mettre à jour le statut d'une candidature
    public void mettreAJourStatutCandidature(int id_candidature, StatutCandidature statut) {
        String query = "UPDATE Candidatures SET statut = ? WHERE id_candidature = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, statut.name());
            stmt.setInt(2, id_candidature);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du statut de la candidature : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Récupérer une candidature par ID
    public Candidatures getCandidatureById(int id_candidature) {
        String query = "SELECT * FROM Candidatures WHERE id_candidature = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id_candidature);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Candidatures(
                    rs.getInt("id_candidature"),
                    rs.getInt("id_utilisateur"),
                    rs.getInt("id_offre"),
                    rs.getDate("date_candidature"),
                    StatutCandidature.valueOf(rs.getString("statut"))
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la candidature : " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}