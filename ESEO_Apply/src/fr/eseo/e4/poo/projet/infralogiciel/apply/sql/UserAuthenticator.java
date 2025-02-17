package fr.eseo.e4.poo.projet.infralogiciel.apply.sql;

import java.sql.*;


import org.mindrot.jbcrypt.BCrypt;

public class UserAuthenticator {
	public boolean authenticateUser(String email, String password) {
        // Requête SQL pour récupérer les informations de l'utilisateur
        String query = "SELECT * FROM recruteurs WHERE email = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Remplir les paramètres de la requête
            stmt.setString(1, email);
           // stmt.setString(2, password);

            // Exécuter la requête
            ResultSet rs = stmt.executeQuery();
            
            // Vérifier si un utilisateur correspondant est trouvé
            if (rs.next()) {
            	 String hashStocke = rs.getString("mot_de_passe");
            	// Vérifier le format du hash
                 if (!hashStocke.startsWith("$2y$") && !hashStocke.startsWith("$2a$") && !hashStocke.startsWith("$2b$")) {
                     System.out.println("Le hash n'est pas au format BCrypt valide !");
                     return false;
                 }

                 // Vérifier la longueur du hash
                 if (hashStocke.length() != 60) {
                     System.out.println("Le hash n'a pas la bonne longueur !");
                     return false;
                 }

                 // Adapter le hash si nécessaire
                 hashStocke = hashStocke.replace("$2y$", "$2a$");

                 // Vérifier si le mot de passe saisi correspond au hash en base
                 if (BCrypt.checkpw(password, hashStocke)) {
                	 System.out.println("Connexion réussie pour l'utilisateur : " + email);
                     return true;
                 } else {
                	 System.out.println("Identifiants incorrects !");
                     return false;
                 }
            } else {
                System.out.println("Utilisateur Introuvable !");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'authentification : " + e.getMessage());
            return false;
        }
    }
}
