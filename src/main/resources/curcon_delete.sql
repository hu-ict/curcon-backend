-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 23 mrt 2017 om 09:16
-- Serverversie: 10.1.21-MariaDB
-- PHP-versie: 7.1.1

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `curcon`
--
DROP TABLE IF EXISTS `toets_geslotenvraag`;
DROP TABLE IF EXISTS `toets_openvraag`;
DROP TABLE IF EXISTS `onderwerp_cursus`;
DROP TABLE IF EXISTS `opleidingsprofiel_beroepstaak`;
DROP TABLE IF EXISTS `opleidingsprofiel_cohort`;
DROP TABLE IF EXISTS `opleidingsprofiel_leerlijn`;
DROP TABLE IF EXISTS `opleidingsprofiel_professionalskill`;
DROP TABLE IF EXISTS `organisatie_beroepstaak`;
DROP TABLE IF EXISTS `organisatie_cursus`;
DROP TABLE IF EXISTS `organisatie_professionalskill`;
DROP TABLE IF EXISTS `cursus_beroepstaak`;
DROP TABLE IF EXISTS `cursus_onderwerp`;
DROP TABLE IF EXISTS `cursus_professionalskill`;
DROP TABLE IF EXISTS `toets_beroepsproduct`;
DROP TABLE IF EXISTS `toetsplanning_toetselement`;
DROP TABLE IF EXISTS `beoordelingselement_toetselement`;
DROP TABLE IF EXISTS `cohort_cursus`;
DROP TABLE IF EXISTS `leerlijn_onderwerp`;
DROP TABLE IF EXISTS `geslotenvraag`;
DROP TABLE IF EXISTS `openvraag`;
DROP TABLE IF EXISTS `beroepstaak`;
DROP TABLE IF EXISTS `cohort`;
DROP TABLE IF EXISTS `opleidingsprofiel`;
DROP TABLE IF EXISTS `leerlijn`;
DROP TABLE IF EXISTS `onderwerp`;
DROP TABLE IF EXISTS `toetselement`;
DROP TABLE IF EXISTS `toetsplanning`;
DROP TABLE IF EXISTS `osirisresultaattype`;
DROP TABLE IF EXISTS `professionalskill`;
DROP TABLE IF EXISTS `toets`;
DROP TABLE IF EXISTS `beroepsproduct`;
DROP TABLE IF EXISTS `beoordelingselement`;
DROP TABLE IF EXISTS `leerdoel`;
DROP TABLE IF EXISTS `cursus`;
DROP TABLE IF EXISTS `docent`;
DROP TABLE IF EXISTS `bloomniveau`;
DROP TABLE IF EXISTS `periode`;
DROP TABLE IF EXISTS `organisatie`;

SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
