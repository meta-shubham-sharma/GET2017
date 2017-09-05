USE LIS;

SELECT mb.member_nm as MemberName, i.issue_dt as IssueDate,i.accession_no as AccessionNo,i.member_id as MemberId,IFNULL(r.return_dt,'') as ReturnDate 
FROM book_issue i JOIN book_return r , members mb
WHERE i.accession_no = r.accession_no AND i.member_id = r.member_id AND i.member_id = mb.member_id
ORDER BY i.issue_dt , mb.member_nm ;
