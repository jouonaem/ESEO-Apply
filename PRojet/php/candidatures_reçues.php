<?php
session_start();
require_once "db.php";

if (!isset($_SESSION["utilisateur"]) || $_SESSION["utilisateur"]["type_utilisateur"] != "Recruteur") {
    header("Location: formulaire.html");
    exit();
}

$sql = "SELECT c.id_candidature, u.nom, u.prenom, o.titre, c.statut 
        FROM candidatures c 
        JOIN utilisateurs u ON c.id_utilisateur = u.id_utilisateur
        JOIN offres o ON c.id_offre = o.id_offre";
$result = $conn->query($sql);
/*$recruteur_id = $_SESSION["utilisateur"]["id"];

$sql = "SELECT c.id, u.nom, u.prenom, c.offre_id, c.date_soumission, c.statut
        FROM candidatures c
        JOIN utilisateurs u ON c.utilisateur_id = u.id
        JOIN offres o ON c.offre_id = o.id
        WHERE o.recruteur_id = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $recruteur_id);
$stmt->execute();
$result = $stmt->get_result();*/
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Candidatures</title>
</head>
<body>

<h2>Liste des Candidatures</h2>

<table border="1">
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Offre</th>
        <th>Statut</th>
        <th>Actions</th>
    </tr>
    <?php
    while ($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($row['nom']) . "</td>";
        echo "<td>" . htmlspecialchars($row['prenom']) . "</td>";
        echo "<td>" . htmlspecialchars($row['titre']) . "</td>";
        echo "<td>" . htmlspecialchars($row['statut']) . "</td>";
        echo '<td>
                <a href="traiter_candidature.php?id_candidature='.$row["id_candidature"].'&action=accepter">Accepter</a> |
                <a href="traiter_candidature.php?id_candidature='.$row["id_candidature"].'&action=refuser">Refuser</a>
              </td>';
        echo "</tr>";
    }
    ?>
</table>

</body>
</html>
