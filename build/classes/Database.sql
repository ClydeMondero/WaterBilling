CREATE DATABASE IF NOT EXISTS WaterBilling;

USE WaterBilling;

CREATE TABLE IF NOT EXISTS Administrator(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT INTO Administrator (username, password) VALUES ('admin', 'admin');

CREATE TABLE IF NOT EXISTS Staff(
	id INT PRIMARY KEY AUTO_INCREMENT , 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT INTO Staff (username, password) VALUES ('staff', 'staff');

SELECT * FROM Administrator;

SELECT * FROM Staff;
