-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 23 jan. 2025 à 10:02
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_eseo_apply`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidatures`
--

DROP TABLE IF EXISTS `candidatures`;
CREATE TABLE IF NOT EXISTS `candidatures` (
  `id_candidature` int NOT NULL AUTO_INCREMENT,
  `id_utilisateur` int NOT NULL,
  `id_offre` int NOT NULL,
  `statut` enum('EN_COURS','REFUSE','ACCEPTEE') NOT NULL,
  `date_candidature` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_candidature`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_offre` (`id_offre`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `candidatures`
--

INSERT INTO `candidatures` (`id_candidature`, `id_utilisateur`, `id_offre`, `statut`, `date_candidature`) VALUES
(2, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(3, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(4, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(5, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(6, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(7, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(8, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(9, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(10, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(11, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(12, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(13, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(14, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(15, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(16, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(17, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(18, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(19, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(20, 1, 2, 'EN_COURS', '2025-01-21 23:00:00'),
(21, 1, 2, 'EN_COURS', '2025-01-22 23:00:00'),
(22, 1, 2, 'EN_COURS', '2025-01-22 23:00:00'),
(23, 1, 2, 'EN_COURS', '2025-01-22 23:00:00'),
(28, 1, 2, 'ACCEPTEE', '2025-01-22 23:00:00'),
(25, 1, 2, 'ACCEPTEE', '2025-01-22 23:00:00'),
(26, 1, 2, 'ACCEPTEE', '2025-01-22 23:00:00'),
(27, 1, 2, 'ACCEPTEE', '2025-01-22 23:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

DROP TABLE IF EXISTS `etudiants`;
CREATE TABLE IF NOT EXISTS `etudiants` (
  `id_etudiant` smallint NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mot_de_passe` varchar(255) NOT NULL,
  `Type_utilisateur` enum('ETUDIANT','ADMIN') NOT NULL,
  PRIMARY KEY (`id_etudiant`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etudiants`
--

INSERT INTO `etudiants` (`id_etudiant`, `Nom`, `Email`, `Mot_de_passe`, `Type_utilisateur`) VALUES
(2, 'John Doe', 'john.doe@example.com', 'password123', 'ETUDIANT');

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

DROP TABLE IF EXISTS `offres`;
CREATE TABLE IF NOT EXISTS `offres` (
  `id_offre` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date_publication` date DEFAULT NULL,
  `Entreprise` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_offre`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `offres`
--

INSERT INTO `offres` (`id_offre`, `titre`, `description`, `date_publication`, `Entreprise`) VALUES
(9, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(2, 'Stage en dev web', 'java, python ,c', '2025-01-22', NULL),
(3, 'Stage en dev web', 'java, python ,c', '2025-01-22', NULL),
(4, 'Stage en dev web', 'java, python ,c', '2025-01-22', NULL),
(5, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(6, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(7, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(8, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(10, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(11, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(12, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(13, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(14, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(15, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(16, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(17, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(18, 'Stage en dev web', 'java, python ,c', '2025-01-22', 'choco enterprise'),
(19, 'Stage en dev web', 'java, python ,c', '2025-01-23', 'choco enterprise'),
(20, 'Alternance en programmation', 'java, python ,c', '2025-01-23', 'choco enterprise');

-- --------------------------------------------------------

--
-- Structure de la table `recruteurs`
--

DROP TABLE IF EXISTS `recruteurs`;
CREATE TABLE IF NOT EXISTS `recruteurs` (
  `id_recruteur` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `Mot_de_passe` varchar(255) DEFAULT NULL,
  `type_utilisateur` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_recruteur`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `recruteurs`
--

INSERT INTO `recruteurs` (`id_recruteur`, `nom`, `email`, `Mot_de_passe`, `type_utilisateur`) VALUES
(1, 'Jean Dupont', 'jean.dupont@email.com', 'password123', 'Admin');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id_utilisateur` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `type_utilisateur` enum('Étudiant','Admin') DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `email`, `mot_de_passe`, `type_utilisateur`) VALUES
(1, 'choco', 'new-email@domain.com', 'newpassword123', 'Étudiant'),
(2, 'choco', 'kwegueng.emmanuel@gmail.com', 'chocoboy1234', 'Étudiant');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
