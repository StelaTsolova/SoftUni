CREATE TABLE `directors` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT 
);

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT 
);

CREATE TABLE `movies` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `director_id` INT,
    `copyright_year` YEAR ,
    `length` TIME,
    `genre_id` INT,
    `category_id` INT,
    `rating` DOUBLE,
    `notes` TEXT 
);

/*
ALTER TABLE `movies`
ADD CONSTRAINT fk_movies_directors
FOREIGN KEY (`director_id`) REFERENCES `directors`(`id`),
ADD CONSTRAINT fk_movies_genres
FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`),
ADD CONSTRAINT fk_movies_categories
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`);
*/

INSERT INTO `directors` 
VALUES 
(1, 'Pesho', NULL),
(2, 'Petya', NULL),
(3, 'Poly', NULL),
(4, 'Mitko', NULL),
(5, 'Gosho', NULL);

INSERT INTO `genres` 
VALUES 
(1, 'Horror', NULL),
(2, 'Romance', NULL),
(3, 'Comedy', NULL),
(4, 'Drama', NULL),
(5, 'Action', NULL);

INSERT INTO `categories` 
VALUES 
(1, 'First', NULL),
(2, 'Secont', NULL),
(3, 'Third', NULL),
(4, 'Fourth', NULL),
(5, 'Fifth', NULL);

INSERT INTO `movies`
VALUES
(1, 'Love', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Dog',  NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Cat',  NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Mouse', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'Snake', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
