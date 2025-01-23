package fr.eseo.e4.poo.projet.infralogiciel.apply.vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eseo.e4.poo.projet.infralogiciel.apply.controlleur.SignInActionRec;
import fr.eseo.e4.poo.projet.infralogiciel.apply.modele.InscriptionConnexion;

public class SignInDialogRec extends JPanel implements InscriptionConnexion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSignIn;
	private JButton btnLogon;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtBirthdate;
	private JPasswordField txtMdp;
	private JPasswordField txtConfMdp;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblBirthdate;
	private JLabel lblMdp;
	private JLabel lblConfMdp;
	private UserData userData;
	
	public SignInDialogRec() {
		setLayout(new GridLayout(8, 2));

		// Création des composants
		lblNom = new JLabel("Nom:");
		txtNom = new JTextField();
		lblPrenom = new JLabel("Prenom:");
		txtPrenom = new JTextField();
		lblEmail = new JLabel("Adresse Mail:");
		txtEmail = new JTextField();
		lblPhone = new JLabel("Téléphone:");
		txtPhone = new JTextField();
		lblBirthdate = new JLabel("Date de Naissance:");
		txtBirthdate = new JTextField();
		lblMdp = new JLabel("Mot de passe:");
		txtMdp = new JPasswordField();
		lblConfMdp = new JLabel("Confirmation mot de passe:");
		txtConfMdp = new JPasswordField();
		btnSignIn = new JButton("Inscription");
		btnLogon = new JButton("Connexion");
		
		
		//Création d'un utilisateur
		userData = new UserData();
		
		//Ajout des composants à l'interface graphique
		this.add(lblNom);
		this.add(txtNom);
		this.add(lblPrenom);
		this.add(txtPrenom);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblPhone);
		this.add(txtPhone);
		this.add(lblBirthdate);
		this.add(txtBirthdate);
		this.add(lblMdp);
		this.add(txtMdp);
		this.add(lblConfMdp);
		this.add(txtConfMdp);
		this.add(btnSignIn);
		this.add(btnLogon);
		
		//Ajout du bouton au ActionListener
		btnSignIn.addActionListener(new SignInActionRec(this));
		btnLogon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openLogonDialogRec();
			}
		});
	}
	

	
	protected void openLogonDialogRec() {
		// TODO Auto-generated method stub
		UserData userData = new UserData();
		userData.setUniqueId(getUniqueId());
		userData.setUsername(getUserId());
		userData.setPassword(getConfMotDePasse());
		
		//Afficher la fenêtre LogonDialogRec
		LogonDialogRec lgDRec = new LogonDialogRec(userData);  
		JFrame frame = new JFrame("Connexion");
		frame.getContentPane().add(lgDRec);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return txtNom.getText();
	}

	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return txtPrenom.getText();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return txtEmail.getText();
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return txtPhone.getText();
	}

	@Override
	public String getBirthDate() {
		// TODO Auto-generated method stub
		return txtBirthdate.getText();
	}

	@Override
	public String getMotDePasse() {
		// TODO Auto-generated method stub
		return new String(txtMdp.getPassword());
	}

	@Override
	public String getConfMotDePasse() {
		// TODO Auto-generated method stub
		return new String(txtConfMdp.getPassword());
	}
	
	public String userId(){
		String nom1;
		String prenom1;
		String name = getNom().toLowerCase();
		String surname = getPrenom().toLowerCase();
		if(name.length()>5) {
			nom1 = name.substring(0,5);
		}
		else {
			nom1 = name;
		}
		if(surname.length()>=3) {
			prenom1 = surname.substring(0,3);
		}
		else {
			prenom1 = surname;
		}
		//Extraction des deux chiffres de l'année de naissance
		String annee = String.valueOf(getBirthDate()).substring(2);
		//Suppression des espaces et des apostrophes
		String id = (nom1 + prenom1).replace(" ","").replace("'","")+annee;
		return id;
	}
	
	public String getUserId() {
		return userId();
	}
	
	public String generateId() {
		String name1 = getNom().toLowerCase();
		String surname1 = getPrenom().toLowerCase();
		
		//Préfixe de l'identifiant avec les 3 prmières lettres du nom et première du prénom
		String prefix = (name1.substring(0, 3) + surname1.substring(0, 1)).toUpperCase();
		
		//Ajout de 4 lettres d'un UUID pour l'unicité
		String unique = UUID.randomUUID().toString().substring(0, 4);
		
		//Combinaison des 2 éléments
		String shortID = prefix + "-" + unique;
		
		return shortID;
	}
	
	public String getUniqueId() {
		return generateId();
	}
	
	public void saveUserData() {
		userData.setUniqueId(getUniqueId());
		userData.setUsername(getUserId());
		userData.setPassword(getConfMotDePasse());
	}
	
	
	
	public static void main(String[] args) {
		//Création de la JFrame
		JFrame frame = new JFrame("Inscription");
		
		//Création de l'instance  de SignInDialogRec
		SignInDialogRec sgDRec = new SignInDialogRec();
		
		//Ajout de SignInDialog à la JFrame
		frame.getContentPane().add(sgDRec);
		
		//Configuration de la JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //Centrer le fenêtre
		frame.pack();
		frame.setVisible(true);
	}
	
}
