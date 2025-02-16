package fr.eseo.e4.poo.projet.infralogiciel.apply.model;


import java.util.Date;

public class Offres {
	private int id_offre;
	private String titre;
	private String description;
	private String entreprise;
	private String lieu;
	private Date date_publication;

	public Offres(int id_offre, String titre, String description, String entreprise, String lieu, Date date_publication) {
		this.setId_offre(id_offre);
		this.setTitre(titre);
		this.setDescription(description);
		this.setEntreprise(entreprise);
		this.setLieu(lieu);
		this.setDate_publication(date_publication);

	}

	public int getId_offre() {
		return id_offre;
	}

	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Date getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
