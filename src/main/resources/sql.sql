INSERT INTO `organisatie` (`id`, `naam`) VALUES
(1, 'FNT-ICT');

INSERT INTO `cohort` (`id`, `jaar`, `organisatie_id`) VALUES
(1, '2015', NULL);

INSERT INTO `opleidingsprofiel` (`id`, `complexiteitsContext`, `complexiteitsInhoud`, `naam`, `zelfstandigheid`) VALUES
(1, '3', '3', 'Software and Information Enginering', '3'),
(2, '3', '3', 'Technische Informatica', '3'),
(3, '3', '3', 'Business IT and Management', '3'),
(4, '3', '3', 'System and Network Enginering', '3');

INSERT INTO `cursus` (`id`, `complexiteitsContext`, `complexiteitsInhoud`, `cursusCode`, `cursuscoordinator`, `europeanCredits`, `naam`, `periode`, `zelfstandigheid`) VALUES
(1, '3', '3', 'TICT-V1PROG-15', NULL, 5, 'Programming', 1, '3'),
(2, '3', '3', 'TICT-V1ICOR-15', NULL, 5, 'ICT and Organisation', 1, '3');

INSERT INTO `cohort_opleidingsprofiel` (`Cohort_id`, `opleidingsProfielen_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

INSERT INTO `opleidingsprofiel_cursus` (`OpleidingsProfiel_id`, `cursussen_id`) VALUES
(1, 1),
(1, 2);

INSERT INTO `organisatie_cohort` (`Organisatie_id`, `cohorten_id`) VALUES
(1, 1);

INSERT INTO `beroepstaak` (`activiteit`, `architectuurlaag`, `beschrijving`, `niveau`) VALUES
('Beheren', 'Gebruikersinteractie', 'Vanaf de start van product- of dienstontwikkeling rekening houden met productverantwoording, productcontext, continuïteit en overdracht naar de opdrachtgever en/of gebruikersomgeving.', 3),
('Beheren', 'Gebruikersinteractie', 'Het toepassen van versiebeheer en het inrichten en configureren van een samenwerkingsomgeving bij de realisatie van ict- en/of digitale mediaproducten,  rekening houdend met onderhoudbaarheid en daarvoor beschikbare middelen.', 2),
('Beheren', 'Gebruikersinteractie', 'Het inrichten en onderhouden van de eigen werkomgeving voor analyse, ontwerp en realisatie van ict- en/of digitale mediaproducten m.b.v. een gangbare tool. Het overdragen van een gedefinieerde versie van het eindproduct, inclusief productverantwoording, aan een opdrachtgever.', 2),
('Analyseren', 'Gebruikersinteractie', 'Het in kaart brengen van trends in communicatie en designrepertoire van ict- en/of digitale mediaproducten. Het opstellen van een analyserapportage (doelgroep, doelstelling, context, informatie- en communicatiebehoefte, visualisatie, bruikbaarheid en gebruik), en dit relateren aan trends in ict- en/of digitale mediaproducten.', 3),
('Analyseren', 'Gebruikersinteractie', '', 2),
('Analyseren', 'Gebruikersinteractie', '', 1),
('Adviseren', 'Gebruikersinteractie', '', 3),
('Adviseren', 'Gebruikersinteractie', '', 2),
('Adviseren', 'Gebruikersinteractie', '', 1),
('Ontwerpen', 'Gebruikersinteractie', '', 3),
('Ontwerpen', 'Gebruikersinteractie', '', 2),
('Ontwerpen', 'Gebruikersinteractie', '', 1),
('Realiseren', 'Gebruikersinteractie', '', 3),
('Realiseren', 'Gebruikersinteractie', '', 2),
('Realiseren', 'Gebruikersinteractie', '', 1),
('Beheren', 'Bedrijfsprocessen', '', 3),
('Beheren', 'Bedrijfsprocessen', '', 2),
('Beheren', 'Bedrijfsprocessen', '', 1),
('Analyseren', 'Bedrijfsprocessen', '', 3),
('Analyseren', 'Bedrijfsprocessen', '', 2),
('Analyseren', 'Bedrijfsprocessen', '', 2),
('Adviseren', 'Bedrijfsprocessen', '', 3),
('Adviseren', 'Bedrijfsprocessen', '', 2),
('Adviseren', 'Bedrijfsprocessen', '', 2),
('Ontwerpen', 'Bedrijfsprocessen', '', 3),
('Ontwerpen', 'Bedrijfsprocessen', '', 2),
('Ontwerpen', 'Bedrijfsprocessen', '', 2),
('Realiseren', 'Bedrijfsprocessen', '', 3),
('Realiseren', 'Bedrijfsprocessen', '', 2),
('Realiseren', 'Bedrijfsprocessen', '', 2),
('Beheren', 'Infrastructuur', '', 3),
('Beheren', 'Infrastructuur', '', 2),
('Beheren', 'Infrastructuur', '', 2),
('Analyseren', 'Infrastructuur', '', 3),
('Analyseren', 'Infrastructuur', '', 2),
('Analyseren', 'Infrastructuur', '', 2),
('Adviseren', 'Infrastructuur', '', 3),
('Adviseren', 'Infrastructuur', '', 2),
('Adviseren', 'Infrastructuur', '', 2),
('Ontwerpen', 'Infrastructuur', '', 3),
('Ontwerpen', 'Infrastructuur', '', 2),
('Ontwerpen', 'Infrastructuur', '', 2),
('Realiseren', 'Infrastructuur', '', 3),
('Realiseren', 'Infrastructuur', '', 2),
('Realiseren', 'Infrastructuur', '', 2),
('Beheren', 'Software', '', 3),
('Beheren', 'Software', '', 2),
('Beheren', 'Software', '', 2),
('Analyseren', 'Software', '', 3),
('Analyseren', 'Software', '', 2),
('Analyseren', 'Software', '', 2),
('Adviseren', 'Software', '', 3),
('Adviseren', 'Software', '', 2),
('Adviseren', 'Software', '', 2),
('Ontwerpen', 'Software', '', 3),
('Ontwerpen', 'Software', '', 2),
('Ontwerpen', 'Software', '', 2),
('Realiseren', 'Software', '', 3),
('Realiseren', 'Software', '', 2),
('Realiseren', 'Software', '', 2),
('Beheren', 'Hardware Interfacing', '', 3),
('Beheren', 'Hardware Interfacing', '', 2),
('Beheren', 'Hardware Interfacing', '', 2),
('Analyseren', 'Hardware Interfacing', '', 3),
('Analyseren', 'Hardware Interfacing', '', 2),
('Analyseren', 'Hardware Interfacing', '', 2),
('Adviseren', 'Hardware Interfacing', '', 3),
('Adviseren', 'Hardware Interfacing', '', 2),
('Adviseren', 'Hardware Interfacing', '', 2),
('Ontwerpen', 'Hardware Interfacing', '', 3),
('Ontwerpen', 'Hardware Interfacing', '', 2),
('Ontwerpen', 'Hardware Interfacing', '', 2),
('Realiseren', 'Hardware Interfacing', '', 3),
('Realiseren', 'Hardware Interfacing', '', 2),
('Realiseren', 'Hardware Interfacing', '', 2);

INSERT INTO `opleidingsprofiel_beroepstaak` (`OpleidingsProfiel_id`, `eindBT_id`) VALUES
(1, 13),
(1, 56),
(1, 31);