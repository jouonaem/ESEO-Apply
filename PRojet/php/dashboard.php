<?php
session_start();
if (!isset($_SESSION["utilisateur"])) {
    header("Location: /PRojet/formulaire.html");
    exit();
}

$utilisateur = $_SESSION["utilisateur"];

?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; }
        .container { margin-top: 50px; }
        .btn { padding: 10px 20px; background-color: blue; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>

    <h1>Bienvenue, <?= htmlspecialchars($utilisateur["prenom"]) ?>!</h1>
    <h2>Votre rôle : <?= htmlspecialchars($utilisateur["type_utilisateur"]) ?></h2>

    <div class="container">
        <?php if ($utilisateur["type_utilisateur"] == "Etudiant"): ?> <br>
            <a href="offres.php" class="btn">Voir les offres</a>
            <a href="mes_candidatures.php" class="btn">Mes candidatures</a>
        <?php elseif ($utilisateur["type_utilisateur"] == "Recruteur"): ?> <br>
            <a href="/PRojet/Recruteur.html" class="btn">Mon Espace Admin</a>
            <a href="candidatures_reçues.php" class="btn">Voir les candidatures</a>
        <?php endif; ?>
    </div>

    <br>
    <a href="logout.php" class="btn" style="background-color: red;">Déconnexion</a>

</body>
</html>