<?php
print_r($_POST);
session_start();
require_once "db.php";


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = $_POST["email"];
    $mot_de_passe = $_POST["password"];

   /* if (empty($email) || empty($password)) {
        echo json_encode(["success" => false, "message" => "Champs manquants"]);
        exit;
    }*/


    $sql = "SELECT * FROM utilisateurs WHERE email='$email'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        if (password_verify($mot_de_passe, $user["mot_de_passe"])) {
            session_start();
            $_SESSION["utilisateur"] = $user;
            // S'assurer que l'ID est stocké séparément aussi
            //$_SESSION["id_etudiant"] = $user["id_etudiant"] ?? null;
            echo "Connexion réussie!";
            header("Location: dashboard.php");  /*Redirige vers une page différente selon l'utilisateur*/
            exit();

        } else {
            echo "Mot de passe incorrect!";
        }
    } else {
        echo "Email introuvable!";
    }
}

$conn->close();
?>
