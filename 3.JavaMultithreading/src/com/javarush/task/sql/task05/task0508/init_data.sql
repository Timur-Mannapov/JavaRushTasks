DROP TABLE IF EXISTS `author`;

CREATE TABLE `author`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(50)  DEFAULT NULL,
    `last_name`  varchar(50)  DEFAULT NULL,
    `full_name`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 28
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


LOCK TABLES `author` WRITE;