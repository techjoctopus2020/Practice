package com.joctopus.Factory.FactoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;

import com.joctopus.Factory.MyConnection;

public class SqlServerImpl implements MyConnection {

	Connection con = null;

	@Override
	public Connection getConnection() {

		// load the driver

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibpra", "root", "admin");
		} catch (Exception e) {

			System.out.println("Exception :" + e.getMessage());
		}

		return con;
	}

}
