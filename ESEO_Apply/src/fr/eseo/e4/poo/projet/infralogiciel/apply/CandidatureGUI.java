package fr.eseo.e4.poo.projet.infralogiciel.apply;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Candidatures;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CandidatureGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel model;
    private CandidaturesDAO candidaturesDAO;

    public CandidatureGUI(CandidaturesDAO candidaturesDAO) {
        this.candidaturesDAO = candidaturesDAO;
        setTitle("Gestion des Offres");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new Object[]{"ID", "Titre", "Entreprise", "Lieu"}, 0);
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null); // Empêche l'édition de la table
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        remplirTable(); // Remplir les offres

        // Ajouter un écouteur de clic sur le tableau
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-clic
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int idOffre = (int) model.getValueAt(selectedRow, 0);
                        afficherOptions(idOffre);
                    }
                }
            }
        });

        setVisible(true);
    }

   

	private void remplirTable() {
        model.setRowCount(0); // Effacer les anciennes données
        List<Candidatures> candidatures = candidaturesDAO.getAllCandidatures();
        for (Candidatures candidature : candidatures) {
            model.addRow(new Object[]{candidature.getId_candidature(), candidature.getId_offre(), candidature.getStatut(),candidature.getDate_candidature(), candidature.getNom(), candidature.getPrenom()});
        }
    }

    private void afficherOptions(int idCandidature) {
        String[] options = {"Accepter", "Refuser", "Annuler"};
        int choix = JOptionPane.showOptionDialog(this, "Que voulez-vous faire ?", "Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choix == 0) {
           // modifierOffre(idOffre);
        } else if (choix == 1) {
           // supprimerOffre(idOffre);
        }
    }

   /* private void modifierOffre(int idOffre) {
        String nouveauTitre = JOptionPane.showInputDialog(this, "Nouveau titre de l'offre :");
        String newdescription = JOptionPane.showInputDialog(this, "Description :");
        String newentreprise = JOptionPane.showInputDialog(this, "Entreprise :");
        String newlieu = JOptionPane.showInputDialog(this, "Lieu :");
        if (nouveauTitre != null && !nouveauTitre.trim().isEmpty() &&
                newdescription != null && !newdescription.trim().isEmpty() &&
                newentreprise != null && !newentreprise.trim().isEmpty() &&
                newlieu != null && !newlieu.trim().isEmpty()) {

                // Créer un objet Offres avec les nouvelles valeurs
                Offres offre = new Offres(idOffre, nouveauTitre, newdescription, newentreprise, newlieu, new java.util.Date());

                // Mettre à jour l'offre dans la base de données
                offresDAO.mettreAJourOffre(offre);

                // Rafraîchir l'affichage
                remplirTable();
                JOptionPane.showMessageDialog(this, "Offre modifiée avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis !");
            }
    }*/

    /*private void supprimerOffre(int idOffre) {
        int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette offre ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        	candidaturesDAO.supprimerOffre(idOffre);
            remplirTable(); // Rafraîchir l'affichage
            JOptionPane.showMessageDialog(this, "Offre supprimée !");
        }
    }*/
}
