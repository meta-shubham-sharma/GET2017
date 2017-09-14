package com.metacube.testLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metacube.dao.DBHelper;
import com.metacube.model.Titles;

public class TestLibraryManager {

	static DBHelper object;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		object = new DBHelper();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		object.closeConnection();
	}

	@Test
	public void testBookDetails() {
		try {
			List<Titles> list = object.getBookDetailsByAuthor("Prakash");
			String actual = list.get(0).toString();
			String expected = "\nTitleId : 2	TitleName : HC Verma	PublisherId : 2";
			assertEquals(expected,actual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckBook() {
		try {
			int actual = object.checkBook("HC Verma");
			int expected = -1;
			assertEquals(expected,actual);
			actual = object.checkBook("HC Verma part2");
			expected = 0;
			assertEquals(expected,actual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteBooks() {
		try {
			int actual = object.deleteBooks();
			int expected = 0;
			assertEquals(expected,actual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
