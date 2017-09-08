USE lis;

/* Assignment 2.1 create view for details of issued books*/
DROP VIEW IF EXISTS IssuedBooks;

CREATE VIEW IssuedBooks
AS
SELECT mb.member_nm,i.member_id,i.accession_no,i.issue_dt,i.due_dt
FROM book_issue i JOIN members mb ON i.member_id = mb.member_id;

SELECT member_nm,member_id,accession_no,issue_dt,due_dt
FROM IssuedBooks;

/* Assignment 2.2 create view for details of members of a particular category*/
DROP VIEW IF EXISTS MemberDetails;

CREATE VIEW MemberDetails
AS
SELECT member_nm,member_id,category
FROM members;

SELECT member_nm,member_id,IF(category='S','Student',IF(category='F','Faculty','Others')) AS Category
FROM MemberDetails;

/* Assignment 2.3 create view for details of issued books and members*/
DROP VIEW IF EXISTS BookDetails;

CREATE VIEW BookDetails
AS 
SELECT mb.member_nm,s.subject_nm,t.title_nm,mb.category,i.issue_dt,i.due_dt,r.return_dt
FROM book_issue i JOIN book_return r JOIN books b JOIN titles t JOIN subjects s 
ON i.accession_no = r.accession_no AND i.member_id = r.member_id 
AND i.accession_no = b.accession_no 
AND b.title_id = t.title_id AND t.subject_id = s.subject_id,
members mb
WHERE mb.member_id = i.member_id;

SELECT member_nm,subject_nm,title_nm,category,issue_dt,due_dt,return_dt
FROM BookDetails;