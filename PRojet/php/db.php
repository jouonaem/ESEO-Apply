<?php
$host = "127.0.0.1";  // Adresse du serveur MySQL (ou IP)
$user = "root";       // Nom d'utilisateur MySQL
$password = "";       // Mot de passe MySQL (laisser vide si aucun)
$database = "projet_eseo_apply"; // Nom de la base de données

// Connexion à MySQL
$conn = new mysqli($host, $user, $password, $database);

// Vérifier la connexion
if ($conn->connect_error) {
    die("Connexion échouée : " . $conn->connect_error);
}

// Définir l'encodage en UTF-8 (important pour les accents)
$conn->set_charset("utf8");
?>
