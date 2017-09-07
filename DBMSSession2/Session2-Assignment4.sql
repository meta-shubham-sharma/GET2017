DROP DATABASE IF EXISTS FORM;

CREATE DATABASE FORM;

USE FORM;

CREATE TABLE ZipCode (
pincode int not null ,
district_name varchar(45),
state varchar(45) ,
PRIMARY KEY (pincode)
);

LOAD DATA LOCAL INFILE 'C:\\Users\\User21\\Desktop\\zipcode_data.csv' 
INTO TABLE zipcode FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n';

SELECT pincode,district_name,state FROM zipcode WHERE pincode = 311001;
