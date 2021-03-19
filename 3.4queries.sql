/* CREATE DATABASE CITY_CODE_DIRECTORY */
CREATE DATABASE IF NOT EXISTS CITY_CODE_DIRECTORY;

/* SELECT DATABSE TO USE */
USE CITY_CODE_DIRECTORY;

/* CREATE TABLE state */
CREATE TABLE IF NOT EXISTS state (
state_id int PRIMARY KEY AUTO_INCREMENT,
state_name VARCHAR(50)
);

DESCRIBE state;

/* CREATE TABLE city */
CREATE TABLE IF NOT EXISTS city (
city_zip_id int PRIMARY KEY,
city_name VARCHAR(50),
state_id int NOT NULL,FOREIGN KEY (state_id) REFERENCES state(state_id)
);

DESCRIBE city;

/* insert data into state */
INSERT INTO state(state_name) VALUES ("Andhra Pradesh");
INSERT INTO state(state_name) VALUES ("Arunachal Pradesh");
INSERT INTO state(state_name) VALUES ("Assam");
INSERT INTO state(state_name) VALUES ("Bihar");
INSERT INTO state(state_name) VALUES ("Chhattisgarh");
INSERT INTO state(state_name) VALUES ("Gujarat");
INSERT INTO state(state_name) VALUES ("Haryana");
INSERT INTO state(state_name) VALUES ("Rajasthan");

SELECT * FROM state;

/* insert data into city */
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (201457,"Amravathi",1);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (245784,"Itanagar",2);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (354124,"Dispur",3);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (298547,"Patna",4);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (652147,"Raipur",5);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (478512,"Ahemedabad",6);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (20101,"Jaipur",8);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (7867,"Jodhpur",8);
INSERT INTO city(city_zip_id,city_name,state_id) VALUES (301001,"Alwar",8);

SELECT * FROM city;

/* query to show city zip, name, state name sorted by state name and city name */
SELECT 
	city.city_zip_id AS ZIP_CODE, 
	city.city_name AS CITY_NAME, 
	state.state_name AS STATE_NAME 
FROM 
	city 
LEFT JOIN 
	state ON city.state_id = state.state_id
	ORDER BY STATE_NAME, CITY_NAME;