CREATE DATABASE WaterBilling;

USE WaterBilling;

CREATE TABLE Administrator(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	username VARCHAR(25), 
	password VARCHAR(25)
);

INSERT INTO Administrator (username, password) VALUES ('admin', 'admin');

CREATE TABLE Staff(
	id INT PRIMARY KEY AUTO_INCREMENT , 
	username VARCHAR(25), 
	password VARCHAR(25)
);

INSERT INTO Staff (username, password) VALUES ('staff', 'staff');

SELECT * FROM Administrator;

SELECT * FROM Staff;
