<?php
session_start();
require_once "db.php";

if (!isset($_SESSION["utilisateur"]) || $_SESSION["utilisateur"]["type_utilisateur"] != "Recruteur") {
    header("Location: /PRojet/formulaire.html");
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titre = $_POST['titre'] ?? '';
    $description = $_POST['description'] ?? '';
    $entreprise = $_POST['Entreprise'] ?? '';
    $lieu = $_POST['lieu'] ?? '';
    if (empty($titre) || empty($description) || empty($entreprise) || empty($lieu)) {
        die("Tous les champs sont obligatoires.");
    }

        $sql = "INSERT INTO offres (titre, description, Entreprise, lieu) VALUES (?, ?, ?, ?)";
        $stmt = $conn->prepare($sql);
        if (!$stmt) {
            die("Erreur de préparation de la requête : " . $conn->error);
        }
    
        $stmt->bind_param("ssss", $titre, $description, $entreprise, $lieu);
        
        if ($stmt->execute()) {
            echo "<p style='color: green;'>Offre ajoutée avec succès !</p>";
        } else {
            echo "Erreur lors de l'ajout de l'offre : " . $stmt->error;
        }
        
        $stmt->close();
        $conn->close();
}
?>