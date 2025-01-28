<?php
$host = 'localhost';
$dbname = 'utilisateur_db';
$username = 'root';
$password = '';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Erreur de connexion : " . $e->getMessage());
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titre = $_POST['titre'];
    $description = $_POST['description'];
    $entreprise = $_POST['entreprise'];
    $lieu = $_POST['lieu'];

    $sql = "INSERT INTO offres (titre, description, entreprise, lieu) VALUES (:titre, :description, :entreprise, :lieu)";
    $stmt = $pdo->prepare($sql);
    $stmt->execute(['titre' => $titre, 'description' => $description, 'entreprise' => $entreprise, 'lieu' => $lieu]);

    echo "<p style='color: green;'>Offre ajoutée avec succès !</p>";
}
?>
