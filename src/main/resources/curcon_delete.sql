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
-- Database: "curcon"
--
ALTER TABLE ONLY "activiteit" DROP CONSTRAINT "activiteit_pkey";
ALTER TABLE ONLY "architectuurlaag" DROP CONSTRAINT "architectuurlaag_pkey";
ALTER TABLE ONLY "beoordelingselement" DROP CONSTRAINT "beoordelingselement_pkey";
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "beroepstaak_pkey";
ALTER TABLE ONLY "bloomniveau" DROP CONSTRAINT "bloomniveau_pkey";
ALTER TABLE ONLY "cohort" DROP CONSTRAINT "cohort_pkey";
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "cursus_pkey";
ALTER TABLE ONLY "docent" DROP CONSTRAINT "docent_pkey";
ALTER TABLE ONLY "function" DROP CONSTRAINT "function_pkey";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "leerdoel_pkey";
ALTER TABLE ONLY "leerlijn" DROP CONSTRAINT "leerlijn_pkey";
ALTER TABLE ONLY "millerniveau" DROP CONSTRAINT "millerniveau_pkey";
ALTER TABLE ONLY "module" DROP CONSTRAINT "module_pkey";
ALTER TABLE ONLY "opleidingsprofiel" DROP CONSTRAINT "opleidingsprofiel_pkey";
ALTER TABLE ONLY "organisatie" DROP CONSTRAINT "organisatie_pkey";
ALTER TABLE ONLY "periode" DROP CONSTRAINT "periode_pkey";
ALTER TABLE ONLY "professionalskill" DROP CONSTRAINT "professionalskill_pkey";
ALTER TABLE ONLY "role" DROP CONSTRAINT "role_pkey";
ALTER TABLE ONLY "toets" DROP CONSTRAINT "toets_pkey";
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "toetselement_pkey";
ALTER TABLE ONLY "toetsplanning" DROP CONSTRAINT "toetsplanning_pkey";
ALTER TABLE ONLY "trefwoord" DROP CONSTRAINT "trefwoord_pkey";

ALTER TABLE "activiteit" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "architectuurlaag" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "beoordelingselement" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "beroepstaak" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "bloomniveau" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "cohort" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "cursus" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "docent" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "function" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "geslotenvraag" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "leerlijn" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "leerdoel" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "module" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "onderwerp" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "openvraag" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "opleidingsprofiel" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "organisatie" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "osirisresultaattype" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "periode" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "professionalskill" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "role" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "toets" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "toetselement" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "toetsplanning" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "werkveld" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "beroepsproduct" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE "trefwoord" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "role" DROP CONSTRAINT "uk_8sewwnpamngi6b1dwaa88askk";
ALTER TABLE ONLY "function" DROP CONSTRAINT "uk_bn41k01mf22q8kpqgx37a7fdl";
ALTER TABLE ONLY "module" DROP CONSTRAINT "uk_f73dsvaor0f4cycvldyt2idf1";
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "uk_hocdlu4u5q4j1tbu8dgfnf7nl";
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "uk_omop6e84r58i4hbtb6p5islv2";
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "uk_q3cxewy63tbr3wsvnorhnjlvw";
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "uk_qv0qxo7jyrr2yk34xam7eb7rq";
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "uk_s3ejxrx1hn6bx97rkwbu54pcu";
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "uk_1xrl6t94fkss966hoa3x092yc";
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "uk_1k2ctjeas1qtk4ueex1sltju1";

