-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 22 jun 2018 om 12:31
-- Serverversie: 10.1.31-MariaDB
-- PHP-versie: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `curcon`
--

--
-- Gegevens worden geëxporteerd voor tabel `function`
--

INSERT INTO `function` (`id`, `name`) VALUES
(41, 'beroepstaken_get'),
(1, 'cursus_get'),
(23, 'cursussen_delete'),
(26, 'cursussen_get'),
(24, 'cursussen_post'),
(25, 'cursussen_put'),
(4, 'function_delete'),
(5, 'function_post'),
(6, 'function_put'),
(15, 'leerdoel_delete'),
(18, 'leerdoel_get'),
(16, 'leerdoel_post'),
(17, 'leerdoel_put'),
(14, 'leerdoelen_get'),
(8, 'module_get'),
(3, 'module_post'),
(9, 'module_put'),
(36, 'modulefunction_delete'),
(35, 'modulefunction_post'),
(19, 'opleidingsprofiel_delete'),
(22, 'opleidingsprofiel_get'),
(20, 'opleidingsprofiel_post'),
(21, 'opleidingsprofiel_put'),
(2, 'organisatie_get'),
(7, 'organisaties_get'),
(27, 'professional_delete'),
(30, 'professional_get'),
(28, 'professional_post'),
(29, 'professional_put'),
(31, 'professionals_get'),
(13, 'role_delete'),
(10, 'role_get'),
(11, 'role_post'),
(12, 'role_put'),
(38, 'rolemodule_delete'),
(37, 'rolemodule_post'),
(39, 'user_put');

--
-- Gegevens worden geëxporteerd voor tabel `function_module`
--

INSERT INTO `function_module` (`module_id`, `function_id`) VALUES
(1, 1),
(2, 5),
(3, 3),
(4, 11),
(5, 35),
(6, 37),
(7, 39),
(8, 41);

--
-- Gegevens worden geëxporteerd voor tabel `module`
--

INSERT INTO `module` (`id`, `name`) VALUES
(1, 'Module 1'),
(2, 'create function'),
(3, 'create module'),
(4, 'create role'),
(5, 'merge module function'),
(6, 'merge role module'),
(7, 'merge user role'),
(8, 'read beroepstaken');

--
-- Gegevens worden geëxporteerd voor tabel `module_role`
--

INSERT INTO `module_role` (`role_id`, `module_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(3, 8);

--
-- Gegevens worden geëxporteerd voor tabel `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(3, 'Cursus Coordinator'),
(2, 'Goon'),
(1, 'admin');

--
-- Gegevens worden geëxporteerd voor tabel `user`
--

INSERT INTO `user` (`username`, `role_id`) VALUES
('luccah06071@gmail.com', 1),
('luccah06072@gmail.com', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
