package fr.eseo.e4.poo.projet.infralogiciel.apply;

import fr.eseo.e4.poo.projet.infralogiciel.apply.Controller.OffresController;
import fr.eseo.e4.poo.projet.infralogiciel.apply.Controller.UtilisateursController;
import fr.eseo.e4.poo.projet.infralogiciel.apply.Controller.CandidaturesController;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.OffresVue;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.UtilisateurVue;
import fr.eseo.e4.poo.projet.infralogiciel.apply.view.CandidatureVue;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.OffresDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.UtilisateursDAO;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Offres;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Type_utilisateur;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.Utilisateurs;
import fr.eseo.e4.poo.projet.infralogiciel.apply.model.dao.CandidaturesDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OffresController offresController;
    private UtilisateursController utilisateursController;
    private CandidaturesController candidaturesController;
    private OffresDAO offresDAO;
    
    private JTextArea textArea; // Zone d'affichage

    public MainGUI() {
        // Initialisation des composants
        OffresDAO offresDAO = new OffresDAO();
        UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
        CandidaturesDAO candidaturesDAO = new CandidaturesDAO();

        OffresVue offresVue = new OffresVue(offresDAO);
        UtilisateurVue utilisateursVue = new UtilisateurVue(utilisateursDAO);
        CandidatureVue candidaturesVue = new CandidatureVue(candidaturesDAO);

        offresController = new OffresController(offresVue);
        utilisateursController = new UtilisateursController(utilisateursVue);
        candidaturesController = new CandidaturesController(candidaturesVue);

        // Configuration de la fenêtre principale
        setTitle("ESEO-Apply - Interface Graphique");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Zone d'affichage des résultats
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Création des boutons
        JButton btnAjouterOffre = new JButton("Ajouter une offre");
        JButton btnVoirOffres = new JButton("Voir les offres");
        JButton btnModifierOffre = new JButton("Modifier une offre");
        JButton btnVoirUtilisateurs = new JButton("Voir les utilisateurs");
        JButton btnSupprimerOffre = new JButton("Supprimer une offre");
        JButton btnVoirCandidatures = new JButton("Voir les candidatures");

        // Panneau de boutons (JPanel)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(btnAjouterOffre);
        panel.add(btnVoirOffres);
        panel.add(btnModifierOffre);
        panel.add(btnVoirUtilisateurs);
        panel.add(btnSupprimerOffre);
        panel.add(btnVoirCandidatures);

        // Ajout des composants à la fenêtre
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Actions des boutons
        btnAjouterOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterOffre();
            }
        });

        btnVoirOffres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voirOffres();
            }
        });

        btnModifierOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifierOffre();
            }
        });

        btnVoirUtilisateurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voirUtilisateurs();
            }
        });

        btnSupprimerOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 suppressionOffre();
            }
        });

        btnVoirCandidatures.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voirCandidatures();
            }
        });
    }

    private void ajouterOffre() {
        String titre = JOptionPane.showInputDialog(this, "Titre de l'offre :");
        String description = JOptionPane.showInputDialog(this, "Description :");
        String entreprise = JOptionPane.showInputDialog(this, "Entreprise :");
        String lieu = JOptionPane.showInputDialog(this, "Lieu :");
        if (titre != null && description != null && entreprise != null && lieu !=null) {
            offresController.ajouterOffres(titre, description, entreprise, lieu, new Date());
            textArea.append("Offre ajoutée : " + titre + "\n");
        }
    }

    private void voirOffres() {
    	String offresText = offresController.afficherOffres(); // Récupérer le texte des offres
        textArea.append(offresText); // Ajouter au JTextArea
    }

    private void modifierOffre() {
    	new OffreGUI().setVisible(true);
    	
    }

    private void voirUtilisateurs() {
        textArea.append("Liste des Utilisateurs :\n");
        utilisateursController.afficherUtilisateurs();
    }

    private void suppressionOffre() {
    	voirOffres();
    }

    private void voirCandidatures() {
        textArea.append("Liste des Candidatures :\n");
        candidaturesController.afficherCandidatures();
    }

    public static void MainGUI(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}