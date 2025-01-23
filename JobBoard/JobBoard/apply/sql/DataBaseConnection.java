package fr.eseo.e4.poo.projet.infralogiciel.apply.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/projet_eseo_apply";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	 public static void main(String[] args) {
	        try {
	            // Étape 1 : Charger le driver MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Étape 2 : Établir la connexion
	            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

	            // Étape 3 : Vérifier la connexion
	            if (connection != null) {
	                System.out.println("Connexion réussie à la base de données !");
	            } else {
	                System.out.println("La connexion a échoué !");
	            }

	            // Fermer la connexion
	            connection.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver MySQL non trouvé : " + e.getMessage());
	        } catch (SQLException e) {
	            System.out.println("Erreur SQL : " + e.getMessage());
	        }
	    }

}
