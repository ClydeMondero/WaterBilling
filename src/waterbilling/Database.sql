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
        admin_status SET('Active', 'Deactivated', 'Deleted')        
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
        staff_status SET('Active', 'Deactivated', 'Deleted')        
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Staff VALUES (1001, 'Madrideo', 'Joseph', 'Manelese', 'Baliuag, Bulacan', '09453268912', 'joseph_staff', '1234joseph', 'Active');

CREATE TABLE IF NOT EXISTS AdminsStaffs(		
        staff_id INT,        
        admin_id INT,   
        action SET ('Created', 'Updated', 'Deleted'),
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),        
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)		
);

INSERT IGNORE INTO AdminsStaffs VALUES(1001, 1001, 'Created');

CREATE TABLE IF NOT EXISTS Cashier(
	cashier_id INT PRIMARY KEY AUTO_INCREMENT, 
        cashier_lastname VARCHAR(25),
        cashier_firstname VARCHAR(25),
        cashier_middlename VARCHAR(25),
        cashier_address VARCHAR(50),
        cashier_phonenumber VARCHAR(25),
	cashier_username VARCHAR(25) UNIQUE, 
        cashier_password VARCHAR(25),
        cashier_status SET('Active', 'Deactivated', 'Deleted')      
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Cashier VALUES (1001, 'Poma', 'Andrei', 'Vergel De Dios', 'Baliuag, Bulacan', '09487628412', 'poma_cashier', '1234poma', 'Active');

CREATE TABLE IF NOT EXISTS AdminsCashiers(		
        cashier_id INT,        
        admin_id INT,   
        action SET ('Created', 'Updated', 'Deleted'),
        FOREIGN KEY (cashier_id) REFERENCES Cashier(cashier_id),        
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)		
);

INSERT IGNORE INTO AdminsCashiers VALUES(1001, 1001, 'Created');

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
        client_status SET('Connected', 'Disconnected', 'Deleted'),
        client_balance DOUBLE,
        FOREIGN KEY (meter_id) REFERENCES Meter(meter_id)        	
)AUTO_INCREMENT = 1001;

INSERT IGNORE INTO Client (client_id, client_lastname, client_firstname, client_middlename, client_address, client_phonenumber, 
client_rateclass, meter_id, client_status) 
VALUES (1001, 'Ragos', 'Ryan', 'M', 'Bustos, Bulacan', '0923358201', 'Residential', 123456, 'Connected');

CREATE TABLE IF NOT EXISTS AdminsClients(		
        client_id INT,        
        admin_id INT,   
        action SET ('Created', 'Updated', 'Deleted'),
        FOREIGN KEY (client_id) REFERENCES Client(client_id),        
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)		
);

CREATE TABLE IF NOT EXISTS StaffsClients(		
        client_id INT,        
        staff_id INT,   
        action SET ('Created', 'Updated', 'Deleted'),
        FOREIGN KEY (client_id) REFERENCES Client(client_id),        
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)		
);

INSERT IGNORE INTO StaffsClients VALUES(1001, 1001, 'Created');


CREATE TABLE IF NOT EXISTS Invoice(
		invoice_id INT PRIMARY KEY AUTO_INCREMENT,                 	
        invoice_period_date DATE,
        invoice_payment DOUBLE,
        invoice_payment_date DATE,
        invoice_status SET ('Paid', 'UnPaid', 'Deleted'),
        invoice_basic_charge DOUBLE,
        invoice_transitory_charge DOUBLE,
        invoice_environmental_charge DOUBLE,
        invoice_maintenance_charge  DOUBLE,
        invoice_before_tax  DOUBLE,
        invoice_tax DOUBLE,
        invoice_discount DOUBLE,
        invoice_amount DOUBLE,
        client_id INT,        
        staff_id INT,
        cashier_id INT,
        admin_id INT,
        FOREIGN KEY (client_id) REFERENCES Client(client_id),        
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
        FOREIGN KEY (cashier_id) REFERENCES Cashier (cashier_id),
        FOREIGN KEY (admin_id) REFERENCES Admin(admin_id)        
)AUTO_INCREMENT = 1001;

SELECT * FROM Admin;

SELECT * FROM Staff;

SELECT * FROM Cashier;

SELECT * FROM Client;

SELECT * FROM Meter;

SELECT * FROM Invoice;

SELECT * FROM AdminsStaffs;

SELECT * FROM AdminsCashiers;

SELECT * FROM AdminsClients;

SELECT * FROM StaffsClients;

-- DROP DATABASE WaterBilling;