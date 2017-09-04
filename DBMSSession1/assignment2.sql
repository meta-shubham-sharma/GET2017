CREATE DATABASE LIS;

USE LIS;

CREATE TABLE members(
	member_id int NOT NULL AUTO_INCREMENT,
	member_nm varchar(20),
	addressline1 varchar(50),
	addressline2 varchar(50),
	category varchar(20),
	PRIMARY KEY(member_id)
);

CREATE TABLE subjects(
  subject_id int NOT NULL AUTO_INCREMENT,  
  subject_nm varchar(20),
  PRIMARY KEY(subject_id)
);

CREATE TABLE publishers(
  publisher_id int NOT NULL AUTO_INCREMENT,  
  publisher_nm varchar(20),
  PRIMARY KEY(publisher_id)
);

CREATE TABLE authors(
  author_id int NOT NULL AUTO_INCREMENT,  
  author_nm varchar(20),
  PRIMARY KEY(author_id)
);

CREATE TABLE titles(
  title_id int NOT NULL AUTO_INCREMENT,  
  title_nm varchar(20),
  subject_id int,
  publisher_id int,
  PRIMARY KEY(title_id),
  FOREIGN KEY(subject_id) references subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(publisher_id) references publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE books(
    accession_no int NOT NULL AUTO_INCREMENT,
    title_id int,
    purchase_dt timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
    price double,
    status varchar(20),
    PRIMARY KEY(accession_no),
    FOREIGN KEY(title_id) references titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE title_author(
    title_id int,
    author_id int,
    PRIMARY KEY(title_id,author_id),
    FOREIGN KEY(title_id) references titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(author_id) references authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_issue(
    issue_dt timestamp,
    accession_no int,
    member_id int,
    due_dt timestamp,
    PRIMARY KEY(issue_dt,accession_no,member_id),
    FOREIGN KEY(accession_no) references books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_book_issue_members FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_return(
    return_dt timestamp,
    accession_no int,
    member_id int,
    issue_dt timestamp,
    PRIMARY KEY(return_dt,accession_no,member_id),
    FOREIGN KEY(accession_no) references books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT fk_book_return_members FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE
);

show tables;

DELIMITER $$
CREATE TRIGGER dt_15days
BEFORE INSERT ON `book_issue` FOR EACH ROW
BEGIN
   SET NEW.due_dt = now() + INTERVAL 15 DAY;
END;
$$
DELIMITER ;

ALTER TABLE book_return drop foreign key fk_book_return_members;
ALTER TABLE book_issue drop foreign key fk_book_issue_members;
drop table members;

CREATE TABLE members(
	member_id int NOT NULL AUTO_INCREMENT,
	member_nm varchar(20),
	addressline1 varchar(50),
	addressline2 varchar(50),
	category varchar(20),
	PRIMARY KEY(member_id)
);

ALTER TABLE book_return ADD FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE book_issue ADD FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
