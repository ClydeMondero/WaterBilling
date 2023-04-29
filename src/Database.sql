CREATE DATABASE IF NOT EXISTS WaterBilling;

USE WaterBilling;

CREATE TABLE IF NOT EXISTS Admin(
	admin_id INT PRIMARY KEY AUTO_INCREMENT, 
        admin_lastname VARCHAR(25),
        admin_firstname VARCHAR(25),
        admin_middlename VARCHAR(25),
        admin_address VARCHAR(50),
        admin_phonenumber VARCHAR(25),
	admin_username VARCHAR(25) UNIQUE, 
        admin_password VARCHAR(25),
        admin_status VARCHAR(15)
);

INSERT IGNORE INTO Admin (admin_username, admin_password, admin_status) VALUES ('main_admin', '1234main', 'Active');

CREATE TABLE IF NOT EXISTS Staff(
	id INT PRIMARY KEY AUTO_INCREMENT , 
	username VARCHAR(25) UNIQUE, 
	password VARCHAR(25)
);

INSERT IGNORE INTO Staff (username, password) VALUES ('staff', 'staff');

SELECT * FROM Admin;

SELECT * FROM Staff;

-- DROP DATABASE WaterBilling;