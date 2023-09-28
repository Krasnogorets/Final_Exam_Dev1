USE human_friends;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('мурзик', '2011-01-01', 'кс-кс', 1),
('барсик', '2016-01-01', "мур-мур", 1),  
('пушистик', '2017-01-01', "кушать", 1); 

INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('рембо', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
('шарик', '2021-06-12', "сидеть, лежать, лапу", 2),  
('волк', '2018-05-01', "сидеть, лежать", 2), 
('лис', '2021-05-10', "сидеть, фу, место", 2);

INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('толстый', '2020-10-12', 'бегать', 3),
('худой', '2021-03-12', "прыгать", 3),  
('зануда', '2022-07-11', "валяться", 3), 
('череп', '2022-05-10', "покажи пузо", 3);

INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('розовый', '2020-01-12', 'бегом, шагом', 1),
('беляк', '2017-03-12', "бегом, аллюр, но",1),  
('черныш', '2016-05-20', "бегом, тпру", 1), 
('рыжуля', '2020-11-10', "шагом, но", 1);

INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('ленивый', '2019-04-10', "пошел", 2),
('тупой', '2020-03-12', "стой", 2),  
('ушастый', '2021-12-21', "быстрей", 2), 
('тормоз', '2022-10-22', "ешь морковку", 2);

INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('вася', '2022-03-11', 'плюнь', 3),
('юля', '2019-05-12', "плюнь далеко", 3),  
('женя', '2015-07-13', "на колени", 3), 
('саша', '2022-8-14', "улыбнись", 3);
