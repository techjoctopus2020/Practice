package com.joctopus.Factory.LoadFactory;

import java.sql.Connection;

import com.joctopus.Factory.FactoryImpl.MySqlImpl;
import com.joctopus.Factory.FactoryImpl.OracleImpl;
import com.joctopus.Factory.FactoryImpl.SqlServerImpl;

public class ConnectionFactory {

	public Connection provideCon(String conType) {

		if (conType != null && conType.equalsIgnoreCase("MySql")) {

			return new MySqlImpl().getConnection();
		} else if (conType != null && conType.equalsIgnoreCase("oracle")) {

			return new OracleImpl().getConnection();
		} else if (conType != null && conType.equalsIgnoreCase("SqlServer")) {

			return new SqlServerImpl().getConnection();
		} else {

			return null;
		}
	}
}
