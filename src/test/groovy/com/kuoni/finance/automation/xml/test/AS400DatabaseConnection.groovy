package com.kuoni.finance.automation.xml.test

import java.sql.*;

public class AS400DatabaseConnection {
	
	private static Connection connection = null;
	
	private GetConnection()
	{
	}
	static Connection getAs400Connection() {
		try {
			if (connection == null) {
				Class.forName("com.ibm.as400.access.AS400JDBCDriver");
				connection = DriverManager.getConnection("jdbc:as400://londev;naming=sql;errors=full;prompt=false;libraries=RT012DTA;dateformat=iso;time format=iso", "webrev", "webrev");
			  }
			  return connection;		
		}catch(Exception exception) {
			exception.printStackTrace()
		} 
		return connection
	}
}

