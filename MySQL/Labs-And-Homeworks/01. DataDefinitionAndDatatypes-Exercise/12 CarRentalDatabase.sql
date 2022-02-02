# CREATE DATABASE car_rental; 

CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `category` VARCHAR(50) NOT NULL,
    `daily_rate` DOUBLE,
    `weekly_rate` DOUBLE,
    `monthly_rate` DOUBLE,
    `weekend_rate` DOUBLE
);

CREATE TABLE `cars` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `plate_number` INT NOT NULL,
    `make` VARCHAR(50),
    `model` VARCHAR(50),
    `car_year` YEAR,
    `category_id` INT,
    `doors` INT,
    `picture` BLOB,
    `car_condition` VARCHAR(50),
    `available` VARCHAR(50)
);

CREATE TABLE `employees` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50),
    `title` VARCHAR(50),
    `notes` TEXT
);

CREATE TABLE `customers` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `driver_licence_number` INT NOT NULL,
    `full_name` VARCHAR(50),
    `address` VARCHAR(50),
    `city` VARCHAR(50),
    `zip_code` INT,
    `notes` TEXT
);

CREATE TABLE `rental_orders` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `employee_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `car_id` INT NOT NULL,
    `car_condition` VARCHAR(50),
    `tank_level` INT,
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` INT,
    `rate_applied` DOUBLE,
    `tax_rate` DOUBLE,
    `order_status` VARCHAR(50),
    `notes` TEXT
);

/*
ALTER TABLE `rental_orders`
ADD CONSTRAINT fk_rental_orders_employees
FOREIGN KEY (`employee_id`) REFERENCES `employees`(`id`),
ADD CONSTRAINT fk_rental_orders_customer
FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
ADD CONSTRAINT fk_rental_orders_car
FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`);
*/

INSERT INTO `categories` (`id`, `category`)
VALUES
(1, 'A'),
(2, 'B'),
(3, 'C');

INSERT INTO  `cars` (`id`, `plate_number`)
VALUES 
(1, 1423),
(2, 1789),
(3, 3652);

INSERT INTO `employees` (`id`, `first_name`)
VALUES
(1, 'Pesho'),
(2, 'Gosho'),
(3, 'Tosho');

INSERT INTO `customers` (`id`, `driver_licence_number`)
VALUES
(1, 286317),
(2, 256973),
(3, 834516);

INSERT INTO `rental_orders` (`id`, `employee_id`, `customer_id`, `car_id`)
VALUES
(1, 2, 1, 3),
(2, 1, 3, 2),
(3, 3, 2, 1);