package fr.eseo.e4.poo.projet.infralogiciel.apply;
	import java.awt.*;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	import fr.eseo.e4.poo.projet.infralogiciel.apply.sql.UserAuthenticator;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;


	public class Main {
		public static void main(String[] args) {
			// Création de la fenêtre principale
	        JFrame frame = new JFrame("ESEO-Apply");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 250);
	        frame.setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

	        // Création du panel principal
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridBagLayout()); 
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les éléments

	        // Ajout du titre
	        JLabel titleLabel = new JLabel("Connexion");
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.gridwidth = 2; // Étendre sur deux colonnes
	        panel.add(titleLabel, gbc);

	        // Label et champ pour Identifiant
	        gbc.gridwidth = 1;
	        gbc.gridy = 1;
	        gbc.gridx = 0;
	        panel.add(new JLabel("Identifiant :"), gbc);

	        gbc.gridx = 1;
	        JTextField identifiantField = new JTextField(15);
	        panel.add(identifiantField, gbc);

	        // Label et champ pour Mot de passe
	        gbc.gridy = 2;
	        gbc.gridx = 0;
	        panel.add(new JLabel("Mot de passe :"), gbc);

	        gbc.gridx = 1;
	        JPasswordField passwordField = new JPasswordField(15);
	        panel.add(passwordField, gbc);

	        // Bouton de connexion
	        gbc.gridy = 3;
	        gbc.gridx = 0;
	        gbc.gridwidth = 2;
	        JButton loginButton = new JButton("Se connecter");
	        panel.add(loginButton, gbc);
	        
	        // Action du bouton de connexion
	        loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = identifiantField.getText();
	                String password = new String(passwordField.getPassword());

	                // Authentifier l'utilisateur
	                UserAuthenticator authenticator = new UserAuthenticator();
	                if (authenticator.authenticateUser(username, password)) {
	                    //JOptionPane.showMessageDialog(frame, "Connexion réussie !");
	                    // Rediriger vers la page suivante
	                     frame.setVisible(false); // Cache la fenêtre de connexion
	                     new MainGUI().setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Identifiants incorrects, réessayez.");
	                }
	            }
	        });

	        // Ajout du panel à la fenêtre
	        frame.add(panel);
	        frame.setVisible(true);
	    }
}



