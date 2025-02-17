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
    public void afficherCandidatures() {
        List<Candidatures> candidatures = candidaturesDAO.getAllCandidatures();
        if (candidatures.isEmpty()) {
            System.out.println("Aucune candidature disponible.");
        } else {
            System.out.println("\n--- Liste des Candidatures---");
            for (Candidatures candidature : candidatures) {
                System.out.println("ID_candidature: " + candidature.getId_candidature());
                System.out.println("ID_utilisateur: " + candidature.getId_utilisateur());
                System.out.println("ID_offre: " + candidature.getId_offre());
                System.out.println("Date: " + candidature.getDate_candidature());
                System.out.println("Statut: " + candidature.getStatut());
                System.out.println("------------------------");
            }
        }
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

	public void afficherMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
