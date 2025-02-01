package fr.eseo.e4.poo.projet.infralogiciel.apply.model;

import java.util.Date;

public class Candidatures {
    private int id_candidature;
    private int id_utilisateur;
    private int id_offre;
    private Date date_candidature; // Utilise le même nom partout
    private StatutCandidature statut;

    public Candidatures(int id_candidature, int id_utilisateur, int id_offre, Date date_candidature, StatutCandidature statut) {
        if (date_candidature == null) {      //Pourquoi la création d'un objet date? On aurait pu effectuer un test sur l'id de la candidature plutôt non?
            throw new IllegalArgumentException("La date de candidature ne peut pas être null.");
        }
        this.id_candidature = id_candidature;
        this.id_utilisateur = id_utilisateur;
        this.id_offre = id_offre;
        this.date_candidature = date_candidature;
        this.statut = statut;
    }

    public int getId_candidature() {
        return id_candidature;
    }

    public void setId_candidature(int id_candidature) {
        this.id_candidature = id_candidature;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public Date getDate_candidature() {
        return date_candidature;
    }

    public void setDate_candidature(Date date_candidature) {
        if (date_candidature == null) {
            throw new IllegalArgumentException("La date de candidature ne peut pas être null.");
        }
        this.date_candidature = date_candidature;
    }

    public StatutCandidature getStatut() {
        return statut;
    }

    public void setStatut(StatutCandidature statut) {
        this.statut = statut;
    }
}
