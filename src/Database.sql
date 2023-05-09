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

INSERT IGNORE INTO Admin VALUES (1001, 'Mondero', 'Clyde', 'Cruz', 'Baliuag, Bulacan', '09565317151', 'main_admin', '1234main', 'Active');

CREATE TABLE IF NOT EXISTS Staff(
	staff_id INT PRIMARY KEY AUTO_INCREMENT, 
        staff_lastname VARCHAR(25),
        staff_firstname VARCHAR(25),
        staff_middlename VARCHAR(25),
        staff_address VARCHAR(50),
        staff_phonenumber VARCHAR(25),
	staff_username VARCHAR(25) UNIQUE, 
        staff_password VARCHAR(25),
        staff_status SET('Active', 'Deactivated'),
        admin_id INT,
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Staff VALUES (1001, 'Madrideo', 'Joseph', 'Manelese', 'Baliuag, Bulacan', '09453268912', 'joseph_staff', '1234joseph', 'Active', 1001);
INSERT IGNORE INTO Staff VALUES (1002, 'Poma', 'Andrei', 'Vergel De Dios', 'Baliuag, Bulacan', '09487628412', 'poma_staff', '1234poma', 'Active', 1001);

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
        FOREIGN KEY (meter_id) REFERENCES Meter(meter_id),
        admin_id INT,
        staff_id INT,
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id),
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Client (client_id, client_lastname, client_firstname, client_middlename, client_address, client_phonenumber, 
client_rateclass, meter_id, client_status, staff_id) 
VALUES (1001, 'Ragos', 'Ryan', 'M', 'Bustos, Bulacan', '09', 'Residential', 123456, 'Connected', 1002);

CREATE TABLE IF NOT EXISTS Invoice(
		invoice_id INT PRIMARY KEY AUTO_INCREMENT,                 
        invoice_amount DOUBLE,
        invoice_period_date DATE,
        invoice_payment DOUBLE,
        invoice_payment_date DATE,
        invoice_status SET ('Paid', 'UnPaid'),
        client_id INT,        
        staff_id INT,
        admin_id INT,
        FOREIGN KEY (client_id) REFERENCES Client(client_id),        
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Invoice (invoice_id, invoice_amount, invoice_period_date, invoice_status, client_id, staff_id) 
VALUES (1001, 6000, '2023-06-06','Unpaid', 1001, 1001);

INSERT IGNORE INTO Invoice (invoice_id, invoice_amount, invoice_period_date, invoice_status, client_id, admin_id) 
VALUES (1002, 6000, '2023-06-06','Unpaid', 1001, 1001);

SELECT * FROM Admin;

SELECT * FROM Staff;

SELECT * FROM Client;

SELECT * FROM Meter;

SELECT * FROM Invoice;

SELECT * FROM Invoice
JOIN Client ON Invoice.client_id = Client.client_id
JOIN Staff ON Invoice.staff_id = Staff.staff_id;

SELECT * FROM Invoice
JOIN Client ON Invoice.client_id = Client.client_id
JOIN Admin ON Invoice.admin_id = Admin.admin_id;

-- DROP DATABASE WaterBilling;