/* 7 */
ALTER TABLE ONLY "opleidingsprofiel_professionalskill" DROP CONSTRAINT "fk_lu0op8xyicl02p5xwloffkxqm";
ALTER TABLE ONLY "useraccount" DROP CONSTRAINT "useraccount_pkey";
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "werkveld_pkey";
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "fk_1xrl6t94fkss966hoa3x092yc";
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "fk_2db5g96ixkptp5lt5qw880ykm";
ALTER TABLE ONLY "cursus_professionalskill" DROP CONSTRAINT "fk_2h9c9xvpx3s8fjk6ruprdw0wf";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_37pv9eeavdemclsrytoqt8jwy";
ALTER TABLE ONLY "opleidingsprofiel_beroepstaak" DROP CONSTRAINT "fk_39v4pcxxdjg11gomdw136n2eq";
ALTER TABLE ONLY "cohort_cursus" DROP CONSTRAINT "fk_3ekqp6i61q8vi3oaaqfqnoc74";
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_3gj46c9u0vb6qhiptpn88qm3b";
ALTER TABLE ONLY "beoordelingselement" DROP CONSTRAINT "fk_3wc9o5452emhllomss1hip2uf";
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "fk_41np2n3am9g6g669fm5v5tegf";
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "fk_5buj14li6mkwx50q1lnvx6054";
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "fk_6pye2t9ava5ps2wa3b2jima0j";
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_aidapgk4lby6fmj33m99w5glj";
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "fk_cc59u321ynva95rvvv9onj6ec";
ALTER TABLE ONLY "cohort" DROP CONSTRAINT "fk_ccgxpn709nmyigkaf1xvulkim";
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "fk_clhi3n9fgvpcau7ogopahfsup";
ALTER TABLE ONLY "toets" DROP CONSTRAINT "fk_cxcr4lqb7k54fwecor4fb59jb";
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "fk_dwtbbqqp16hsbg50h966l0rsc";
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "fk_e63kq5ykbiy81n386xx02a21x";
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "fk_ea2wjp6trh24smvit2qggan3s";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_f64pgw7v3ljnrxfdo9k7k7qg0";
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "fk_fm2uils8ed3c9bvl79tbuqufo";
ALTER TABLE ONLY "cursus_beroepstaak" DROP CONSTRAINT "fk_gmqaje32vtdsjbkwfu7nwl4ry";
ALTER TABLE ONLY "trefwoord" DROP CONSTRAINT "fk_h3so9kvm603mk3la4s3k6g8ty";
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "fk_hocdlu4u5q4j1tbu8dgfnf7nl";
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "fk_hw0degphskbobm4m9wpfieoca";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_hyepkf0s2d3s7li98rjhnld9v";
ALTER TABLE ONLY "opleidingsprofiel" DROP CONSTRAINT "fk_i9erap1k01585f538c91jixjc";
ALTER TABLE ONLY "cursus_trefwoord" DROP CONSTRAINT "fk_icdl8cwgh0255h855bqm48af0";
ALTER TABLE ONLY "docent" DROP CONSTRAINT "fk_ioulcs791yeqanu0v3fvkk6kj";
ALTER TABLE ONLY "cursus_beroepstaak" DROP CONSTRAINT "fk_irfq85i0voi3q4v7ijw55222o";
ALTER TABLE ONLY "opleidingsprofiel_beroepstaak" DROP CONSTRAINT "fk_jsgpqfj2xc9871neudyu9duw";
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "fk_kw3jdrh44q9yerec6crm8m47b";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_m9pfuqrycghb0snvostmfvogc";
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_ms3ibbff33fs4jdcb8c2jfv3j";
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "fk_omop6e84r58i4hbtb6p5islv2";
ALTER TABLE ONLY "cursus_trefwoord" DROP CONSTRAINT "fk_ovh1rbl9olr5ppj8wnda1g3k8";
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "fk_q3cxewy63tbr3wsvnorhnjlvw";
ALTER TABLE ONLY "useraccount" DROP CONSTRAINT "fk_q4p5eim90h3r4s0f0owog07n0";
ALTER TABLE ONLY "professionalskill" DROP CONSTRAINT "fk_qdqi2mcdru727ptkfhksyht1x";
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "fk_qv0qxo7jyrr2yk34xam7eb7rq";
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "fk_r9h01rybxno7jxqin3ws4y96o";
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "fk_s2me07sqv4c474qdr280ixsl9";
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_s68gvyvmk9kxkoe8l906wanim";
ALTER TABLE ONLY "cohort_cursus" DROP CONSTRAINT "fk_t44j7yrbfl9sp7235bwknco9y";
ALTER TABLE ONLY "toets" DROP CONSTRAINT "fk_yhnlcne5uvndgg04rl4h3vu7";
ALTER TABLE ONLY "cursus_professionalskill" DROP CONSTRAINT "fk_fd194moq3x5vxboyvvgovph8l";
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "fk_i2s28m194yhq06goqx5q0gj23";

