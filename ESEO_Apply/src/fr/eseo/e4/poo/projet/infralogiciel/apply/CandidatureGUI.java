package fr.eseo.e4.poo.projet.infralogiciel.apply;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.StatutCandidature;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CandidatureGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private CandidaturesDAO candidaturesDAO;
    private int idOffre;
    private String titreOffre;

    public CandidatureGUI(CandidaturesDAO candidaturesDAO, int idOffre, String titreOffre) {
        this.candidaturesDAO = candidaturesDAO;
        this.idOffre = idOffre;
        this.titreOffre = titreOffre;

        setTitle("Candidatures pour l'offre : " + titreOffre);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new Object[]{"ID Candidature", "Nom", "Prénom", "Statut"}, 0);
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null); 
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        remplirTable(); // Remplir les candidatures associées à l'offre

        // Ajouter un écouteur de clic sur le tableau
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-clic
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int idCandidature = (int) model.getValueAt(selectedRow, 0);
                        afficherOptions(idCandidature);
                    }
                }
            }
        });

        setVisible(true);
    }

    private void remplirTable() {
        model.setRowCount(0); // Effacer les anciennes données
        List<Candidatures> candidatures = candidaturesDAO.getCandidaturesParOffre(idOffre);
        for (Candidatures candidature : candidatures) {
            model.addRow(new Object[]{
                    candidature.getId_candidature(),
                    candidature.getNom(),
                    candidature.getPrenom(),
                    candidature.getStatut()
            });
        }
    }

    private void afficherOptions(int idCandidature) {
        String[] options = {"Accepter", "Refuser", "Annuler"};
        int choix = JOptionPane.showOptionDialog(this, "Que voulez-vous faire ?", "Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choix == 0) {
            modifierStatutCandidature(idCandidature, StatutCandidature.ACCEPTEE);
        } else if (choix == 1) {
            modifierStatutCandidature(idCandidature, StatutCandidature.REFUSEE);
        }
    }

    private void modifierStatutCandidature(int idCandidature, StatutCandidature nouveauStatut) {
        candidaturesDAO.mettreAJourStatutCandidature(idCandidature, nouveauStatut);
        remplirTable(); // Rafraîchir l'affichage
        JOptionPane.showMessageDialog(this, "Statut de la candidature mis à jour !");
        envoyerNotification(idCandidature, nouveauStatut);
    }

    private void envoyerNotification(int idCandidature, StatutCandidature nouveauStatut) {
        JOptionPane.showMessageDialog(this, "Notification envoyée à l'étudiant pour la mise à jour du statut : " + nouveauStatut);
        // Ici, tu peux appeler la logique d'envoi d'email ou de notification
    }
}