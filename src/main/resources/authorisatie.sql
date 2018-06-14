--
--Geen idee hoe dit automatisch wordt uitgevoerd dus kan je dit in phpMyadmin plakken
--
INSERT INTO FUNCTION VALUES(1,"docent_get");
INSERT INTO FUNCTION VALUES(2,"docent_put");

INSERT INTO MODULE  VALUES (1, 'Docent ophalen');
INSERT INTO MODULE  VALUES (2, 'Docent beheren');

INSERT INTO ROLE  VALUES (1, 'Ophaler');
INSERT INTO ROLE  VALUES (2, 'Beheerder');

INSERT INTO user (username, role_id) VALUES ("test1curcon@gmail.com", 1);
INSERT INTO user (username, role_id) VALUES ("test2curcon@gmail.com", 2);

INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('1', '1');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '1');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '2');


INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('1', '1');
INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('2', '2');


--Emails+wachtwoorden
--Test1Curcon@gmail.com+Test1Curconww
--Test2Curcon@gmail.com+Test2Curconww