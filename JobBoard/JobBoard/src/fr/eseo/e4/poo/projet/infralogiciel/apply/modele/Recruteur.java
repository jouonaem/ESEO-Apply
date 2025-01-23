package fr.eseo.e4.poo.projet.infralogiciel.apply.modele;

public class Recruteur extends Utilisateur{
	//Instanciation des variables
	private String nom;
	private String prenom;
	private String email;
	private String entreprise;
	
	public Recruteur(String nom, String prenom, String entreprise) {
		this.nom = nom;
		this.prenom = prenom;
		this.entreprise = entreprise;
	}
	
	//Getters et Setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
	//Méthodes
	
	public boolean SelectionnerCandidature(boolean s) {
		return false;
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMotDePasse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfMotDePasse() {
		// TODO Auto-generated method stub
		return null;
	}
}
