USE LIS;

/*Assignment 2.1 select details from subjects when a book is purchased*/
SELECT s.subject_nm,s.subject_id
FROM books b JOIN titles t ON b.title_id = t.title_id ,
subjects s 
WHERE t.subject_id = s.subject_id AND b.purchase_dt IS NOT NULL;

/*Assignment 2.2 select books issued for more than 2 months*/
SELECT issue_dt,accession_no,member_id,due_dt 
FROM book_issue
WHERE DATEDIFF(due_dt,issue_dt) > 60;

/*Assignment 2.3 select books having price more than minimum price of purchased book*/
SELECT accession_no,title_id,purchase_dt,price,status 
FROM books 
WHERE price > ( SELECT MIN(price) FROM books WHERE purchase_dt IS NOT NULL );