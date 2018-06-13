--
--Geen idee hoe dit automatisch wordt uitgevoerd dus kan je dit in phpMyadmin plakken
--
INSERT INTO FUNCTION VALUES(1,"docent_get");
INSERT INTO FUNCTION VALUES(2,"docent_put");

INSERT INTO MODULE  VALUES (1, 'Docent ophalen');
INSERT INTO MODULE  VALUES (2, 'Docent beheren');

INSERT INTO ROLE  VALUES (1, 'Ophaler');
INSERT INTO ROLE  VALUES (2, 'Beheerder');

--Paswoord moet weg en andere usersemails
INSERT INTO user (username, password, role_id) VALUES ("Test1Curcon@gmail.com", 'pas1', 1);
INSERT INTO user (username, password, role_id) VALUES ("Test2Curcon@gmail.com", 'pas2', 2);

INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('1', '1');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '1');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '2');


INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('1', '1');
INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('2', '2');


--Emails+wachtwoorden
--Test1Curcon@gmail.com+Test1Curconww
--Test2Curcon@gmail.com+Test2Curconww