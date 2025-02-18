package fr.eseo.e4.poo.projet.infralogiciel.apply.view;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;

import java.util.List;
import java.util.Scanner;


public class CandidatureVue {
	
	private CandidaturesDAO candidaturesDAO = new CandidaturesDAO();

	public CandidatureVue(CandidaturesDAO candidaturesDAO) {
        this.candidaturesDAO = candidaturesDAO;
    }
	
	 // Afficher toutes les candidatures
    public String afficherCandidatures() {
        List<Candidatures> candidatures = candidaturesDAO.getAllCandidatures();
        StringBuilder sb = new StringBuilder();
        if (candidatures.isEmpty()) {
            sb.append("Aucune candidature disponible");
        } else {
        	sb.append("\n--- Liste des Candidatures ---\n");

            for (Candidatures candidature : candidatures) {
                sb.append("ID_candidature: ").append(candidature.getId_candidature()).append("\n")
                  .append("ID_utilisateur: ").append(candidature.getId_utilisateur()).append("\n")
                  .append("ID_offre: ").append(candidature.getId_offre()).append("\n")
                  .append("Date: ").append(candidature.getDate_candidature()).append("\n")
                  .append("Statut: ").append(candidature.getStatut()).append("\n")
                  .append("Nom: ").append(candidature.getNom()).append("\n")
                  .append("Prenom: ").append(candidature.getPrenom()).append("\n")
                  .append("------------------------\n");
            }
        }
        return sb.toString();
    }
    
    // Afficher une candidature spécifique
    
    public void afficherCandidatureSpecifique(Candidatures candidature) {
    	if(candidature == null) {
    		System.out.println("cette candidature n'éxiste pas");
    	}
    	else {
    		System.out.println("Détails de la candidature :");
            System.out.println("ID Candidature : " + candidature.getId_candidature());
            System.out.println("ID Utilisateur : " + candidature.getId_utilisateur());
            System.out.println("ID Offre : " + candidature.getId_offre());
            System.out.println("Date de candidature : " + candidature.getDate_candidature());
            System.out.println("Statut : " + candidature.getStatut());
            System.out.println("---------------------------");
    	}
    }

	public String afficherMessage(String message) {
		// TODO Auto-generated method stub
		return message;
	}

}
