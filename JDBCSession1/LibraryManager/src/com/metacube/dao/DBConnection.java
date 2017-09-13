package com.metacube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	Connection con;
	PreparedStatement stmt;

	/**
	 * load driver class
	 * 
	 * @throws SQLException
	 */
	public DBConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Constants.mysqlURL,
					Constants.userId, Constants.password);
		} catch (ClassNotFoundException exc) {
			System.out.println("Error loading driver " + exc);
		}

	}

	/**
	 * close the connection
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		con.close();
	}

}
