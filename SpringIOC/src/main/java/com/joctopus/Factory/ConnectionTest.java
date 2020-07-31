package com.joctopus.Factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.joctopus.Factory.LoadFactory.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) {

		ConnectionFactory cf = new ConnectionFactory();

		Connection con = null;

		try {

			con = cf.provideCon("nosql");

			System.out.println("Connection :" + con);

		} catch (Exception e) {

			System.out.println("Exceptioon:" + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
