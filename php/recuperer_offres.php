<?php
// Paramètres de connexion à la base de données
$host = 'localhost'; // Hôte
$dbname = 'utilisateur_db'; // Nom de la base de données
$username = 'root'; // Nom d'utilisateur MySQL
$password = ''; // Mot de passe MySQL

try {
    // Connexion à la base de données
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion à la base de données : " . $e->getMessage());
}

// Récupérer les offres
try {
    $stmt = $pdo->query("SELECT * FROM offres ORDER BY date_creation DESC");
    $offres = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    die("Erreur lors de la récupération des offres : " . $e->getMessage());
}

$stmt = $pdo->query("SELECT * FROM offres ORDER BY date_creation DESC");
$offres = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

// Générer les divs pour chaque offre
foreach ($offres as $offre) {
    echo '<div class="job-card">';
    echo '<h2>' . htmlspecialchars($offre['titre']) . '</h2>';
    echo '<p><strong>Entreprise :</strong> ' . htmlspecialchars($offre['entreprise']) . '</p>';
    echo '<p><strong>Lieu :</strong> ' . htmlspecialchars($offre['lieu']) . '</p>';
    echo '<p>' . nl2br(htmlspecialchars($offre['description'])) . '</p>';
    echo '<button>Postuler</button>';
    echo '</div>';
}
?>
