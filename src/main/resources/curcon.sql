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
-- Database: "curcon"
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "activiteit"
--
CREATE DATABASE  IF NOT EXISTS "jpa_manytomany";
USE "jpa_manytomany";

CREATE EXTENSION IF NOT EXISTS "plpgsql" WITH SCHEMA "pg_catalog";

--
-- Table structure for table "book"
--

CREATE TABLE "book_publisher" (
  "module_name" varchar(255) unsigned NOT NULL,
  "role_name" varchar(255) unsigned NOT NULL,
  PRIMARY KEY ("module_name","role_name"),
  KEY "fk_modulerole_role_name" ("role_name"),
  CONSTRAINT "fk_modulerole_module" FOREIGN KEY ("module_name") REFERENCES "module" ("name") ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT "fk_modulerole_role" FOREIGN KEY ("role_name") REFERENCES "role" ("name") ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE "role" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

CREATE TABLE "activiteit" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(1024)
);

--
-- Gegevens worden geëxporteerd voor tabel "activiteit"
--

INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES
(1, "Beheren", "Het beheersbaar laten verlopen van alle activiteiten gericht op het proces van ontwikkeling, ingebruikname en gebruik van ict-systemen."),
(2, "Analyseren", "Het analyseren van processen, producten en informatiestromen  in hun onderlinge samenhang en de context van de omgeving."),
(3, "Adviseren", "Het adviseren over de herinrichting van processen en/of informatiestromen  en voor een nieuw te ontwikkelen of aan te schaffen ict-systeem op basis van een analyse en in overleg met stakeholders."),
(4, "Ontwerpen", "Het ontwerpen van een ict-systeem op basis van specificaties en binnen vooraf gestelde kaders."),
(5, "Realiseren", "Het realiseren van een ict-systeem op basis van een ontwerp en binnen gestelde kaders."),
(6, "CPO", "Creatief problemen oplossen"),
(7, "OD", "Onderzoek doen"),
(8, "LSC", "Leiderschap, Samenwerken, Communicatie"),
(9, "POKe", "Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek"),
(10, "LPO", "Leren & Persoonlijke Ontwikkeling");

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "architectuurlaag"
--

CREATE TABLE "architectuurlaag" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(1024)
);
--
-- Gegevens worden geëxporteerd voor tabel "architectuurlaag"
--

INSERT INTO "architectuurlaag" ("id", "naam", "omschrijving") VALUES
(1, "Gebruikersinteractie", "Gebruikersinteractie heeft betrekking op de communicatie van de (eind)gebruiker) met het ict-systeem. Hier wordt nadrukkelijk niet de interactie bedoeld met gebruikers zoals die plaatsvindt tijdens het tot stand komen van een ict-systeem; dat is immers in elk van de architectuurlagen aan de orde."),
(2, "Bedrijfsprocessen", "Bedrijfsprocessen heeft betrekking op het faciliteren van organisatieprocessen door middel van ict-systemen. Daarbij gaat het om de functionaliteit van het systeem als geheel (geautomatiseerde en niet geautomatiseerde delen) bezien vanuit de context van de te realiseren organisatiedoelen."),
(3, "Infrastructuur", "Infrastructuur betreft het geheel aan ict-systemen waarmee bedrijfsprocessen  gefaciliteerd worden. Het gaat hier om beschikbaar stellen, beschikbaar houden en configureren van de traditionele hardware-infrastructuur, maar zeker ook de software-infrastructuur."),
(4, "Software", "Software betreft het ontwikkelen van diverse soorten software. Dit betreft software die na oplevering wordt opgenomen in een ict-infrastructuur."),
(5, "Hardware interfacing", "Hardware interfacing is van toepassing wanneer software interactie aangaat met beschikbare hardware. Hierbij gaat het om situaties waarbij in de software expliciet rekening gehouden moet worden met mogelijkheden en beperkingen van de beschikbare hardware. Gekozen is voor â€˜computersysteemâ€™ als generieke, overkoepelende term. Afhankelijk van de context kan dit nader gespecificeerd worden inâ€˜embedded systeemâ€™, â€˜industrial automationâ€™, â€˜virtueel systeemâ€™ e.d.");

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "beoordelingselement"
--

CREATE TABLE "beoordelingselement" (
    "id" integer NOT NULL,
    "gewicht" integer,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "toets_id" integer
);

--
-- Gegevens worden geëxporteerd voor tabel "beoordelingselement"
--

