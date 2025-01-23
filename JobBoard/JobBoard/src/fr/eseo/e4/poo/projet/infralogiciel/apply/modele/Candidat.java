package fr.eseo.e4.poo.projet.infralogiciel.apply.modele;

public class Candidat extends Utilisateur{
	//Instanciation des variables
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private boolean statut;
	//private String cv; cette section est en commentaire car le CV est un PDF et peut nécessiter une conversion en chaîne de caractères
	//Ou alors peut être vu dirctement par l'entité "Recruteur" au travers de la partie font-end.
	
	//Constructeur
	public Candidat(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
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
