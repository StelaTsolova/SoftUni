CREATE TABLE `people` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` FLOAT(5, 2),
    `weight` FLOAT(5, 2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO `people` 
VALUES 
(1, 'Pesho', NULL, 1.90, 98.6, 'M', '1996-05-17', NULL),
(2, 'Petur', NULL, 1.80, 79.3, 'M', '1990-08-14', NULL),
(3, 'Petya', NULL, 1.60, 45.2, 'F', '1999-11-28', NULL),
(4, 'Poly', NULL, 1.67, 50.5, 'F', '1997-06-10', NULL),
(5, 'Ivan', NULL, 1.75, 67, 'M', '1986-01-12', NULL);