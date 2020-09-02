DROP TABLE IF EXISTS asset;
CREATE TABLE `asset` (
  `id` int NOT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `a_attr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM asset;
INSERT INTO asset(id, parent, text) VALUES(1, "#", "Simple root directory");
INSERT INTO asset(id, parent, text) VALUES(2, "#", "First directory");
INSERT INTO asset(id, parent, text) VALUES(3, "2", "First node/file client of First directory");
INSERT INTO asset(id, parent, text) VALUES(4, "2", "Second node/file client of First directory");
INSERT INTO asset(id, parent, text) VALUES(5, "#", "Second directory");
INSERT INTO asset(id, parent, text) VALUES(6, "5", "Text before link <a class='link' href='www.google.com'>http://www.google.com</a>");