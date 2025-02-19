<?php
// Paramètres de connexion à la base de données
session_start();
require_once "db.php";

// Récupérer les offres
$sql = "SELECT id_offre, titre, description, Entreprise, lieu FROM offres";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Offres</title>
    <style>
        .offre {
            border: 1px solid #ccc;
            padding: 15px;
            margin: 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .offre:hover {
            background: #f0f0f0;
        }
    </style>
</head>
<body>

<h2>Liste des Offres</h2>

<?php
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo '<div class="offre" onclick="window.location.href=\'postuler.php?id_offre='.$row["id_offre"].'\'">';
        echo "<h3>" . htmlspecialchars($row["titre"]) . "</h3>";
        echo "<p><strong>Entreprise :</strong> " . htmlspecialchars($row["Entreprise"]) . "</p>";
        echo "<p><strong>Lieu :</strong> " . htmlspecialchars($row["lieu"]) . "</p>";
        echo "<p>" . htmlspecialchars($row["description"]) . "</p>";
        echo "</div>";
    }
} else {
    echo "<p>Aucune offre disponible.</p>";
}
$conn->close();
?>

</body>
</html>
