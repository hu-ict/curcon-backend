--
--Geen idee hoe dit automatisch wordt uitgevoerd dus kan je dit in phpMyadmin plakken
--
INSERT INTO FUNCTION VALUES(1,"Function1");
INSERT INTO FUNCTION VALUES(2,"Function2");
INSERT INTO FUNCTION VALUES(3,"Function3");


INSERT INTO MODULE  VALUES (1, 'Module1');
INSERT INTO MODULE  VALUES (2, 'Module2');

INSERT INTO ROLE  VALUES (1, 'ROLE1');
INSERT INTO ROLE  VALUES (2, 'ROLE2');

INSERT INTO user (username, password, role_id) VALUES ("user1@live.nl", 'pas1', 1);
INSERT INTO user (username, password, role_id) VALUES ("user2@live.nl", 'pas2', 2);

INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('1', '1');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '2');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('1', '3');
INSERT INTO `function_module` (`module_id`, `function_id`) VALUES ('2', '3');

INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('1', '1');
INSERT INTO `module_role` (`role_id`, `module_id`) VALUES ('2', '2');