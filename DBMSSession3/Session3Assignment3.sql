USE LIS;

/*Assignment 3.1 select count of different categories*/
SELECT (SELECT COUNT(member_id) FROM members WHERE category = 'S') AS Students,
(SELECT COUNT(member_id) FROM members WHERE category = 'F') AS Faculty,
(SELECT COUNT(member_id) FROM members WHERE category = 'O') AS Others
FROM members group by Students;

/*Assignment 3.2 select details of title when book is iisued more than once*/
SELECT t.title_nm , t.title_id 
FROM book_issue i JOIN books b ON i.accession_no = b.accession_no,
titles t 
WHERE b.title_id = t.title_id GROUP BY i.accession_no HAVING COUNT(i.accession_no) > 2 ; 
     
 /*Assignment 3.3 select member details having category non faculty*/    
SELECT i.member_id,b.accession_no,b.title_id,b.purchase_dt,b.price
FROM books b JOIN book_issue i ON i.accession_no = b.accession_no,
members mb  
WHERE i.member_id = mb.member_id AND mb.category !='F'; 

/*Assignment 3.4 select author details for books purchased */
SELECT a.title_id,author_id 
FROM title_author a JOIN books b ON a.title_id = b.title_id 
WHERE b.purchase_dt IS NOT NULL; 
