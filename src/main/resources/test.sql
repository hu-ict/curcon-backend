
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
DROP SEQUENCE "geslotenvraag_id_seq";
DROP SEQUENCE "hibernate_sequence";
DROP SEQUENCE "leerdoel_id_seq";
DROP SEQUENCE "leerlijn_id_seq";
DROP SEQUENCE "module_id_seq";
DROP SEQUENCE "onderwerp_id_seq";
DROP SEQUENCE "openvraag_id_seq";
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

DROP TABLE "activiteit";
DROP TABLE "architectuurlaag";
DROP TABLE "beoordelingselement";
DROP TABLE "beoordelingselement_toetselement";
DROP TABLE "beroepsproduct";
DROP TABLE "beroepstaak";
DROP TABLE "bloomniveau";
DROP TABLE "cohort";
DROP TABLE "cursus";
DROP TABLE "cursus_beroepstaak";
DROP TABLE "cursus_onderwerp";
DROP TABLE "cursus_professionalskill";
DROP TABLE "cursus_trefwoord";
DROP TABLE "docent";
DROP TABLE "function";
DROP TABLE "function_module";
DROP TABLE "geslotenvraag";
DROP TABLE "leerdoel";
DROP TABLE "leerlijn";
DROP TABLE "leerlijn_onderwerp";
DROP TABLE "millerniveau";
DROP TABLE "module";
DROP TABLE "module_role";
DROP TABLE "onderwerp";
DROP TABLE "onderwerp_cursus";
DROP TABLE "openvraag";
DROP TABLE "opleidingsprofiel";
DROP TABLE "opleidingsprofiel_beroepstaak";
DROP TABLE "opleidingsprofiel_cohort";
DROP TABLE "opleidingsprofiel_professionalskill";
DROP TABLE "opleidingsprofiel_leerlijn";
DROP TABLE "organisatie";
DROP TABLE "organisatie_beroepstaak";
DROP TABLE "organisatie_cursus";
DROP TABLE "organisatie_professionalskill";
DROP TABLE "osirisresultaattype";
DROP TABLE "periode";
DROP TABLE "professionalskill";
DROP TABLE "role";
DROP TABLE "toets";
DROP TABLE "toets_beroepsproduct";
DROP TABLE "toets_geslotenvraag";
DROP TABLE "toets_openvraag";
DROP TABLE "toetselement";
DROP TABLE "toetsplanning";
DROP TABLE "toetsplanning_toetselement";
DROP TABLE "trefwoord";
DROP TABLE "trefwoord_cursus";
DROP TABLE "useraccount";
DROP TABLE "werkveld";

CREATE TABLE "activiteit" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(1024)
);

CREATE SEQUENCE "activiteit_id_seq"
    START WITH 11
    INCREMENT BY 1
    MINVALUE 11
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "activiteit_id_seq" OWNED BY "activiteit"."id";

CREATE TABLE "architectuurlaag" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(1024)
);

CREATE SEQUENCE "architectuurlaag_id_seq"
    START WITH 6
    INCREMENT BY 1
    MINVALUE 6
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "architectuurlaag_id_seq" OWNED BY "architectuurlaag"."id";

CREATE TABLE "beoordelingselement" (
    "id" integer NOT NULL,
    "gewicht" integer,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "toets_id" integer
);

CREATE SEQUENCE "beoordelingselement_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beoordelingselement_id_seq" OWNED BY "beoordelingselement"."id";

CREATE TABLE "beoordelingselement_toetselement" (
    "beoordelingselement_id" integer NOT NULL,
    "toetselementen_id" integer NOT NULL
);

CREATE TABLE "beroepsproduct" (
    "id" integer NOT NULL
);

CREATE SEQUENCE "beroepsproduct_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beroepsproduct_id_seq" OWNED BY "beroepsproduct"."id";

CREATE TABLE "beroepstaak" (
    "id" integer NOT NULL,
    "beschrijving" character varying(1024),
    "niveau" integer NOT NULL,
    "activiteit_id" integer NOT NULL,
    "architectuurlaag_id" integer NOT NULL
);

CREATE SEQUENCE "beroepstaak_id_seq"
    START WITH 76
    INCREMENT BY 1
    MINVALUE 76
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "beroepstaak_id_seq" OWNED BY "beroepstaak"."id";

CREATE TABLE "bloomniveau" (
    "id" integer NOT NULL,
    "niveau" character varying(255),
    "omschrijving" character varying(255)
);

CREATE SEQUENCE "bloomniveau_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "bloomniveau_id_seq" OWNED BY "bloomniveau"."id";

CREATE TABLE "cohort" (
    "id" integer NOT NULL,
    "jaar" character varying(255),
    "opleidingsprofiel_id" integer
);


