package fr.eseo.e4.poo.projet.infralogiciel.apply.modele;
import java.awt.Color;

public enum Couleur {
	BLEU(java.awt.Color.BLUE),
	ROUGE(java.awt.Color.RED);
	
	private final Color couleurPourAffichage;
	
	private Couleur(Color couleurPourAffichage) {
		this.couleurPourAffichage = couleurPourAffichage;
	}

	public Color getCouleurPourAffichage() {
		return couleurPourAffichage;
	}
}
