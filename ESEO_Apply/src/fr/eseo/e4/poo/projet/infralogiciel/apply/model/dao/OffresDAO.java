package fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao;


import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.sql.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffresDAO {

	// Récupérer toutes les offres
    public List<Offres> getAllOffres() {
        List<Offres> offres = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Offres";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Offres offre = new Offres(
                    rs.getInt("id_offre"),
                    rs.getString("titre"),
                    rs.getString("description"),
                    rs.getString("entreprise"),
                    rs.getDate("date_publication")
                );
                offres.add(offre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offres;
    }

    // Ajouter une offre
    public static void ajouterOffre(Offres offre) {
        try (Connection connection = DataBaseConnection.getConnection()) {
        	 System.out.println("Entreprise avant insertion : " + offre.getEntreprise());
            String query = "INSERT INTO Offres (titre, description, entreprise, date_publication) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, offre.getTitre());
            stmt.setString(2, offre.getDescription());
            stmt.setString(3, offre.getEntreprise());
            stmt.setDate(4, new Date(offre.getDate_publication().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer une offre
    public void supprimerOffre(int id_offre) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "DELETE FROM Offres WHERE id_offre = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id_offre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour une offre
    public void mettreAJourOffre(Offres offre) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "UPDATE Offres SET titre = ?, description = ?, entreprise = ?, date_publication = ? WHERE id_offre = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, offre.getTitre());
            stmt.setString(2, offre.getDescription());
            stmt.setString(3, offre.getEntreprise());
            stmt.setDate(4, new Date(offre.getDate_publication().getTime()));
            stmt.setInt(5, offre.getId_offre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer une offre par ID
    public Offres getOffreById(int id_offre) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Offres WHERE id_offre = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id_offre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Offres(
                    rs.getInt("id_offre"),
                    rs.getString("titre"),
                    rs.getString("description"),
                    rs.getString("entreprise"),
                    rs.getDate("date_publication")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}