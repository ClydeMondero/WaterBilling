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

CREATE TABLE IF NOT EXISTS Meter(
	meter_id VARCHAR(6) PRIMARY KEY, 
        meter_size DOUBLE,
        meter_reading_date DATE,
        meter_reading INT,
        meter_consumption INT     
);

INSERT IGNORE INTO Meter VALUES (123456, 0.5, '2023-06-06', 224, 0);

CREATE TABLE IF NOT EXISTS Client(
	client_id INT PRIMARY KEY AUTO_INCREMENT, 
        client_lastname VARCHAR(25),
        client_firstname VARCHAR(25),
        client_middlename VARCHAR(25),
        client_address VARCHAR(50),
        client_phonenumber VARCHAR(25),
	client_rateclass SET('Residential', 'Semi-Business', 'Business'),  
        meter_id VARCHAR(6),
        client_status SET('Connected', 'Disconnected'),
        FOREIGN KEY (meter_id) REFERENCES Meter(meter_id)
        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Client VALUES (1001, 'Ragos', 'Ryan', 'M', 'Bustos, Bulacan', '09', 'Residential', 123456, 'Connected');

CREATE TABLE IF NOT EXISTS Invoice(
		invoice_id INT PRIMARY KEY AUTO_INCREMENT, 
        invoice_period_date DATE,        
        invoice_amount DOUBLE,
        invoice_due_date DATE,
        invoice_payment DOUBLE,
        invoice_payment_date DATE,
        invoice_status SET ('Paid', 'UnPaid'),
        client_id INT,
        meter_id VARCHAR(6),
        staff_id INT,
        admin_id INT,
        FOREIGN KEY (client_id) REFERENCES Client(client_id),
        FOREIGN KEY (meter_id) REFERENCES Meter(meter_id),
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Invoice (invoice_id, invoice_period_date, invoice_amount, invoice_due_date, client_id, meter_id, staff_id) 
VALUES (1001, '2023-05-06', 6000, '2023-06-06','Unpaid', 1001, 123456, 1001);

SELECT * FROM Admin;

SELECT * FROM Staff;

SELECT * FROM Client;

SELECT * FROM Meter;

SELECT * FROM Invoice;

-- DROP DATABASE WaterBilling;