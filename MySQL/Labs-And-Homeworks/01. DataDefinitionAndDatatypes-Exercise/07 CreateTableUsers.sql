CREATE TABLE `users` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30),
    `password` VARCHAR(26),
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

INSERT INTO `users` 
VALUES 
(1, 'Pesho', '123', NULL, '1996-05-17 22:30:59', TRUE),
(2, 'Ely', '12345', NULL, '2000-06-06 04:10:12', TRUE),
(3, 'Mimi', 'asd', NULL, '1986-05-17 23:45:39', FALSE),
(4, 'Petko', 'qwe', NULL, '2020-09-10 13:05:03', TRUE),
(5, 'Mitko', 'asd123', NULL, '2003-07-27 15:17:00', FALSE);