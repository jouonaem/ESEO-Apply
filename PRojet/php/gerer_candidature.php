<?php
session_start();
require_once "db.php";

if (!isset($_SESSION["utilisateur"]) || $_SESSION["utilisateur"]["type_utilisateur"] != "Recruteur") {
    header("Location: formulaire.html");
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $candidature_id = $_POST["candidature_id"];
    $action = $_POST["action"];

    $nouveau_statut = ($action == "accepter") ? "Acceptée" : "Refusée";

    $stmt = $conn->prepare("UPDATE candidatures SET statut = ? WHERE id = ?");
    $stmt->bind_param("si", $nouveau_statut, $candidature_id);

    if ($stmt->execute()) {
        echo "Candidature mise à jour avec succès.";
    } else {
        echo "Erreur : " . $conn->error;
    }

    $stmt->close();
    $conn->close();
}
?>
