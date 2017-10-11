package com.metacube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.model.Titles;

public class HelperDao extends DBConnection {
	public HelperDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * get details of title and wrap in pojo
	 * 
	 * @param authorName
	 * @return
	 * @throws SQLException
	 */
	public List<Titles> getBookDetails(String authorName) throws SQLException {
		String query = "select t.title_id,t.title_nm,t.publisher_id from authors a join title_author ta "
				+ "	on a.author_id = ta.author_id and a.author_nm = ? join titles t on t.title_id = ta.title_id";
		stmt = con.prepareStatement(query);
		stmt.setString(1, authorName);
		ResultSet rs = stmt.executeQuery();
		List<Titles> list = new ArrayList<Titles>();
		while (rs.next()) {
			Titles title = new Titles();
			title.setId(rs.getInt(1));
			title.setTitle(rs.getString(2));
			title.setPublisherId(rs.getInt(3));
			list.add(title);
		}
		return list;
	}

	/**
	 * 
	 * @param bookName
	 * @return
	 * @throws SQLException
	 */
	public int checkBook(String bookName) throws SQLException {
		// flag : -1 when book can not be issued
		int flag = -1;
		// check if book is present in library
		String query1 = "select b.accession_no from books b join titles t on b.title_id = t.title_id and title_nm = ?";
		stmt = con.prepareStatement(query1);
		stmt.setString(1, bookName);
		ResultSet rs = stmt.executeQuery();
		if (!rs.next()) {
			// flag : 0 when book is not in library
			flag = 0;
		} else {
			// count number of times book has been issued
			String query2 = "select count(accession_no) "
					+ "from book_issue "
					+ " where accession_no in (select b.accession_no from books b join titles t on b.title_id = t.title_id and title_nm = ?)";
			stmt = con.prepareStatement(query2);
			stmt.setString(1, bookName);
			rs = stmt.executeQuery();
			rs.absolute(1);
			int count1 = rs.getInt(1);
			// if book has not been issued ever it can be issued
			if (count1 == 0) {
				// flag : 1 when book can be issued
				flag = 1;
			} else {
				// count number of times book has been returned
				String query3 = "select count(1) "
						+ " from book_return r "
						+ " where return_dt is not null and accession_no in (select b.accession_no from books b join titles t on b.title_id = t.title_id and title_nm = ?)";
				stmt = con.prepareStatement(query3);
				stmt.setString(1, bookName);
				rs = stmt.executeQuery();
				rs.absolute(1);
				int count2 = rs.getInt(1);
				// if count of number of times issued and returned is same book
				// is available to be issued
				if (count1 == count2) {
					// flag : 1 when book can be issued
					flag = 1;
				}
			}
		}
		return flag;
	}

	public int deleteBooks() throws SQLException {
		// delete books not issued since last year
		String query = " delete from books where accession_no not in "
				+ "(select i.accession_no from book_issue i where"
				+ " datediff(now(),i.issue_dt)<=365)";
		stmt = con.prepareStatement(query);
		int rows = stmt.executeUpdate();
		return rows;
	}

}
