CREATE DATABASE Waterbillingsystem;

USE Waterbillingsystem;

CREATE TABLE Administrator(id INTEGER PRIMARY KEY AUTO_INCREMENT, username VARCHAR(25), password VARCHAR(25));

INSERT INTO Administrator VALUES ('1', 'admin', 'admin');

SELECT * FROM Administrator;