CREATE TABLE delfosapi.`permission` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE delfosapi.`user` (
  `id` bigint NOT NULL,
  `cep` varchar(8) NOT NULL,
  `creation_date` date NOT NULL,
  `document_type` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `state` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `updated_date` date DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO delfosapi.user (id, cep, creation_date, document_type, email, name, state, type, updated_date, document_number, password) VALUES
(1, 14821208, '2022-04-11', 1, 'leonardo@gmail.com', 'Leonardo Cardoso Camilo', 'ATIVO', 'COMMUNAL', '2022-04-11', '47579950839', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

ALTER TABLE delfosapi.user MODIFY id bigint NOT NULL AUTO_INCREMENT;

CREATE TABLE delfosapi.`user_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_permission` int DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpskbfr0wjeo3vcytgr8y2fhqx` (`id_user`),
  CONSTRAINT `FKpskbfr0wjeo3vcytgr8y2fhqx` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE delfosapi.`bill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cash_value` decimal(19,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `kvw_value` float DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhq5aolak9ku5x5mx11cpjad9` (`user_id`),
  CONSTRAINT `FKqhq5aolak9ku5x5mx11cpjad9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE delfosapi.`flag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE delfosapi.`tip` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