CREATE TABLE "cohort_cursus" (
    "cohort_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

DROP TABLE "cohort_cursus";

CREATE SEQUENCE "cohort_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "cohort_id_seq" OWNED BY "cohort"."id";

CREATE TABLE "cursus" (
    "id" integer NOT NULL,
    "cursuscode" character varying(255),
    "ects" integer,
    "naam" character varying(255),
    "periode" integer,
    "docent_id" integer,
    "organisatie_id" integer
);

CREATE TABLE "cursus_beroepstaak" (
    "cursus_id" integer NOT NULL,
    "eindbts_id" integer NOT NULL
);

CREATE SEQUENCE "cursus_id_seq"
    START WITH 14
    INCREMENT BY 1
    MINVALUE 14
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "cursus_id_seq" OWNED BY "cursus"."id";

CREATE TABLE "cursus_onderwerp" (
    "cursus_id" integer NOT NULL,
    "onderwerpen_id" integer NOT NULL
);


CREATE TABLE "cursus_professionalskill" (
    "cursus_id" integer NOT NULL,
    "eindpss_id" integer NOT NULL
);

CREATE TABLE "cursus_trefwoord" (
    "cursus_id" integer NOT NULL,
    "trefwoorden_id" integer NOT NULL
);

CREATE TABLE "docent" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "organisatie_id" integer NOT NULL
);

CREATE SEQUENCE "docent_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "docent_id_seq" OWNED BY "docent"."id";

CREATE TABLE "function" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

CREATE SEQUENCE "function_id_seq"
    START WITH 112
    INCREMENT BY 1
    MINVALUE 112
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "function_id_seq" OWNED BY "function"."id";

CREATE TABLE "function_module" (
    "module_id" integer NOT NULL,
    "function_id" integer NOT NULL
);

CREATE TABLE "geslotenvraag" (
    "id" integer NOT NULL
);

CREATE SEQUENCE "geslotenvraag_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "geslotenvraag_id_seq" OWNED BY "geslotenvraag"."id";

CREATE SEQUENCE "hibernate_sequence"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

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

CREATE SEQUENCE "leerdoel_id_seq"
    START WITH 6
    INCREMENT BY 1
    MINVALUE 6
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "leerdoel_id_seq" OWNED BY "leerdoel"."id";

CREATE TABLE "leerlijn" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(255)
);

CREATE SEQUENCE "leerlijn_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "leerlijn_id_seq" OWNED BY "leerlijn"."id";

CREATE TABLE "leerlijn_onderwerp" (
    "leerlijn_id" integer NOT NULL,
    "onderwerpen_id" integer NOT NULL
);

CREATE TABLE "millerniveau" (
    "id" integer NOT NULL,
    "niveau" character varying(255),
    "omschrijving" character varying(255)
);

CREATE TABLE "module" (
    "id" integer NOT NULL,
    "name" character varying(255)
);

CREATE SEQUENCE "module_id_seq"
    START WITH 21
    INCREMENT BY 1
    MINVALUE 21
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "module_id_seq" OWNED BY "module"."id";

CREATE TABLE "module_role" (
    "role_id" integer NOT NULL,
    "module_id" integer NOT NULL
);

CREATE TABLE "onderwerp" (
    "id" integer NOT NULL,
    "leerlijn" "bytea",
    "trefwoord" character varying
);

CREATE TABLE "onderwerp_cursus" (
    "onderwerp_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

CREATE SEQUENCE "onderwerp_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "onderwerp_id_seq" OWNED BY "onderwerp"."id";

CREATE TABLE "openvraag" (
    "id" integer NOT NULL
);

CREATE SEQUENCE "openvraag_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "openvraag_id_seq" OWNED BY "openvraag"."id";

CREATE TABLE "opleidingsprofiel" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "organisatie_id" integer
);

CREATE TABLE "opleidingsprofiel_beroepstaak" (
    "opleidingsprofiel_id" integer NOT NULL,
    "eindbts_id" integer NOT NULL
);

CREATE TABLE "opleidingsprofiel_cohort" (
    "opleidingsprofiel_id" integer NOT NULL,
    "cohorten_id" integer NOT NULL
);

CREATE SEQUENCE "opleidingsprofiel_id_seq"
    START WITH 5
    INCREMENT BY 1
    MINVALUE 5
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "opleidingsprofiel_id_seq" OWNED BY "opleidingsprofiel"."id";

CREATE TABLE "opleidingsprofiel_leerlijn" (
    "opleidingsprofiel_id" integer NOT NULL,
    "leerlijnen_id" integer NOT NULL
);

CREATE TABLE "opleidingsprofiel_professionalskill" (
    "opleidingsprofiel_id" integer NOT NULL,
    "eindpss_id" integer NOT NULL
);

CREATE TABLE "organisatie" (
    "id" integer NOT NULL,
    "naam" character varying(255)
);

CREATE TABLE "organisatie_beroepstaak" (
    "organisatie_id" integer NOT NULL,
    "alleberoepstaken_id" integer NOT NULL
);

CREATE TABLE "organisatie_cursus" (
    "organisatie_id" integer NOT NULL,
    "allecursussen_id" integer NOT NULL
);

CREATE SEQUENCE "organisatie_id_seq"
    START WITH 2
    INCREMENT BY 1
    MINVALUE 2
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "organisatie_id_seq" OWNED BY "organisatie"."id";

CREATE TABLE "organisatie_professionalskill" (
    "organisatie_id" integer NOT NULL,
    "professionalskills_id" integer NOT NULL
);

