-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 23 mrt 2017 om 09:13
-- Serverversie: 10.1.21-MariaDB
-- PHP-versie: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `curcon`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beoordelingselement`
--

CREATE TABLE `beoordelingselement` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `omschrijving` varchar(255) DEFAULT NULL,
  `toets` tinyblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beoordelingselement_toetselement`
--

CREATE TABLE `beoordelingselement_toetselement` (
  `BeoordelingsElement_id` int(11) NOT NULL,
  `toetsElementen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beroepsproduct`
--

CREATE TABLE `beroepsproduct` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beroepstaak`
--

CREATE TABLE `beroepstaak` (
  `id` int(11) NOT NULL,
  `activiteit` varchar(255) DEFAULT NULL,
  `architectuurlaag` varchar(255) DEFAULT NULL,
  `beschrijving` longtext,
  `niveau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `beroepstaak`
--

INSERT INTO `beroepstaak` (`id`, `activiteit`, `architectuurlaag`, `beschrijving`, `niveau`) VALUES
(1, 'Beheren', 'Gebruikersinteractie', 'Vanaf de start van product- of dienstontwikkeling rekening houden met productverantwoording, productcontext, continuÃ¯teit en overdracht naar de opdrachtgever en/of gebruikersomgeving.', 3),
(2, 'Beheren', 'Gebruikersinteractie', 'Het toepassen van versiebeheer en het inrichten en configureren van een samenwerkingsomgeving bij de realisatie van ict- en/of digitale mediaproducten,  rekening houdend met onderhoudbaarheid en daarvoor beschikbare middelen.', 2),
(3, 'Beheren', 'Gebruikersinteractie', 'Het inrichten en onderhouden van de eigen werkomgeving voor analyse, ontwerp en realisatie van ict- en/of digitale mediaproducten m.b.v. een gangbare tool. Het overdragen van een gedefinieerde versie van het eindproduct, inclusief productverantwoording, aan een opdrachtgever.', 1),
(4, 'Analyseren', 'Gebruikersinteractie', 'Het in kaart brengen van trends in communicatie en designrepertoire van ict- en/of digitale mediaproducten. Het opstellen van een analyserapportage (doelgroep, doelstelling, context, informatie- en communicatiebehoefte, visualisatie, bruikbaarheid en gebruik), en dit relateren aan trends in ict- en/of digitale mediaproducten.', 3),
(5, 'Analyseren', 'Gebruikersinteractie', '', 2),
(6, 'Analyseren', 'Gebruikersinteractie', '', 1),
(7, 'Adviseren', 'Gebruikersinteractie', '', 3),
(8, 'Adviseren', 'Gebruikersinteractie', '', 2),
(9, 'Adviseren', 'Gebruikersinteractie', '', 1),
(10, 'Ontwerpen', 'Gebruikersinteractie', '', 3),
(11, 'Ontwerpen', 'Gebruikersinteractie', '', 2),
(12, 'Ontwerpen', 'Gebruikersinteractie', '', 1),
(13, 'Realiseren', 'Gebruikersinteractie', '', 3),
(14, 'Realiseren', 'Gebruikersinteractie', '', 2),
(15, 'Realiseren', 'Gebruikersinteractie', '', 1),
(16, 'Beheren', 'Bedrijfsprocessen', '', 3),
(17, 'Beheren', 'Bedrijfsprocessen', '', 2),
(18, 'Beheren', 'Bedrijfsprocessen', '', 1),
(19, 'Analyseren', 'Bedrijfsprocessen', '', 3),
(20, 'Analyseren', 'Bedrijfsprocessen', '', 2),
(21, 'Analyseren', 'Bedrijfsprocessen', '', 1),
(22, 'Adviseren', 'Bedrijfsprocessen', '', 3),
(23, 'Adviseren', 'Bedrijfsprocessen', '', 2),
(24, 'Adviseren', 'Bedrijfsprocessen', '', 1),
(25, 'Ontwerpen', 'Bedrijfsprocessen', '', 3),
(26, 'Ontwerpen', 'Bedrijfsprocessen', '', 2),
(27, 'Ontwerpen', 'Bedrijfsprocessen', '', 1),
(28, 'Realiseren', 'Bedrijfsprocessen', '', 3),
(29, 'Realiseren', 'Bedrijfsprocessen', '', 2),
(30, 'Realiseren', 'Bedrijfsprocessen', '', 1),
(31, 'Beheren', 'Infrastructuur', '', 3),
(32, 'Beheren', 'Infrastructuur', '', 2),
(33, 'Beheren', 'Infrastructuur', '', 1),
(34, 'Analyseren', 'Infrastructuur', '', 3),
(35, 'Analyseren', 'Infrastructuur', '', 2),
(36, 'Analyseren', 'Infrastructuur', '', 1),
(37, 'Adviseren', 'Infrastructuur', '', 3),
(38, 'Adviseren', 'Infrastructuur', '', 2),
(39, 'Adviseren', 'Infrastructuur', '', 1),
(40, 'Ontwerpen', 'Infrastructuur', '', 3),
(41, 'Ontwerpen', 'Infrastructuur', '', 2),
(42, 'Ontwerpen', 'Infrastructuur', '', 1),
(43, 'Realiseren', 'Infrastructuur', '', 3),
(44, 'Realiseren', 'Infrastructuur', '', 2),
(45, 'Realiseren', 'Infrastructuur', '', 1),
(46, 'Beheren', 'Software', '', 3),
(47, 'Beheren', 'Software', '', 2),
(48, 'Beheren', 'Software', '', 1),
(49, 'Analyseren', 'Software', '', 3),
(50, 'Analyseren', 'Software', '', 2),
(51, 'Analyseren', 'Software', '', 1),
(52, 'Adviseren', 'Software', '', 3),
(53, 'Adviseren', 'Software', '', 2),
(54, 'Adviseren', 'Software', '', 1),
(55, 'Ontwerpen', 'Software', '', 3),
(56, 'Ontwerpen', 'Software', '', 2),
(57, 'Ontwerpen', 'Software', '', 1),
(58, 'Realiseren', 'Software', '', 3),
(59, 'Realiseren', 'Software', '', 2),
(60, 'Realiseren', 'Software', '', 1),
(61, 'Beheren', 'Hardware Interfacing', '', 3),
(62, 'Beheren', 'Hardware Interfacing', '', 2),
(63, 'Beheren', 'Hardware Interfacing', '', 1),
(64, 'Analyseren', 'Hardware Interfacing', '', 3),
(65, 'Analyseren', 'Hardware Interfacing', '', 2),
(66, 'Analyseren', 'Hardware Interfacing', '', 1),
(67, 'Adviseren', 'Hardware Interfacing', '', 3),
(68, 'Adviseren', 'Hardware Interfacing', '', 2),
(69, 'Adviseren', 'Hardware Interfacing', '', 1),
(70, 'Ontwerpen', 'Hardware Interfacing', '', 3),
(71, 'Ontwerpen', 'Hardware Interfacing', '', 2),
(72, 'Ontwerpen', 'Hardware Interfacing', '', 1),
(73, 'Realiseren', 'Hardware Interfacing', '', 3),
(74, 'Realiseren', 'Hardware Interfacing', '', 2),
(75, 'Realiseren', 'Hardware Interfacing', '', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bloomniveau`
--

CREATE TABLE `bloomniveau` (
  `id` int(11) NOT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  `omschrijving` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `bloomniveau`
--

INSERT INTO `bloomniveau` (`id`, `niveau`, `omschrijving`) VALUES
(1, 'Onthouden', ''),
(2, 'Begrijpen', ''),
(3, 'Toepassen', ''),
(4, 'Analyseren', ''),
(5, 'Evalueren', ''),
(6, 'CreÃ«ren', '');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cohort`
--

CREATE TABLE `cohort` (
  `id` int(11) NOT NULL,
  `jaar` varchar(255) DEFAULT NULL,
  `opleidingsProfiel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cohort`
--

INSERT INTO `cohort` (`id`, `jaar`, `opleidingsProfiel_id`) VALUES
(1, '2014', 2),
(2, '2015', 2),
(3, '2016', 2),
(4, '2017', 2),
(5, '2018', 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cohort_cursus`
--

CREATE TABLE `cohort_cursus` (
  `cohort_id` int(11) NOT NULL,
  `cursussen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cohort_cursus`
--

INSERT INTO `cohort_cursus` (`cohort_id`, `cursussen_id`) VALUES
(2, 1),
(2, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus`
--

CREATE TABLE `cursus` (
  `id` int(11) NOT NULL,
  `cursuscode` varchar(255) DEFAULT NULL,
  `ects` int(11) DEFAULT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `periode` int(11) DEFAULT NULL,
  `docent_id` int(11) DEFAULT NULL,
  `organisatie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cursus`
--

INSERT INTO `cursus` (`id`, `cursuscode`, `ects`, `naam`, `periode`, `docent_id`, `organisatie_id`) VALUES
(1, 'TICT-V1PROG-15', 5, 'Programming', 1, 1, NULL),
(2, 'TICT-V1ICOR-15', 5, 'ICT and Organisation', 1, 1, NULL),
(3, 'TICT-V1CSN-15', 5, 'Computer, system and network', 1, 1, NULL),
(4, 'TICT-V1MOD-15', 5, 'Modelling', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus_beroepstaak`
--

CREATE TABLE `cursus_beroepstaak` (
  `cursus_id` int(11) NOT NULL,
  `eindBTs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cursus_beroepstaak`
--

INSERT INTO `cursus_beroepstaak` (`cursus_id`, `eindBTs_id`) VALUES
(1, 6),
(1, 10),
(1, 21),
(2, 45),
(2, 46),
(2, 67),
(3, 11),
(3, 34),
(4, 35),
(4, 55);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus_onderwerp`
--

CREATE TABLE `cursus_onderwerp` (
  `cursus_id` int(11) NOT NULL,
  `onderwerpen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus_professionalskill`
--

CREATE TABLE `cursus_professionalskill` (
  `cursus_id` int(11) NOT NULL,
  `eindPSs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `cursus_professionalskill`
--

INSERT INTO `cursus_professionalskill` (`cursus_id`, `eindPSs_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `docent`
--

CREATE TABLE `docent` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `organisatie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `docent`
--

INSERT INTO `docent` (`id`, `naam`, `organisatie_id`) VALUES
(1, 'Berend Wilkens', 1),
(2, 'Leo Pruijt', 1),
(3, 'Dan Greve', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geslotenvraag`
--

CREATE TABLE `geslotenvraag` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `leerdoel`
--

CREATE TABLE `leerdoel` (
  `id` int(11) NOT NULL,
  `eindBT` tinyblob,
  `eindPS` tinyblob,
  `omschrijving` varchar(255) DEFAULT NULL,
  `toetsPlanning` tinyblob,
  `bloomniveau_id` int(11) NOT NULL,
  `cursus_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `leerdoel`
--

INSERT INTO `leerdoel` (`id`, `eindBT`, `eindPS`, `omschrijving`, `toetsPlanning`, `bloomniveau_id`, `cursus_id`) VALUES
(1, NULL, NULL, 'Grafische webinterfaces bouwen met behulp van het J2EE framework (servlets en Java Server Pages) en kan een J2EE frontendframework toepassen (Struts2).', NULL, 2, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `leerlijn`
--

CREATE TABLE `leerlijn` (
  `Id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `leerlijn_onderwerp`
--

CREATE TABLE `leerlijn_onderwerp` (
  `Leerlijn_Id` int(11) NOT NULL,
  `onderwerpen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `onderwerp`
--

CREATE TABLE `onderwerp` (
  `id` int(11) NOT NULL,
  `leerlijn` tinyblob,
  `trefwoord` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `onderwerp_cursus`
--

CREATE TABLE `onderwerp_cursus` (
  `Onderwerp_id` int(11) NOT NULL,
  `cursussen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `openvraag`
--

CREATE TABLE `openvraag` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel`
--

CREATE TABLE `opleidingsprofiel` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `organisatie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `opleidingsprofiel`
--

INSERT INTO `opleidingsprofiel` (`id`, `naam`, `organisatie_id`) VALUES
(1, 'Business IT and Management', 1),
(2, 'Software and Information Enginering', 1),
(3, 'System and Network Enginering', 1),
(4, 'Technische Informatica', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel_beroepstaak`
--

CREATE TABLE `opleidingsprofiel_beroepstaak` (
  `OpleidingsProfiel_id` int(11) NOT NULL,
  `Beroepstaak_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `opleidingsprofiel_beroepstaak`
--

INSERT INTO `opleidingsprofiel_beroepstaak` (`OpleidingsProfiel_id`, `Beroepstaak_id`) VALUES
(1, 1),
(1, 5),
(1, 7),
(1, 11),
(1, 45);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel_cohort`
--

CREATE TABLE `opleidingsprofiel_cohort` (
  `opleidingsprofiel_id` int(11) NOT NULL,
  `cohorten_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel_leerlijn`
--

CREATE TABLE `opleidingsprofiel_leerlijn` (
  `opleidingsprofiel_id` int(11) NOT NULL,
  `leerlijnen_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel_professionalskill`
--

CREATE TABLE `opleidingsprofiel_professionalskill` (
  `opleidingsprofiel_id` int(11) NOT NULL,
  `eindPS_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `opleidingsprofiel_professionalskill`
--

INSERT INTO `opleidingsprofiel_professionalskill` (`opleidingsprofiel_id`, `eindPS_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organisatie`
--

CREATE TABLE `organisatie` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `organisatie`
--

INSERT INTO `organisatie` (`id`, `naam`) VALUES
(1, 'Hogeschool Utrecht I-ICT');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organisatie_beroepstaak`
--

CREATE TABLE `organisatie_beroepstaak` (
  `organisatie_id` int(11) NOT NULL,
  `alleBeroepsTaken_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organisatie_cursus`
--

CREATE TABLE `organisatie_cursus` (
  `organisatie_id` int(11) NOT NULL,
  `alleCursussen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `organisatie_professionalskill`
--

CREATE TABLE `organisatie_professionalskill` (
  `organisatie_id` int(11) NOT NULL,
  `alleProfessionalSkills_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `osirisresultaattype`
--

CREATE TABLE `osirisresultaattype` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `omschrijving` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `periode`
--

CREATE TABLE `periode` (
  `id` int(11) NOT NULL,
  `periode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `professionalskill`
--

CREATE TABLE `professionalskill` (
  `id` int(11) NOT NULL,
  `beschrijving` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `niveau` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `professionalskill`
--

INSERT INTO `professionalskill` (`id`, `beschrijving`, `code`, `niveau`) VALUES
(1, 'Creatief problemen oplossen', 'CP', 'T');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toets`
--

CREATE TABLE `toets` (
  `DTYPE` varchar(31) NOT NULL,
  `toets_id` int(11) NOT NULL,
  `gewicht` double DEFAULT NULL,
  `osirisResultaatType` tinyblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toetselement`
--

CREATE TABLE `toetselement` (
  `id` int(11) NOT NULL,
  `gewicht` double DEFAULT NULL,
  `beoordelingselement_id` int(11) DEFAULT NULL,
  `bloomNiveau_id` int(11) DEFAULT NULL,
  `leerdoel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toetsplanning`
--

CREATE TABLE `toetsplanning` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toetsplanning_toetselement`
--

CREATE TABLE `toetsplanning_toetselement` (
  `ToetsPlanning_id` int(11) NOT NULL,
  `toetsElementen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toets_beroepsproduct`
--

CREATE TABLE `toets_beroepsproduct` (
  `Toets_toets_id` int(11) NOT NULL,
  `beroepsProducten_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toets_geslotenvraag`
--

CREATE TABLE `toets_geslotenvraag` (
  `Toets_toets_id` int(11) NOT NULL,
  `geslotenVragen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toets_openvraag`
--

CREATE TABLE `toets_openvraag` (
  `Toets_toets_id` int(11) NOT NULL,
  `openVragen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `beoordelingselement`
--
ALTER TABLE `beoordelingselement`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `beoordelingselement_toetselement`
--
ALTER TABLE `beoordelingselement_toetselement`
  ADD UNIQUE KEY `UK_q1wfcf17lde4nberhgydtin67` (`toetsElementen_id`),
  ADD KEY `FK_astwpup2huwxr31sml4ogg875` (`BeoordelingsElement_id`);

--
-- Indexen voor tabel `beroepsproduct`
--
ALTER TABLE `beroepsproduct`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `beroepstaak`
--
ALTER TABLE `beroepstaak`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `bloomniveau`
--
ALTER TABLE `bloomniveau`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `cohort`
--
ALTER TABLE `cohort`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ccgxpn709nmyigkaf1xvulkim` (`opleidingsProfiel_id`);

--
-- Indexen voor tabel `cohort_cursus`
--
ALTER TABLE `cohort_cursus`
  ADD KEY `FK_t44j7yrbfl9sp7235bwknco9y` (`cursussen_id`),
  ADD KEY `FK_3ekqp6i61q8vi3oaaqfqnoc74` (`cohort_id`);

--
-- Indexen voor tabel `cursus`
--
ALTER TABLE `cursus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_cc59u321ynva95rvvv9onj6ec` (`docent_id`),
  ADD KEY `FK_hw0degphskbobm4m9wpfieoca` (`organisatie_id`);

--
-- Indexen voor tabel `cursus_beroepstaak`
--
ALTER TABLE `cursus_beroepstaak`
  ADD KEY `FK_irfq85i0voi3q4v7ijw55222o` (`eindBTs_id`),
  ADD KEY `FK_gmqaje32vtdsjbkwfu7nwl4ry` (`cursus_id`);

--
-- Indexen voor tabel `cursus_onderwerp`
--
ALTER TABLE `cursus_onderwerp`
  ADD KEY `FK_dw20bfo2rb2hbpad054gqtf10` (`onderwerpen_id`),
  ADD KEY `FK_qkq72mhh52x8icv6fgqypjjte` (`cursus_id`);

--
-- Indexen voor tabel `cursus_professionalskill`
--
ALTER TABLE `cursus_professionalskill`
  ADD KEY `FK_2h9c9xvpx3s8fjk6ruprdw0wf` (`eindPSs_id`),
  ADD KEY `FK_fd194moq3x5vxboyvvgovph8l` (`cursus_id`);

--
-- Indexen voor tabel `docent`
--
ALTER TABLE `docent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ioulcs791yeqanu0v3fvkk6kj` (`organisatie_id`);

--
-- Indexen voor tabel `geslotenvraag`
--
ALTER TABLE `geslotenvraag`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `leerdoel`
--
ALTER TABLE `leerdoel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_m9pfuqrycghb0snvostmfvogc` (`bloomniveau_id`),
  ADD KEY `FK_37pv9eeavdemclsrytoqt8jwy` (`cursus_id`);

--
-- Indexen voor tabel `leerlijn`
--
ALTER TABLE `leerlijn`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `leerlijn_onderwerp`
--
ALTER TABLE `leerlijn_onderwerp`
  ADD UNIQUE KEY `UK_gqaq2wd0t98iru5nkmv5e2wyp` (`onderwerpen_id`),
  ADD KEY `FK_1pc90xgya5s1r3mt6f6nb7yqu` (`Leerlijn_Id`);

--
-- Indexen voor tabel `onderwerp`
--
ALTER TABLE `onderwerp`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `onderwerp_cursus`
--
ALTER TABLE `onderwerp_cursus`
  ADD UNIQUE KEY `UK_qvko05812negb0j9px6q61x92` (`cursussen_id`),
  ADD KEY `FK_2l2ee2k2fnu71ovvdlolr10fe` (`Onderwerp_id`);

--
-- Indexen voor tabel `openvraag`
--
ALTER TABLE `openvraag`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `opleidingsprofiel`
--
ALTER TABLE `opleidingsprofiel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_i9erap1k01585f538c91jixjc` (`organisatie_id`);

--
-- Indexen voor tabel `opleidingsprofiel_beroepstaak`
--
ALTER TABLE `opleidingsprofiel_beroepstaak`
  ADD KEY `FK_8e29jaxmpjbnf696sd77dx20o` (`Beroepstaak_id`),
  ADD KEY `FK_6mbfnqs6of1ilcmtndsf0k2al` (`OpleidingsProfiel_id`);

--
-- Indexen voor tabel `opleidingsprofiel_cohort`
--
ALTER TABLE `opleidingsprofiel_cohort`
  ADD UNIQUE KEY `UK_kw1xdvsafc8n7x7otwe66o2de` (`cohorten_id`),
  ADD KEY `FK_i2og4n9rcna0qpn0gsbi4s66y` (`opleidingsprofiel_id`);

--
-- Indexen voor tabel `opleidingsprofiel_leerlijn`
--
ALTER TABLE `opleidingsprofiel_leerlijn`
  ADD UNIQUE KEY `UK_lm34wq0bn32tvc76cu7wuttda` (`leerlijnen_Id`),
  ADD KEY `FK_o9hup5xdk59dynmrbmu5smglb` (`opleidingsprofiel_id`);

--
-- Indexen voor tabel `opleidingsprofiel_professionalskill`
--
ALTER TABLE `opleidingsprofiel_professionalskill`
  ADD KEY `FK_ltqs8rts7qq64k3scf66pha7i` (`eindPS_id`),
  ADD KEY `FK_lu0op8xyicl02p5xwloffkxqm` (`opleidingsprofiel_id`);

--
-- Indexen voor tabel `organisatie`
--
ALTER TABLE `organisatie`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `organisatie_beroepstaak`
--
ALTER TABLE `organisatie_beroepstaak`
  ADD UNIQUE KEY `UK_hocdlu4u5q4j1tbu8dgfnf7nl` (`alleBeroepsTaken_id`),
  ADD KEY `FK_2db5g96ixkptp5lt5qw880ykm` (`organisatie_id`);

--
-- Indexen voor tabel `organisatie_cursus`
--
ALTER TABLE `organisatie_cursus`
  ADD UNIQUE KEY `UK_r454xv1d7410cklsd3bqgbkrf` (`alleCursussen_id`),
  ADD KEY `FK_fvyg65456495y0pwh7obet5tt` (`organisatie_id`);

--
-- Indexen voor tabel `organisatie_professionalskill`
--
ALTER TABLE `organisatie_professionalskill`
  ADD UNIQUE KEY `UK_5ysvn6ekthr1g5m97x3owpgjh` (`alleProfessionalSkills_id`),
  ADD KEY `FK_41np2n3am9g6g669fm5v5tegf` (`organisatie_id`);

--
-- Indexen voor tabel `osirisresultaattype`
--
ALTER TABLE `osirisresultaattype`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `periode`
--
ALTER TABLE `periode`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `professionalskill`
--
ALTER TABLE `professionalskill`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `toets`
--
ALTER TABLE `toets`
  ADD PRIMARY KEY (`toets_id`);

--
-- Indexen voor tabel `toetselement`
--
ALTER TABLE `toetselement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_dki0wnhtluj36pl0vvdv0qqxa` (`beoordelingselement_id`),
  ADD KEY `FK_wi3vpcbct1v9587tq1kno3ny` (`bloomNiveau_id`),
  ADD KEY `FK_2bbywfe3ian6qcg23gty34u5p` (`leerdoel_id`);

--
-- Indexen voor tabel `toetsplanning`
--
ALTER TABLE `toetsplanning`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `toetsplanning_toetselement`
--
ALTER TABLE `toetsplanning_toetselement`
  ADD UNIQUE KEY `UK_b0t4joc4wp6l66ur4uvl78lcs` (`toetsElementen_id`),
  ADD KEY `FK_fckqk8fm4f429jqeaky4c1r06` (`ToetsPlanning_id`);

--
-- Indexen voor tabel `toets_beroepsproduct`
--
ALTER TABLE `toets_beroepsproduct`
  ADD UNIQUE KEY `UK_tm9car2a77pgfcu1dgtbl9cnf` (`beroepsProducten_id`),
  ADD KEY `FK_8xo0oldv5m6vmi84146mlh1wo` (`Toets_toets_id`);

--
-- Indexen voor tabel `toets_geslotenvraag`
--
ALTER TABLE `toets_geslotenvraag`
  ADD UNIQUE KEY `UK_cu8c5jcdf8iauvt2csfd51gkw` (`geslotenVragen_id`),
  ADD KEY `FK_mhdl32rpyfqhev3v29lct3u0y` (`Toets_toets_id`);

--
-- Indexen voor tabel `toets_openvraag`
--
ALTER TABLE `toets_openvraag`
  ADD UNIQUE KEY `UK_jv6wrvg64fkivq724uhrhrv5f` (`openVragen_id`),
  ADD KEY `FK_9wcabhjyhr5re37kij58w6nfo` (`Toets_toets_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `beoordelingselement`
--
ALTER TABLE `beoordelingselement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `beroepstaak`
--
ALTER TABLE `beroepstaak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT voor een tabel `bloomniveau`
--
ALTER TABLE `bloomniveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT voor een tabel `cohort`
--
ALTER TABLE `cohort`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT voor een tabel `cursus`
--
ALTER TABLE `cursus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT voor een tabel `docent`
--
ALTER TABLE `docent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `leerdoel`
--
ALTER TABLE `leerdoel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `leerlijn`
--
ALTER TABLE `leerlijn`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `onderwerp`
--
ALTER TABLE `onderwerp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `opleidingsprofiel`
--
ALTER TABLE `opleidingsprofiel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT voor een tabel `organisatie`
--
ALTER TABLE `organisatie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `osirisresultaattype`
--
ALTER TABLE `osirisresultaattype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `periode`
--
ALTER TABLE `periode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `professionalskill`
--
ALTER TABLE `professionalskill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `toets`
--
ALTER TABLE `toets`
  MODIFY `toets_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `toetselement`
--
ALTER TABLE `toetselement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `toetsplanning`
--
ALTER TABLE `toetsplanning`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `beoordelingselement_toetselement`
--
ALTER TABLE `beoordelingselement_toetselement`
  ADD CONSTRAINT `FK_astwpup2huwxr31sml4ogg875` FOREIGN KEY (`BeoordelingsElement_id`) REFERENCES `beoordelingselement` (`id`),
  ADD CONSTRAINT `FK_q1wfcf17lde4nberhgydtin67` FOREIGN KEY (`toetsElementen_id`) REFERENCES `toetselement` (`id`);

--
-- Beperkingen voor tabel `beroepsproduct`
--
ALTER TABLE `beroepsproduct`
  ADD CONSTRAINT `FK_sui24eyv9h3x6tfpif7ti7yxm` FOREIGN KEY (`id`) REFERENCES `beoordelingselement` (`id`);

--
-- Beperkingen voor tabel `cohort`
--
ALTER TABLE `cohort`
  ADD CONSTRAINT `FK_ccgxpn709nmyigkaf1xvulkim` FOREIGN KEY (`opleidingsProfiel_id`) REFERENCES `opleidingsprofiel` (`id`);

--
-- Beperkingen voor tabel `cohort_cursus`
--
ALTER TABLE `cohort_cursus`
  ADD CONSTRAINT `FK_3ekqp6i61q8vi3oaaqfqnoc74` FOREIGN KEY (`cohort_id`) REFERENCES `cohort` (`id`),
  ADD CONSTRAINT `FK_t44j7yrbfl9sp7235bwknco9y` FOREIGN KEY (`cursussen_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `cursus`
--
ALTER TABLE `cursus`
  ADD CONSTRAINT `FK_cc59u321ynva95rvvv9onj6ec` FOREIGN KEY (`docent_id`) REFERENCES `docent` (`id`),
  ADD CONSTRAINT `FK_hw0degphskbobm4m9wpfieoca` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`);

--
-- Beperkingen voor tabel `cursus_beroepstaak`
--
ALTER TABLE `cursus_beroepstaak`
  ADD CONSTRAINT `FK_gmqaje32vtdsjbkwfu7nwl4ry` FOREIGN KEY (`cursus_id`) REFERENCES `cursus` (`id`),
  ADD CONSTRAINT `FK_irfq85i0voi3q4v7ijw55222o` FOREIGN KEY (`eindBTs_id`) REFERENCES `beroepstaak` (`id`);

--
-- Beperkingen voor tabel `cursus_onderwerp`
--
ALTER TABLE `cursus_onderwerp`
  ADD CONSTRAINT `FK_dw20bfo2rb2hbpad054gqtf10` FOREIGN KEY (`onderwerpen_id`) REFERENCES `onderwerp` (`id`),
  ADD CONSTRAINT `FK_qkq72mhh52x8icv6fgqypjjte` FOREIGN KEY (`cursus_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `cursus_professionalskill`
--
ALTER TABLE `cursus_professionalskill`
  ADD CONSTRAINT `FK_2h9c9xvpx3s8fjk6ruprdw0wf` FOREIGN KEY (`eindPSs_id`) REFERENCES `professionalskill` (`id`),
  ADD CONSTRAINT `FK_fd194moq3x5vxboyvvgovph8l` FOREIGN KEY (`cursus_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `docent`
--
ALTER TABLE `docent`
  ADD CONSTRAINT `FK_ioulcs791yeqanu0v3fvkk6kj` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`);

--
-- Beperkingen voor tabel `geslotenvraag`
--
ALTER TABLE `geslotenvraag`
  ADD CONSTRAINT `FK_o6e2p9e86t4v5dvvms4y76ddt` FOREIGN KEY (`id`) REFERENCES `beoordelingselement` (`id`);

--
-- Beperkingen voor tabel `leerdoel`
--
ALTER TABLE `leerdoel`
  ADD CONSTRAINT `FK_37pv9eeavdemclsrytoqt8jwy` FOREIGN KEY (`cursus_id`) REFERENCES `cursus` (`id`),
  ADD CONSTRAINT `FK_m9pfuqrycghb0snvostmfvogc` FOREIGN KEY (`bloomniveau_id`) REFERENCES `bloomniveau` (`id`);

--
-- Beperkingen voor tabel `leerlijn_onderwerp`
--
ALTER TABLE `leerlijn_onderwerp`
  ADD CONSTRAINT `FK_1pc90xgya5s1r3mt6f6nb7yqu` FOREIGN KEY (`Leerlijn_Id`) REFERENCES `leerlijn` (`Id`),
  ADD CONSTRAINT `FK_gqaq2wd0t98iru5nkmv5e2wyp` FOREIGN KEY (`onderwerpen_id`) REFERENCES `onderwerp` (`id`);

--
-- Beperkingen voor tabel `onderwerp_cursus`
--
ALTER TABLE `onderwerp_cursus`
  ADD CONSTRAINT `FK_2l2ee2k2fnu71ovvdlolr10fe` FOREIGN KEY (`Onderwerp_id`) REFERENCES `onderwerp` (`id`),
  ADD CONSTRAINT `FK_qvko05812negb0j9px6q61x92` FOREIGN KEY (`cursussen_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `openvraag`
--
ALTER TABLE `openvraag`
  ADD CONSTRAINT `FK_l5r8xnhiknqo27qwj3poixd0m` FOREIGN KEY (`id`) REFERENCES `beoordelingselement` (`id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_beroepstaak`
--
ALTER TABLE `opleidingsprofiel_beroepstaak`
  ADD CONSTRAINT `FK_6mbfnqs6of1ilcmtndsf0k2al` FOREIGN KEY (`OpleidingsProfiel_id`) REFERENCES `opleidingsprofiel` (`id`),
  ADD CONSTRAINT `FK_8e29jaxmpjbnf696sd77dx20o` FOREIGN KEY (`Beroepstaak_id`) REFERENCES `beroepstaak` (`id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_cohort`
--
ALTER TABLE `opleidingsprofiel_cohort`
  ADD CONSTRAINT `FK_i2og4n9rcna0qpn0gsbi4s66y` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`),
  ADD CONSTRAINT `FK_kw1xdvsafc8n7x7otwe66o2de` FOREIGN KEY (`cohorten_id`) REFERENCES `cohort` (`id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_leerlijn`
--
ALTER TABLE `opleidingsprofiel_leerlijn`
  ADD CONSTRAINT `FK_lm34wq0bn32tvc76cu7wuttda` FOREIGN KEY (`leerlijnen_Id`) REFERENCES `leerlijn` (`Id`),
  ADD CONSTRAINT `FK_o9hup5xdk59dynmrbmu5smglb` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_professionalskill`
--
ALTER TABLE `opleidingsprofiel_professionalskill`
  ADD CONSTRAINT `FK_ltqs8rts7qq64k3scf66pha7i` FOREIGN KEY (`eindPS_id`) REFERENCES `professionalskill` (`id`),
  ADD CONSTRAINT `FK_lu0op8xyicl02p5xwloffkxqm` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`);

--
-- Beperkingen voor tabel `organisatie_beroepstaak`
--
ALTER TABLE `organisatie_beroepstaak`
  ADD CONSTRAINT `FK_2db5g96ixkptp5lt5qw880ykm` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`),
  ADD CONSTRAINT `FK_hocdlu4u5q4j1tbu8dgfnf7nl` FOREIGN KEY (`alleBeroepsTaken_id`) REFERENCES `beroepstaak` (`id`);

--
-- Beperkingen voor tabel `organisatie_cursus`
--
ALTER TABLE `organisatie_cursus`
  ADD CONSTRAINT `FK_fvyg65456495y0pwh7obet5tt` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`),
  ADD CONSTRAINT `FK_r454xv1d7410cklsd3bqgbkrf` FOREIGN KEY (`alleCursussen_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `organisatie_professionalskill`
--
ALTER TABLE `organisatie_professionalskill`
  ADD CONSTRAINT `FK_41np2n3am9g6g669fm5v5tegf` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`),
  ADD CONSTRAINT `FK_5ysvn6ekthr1g5m97x3owpgjh` FOREIGN KEY (`alleProfessionalSkills_id`) REFERENCES `professionalskill` (`id`);

--
-- Beperkingen voor tabel `toetselement`
--
ALTER TABLE `toetselement`
  ADD CONSTRAINT `FK_2bbywfe3ian6qcg23gty34u5p` FOREIGN KEY (`leerdoel_id`) REFERENCES `leerdoel` (`id`),
  ADD CONSTRAINT `FK_dki0wnhtluj36pl0vvdv0qqxa` FOREIGN KEY (`beoordelingselement_id`) REFERENCES `beoordelingselement` (`id`),
  ADD CONSTRAINT `FK_wi3vpcbct1v9587tq1kno3ny` FOREIGN KEY (`bloomNiveau_id`) REFERENCES `bloomniveau` (`id`);

--
-- Beperkingen voor tabel `toetsplanning_toetselement`
--
ALTER TABLE `toetsplanning_toetselement`
  ADD CONSTRAINT `FK_b0t4joc4wp6l66ur4uvl78lcs` FOREIGN KEY (`toetsElementen_id`) REFERENCES `toetselement` (`id`),
  ADD CONSTRAINT `FK_fckqk8fm4f429jqeaky4c1r06` FOREIGN KEY (`ToetsPlanning_id`) REFERENCES `toetsplanning` (`id`);

--
-- Beperkingen voor tabel `toets_beroepsproduct`
--
ALTER TABLE `toets_beroepsproduct`
  ADD CONSTRAINT `FK_8xo0oldv5m6vmi84146mlh1wo` FOREIGN KEY (`Toets_toets_id`) REFERENCES `toets` (`toets_id`),
  ADD CONSTRAINT `FK_tm9car2a77pgfcu1dgtbl9cnf` FOREIGN KEY (`beroepsProducten_id`) REFERENCES `beroepsproduct` (`id`);

--
-- Beperkingen voor tabel `toets_geslotenvraag`
--
ALTER TABLE `toets_geslotenvraag`
  ADD CONSTRAINT `FK_cu8c5jcdf8iauvt2csfd51gkw` FOREIGN KEY (`geslotenVragen_id`) REFERENCES `geslotenvraag` (`id`),
  ADD CONSTRAINT `FK_mhdl32rpyfqhev3v29lct3u0y` FOREIGN KEY (`Toets_toets_id`) REFERENCES `toets` (`toets_id`);

--
-- Beperkingen voor tabel `toets_openvraag`
--
ALTER TABLE `toets_openvraag`
  ADD CONSTRAINT `FK_9wcabhjyhr5re37kij58w6nfo` FOREIGN KEY (`Toets_toets_id`) REFERENCES `toets` (`toets_id`),
  ADD CONSTRAINT `FK_jv6wrvg64fkivq724uhrhrv5f` FOREIGN KEY (`openVragen_id`) REFERENCES `openvraag` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