INSERT INTO "beoordelingselement" ("id", "naam", "omschrijving", "toets", "gewicht", "toets_id") VALUES
(1, "Vraag 1", "", NULL, 10, 1),
(2, "Vraag 2", "", NULL, 10, 1),
(3, "Vraag 3", "", NULL, 10, 1),
(4, "Projectvoorstel", "", NULL, 10, 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "beoordelingselement_toetselement"
--

CREATE TABLE "beoordelingselement_toetselement" (
    "beoordelingselement_id" integer NOT NULL,
    "toetselementen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "beroepsproduct"
--

CREATE TABLE "beroepsproduct" (
    "id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "beroepstaak"
--

CREATE TABLE "beroepstaak" (
    "id" integer NOT NULL,
    "beschrijving" character varying(1024),
    "niveau" integer NOT NULL,
    "activiteit_id" integer NOT NULL,
    "architectuurlaag_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "beroepstaak"
--

INSERT INTO "beroepstaak" ("id", "beschrijving", "niveau", "activiteit_id", "architectuurlaag_id") VALUES
(1, "Vanaf de start van product- of dienstontwikkeling rekening houden met productverantwoording, productcontext, continuÃ¯teit en overdracht naar de opdrachtgever en/of gebruikersomgeving.", 3, 1, 1),
(2, "Het toepassen van versiebeheer en het inrichten en configureren van een samenwerkingsomgeving bij de realisatie van ict- en/of digitale mediaproducten,  rekening houdend met onderhoudbaarheid en daarvoor beschikbare middelen.", 2, 1, 1),
(3, "Het inrichten en onderhouden van de eigen werkomgeving voor analyse, ontwerp en realisatie van ict- en/of digitale mediaproducten m.b.v. een gangbare tool. Het overdragen van een gedefinieerde versie van het eindproduct, inclusief productverantwoording, aan een opdrachtgever.", 1, 1, 1),
(4, "Het in kaart brengen van trends in communicatie en designrepertoire van ict- en/of digitale mediaproducten. Het opstellen van een analyserapportage (doelgroep, doelstelling, context, informatie- en communicatiebehoefte, visualisatie, bruikbaarheid en gebruik), en dit relateren aan trends in ict- en/of digitale mediaproducten.", 3, 2, 1),
(5, "Het analyseren van ict- en/of digitale mediaproducten, doelgroepen en doelstellingen vanuit een overzicht van actuele â€˜cultuurâ€™ en trends t.b.v. de inventarisatie van klant- of gebruikersbehoeften. Een interface-, gebruiks- en communicatieanalyse maken, inclusief usability en user- experience.", 2, 2, 1),
(6, "Het designrepertoire (vormen, kleuren, stijlkenmerken) inventariseren en de merk- of productidentiteit beschrijven voor een actueel ict- en/of digitaal mediaproduct. Doelgroepen en doelstellingen onderscheiden en deze koppelen aan gebruikersgedrag  en interactie.", 1, 2, 1),
(7, "Maatschappelijke en branchetrends verwerken In een advies voor de concrete inzet van media en middelen bij de ontwikkeling van ict- en of digitale mediaproducten, rekening houdend met planning en budget.", 3, 3, 1),
(8, "Adviseren over de concrete inzet van media en middelen, rekening houdend met (communicatie)doelstellingen, doelgroepen, planning en budget.", 2, 3, 1),
(9, "Adviseren over toe te passen interactie-, communicatie- en beeldende middelen voor inzet in communicatie en interface- ontwikkeling. Op basis van een gegeven usability-analyse aanbevelingen doen voor het ontwerp van een ict- en/of digitaal mediaproduct", 1, 3, 1),
(10, "Ontwerpen van ict- en/of digitale mediaproducten vanuit een zelf ontworpen (vernieuwende) functionaliteit, interactievorm, stijl en/of dienst, met inbegrip van user experience, usability-testen en innovatieve technologie.", 3, 4, 1),
(11, "Ontwerpen van samenhangende, dynamische ict- en/of digitale mediaproducten met toepassing van gedeeltelijk zelf geselecteerde technieken zoals scripts, storyboards, navigatiestructuur en passende usability-testen.", 2, 4, 1),
(12, "Ontwerpen van statische en beperkt dynamische ict- en/of digitale mediaproducten met toepassing van gegeven technieken, zoals scenarioâ€™s, storyboards en wire frames en passende usability-testen.", 1, 4, 1),
(13, "Realiseren en testen van dynamische ict- en/of digitale mediaproducten  met toepassing van innovatieve technologieÃ«n.", 3, 5, 1),
(14, "Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.", 2, 5, 1),
(15, "Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.", 1, 5, 1),
(16, "Het inrichten en actualiseren van principes, business rules en modellen van procesarchitectuur, mede op basis van kwantitatieve en kwalitatieve analyse. Het proactief signaleren van behoefte aan verandering en bijbehorende processen in gang zetten.", 3, 1, 2),
(17, "Het inrichten, onderhouden en actualiseren van functioneel beheer. De behoefte aan procesveranderingen signaleren en inventariseren, mede op basis van gegevens uit kwantitatieve en kwalitatieve analyse.", 2, 1, 2),
(18, "Het onderhouden en actualiseren van procesdocumentatie. Het beschrijven van de veranderingsbehoefte bij een proces op basis van gegevens uit kwantitatieve en kwalitatieve analyse.", 1, 1, 2),
(19, "Het in kaart brengen van de consequenties van een (strategische) koerswijziging voor bedrijfsprocessen en hun informatievoorziening. Een kwantitatieve en/of kwalitatieve analyse maken van de huidige en toekomstige situatie op het gebied van bijvoorbeeld beleid, strategie, alignment en architectuur, met gebruikmaking van gangbare methoden.", 3, 2, 2),
(20, "Het analyseren van bedrijfsprocessen, organisatie, gegevensstromen, databehoeften en procesbesturing (op tactisch/operationeel niveau) en het beschrijven van knelpunten en oorzaak-gevolgrelaties vanuit de invalshoek van de informatievoorziening", 2, 2, 2),
(21, "Het inventariseren van de gegevensstromen en informatievoorziening binnen een bedrijfsproces. Het analyseren van knelpunten van een bedrijfsproces en het beschrijven van oorzaak- gevolgrelaties.", 1, 2, 2),
(22, "Adviseren over de in- en externe afstemming tussen business en ict (alignment en governance) op basis van de (netwerk-)organisatiestrategie en doelstellingen", 3, 3, 2),
(23, "Adviseren over knelpunten op het terrein van organisatiestructuur (en rollen), (bedrijfs)processtructuur en samenhang, en informatievoorziening. Adviseren over nieuwe mogelijkheden voor de organisatie op basis van ontwikkelingen  in ict.", 2, 3, 2),
(24, "Op basis van geanalyseerde knelpunten binnen een (bedrijfs)proces verbeteringen formuleren voor organisatie(structuur), (bedrijfs)processtructuur en/of informatieverzorging, met inachtneming van mogelijkheden van ict. Adviseren over de toepasbaarheid van een ict- ontwikkeling voor een organisatie.", 1, 3, 2),
(25, "Het (her)ontwerpen van de architectuur van bedrijfsprocessen en besturingsmodellen, inclusief bijbehorende beheersing, informatievoorziening en veranderproces.", 3, 4, 2),
(26, "Het (her)ontwerpen van samenhangende bedrijfsprocessen, een gegevensstructuur (model), het procesmanagement van bedrijfsprocessen, de functionele organisatiestructuur en/of de informatievoorziening, met inachtneming van mogelijkheden van ict en de borging van integriteit van de gegevens.", 2, 4, 2),
(27, "Het (her)ontwerpen en/of digitaliseren van een bedrijfsproces, enkele gegevensstromen, een organisatieonderdeel en/of een deel van de informatievoorziening.", 1, 4, 2),
(28, "Het realiseren van invoering en acceptatie realiseren van gewijzigde bedrijfsvoering op basis van een veranderproces.", 3, 5, 2),
(29, "Het realiseren van de invoering en acceptatie van procedures in samenhang met nieuwe of gewijzigde informatievoorziening en besturing.", 2, 5, 2),
(30, "Het beschrijven en opstellen van werkinstructies, functie- en rolbeschrijvingen, en procedures voor een (aangepast) proces.", 1, 5, 2),
(31, "Ict-beheer afstemmen in horizontale richting (leveranciers, third-party) en in verticale richting (alignment). Het beheer opzetten en uitvoeren van een public of private cloudgebaseerde infrastructuur.", 3, 1, 3),
(32, "Het in beheer onderbrengen van nieuwe technologische ontwikkelingen in infrastructuur, waaronder gebruikersdevices. Implementeren van beheerprocessen. Opzetten van een beheeromgeving om de kwaliteit van de ict-dienstverlening te kunnen meten, waaronder het ontvangen en afhandelen van klantverzoeken, en te kunnen rapporteren overdienstenniveau.", 2, 1, 3),
(33, "Opzetten en documenteren van authenticatie- en autorisatiestructuur, systeem- en netwerkconfiguratie voor een lokale infrastructuur. Documenteren van standaardbeheerprocessen en - werkprocedures ten behoeve van beheer van infrastructuur.", 1, 1, 3),
(34, "Onderzoek doen naar trends op het gebied van ict-infrastructuur op basis van (internationale) technologische, economische en maatschappelijke ontwikkelingen en innovaties. Een requirementsanalyse uitvoeren voor een bedrijfsinfrastructuur om functionele en niet-functionele eisen in kaart te brengen.", 3, 2, 3),
(35, "Analyseren van de kwaliteit van de infrastructuuromgeving en - services aan de hand van gangbare modellen en methoden. Analyseren van aan infrastructuur gerelateerde incidenten, problemen en security- bedreigingen.", 2, 2, 3),
(36, "Een infrastructuur analyseren volgens een standaardmethode en op basis van gegeven functionele eisen.", 1, 2, 3),
(37, "Adviseren over infrastructuur, inclusief beheer en beveiliging, in relatie tot informatiearchitectuur, IT governance, innovatie, maatschappelijke  en internationale ontwikkelingen.", 3, 3, 3),
(38, "Adviseren over inrichting en beheer van een infrastructuur met onderbouwde keuzes vanuit functionele en niet-functionele eisen, en vanuit beschikbare technologie, beheermodellen  en beheermethodes. Maatregelen voorstellen die de informatiebeveiliging van de infrastructuur ten goede komen.", 2, 3, 3),
(39, "Aanbevelingen doen over een opzet van een lokale infrastructuur.", 1, 3, 3),
(40, "Ontwerpen van een cloudgebaseerde infrastructuur met inachtneming van alle requirements. Ontwerpen van een incident response organisatie en systemen om adequaat te kunnen reageren op incidenten van iedere aard en omvang.", 3, 4, 3),
(41, "Het beschrijven van beheerprocessen en afspraken omtrent te leveren diensten. Een functioneel ontwerp opstellen voor het automatiseren van het beheer van een infrastructuur in een specifieke bedrijfsomgeving. Een technisch ontwerp opstellen voor een infrastructuur met bijbehorende beveiliging op basis van functionele en niet-functionele eisen.", 2, 4, 3),
(42, "Specificaties opstellen voor een lokale infrastructuur volgens een standaardmethode.", 1, 4, 3),
(43, "Realiseren van public of private cloudgebaseerde infrastructuur en -services, met inachtneming van alle requirements. Opzetten van een geÃ¯ntegreerde multi-level ict- omgeving om de kwaliteit en security van ict-dienstverlening centraal te kunnen monitoren.", 3, 5, 3),
(44, "Een infrastructuur inrichten die voldoet aan gestelde eisen op gebied van performance, usability, security en compliance. Opzetten van basismonitoring van de infrastructuur. Opstellen en uitvoeren van een testplan voor een infrastructuur om de kwaliteit te toetsen op basis van het opgestelde functionele en niet-functionele ontwerp.", 2, 5, 3),
(45, "Een lokale infrastructuur inrichten, testen en beschikbaar stellen.", 1, 5, 3),
(46, "Uitvoeren van configuratie-, change- en releasemanagement", 3, 1, 4),
(47, "Inrichten, beheren en gebruikmaken van een ontwikkelstraat ter ondersteuning van softwareontwikkeling in teams. Principes toepassen om een softwareontwikkelproces te managen en te bewaken.", 2, 1, 4),
(48, "Inrichten en gebruikmaken van beheersysteem ter ondersteuning van softwareontwikkeling in teamverband.", 1, 1, 4),
(49, "Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden in een context van bestaande systemen. Integratie en migratieproblematiek in kaart brengen. Acceptatiecriteria definiÃ«ren aan de hand van kwaliteitseigenschappen en een uitgevoerde risicoanalyse.", 3, 2, 4),
(50, "Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden, rekeninghoudend met de kwaliteitseigenschappen. Een analyse uitvoeren om functionaliteit, ontwerp, interfaces e.d. van een bestaand systeem of bestaande component te formuleren en te valideren. Een acceptatietest opstellen aan de hand van kwaliteitseigenschappen.", 2, 2, 4),
(51, "Verzamelen en valideren van functionele eisen voor een softwaresysteem met Ã©Ã©n belanghebbende en volgens een standaardmethode. Acceptatiecriteria definiÃ«ren voor bovengenoemde  functionele eisen.", 1, 2, 4),
(52, "Adviseren met betrekking tot de keuze voor softwarearchitectuur of software frameworks, waarbij kostenaspecten en kwaliteitskenmerken zoals beschikbaarheid, performance, security en schaalbaarheid  een rol spelen. Adviseren over de inrichting van een softwareontwikkelproces, waaronder het testproces.", 3, 3, 4),
(53, "Adviseren over eventuele aanschaf en vervolgens selectie van bestaande software of componenten bij het ontwikkelen van softwaresysteem, waarbij het kostenaspect een rol speelt. Adviseren over een onderdeel van een architectuur of een beperkt softwaresysteem. Adviseren over het gebruik van prototypes bij het valideren van de eisen.", 2, 3, 4),
(54, "Aanbevelingen  doen over specifieke requirements van een softwaresysteem op grond van onderzoek naar bestaande, vergelijkbare systemen.", 1, 3, 4),
(55, "Een softwarearchitectuur opstellen voor een softwaresysteem, bestaande uit reeds bestaande en nieuwe systemen, rekening houdend met kwaliteitskenmerken en belanghebbenden. Opstellen van teststrategie voor systeemtesten.", 3, 4, 4),
(56, "Opstellen van een ontwerp voor een softwaresysteem, rekening houdend met het gebruik van bestaande componenten en libraries; gebruik maken van ontwerp- kwaliteitscriteria. Vaststellen van de kwaliteit van het ontwerp, bijvoorbeeld door toetsing of prototyping, rekening houdend met de geformuleerde kwaliteitseigenschappen. Testontwerpen opstellen volgens een gegeven teststrategie.", 2, 4, 4),
(57, "Een ontwerp maken voor een softwaresysteem met modelleertechnieken volgens een standaardmethode.", 1, 4, 4),
(58, "Bouwen en beschikbaar stellen van een softwaresysteem dat aansluit bij bestaande systemen, volgens de ontworpen architectuur met gebruik van bestaande frameworks. Gebruikmaken van testautomatisering  bij het uitvoeren van testen", 3, 5, 4),
(59, "Bouwen en beschikbaar stellen van een softwaresysteem dat bestaat uit meerdere subsystemen, hierbij gebruik makend van bestaande componenten. Integreren van softwarecomponenten in een bestaand systeem, waarbij o.a. de integriteit en systeemprestaties  bewaakt worden. Uitvoeren van regressietesten. Uitvoeren van en rapporteren over unit-, integratie- en systeemtesten.", 2, 5, 4),
(60, "Een eenvoudig softwaresysteem bouwen, testen en beschikbaar stellen.", 1, 5, 4),
(61, "Een ontwikkel- en testplatform ten behoeve van hardware/software co-design inrichten, inclusief tools (bijvoorbeeld voor virtualisatie). Een beheertestomgeving voor een computersysteem  inrichten.", 3, 1, 5),
(62, "Een (crossplatform) ontwikkelomgeving inrichten, zowel software- als hardware- gerelateerd, inclusief tools. Een gegeven ontwikkelomgeving beoordelen op kwaliteit en prestaties.", 2, 1, 5),
(63, "Inrichten en gebruikmaken van een beheeromgeving ter ondersteuning van de ontwikkeling van een computersysteem, bijv. een embedded of IA-systeem, in teamverband.", 1, 1, 5),
(64, "Een gedistribueerd computersysteem specificeren, inclusief timing, resourcegebruik en performance. Security-aspecten beschrijven van computersystemen die aan of via (openbare) netwerken gekoppeld zijn. Acceptatietestplan en integratietestplan opstellen.", 3, 2, 5),
(65, "Signalerings- en regelingsaspecten van de omgeving van een computersysteem in kaart brengen. Een computersysteem  methodisch specificeren. Een protocolanalyse uitvoeren. Een acceptatietest voor een computersysteem opstellen.", 2, 2, 5),
(66, "Architectuur van een computersysteem  beschrijven. Werking van actuatoren en sensoren beschrijven en metingen verrichten. Functionele en niet-functionele eisen voor een computersysteem, bijv. een embedded of IA-systeem, en acceptatiecriteria opstellen.", 1, 2, 5),
(67, "Een technisch advies uitbrengen over een te realiseren (gedistribueerd) computersysteem, inclusief hardware- en software- componenten en koppelingen.", 3, 3, 5),
(68, "Een technisch advies uitbrengen voor de architectuur van een computersysteem en de hardware- en software- componenten. Advies uitbrengen over het koppelen van systemen.", 2, 3, 5),
(69, "Een gegeven technisch advies verifiÃ«ren en onderbouwen. Een initiÃ«le architectuur en de functionaliteit van een gegeven systeemconfiguratie (microprocessor, geheugen of andere bouwstenen) verifiÃ«ren en beschrijven.", 1, 3, 5),
(70, "Een gedistribueerd computersysteem ontwerpen, inclusief bepaling van actuatoren, sensoren, timing, resourcegebruik en performance.", 3, 4, 5),
(71, "Een computersysteem methodisch ontwerpen op basis van zelfgekozen hardwarecomponenten. Een driverontwerp opstellen. Een protocol ontwerpen.", 2, 4, 5),
(72, "Een eenvoudig computersysteem, bijv. een embedded of IA- systeem, ontwerpen op basis van gegeven hardware.", 1, 4, 5),
(73, "Een compleet computersysteem verwezenlijken, inclusief netwerk, hardware en systeemsoftware. Een acceptatieprocedure opstellen en uitvoeren, bijv. in een virtuele omgeving, inclusief aspecten als timing, resourcegebruik en performance.", 3, 5, 5),
(74, "Een eenvoudig computersysteem inrichten en de koppelingen met hardwarecomponenten realiseren via software. Driversoftware schrijven en testen. Een protocol implementeren  en testen.", 2, 5, 5),
(75, "Software schrijven voor een eenvoudig, gegeven computersysteem, voorzien van actuatoren en sensoren.", 1, 5, 5);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "bloomniveau"
--

CREATE TABLE "bloomniveau" (
    "id" integer NOT NULL,
    "niveau" character varying(255),
    "omschrijving" character varying(255)
);

--
-- Gegevens worden geëxporteerd voor tabel "bloomniveau"
--

INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES
(1, "Onthouden", ""),
(2, "Begrijpen", ""),
(3, "Toepassen", ""),
(4, "Analyseren", ""),
(5, "Evalueren", ""),
(6, "Creeeren", "");

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "cohort"
--

CREATE TABLE "cohort" (
    "id" integer NOT NULL,
    "jaar" character varying(255),
    "opleidingsprofiel_id" integer
);

--
-- Gegevens worden geëxporteerd voor tabel "cohort"
--

INSERT INTO "cohort" ("id", "jaar", "opleidingsProfiel_id") VALUES
(1, "2014", 2),
(2, "2015", 2),
(3, "2016", 2),
(4, "2017", 2),
(5, "2018", 2);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "cohort_cursus"
--

CREATE TABLE "cohort_cursus" (
    "cohort_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "cohort_cursus"
--

INSERT INTO "cohort_cursus" ("cohort_id", "cursussen_id") VALUES
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
-- Tabelstructuur voor tabel "cursus"
--

CREATE TABLE "cursus" (
    "id" integer NOT NULL,
    "cursuscode" character varying(255),
    "ects" integer,
    "naam" character varying(255),
    "periode" integer,
    "docent_id" integer,
    "organisatie_id" integer
);

--
-- Gegevens worden geëxporteerd voor tabel "cursus"
--

INSERT INTO "cursus" ("id", "cursuscode", "ects", "naam", "periode", "docent_id", "organisatie_id") VALUES
(1, "TICT-V1PROG-15", 5, "Programming", 1, 1, NULL),
(2, "TICT-V1ICOR-15", 5, "ICT and Organisation", 1, 1, NULL),
(3, "TICT-V1CSN-15", 5, "Computer, system and network", 1, 1, NULL),
(4, "TICT-V1MOD-15", 5, "Modelling", 2, 1, NULL),
(5, "TICT-V1WAC-15", 5, "Web Application Construction", 4, 1, 1),
(6, "TICT-V1AUI-15", 5, "Analysis & User Interfacing", 3, 1, 1),
(7, "TICT-V1OODC-15", 5, "Object Oriented Design & Construction", 3, 1, 1),
(8, "TICT-V1GP-15", 5, "Group Project", 3, 1, 1),
(9, "TICT-V1DP-15", 5, "Data Processing", 4, 1, 1),
(10, "TICT-V1IPASS-15", 5, "Individual Propedeuse Assessment", 4, 1, 1),
(11, "TICT-V1PROF-15", 5, "Professional Development", 2, 1, 1),
(12, "TICT-V1IDP-15", 5, "Intradisciplary Project", 2, 1, 1),
(13, "TICT-V4AFST-17", 30, "Afstuderen", 15, 3, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "cursus_beroepstaak"
--

CREATE TABLE "cursus_beroepstaak" (
    "cursus_id" integer NOT NULL,
    "eindbts_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "cursus_beroepstaak"
--

INSERT INTO "cursus_beroepstaak" ("cursus_id", "eindBTs_id") VALUES
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
-- Tabelstructuur voor tabel "cursus_onderwerp"
--

CREATE TABLE "cursus_onderwerp" (
    "cursus_id" integer NOT NULL,
    "onderwerpen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "cursus_professionalskill"
--

CREATE TABLE "cursus_professionalskill" (
    "cursus_id" integer NOT NULL,
    "eindpss_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "cursus_professionalskill"
--

INSERT INTO "cursus_professionalskill" ("cursus_id", "eindPSs_id") VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "cursus_trefwoord"
--

CREATE TABLE "cursus_trefwoord" (
    "cursus_id" integer NOT NULL,
    "trefwoorden_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "docent"
--

CREATE TABLE "docent" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "organisatie_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "docent"
--

INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES
(1, "Berend Wilkens", 1),
(2, "Leo Pruijt", 1),
(3, "Dan Greve", 1),
(4, "Jeroen Weber", 1),
(5, "Rik Jansen", 1),
(6, "Rik Boss", 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "geslotenvraag"
--

CREATE TABLE "geslotenvraag" (
    "id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "leerdoel"
--

CREATE TABLE "leerdoel" (
    "id" integer NOT NULL,
    "gewicht" double precision,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "beroepstaak_id" integer,
    "bloomniveau_id" integer NOT NULL,
    "cursus_id" integer NOT NULL,
    "professionalskill_id" integer,
    "trefwoord_id" integer
);
--
-- Gegevens worden geëxporteerd voor tabel "leerdoel"
--

INSERT INTO "leerdoel" ("id", "eindBT", "eindPS", "omschrijving", "toetsPlanning", "bloomniveau_id", "cursus_id") VALUES
(1, NULL, NULL, "Grafische webinterfaces bouwen met behulp van het J2EE framework (servlets en Java Server Pages) en kan een J2EE frontendframework toepassen (Struts2).", NULL, 2, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "leerlijn"
--

CREATE TABLE "leerlijn" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(255)
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "leerlijn_onderwerp"
--

CREATE TABLE "leerlijn_onderwerp" (
    "leerlijn_id" integer NOT NULL,
    "onderwerpen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "millerniveau"
--

CREATE TABLE "millerniveau" (
    "id" integer NOT NULL,
    "niveau" character varying(255),
    "omschrijving" character varying(255)
);

--
-- Gegevens worden geëxporteerd voor tabel "millerniveau"
--

INSERT INTO "millerniveau" ("id", "niveau", "omschrijving") VALUES
(1, "Weten", "Kennistoets"),
(2, "Toepassen", "Toepassen van kennis in schriftelijke casus / opdracht"),
(3, "Tonen", "Beoordeling in realistische voorspelbare situatie (simulatie/project)"),
(4, "Doen", "Beoordeling in echte beroepssituaties");

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "onderwerp"
--

CREATE TABLE "onderwerp" (
    "id" integer NOT NULL,
    "leerlijn" "bytea",
    "trefwoord" character varying
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "onderwerp_cursus"
--

CREATE TABLE "onderwerp_cursus" (
    "onderwerp_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "openvraag"
--

CREATE TABLE "openvraag" (
    "id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "opleidingsprofiel"
--

CREATE TABLE "opleidingsprofiel" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "organisatie_id" integer
);

--
-- Gegevens worden geëxporteerd voor tabel "opleidingsprofiel"
--

INSERT INTO "opleidingsprofiel" ("id", "naam", "organisatie_id") VALUES
(1, "Business IT and Management", 1),
(2, "Software and Information Enginering", 1),
(3, "System and Network Enginering", 1),
(4, "Technische Informatica", 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "opleidingsprofiel_beroepstaak"
--

CREATE TABLE "opleidingsprofiel_beroepstaak" (
    "opleidingsprofiel_id" integer NOT NULL,
    "eindbts_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "opleidingsprofiel_beroepstaak"
--

INSERT INTO "opleidingsprofiel_beroepstaak" ("opleidingsprofiel_id", "eindBTs_id") VALUES
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
-- Tabelstructuur voor tabel "opleidingsprofiel_cohort"
--

CREATE TABLE "opleidingsprofiel_cohort" (
    "opleidingsprofiel_id" integer NOT NULL,
    "cohorten_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "opleidingsprofiel_leerlijn"
--

CREATE TABLE "opleidingsprofiel_leerlijn" (
    "opleidingsprofiel_id" integer NOT NULL,
    "leerlijnen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "opleidingsprofiel_professionalskill"
--

CREATE TABLE "opleidingsprofiel_professionalskill" (
    "opleidingsprofiel_id" integer NOT NULL,
    "eindpss_id" integer NOT NULL
);

ALTER TABLE ONLY "opleidingsprofiel_professionalskill"
ADD CONSTRAINT "fk_lu0op8xyicl02p5xwloffkxqm" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel"("id");


--
-- Gegevens worden geëxporteerd voor tabel "opleidingsprofiel_professionalskill"
--

INSERT INTO "opleidingsprofiel_professionalskill" ("opleidingsprofiel_id", "eindPSs_id") VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "organisatie"
--

CREATE TABLE "organisatie" (
    "id" integer NOT NULL,
    "naam" character varying(255)
);

--
-- Gegevens worden geëxporteerd voor tabel "organisatie"
--

INSERT INTO "organisatie" ("id", "naam") VALUES
(1, "Hogeschool Utrecht I-ICT");

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "organisatie_beroepstaak"
--

CREATE TABLE "organisatie_beroepstaak" (
    "organisatie_id" integer NOT NULL,
    "alleberoepstaken_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "organisatie_cursus"
--

CREATE TABLE "organisatie_cursus" (
    "organisatie_id" integer NOT NULL,
    "allecursussen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "organisatie_professionalskill"
--

CREATE TABLE "organisatie_professionalskill" (
    "organisatie_id" integer NOT NULL,
    "professionalskills_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "osirisresultaattype"
--

CREATE TABLE "osirisresultaattype" (
    "id" integer NOT NULL,
    "naam" character varying,
    "omschrijving" character varying
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "periode"
--

CREATE TABLE "periode" (
    "id" integer NOT NULL,
    "periode" integer
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "professionalskill"
--

CREATE TABLE "professionalskill" (
    "id" integer NOT NULL,
    "beschrijving" character varying(1024),
    "code" character varying(255),
    "niveau" character varying(255),
    "activiteit_id" integer NOT NULL
);

--
-- Gegevens worden geëxporteerd voor tabel "professionalskill"
--

INSERT INTO "professionalskill" ("id", "beschrijving", "code", "niveau", "activiteit_id") VALUES
(1, "Creatief problemen oplossen", "CPO", "T", 6),
(2, "Onderzoek doen", "OD", "T", 7),
(3, "Leiderschap, Samenwerken, Communicatie", "LSC", "T", 8),
(4, "Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek", "POKe", "T", 9),
(5, "Leren & Persoonlijke Ontwikkeling", "LPO", "T", 10),
(6, "Creatief problemen oplossen", "CPO", "P", 6),
(7, "Onderzoek doen", "OD", "P", 7),
(8, "Leiderschap, Samenwerken, Communicatie", "LSC", "P", 8),
(9, "Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek", "POKe", "P", 9),
(10, "Leren & Persoonlijke Ontwikkeling", "LPO", "P", 10),
(11, "Creatief problemen oplossen", "CPO", "S", 6),
(12, "Onderzoek doen", "OD", "S", 7),
(13, "Leiderschap, Samenwerken, Communicatie", "LSC", "S", 8),
(14, "Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek", "POKe", "S", 9),
(15, "Leren & Persoonlijke Ontwikkeling", "LPO", "S", 10);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toets"
--

CREATE TABLE "toets" (
    "id" integer NOT NULL,
    "gewicht" double precision,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "cursus_id" integer,
    "millerniveau_id" integer
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toetselement"
--

CREATE TABLE "toetselement" (
    "id" integer NOT NULL,
    "gewicht" double precision,
    "beoordelingselement_id" integer,
    "bloomniveau_id" integer,
    "leerdoel_id" integer
);
--
-- Gegevens worden geëxporteerd voor tabel "toetselement"
--

INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomNiveau_id", "leerdoel_id") VALUES
(1, 20, 1, 2, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toetsplanning"
--

CREATE TABLE "toetsplanning" (
    "id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toetsplanning_toetselement"
--

CREATE TABLE "toetsplanning_toetselement" (
    "toetsplanning_id" integer NOT NULL,
    "toetselementen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toets_beroepsproduct"
--

CREATE TABLE "toets_beroepsproduct" (
    "toets_toets_id" integer NOT NULL,
    "beroepsproducten_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toets_geslotenvraag"
--

CREATE TABLE "toets_geslotenvraag" (
    "toets_toets_id" integer NOT NULL,
    "geslotenvragen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "toets_openvraag"
--

CREATE TABLE "toets_openvraag" (
    "toets_toets_id" integer NOT NULL,
    "openvragen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "trefwoord"
--

CREATE TABLE "trefwoord" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "leerlijn_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "trefwoord_cursus"
--

CREATE TABLE "trefwoord_cursus" (
    "trefwoord_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

-- --------------------------------------------------------

--
-- Gegevens worden geëxporteerd voor tabel "user"
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel "werkveld"
--

CREATE TABLE "werkveld" (
    "id" integer NOT NULL,
    "activiteit_id" integer NOT NULL,
    "architectuurlaag_id" integer NOT NULL
);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel "activiteit"
--
ALTER TABLE ONLY "activiteit"
ADD CONSTRAINT "activiteit_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "architectuurlaag"
--
ALTER TABLE ONLY "architectuurlaag"
ADD CONSTRAINT "architectuurlaag_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "beoordelingselement"
--
ALTER TABLE ONLY "beoordelingselement"
ADD CONSTRAINT "beoordelingselement_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "beroepsproduct"
--
ALTER TABLE "beroepsproduct"
  ADD PRIMARY KEY ("id");

--
-- Indexen voor tabel "beroepstaak"
--

ALTER TABLE ONLY "beroepstaak"
ADD CONSTRAINT "beroepstaak_pkey" PRIMARY KEY ("id");
--
-- Indexen voor tabel "bloomniveau"
--
ALTER TABLE ONLY "bloomniveau"
ADD CONSTRAINT "bloomniveau_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "cohort"
--
ALTER TABLE ONLY "cohort"
ADD CONSTRAINT "cohort_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "cursus"
--
ALTER TABLE ONLY "cursus"
ADD CONSTRAINT "cursus_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "docent"
--
ALTER TABLE ONLY "docent"
ADD CONSTRAINT "docent_pkey" PRIMARY KEY ("id");
  ADD KEY "FK_ioulcs791yeqanu0v3fvkk6kj" ("organisatie_id");

--
-- Indexen voor tabel "geslotenvraag"
--
ALTER TABLE "geslotenvraag"
  ADD PRIMARY KEY ("id");

--
-- Indexen voor tabel "leerdoel"
--
ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "leerdoel_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "leerlijn"
--
ALTER TABLE ONLY "leerlijn"
ADD CONSTRAINT "leerlijn_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "millerniveau"
--
ALTER TABLE ONLY "millerniveau"
ADD CONSTRAINT "millerniveau_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "onderwerp"
--
ALTER TABLE "onderwerp"
  ADD PRIMARY KEY ("id");

--
-- Indexen voor tabel "openvraag"
--
ALTER TABLE "openvraag"
  ADD PRIMARY KEY ("id");

--
-- Indexen voor tabel "opleidingsprofiel"
--
ALTER TABLE ONLY "opleidingsprofiel"
ADD CONSTRAINT "opleidingsprofiel_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "organisatie"
--
ALTER TABLE ONLY "organisatie"
ADD CONSTRAINT "organisatie_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "osirisresultaattype"
--
ALTER TABLE "osirisresultaattype"
  ADD PRIMARY KEY ("id");

--
-- Indexen voor tabel "periode"
--
ALTER TABLE ONLY "periode"
ADD CONSTRAINT "periode_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "professionalskill"
--
ALTER TABLE ONLY "professionalskill"
ADD CONSTRAINT "professionalskill_pkey" PRIMARY KEY ("id");
  ADD KEY "FK_qdqi2mcdru727ptkfhksyht1x" ("activiteit_id");

--
-- Indexen voor tabel "toets"
--
ALTER TABLE ONLY "toets"
ADD CONSTRAINT "toets_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "toetselement"
--
ALTER TABLE ONLY "toetselement"
ADD CONSTRAINT "toetselement_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "toetsplanning"
--
ALTER TABLE ONLY "toetsplanning"
ADD CONSTRAINT "toetsplanning_pkey" PRIMARY KEY ("id");

--
--
-- Indexen voor tabel "trefwoord"
--

ALTER TABLE ONLY "trefwoord"
ADD CONSTRAINT "trefwoord_pkey" PRIMARY KEY ("id");

--
-- Indexen voor tabel "user"
--
ALTER TABLE ONLY "useraccount"
ADD CONSTRAINT "useraccount_pkey" PRIMARY KEY ("username");

--
-- Indexen voor tabel "werkveld"
--
ALTER TABLE ONLY "werkveld"
ADD CONSTRAINT "werkveld_pkey" PRIMARY KEY ("id");

--
-- SEQUENCE voor geëxporteerde tabellen
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- SEQUENCE voor een tabel "activiteit"
-- AUTO_INCREMENT voor een tabel "activiteit"
--
CREATE SEQUENCE "activiteit_id_seq"
    START WITH 11
    INCREMENT BY 1
    MINVALUE 11
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "activiteit_id_seq" OWNED BY "activiteit"."id";
ALTER TABLE ONLY "activiteit" ALTER COLUMN "id" SET DEFAULT "nextval"('"activiteit_id_seq"'::"regclass");


--
-- SEQUENCE voor een tabel "architectuurlaag"
-- AUTO_INCREMENT voor een tabel "architectuurlaag"
--

CREATE SEQUENCE "architectuurlaag_id_seq"
    START WITH 6
    INCREMENT BY 1
    MINVALUE 6
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "architectuurlaag_id_seq" OWNED BY "architectuurlaag"."id";
ALTER TABLE ONLY "architectuurlaag" ALTER COLUMN "id" SET DEFAULT "nextval"('"architectuurlaag_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "beoordelingselement"
-- AUTO_INCREMENT voor een tabel "beoordelingselement"
--

CREATE SEQUENCE "beoordelingselement_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beoordelingselement_id_seq" OWNED BY "beoordelingselement"."id";
ALTER TABLE ONLY "beoordelingselement" ALTER COLUMN "id" SET DEFAULT "nextval"('"beoordelingselement_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "beroepstaak"
-- AUTO_INCREMENT voor een tabel "beroepstaak"
--

CREATE SEQUENCE "beroepstaak_id_seq"
    START WITH 76
    INCREMENT BY 1
    MINVALUE 76
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beroepstaak_id_seq" OWNED BY "beroepstaak"."id";
ALTER TABLE ONLY "beroepstaak" ALTER COLUMN "id" SET DEFAULT "nextval"('"beroepstaak_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "beroepsproduct"
-- AUTO_INCREMENT voor een tabel "beroepsproduct"
--

CREATE SEQUENCE "beroepsproduct_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beroepsproduct_id_seq" OWNED BY "beroepsproduct"."id";
ALTER TABLE ONLY "beroepsproduct" ALTER COLUMN "id" SET DEFAULT "nextval"('"beroepsproduct_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "bloomniveau"
-- AUTO_INCREMENT voor een tabel "bloomniveau"
--

CREATE SEQUENCE "bloomniveau_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "bloomniveau_id_seq" OWNED BY "bloomniveau"."id";
ALTER TABLE ONLY "bloomniveau" ALTER COLUMN "id" SET DEFAULT "nextval"('"bloomniveau_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "cohort"
-- AUTO_INCREMENT voor een tabel "cohort"
--

CREATE SEQUENCE "cohort_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "cohort_id_seq" OWNED BY "cohort"."id";
ALTER TABLE ONLY "cohort" ALTER COLUMN "id" SET DEFAULT "nextval"('"cohort_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "cursus"
-- AUTO_INCREMENT voor een tabel "cursus"
--

CREATE SEQUENCE "cursus_id_seq"
    START WITH 14
    INCREMENT BY 1
    MINVALUE 14
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "cursus_id_seq" OWNED BY "cursus"."id";
ALTER TABLE ONLY "cursus" ALTER COLUMN "id" SET DEFAULT "nextval"('"cursus_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "docent"
-- AUTO_INCREMENT voor een tabel "docent"
--

CREATE SEQUENCE "docent_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "docent_id_seq" OWNED BY "docent"."id";
ALTER TABLE ONLY "docent" ALTER COLUMN "id" SET DEFAULT "nextval"('"docent_id_seq"'::"regclass");

CREATE SEQUENCE "geslotenvraag_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "geslotenvraag_id_seq" OWNED BY "geslotenvraag"."id";
ALTER TABLE ONLY "geslotenvraag" ALTER COLUMN "id" SET DEFAULT "nextval"('"geslotenvraag_id_seq"'::"regclass");

CREATE SEQUENCE "hibernate_sequence"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE "openvraag_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "openvraag_id_seq" OWNED BY "openvraag"."id";
ALTER TABLE ONLY "openvraag" ALTER COLUMN "id" SET DEFAULT "nextval"('"openvraag_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "leerdoel"
-- AUTO_INCREMENT voor een tabel "leerdoel"
--

CREATE SEQUENCE "leerdoel_id_seq"
    START WITH 6
    INCREMENT BY 1
    MINVALUE 6
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "leerdoel_id_seq" OWNED BY "leerdoel"."id";
ALTER TABLE ONLY "leerdoel" ALTER COLUMN "id" SET DEFAULT "nextval"('"leerdoel_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "leerlijn"
-- AUTO_INCREMENT voor een tabel "leerlijn"
--

CREATE SEQUENCE "leerlijn_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "leerlijn_id_seq" OWNED BY "leerlijn"."id";
ALTER TABLE ONLY "leerlijn" ALTER COLUMN "id" SET DEFAULT "nextval"('"leerlijn_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "millerniveau"
-- AUTO_INCREMENT voor een tabel "millerniveau"
--

-- TODO: sequence voor millerniveau

--
-- SEQUENCE voor een tabel "onderwerp"
-- AUTO_INCREMENT voor een tabel "onderwerp"
--

CREATE SEQUENCE "onderwerp_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "onderwerp_id_seq" OWNED BY "onderwerp"."id";
ALTER TABLE ONLY "onderwerp" ALTER COLUMN "id" SET DEFAULT "nextval"('"onderwerp_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "opleidingsprofiel"
-- AUTO_INCREMENT voor een tabel "opleidingsprofiel"
--

CREATE SEQUENCE "opleidingsprofiel_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "opleidingsprofiel_id_seq" OWNED BY "opleidingsprofiel"."id";
ALTER TABLE ONLY "opleidingsprofiel" ALTER COLUMN "id" SET DEFAULT "nextval"('"opleidingsprofiel_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "organisatie"
-- AUTO_INCREMENT voor een tabel "organisatie"
--

CREATE SEQUENCE "organisatie_id_seq"
    START WITH 2
    INCREMENT BY 1
    MINVALUE 2
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "organisatie_id_seq" OWNED BY "organisatie"."id";
ALTER TABLE ONLY "organisatie" ALTER COLUMN "id" SET DEFAULT "nextval"('"organisatie_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "osirisresultaattype"
-- AUTO_INCREMENT voor een tabel "osirisresultaattype"
--

CREATE SEQUENCE "osirisresultaattype_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "osirisresultaattype_id_seq" OWNED BY "osirisresultaattype"."id";
ALTER TABLE ONLY "osirisresultaattype" ALTER COLUMN "id" SET DEFAULT "nextval"('"osirisresultaattype_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "periode"
-- AUTO_INCREMENT voor een tabel "periode"
--

CREATE SEQUENCE "periode_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "periode_id_seq" OWNED BY "periode"."id";
ALTER TABLE ONLY "periode" ALTER COLUMN "id" SET DEFAULT "nextval"('"periode_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "professionalskill"
-- AUTO_INCREMENT voor een tabel "professionalskill"
--

CREATE SEQUENCE "professionalskill_id_seq"
    START WITH 16
    INCREMENT BY 1
    MINVALUE 16
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "professionalskill_id_seq" OWNED BY "professionalskill"."id";
ALTER TABLE ONLY "professionalskill" ALTER COLUMN "id" SET DEFAULT "nextval"('"professionalskill_id_seq"'::"regclass");


--
-- SEQUENCE voor een tabel "toets"
-- AUTO_INCREMENT voor een tabel "toets"
--

CREATE SEQUENCE "toets_id_seq"
    START WITH 3
    INCREMENT BY 1
    MINVALUE 3
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toets_id_seq" OWNED BY "toets"."id";
ALTER TABLE ONLY "toets" ALTER COLUMN "id" SET DEFAULT "nextval"('"toets_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "toetselement"
-- AUTO_INCREMENT voor een tabel "toetselement"
--

CREATE SEQUENCE "toetselement_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toetselement_id_seq" OWNED BY "toetselement"."id";
ALTER TABLE ONLY "toetselement" ALTER COLUMN "id" SET DEFAULT "nextval"('"toetselement_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "toetsplanning"
-- AUTO_INCREMENT voor een tabel "toetsplanning"
--

CREATE SEQUENCE "toetsplanning_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toetsplanning_id_seq" OWNED BY "toetsplanning"."id";
ALTER TABLE ONLY "toetsplanning" ALTER COLUMN "id" SET DEFAULT "nextval"('"toetsplanning_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "trefwoord"
-- AUTO_INCREMENT voor een tabel "trefwoord"
--

CREATE SEQUENCE "trefwoord_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "trefwoord_id_seq" OWNED BY "trefwoord"."id";
ALTER TABLE ONLY "trefwoord" ALTER COLUMN "id" SET DEFAULT "nextval"('"trefwoord_id_seq"'::"regclass");

--
-- SEQUENCE voor een tabel "werkveld"
-- AUTO_INCREMENT voor een tabel "werkveld"
--
CREATE SEQUENCE "werkveld_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "werkveld_id_seq" OWNED BY "werkveld"."id";
ALTER TABLE ONLY "werkveld" ALTER COLUMN "id" SET DEFAULT "nextval"('"werkveld_id_seq"'::"regclass");

--
-- Beperkingen voor tabel "beoordelingselement_toetselement"
--
ALTER TABLE "beoordelingselement_toetselement"
  ADD CONSTRAINT "fk_astwpup2huwxr31sml4ogg875" FOREIGN KEY ("BeoordelingsElement_id") REFERENCES "beoordelingselement" ("id"),
  ADD CONSTRAINT "fk_q1wfcf17lde4nberhgydtin67" FOREIGN KEY ("toetsElementen_id") REFERENCES "toetselement" ("id");

--
-- Beperkingen voor tabel "beroepsproduct"
--
ALTER TABLE "beroepsproduct"
  ADD CONSTRAINT "fk_sui24eyv9h3x6tfpif7ti7yxm" FOREIGN KEY ("id") REFERENCES "beoordelingselement" ("id");

--
-- Beperkingen voor tabel "beroepstaak"
--
ALTER TABLE "beroepstaak"
  ADD CONSTRAINT "fk_kw3jdrh44q9yerec6crm8m47b" FOREIGN KEY ("architectuurlaag_id") REFERENCES "architectuurlaag" ("id"),
  ADD CONSTRAINT "fk_s2me07sqv4c474qdr280ixsl9" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit" ("id");

--
-- Beperkingen voor tabel "cohort"
--
ALTER TABLE "cohort"
  ADD CONSTRAINT "fk_ccgxpn709nmyigkaf1xvulkim" FOREIGN KEY ("opleidingsProfiel_id") REFERENCES "opleidingsprofiel" ("id");

--
-- Beperkingen voor tabel "cohort_cursus"
--
ALTER TABLE "cohort_cursus"
  ADD CONSTRAINT "fk_3ekqp6i61q8vi3oaaqfqnoc74" FOREIGN KEY ("cohort_id") REFERENCES "cohort" ("id"),
  ADD CONSTRAINT "fk_t44j7yrbfl9sp7235bwknco9y" FOREIGN KEY ("cursussen_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "cursus"
--
ALTER TABLE "cursus"
  ADD CONSTRAINT "fk_hw0degphskbobm4m9wpfieoca" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id");

--
-- Beperkingen voor tabel "cursus_beroepstaak"
--
ALTER TABLE "cursus_beroepstaak"
  ADD CONSTRAINT "fk_gmqaje32vtdsjbkwfu7nwl4ry" FOREIGN KEY ("cursus_id") REFERENCES "cursus" ("id"),
  ADD CONSTRAINT "fk_irfq85i0voi3q4v7ijw55222o" FOREIGN KEY ("eindBTs_id") REFERENCES "beroepstaak" ("id");

--
-- Beperkingen voor tabel "cursus_onderwerp"
--
ALTER TABLE "cursus_onderwerp"
  ADD CONSTRAINT "fk_dw20bfo2rb2hbpad054gqtf10" FOREIGN KEY ("onderwerpen_id") REFERENCES "onderwerp" ("id"),
  ADD CONSTRAINT "fk_qkq72mhh52x8icv6fgqypjjte" FOREIGN KEY ("cursus_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "cursus_professionalskill"
--
ALTER TABLE "cursus_professionalskill"
  ADD CONSTRAINT "fk_2h9c9xvpx3s8fjk6ruprdw0wf" FOREIGN KEY ("eindPSs_id") REFERENCES "professionalskill" ("id"),
  ADD CONSTRAINT "fk_fd194moq3x5vxboyvvgovph8l" FOREIGN KEY ("cursus_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "cursus_trefwoord"
--
ALTER TABLE "cursus_trefwoord"
  ADD CONSTRAINT "fk_icdl8cwgh0255h855bqm48af0" FOREIGN KEY ("trefwoorden_id") REFERENCES "trefwoord" ("id"),
  ADD CONSTRAINT "fk_ovh1rbl9olr5ppj8wnda1g3k8" FOREIGN KEY ("cursus_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "docent"
--
ALTER TABLE "docent"
  ADD CONSTRAINT "fk_ioulcs791yeqanu0v3fvkk6kj" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id");

--
-- Beperkingen voor tabel "geslotenvraag"
--
ALTER TABLE "geslotenvraag"
  ADD CONSTRAINT "fk_o6e2p9e86t4v5dvvms4y76ddt" FOREIGN KEY ("id") REFERENCES "beoordelingselement" ("id");

--
-- Beperkingen voor tabel "leerdoel"
--
ALTER TABLE "leerdoel"
  ADD CONSTRAINT "fk_37pv9eeavdemclsrytoqt8jwy" FOREIGN KEY ("cursus_id") REFERENCES "cursus" ("id"),
  ADD CONSTRAINT "fk_m9pfuqrycghb0snvostmfvogc" FOREIGN KEY ("bloomniveau_id") REFERENCES "bloomniveau" ("id");

--
-- Beperkingen voor tabel "leerlijn_onderwerp"
--
ALTER TABLE "leerlijn_onderwerp"
  ADD CONSTRAINT "fk_1pc90xgya5s1r3mt6f6nb7yqu" FOREIGN KEY ("Leerlijn_Id") REFERENCES "leerlijn" ("Id"),
  ADD CONSTRAINT "fk_gqaq2wd0t98iru5nkmv5e2wyp" FOREIGN KEY ("onderwerpen_id") REFERENCES "onderwerp" ("id");

--
-- Beperkingen voor tabel "onderwerp_cursus"
--
ALTER TABLE "onderwerp_cursus"
  ADD CONSTRAINT "fk_2l2ee2k2fnu71ovvdlolr10fe" FOREIGN KEY ("Onderwerp_id") REFERENCES "onderwerp" ("id"),
  ADD CONSTRAINT "fk_qvko05812negb0j9px6q61x92" FOREIGN KEY ("cursussen_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "openvraag"
--
ALTER TABLE "openvraag"
  ADD CONSTRAINT "fk_l5r8xnhiknqo27qwj3poixd0m" FOREIGN KEY ("id") REFERENCES "beoordelingselement" ("id");

--
-- Beperkingen voor tabel "opleidingsprofiel"
--
ALTER TABLE "opleidingsprofiel"
  ADD CONSTRAINT "fk_i9erap1k01585f538c91jixjc" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id");

--
-- Beperkingen voor tabel "opleidingsprofiel_beroepstaak"
--
ALTER TABLE "opleidingsprofiel_beroepstaak"
  ADD CONSTRAINT "fk_39v4pcxxdjg11gomdw136n2eq" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel" ("id"),
  ADD CONSTRAINT "fk_jsgpqfj2xc9871neudyu9duw" FOREIGN KEY ("eindBTs_id") REFERENCES "beroepstaak" ("id");

--
-- Beperkingen voor tabel "opleidingsprofiel_cohort"
--
ALTER TABLE "opleidingsprofiel_cohort"
  ADD CONSTRAINT "fk_i2og4n9rcna0qpn0gsbi4s66y" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel" ("id"),
  ADD CONSTRAINT "fk_kw1xdvsafc8n7x7otwe66o2de" FOREIGN KEY ("cohorten_id") REFERENCES "cohort" ("id");

--
-- Beperkingen voor tabel "opleidingsprofiel_leerlijn"
--
ALTER TABLE "opleidingsprofiel_leerlijn"
  ADD CONSTRAINT "fk_fm2uils8ed3c9bvl79tbuqufo" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel" ("id"),
  ADD CONSTRAINT "fk_q3cxewy63tbr3wsvnorhnjlvw" FOREIGN KEY ("leerlijnen_id") REFERENCES "leerlijn" ("Id");

--
-- Beperkingen voor tabel "opleidingsprofiel_professionalskill"
--
ALTER TABLE "opleidingsprofiel_professionalskill"
  ADD CONSTRAINT "fk_lu0op8xyicl02p5xwloffkxqm" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel" ("id"),
  ADD CONSTRAINT "fk_mvg04ld4nvekx1nvusncevc6g" FOREIGN KEY ("eindPSs_id") REFERENCES "professionalskill" ("id");

--
-- Beperkingen voor tabel "organisatie_beroepstaak"
--
ALTER TABLE "organisatie_beroepstaak"
  ADD CONSTRAINT "fk_2db5g96ixkptp5lt5qw880ykm" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id"),
  ADD CONSTRAINT "fk_hocdlu4u5q4j1tbu8dgfnf7nl" FOREIGN KEY ("alleBeroepsTaken_id") REFERENCES "beroepstaak" ("id");

--
-- Beperkingen voor tabel "organisatie_cursus"
--
ALTER TABLE "organisatie_cursus"
  ADD CONSTRAINT "fk_fvyg65456495y0pwh7obet5tt" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id"),
  ADD CONSTRAINT "fk_r454xv1d7410cklsd3bqgbkrf" FOREIGN KEY ("alleCursussen_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "organisatie_professionalskill"
--
ALTER TABLE "organisatie_professionalskill"
  ADD CONSTRAINT "fk_41np2n3am9g6g669fm5v5tegf" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie" ("id"),
  ADD CONSTRAINT "fk_qv0qxo7jyrr2yk34xam7eb7rq" FOREIGN KEY ("professionalSkills_id") REFERENCES "professionalskill" ("id");

--
-- Beperkingen voor tabel "professionalskill"
--
ALTER TABLE "professionalskill"
  ADD CONSTRAINT "fk_qdqi2mcdru727ptkfhksyht1x" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit" ("id");

--
-- Beperkingen voor tabel "toetselement"
--
ALTER TABLE "toetselement"
  ADD CONSTRAINT "fk_2bbywfe3ian6qcg23gty34u5p" FOREIGN KEY ("leerdoel_id") REFERENCES "leerdoel" ("id"),
  ADD CONSTRAINT "fk_3gj46c9u0vb6qhiptpn88qm3b" FOREIGN KEY ("beoordelingselement_id") REFERENCES "beoordelingselement" ("id"),
  ADD CONSTRAINT "fk_aidapgk4lby6fmj33m99w5glj" FOREIGN KEY ("bloomNiveau_id") REFERENCES "bloomniveau" ("id"),
  ADD CONSTRAINT "fk_dki0wnhtluj36pl0vvdv0qqxa" FOREIGN KEY ("beoordelingselement_id") REFERENCES "beoordelingselement" ("id"),
  ADD CONSTRAINT "fk_s68gvyvmk9kxkoe8l906wanim" FOREIGN KEY ("leerdoel_id") REFERENCES "leerdoel" ("id"),
  ADD CONSTRAINT "fk_wi3vpcbct1v9587tq1kno3ny" FOREIGN KEY ("bloomNiveau_id") REFERENCES "bloomniveau" ("id");

--
-- Beperkingen voor tabel "toetsplanning_toetselement"
--
ALTER TABLE "toetsplanning_toetselement"
  ADD CONSTRAINT "fk_1xrl6t94fkss966hoa3x092yc" FOREIGN KEY ("toetsElementen_id") REFERENCES "toetselement" ("id"),
  ADD CONSTRAINT "fk_clhi3n9fgvpcau7ogopahfsup" FOREIGN KEY ("ToetsPlanning_id") REFERENCES "toetsplanning" ("id");

--
-- Beperkingen voor tabel "toets_beroepsproduct"
--
ALTER TABLE "toets_beroepsproduct"
  ADD CONSTRAINT "fk_8xo0oldv5m6vmi84146mlh1wo" FOREIGN KEY ("Toets_toets_id") REFERENCES "toets" ("toets_id"),
  ADD CONSTRAINT "fk_tm9car2a77pgfcu1dgtbl9cnf" FOREIGN KEY ("beroepsProducten_id") REFERENCES "beroepsproduct" ("id");

--
-- Beperkingen voor tabel "toets_geslotenvraag"
--
ALTER TABLE "toets_geslotenvraag"
  ADD CONSTRAINT "fk_cu8c5jcdf8iauvt2csfd51gkw" FOREIGN KEY ("geslotenVragen_id") REFERENCES "geslotenvraag" ("id"),
  ADD CONSTRAINT "fk_mhdl32rpyfqhev3v29lct3u0y" FOREIGN KEY ("Toets_toets_id") REFERENCES "toets" ("toets_id");

--
-- Beperkingen voor tabel "toets_openvraag"
--
ALTER TABLE "toets_openvraag"
  ADD CONSTRAINT "fk_9wcabhjyhr5re37kij58w6nfo" FOREIGN KEY ("Toets_toets_id") REFERENCES "toets" ("toets_id"),
  ADD CONSTRAINT "fk_jv6wrvg64fkivq724uhrhrv5f" FOREIGN KEY ("openVragen_id") REFERENCES "openvraag" ("id");

--
-- Beperkingen voor tabel "trefwoord"
--
ALTER TABLE "trefwoord"
  ADD CONSTRAINT "fk_h3so9kvm603mk3la4s3k6g8ty" FOREIGN KEY ("leerlijn_id") REFERENCES "leerlijn" ("Id");

--
-- Beperkingen voor tabel "trefwoord_cursus"
--
ALTER TABLE "trefwoord_cursus"
  ADD CONSTRAINT "fk_5buj14li6mkwx50q1lnvx6054" FOREIGN KEY ("trefwoord_id") REFERENCES "trefwoord" ("id"),
  ADD CONSTRAINT "fk_omop6e84r58i4hbtb6p5islv2" FOREIGN KEY ("cursussen_id") REFERENCES "cursus" ("id");

--
-- Beperkingen voor tabel "werkveld"
--
ALTER TABLE "werkveld"
  ADD CONSTRAINT "fk_e63kq5ykbiy81n386xx02a21x" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit" ("id"),
  ADD CONSTRAINT "fk_r9h01rybxno7jxqin3ws4y96o" FOREIGN KEY ("architectuurlaag_id") REFERENCES "architectuurlaag" ("id");

  --
  -- NOTE aan Berend: deze foreign keys stonden er oorspronkelijk niet in
  --


  ALTER TABLE ONLY "organisatie_professionalskill"
  ADD CONSTRAINT "uk_qv0qxo7jyrr2yk34xam7eb7rq" UNIQUE ("professionalskills_id");


  ALTER TABLE ONLY "beoordelingselement"
  ADD CONSTRAINT "fk_3wc9o5452emhllomss1hip2uf" FOREIGN KEY ("toets_id") REFERENCES "toets"("id");

  ALTER TABLE ONLY "toets"
  ADD CONSTRAINT "fk_cxcr4lqb7k54fwecor4fb59jb" FOREIGN KEY ("millerniveau_id") REFERENCES "millerniveau"("id");


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- TODO: heel goed testen op functions met de zojuist toegevoegde CONSTRAINTs

--
-- Tabelstructuur voor geëxporteerde tabellen in autorisatiebeheer
--

CREATE TABLE "function" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

INSERT INTO "function" ("id", "name") VALUES
(1, "beoordelingselement_get"),
(2, "beoordelingselement_put"),
(3, "beoordelingselement_delete"),
(4, "beoordelingselement_getlist"),
(5, "beroepstaak_get"),
(6, "beroepstaken_get"),
(7, "beroepstaaktypes_get"),
(8, "beroepstaak_find"),
(9, "cohort_get"),
(10, "cohort_put"),
(11, "cohortcursussen_get"),
(12, "cohortcursus_post"),
(13, "cohortcursus_delete"),
(14, "cursus_get"),
(15, "cursus_put"),
(16, "cursus_delete"),
(17, "cursusleerdoelen_get"),
(18, "cursusleerdoel_post"),
(19, "cursustoetsen_get"),
(20, "cursustoets_post"),
(21, "cursusberoepstaken_get"),
(22, "cursusberoepstaak_post"),
(23, "cursusberoepstaak_delete"),
(24, "cursusprofessionals_get"),
(25, "cursusprofessional_post"),
(26, "cursusprofessional_delete"),
(27, "cursuschecks_get"),
(28, "docent_get"),
(29, "docent_put"),
(30, "functions_get"),
(31, "function_get"),
(32, "function_post"),
(33, "function_put"),
(34, "function_delete"),
(35, "leerdoel_get"),
(36, "leerdoel_put"),
(37, "leerdoel_delete"),
(38, "leerdoeltoetselementen_get"),
(39, "leerdoeltoetselement_post"),
(40, "leerlijn_get"),
(41, "leerlijn_put"),
(42, "leerlijn_delete"),
(43, "leerlijntrefwoorden_get"),
(44, "leerlijntrefwoorden_post"),
(45, "leerplanschema_get"),
(46, "leerplanschemaprofiel_get"),
(47, "leerdoelencohortberoepstaak_get"),
(48, "ECTScohortberoepstaak_get"),
(49, "leerplanschema_check_get"),
(50, "millerniveaus_get"),
(51, "millerniveau_get"),
(52, "modules_get"),
(53, "module_get"),
(54, "module_post"),
(55, "module_put"),
(56, "module_delete"),
(57, "modulefunctions_get"),
(58, "modulefunction_post"),
(59, "modulefunction_delete"),
(60, "opleidingsprofiel_get"),
(61, "opleidingsprofiel_put"),
(62, "opleidingsprofielcohorten_get"),
(63, "opleidingsprofielcohort_post"),
(64, "opleidingsprofielberoepstaken_get"),
(65, "opleidingsprofielberoepstaken_check"),
(66, "opleidingsprofielprofessionals_get"),
(67, "opleidingsprofielleerlijnen_get"),
(68, "opleidingsprofielberoepstaak_post"),
(69, "opleidingsprofielberoepstaak_delete"),
(70, "opleidingsprofielprofessional_post"),
(71, "opleidingsprofielprofessional_delete"),
(72, "organisaties_get"),
(73, "organisatie_get"),
(74, "organisatie_post"),
(75, "organisatie_put"),
(76, "organisatie_delete"),
(77, "organisatiedocenten_get"),
(78, "organisatiedocent_put"),
(79, "organisatiecursussen_get"),
(80, "organisatiecursus_post"),
(81, "organisatieopleidingsprofielen_get"),
(82, "organisatieopleidingsprofiel_post"),
(83, "organisatieberoepstaken_get"),
(84, "professionals_get"),
(85, "professional_get"),
(86, "professionaltypes_get"),
(87, "professional_find"),
(88, "role_get"),
(89, "role_post"),
(90, "role_put"),
(91, "role_delete"),
(92, "rolemodules_get"),
(93, "rolemodule_post"),
(94, "rolemodule_delete"),
(95, "toetselement_get"),
(96, "toetselement_put"),
(97, "toetselement_delete"),
(98, "toetsmatrijs_get"),
(99, "toetsvorm_get"),
(100, "ects_get"),
(101, "calcprofiel_get"),
(102, "toets_get"),
(103, "toets_put"),
(104, "toets_delete"),
(105, "toetsbeoordelingselement_post"),
(106, "toetsbeoordelingselementen_get"),
(107, "users_get"),
(108, "user_delete"),
(109, "user_put"),
(110, "roles_get"),
(111,"userrole_get");

CREATE TABLE "module" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

--
-- Gegevens worden geëxporteerd voor tabel "module"
--

INSERT INTO "module" ("id", "name") VALUES
(1, "beheer_beoordelingselement"),
(2, "beheer_cursusberoepstaak"),
(3, "beheer_opleidingsprofielberoepstaak"),
(4, "beheer_cohort"),
(5, "beheer_organisatiecursus"),
(6, "beheer_cursus"),
(7, "beheer_organisatiedocent"),
(8, "beheer_docent"),
(9, "beheer_leerdoel"),
(10, "beheer_leerlijn"),
(11, "beheer_autorisatie"),
(12, "beheer_organisatie-opleidingsprofiel"),
(13, "beheer_opleidingsprofiel"),
(14, "beheer_organisatie"),
(15, "beheer_cursussentoets"),
(16, "beheer_toets"),
(17, "read_toets"),
(18, "beheer_leerdoelentoetselement"),
(19, "beheer_toetselement"),
(20, "read_domeinpubliek");

CREATE TABLE "role" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

--
-- Gegevens worden geëxporteerd voor tabel "role"
--

INSERT INTO "role" ("id", "name") VALUES
(1, "publiek"),
(2, "admin"),
(3, "cursusleider"),
(4, "cursuscommissie"),
(5, "curriculumcommissie"),
(6, "developer");

--
-- Tabelstructuur voor tabel "user"
--

CREATE TABLE "useraccount" (
    "username" character varying(255) NOT NULL,
    "role_id" integer
);



CREATE TABLE "function_module" (
    "module_id" integer NOT NULL,
    "function_id" integer NOT NULL
);

CREATE TABLE "module_role" (
    "role_id" integer NOT NULL,
    "module_id" integer NOT NULL
);

--
-- SEQUENCE voor geëxporteerde tabellen in autorisatiebeheer
-- AUTO_INCREMENT voor geëxporteerde tabellen in autorisatiebeheer
--

CREATE SEQUENCE "module_id_seq"
    START WITH 21
    INCREMENT BY 1
    MINVALUE 21
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "module_id_seq" OWNED BY "module"."id";
ALTER TABLE ONLY "module" ALTER COLUMN "id" SET DEFAULT "nextval"('"module_id_seq"'::"regclass");

CREATE SEQUENCE "role_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "role_id_seq" OWNED BY "role"."id";
ALTER TABLE ONLY "role" ALTER COLUMN "id" SET DEFAULT "nextval"('"role_id_seq"'::"regclass");

CREATE SEQUENCE "function_id_seq"
    START WITH 112
    INCREMENT BY 1
    MINVALUE 112
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "function_id_seq" OWNED BY "function"."id";
ALTER TABLE ONLY "function" ALTER COLUMN "id" SET DEFAULT "nextval"('"function_id_seq"'::"regclass");

--
-- Beperkingen voor geëxporteerde tabellen in autorisatiebeheer
--

ALTER TABLE ONLY "function"
ADD CONSTRAINT "function_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "module"
ADD CONSTRAINT "module_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "role"
ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id"),
ADD CONSTRAINT "uk_8sewwnpamngi6b1dwaa88askk" UNIQUE ("name");

ALTER TABLE ONLY "function"
ADD CONSTRAINT "uk_bn41k01mf22q8kpqgx37a7fdl" UNIQUE ("name");


ALTER TABLE ONLY "module"
ADD CONSTRAINT "uk_f73dsvaor0f4cycvldyt2idf1" UNIQUE ("name");

ALTER TABLE ONLY "function_module"
ADD CONSTRAINT "uk_1k2ctjeas1qtk4ueex1sltju1" UNIQUE ("module_id", "function_id"),
ADD CONSTRAINT "uk_1k2ctjeas1qtk4ueex1sltju1" UNIQUE ("module_id", "function_id"),
ADD CONSTRAINT "fk_i2s28m194yhq06goqx5q0gj23" FOREIGN KEY ("module_id") REFERENCES "module"("id");

ALTER TABLE ONLY "module_role"
ADD CONSTRAINT "uk_s3ejxrx1hn6bx97rkwbu54pcu" UNIQUE ("role_id", "module_id"),
ADD CONSTRAINT "fk_dwtbbqqp16hsbg50h966l0rsc" FOREIGN KEY ("role_id") REFERENCES "role"("id"),
ADD CONSTRAINT "fk_ea2wjp6trh24smvit2qggan3s" FOREIGN KEY ("module_id") REFERENCES "module"("id");

ALTER TABLE ONLY "useraccount"
ADD CONSTRAINT "fk_q4p5eim90h3r4s0f0owog07n0" FOREIGN KEY ("role_id") REFERENCES "role"("id");

COMMIT;