CREATE TABLE "osirisresultaattype" (
    "id" integer NOT NULL,
    "naam" character varying,
    "omschrijving" character varying
);

CREATE SEQUENCE "osirisresultaattype_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "osirisresultaattype_id_seq" OWNED BY "osirisresultaattype"."id";

CREATE TABLE "periode" (
    "id" integer NOT NULL,
    "periode" integer
);

CREATE SEQUENCE "periode_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "periode_id_seq" OWNED BY "periode"."id";

CREATE TABLE "professionalskill" (
    "id" integer NOT NULL,
    "beschrijving" character varying(1024),
    "code" character varying(255),
    "niveau" character varying(255),
    "activiteit_id" integer NOT NULL
);

CREATE SEQUENCE "professionalskill_id_seq"
    START WITH 16
    INCREMENT BY 1
    MINVALUE 16
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "professionalskill_id_seq" OWNED BY "professionalskill"."id";

CREATE TABLE "role" (
    "id" integer NOT NULL,
    "name" character varying(255)
);



CREATE SEQUENCE "role_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "role_id_seq" OWNED BY "role"."id";

CREATE TABLE "toets" (
    "id" integer NOT NULL,
    "gewicht" double precision,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "cursus_id" integer,
    "millerniveau_id" integer
);



CREATE TABLE "toets_beroepsproduct" (
    "toets_toets_id" integer NOT NULL,
    "beroepsproducten_id" integer NOT NULL
);


CREATE TABLE "toets_geslotenvraag" (
    "toets_toets_id" integer NOT NULL,
    "geslotenvragen_id" integer NOT NULL
);

CREATE SEQUENCE "toets_id_seq"
    START WITH 3
    INCREMENT BY 1
    MINVALUE 3
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toets_id_seq" OWNED BY "toets"."id";

CREATE TABLE "toets_openvraag" (
    "toets_toets_id" integer NOT NULL,
    "openvragen_id" integer NOT NULL
);

CREATE TABLE "toetselement" (
    "id" integer NOT NULL,
    "gewicht" double precision,
    "beoordelingselement_id" integer,
    "bloomniveau_id" integer,
    "leerdoel_id" integer
);

CREATE SEQUENCE "toetselement_id_seq"
    START WITH 7
    INCREMENT BY 1
    MINVALUE 7
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toetselement_id_seq" OWNED BY "toetselement"."id";

CREATE TABLE "toetsplanning" (
    "id" integer NOT NULL
);

CREATE SEQUENCE "toetsplanning_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "toetsplanning_id_seq" OWNED BY "toetsplanning"."id";

CREATE TABLE "toetsplanning_toetselement" (
    "toetsplanning_id" integer NOT NULL,
    "toetselementen_id" integer NOT NULL
);

CREATE TABLE "trefwoord" (
    "id" integer NOT NULL,
    "naam" character varying(255),
    "omschrijving" character varying(255),
    "leerlijn_id" integer NOT NULL
);


CREATE TABLE "trefwoord_cursus" (
    "trefwoord_id" integer NOT NULL,
    "cursussen_id" integer NOT NULL
);

CREATE SEQUENCE "trefwoord_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "trefwoord_id_seq" OWNED BY "trefwoord"."id";

CREATE TABLE "useraccount" (
    "username" character varying(255) NOT NULL,
    "role_id" integer
);

CREATE TABLE "werkveld" (
    "id" integer NOT NULL,
    "activiteit_id" integer NOT NULL,
    "architectuurlaag_id" integer NOT NULL
);

CREATE SEQUENCE "werkveld_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE "werkveld_id_seq" OWNED BY "werkveld"."id";

