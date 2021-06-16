-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 16 juin 2021 à 16:31
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `magasin`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Torture'),
(2, 'Explosif'),
(3, 'poison'),
(4, 'arme blanche');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `name`, `firstname`) VALUES
(3, 'Amiral General', 'Aladeen'),
(4, 'Jong-un', 'Kim'),
(5, 'Montgomery', 'Charles'),
(6, 'Tahiti', 'Bob'),
(7, 'Lecter', 'Hannibal'),
(8, 'Krueger', 'Freddy'),
(9, 'Denfer', 'Cruella'),
(10, 'Vador', 'Dark'),
(11, 'Poutine', 'Vladimir'),
(12, 'Poutine', 'Vladimir'),
(13, 'Poutine', NULL),
(14, 'Vador', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `client_id`) VALUES
(1, 3),
(2, 4),
(3, 5),
(4, 10);

-- --------------------------------------------------------

--
-- Structure de la table `commande_has_produit`
--

CREATE TABLE `commande_has_produit` (
  `produit_id` int(11) NOT NULL,
  `commande_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande_has_produit`
--

INSERT INTO `commande_has_produit` (`produit_id`, `commande_id`) VALUES
(1, 3),
(6, 3),
(10, 3),
(14, 4),
(17, 1),
(18, 2);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `price` double NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `name`, `description`, `price`, `category_id`) VALUES
(1, 'Arsenic', 'Poison le plus apprécié des Rois et Reines, la poudre d\'Arsenic est inodore et incolore lorsqu\'elle est humide. \r\nDe trés petites doses suffisent pour entrainer la mort, qui n\'est pas instantanée mais qui a lieu plusieurs heures aprés la prise, ce qui permet de vous ecarter de tout soupçons.', 125.5, 3),
(4, 'Cyanure', '', 134.5, 3),
(5, 'Sarin', '', 299.59, 3),
(6, 'Chaise de Judas', '', 599.99, 1),
(7, 'Chaussures de Ciment', '', 200.5, 1),
(8, 'Taureau d\'Airain', '', 999.99, 1),
(9, 'Tourniquet', '', 2430.55, 1),
(10, 'Bambou Tueur', '', 364.56, 1),
(11, 'Cigare Explosif', '', 35.99, 2),
(12, 'M14', '', 59.99, 2),
(13, 'Grenade', '', 35.25, 2),
(14, 'Bazooka', '', 167.34, 2),
(15, 'Epée de Toléde', '', 999.99, 4),
(16, 'Epée d\'Erik le Rouge ', '', 1890.5, 4),
(17, 'Stylo/Lame', '', 29.99, 4),
(18, 'Poignard Bowie', '', 255.8, 4);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_commande_client_idx` (`client_id`);

--
-- Index pour la table `commande_has_produit`
--
ALTER TABLE `commande_has_produit`
  ADD PRIMARY KEY (`produit_id`,`commande_id`),
  ADD KEY `fk_produit_has_commande_commande1_idx` (`commande_id`),
  ADD KEY `fk_produit_has_commande_produit1_idx` (`produit_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_commande_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `commande_has_produit`
--
ALTER TABLE `commande_has_produit`
  ADD CONSTRAINT `commande_has_produit_ibfk_1` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `fk_produit_has_commande_produit1` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `fk_produit_catégorie1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
