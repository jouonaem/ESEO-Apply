package fr.eseo.e4.poo.projet.infralogiciel.apply.controlleur;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.e4.poo.projet.infralogiciel.apply.vue.LogonDialogRec;
import fr.eseo.e4.poo.projet.infralogiciel.apply.vue.UserData;

public class LogonActionRec extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogonDialogRec logonDialogRec;
	private UserData userData;
	
	public LogonActionRec(LogonDialogRec logonDialogRec, UserData userData) {          
		this.logonDialogRec = logonDialogRec;
		this.userData = userData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nomUtilisateur = logonDialogRec.getNomUtilisateur();
		String motDePasse = logonDialogRec.getMotDePasse();
		String entreprise = logonDialogRec.getEntreprise();
		
		if(nomUtilisateur.equals(userData.getUsername()) && motDePasse.equals(userData.getPassword())) {
			String message = "L'utilisateur "+nomUtilisateur+" est connecté";
			JOptionPane.showMessageDialog((Component)logonDialogRec, message);
		}
		else if(nomUtilisateur.isBlank() || motDePasse.isBlank()) {
			String error = "Le mot de passe est vide ou contient des espaces";
			JOptionPane.showMessageDialog((Component)logonDialogRec, error);
		}
		else if(entreprise.isBlank()) {
			String error1 = "Veuillez remplir le champ Entreprise";
			JOptionPane.showMessageDialog((Component)logonDialogRec, error1);
		}
		else {
			String error2 = "Nom d'utilisateur ou mot de passe incorrect";
			JOptionPane.showMessageDialog((Component)logonDialogRec, error2);
		}
	}
	
}
