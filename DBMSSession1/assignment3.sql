insert into members(member_nm,addressline1,addressline2,category) values ("shubham","csan","bhl","G");
insert into members(member_nm,addressline1,addressline2,category) values ("pawan","csk","ajmer","F");
insert into members(member_nm,addressline1,addressline2,category) values ("rajat","kumbha marg","bhl","G");
insert into members(member_nm,addressline1,addressline2,category) values ("gourav","tonk road","ajmer","F");
insert into members(member_nm,addressline1,addressline2,category) values ("udit","haldighati","bhl","G");
insert into members(member_nm,addressline1,addressline2,category) values ("mahesh","shastri nagar","ajmer","F");

insert into subjects(subject_nm) values ("Chemistry");
insert into subjects(subject_nm) values ("Physics");
insert into subjects(subject_nm) values ("Data Structure");
insert into subjects(subject_nm) values ("Prog.Fundamental");
insert into subjects(subject_nm) values ("DBMS");
insert into subjects(subject_nm) values ("OOPS Concepts");

insert into publishers(publisher_nm) values ("K.K. Menon");
insert into publishers(publisher_nm) values ("Sachin");
insert into publishers(publisher_nm) values ("Sourav Menon");
insert into publishers(publisher_nm) values ("Virat Jain");
insert into publishers(publisher_nm) values ("M.K. Batra");
insert into publishers(publisher_nm) values ("Alok Kumar");

insert into authors(author_nm) values ("Arjun P.");
insert into authors(author_nm) values ("Prakash");
insert into authors(author_nm) values ("Arjun Prakash");
insert into authors(author_nm) values ("P.K. Gupta");
insert into authors(author_nm) values ("Arun Guha");
insert into authors(author_nm) values ("Vijay Laxman");

insert into titles(title_nm,subject_id,publisher_id) values ("Organic Fundamentals","1","1");
insert into titles(title_nm,subject_id,publisher_id) values ("HC Verma","2","2");
insert into titles(title_nm,subject_id,publisher_id) values ("DS part1","3","1");
insert into titles(title_nm,subject_id,publisher_id) values ("DS part2","3","2");
insert into titles(title_nm,subject_id,publisher_id) values ("OOPS Part1","6","1");
insert into titles(title_nm,subject_id,publisher_id) values ("HC Verma part2","2","2");

insert into books(title_id,purchase_dt,price,status) values ("1",now(),"125.00","not avilable");
insert into books(title_id,price,status) values ("2","132.00","available");
insert into books(title_id,purchase_dt,price,status) values ("3",now(),"225.00","not avilable");
insert into books(title_id,price,status) values ("4","232.00","available");
insert into books(title_id,purchase_dt,price,status) values ("5",now(),"325.00","not avilable");
insert into books(title_id,price,status) values ("6","332.00","available");

insert into title_author(title_id,author_id) values ("1","1");
insert into title_author(title_id,author_id) values ("2","2");
insert into title_author(title_id,author_id) values ("3","3");
insert into title_author(title_id,author_id) values ("4","4");
insert into title_author(title_id,author_id) values ("5","5");
insert into title_author(title_id,author_id) values ("6","6");

insert into book_issue(accession_no,member_id) values ("1","1"); 
insert into book_issue(accession_no,member_id) values ("2","2");
insert into book_issue(accession_no,member_id) values ("3","1"); 

insert into book_return(accession_no,member_id, issue_dt) SELECT accession_no, member_id, issue_dt FROM book_issue where member_id = '1' and accession_no = '1';
insert into book_return(accession_no,member_id, issue_dt) SELECT accession_no, member_id, issue_dt FROM book_issue where member_id = '2' and accession_no = '2';

SET SQL_SAFE_UPDATES=0;
UPDATE members SET addressline2 = "jaipur(RAJ.)";

UPDATE members SET addressline1 = "EPIP, Sitapura" where category="F";

DELETE FROM PUBLISHERS;

SET @publisher_id1 = 1;
SET @publisher_nm1 = 'New Moon Books';
SET @publisher_id2 = 2;
SET @publisher_nm2 = 'Binnet & Harley';
INSERT INTO publishers(publisher_id, publisher_nm) VALUES (@publisher_id1, @publisher_nm1), (@publisher_id2, @publisher_nm2);

DELETE FROM titles where publisher_id ="1";


