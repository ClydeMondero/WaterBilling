CREATE DATABASE IF NOT EXISTS WaterBilling;

USE WaterBilling;

CREATE TABLE IF NOT EXISTS Admin(
	id INT PRIMARY KEY AUTO_INCREMENT, 
        lastname VARCHAR(25),
        firstname VARCHAR(25),
        middlename VARCHAR(25),
        address VARCHAR(50),
        phonenumber VARCHAR(25),
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT IGNORE INTO Admin (username, password) VALUES ('admin', 'admin');

CREATE TABLE IF NOT EXISTS Staff(
	id INT PRIMARY KEY AUTO_INCREMENT , 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT IGNORE INTO Staff (username, password) VALUES ('staff', 'staff');

SELECT * FROM Administrator;

SELECT * FROM Staff;
