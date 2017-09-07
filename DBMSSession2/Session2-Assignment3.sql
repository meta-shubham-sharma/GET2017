DROP DATABASE IF EXISTS ECOMMERCE;

CREATE DATABASE ECOMMERCE;

USE ECOMMERCE;

CREATE TABLE categories(
    category varchar(45),
    category_id varchar(45),
    parent_id varchar(45),
    PRIMARY KEY(category_id),
    FOREIGN KEY(parent_id) references categories(category_id)
);

/*Enter top categories into table */
INSERT INTO categories(category_id,category) VALUES('MT1','Mobiles & Tablets');
INSERT INTO categories(category_id,category) VALUES('C1','Computers');
INSERT INTO categories(category_id,category) VALUES('HA1','Home Appliances');

/*Enter sub categories of Mobiles & Tablets into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('M1','MT1','Mobiles');
INSERT INTO categories(category_id,parent_id,category) VALUES('T1','MT1','Tablets');
INSERT INTO categories(category_id,parent_id,category) VALUES('A1','MT1','Accessories');
INSERT INTO categories(category_id,parent_id,category) VALUES('CC1','MT1','Cases & Covers');

/*Enter sub categories of Computers into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('D1','C1','Desktop');
INSERT INTO categories(category_id,parent_id,category) VALUES('L1','C1','Laptop');
INSERT INTO categories(category_id,parent_id,category) VALUES('LA1','C1','Laptop Accessories');
INSERT INTO categories(category_id,parent_id,category) VALUES('P1','C1','Printers');

/*Enter sub categories of Home Appliances into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('TV1','HA1','TVs');
INSERT INTO categories(category_id,parent_id,category) VALUES('AC1','HA1','Air Conditioners');
INSERT INTO categories(category_id,parent_id,category) VALUES('WM1','HA1','Washing Machines');

/*Enter sub categories of Mobiles into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('SP1','M1','SmartPhones');
INSERT INTO categories(category_id,parent_id,category) VALUES('FP1','M1','Featured Phones');

/*Enter sub categories of Tablets into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('2G1','T1','2G');
INSERT INTO categories(category_id,parent_id,category) VALUES('3G1','T1','3G');

/*Enter sub categories of Laptop Accessories into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('Key1','LA1','Keyboard');
INSERT INTO categories(category_id,parent_id,category) VALUES('Mouse1','LA1','Mouse');
INSERT INTO categories(category_id,parent_id,category) VALUES('Head1','LA1','Headphones');

/*Enter sub categories of Printers into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('Ink1','P1','Inkjet');
INSERT INTO categories(category_id,parent_id,category) VALUES('Laser1','P1','Laser');

/*Enter sub categories of TVs into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('LED1','TV1','LED');
INSERT INTO categories(category_id,parent_id,category) VALUES('LCD1','TV1','LCD');
INSERT INTO categories(category_id,parent_id,category) VALUES('PLASMA1','TV1','Plasma');

/*Enter sub categories of Washing Machines into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('FA1','WM1','Full AUtomatic');
INSERT INTO categories(category_id,parent_id,category) VALUES('SA1','WM1','Semi Automatic');

/*Enter sub categories of Full Automatic into table */
INSERT INTO categories(category_id,parent_id,category) VALUES('TL1','FA1','Top Load');
INSERT INTO categories(category_id,parent_id,category) VALUES('FL1','FA1','Front Load');

SELECT category_id,category,IFNULL(parent_id,'Top Category') as ParentId
FROM categories order by parent_id;

SELECT category_id,category FROM categories where parent_id IS NULL ;
