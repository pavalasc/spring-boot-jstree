DROP TABLE IF EXISTS asset;
CREATE TABLE `asset` (
  `id` int NOT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `a_attr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM asset;
INSERT INTO asset(id, parent, text, a_attr) VALUES(1, "#", "Simple root directory", null);
INSERT INTO asset(id, parent, text, a_attr) VALUES(2, "#", "First directory", null);
INSERT INTO asset(id, parent, text, a_attr) VALUES(3, "2", "First node/file client of First directory", "href:http://www.example.com");
INSERT INTO asset(id, parent, text, a_attr) VALUES(4, "2", "Second node/file client of First directory", "href:http://www.example.com");
INSERT INTO asset(id, parent, text, a_attr) VALUES(5, "#", "Second directory", null);
INSERT INTO asset(id, parent, text, a_attr) VALUES(6, "5", "Text before link <a class='link' href='www.google.com'>http://www.google.com</a>", "href:http://www.example.com");