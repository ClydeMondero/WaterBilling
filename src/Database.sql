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

INSERT IGNORE INTO Admin (admin_id, admin_username, admin_password, admin_status) VALUES (1001, 'main_admin', '1234main', 'Active');

CREATE TABLE IF NOT EXISTS Staff(
	staff_id INT PRIMARY KEY AUTO_INCREMENT, 
        staff_lastname VARCHAR(25),
        staff_firstname VARCHAR(25),
        staff_middlename VARCHAR(25),
        staff_address VARCHAR(50),
        staff_phonenumber VARCHAR(25),
	staff_username VARCHAR(25) UNIQUE, 
        staff_password VARCHAR(25),
        staff_status VARCHAR(15)
);

INSERT IGNORE INTO Staff (staff_ id, staff_username, staff_password, staff_status) VALUES (1001, 'clyde_staff', '1234clyde', 'Active');

SELECT * FROM Admin;

SELECT * FROM Staff;

DROP DATABASE WaterBilling;