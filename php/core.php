<?php
// Paramètres de connexion à la base de données
$host = 'localhost'; // Hôte
$dbname = 'utilisateur_db'; // Nom de la base de données
$username = 'root'; // Nom d'utilisateur MySQL
$password = ''; // Mot de passe MySQL (laissez vide si non défini pour localhost)

try {
    // Connexion à la base de données avec PDO
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion à la base de données : " . $e->getMessage());
}

// Vérifier si le formulaire a été soumis
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id_utilisateur = $_POST['id_utilisateur'] ?? '';
    $nom = $_POST['nom'] ?? '';
    $prenom = $_POST['prenom'] ?? '';
    $email = $_POST['email'] ?? '';
    $type_utilisateur = $_POST['type_utilisateur'] ?? '';
    $mot_de_passe = $_POST['mot_de_passe'] ?? '';

    // Validation des champs
    if (empty($nom) || empty($email) || empty($mot_de_passe) || empty( $prenom) || empty( $mot_de_passe)) {
        echo "Tous les champs sont obligatoires.";
        exit;
    }

    // Hachage du mot de passe
    $mot_de_passe_hache = password_hash($mot_de_passe, PASSWORD_DEFAULT);

    try {
        // Préparation de la requête SQL
        $stmt = $pdo->prepare("INSERT INTO utilisateurs (nom, prenom, email, type_utilisateur, mot_de_passe) VALUES (:nom, :prenom, :email, :type_utiliseur, :mot_de_passe)");
        $stmt->execute([
            ':nom' => $nom,
            ':prenom' => $prenom,
            ':email' => $email,
            ':type_utilisateur' => $type_utilisateur,
            ':mot_de_passe' => $mot_de_passe_hache,
        ]);

        echo "Utilisateur enregistré avec succès.";
    } catch (PDOException $e) {
        if ($e->getCode() == 23000) { // Violation de contrainte unique (email déjà utilisé)
            echo "Cet email est déjà enregistré.";
        } else {
            echo "Erreur lors de l'enregistrement : " . $e->getMessage();
        }
    }
}
?>
