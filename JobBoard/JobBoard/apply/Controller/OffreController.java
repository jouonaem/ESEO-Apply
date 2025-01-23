package fr.eseo.e4.poo.projet.infralogiciel.apply.Controller;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;

import java.util.List;

public class OffreController {

    private final OffresDAO offresDAO;

    public OffreController(OffresDAO offresDAO) {
        this.offresDAO = offresDAO;
    }

    public List<Offres> getToutesLesOffres() {
        return offresDAO.getAllOffres();
    }

    public void ajouterOffre(Offres offre) {
        offresDAO.ajouterOffre(offre);
    }

    public void supprimerOffre(int id_offre) {
        offresDAO.supprimerOffre(id_offre);
    }

    public Offres obtenirOffreParId(int id_offre) {
        return offresDAO.getOffreById(id_offre);
    }

    public void mettreAJourOffre(Offres offre) {
        offresDAO.mettreAJourOffre(offre);
    }
}