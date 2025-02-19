<?php
print_r($_POST);

// Paramètres de connexion à la base de données
session_start();
require_once "db.php";

try {
    // Connexion à la base de données
    $pdo = new PDO("mysql:host=$host;dbname=$database", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion à la base de données : " . $e->getMessage());
}

// Vérifier si le formulaire a été soumis
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
   // $id_utilisateur = $_POST['id_utilisateur'] ?? '';
    $nom = $_POST['nom'] ?? '';
    $prenom = $_POST['prenom'] ?? '';
    $email = $_POST['email'] ?? '';
    $type_utilisateur = $_POST['type_utilisateur'] ?? '';
    $entreprise = $_POST['entreprise'] ?? '';
    $mot_de_passe = $_POST['password'] ?? '';

    // Validation des champs
    if (empty($nom) || empty($email) || empty( $prenom) || empty( $mot_de_passe)) {
        echo "Tous les champs sont obligatoires.";
        exit;
    }

    // Hachage du mot de passe
    $mot_de_passe_hache = password_hash($mot_de_passe, PASSWORD_DEFAULT);

    try {
        // Préparation de la requête SQL
        $stmt = $pdo->prepare("INSERT INTO utilisateurs (nom, prenom, email, type_utilisateur, mot_de_passe) VALUES (:nom, :prenom, :email, :type_utilisateur, :mot_de_passe)");
        $stmt->execute([
            ':nom' => $nom,
            ':prenom' => $prenom,
            ':email' => $email,
            ':type_utilisateur' => $type_utilisateur,
            ':mot_de_passe' => $mot_de_passe_hache,
        ]);
        
        if ($type_utilisateur == "Recruteur" && !empty($entreprise)) {
            $stmt = $pdo->prepare("INSERT INTO recruteurs (nom, prenom, email, type_utilisateur, mot_de_passe, entreprise) VALUES (:nom, :prenom, :email, :type_utilisateur, :mot_de_passe, :entreprise)");
            $stmt->execute([
                ':nom' => $nom,
                ':prenom' => $prenom,
                ':email' => $email,
                ':type_utilisateur' => $type_utilisateur,
                ':entreprise' => $entreprise,
                ':mot_de_passe' => $mot_de_passe_hache,
            ]);
        } else {
            $stmt = $pdo->prepare("INSERT INTO etudiants (nom, prenom, email, type_utilisateur, mot_de_passe) VALUES (:nom, :prenom, :email, :type_utilisateur, :mot_de_passe)");
            $stmt->execute([
                ':nom' => $nom,
                ':prenom' => $prenom,
                ':email' => $email,
                ':type_utilisateur' => $type_utilisateur,
                ':mot_de_passe' => $mot_de_passe_hache,
            ]);
        }

        echo "Utilisateur enregistré avec succès.";

        header("Location: /PRojet/formulaire.html");
        exit();

    } catch (PDOException $e) {
        if ($e->getCode() == 23000) { // Violation de contrainte unique (email déjà utilisé)
            echo "Cet email est déjà enregistré.";
        } else {
            echo "Erreur lors de l'enregistrement : " . $e->getMessage();
        }
    }
}
?>
