package fr.eseo.e4.poo.projet.infralogiciel.apply.vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eseo.e4.poo.projet.infralogiciel.apply.controlleur.LogonActionRec;

public class LogonDialogRec extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLogon;
	private JTextField txtNomUtilisateur;
	private JPasswordField txtMotDePasse;
	private JLabel lblNomUtilisateur;
	private JLabel lblMotDePasse;
	private JLabel lblUniqueId;
	private JLabel txtUniqueId;
	private JLabel lblEntreprise;
	private JTextField txtEntreprise;
	private static UserData userData;
	
	public LogonDialogRec(UserData userData) {
		//Configuration du gestionnaire de répartition
		setLayout(new GridLayout(5,2));
		this.userData = userData;
		
		//Création des composants
		lblUniqueId = new JLabel("Identifiant Unique: ");
		txtUniqueId = new JLabel(userData.getUniqueId());
		lblNomUtilisateur = new JLabel("Nom d'Utilisateur:");
		txtNomUtilisateur = new JTextField();
		lblEntreprise = new JLabel("Entreprise");
		txtEntreprise = new JTextField();
		lblMotDePasse = new JLabel("Mot de passe:");
		txtMotDePasse = new JPasswordField();
		btnLogon = new JButton("Connexion");
		
		//ajout de composants à l'interface graphique
		this.add(lblUniqueId);
		this.add(txtUniqueId);
		this.add(lblNomUtilisateur);
		this.add(txtNomUtilisateur);
		this.add(lblEntreprise);
		this.add(txtEntreprise);
		this.add(lblMotDePasse);
		this.add(txtMotDePasse);
		this.add(btnLogon);
		
		
		//Ajout du bouton au ActionListener
		btnLogon.addActionListener(new LogonActionRec(this, userData));  
	}
	
	public String getNomUtilisateur() {
		return txtNomUtilisateur.getText();
	}
	
	public String getMotDePasse() {
		return new String(txtMotDePasse.getPassword());
	}
	public String getEntreprise() {
		return txtEntreprise.getText();
	}
	
	public static void main(String[] args) {
		
	}
}
