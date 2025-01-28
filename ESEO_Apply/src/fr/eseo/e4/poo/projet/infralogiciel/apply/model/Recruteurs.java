package fr.eseo.e4.poo.projet.infralogiciel.apply.model;

public class Recruteurs extends Utilisateurs {

	public Recruteurs(int id_recruteur, String nom,String prenom, String email, String Mot_de_passe, Type_utilisateur type) {
        super(id_recruteur, nom,prenom, email, Mot_de_passe, Type_utilisateur.Admin);  // Utilisation de RECRUTEUR par défaut
    }

}