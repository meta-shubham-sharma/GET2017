USE lis;

/* Assignment 1.1 select members of a particular category*/
SELECT member_nm
FROM members 
WHERE member_nm != 'gourav' AND category = (SELECT category 
                    FROM members WHERE member_nm = 'gourav');

/* Assignment 1.2 select details of issued books*/
SELECT mb.member_nm,t.title_nm,i.issue_dt,i.due_dt
FROM book_issue i JOIN book_return r ON r.return_dt IS NULL AND i.accession_no = r.accession_no AND i.member_id = r.member_id,
books b JOIN titles t ON b.title_id = t.title_id,
members mb 
WHERE mb.member_id IN (SELECT r.member_id FROM book_return) AND b.accession_no IN (SELECT r.accession_no FROM book_return) ; 

/* Assignment 1.3 select details of books issued for more than due date */
SELECT mb.member_nm,t.title_nm,i.issue_dt,i.due_dt,r.return_dt
FROM book_issue i JOIN book_return r ON i.accession_no = r.accession_no AND i.member_id = r.member_id,
books b JOIN titles t ON b.title_id = t.title_id,
members mb 
WHERE DATEDIFF(r.return_dt,i.due_dt) >=1 AND mb.member_id IN (SELECT r.member_id FROM book_return) AND b.accession_no IN (SELECT r.accession_no FROM book_return) ;

/* Assignment 1.4 select books of a particular price*/
SELECT b.title_id,t.title_nm,b.price,b.accession_no 
FROM books b JOIN titles t ON b.title_id = t.title_id
WHERE b.price = ( SELECT MAX(price) FROM books WHERE purchase_dt IS NOT NULL);

/* Assignment 1.5 select books with second highest price*/
SELECT MAX(price)AS SecondMaximum,title_id
FROM books
WHERE price < (SELECT MAX(price) FROM BOOKS);
