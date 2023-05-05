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
        admin_status SET('Active', 'Deactivated')
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Admin (admin_username, admin_password, admin_status) VALUES ('main_admin', '1234main', 'Active');

CREATE TABLE IF NOT EXISTS Staff(
	staff_id INT PRIMARY KEY AUTO_INCREMENT, 
        staff_lastname VARCHAR(25),
        staff_firstname VARCHAR(25),
        staff_middlename VARCHAR(25),
        staff_address VARCHAR(50),
        staff_phonenumber VARCHAR(25),
	staff_username VARCHAR(25) UNIQUE, 
        staff_password VARCHAR(25),
        staff_status SET('Active', 'Deactivated')
        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Staff (staff_username, staff_password, staff_status) VALUES ('clyde_staff', '1234clyde', 'Active');

CREATE TABLE IF NOT EXISTS Client(
	client_id INT PRIMARY KEY AUTO_INCREMENT, 
        client_lastname VARCHAR(25),
        client_firstname VARCHAR(25),
        client_middlename VARCHAR(25),
        client_address VARCHAR(50),
        client_phonenumber VARCHAR(25),
	client_rateclass SET('Residential', 'Semi-Business', 'Business'),  
        meter_id INT,
        client_status SET('Connected', 'Disconnected'),
        FOREIGN KEY (meter_id) REFERENCES Meter(meter_id)
        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Client VALUES (1001, 'Ragos', 'Ryan', 'M', 'Bustos, Bulacan', '09', 'Residential', 012345, 'Connected');

CREATE TABLE IF NOT EXISTS Meter(
	meter_id INT PRIMARY KEY AUTO_INCREMENT, 
        meter_size DOUBLE,
        meter_reading INT,
        meter_consumption INT     
);

INSERT IGNORE INTO Meter VALUES (012345, 0.5, 224, 0);

SELECT * FROM Admin;

SELECT * FROM Staff;

SELECT * FROM Client;

-- DROP DATABASE WaterBilling;