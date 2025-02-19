<?php
session_start();
require_once "db.php";

$id_candidature = isset($_GET['id_candidature']) ? intval($_GET['id_candidature']) : 0;
$action = isset($_GET['action']) ? $_GET['action'] : '';

if ($id_candidature > 0 && ($action === 'accepter' || $action === 'refuser')) {
    $nouveau_statut = ($action === 'accepter') ? 'ACCEPTEE' : 'REFUSE';
    $sql = "UPDATE candidatures SET statut = ? WHERE id_candidature = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("si", $nouveau_statut, $id_candidature);

    if ($stmt->execute()) {
        echo "<p>Candidature mise à jour avec succès.</p>";
    } else {
        echo "<p>Erreur de mise à jour.</p>";
    }

    $stmt->close();
}

$conn->close();
?>

<a href="candidatures_reçues.php">Retour aux candidatures</a>
