USE LIS;

DESC members;

SELECT member_id,member_nm,category FROM members;

SELECT member_id,member_nm,category FROM members WHERE category='F';

SELECT distinct(category) FROM members;

SELECT member_nm,category FROM members ORDER BY member_nm DESC;

SELECT t.title_nm,s.subject_nm,p.publisher_nm 
FROM titles t ,subjects s,publishers p 
WHERE t.subject_id = s.subject_id AND t.publisher_id = p.publisher_id; 

SELECT count(member_id),category FROM members GROUP BY category;

SELECT m.member_nm 
FROM members m join members mb
WHERE mb.member_nm = 'shubham' AND m.category = mb.category AND m.member_nm NOT IN('shubham'); 

SELECT i.issue_dt AS IssueDate,i.accession_no AS AccessionNo,i.member_id AS MemberId,IFNULL(r.return_dt,'') AS ReturnDate 
FROM book_issue i join book_return r 
WHERE i.accession_no = r.accession_no AND i.member_id = r.member_id ;




