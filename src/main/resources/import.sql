INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (1, "Onthouden", "");
INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (2, "Begrijpen", "");
INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (3, "Toepassen", "");
INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (4, "Analyseren", "");
INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (5, "Evalueren", "");
INSERT INTO "bloomniveau" ("id", "niveau", "omschrijving") VALUES (6, "Creëren", "");

INSERT INTO "millerniveau" ("id", "niveau", "omschrijving") VALUES (1, "Weten", "Kennistoets");
INSERT INTO "millerniveau" ("id", "niveau", "omschrijving") VALUES (2, "Toepassen", "Toepassen van kennis in schriftelijke casus / opdracht");
INSERT INTO "millerniveau" ("id", "niveau", "omschrijving") VALUES (3, "Tonen", "Beoordeling in realistische voorspelbare situatie (simulatie/project)");
INSERT INTO "millerniveau" ("id", "niveau", "omschrijving") VALUES (4, "Doen", "Beoordeling in echte beroepssituaties");

INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES (1, "Beheren", "Het beheersbaar laten verlopen van alle activiteiten gericht op het proces van ontwikkeling, ingebruikname en gebruik van ict-systemen.");
INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES (2, "Analyseren", "Het analyseren van processen, producten en informatiestromen  in hun onderlinge samenhang en de context van de omgeving.");
INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES (3, "Adviseren", "Het adviseren over de herinrichting van processen en/of informatiestromen  en voor een nieuw te ontwikkelen of aan te schaffen ict-systeem op basis van een analyse en in overleg met stakeholders.");
INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES (4, "Ontwerpen", "Het ontwerpen van een ict-systeem op basis van specificaties en binnen vooraf gestelde kaders.");
INSERT INTO "activiteit" ("id", "naam", "omschrijving") VALUES (5, "Realiseren", "Het realiseren van een ict-systeem op basis van een ontwerp en binnen gestelde kaders.");

