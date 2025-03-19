-- Drop tables safely
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Payments CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Rentals CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Vehicles CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Users CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Locations CASCADE CONSTRAINTS'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

-- Create Users table
CREATE TABLE Users (
    user_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    contact_information VARCHAR2(100) NOT NULL,
    payment_method VARCHAR2(50) NOT NULL
);

-- Create Vehicles table
CREATE TABLE Vehicles (
    vehicle_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    model VARCHAR2(50) NOT NULL,
    rental_rate NUMBER(6,2) NOT NULL
);

-- Create Rentals table
CREATE TABLE Rentals (
    rental_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id NUMBER NOT NULL REFERENCES Users(user_id),
    vehicle_id NUMBER NOT NULL REFERENCES Vehicles(vehicle_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    distance_traveled NUMBER DEFAULT 0
);

-- Create Payments table
CREATE TABLE Payments (
    payment_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    rental_id NUMBER NOT NULL REFERENCES Rentals(rental_id),
    amount NUMBER(6,2) NOT NULL,
    payment_date DATE DEFAULT SYSDATE NOT NULL
);

-- Create Locations table
CREATE TABLE Locations (
    location_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    address VARCHAR2(100) NOT NULL
);

-- Insert sample data
INSERT INTO Users (name, contact_information, payment_method) 
VALUES ('John Doe', 'john.doe@example.com', 'Credit Card');

INSERT INTO Vehicles (model, rental_rate) 
VALUES ('Toyota Corolla', 40.00);

INSERT INTO Locations (name, address) 
VALUES ('Downtown Rental', '123 Main Street');

INSERT INTO Rentals (user_id, vehicle_id, start_date, end_date, distance_traveled) 
VALUES (1, 1, TO_DATE('2025-03-01', 'YYYY-MM-DD'), TO_DATE('2025-03-05', 'YYYY-MM-DD'), 100);

INSERT INTO Payments (rental_id, amount, payment_date) 
VALUES (1, 160.00, TO_DATE('2025-03-05', 'YYYY-MM-DD'));

COMMIT;
