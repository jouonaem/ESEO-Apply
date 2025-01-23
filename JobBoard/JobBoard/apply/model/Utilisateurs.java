package fr.eseo.e4.poo.projet.infralogiciel.apply.model;


public abstract class Utilisateurs {
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String Mot_de_passe;
    private Type_utilisateur type_utilisateur; // Utilisation de l'énumération Type_utilisateur

    public Utilisateurs(int id_utilisateur,String nom,String prenom, String email, String Mot_de_passe, Type_utilisateur type_utilisateur) {
        this.id_utilisateur = id_utilisateur;
        this.nom=nom;
        this.prenom=prenom;
        this.email = email;
        this.Mot_de_passe = Mot_de_passe;
        this.type_utilisateur = type_utilisateur;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return Mot_de_passe;
    }

    public void setMot_de_passe(String Mot_de_passe) {
        this.Mot_de_passe = Mot_de_passe;
    }

    public Type_utilisateur getType_utilisateur() {
        return type_utilisateur;
    }

    public void setType_utilisateur(Type_utilisateur type_utilisateur) {
        this.type_utilisateur = type_utilisateur;
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
	
	
}	   