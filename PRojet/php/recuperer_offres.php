<?php
// Paramètres de connexion à la base de données
session_start();
require_once "db.php";

header("Content-Type: application/json"); // Indiquer que la réponse est en JSON


try {
    // Connexion à la base de données
    $conn = new mysqli("mysql:host=$host;dbname=$database", $user, $password);
    if ($conn->connect_error) {
        die("Erreur de connexion à la base de données : " . $conn->connect_error);
    }
} catch (Exception $e) {
    die("Erreur de connexion à la base de données : " . $e->getMessage());
}

// Récupérer les offres
try {
    $sql = "SELECT * FROM offres ORDER BY date_publication DESC";
    $result = $conn->query($sql);

      // Vérifier si des offres existent
      if ($result->num_rows > 0) {
        $offres = $result->fetch_all(MYSQLI_ASSOC);
        echo json_encode($offres);
    } else {
        echo json_encode([]); // Renvoie un tableau vide si aucune offre
    }

} catch (Exception $e) {
    die("Erreur lors de la récupération des offres : " . $e->getMessage());
}
echo json_encode($offres);
?>