--INSERT INTO activiteit (id, naam, omschrijving) VALUES (6, 'Leiderschap', 'neem initiatief en vervul een leidende rol in een team om de gestelde doelen te bereiken.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (7, 'Samenwerken', 'draag actief bij aan het product of het resultaat van het team.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (8, 'Planning en organisatie', 'plan, beheers en evalueer het individuele en het team-werk. Gebruik geschikte methodes om het eigen gedrag te monitoren.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (9, 'Communicatie', 'Communicatie: spreek en schrijf vloeiend en correct Nederlands [niveau: C1 - C2] en Engels [B2], zowel in gesproken als geschreven taal. Neem deel aan vergaderingen, voer gesprekken, maak project- documentatie, schrijf klantrapporten, houd presentaties en maak bij de communicatie gebruik van relevante visuele ondersteuning. Weet wanneer formeel en informeel taalgebruik gepast is.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (10, 'Analyse en informatieverwerking', 'mobiliseer kennis rond een kwestie; formuleer hierover hoofd- en deelvragen, kies en pas geschikte onderzoeksmethoden toe; genereer, verzamel en analyseer gegevens zorgvuldig en nauwkeurig; lever antwoorden op die samenhang vertonen en taal- en rekenkundig kloppen.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (11, 'Creatief problemen oplossen', 'Ontwikkel systematisch de aanpak van een kwestie, gebruik hierbij (wetenschappelijk) onderbouwde methoden èn creativiteit, werk vakkundig en evalueer (tussen)resultaten aan de hand van kwaliteitscriteria.'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (12, 'Leren en persoonlijke ontwikkeling', 'Ken de eigen grenzen en de sterke en zwakke kanten en ontwikkel jezelf door zelfreflectie en zelfbeoordeling van de eigen (leer)resultaten. Neem verantwoordelijkheid voor de eigen activiteiten, accepteer kritiek van anderen en maak er goed gebruik van. Neem initiatief en werk zelfstandig'));
--INSERT INTO activiteit (id, naam, omschrijving) VALUES (13, 'Verantwoordelijkheid en zelfstandigheid', 'Laat maatschappelijke, normatieve en ethische aspecten meewegen in de oordeels- en besluitvorming in de beroepspraktijk. Draagt verantwoordelijkheid voor de eigen handelingen. Zorg dat jouw gedrag passend is binnen de waarden, normen, cultuur, behoeften, prioriteiten en doelstellingen van de organisatie en maatschappij waarin je werk en leeft.'));

INSERT INTO activiteit (id, naam, omschrijving) VALUES (6, 'CPO', 'Creatief problemen oplossen');
INSERT INTO activiteit (id, naam, omschrijving) VALUES (7, 'OD', 'Onderzoek doen');
INSERT INTO activiteit (id, naam, omschrijving) VALUES (8, 'LSC', 'Leiderschap, Samenwerken, Communicatie');
INSERT INTO activiteit (id, naam, omschrijving) VALUES (9, 'POKe', 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek');
INSERT INTO activiteit (id, naam, omschrijving) VALUES (10, 'LPO', 'Leren & Persoonlijke Ontwikkeling');

INSERT INTO architectuurlaag (id, naam, omschrijving) VALUES (1, 'Gebruikersinteractie', 'Gebruikersinteractie heeft betrekking op de communicatie van de (eind)gebruiker) met het ict-systeem. Hier wordt nadrukkelijk niet de interactie bedoeld met gebruikers zoals die plaatsvindt tijdens het tot stand komen van een ict-systeem; dat is immers in elk van de architectuurlagen aan de orde.');
INSERT INTO architectuurlaag (id, naam, omschrijving) VALUES (2, 'Bedrijfsprocessen', 'Bedrijfsprocessen heeft betrekking op het faciliteren van organisatieprocessen door middel van ict-systemen. Daarbij gaat het om de functionaliteit van het systeem als geheel (geautomatiseerde en niet geautomatiseerde delen) bezien vanuit de context van de te realiseren organisatiedoelen.');
INSERT INTO architectuurlaag (id, naam, omschrijving) VALUES (3, 'Infrastructuur', 'Infrastructuur betreft het geheel aan ict-systemen waarmee bedrijfsprocessen  gefaciliteerd worden. Het gaat hier om beschikbaar stellen, beschikbaar houden en configureren van de traditionele hardware-infrastructuur, maar zeker ook de software-infrastructuur.');
INSERT INTO architectuurlaag (id, naam, omschrijving) VALUES (4, 'Software', 'Software betreft het ontwikkelen van diverse soorten software. Dit betreft software die na oplevering wordt opgenomen in een ict-infrastructuur.');
INSERT INTO architectuurlaag (id, naam, omschrijving) VALUES (5, 'Hardware interfacing', 'Hardware interfacing is van toepassing wanneer software interactie aangaat met beschikbare hardware. Hierbij gaat het om situaties waarbij in de software expliciet rekening gehouden moet worden met mogelijkheden en beperkingen van de beschikbare hardware. Gekozen is voor ‘computersysteem’ als generieke, overkoepelende term. Afhankelijk van de context kan dit nader gespecificeerd worden in‘embedded systeem’, ‘industrial automation’, ‘virtueel systeem’ e.d.');
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (1, 1, 1, 'Vanaf de start van product- of dienstontwikkeling rekening houden met productverantwoording, productcontext, continuïteit en overdracht naar de opdrachtgever en/of gebruikersomgeving.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (2, 1, 1, 'Het toepassen van versiebeheer en het inrichten en configureren van een samenwerkingsomgeving bij de realisatie van ict- en/of digitale mediaproducten,  rekening houdend met onderhoudbaarheid en daarvoor beschikbare middelen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (3, 1, 1, 'Het inrichten en onderhouden van de eigen werkomgeving voor analyse, ontwerp en realisatie van ict- en/of digitale mediaproducten m.b.v. een gangbare tool. Het overdragen van een gedefinieerde versie van het eindproduct, inclusief productverantwoording, aan een opdrachtgever.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (4, 2, 1, 'Het in kaart brengen van trends in communicatie en designrepertoire van ict- en/of digitale mediaproducten. Het opstellen van een analyserapportage (doelgroep, doelstelling, context, informatie- en communicatiebehoefte, visualisatie, bruikbaarheid en gebruik), en dit relateren aan trends in ict- en/of digitale mediaproducten.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (5, 2, 1, 'Het analyseren van ict- en/of digitale mediaproducten, doelgroepen en doelstellingen vanuit een overzicht van actuele ‘cultuur’ en trends t.b.v. de inventarisatie van klant- of gebruikersbehoeften. Een interface-, gebruiks- en communicatieanalyse maken, inclusief usability en user- experience.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (6, 2, 1, 'Het designrepertoire (vormen, kleuren, stijlkenmerken) inventariseren en de merk- of productidentiteit beschrijven voor een actueel ict- en/of digitaal mediaproduct. Doelgroepen en doelstellingen onderscheiden en deze koppelen aan gebruikersgedrag  en interactie.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (7, 3, 1, 'Maatschappelijke en branchetrends verwerken In een advies voor de concrete inzet van media en middelen bij de ontwikkeling van ict- en of digitale mediaproducten, rekening houdend met planning en budget.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (8, 3, 1, 'Adviseren over de concrete inzet van media en middelen, rekening houdend met (communicatie)doelstellingen, doelgroepen, planning en budget.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (9, 3, 1, 'Adviseren over toe te passen interactie-, communicatie- en beeldende middelen voor inzet in communicatie en interface- ontwikkeling. Op basis van een gegeven usability-analyse aanbevelingen doen voor het ontwerp van een ict- en/of digitaal mediaproduct', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (10, 4, 1, 'Ontwerpen van ict- en/of digitale mediaproducten vanuit een zelf ontworpen (vernieuwende) functionaliteit, interactievorm, stijl en/of dienst, met inbegrip van user experience, usability-testen en innovatieve technologie.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (11, 4, 1, 'Ontwerpen van samenhangende, dynamische ict- en/of digitale mediaproducten met toepassing van gedeeltelijk zelf geselecteerde technieken zoals scripts, storyboards, navigatiestructuur en passende usability-testen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (12, 4, 1, 'Ontwerpen van statische en beperkt dynamische ict- en/of digitale mediaproducten met toepassing van gegeven technieken, zoals scenario’s, storyboards en wire frames en passende usability-testen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (13, 5, 1, 'Realiseren en testen van dynamische ict- en/of digitale mediaproducten  met toepassing van innovatieve technologieën.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (14, 5, 1, 'Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (15, 5, 1, 'Het realiseren en testen van dynamische ict- en/of digitale mediaproducten met toepassing van relevante grafische elementen, geluid, beeld, en animaties.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (16, 1, 2, 'Het inrichten en actualiseren van principes, business rules en modellen van procesarchitectuur, mede op basis van kwantitatieve en kwalitatieve analyse. Het proactief signaleren van behoefte aan verandering en bijbehorende processen in gang zetten.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (17, 1, 2, 'Het inrichten, onderhouden en actualiseren van functioneel beheer. De behoefte aan procesveranderingen signaleren en inventariseren, mede op basis van gegevens uit kwantitatieve en kwalitatieve analyse.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (18, 1, 2, 'Het onderhouden en actualiseren van procesdocumentatie. Het beschrijven van de veranderingsbehoefte bij een proces op basis van gegevens uit kwantitatieve en kwalitatieve analyse.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (19, 2, 2, 'Het in kaart brengen van de consequenties van een (strategische) koerswijziging voor bedrijfsprocessen en hun informatievoorziening. Een kwantitatieve en/of kwalitatieve analyse maken van de huidige en toekomstige situatie op het gebied van bijvoorbeeld beleid, strategie, alignment en architectuur, met gebruikmaking van gangbare methoden.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (20, 2, 2, 'Het analyseren van bedrijfsprocessen, organisatie, gegevensstromen, databehoeften en procesbesturing (op tactisch/operationeel niveau) en het beschrijven van knelpunten en oorzaak-gevolgrelaties vanuit de invalshoek van de informatievoorziening', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (21, 2, 2, 'Het inventariseren van de gegevensstromen en informatievoorziening binnen een bedrijfsproces. Het analyseren van knelpunten van een bedrijfsproces en het beschrijven van oorzaak- gevolgrelaties.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (22, 3, 2, 'Adviseren over de in- en externe afstemming tussen business en ict (alignment en governance) op basis van de (netwerk-)organisatiestrategie en doelstellingen', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (23, 3, 2, 'Adviseren over knelpunten op het terrein van organisatiestructuur (en rollen), (bedrijfs)processtructuur en samenhang, en informatievoorziening. Adviseren over nieuwe mogelijkheden voor de organisatie op basis van ontwikkelingen  in ict.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (24, 3, 2, 'Op basis van geanalyseerde knelpunten binnen een (bedrijfs)proces verbeteringen formuleren voor organisatie(structuur), (bedrijfs)processtructuur en/of informatieverzorging, met inachtneming van mogelijkheden van ict. Adviseren over de toepasbaarheid van een ict- ontwikkeling voor een organisatie.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (25, 4, 2, 'Het (her)ontwerpen van de architectuur van bedrijfsprocessen en besturingsmodellen, inclusief bijbehorende beheersing, informatievoorziening en veranderproces.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (26, 4, 2, 'Het (her)ontwerpen van samenhangende bedrijfsprocessen, een gegevensstructuur (model), het procesmanagement van bedrijfsprocessen, de functionele organisatiestructuur en/of de informatievoorziening, met inachtneming van mogelijkheden van ict en de borging van integriteit van de gegevens.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (27, 4, 2, 'Het (her)ontwerpen en/of digitaliseren van een bedrijfsproces, enkele gegevensstromen, een organisatieonderdeel en/of een deel van de informatievoorziening.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (28, 5, 2, 'Het realiseren van invoering en acceptatie realiseren van gewijzigde bedrijfsvoering op basis van een veranderproces.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (29, 5, 2, 'Het realiseren van de invoering en acceptatie van procedures in samenhang met nieuwe of gewijzigde informatievoorziening en besturing.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (30, 5, 2, 'Het beschrijven en opstellen van werkinstructies, functie- en rolbeschrijvingen, en procedures voor een (aangepast) proces.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (31, 1, 3, 'Ict-beheer afstemmen in horizontale richting (leveranciers, third-party) en in verticale richting (alignment). Het beheer opzetten en uitvoeren van een public of private cloudgebaseerde infrastructuur.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (32, 1, 3, 'Het in beheer onderbrengen van nieuwe technologische ontwikkelingen in infrastructuur, waaronder gebruikersdevices. Implementeren van beheerprocessen. Opzetten van een beheeromgeving om de kwaliteit van de ict-dienstverlening te kunnen meten, waaronder het ontvangen en afhandelen van klantverzoeken, en te kunnen rapporteren overdienstenniveau.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (33, 1, 3, 'Opzetten en documenteren van authenticatie- en autorisatiestructuur, systeem- en netwerkconfiguratie voor een lokale infrastructuur. Documenteren van standaardbeheerprocessen en - werkprocedures ten behoeve van beheer van infrastructuur.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (34, 2, 3, 'Onderzoek doen naar trends op het gebied van ict-infrastructuur op basis van (internationale) technologische, economische en maatschappelijke ontwikkelingen en innovaties. Een requirementsanalyse uitvoeren voor een bedrijfsinfrastructuur om functionele en niet-functionele eisen in kaart te brengen.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (35, 2, 3, 'Analyseren van de kwaliteit van de infrastructuuromgeving en - services aan de hand van gangbare modellen en methoden. Analyseren van aan infrastructuur gerelateerde incidenten, problemen en security- bedreigingen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (36, 2, 3, 'Een infrastructuur analyseren volgens een standaardmethode en op basis van gegeven functionele eisen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (37, 3, 3, 'Adviseren over infrastructuur, inclusief beheer en beveiliging, in relatie tot informatiearchitectuur, IT governance, innovatie, maatschappelijke  en internationale ontwikkelingen.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (38, 3, 3, 'Adviseren over inrichting en beheer van een infrastructuur met onderbouwde keuzes vanuit functionele en niet-functionele eisen, en vanuit beschikbare technologie, beheermodellen  en beheermethodes. Maatregelen voorstellen die de informatiebeveiliging van de infrastructuur ten goede komen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (39, 3, 3, 'Aanbevelingen doen over een opzet van een lokale infrastructuur.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (40, 4, 3, 'Ontwerpen van een cloudgebaseerde infrastructuur met inachtneming van alle requirements. Ontwerpen van een incident response organisatie en systemen om adequaat te kunnen reageren op incidenten van iedere aard en omvang.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (41, 4, 3, 'Het beschrijven van beheerprocessen en afspraken omtrent te leveren diensten. Een functioneel ontwerp opstellen voor het automatiseren van het beheer van een infrastructuur in een specifieke bedrijfsomgeving. Een technisch ontwerp opstellen voor een infrastructuur met bijbehorende beveiliging op basis van functionele en niet-functionele eisen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (42, 4, 3, 'Specificaties opstellen voor een lokale infrastructuur volgens een standaardmethode.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (43, 5, 3, 'Realiseren van public of private cloudgebaseerde infrastructuur en -services, met inachtneming van alle requirements. Opzetten van een geïntegreerde multi-level ict- omgeving om de kwaliteit en security van ict-dienstverlening centraal te kunnen monitoren.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (44, 5, 3, 'Een infrastructuur inrichten die voldoet aan gestelde eisen op gebied van performance, usability, security en compliance. Opzetten van basismonitoring van de infrastructuur. Opstellen en uitvoeren van een testplan voor een infrastructuur om de kwaliteit te toetsen op basis van het opgestelde functionele en niet-functionele ontwerp.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (45, 5, 3, 'Een lokale infrastructuur inrichten, testen en beschikbaar stellen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (46, 1, 4, 'Uitvoeren van configuratie-, change- en releasemanagement', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (47, 1, 4, 'Inrichten, beheren en gebruikmaken van een ontwikkelstraat ter ondersteuning van softwareontwikkeling in teams. Principes toepassen om een softwareontwikkelproces te managen en te bewaken.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (48, 1, 4, 'Inrichten en gebruikmaken van beheersysteem ter ondersteuning van softwareontwikkeling in teamverband.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (49, 2, 4, 'Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden in een context van bestaande systemen. Integratie en migratieproblematiek in kaart brengen. Acceptatiecriteria definiëren aan de hand van kwaliteitseigenschappen en een uitgevoerde risicoanalyse.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (50, 2, 4, 'Een requirementanalyse uitvoeren voor een softwaresysteem met verschillende belanghebbenden, rekeninghoudend met de kwaliteitseigenschappen. Een analyse uitvoeren om functionaliteit, ontwerp, interfaces e.d. van een bestaand systeem of bestaande component te formuleren en te valideren. Een acceptatietest opstellen aan de hand van kwaliteitseigenschappen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (51, 2, 4, 'Verzamelen en valideren van functionele eisen voor een softwaresysteem met één belanghebbende en volgens een standaardmethode. Acceptatiecriteria definiëren voor bovengenoemde  functionele eisen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (52, 3, 4, 'Adviseren met betrekking tot de keuze voor softwarearchitectuur of software frameworks, waarbij kostenaspecten en kwaliteitskenmerken zoals beschikbaarheid, performance, security en schaalbaarheid  een rol spelen. Adviseren over de inrichting van een softwareontwikkelproces, waaronder het testproces.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (53, 3, 4, 'Adviseren over eventuele aanschaf en vervolgens selectie van bestaande software of componenten bij het ontwikkelen van softwaresysteem, waarbij het kostenaspect een rol speelt. Adviseren over een onderdeel van een architectuur of een beperkt softwaresysteem. Adviseren over het gebruik van prototypes bij het valideren van de eisen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (54, 3, 4, 'Aanbevelingen  doen over specifieke requirements van een softwaresysteem op grond van onderzoek naar bestaande, vergelijkbare systemen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (55, 4, 4, 'Een softwarearchitectuur opstellen voor een softwaresysteem, bestaande uit reeds bestaande en nieuwe systemen, rekening houdend met kwaliteitskenmerken en belanghebbenden. Opstellen van teststrategie voor systeemtesten.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (56, 4, 4, 'Opstellen van een ontwerp voor een softwaresysteem, rekening houdend met het gebruik van bestaande componenten en libraries; gebruik maken van ontwerp- kwaliteitscriteria. Vaststellen van de kwaliteit van het ontwerp, bijvoorbeeld door toetsing of prototyping, rekening houdend met de geformuleerde kwaliteitseigenschappen. Testontwerpen opstellen volgens een gegeven teststrategie.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (57, 4, 4, 'Een ontwerp maken voor een softwaresysteem met modelleertechnieken volgens een standaardmethode.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (58, 5, 4, 'Bouwen en beschikbaar stellen van een softwaresysteem dat aansluit bij bestaande systemen, volgens de ontworpen architectuur met gebruik van bestaande frameworks. Gebruikmaken van testautomatisering  bij het uitvoeren van testen', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (59, 5, 4, 'Bouwen en beschikbaar stellen van een softwaresysteem dat bestaat uit meerdere subsystemen, hierbij gebruik makend van bestaande componenten. Integreren van softwarecomponenten in een bestaand systeem, waarbij o.a. de integriteit en systeemprestaties  bewaakt worden. Uitvoeren van regressietesten. Uitvoeren van en rapporteren over unit-, integratie- en systeemtesten.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (60, 5, 4, 'Een eenvoudig softwaresysteem bouwen, testen en beschikbaar stellen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (61, 1, 5, 'Een ontwikkel- en testplatform ten behoeve van hardware/software co-design inrichten, inclusief tools (bijvoorbeeld voor virtualisatie). Een beheertestomgeving voor een computersysteem  inrichten.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (62, 1, 5, 'Een (crossplatform) ontwikkelomgeving inrichten, zowel software- als hardware- gerelateerd, inclusief tools. Een gegeven ontwikkelomgeving beoordelen op kwaliteit en prestaties.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (63, 1, 5, 'Inrichten en gebruikmaken van een beheeromgeving ter ondersteuning van de ontwikkeling van een computersysteem, bijv. een embedded of IA-systeem, in teamverband.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (64, 2, 5, 'Een gedistribueerd computersysteem specificeren, inclusief timing, resourcegebruik en performance. Security-aspecten beschrijven van computersystemen die aan of via (openbare) netwerken gekoppeld zijn. Acceptatietestplan en integratietestplan opstellen.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (65, 2, 5, 'Signalerings- en regelingsaspecten van de omgeving van een computersysteem in kaart brengen. Een computersysteem  methodisch specificeren. Een protocolanalyse uitvoeren. Een acceptatietest voor een computersysteem opstellen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (66, 2, 5, 'Architectuur van een computersysteem  beschrijven. Werking van actuatoren en sensoren beschrijven en metingen verrichten. Functionele en niet-functionele eisen voor een computersysteem, bijv. een embedded of IA-systeem, en acceptatiecriteria opstellen.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (67, 3, 5, 'Een technisch advies uitbrengen over een te realiseren (gedistribueerd) computersysteem, inclusief hardware- en software- componenten en koppelingen.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (68, 3, 5, 'Een technisch advies uitbrengen voor de architectuur van een computersysteem en de hardware- en software- componenten. Advies uitbrengen over het koppelen van systemen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (69, 3, 5, 'Een gegeven technisch advies verifiëren en onderbouwen. Een initiële architectuur en de functionaliteit van een gegeven systeemconfiguratie (microprocessor, geheugen of andere bouwstenen) verifiëren en beschrijven.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (70, 4, 5, 'Een gedistribueerd computersysteem ontwerpen, inclusief bepaling van actuatoren, sensoren, timing, resourcegebruik en performance.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (71, 4, 5, 'Een computersysteem methodisch ontwerpen op basis van zelfgekozen hardwarecomponenten. Een driverontwerp opstellen. Een protocol ontwerpen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (72, 4, 5, 'Een eenvoudig computersysteem, bijv. een embedded of IA- systeem, ontwerpen op basis van gegeven hardware.', 1);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (73, 5, 5, 'Een compleet computersysteem verwezenlijken, inclusief netwerk, hardware en systeemsoftware. Een acceptatieprocedure opstellen en uitvoeren, bijv. in een virtuele omgeving, inclusief aspecten als timing, resourcegebruik en performance.', 3);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (74, 5, 5, 'Een eenvoudig computersysteem inrichten en de koppelingen met hardwarecomponenten realiseren via software. Driversoftware schrijven en testen. Een protocol implementeren  en testen.', 2);
INSERT INTO beroepstaak (id, activiteit_id, architectuurlaag_id, beschrijving, niveau) VALUES (75, 5, 5, 'Software schrijven voor een eenvoudig, gegeven computersysteem, voorzien van actuatoren en sensoren.', 1);
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (1, 6, 'CPO', 'Creatief problemen oplossen', 'T');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (2, 7, 'OD', 'Onderzoek doen', 'T');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (3, 8, 'LSC', 'Leiderschap, Samenwerken, Communicatie', 'T');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (4, 9, 'POKe', 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'T');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (5, 10, 'LPO', 'Leren & Persoonlijke Ontwikkeling', 'T');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (6, 6, 'CPO', 'Creatief problemen oplossen', 'P');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (7, 7, 'OD', 'Onderzoek doen', 'P');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (8, 8, 'LSC', 'Leiderschap, Samenwerken, Communicatie', 'P');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (9, 9, 'POKe', 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'P');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (10, 10, 'LPO', 'Leren & Persoonlijke Ontwikkeling', 'P');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (11, 6, 'CPO', 'Creatief problemen oplossen', 'S');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (12, 7, 'OD', 'Onderzoek doen', 'S');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (13, 8, 'LSC', 'Leiderschap, Samenwerken, Communicatie', 'S');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (14, 9, 'POKe', 'Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek', 'S');
INSERT INTO professionalskill (id, activiteit_id, code, beschrijving, niveau) VALUES (15, 10, 'LPO', 'Leren & Persoonlijke Ontwikkeling', 'S');

INSERT INTO "organisatie" ("id", "naam") VALUES (1, "Hogeschool Utrecht I-ICT");
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (1, "Berend Wilkens", 1);
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (2, "Leo Pruijt", 1);
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (3, "Dan Greve", 1);
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (4, "Jeroen Weber", 1);
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (5, "Rik Jansen", 1);
INSERT INTO "docent" ("id", "naam", "organisatie_id") VALUES (6, "Rik Boss", 1);
INSERT INTO "opleidingsprofiel" ("id", "naam", "organisatie_id") VALUES (1, "Business IT and Management", 1);
INSERT INTO "opleidingsprofiel" ("id", "naam", "organisatie_id") VALUES (2, "Software and Information Enginering", 1);
INSERT INTO "opleidingsprofiel" ("id", "naam", "organisatie_id") VALUES (3, "System and Network Enginering", 1);
INSERT INTO "opleidingsprofiel" ("id", "naam", "organisatie_id") VALUES (4, "Technische Informatica", 1);
INSERT INTO "opleidingsprofiel_beroepstaak" values (1, 1);
INSERT INTO "opleidingsprofiel_beroepstaak" values (1, 5);
INSERT INTO "opleidingsprofiel_beroepstaak" values (1, 7);
INSERT INTO "opleidingsprofiel_beroepstaak" values (1, 11);
INSERT INTO "opleidingsprofiel_beroepstaak" values (1, 45);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 3);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 6);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 9);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 11);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 14);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 21);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 36);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 39);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 47);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 50);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 54);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 55);
INSERT INTO "opleidingsprofiel_beroepstaak" values (2, 58);
INSERT INTO "cohort" ("id", "jaar", "opleidingsprofiel_id") VALUES (1, "2017", 1);
INSERT INTO "cohort" ("id", "jaar", "opleidingsprofiel_id") VALUES (2, "2017", 2);
INSERT INTO "cohort" ("id", "jaar", "opleidingsprofiel_id") VALUES (3, "2017", 3);
INSERT INTO "cohort" ("id", "jaar", "opleidingsprofiel_id") VALUES (4, "2017", 4);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (1, "TICT-V1PROG-15", 1, 5, "Programming", 1, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (2, "TICT-V1ICOR-15", 1, 5, "ICT and Organisation", 1, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (3, "TICT-V1CSN-15", 1, 5, "Computer, system and network", 1, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (4, "TICT-V1MOD-15", 1, 5, "Modelling", 2, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (5, "TICT-V1WAC-15", 1, 5, "Web Application Construction", 4, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (6, "TICT-V1AUI-15", 1, 5, "Analysis & User Interfacing", 3, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (7, "TICT-V1OODC-15", 1, 5, "Object Oriented Design & Construction", 3, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (8, "TICT-V1GP-15", 1, 5, "Group Project", 3, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (9, "TICT-V1DP-15", 1, 5, "Data Processing", 4, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (10, "TICT-V1IPASS-15", 1, 5, "Individual Propedeuse Assessment", 4, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (11, "TICT-V1PROF-15", 1, 5, "Professional Development", 2, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (12, "TICT-V1IDP-15", 1, 5, "Intradisciplary Project", 2, 1);
INSERT INTO "cursus" ("id", "cursuscode", "docent_id", "ects", "naam", "periode", "organisatie_id") VALUES (13, "TICT-V4AFST-17", 3, 30, "Afstuderen", 15, 1);
INSERT INTO "cohort_cursus" values (1, 1);
INSERT INTO "cohort_cursus" values (1, 2);
INSERT INTO "cohort_cursus" values (1, 3);
INSERT INTO "cohort_cursus" values (2, 1);
INSERT INTO "cohort_cursus" values (2, 2);
INSERT INTO "cohort_cursus" values (2, 3);
INSERT INTO "cohort_cursus" values (2, 4);
INSERT INTO "cohort_cursus" values (2, 5);
INSERT INTO "cohort_cursus" values (2, 6);
INSERT INTO "cohort_cursus" values (2, 7);
INSERT INTO "cohort_cursus" values (2, 8);
INSERT INTO "cohort_cursus" values (2, 9);
INSERT INTO "cohort_cursus" values (2, 10);
INSERT INTO "cohort_cursus" values (2, 11);
INSERT INTO "cohort_cursus" values (2, 12);
INSERT INTO "cohort_cursus" values (2, 13);
INSERT INTO "leerdoel" ("id", "cursus_id", "beroepstaak_id", "professionalskill_id", "bloomniveau_id", "naam", "omschrijving", "gewicht") VALUES (1, 5, 15, 1, 6, "Servlets", "Grafische webinterfaces bouwen met behulp van het J2EE framework (servlets en Java Server Pages) en kan een J2EE frontendframework toepassen (Struts2).", 10);
INSERT INTO "leerdoel" ("id", "cursus_id", "beroepstaak_id", "professionalskill_id", "bloomniveau_id", "naam", "omschrijving", "gewicht") VALUES (2, 5, 15, 1, 3, "Applicatieserver", "De werking van applicatieservers als Tomcat beschrijven en kan daarop webapplicatiesdeployen.", 30);
INSERT INTO "leerdoel" ("id", "cursus_id", "beroepstaak_id", "professionalskill_id", "bloomniveau_id", "naam", "omschrijving", "gewicht") VALUES (3, 5, 15, 1, 2, "HTTP-protocol", "Het HTTP-protocol en, met behulp daarvan, de J2EE application-lifecycle beschrijven.", 20);
INSERT INTO "leerdoel" ("id", "cursus_id", "beroepstaak_id", "professionalskill_id", "bloomniveau_id", "naam", "omschrijving", "gewicht") VALUES (4, 5, 15, 1, 6, "J2EE listeners", "Kan J2EE listeners toepassen en kan diverse framework-toevoegingen (datavalidatie, AJAX-componenten, Struts2 technologiestack, internationalisatie) gebruiken en beschrijven.", 20);
INSERT INTO "leerdoel" ("id", "cursus_id", "beroepstaak_id", "professionalskill_id", "bloomniveau_id", "naam", "omschrijving", "gewicht") VALUES (5, 5, 60, 1, 6, "ORM", "Gegevens vastleggen in databases vanuit OO-systemen, gebaseerd op OO principes.", 20);
INSERT INTO "opleidingsprofiel_professionalskill" values (1, 1) ;
INSERT INTO "cursus_beroepstaak" VALUES (1, 57);
INSERT INTO "cursus_beroepstaak" VALUES (1, 60);
INSERT INTO "cursus_beroepstaak" VALUES (3, 39);
INSERT INTO "cursus_beroepstaak" VALUES (4, 6);
INSERT INTO "cursus_beroepstaak" VALUES (4, 21);
INSERT INTO "cursus_beroepstaak" VALUES (4, 36);
INSERT INTO "cursus_beroepstaak" VALUES (4, 51);
INSERT INTO "cursus_beroepstaak" VALUES (5, 15);
INSERT INTO "cursus_beroepstaak" VALUES (5, 60);
INSERT INTO "cursus_beroepstaak" VALUES (6, 6);
INSERT INTO "cursus_beroepstaak" VALUES (6, 12);
INSERT INTO "cursus_beroepstaak" VALUES (6, 51);
INSERT INTO "cursus_beroepstaak" VALUES (7, 57);
INSERT INTO "cursus_beroepstaak" VALUES (7, 60);
INSERT INTO "cursus_professionalskill" values (1, 1) ;
INSERT INTO "toets" ("id", "gewicht", "millerniveau_id", "naam", "cursus_id") values (1, 50, 1, "Theorietentamen", 5);
INSERT INTO "toets" ("id", "gewicht", "millerniveau_id", "naam", "cursus_id") values (2, 50, 2, "Praktijkopdracht", 5);
INSERT INTO "beoordelingselement" ("id", "gewicht", "naam", "omschrijving", "toets_id")  values (1, 10, "Vraag 1", "", 1);
INSERT INTO "beoordelingselement" ("id", "gewicht", "naam", "omschrijving", "toets_id")  values (2, 10, "Vraag 2", "", 1);
INSERT INTO "beoordelingselement" ("id", "gewicht", "naam", "omschrijving", "toets_id")  values (3, 10, "Vraag 3", "", 1);
INSERT INTO "beoordelingselement" ("id", "gewicht", "naam", "omschrijving", "toets_id")  values (4, 10, "Projectvoorstel", "", 2);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (1, 20, 1, 2, 1);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (2, 20, 1, 2, 2);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (3, 20, 2, 2, 3);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (4, 20, 2, 2, 4);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (5, 20, 4, 2, 4);
INSERT INTO "toetselement" ("id", "gewicht", "beoordelingselement_id", "bloomniveau_id", "leerdoel_id") VALUES (6, 40, 4, 2, 5);


--Authorisatie gedeelte

--
-- Gegevens worden geëxporteerd voor tabel "user"
--

INSERT INTO "useraccount" ("username", "role_id") VALUES
("jan.testgebruiker@gmail.com", 6),
("luccah06071@gmail.com", 6),
("redouan.bouzid96@gmail.com", 6);

--
-- Gegevens worden geëxporteerd voor tabel "function_module"
--

INSERT INTO "function_module" ("module_id", "function_id") VALUES
(1, 3),
(1, 105),
(1, 2),
(2, 23),
(3, 69),
(3, 22),
(3, 68),
(4, 13),
(4, 12),
(4, 63),
(4, 10),
(5, 80),
(6, 16),
(6, 26),
(6, 18),
(6, 25),
(6, 15),
(7, 78),
(8, 29),
(9, 36),
(10, 42),
(10, 44),
(10, 41),
(11, 34),
(11, 37),
(11, 56),
(11, 59),
(11, 91),
(11, 94),
(11, 108),
(11, 32),
(11, 54),
(11, 58),
(11, 89),
(11, 93),
(11, 33),
(11, 55),
(11, 90),
(11, 109),
(12, 82),
(13, 71),
(13, 70),
(13, 74),
(13, 61),
(13, 75),
(14, 76),
(15, 20),
(16, 104),
(16, 99),
(16, 103),
(17, 38),
(17, 39),
(18, 97),
(18, 96),
(19, 98),
(19, 19),
(19, 102),
(19, 106),
(19, 95),
(19, 101),
(20, 65),
(20, 8),
(20, 87),
(20, 1),
(20, 5),
(20, 6),
(20, 7),
(20, 9),
(20, 11),
(20, 14),
(20, 17),
(20, 21),
(20, 24),
(20, 27),
(20, 28),
(20, 30),
(20, 31),
(20, 35),
(20, 40),
(20, 43),
(20, 45),
(20, 46),
(20, 47),
(20, 48),
(20, 49),
(20, 50),
(20, 51),
(20, 52),
(20, 57),
(20, 60),
(20, 62),
(20, 64),
(20, 66),
(20, 67),
(20, 72),
(20, 73),
(20, 77),
(20, 79),
(20, 81),
(20, 83),
(20, 84),
(20, 85),
(20, 86),
(20, 88),
(20, 92),
(20, 100),
(20, 107),
(20, 4),
(20, 110),
(20, 53),
(20,111);


--
-- Gegevens worden geëxporteerd voor tabel "module_role"
--

INSERT INTO "module_role" ("role_id", "module_id") VALUES
(5, 1),
(3, 2),
(5, 3),
(4, 4),
(5, 5),
(4, 6),
(2, 7),
(2, 8),
(4, 9),
(4, 10),
(2, 11),
(5, 12),
(5, 13),
(2, 14),
(3, 15),
(4, 15),
(4, 16),
(3, 17),
(4, 17),
(5, 17),
(4, 18),
(3, 19),
(1, 20),
(2, 20),
(3, 20),
(4, 20),
(5, 20),
(6, 20),
(6, 1),
(6, 2),
(6, 3),
(6, 4),
(6, 5),
(6, 6),
(6, 7),
(6, 8),
(6, 9),
(6, 10),
(6, 11),
(6, 12),
(6, 13),
(6, 14),
(6, 15),
(6, 16),
(6, 17),
(6, 18),
(6, 19);
