package fr.eseo.e4.poo.projet.infralogiciel.apply.model;

public class Etudiants extends Utilisateurs  {

	public Etudiants(int id_etudiant,String nom , String prenom,String email, String password,  Type_utilisateur type) {
		super(id_etudiant,nom,prenom, email, password, type);
		
	}

}