ALTER TABLE ONLY "activiteit" ALTER COLUMN "id" SET DEFAULT "nextval"('"activiteit_id_seq"'::"regclass");
ALTER TABLE "activiteit" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "architectuurlaag" ALTER COLUMN "id" SET DEFAULT "nextval"('"architectuurlaag_id_seq"'::"regclass");
ALTER TABLE "architectuurlaag" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "beoordelingselement" ALTER COLUMN "id" SET DEFAULT "nextval"('"beoordelingselement_id_seq"'::"regclass");
ALTER TABLE "beoordelingselement" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "beroepsproduct" ALTER COLUMN "id" SET DEFAULT "nextval"('"beroepsproduct_id_seq"'::"regclass");
ALTER TABLE "beroepsproduct" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "beroepstaak" ALTER COLUMN "id" SET DEFAULT "nextval"('"beroepstaak_id_seq"'::"regclass");
ALTER TABLE "beroepstaak" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "bloomniveau" ALTER COLUMN "id" SET DEFAULT "nextval"('"bloomniveau_id_seq"'::"regclass");
ALTER TABLE "bloomniveau" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE ONLY "cohort" ALTER COLUMN "id" SET DEFAULT "nextval"('"cohort_id_seq"'::"regclass");
ALTER TABLE "cohort" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "cursus" ALTER COLUMN "id" SET DEFAULT "nextval"('"cursus_id_seq"'::"regclass");
ALTER TABLE "cursus" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "docent" ALTER COLUMN "id" SET DEFAULT "nextval"('"docent_id_seq"'::"regclass");
ALTER TABLE "docent" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "function" ALTER COLUMN "id" SET DEFAULT "nextval"('"function_id_seq"'::"regclass");
ALTER TABLE "function" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "geslotenvraag" ALTER COLUMN "id" SET DEFAULT "nextval"('"geslotenvraag_id_seq"'::"regclass");
ALTER TABLE "geslotenvraag" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "leerdoel" ALTER COLUMN "id" SET DEFAULT "nextval"('"leerdoel_id_seq"'::"regclass");
ALTER TABLE "leerdoel" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "leerlijn" ALTER COLUMN "id" SET DEFAULT "nextval"('"leerlijn_id_seq"'::"regclass");
ALTER TABLE "leerlijn" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "module" ALTER COLUMN "id" SET DEFAULT "nextval"('"module_id_seq"'::"regclass");
ALTER TABLE "module" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "onderwerp" ALTER COLUMN "id" SET DEFAULT "nextval"('"onderwerp_id_seq"'::"regclass");
ALTER TABLE "onderwerp" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "openvraag" ALTER COLUMN "id" SET DEFAULT "nextval"('"openvraag_id_seq"'::"regclass");
ALTER TABLE "openvraag" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "opleidingsprofiel" ALTER COLUMN "id" SET DEFAULT "nextval"('"opleidingsprofiel_id_seq"'::"regclass");
ALTER TABLE "opleidingsprofiel" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "organisatie" ALTER COLUMN "id" SET DEFAULT "nextval"('"organisatie_id_seq"'::"regclass");
ALTER TABLE "organisatie" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "osirisresultaattype" ALTER COLUMN "id" SET DEFAULT "nextval"('"osirisresultaattype_id_seq"'::"regclass");
ALTER TABLE "osirisresultaattype" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "periode" ALTER COLUMN "id" SET DEFAULT "nextval"('"periode_id_seq"'::"regclass");
ALTER TABLE "periode" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "professionalskill" ALTER COLUMN "id" SET DEFAULT "nextval"('"professionalskill_id_seq"'::"regclass");
ALTER TABLE "professionalskill" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "role" ALTER COLUMN "id" SET DEFAULT "nextval"('"role_id_seq"'::"regclass");
ALTER TABLE "role" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "toets" ALTER COLUMN "id" SET DEFAULT "nextval"('"toets_id_seq"'::"regclass");
ALTER TABLE "toets" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "toetselement" ALTER COLUMN "id" SET DEFAULT "nextval"('"toetselement_id_seq"'::"regclass");
ALTER TABLE "toetselement" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "toetsplanning" ALTER COLUMN "id" SET DEFAULT "nextval"('"toetsplanning_id_seq"'::"regclass");
ALTER TABLE "toetsplanning" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "trefwoord" ALTER COLUMN "id" SET DEFAULT "nextval"('"trefwoord_id_seq"'::"regclass");
ALTER TABLE "trefwoord" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "werkveld" ALTER COLUMN "id" SET DEFAULT "nextval"('"werkveld_id_seq"'::"regclass");
ALTER TABLE "werkveld" ALTER COLUMN "id" DROP DEFAULT;

ALTER TABLE ONLY "activiteit"
ADD CONSTRAINT "activiteit_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "activiteit" DROP CONSTRAINT "activiteit_pkey";

ALTER TABLE ONLY "architectuurlaag"
ADD CONSTRAINT "architectuurlaag_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "architectuurlaag" DROP CONSTRAINT "architectuurlaag_pkey";

ALTER TABLE ONLY "beoordelingselement"
ADD CONSTRAINT "beoordelingselement_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "beoordelingselement" DROP CONSTRAINT "beoordelingselement_pkey";

ALTER TABLE ONLY "beroepstaak"
ADD CONSTRAINT "beroepstaak_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "beroepstaak_pkey";

ALTER TABLE ONLY "bloomniveau"
ADD CONSTRAINT "bloomniveau_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "bloomniveau" DROP CONSTRAINT "bloomniveau_pkey";

ALTER TABLE ONLY "cohort"
ADD CONSTRAINT "cohort_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "cohort" DROP CONSTRAINT "cohort_pkey";

ALTER TABLE ONLY "cursus"
ADD CONSTRAINT "cursus_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "cursus_pkey";

ALTER TABLE ONLY "docent"
ADD CONSTRAINT "docent_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "docent" DROP CONSTRAINT "docent_pkey";

ALTER TABLE ONLY "function"
ADD CONSTRAINT "function_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "function" DROP CONSTRAINT "function_pkey";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "leerdoel_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "leerdoel_pkey";

ALTER TABLE ONLY "leerlijn"
ADD CONSTRAINT "leerlijn_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "leerlijn" DROP CONSTRAINT "leerlijn_pkey";

ALTER TABLE ONLY "millerniveau"
ADD CONSTRAINT "millerniveau_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "millerniveau" DROP CONSTRAINT "millerniveau_pkey";

ALTER TABLE ONLY "module"
ADD CONSTRAINT "module_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "module" DROP CONSTRAINT "module_pkey";

