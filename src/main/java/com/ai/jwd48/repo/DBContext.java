package com.ai.jwd48.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	private static final String URL = "jdbc:mysql://localhost:3306/School_Management_System";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection connection;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			if (connection == null) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} else {
				return connection;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		} catch (SQLException e) {
			System.out.println("Database Coonectin not found");
		}
		return connection;

	}

}
