CREATE DATABASE human_friends;
USE human_friends;
drop TABLE animals_list;
CREATE TABLE if not EXISTS animals_list
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    GenusId int
);
INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('мурзик', '2011-01-01', 'кс-кс', 1),
('барсик', '2016-01-01', "мур-мур", 1),  
('пушистик', '2017-01-01', "кушать", 1); 

INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('рембо', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
('шарик', '2021-06-12', "сидеть, лежать, лапу", 2),  
('волк', '2018-05-01', "сидеть, лежать", 2), 
('лис', '2021-05-10', "сидеть, фу, место", 2);

INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('толстый', '2020-10-12', 'бегать', 3),
('худой', '2021-03-12', "прыгать", 3),  
('зануда', '2022-07-11', "валяться", 3), 
('череп', '2022-05-10', "покажи пузо", 3);

INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('розовый', '2020-01-12', 'бегом, шагом', 4),
('беляк', '2017-03-12', "бегом, аллюр, но",4),  
('черныш', '2016-05-20', "бегом, тпру", 4), 
('рыжуля', '2020-11-10', "шагом, но", 4);

INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('ленивый', '2019-04-10', "пошел", 5),
('тупой', '2020-03-12', "стой", 5),  
('ушастый', '2021-12-21', "быстрей", 5), 
('тормоз', '2022-10-22', "ешь морковку", 5);

INSERT INTO animals_list (Name, Birthday, Commands, GenusId)
VALUES ('вася', '2022-03-11', 'плюнь', 6),
('юля', '2019-05-12', "плюнь далеко", 6),  
('женя', '2015-07-13', "на колени", 6), 
('саша', '2022-8-14', "улыбнись", 6);

CREATE TABLE if not EXISTS animals_types
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Genus_name VARCHAR(20)
);
INSERT INTO animals_types (Genus_name)
VALUES ("Cat"),
('Dog'),  
('Hamster'), 
('Horse' ),
('Donkey' ),
('Camel' );

DROP TABLE Genus_command;
CREATE TABLE if not EXISTS Genus_command
(       
    CommandId INT, 
    Command_name VARCHAR(20),
    GenusId int
);

INSERT INTO Genus_command (CommandId, Command_name, GenusId)
VALUES (1,'плюнь', 6),
(2,"плюнь далеко", 6),  
(3, "на колени", 6), 
(4,"улыбнись", 6),
(5, "пошел", 5),
(6, "стой", 5),  
(7, "быстрей", 5), 
(8,"ешь морковку", 5),
 (9,'бегом', 4),
(10,"тпру",4),  
(11,"шагом", 4), 
(12,"аллюр", 4), 
(13,"но", 4),
 (14,'бегать', 3),
(15,"прыгать", 3),  
(16,"валяться", 3), 
(17,"покажи пузо", 3),
 (18,'ко мне', 2),
(19,"сидеть", 2),  
(20,"лежать", 2),  
(21,"лапу", 2),  
(22,"голос", 2),  
(23, "фу", 2), 
( 24,"место", 2),
 (25, 'кс-кс', 1),
(26,"мур-мур", 1),  
(27,"кушать", 1); 
DROP TABLE commands;
CREATE TABLE if not EXISTS commands
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Command_name VARCHAR(20)
);

INSERT INTO commands (Command_name)
VALUES ('плюнь'),
("плюнь далеко"),  
( "на колени"), 
("улыбнись"),
( "пошел"),
( "стой"),  
( "быстрей"), 
("ешь морковку"),
 ('бегом'),
("тпру"),  
("шагом"), 
("аллюр"), 
("но"),
('бегать'),
("прыгать"),  
("валяться"), 
("покажи пузо"),
('ко мне'),
("сидеть"),  
("лежать"),  
("лапу"),  
("голос"),  
( "фу"), 
( "место"),
( 'кс-кс'),
("мур-мур"),  
("кушать"); 
DROP TABLE animals_command;
CREATE TABLE if not EXISTS animals_command
(       
    CommandId INT,
	Command_name VARCHAR(20),
    Animal_id int
);
INSERT INTO animals_command (CommandId, Command_name, Animal_id)
VALUES (25,'кс-кс', 1),
( 26, "мур-мур", 2),  
( 27,"кушать",3),
(18, 'ко мне', 4),
(20,'лежать', 4),
(21,'лапу', 4),
(22,'голос', 4),
(19,"сидеть", 5),  
(20, "лежать", 5),  
(21,"лапу", 5),  
(19,"сидеть", 6), 
(20,"лежать", 6), 
(19,"сидеть", 7),
(23,"фу", 7),
(24,"место", 7),
(14,'бегать', 8),
(15,"прыгать", 9),  
( 16,"валяться", 10), 
( 17,"покажи пузо", 11),
(9,'бегом', 12),
(11,'шагом', 12),
(9,"бегом",13),  
(12,"аллюр",13),  
(13,"но",13),  
( 9,"бегом", 14), 
(10,"тпру", 14), 
(11,"шагом", 15),
(13, "но", 15),
(5,"пошел", 16),
(6,"стой", 17),  
(7,"быстрей", 18), 
(8, "ешь морковку", 19),
(1,'плюнь', 20),
(2, "плюнь далеко", 21),  
(3, "на колени", 22), 
( 4,"улыбнись", 23);
ALTER TABLE animals_command DROP Command_name;
SELECT * FROM animals_command;
SELECT * FROM commands;
SELECT * FROM Genus_command;
ALTER TABLE Genus_command DROP Command_name;
SELECT * FROM animals_list;