ALTER TABLE ONLY "opleidingsprofiel"
ADD CONSTRAINT "opleidingsprofiel_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "opleidingsprofiel" DROP CONSTRAINT "opleidingsprofiel_pkey";

ALTER TABLE ONLY "organisatie"
ADD CONSTRAINT "organisatie_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "organisatie" DROP CONSTRAINT "organisatie_pkey";

ALTER TABLE ONLY "periode"
ADD CONSTRAINT "periode_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "periode" DROP CONSTRAINT "periode_pkey";

ALTER TABLE ONLY "professionalskill"
ADD CONSTRAINT "professionalskill_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "professionalskill" DROP CONSTRAINT "professionalskill_pkey";

ALTER TABLE ONLY "role"
ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "role" DROP CONSTRAINT "role_pkey";

ALTER TABLE ONLY "toets"
ADD CONSTRAINT "toets_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "toets" DROP CONSTRAINT "toets_pkey";

ALTER TABLE ONLY "toetselement"
ADD CONSTRAINT "toetselement_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "toetselement_pkey";

ALTER TABLE ONLY "toetsplanning"
ADD CONSTRAINT "toetsplanning_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "toetsplanning" DROP CONSTRAINT "toetsplanning_pkey";

ALTER TABLE ONLY "trefwoord"
ADD CONSTRAINT "trefwoord_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "trefwoord" DROP CONSTRAINT "trefwoord_pkey";

ALTER TABLE ONLY "function_module"
ADD CONSTRAINT "uk_1k2ctjeas1qtk4ueex1sltju1" UNIQUE ("module_id", "function_id");
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "uk_1k2ctjeas1qtk4ueex1sltju1";

ALTER TABLE ONLY "toetsplanning_toetselement"
ADD CONSTRAINT "uk_1xrl6t94fkss966hoa3x092yc" UNIQUE ("toetselementen_id");
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "uk_1xrl6t94fkss966hoa3x092yc";

ALTER TABLE ONLY "role"
ADD CONSTRAINT "uk_8sewwnpamngi6b1dwaa88askk" UNIQUE ("name");
ALTER TABLE ONLY "role" DROP CONSTRAINT "uk_8sewwnpamngi6b1dwaa88askk";

ALTER TABLE ONLY "function"
ADD CONSTRAINT "uk_bn41k01mf22q8kpqgx37a7fdl" UNIQUE ("name");
ALTER TABLE ONLY "function" DROP CONSTRAINT "uk_bn41k01mf22q8kpqgx37a7fdl";

ALTER TABLE ONLY "module"
ADD CONSTRAINT "uk_f73dsvaor0f4cycvldyt2idf1" UNIQUE ("name");
ALTER TABLE ONLY "module" DROP CONSTRAINT "uk_f73dsvaor0f4cycvldyt2idf1";

ALTER TABLE ONLY "organisatie_beroepstaak"
ADD CONSTRAINT "uk_hocdlu4u5q4j1tbu8dgfnf7nl" UNIQUE ("alleberoepstaken_id");
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "uk_hocdlu4u5q4j1tbu8dgfnf7nl";

ALTER TABLE ONLY "trefwoord_cursus"
ADD CONSTRAINT "uk_omop6e84r58i4hbtb6p5islv2" UNIQUE ("cursussen_id");
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "uk_omop6e84r58i4hbtb6p5islv2";

ALTER TABLE ONLY "opleidingsprofiel_leerlijn"
ADD CONSTRAINT "uk_q3cxewy63tbr3wsvnorhnjlvw" UNIQUE ("leerlijnen_id");
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "uk_q3cxewy63tbr3wsvnorhnjlvw";

ALTER TABLE ONLY "organisatie_professionalskill"
ADD CONSTRAINT "uk_qv0qxo7jyrr2yk34xam7eb7rq" UNIQUE ("professionalskills_id");
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "uk_qv0qxo7jyrr2yk34xam7eb7rq";

ALTER TABLE ONLY "module_role"
ADD CONSTRAINT "uk_s3ejxrx1hn6bx97rkwbu54pcu" UNIQUE ("role_id", "module_id");
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "uk_s3ejxrx1hn6bx97rkwbu54pcu";

ALTER TABLE ONLY "useraccount"
ADD CONSTRAINT "useraccount_pkey" PRIMARY KEY ("username");
ALTER TABLE ONLY "useraccount" DROP CONSTRAINT "useraccount_pkey";

ALTER TABLE ONLY "werkveld"
ADD CONSTRAINT "werkveld_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "werkveld_pkey";

ALTER TABLE ONLY "toetsplanning_toetselement"
ADD CONSTRAINT "fk_1xrl6t94fkss966hoa3x092yc" FOREIGN KEY ("toetselementen_id") REFERENCES "toetselement"("id");
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "fk_1xrl6t94fkss966hoa3x092yc";

ALTER TABLE ONLY "organisatie_beroepstaak"
ADD CONSTRAINT "fk_2db5g96ixkptp5lt5qw880ykm" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie"("id");
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "fk_2db5g96ixkptp5lt5qw880ykm";

