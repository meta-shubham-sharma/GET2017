USE LIS;

/*Assignment 1.1 select details from members and issued books where book has been issued for more than 2 months*/
SELECT mb.member_nm,r.member_id,t.title_nm,r.accession_no,r.issue_dt,i.due_dt ,TIMESTAMPDIFF(MONTH,r.issue_dt,r.return_dt) AS Months
FROM book_issue i JOIN book_return r ON r.accession_no = i.accession_no AND r.member_id = i.member_id AND TIMESTAMPDIFF(MONTH,r.issue_dt,r.return_dt) >= 2,
books b JOIN titles t ON b.title_id = t.title_id, members mb  
WHERE r.member_id = mb.member_id AND r.accession_no = b.accession_no 
ORDER BY mb.member_nm, t.title_nm;   

/*Assignment 1.2 select details from members where name of member is longest*/
SELECT member_nm,LENGTH(member_nm) AS LengthOfName 
FROM members 
WHERE LENGTH(member_nm) = ( SELECT MAX( LENGTH(member_nm) ) FROM members);

/*Assignment 1.3 select count of total books issued*/
SELECT COUNT(issue_dt) 
FROM book_issue;





     