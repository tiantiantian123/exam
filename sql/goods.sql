DROP DATABASE goods;
CREATE DATABASE goods;

USE goods;


DROP TABLE IF EXISTS admin;
CREATE TABLE admin(
  id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255)
);

INSERT INTO goods.admin VALUES (NULL ,"admin","123");

DROP TABLE IF EXISTS supply;
CREATE TABLE supply(
  id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  addr VARCHAR(255),
  linkman VARCHAR(50),
  materials VARCHAR(50),
  tel VARCHAR(255)
);

INSERT INTO goods.supply VALUES (NULL ,"天翼电子商贸","北四环东路","杨怡","硒鼓","010-66778899");

SELECT *
FROM supply;