ALTER TABLE ONLY "cursus_professionalskill"
ADD CONSTRAINT "fk_2h9c9xvpx3s8fjk6ruprdw0wf" FOREIGN KEY ("eindpss_id") REFERENCES "professionalskill"("id");
ALTER TABLE ONLY "cursus_professionalskill" DROP CONSTRAINT "fk_2h9c9xvpx3s8fjk6ruprdw0wf";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "fk_37pv9eeavdemclsrytoqt8jwy" FOREIGN KEY ("cursus_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_37pv9eeavdemclsrytoqt8jwy";

ALTER TABLE ONLY "opleidingsprofiel_beroepstaak"
ADD CONSTRAINT "fk_39v4pcxxdjg11gomdw136n2eq" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel"("id");
ALTER TABLE ONLY "opleidingsprofiel_beroepstaak" DROP CONSTRAINT "fk_39v4pcxxdjg11gomdw136n2eq";

ALTER TABLE ONLY "cohort_cursus"
ADD CONSTRAINT "fk_3ekqp6i61q8vi3oaaqfqnoc74" FOREIGN KEY ("cohort_id") REFERENCES "cohort"("id");
ALTER TABLE ONLY "cohort_cursus" DROP CONSTRAINT "fk_3ekqp6i61q8vi3oaaqfqnoc74";

ALTER TABLE ONLY "toetselement"
ADD CONSTRAINT "fk_3gj46c9u0vb6qhiptpn88qm3b" FOREIGN KEY ("beoordelingselement_id") REFERENCES "beoordelingselement"("id");
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_3gj46c9u0vb6qhiptpn88qm3b";

ALTER TABLE ONLY "beoordelingselement"
ADD CONSTRAINT "fk_3wc9o5452emhllomss1hip2uf" FOREIGN KEY ("toets_id") REFERENCES "toets"("id");
ALTER TABLE ONLY "beoordelingselement" DROP CONSTRAINT "fk_3wc9o5452emhllomss1hip2uf";

ALTER TABLE ONLY "organisatie_professionalskill"
ADD CONSTRAINT "fk_41np2n3am9g6g669fm5v5tegf" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie"("id");
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "fk_41np2n3am9g6g669fm5v5tegf";

ALTER TABLE ONLY "trefwoord_cursus"
ADD CONSTRAINT "fk_5buj14li6mkwx50q1lnvx6054" FOREIGN KEY ("trefwoord_id") REFERENCES "trefwoord"("id");
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "fk_5buj14li6mkwx50q1lnvx6054";

ALTER TABLE ONLY "function_module"
ADD CONSTRAINT "fk_6pye2t9ava5ps2wa3b2jima0j" FOREIGN KEY ("function_id") REFERENCES "function"("id");
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "fk_6pye2t9ava5ps2wa3b2jima0j";

ALTER TABLE ONLY "toetselement"
ADD CONSTRAINT "fk_aidapgk4lby6fmj33m99w5glj" FOREIGN KEY ("bloomniveau_id") REFERENCES "bloomniveau"("id");
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_aidapgk4lby6fmj33m99w5glj";

ALTER TABLE ONLY "cursus"
ADD CONSTRAINT "fk_cc59u321ynva95rvvv9onj6ec" FOREIGN KEY ("docent_id") REFERENCES "docent"("id");
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "fk_cc59u321ynva95rvvv9onj6ec";

ALTER TABLE ONLY "cohort"
ADD CONSTRAINT "fk_ccgxpn709nmyigkaf1xvulkim" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel"("id");
ALTER TABLE ONLY "cohort" DROP CONSTRAINT "fk_ccgxpn709nmyigkaf1xvulkim";

ALTER TABLE ONLY "toetsplanning_toetselement"
ADD CONSTRAINT "fk_clhi3n9fgvpcau7ogopahfsup" FOREIGN KEY ("toetsplanning_id") REFERENCES "toetsplanning"("id");
ALTER TABLE ONLY "toetsplanning_toetselement" DROP CONSTRAINT "fk_clhi3n9fgvpcau7ogopahfsup";

ALTER TABLE ONLY "toets"
ADD CONSTRAINT "fk_cxcr4lqb7k54fwecor4fb59jb" FOREIGN KEY ("millerniveau_id") REFERENCES "millerniveau"("id");
ALTER TABLE ONLY "toets" DROP CONSTRAINT "fk_cxcr4lqb7k54fwecor4fb59jb";

ALTER TABLE ONLY "module_role"
ADD CONSTRAINT "fk_dwtbbqqp16hsbg50h966l0rsc" FOREIGN KEY ("role_id") REFERENCES "role"("id");
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "fk_dwtbbqqp16hsbg50h966l0rsc";

ALTER TABLE ONLY "werkveld"
ADD CONSTRAINT "fk_e63kq5ykbiy81n386xx02a21x" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit"("id");
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "fk_e63kq5ykbiy81n386xx02a21x";

ALTER TABLE ONLY "module_role"
ADD CONSTRAINT "fk_ea2wjp6trh24smvit2qggan3s" FOREIGN KEY ("module_id") REFERENCES "module"("id");
ALTER TABLE ONLY "module_role" DROP CONSTRAINT "fk_ea2wjp6trh24smvit2qggan3s";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "fk_f64pgw7v3ljnrxfdo9k7k7qg0" FOREIGN KEY ("trefwoord_id") REFERENCES "trefwoord"("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_f64pgw7v3ljnrxfdo9k7k7qg0";

ALTER TABLE ONLY "cursus_professionalskill"
ADD CONSTRAINT "fk_fd194moq3x5vxboyvvgovph8l" FOREIGN KEY ("cursus_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "cursus_professionalskill" DROP CONSTRAINT "fk_fd194moq3x5vxboyvvgovph8l";

ALTER TABLE ONLY "opleidingsprofiel_leerlijn"
ADD CONSTRAINT "fk_fm2uils8ed3c9bvl79tbuqufo" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel"("id");
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "fk_fm2uils8ed3c9bvl79tbuqufo";

ALTER TABLE ONLY "cursus_beroepstaak"
ADD CONSTRAINT "fk_gmqaje32vtdsjbkwfu7nwl4ry" FOREIGN KEY ("cursus_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "cursus_beroepstaak" DROP CONSTRAINT "fk_gmqaje32vtdsjbkwfu7nwl4ry";

ALTER TABLE ONLY "trefwoord"
ADD CONSTRAINT "fk_h3so9kvm603mk3la4s3k6g8ty" FOREIGN KEY ("leerlijn_id") REFERENCES "leerlijn"("id");
ALTER TABLE ONLY "trefwoord" DROP CONSTRAINT "fk_h3so9kvm603mk3la4s3k6g8ty";

ALTER TABLE ONLY "organisatie_beroepstaak"
ADD CONSTRAINT "fk_hocdlu4u5q4j1tbu8dgfnf7nl" FOREIGN KEY ("alleberoepstaken_id") REFERENCES "beroepstaak"("id");
ALTER TABLE ONLY "organisatie_beroepstaak" DROP CONSTRAINT "fk_hocdlu4u5q4j1tbu8dgfnf7nl";

ALTER TABLE ONLY "cursus"
ADD CONSTRAINT "fk_hw0degphskbobm4m9wpfieoca" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie"("id");
ALTER TABLE ONLY "cursus" DROP CONSTRAINT "fk_hw0degphskbobm4m9wpfieoca";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "fk_hyepkf0s2d3s7li98rjhnld9v" FOREIGN KEY ("professionalskill_id") REFERENCES "professionalskill"("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_hyepkf0s2d3s7li98rjhnld9v";

ALTER TABLE ONLY "function_module"
ADD CONSTRAINT "fk_i2s28m194yhq06goqx5q0gj23" FOREIGN KEY ("module_id") REFERENCES "module"("id");
ALTER TABLE ONLY "function_module" DROP CONSTRAINT "fk_i2s28m194yhq06goqx5q0gj23";

ALTER TABLE ONLY "opleidingsprofiel"
ADD CONSTRAINT "fk_i9erap1k01585f538c91jixjc" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie"("id");
ALTER TABLE ONLY "opleidingsprofiel" DROP CONSTRAINT "fk_i9erap1k01585f538c91jixjc";

ALTER TABLE ONLY "cursus_trefwoord"
ADD CONSTRAINT "fk_icdl8cwgh0255h855bqm48af0" FOREIGN KEY ("trefwoorden_id") REFERENCES "trefwoord"("id");
ALTER TABLE ONLY "cursus_trefwoord" DROP CONSTRAINT "fk_icdl8cwgh0255h855bqm48af0";

ALTER TABLE ONLY "docent"
ADD CONSTRAINT "fk_ioulcs791yeqanu0v3fvkk6kj" FOREIGN KEY ("organisatie_id") REFERENCES "organisatie"("id");
ALTER TABLE ONLY "docent" DROP CONSTRAINT "fk_ioulcs791yeqanu0v3fvkk6kj";

ALTER TABLE ONLY "cursus_beroepstaak"
ADD CONSTRAINT "fk_irfq85i0voi3q4v7ijw55222o" FOREIGN KEY ("eindbts_id") REFERENCES "beroepstaak"("id");
ALTER TABLE ONLY "cursus_beroepstaak" DROP CONSTRAINT "fk_irfq85i0voi3q4v7ijw55222o";

ALTER TABLE ONLY "opleidingsprofiel_beroepstaak"
ADD CONSTRAINT "fk_jsgpqfj2xc9871neudyu9duw" FOREIGN KEY ("eindbts_id") REFERENCES "beroepstaak"("id");
ALTER TABLE ONLY "opleidingsprofiel_beroepstaak" DROP CONSTRAINT "fk_jsgpqfj2xc9871neudyu9duw";

ALTER TABLE ONLY "beroepstaak"
ADD CONSTRAINT "fk_kw3jdrh44q9yerec6crm8m47b" FOREIGN KEY ("architectuurlaag_id") REFERENCES "architectuurlaag"("id");
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "fk_kw3jdrh44q9yerec6crm8m47b";

ALTER TABLE ONLY "opleidingsprofiel_professionalskill"
ADD CONSTRAINT "fk_lu0op8xyicl02p5xwloffkxqm" FOREIGN KEY ("opleidingsprofiel_id") REFERENCES "opleidingsprofiel"("id");
ALTER TABLE ONLY "opleidingsprofiel_professionalskill" DROP CONSTRAINT "fk_lu0op8xyicl02p5xwloffkxqm";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "fk_m9pfuqrycghb0snvostmfvogc" FOREIGN KEY ("bloomniveau_id") REFERENCES "bloomniveau"("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_m9pfuqrycghb0snvostmfvogc";

ALTER TABLE ONLY "leerdoel"
ADD CONSTRAINT "fk_ms3ibbff33fs4jdcb8c2jfv3j" FOREIGN KEY ("beroepstaak_id") REFERENCES "beroepstaak"("id");
ALTER TABLE ONLY "leerdoel" DROP CONSTRAINT "fk_ms3ibbff33fs4jdcb8c2jfv3j";

ALTER TABLE ONLY "opleidingsprofiel_professionalskill"
ADD CONSTRAINT "fk_mvg04ld4nvekx1nvusncevc6g" FOREIGN KEY ("eindpss_id") REFERENCES "professionalskill"("id");
ALTER TABLE ONLY "opleidingsprofiel_professionalskill" DROP CONSTRAINT "fk_mvg04ld4nvekx1nvusncevc6g";

ALTER TABLE ONLY "trefwoord_cursus"
ADD CONSTRAINT "fk_omop6e84r58i4hbtb6p5islv2" FOREIGN KEY ("cursussen_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "trefwoord_cursus" DROP CONSTRAINT "fk_omop6e84r58i4hbtb6p5islv2";

ALTER TABLE ONLY "cursus_trefwoord"
ADD CONSTRAINT "fk_ovh1rbl9olr5ppj8wnda1g3k8" FOREIGN KEY ("cursus_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "cursus_trefwoord" DROP CONSTRAINT "fk_ovh1rbl9olr5ppj8wnda1g3k8";

ALTER TABLE ONLY "opleidingsprofiel_leerlijn"
ADD CONSTRAINT "fk_q3cxewy63tbr3wsvnorhnjlvw" FOREIGN KEY ("leerlijnen_id") REFERENCES "leerlijn"("id");
ALTER TABLE ONLY "opleidingsprofiel_leerlijn" DROP CONSTRAINT "fk_q3cxewy63tbr3wsvnorhnjlvw";

ALTER TABLE ONLY "useraccount"
ADD CONSTRAINT "fk_q4p5eim90h3r4s0f0owog07n0" FOREIGN KEY ("role_id") REFERENCES "role"("id");
ALTER TABLE ONLY "useraccount" DROP CONSTRAINT "fk_q4p5eim90h3r4s0f0owog07n0";

ALTER TABLE ONLY "professionalskill"
ADD CONSTRAINT "fk_qdqi2mcdru727ptkfhksyht1x" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit"("id");
ALTER TABLE ONLY "professionalskill" DROP CONSTRAINT "fk_qdqi2mcdru727ptkfhksyht1x";

ALTER TABLE ONLY "organisatie_professionalskill"
ADD CONSTRAINT "fk_qv0qxo7jyrr2yk34xam7eb7rq" FOREIGN KEY ("professionalskills_id") REFERENCES "professionalskill"("id");
ALTER TABLE ONLY "organisatie_professionalskill" DROP CONSTRAINT "fk_qv0qxo7jyrr2yk34xam7eb7rq";

ALTER TABLE ONLY "werkveld"
ADD CONSTRAINT "fk_r9h01rybxno7jxqin3ws4y96o" FOREIGN KEY ("architectuurlaag_id") REFERENCES "architectuurlaag"("id");
ALTER TABLE ONLY "werkveld" DROP CONSTRAINT "fk_r9h01rybxno7jxqin3ws4y96o";

ALTER TABLE ONLY "beroepstaak"
ADD CONSTRAINT "fk_s2me07sqv4c474qdr280ixsl9" FOREIGN KEY ("activiteit_id") REFERENCES "activiteit"("id");
ALTER TABLE ONLY "beroepstaak" DROP CONSTRAINT "fk_s2me07sqv4c474qdr280ixsl9";

ALTER TABLE ONLY "toetselement"
ADD CONSTRAINT "fk_s68gvyvmk9kxkoe8l906wanim" FOREIGN KEY ("leerdoel_id") REFERENCES "leerdoel"("id");
ALTER TABLE ONLY "toetselement" DROP CONSTRAINT "fk_s68gvyvmk9kxkoe8l906wanim";

ALTER TABLE ONLY "cohort_cursus"
ADD CONSTRAINT "fk_t44j7yrbfl9sp7235bwknco9y" FOREIGN KEY ("cursussen_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "cohort_cursus" DROP CONSTRAINT "fk_t44j7yrbfl9sp7235bwknco9y";

ALTER TABLE ONLY "toets"
ADD CONSTRAINT "fk_yhnlcne5uvndgg04rl4h3vu7" FOREIGN KEY ("cursus_id") REFERENCES "cursus"("id");
ALTER TABLE ONLY "toets" DROP CONSTRAINT "fk_yhnlcne5uvndgg04rl4h3vu7
