CREATE DATABASE IF NOT EXISTS WaterBilling;

USE WaterBilling;

CREATE TABLE IF NOT EXISTS Administrator(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT IGNORE INTO Administrator (username, password) VALUES ('admin', 'admin');

CREATE TABLE IF NOT EXISTS Staff(
	id INT PRIMARY KEY AUTO_INCREMENT , 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT IGNORE INTO Staff (username, password) VALUES ('staff', 'staff');

SELECT * FROM Administrator;

SELECT * FROM Staff;
