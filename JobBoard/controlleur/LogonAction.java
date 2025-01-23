package fr.eseo.e4.poo.projet.infralogiciel.apply.controlleur;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.e4.poo.projet.infralogiciel.apply.vue.LogonDialog;
import fr.eseo.e4.poo.projet.infralogiciel.apply.vue.UserData;


public class LogonAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogonDialog logonDialog;
	private UserData userData;
	
	public LogonAction(LogonDialog logonDialog, UserData userData) {          
		this.logonDialog = logonDialog;
		this.userData = userData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nomUtilisateur = logonDialog.getNomUtilisateur();
		String motDePasse = logonDialog.getMotDePasse();
		
		if(nomUtilisateur.equals(userData.getUsername()) && motDePasse.equals(userData.getPassword())) {
			String message = "L'utilisateur "+nomUtilisateur+" est connecté";
			JOptionPane.showMessageDialog((Component)logonDialog, message);
		}
		else if(nomUtilisateur.isBlank() || motDePasse.isBlank()) {
			String error = "Un des champs est vide ou contient des espaces";
			JOptionPane.showMessageDialog((Component)logonDialog, error);
		}
		else {
			String error1 = "Nom d'utilisateur ou mot de passe incorrect";
			JOptionPane.showMessageDialog((Component)logonDialog, error1);
		}
		
		
	}
}
