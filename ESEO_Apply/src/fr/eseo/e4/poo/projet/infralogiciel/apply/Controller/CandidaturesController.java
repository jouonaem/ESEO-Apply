package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;

import java.util.Date;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.StatutCandidature;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.CandidatureVue;

public class CandidaturesController {
	private CandidatureVue canditvue;
	private CandidaturesDAO candidaturedao;
	
	
	public CandidaturesController(CandidatureVue canditvue) {
		this.canditvue=canditvue;
		this.candidaturedao = new CandidaturesDAO();
	}
	
	// Crée et ajouter une candidature 
	
	// ici on va d'abord crée l'offre
	
	public void ajouterCandidature(int id_candidature, int id_utilisateur, int id_offre, Date date_candidature, StatutCandidature statut) {
		try {
			Candidatures candidature = new Candidatures (1,1,1,date_candidature,statut);
			
			// ajouter la candidature créée
			
			CandidaturesDAO candidaturesDAO = new CandidaturesDAO(); //Modification suggérée par Eclipse
			candidaturesDAO.ajouterCandidature(candidature);
			
			// afficher un message que la candidature a bien été créée 
			
			canditvue.afficherMessage("candidture créée avec succès");
			
		}catch (Exception e) {
			
			// Afficher un message d'erreur via la vue
			
			canditvue.afficherMessage("Erreur lors de l'ajour de l'offre : " + e.getMessage());
		}
		
	}

	public void afficherCandidatures() {
		// TODO Auto-generated method stub
		try {
			var candidatures = candidaturedao.getAllCandidatures();
			canditvue.afficherCandidatures();
		}
		catch(Exception e) {
			canditvue.afficherMessage("Erreur lors de l'affichage des candidatures" + e.getMessage());
		}
	}

	public void postuler(int idCandidat, int idOffre) {
		// TODO Auto-generated method stub
		
	}

}
