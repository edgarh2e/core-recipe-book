--liquibase formatted sql

--changeset edgarh2e:1
CREATE TABLE recipe_book.user(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL);

CREATE TABLE recipe_book.recipe(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(250) NOT NULL,
  imageUrl VARCHAR(100) NOT NULL);

--changeset edgarh2e:2
ALTER TABLE recipe_book.recipe MODIFY imageUrl VARCHAR(500) NOT NULL;

--changeset edgarh2e:3
ALTER TABLE recipe CHANGE imageUrl image_url VARCHAR(500) NOT NULL;