DROP SEQUENCE "geslotenvraag_id_seq";
DROP SEQUENCE "openvraag_id_seq";
DROP SEQUENCE "onderwerp_id_seq";
DROP SEQUENCE "architectuurlaag_id_seq";
DROP SEQUENCE "beoordelingselement_id_seq";
DROP SEQUENCE "cohort_id_seq";
DROP SEQUENCE "bloomniveau_id_seq";
DROP SEQUENCE "beroepstaak_id_seq";
DROP SEQUENCE "activiteit_id_seq";
DROP SEQUENCE "beroepsproduct_id_seq";
DROP SEQUENCE "cursus_id_seq";
DROP SEQUENCE "docent_id_seq";
DROP SEQUENCE "function_id_seq";
DROP SEQUENCE "hibernate_sequence";
DROP SEQUENCE "leerdoel_id_seq";
DROP SEQUENCE "leerlijn_id_seq";
DROP SEQUENCE "module_id_seq";
DROP SEQUENCE "opleidingsprofiel_id_seq";
DROP SEQUENCE "organisatie_id_seq";
DROP SEQUENCE "osirisresultaattype_id_seq";
DROP SEQUENCE "periode_id_seq";
DROP SEQUENCE "professionalskill_id_seq";
DROP SEQUENCE "role_id_seq";
DROP SEQUENCE "toets_id_seq";
DROP SEQUENCE "toetselement_id_seq";
DROP SEQUENCE "toetsplanning_id_seq";
DROP SEQUENCE "trefwoord_id_seq";
DROP SEQUENCE "werkveld_id_seq";

DROP TABLE "toets_geslotenvraag";
DROP TABLE "toets_openvraag";
DROP TABLE "onderwerp_cursus";
DROP TABLE "opleidingsprofiel_beroepstaak";
DROP TABLE "opleidingsprofiel_cohort";
DROP TABLE "opleidingsprofiel_leerlijn";
DROP TABLE "opleidingsprofiel_professionalskill";
DROP TABLE "organisatie_beroepstaak";
DROP TABLE "organisatie_cursus";
DROP TABLE "organisatie_professionalskill";
DROP TABLE "cursus_beroepstaak";
DROP TABLE "cursus_onderwerp";
DROP TABLE "cursus_professionalskill";
DROP TABLE "toets_beroepsproduct";
DROP TABLE "toetsplanning_toetselement";
DROP TABLE "beoordelingselement_toetselement";
DROP TABLE "cohort_cursus";
DROP TABLE "leerlijn_onderwerp";
DROP TABLE "geslotenvraag";
DROP TABLE "openvraag";
DROP TABLE "beroepstaak";
DROP TABLE "cohort";
DROP TABLE "opleidingsprofiel";
DROP TABLE "leerlijn";
DROP TABLE "onderwerp";
DROP TABLE "toetselement";
DROP TABLE "toetsplanning";
DROP TABLE "osirisresultaattype";
DROP TABLE "professionalskill";
DROP TABLE "toets";
DROP TABLE "beroepsproduct";
DROP TABLE "beoordelingselement";
DROP TABLE "leerdoel";
DROP TABLE "cursus";
DROP TABLE "docent";
DROP TABLE "bloomniveau";
DROP TABLE "periode";
DROP TABLE "organisatie";

--
-- tabellen voor autorisatie
--

DROP TABLE "function_module";
DROP TABLE "module_role";
DROP TABLE "useraccount";
DROP TABLE "role";
DROP TABLE "module";
DROP TABLE "function";

--
-- NOTE aan Berend: deze drops stonden er oorspronkelijk niet in
--

DROP TABLE "cursus_trefwoord";
DROP TABLE "trefwoord";
DROP TABLE "trefwoord_cursus";
DROP TABLE "activiteit";
DROP TABLE "architectuurlaag";
DROP TABLE "leerdoel";
DROP TABLE "millerniveau";
DROP TABLE "openvraag";
DROP TABLE "werkveld";

SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
