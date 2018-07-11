-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 10 apr 2018 om 23:02
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

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `activiteit`
--
CREATE DATABASE  IF NOT EXISTS `jpa_manytomany`;
USE `jpa_manytomany`;

--
-- Table structure for table `book`
--

CREATE TABLE `function` (
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `function_module` (
  `function_name` varchar(255) unsigned NOT NULL,
  `module_name` varchar(255) unsigned NOT NULL,
  PRIMARY KEY (`function_name`,`module_name`),
  KEY `fk_functionmodule_function_name` (`function_name`),
  CONSTRAINT `fk_functionmodule_function` FOREIGN KEY (`function_name`) REFERENCES `function` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_functionmodule_module` FOREIGN KEY (`module_name`) REFERENCES `module` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `module` (
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `module_role`;
CREATE TABLE `book_publisher` (
  `module_name` varchar(255) unsigned NOT NULL,
  `role_name` varchar(255) unsigned NOT NULL,
  PRIMARY KEY (`module_name`,`role_name`),
  KEY `fk_modulerole_role_name` (`role_name`),
  CONSTRAINT `fk_modulerole_module` FOREIGN KEY (`module_name`) REFERENCES `module` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_modulerole_role` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `Role` (
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `activiteit` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `omschrijving` longtext COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `activiteit`
--

INSERT INTO `activiteit` (`id`, `naam`, `omschrijving`) VALUES
(1, 'Beheren', 'Het beheersbaar laten verlopen van alle activiteiten gericht op het proces van ontwikkeling, ingebruikname en gebruik van ict-systemen.'),
(2, 'Analyseren', 'Het analyseren van processen, producten en informatiestromen  in hun onderlinge samenhang en de context van de omgeving.'),
(3, 'Adviseren', 'Het adviseren over de herinrichting van processen en/of informatiestromen  en voor een nieuw te ontwikkelen of aan te schaffen ict-systeem op basis van een analyse en in overleg met stakeholders.'),
(4, 'Ontwerpen', 'Het ontwerpen van een ict-systeem op basis van specificaties en binnen vooraf gestelde kaders.'),
(5, 'Realiseren', 'Het realiseren van een ict-systeem op basis van een ontwerp en binnen gestelde kaders.'),
(6, 'CPO', 'Creatief problemen oplossen'),
(7, 'OD', 'Onderzoek doen'),
(8, 'LSC', 'Leiderschap, Samenwerken, Communicatie'),
(9, 'POKe', 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek'),
(10, 'LPO', 'Leren & Persoonlijke Ontwikkeling');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `architectuurlaag`
--

CREATE TABLE `architectuurlaag` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `omschrijving` longtext COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `architectuurlaag`
--

INSERT INTO `architectuurlaag` (`id`, `naam`, `omschrijving`) VALUES
(1, 'Gebruikersinteractie', 'Gebruikersinteractie heeft betrekking op de communicatie van de (eind)gebruiker) met het ict-systeem. Hier wordt nadrukkelijk niet de interactie bedoeld met gebruikers zoals die plaatsvindt tijdens het tot stand komen van een ict-systeem; dat is immers in elk van de architectuurlagen aan de orde.'),
(2, 'Bedrijfsprocessen', 'Bedrijfsprocessen heeft betrekking op het faciliteren van organisatieprocessen door middel van ict-systemen. Daarbij gaat het om de functionaliteit van het systeem als geheel (geautomatiseerde en niet geautomatiseerde delen) bezien vanuit de context van de te realiseren organisatiedoelen.'),
(3, 'Infrastructuur', 'Infrastructuur betreft het geheel aan ict-systemen waarmee bedrijfsprocessen  gefaciliteerd worden. Het gaat hier om beschikbaar stellen, beschikbaar houden en configureren van de traditionele hardware-infrastructuur, maar zeker ook de software-infrastructuur.'),
(4, 'Software', 'Software betreft het ontwikkelen van diverse soorten software. Dit betreft software die na oplevering wordt opgenomen in een ict-infrastructuur.'),
(5, 'Hardware interfacing', 'Hardware interfacing is van toepassing wanneer software interactie aangaat met beschikbare hardware. Hierbij gaat het om situaties waarbij in de software expliciet rekening gehouden moet worden met mogelijkheden en beperkingen van de beschikbare hardware. Gekozen is voor â€˜computersysteemâ€™ als generieke, overkoepelende term. Afhankelijk van de context kan dit nader gespecificeerd worden inâ€˜embedded systeemâ€™, â€˜industrial automationâ€™, â€˜virtueel systeemâ€™ e.d.');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `beoordelingselement`
--

CREATE TABLE `beoordelingselement` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) DEFAULT NULL,
  `omschrijving` varchar(255) DEFAULT NULL,
  `toets` tinyblob,
  `gewicht` int(11) NOT NULL,
  `toets_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `beoordelingselement`
--

INSERT INTO `beoordelingselement` (`id`, `naam`, `omschrijving`, `toets`, `gewicht`, `toets_id`) VALUES
(1, 'Vraag 1', '', NULL, 10, 1),
(2, 'Vraag 2', '', NULL, 10, 1),
(3, 'Vraag 3', '', NULL, 10, 1),
(4, 'Projectvoorstel', '', NULL, 10, 2);

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
  `beschrijving` longtext COLLATE utf8_unicode_ci,
  `niveau` int(11) NOT NULL,
  `activiteit_id` int(11) NOT NULL,
  `architectuurlaag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `beroepstaak`
--

INSERT INTO `beroepstaak` (`id`, `beschrijving`, `niveau`, `activiteit_id`, `architectuurlaag_id`) VALUES
(1, 'Vanaf de start van product- of dienstontwikkeling rekening houden met productverantwoording, productcontext, continuÃ¯teit en overdracht naar de opdrachtgever en/of gebruikersomgeving.', 3, 1, 1),
(2, 'Het toepassen van versiebeheer en het inrichten en configureren van een samenwerkingsomgeving bij de realisatie van ict- en/of digitale mediaproducten,  rekening houdend met onderhoudbaarheid en daarvoor beschikbare middelen.', 2, 1, 1),
(3, 'Het inrichten en onderhouden van de eigen werkomgeving voor analyse, ontwerp en realisatie van ict- en/of digitale mediaproducten m.b.v. een gangbare tool. Het overdragen van een gedefinieerde versie van het eindproduct, inclusief productverantwoording, aan een opdrachtgever.', 1, 1, 1),
(4, 'Het in kaart brengen van trends in communicatie en designrepertoire van ict- en/of digitale mediaproducten. Het opstellen van een analyserapportage (doelgroep, doelstelling, context, informatie- en communicatiebehoefte, visualisatie, bruikbaarheid en gebruik), en dit relateren aan trends in ict- en/of digitale mediaproducten.', 3, 2, 1),
(5, 'Het analyseren van ict- en/of digitale mediaproducten, doelgroepen en doelstellingen vanuit een overzicht van actuele â€˜cultuurâ€™ en trends t.b.v. de inventarisatie van klant- of gebruikersbehoeften. Een interface-, gebruiks- en communicatieanalyse maken, inclusief usability en user- experience.', 2, 2, 1),
(6, 'Het designrepertoire (vormen, kleuren, stijlkenmerken) inventariseren en de merk- of productidentiteit beschrijven voor een actueel ict- en/of digitaal mediaproduct. Doelgroepen en doelstellingen onderscheiden en deze koppelen aan gebruikersgedrag  en interactie.', 1, 2, 1),
(7, 'Maatschappelijke en branchetrends verwerken In een advies voor de concrete inzet van media en middelen bij de ontwikkeling van ict- en of digitale mediaproducten, rekening houdend met planning en budget.', 3, 3, 1),
(8, 'Adviseren over de concrete inzet van media en middelen, rekening houdend met (communicatie)doelstellingen, doelgroepen, planning en budget.', 2, 3, 1),
(9, 'Adviseren over toe te passen interactie-, communicatie- en beeldende middelen voor inzet in communicatie en interface- ontwikkeling. Op basis van een gegeven usability-analyse aanbevelingen doen voor het ontwerp van een ict- en/of digitaal mediaproduct', 1, 3, 1),
(10, 'Ontwerpen van ict- en/of digitale mediaproducten vanuit een zelf ontworpen (vernieuwende) functionaliteit, interactievorm, stijl en/of dienst, met inbegrip van user experience, usability-testen en innovatieve technologie.', 3, 4, 1),
(11, 'Ontwerpen van samenhangende, dynamische ict- en/of digitale mediaproducten met toepassing van gedeeltelijk zelf geselecteerde technieken zoals scripts, storyboards, navigatiestructuur en passende usability-testen.', 2, 4, 1),
(12, 'Ontwerpen van statische en beperkt dynamische ict- en/of digitale mediaproducten met toepassing van gegeven technieken, zoals scenarioâ€™s, storyboards en wire frames en passende usability-testen.', 1, 4, 1),
(13, 'Realiseren en testen van dynamische ict- en/of digitale mediaproducten  met toepassing van innovatieve technologieÃ«n.', 3, 5, 1),
(14, 'Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.', 2, 5, 1),
(15, 'Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.', 1, 5, 1),
(16, 'Het inrichten en actualiseren van principes, business rules en modellen van procesarchitectuur, mede op basis van kwantitatieve en kwalitatieve analyse. Het proactief signaleren van behoefte aan verandering en bijbehorende processen in gang zetten.', 3, 1, 2),
(17, 'Het inrichten, onderhouden en actualiseren van functioneel beheer. De behoefte aan procesveranderingen signaleren en inventariseren, mede op basis van gegevens uit kwantitatieve en kwalitatieve analyse.', 2, 1, 2),
(18, 'Het onderhouden en actualiseren van procesdocumentatie. Het beschrijven van de veranderingsbehoefte bij een proces op basis van gegevens uit kwantitatieve en kwalitatieve analyse.', 1, 1, 2),
(19, 'Het in kaart brengen van de consequenties van een (strategische) koerswijziging voor bedrijfsprocessen en hun informatievoorziening. Een kwantitatieve en/of kwalitatieve analyse maken van de huidige en toekomstige situatie op het gebied van bijvoorbeeld beleid, strategie, alignment en architectuur, met gebruikmaking van gangbare methoden.', 3, 2, 2),
(20, 'Het analyseren van bedrijfsprocessen, organisatie, gegevensstromen, databehoeften en procesbesturing (op tactisch/operationeel niveau) en het beschrijven van knelpunten en oorzaak-gevolgrelaties vanuit de invalshoek van de informatievoorziening', 2, 2, 2),
(21, 'Het inventariseren van de gegevensstromen en informatievoorziening binnen een bedrijfsproces. Het analyseren van knelpunten van een bedrijfsproces en het beschrijven van oorzaak- gevolgrelaties.', 1, 2, 2),
(22, 'Adviseren over de in- en externe afstemming tussen business en ict (alignment en governance) op basis van de (netwerk-)organisatiestrategie en doelstellingen', 3, 3, 2),
(23, 'Adviseren over knelpunten op het terrein van organisatiestructuur (en rollen), (bedrijfs)processtructuur en samenhang, en informatievoorziening. Adviseren over nieuwe mogelijkheden voor de organisatie op basis van ontwikkelingen  in ict.', 2, 3, 2),
(24, 'Op basis van geanalyseerde knelpunten binnen een (bedrijfs)proces verbeteringen formuleren voor organisatie(structuur), (bedrijfs)processtructuur en/of informatieverzorging, met inachtneming van mogelijkheden van ict. Adviseren over de toepasbaarheid van een ict- ontwikkeling voor een organisatie.', 1, 3, 2),
(25, 'Het (her)ontwerpen van de architectuur van bedrijfsprocessen en besturingsmodellen, inclusief bijbehorende beheersing, informatievoorziening en veranderproces.', 3, 4, 2),
(26, 'Het (her)ontwerpen van samenhangende bedrijfsprocessen, een gegevensstructuur (model), het procesmanagement van bedrijfsprocessen, de functionele organisatiestructuur en/of de informatievoorziening, met inachtneming van mogelijkheden van ict en de borging van integriteit van de gegevens.', 2, 4, 2),
(27, 'Het (her)ontwerpen en/of digitaliseren van een bedrijfsproces, enkele gegevensstromen, een organisatieonderdeel en/of een deel van de informatievoorziening.', 1, 4, 2),
(28, 'Het realiseren van invoering en acceptatie realiseren van gewijzigde bedrijfsvoering op basis van een veranderproces.', 3, 5, 2),
(29, 'Het realiseren van de invoering en acceptatie van procedures in samenhang met nieuwe of gewijzigde informatievoorziening en besturing.', 2, 5, 2),
(30, 'Het beschrijven en opstellen van werkinstructies, functie- en rolbeschrijvingen, en procedures voor een (aangepast) proces.', 1, 5, 2),
(31, 'Ict-beheer afstemmen in horizontale richting (leveranciers, third-party) en in verticale richting (alignment). Het beheer opzetten en uitvoeren van een public of private cloudgebaseerde infrastructuur.', 3, 1, 3),
(32, 'Het in beheer onderbrengen van nieuwe technologische ontwikkelingen in infrastructuur, waaronder gebruikersdevices. Implementeren van beheerprocessen. Opzetten van een beheeromgeving om de kwaliteit van de ict-dienstverlening te kunnen meten, waaronder het ontvangen en afhandelen van klantverzoeken, en te kunnen rapporteren overdienstenniveau.', 2, 1, 3),
(33, 'Opzetten en documenteren van authenticatie- en autorisatiestructuur, systeem- en netwerkconfiguratie voor een lokale infrastructuur. Documenteren van standaardbeheerprocessen en - werkprocedures ten behoeve van beheer van infrastructuur.', 1, 1, 3),
(34, 'Onderzoek doen naar trends op het gebied van ict-infrastructuur op basis van (internationale) technologische, economische en maatschappelijke ontwikkelingen en innovaties. Een requirementsanalyse uitvoeren voor een bedrijfsinfrastructuur om functionele en niet-functionele eisen in kaart te brengen.', 3, 2, 3),
(35, 'Analyseren van de kwaliteit van de infrastructuuromgeving en - services aan de hand van gangbare modellen en methoden. Analyseren van aan infrastructuur gerelateerde incidenten, problemen en security- bedreigingen.', 2, 2, 3),
(36, 'Een infrastructuur analyseren volgens een standaardmethode en op basis van gegeven functionele eisen.', 1, 2, 3),
(37, 'Adviseren over infrastructuur, inclusief beheer en beveiliging, in relatie tot informatiearchitectuur, IT governance, innovatie, maatschappelijke  en internationale ontwikkelingen.', 3, 3, 3),
(38, 'Adviseren over inrichting en beheer van een infrastructuur met onderbouwde keuzes vanuit functionele en niet-functionele eisen, en vanuit beschikbare technologie, beheermodellen  en beheermethodes. Maatregelen voorstellen die de informatiebeveiliging van de infrastructuur ten goede komen.', 2, 3, 3),
(39, 'Aanbevelingen doen over een opzet van een lokale infrastructuur.', 1, 3, 3),
(40, 'Ontwerpen van een cloudgebaseerde infrastructuur met inachtneming van alle requirements. Ontwerpen van een incident response organisatie en systemen om adequaat te kunnen reageren op incidenten van iedere aard en omvang.', 3, 4, 3),
(41, 'Het beschrijven van beheerprocessen en afspraken omtrent te leveren diensten. Een functioneel ontwerp opstellen voor het automatiseren van het beheer van een infrastructuur in een specifieke bedrijfsomgeving. Een technisch ontwerp opstellen voor een infrastructuur met bijbehorende beveiliging op basis van functionele en niet-functionele eisen.', 2, 4, 3),
(42, 'Specificaties opstellen voor een lokale infrastructuur volgens een standaardmethode.', 1, 4, 3),
(43, 'Realiseren van public of private cloudgebaseerde infrastructuur en -services, met inachtneming van alle requirements. Opzetten van een geÃ¯ntegreerde multi-level ict- omgeving om de kwaliteit en security van ict-dienstverlening centraal te kunnen monitoren.', 3, 5, 3),
(44, 'Een infrastructuur inrichten die voldoet aan gestelde eisen op gebied van performance, usability, security en compliance. Opzetten van basismonitoring van de infrastructuur. Opstellen en uitvoeren van een testplan voor een infrastructuur om de kwaliteit te toetsen op basis van het opgestelde functionele en niet-functionele ontwerp.', 2, 5, 3),
(45, 'Een lokale infrastructuur inrichten, testen en beschikbaar stellen.', 1, 5, 3),
(46, 'Uitvoeren van configuratie-, change- en releasemanagement', 3, 1, 4),
(47, 'Inrichten, beheren en gebruikmaken van een ontwikkelstraat ter ondersteuning van softwareontwikkeling in teams. Principes toepassen om een softwareontwikkelproces te managen en te bewaken.', 2, 1, 4),
(48, 'Inrichten en gebruikmaken van beheersysteem ter ondersteuning van softwareontwikkeling in teamverband.', 1, 1, 4),
(49, 'Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden in een context van bestaande systemen. Integratie en migratieproblematiek in kaart brengen. Acceptatiecriteria definiÃ«ren aan de hand van kwaliteitseigenschappen en een uitgevoerde risicoanalyse.', 3, 2, 4),
(50, 'Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden, rekeninghoudend met de kwaliteitseigenschappen. Een analyse uitvoeren om functionaliteit, ontwerp, interfaces e.d. van een bestaand systeem of bestaande component te formuleren en te valideren. Een acceptatietest opstellen aan de hand van kwaliteitseigenschappen.', 2, 2, 4),
(51, 'Verzamelen en valideren van functionele eisen voor een softwaresysteem met Ã©Ã©n belanghebbende en volgens een standaardmethode. Acceptatiecriteria definiÃ«ren voor bovengenoemde  functionele eisen.', 1, 2, 4),
(52, 'Adviseren met betrekking tot de keuze voor softwarearchitectuur of software frameworks, waarbij kostenaspecten en kwaliteitskenmerken zoals beschikbaarheid, performance, security en schaalbaarheid  een rol spelen. Adviseren over de inrichting van een softwareontwikkelproces, waaronder het testproces.', 3, 3, 4),
(53, 'Adviseren over eventuele aanschaf en vervolgens selectie van bestaande software of componenten bij het ontwikkelen van softwaresysteem, waarbij het kostenaspect een rol speelt. Adviseren over een onderdeel van een architectuur of een beperkt softwaresysteem. Adviseren over het gebruik van prototypes bij het valideren van de eisen.', 2, 3, 4),
(54, 'Aanbevelingen  doen over specifieke requirements van een softwaresysteem op grond van onderzoek naar bestaande, vergelijkbare systemen.', 1, 3, 4),
(55, 'Een softwarearchitectuur opstellen voor een softwaresysteem, bestaande uit reeds bestaande en nieuwe systemen, rekening houdend met kwaliteitskenmerken en belanghebbenden. Opstellen van teststrategie voor systeemtesten.', 3, 4, 4),
(56, 'Opstellen van een ontwerp voor een softwaresysteem, rekening houdend met het gebruik van bestaande componenten en libraries; gebruik maken van ontwerp- kwaliteitscriteria. Vaststellen van de kwaliteit van het ontwerp, bijvoorbeeld door toetsing of prototyping, rekening houdend met de geformuleerde kwaliteitseigenschappen. Testontwerpen opstellen volgens een gegeven teststrategie.', 2, 4, 4),
(57, 'Een ontwerp maken voor een softwaresysteem met modelleertechnieken volgens een standaardmethode.', 1, 4, 4),
(58, 'Bouwen en beschikbaar stellen van een softwaresysteem dat aansluit bij bestaande systemen, volgens de ontworpen architectuur met gebruik van bestaande frameworks. Gebruikmaken van testautomatisering  bij het uitvoeren van testen', 3, 5, 4),
(59, 'Bouwen en beschikbaar stellen van een softwaresysteem dat bestaat uit meerdere subsystemen, hierbij gebruik makend van bestaande componenten. Integreren van softwarecomponenten in een bestaand systeem, waarbij o.a. de integriteit en systeemprestaties  bewaakt worden. Uitvoeren van regressietesten. Uitvoeren van en rapporteren over unit-, integratie- en systeemtesten.', 2, 5, 4),
(60, 'Een eenvoudig softwaresysteem bouwen, testen en beschikbaar stellen.', 1, 5, 4),
(61, 'Een ontwikkel- en testplatform ten behoeve van hardware/software co-design inrichten, inclusief tools (bijvoorbeeld voor virtualisatie). Een beheertestomgeving voor een computersysteem  inrichten.', 3, 1, 5),
(62, 'Een (crossplatform) ontwikkelomgeving inrichten, zowel software- als hardware- gerelateerd, inclusief tools. Een gegeven ontwikkelomgeving beoordelen op kwaliteit en prestaties.', 2, 1, 5),
(63, 'Inrichten en gebruikmaken van een beheeromgeving ter ondersteuning van de ontwikkeling van een computersysteem, bijv. een embedded of IA-systeem, in teamverband.', 1, 1, 5),
(64, 'Een gedistribueerd computersysteem specificeren, inclusief timing, resourcegebruik en performance. Security-aspecten beschrijven van computersystemen die aan of via (openbare) netwerken gekoppeld zijn. Acceptatietestplan en integratietestplan opstellen.', 3, 2, 5),
(65, 'Signalerings- en regelingsaspecten van de omgeving van een computersysteem in kaart brengen. Een computersysteem  methodisch specificeren. Een protocolanalyse uitvoeren. Een acceptatietest voor een computersysteem opstellen.', 2, 2, 5),
(66, 'Architectuur van een computersysteem  beschrijven. Werking van actuatoren en sensoren beschrijven en metingen verrichten. Functionele en niet-functionele eisen voor een computersysteem, bijv. een embedded of IA-systeem, en acceptatiecriteria opstellen.', 1, 2, 5),
(67, 'Een technisch advies uitbrengen over een te realiseren (gedistribueerd) computersysteem, inclusief hardware- en software- componenten en koppelingen.', 3, 3, 5),
(68, 'Een technisch advies uitbrengen voor de architectuur van een computersysteem en de hardware- en software- componenten. Advies uitbrengen over het koppelen van systemen.', 2, 3, 5),
(69, 'Een gegeven technisch advies verifiÃ«ren en onderbouwen. Een initiÃ«le architectuur en de functionaliteit van een gegeven systeemconfiguratie (microprocessor, geheugen of andere bouwstenen) verifiÃ«ren en beschrijven.', 1, 3, 5),
(70, 'Een gedistribueerd computersysteem ontwerpen, inclusief bepaling van actuatoren, sensoren, timing, resourcegebruik en performance.', 3, 4, 5),
(71, 'Een computersysteem methodisch ontwerpen op basis van zelfgekozen hardwarecomponenten. Een driverontwerp opstellen. Een protocol ontwerpen.', 2, 4, 5),
(72, 'Een eenvoudig computersysteem, bijv. een embedded of IA- systeem, ontwerpen op basis van gegeven hardware.', 1, 4, 5),
(73, 'Een compleet computersysteem verwezenlijken, inclusief netwerk, hardware en systeemsoftware. Een acceptatieprocedure opstellen en uitvoeren, bijv. in een virtuele omgeving, inclusief aspecten als timing, resourcegebruik en performance.', 3, 5, 5),
(74, 'Een eenvoudig computersysteem inrichten en de koppelingen met hardwarecomponenten realiseren via software. Driversoftware schrijven en testen. Een protocol implementeren  en testen.', 2, 5, 5),
(75, 'Software schrijven voor een eenvoudig, gegeven computersysteem, voorzien van actuatoren en sensoren.', 1, 5, 5);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `cohort_cursus`
--

INSERT INTO `cohort_cursus` (`cohort_id`, `cursussen_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 13);

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
(4, 'TICT-V1MOD-15', 5, 'Modelling', 2, 1, NULL),
(5, 'TICT-V1WAC-15', 5, 'Web Application Construction', 4, 1, 1),
(6, 'TICT-V1AUI-15', 5, 'Analysis & User Interfacing', 3, 1, 1),
(7, 'TICT-V1OODC-15', 5, 'Object Oriented Design & Construction', 3, 1, 1),
(8, 'TICT-V1GP-15', 5, 'Group Project', 3, 1, 1),
(9, 'TICT-V1DP-15', 5, 'Data Processing', 4, 1, 1),
(10, 'TICT-V1IPASS-15', 5, 'Individual Propedeuse Assessment', 4, 1, 1),
(11, 'TICT-V1PROF-15', 5, 'Professional Development', 2, 1, 1),
(12, 'TICT-V1IDP-15', 5, 'Intradisciplary Project', 2, 1, 1),
(13, 'TICT-V4AFST-17', 30, 'Afstuderen', 15, 3, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus_beroepstaak`
--

CREATE TABLE `cursus_beroepstaak` (
  `cursus_id` int(11) NOT NULL,
  `eindBTs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `cursus_beroepstaak`
--

INSERT INTO `cursus_beroepstaak` (`cursus_id`, `eindBTs_id`) VALUES
(1, 57),
(1, 60),
(3, 39),
(4, 6),
(4, 21),
(4, 36),
(4, 51),
(5, 15),
(5, 60),
(6, 6),
(6, 12),
(6, 51),
(7, 57),
(7, 60);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `cursus_professionalskill`
--

INSERT INTO `cursus_professionalskill` (`cursus_id`, `eindPSs_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `cursus_trefwoord`
--

CREATE TABLE `cursus_trefwoord` (
  `cursus_id` int(11) NOT NULL,
  `trefwoorden_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `docent`
--

CREATE TABLE `docent` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `organisatie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `docent`
--

INSERT INTO `docent` (`id`, `naam`, `organisatie_id`) VALUES
(1, 'Berend Wilkens', 1),
(2, 'Leo Pruijt', 1),
(3, 'Dan Greve', 1),
(4, 'Jeroen Weber', 1),
(5, 'Rik Jansen', 1),
(6, 'Rik Boss', 1);

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
-- Tabelstructuur voor tabel `millerniveau`
--

CREATE TABLE `millerniveau` (
  `id` int(11) NOT NULL,
  `niveau` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `omschrijving` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `millerniveau`
--

INSERT INTO `millerniveau` (`id`, `niveau`, `omschrijving`) VALUES
(1, 'Weten', 'Kennistoets'),
(2, 'Toepassen', 'Toepassen van kennis in schriftelijke casus / opdracht'),
(3, 'Tonen', 'Beoordeling in realistische voorspelbare situatie (simulatie/project)'),
(4, 'Doen', 'Beoordeling in echte beroepssituaties');

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
  `opleidingsprofiel_id` int(11) NOT NULL,
  `eindBTs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `opleidingsprofiel_beroepstaak`
--

INSERT INTO `opleidingsprofiel_beroepstaak` (`opleidingsprofiel_id`, `eindBTs_id`) VALUES
(1, 1),
(1, 5),
(1, 7),
(1, 11),
(1, 45),
(2, 3),
(2, 6),
(2, 9),
(2, 11),
(2, 14),
(2, 21),
(2, 36),
(2, 39),
(2, 47),
(2, 50),
(2, 54),
(2, 55),
(2, 58);

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
  `leerlijnen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleidingsprofiel_professionalskill`
--

CREATE TABLE `opleidingsprofiel_professionalskill` (
  `opleidingsprofiel_id` int(11) NOT NULL,
  `eindPSs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `opleidingsprofiel_professionalskill`
--

INSERT INTO `opleidingsprofiel_professionalskill` (`opleidingsprofiel_id`, `eindPSs_id`) VALUES
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `professionalSkills_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `professionalskill`
--

CREATE TABLE `professionalskill` (
  `id` int(11) NOT NULL,
  `beschrijving` longtext COLLATE utf8_unicode_ci,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `niveau` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activiteit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `professionalskill`
--

INSERT INTO `professionalskill` (`id`, `beschrijving`, `code`, `niveau`, `activiteit_id`) VALUES
(1, 'Creatief problemen oplossen', 'CPO', 'T', 6),
(2, 'Onderzoek doen', 'OD', 'T', 7),
(3, 'Leiderschap, Samenwerken, Communicatie', 'LSC', 'T', 8),
(4, 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'POKe', 'T', 9),
(5, 'Leren & Persoonlijke Ontwikkeling', 'LPO', 'T', 10),
(6, 'Creatief problemen oplossen', 'CPO', 'P', 6),
(7, 'Onderzoek doen', 'OD', 'P', 7),
(8, 'Leiderschap, Samenwerken, Communicatie', 'LSC', 'P', 8),
(9, 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'POKe', 'P', 9),
(10, 'Leren & Persoonlijke Ontwikkeling', 'LPO', 'P', 10),
(11, 'Creatief problemen oplossen', 'CPO', 'S', 6),
(12, 'Onderzoek doen', 'OD', 'S', 7),
(13, 'Leiderschap, Samenwerken, Communicatie', 'LSC', 'S', 8),
(14, 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'POKe', 'S', 9),
(15, 'Leren & Persoonlijke Ontwikkeling', 'LPO', 'S', 10);

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

--
-- Gegevens worden geëxporteerd voor tabel `toetselement`
--

INSERT INTO `toetselement` (`id`, `gewicht`, `beoordelingselement_id`, `bloomNiveau_id`, `leerdoel_id`) VALUES
(1, 20, 1, 2, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toetsplanning`
--

CREATE TABLE `toetsplanning` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toetsplanning_toetselement`
--

CREATE TABLE `toetsplanning_toetselement` (
  `ToetsPlanning_id` int(11) NOT NULL,
  `toetsElementen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `trefwoord`
--

CREATE TABLE `trefwoord` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `omschrijving` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `leerlijn_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `trefwoord_cursus`
--

CREATE TABLE `trefwoord_cursus` (
  `trefwoord_id` int(11) NOT NULL,
  `cursussen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE `useraccount` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `user`
--

INSERT INTO `useraccount` (`username`, `password`, `role`) VALUES
('alex', 'password', 'docent'),
('Redouan', 'password', 'student');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `werkveld`
--

CREATE TABLE `werkveld` (
  `id` int(11) NOT NULL,
  `activiteit_id` int(11) NOT NULL,
  `architectuurlaag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `activiteit`
--
ALTER TABLE `activiteit`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `architectuurlaag`
--
ALTER TABLE `architectuurlaag`
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_s2me07sqv4c474qdr280ixsl9` (`activiteit_id`),
  ADD KEY `FK_kw3jdrh44q9yerec6crm8m47b` (`architectuurlaag_id`);

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
-- Indexen voor tabel `cursus_trefwoord`
--
ALTER TABLE `cursus_trefwoord`
  ADD KEY `FK_icdl8cwgh0255h855bqm48af0` (`trefwoorden_id`),
  ADD KEY `FK_ovh1rbl9olr5ppj8wnda1g3k8` (`cursus_id`);

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
-- Indexen voor tabel `millerniveau`
--
ALTER TABLE `millerniveau`
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `FK_jsgpqfj2xc9871neudyu9duw` (`eindBTs_id`),
  ADD KEY `FK_39v4pcxxdjg11gomdw136n2eq` (`opleidingsprofiel_id`);

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
  ADD UNIQUE KEY `UK_q3cxewy63tbr3wsvnorhnjlvw` (`leerlijnen_id`),
  ADD KEY `FK_fm2uils8ed3c9bvl79tbuqufo` (`opleidingsprofiel_id`);

--
-- Indexen voor tabel `opleidingsprofiel_professionalskill`
--
ALTER TABLE `opleidingsprofiel_professionalskill`
  ADD KEY `FK_mvg04ld4nvekx1nvusncevc6g` (`eindPSs_id`),
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
  ADD UNIQUE KEY `UK_qv0qxo7jyrr2yk34xam7eb7rq` (`professionalSkills_id`),
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
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_qdqi2mcdru727ptkfhksyht1x` (`activiteit_id`);

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
  ADD UNIQUE KEY `UK_1xrl6t94fkss966hoa3x092yc` (`toetsElementen_id`),
  ADD KEY `FK_clhi3n9fgvpcau7ogopahfsup` (`ToetsPlanning_id`);

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
-- Indexen voor tabel `trefwoord`
--
ALTER TABLE `trefwoord`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_h3so9kvm603mk3la4s3k6g8ty` (`leerlijn_id`);

--
-- Indexen voor tabel `trefwoord_cursus`
--
ALTER TABLE `trefwoord_cursus`
  ADD UNIQUE KEY `UK_omop6e84r58i4hbtb6p5islv2` (`cursussen_id`),
  ADD KEY `FK_5buj14li6mkwx50q1lnvx6054` (`trefwoord_id`);

--
-- Indexen voor tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Indexen voor tabel `werkveld`
--
ALTER TABLE `werkveld`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_e63kq5ykbiy81n386xx02a21x` (`activiteit_id`),
  ADD KEY `FK_r9h01rybxno7jxqin3ws4y96o` (`architectuurlaag_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `activiteit`
--
ALTER TABLE `activiteit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT voor een tabel `architectuurlaag`
--
ALTER TABLE `architectuurlaag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT voor een tabel `beoordelingselement`
--
ALTER TABLE `beoordelingselement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT voor een tabel `docent`
--
ALTER TABLE `docent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
-- AUTO_INCREMENT voor een tabel `millerniveau`
--
ALTER TABLE `millerniveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT voor een tabel `toets`
--
ALTER TABLE `toets`
  MODIFY `toets_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `toetselement`
--
ALTER TABLE `toetselement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT voor een tabel `toetsplanning`
--
ALTER TABLE `toetsplanning`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `trefwoord`
--
ALTER TABLE `trefwoord`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `werkveld`
--
ALTER TABLE `werkveld`
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
-- Beperkingen voor tabel `beroepstaak`
--
ALTER TABLE `beroepstaak`
  ADD CONSTRAINT `FK_kw3jdrh44q9yerec6crm8m47b` FOREIGN KEY (`architectuurlaag_id`) REFERENCES `architectuurlaag` (`id`),
  ADD CONSTRAINT `FK_s2me07sqv4c474qdr280ixsl9` FOREIGN KEY (`activiteit_id`) REFERENCES `activiteit` (`id`);

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
-- Beperkingen voor tabel `cursus_trefwoord`
--
ALTER TABLE `cursus_trefwoord`
  ADD CONSTRAINT `FK_icdl8cwgh0255h855bqm48af0` FOREIGN KEY (`trefwoorden_id`) REFERENCES `trefwoord` (`id`),
  ADD CONSTRAINT `FK_ovh1rbl9olr5ppj8wnda1g3k8` FOREIGN KEY (`cursus_id`) REFERENCES `cursus` (`id`);

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
-- Beperkingen voor tabel `opleidingsprofiel`
--
ALTER TABLE `opleidingsprofiel`
  ADD CONSTRAINT `FK_i9erap1k01585f538c91jixjc` FOREIGN KEY (`organisatie_id`) REFERENCES `organisatie` (`id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_beroepstaak`
--
ALTER TABLE `opleidingsprofiel_beroepstaak`
  ADD CONSTRAINT `FK_39v4pcxxdjg11gomdw136n2eq` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`),
  ADD CONSTRAINT `FK_jsgpqfj2xc9871neudyu9duw` FOREIGN KEY (`eindBTs_id`) REFERENCES `beroepstaak` (`id`);

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
  ADD CONSTRAINT `FK_fm2uils8ed3c9bvl79tbuqufo` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`),
  ADD CONSTRAINT `FK_q3cxewy63tbr3wsvnorhnjlvw` FOREIGN KEY (`leerlijnen_id`) REFERENCES `leerlijn` (`Id`);

--
-- Beperkingen voor tabel `opleidingsprofiel_professionalskill`
--
ALTER TABLE `opleidingsprofiel_professionalskill`
  ADD CONSTRAINT `FK_lu0op8xyicl02p5xwloffkxqm` FOREIGN KEY (`opleidingsprofiel_id`) REFERENCES `opleidingsprofiel` (`id`),
  ADD CONSTRAINT `FK_mvg04ld4nvekx1nvusncevc6g` FOREIGN KEY (`eindPSs_id`) REFERENCES `professionalskill` (`id`);

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
  ADD CONSTRAINT `FK_qv0qxo7jyrr2yk34xam7eb7rq` FOREIGN KEY (`professionalSkills_id`) REFERENCES `professionalskill` (`id`);

--
-- Beperkingen voor tabel `professionalskill`
--
ALTER TABLE `professionalskill`
  ADD CONSTRAINT `FK_qdqi2mcdru727ptkfhksyht1x` FOREIGN KEY (`activiteit_id`) REFERENCES `activiteit` (`id`);

--
-- Beperkingen voor tabel `toetselement`
--
ALTER TABLE `toetselement`
  ADD CONSTRAINT `FK_2bbywfe3ian6qcg23gty34u5p` FOREIGN KEY (`leerdoel_id`) REFERENCES `leerdoel` (`id`),
  ADD CONSTRAINT `FK_3gj46c9u0vb6qhiptpn88qm3b` FOREIGN KEY (`beoordelingselement_id`) REFERENCES `beoordelingselement` (`id`),
  ADD CONSTRAINT `FK_aidapgk4lby6fmj33m99w5glj` FOREIGN KEY (`bloomNiveau_id`) REFERENCES `bloomniveau` (`id`),
  ADD CONSTRAINT `FK_dki0wnhtluj36pl0vvdv0qqxa` FOREIGN KEY (`beoordelingselement_id`) REFERENCES `beoordelingselement` (`id`),
  ADD CONSTRAINT `FK_s68gvyvmk9kxkoe8l906wanim` FOREIGN KEY (`leerdoel_id`) REFERENCES `leerdoel` (`id`),
  ADD CONSTRAINT `FK_wi3vpcbct1v9587tq1kno3ny` FOREIGN KEY (`bloomNiveau_id`) REFERENCES `bloomniveau` (`id`);

--
-- Beperkingen voor tabel `toetsplanning_toetselement`
--
ALTER TABLE `toetsplanning_toetselement`
  ADD CONSTRAINT `FK_1xrl6t94fkss966hoa3x092yc` FOREIGN KEY (`toetsElementen_id`) REFERENCES `toetselement` (`id`),
  ADD CONSTRAINT `FK_clhi3n9fgvpcau7ogopahfsup` FOREIGN KEY (`ToetsPlanning_id`) REFERENCES `toetsplanning` (`id`);

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

--
-- Beperkingen voor tabel `trefwoord`
--
ALTER TABLE `trefwoord`
  ADD CONSTRAINT `FK_h3so9kvm603mk3la4s3k6g8ty` FOREIGN KEY (`leerlijn_id`) REFERENCES `leerlijn` (`Id`);

--
-- Beperkingen voor tabel `trefwoord_cursus`
--
ALTER TABLE `trefwoord_cursus`
  ADD CONSTRAINT `FK_5buj14li6mkwx50q1lnvx6054` FOREIGN KEY (`trefwoord_id`) REFERENCES `trefwoord` (`id`),
  ADD CONSTRAINT `FK_omop6e84r58i4hbtb6p5islv2` FOREIGN KEY (`cursussen_id`) REFERENCES `cursus` (`id`);

--
-- Beperkingen voor tabel `werkveld`
--
ALTER TABLE `werkveld`
  ADD CONSTRAINT `FK_e63kq5ykbiy81n386xx02a21x` FOREIGN KEY (`activiteit_id`) REFERENCES `activiteit` (`id`),
  ADD CONSTRAINT `FK_r9h01rybxno7jxqin3ws4y96o` FOREIGN KEY (`architectuurlaag_id`) REFERENCES `architectuurlaag` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
