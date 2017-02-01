create DATABASE if NOT EXISTS adlister_db;

USE adlister_db;

CREATE TABLE if NOT EXISTS ads(
  id int UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(400) NOT NULL,
  description TEXT,
  PRIMARY KEY (id)
);