<?php
session_start();
require_once "db.php";

if (!isset($_SESSION["utilisateur"])) {
    header("Location: /PRojet/formulaire.html");
    exit();
}

$id_offre = isset($_GET['id_offre']) ? intval($_GET['id_offre']) : 0;
//$id_etudiant = $_SESSION['utilisateur']['id_etudiant'] ?? null;
$id_utilisateur = $_SESSION["utilisateur"]["id_utilisateur"];
//$user = $_SESSION["utilisateur"] ?? null;

// Vérifier si l'étudiant a déjà postulé
$check_sql = "SELECT * FROM candidatures WHERE id_utilisateur = ? AND id_offre = ?";
$stmt = $conn->prepare($check_sql);
$stmt->bind_param("ii", $id_utilisateur, $id_offre);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    echo "<p>Vous avez déjà postulé à cette offre.</p>";
} else {
    // Insérer la candidature
    $insert_sql = "INSERT INTO candidatures (id_utilisateur, id_offre, statut) VALUES (?, ?, 'EN_COURS')";
    $stmt = $conn->prepare($insert_sql);
    $stmt->bind_param("ii", $id_utilisateur, $id_offre);

    if ($stmt->execute()) {
        echo "<p>Votre candidature a été soumise avec succès !</p>";
    } else {
        echo "<p>Erreur lors de la candidature.</p>";
        echo "<p>Erreur SQL : " . $stmt->error . "</p>"; // Affiche l'erreur SQL exacte
    }
}

$stmt->close();
$conn->close();
/*if ($_SERVER["REQUEST_METHOD"] == "POST") {

    if (!isset($_POST["id_offre"]) || !isset($_SESSION["utilisateur"]["id"])) {
        die("Erreur : données manquantes !");
    }

    $offre_id = $_POST["id_offre"];
    $utilisateur_id = $_SESSION["utilisateur"]["id"]; // Récupérer depuis la session


    $stmt = $conn->prepare("INSERT INTO candidatures (id_offre, id_utilisateur, date_Candidature, statut) VALUES (?, ?, ?, 'EN_COURS')");
    $stmt->bind_param("iis", $offre_id, $utilisateur_id);

    if ($stmt->execute()) {
        echo "Candidature envoyée avec succès !";
    } else {
        echo "Erreur : " . $conn->error;
    }

    $stmt->close();
    $conn->close();
}*/
?>

<a href="offres.php">Retour aux offres</a>

