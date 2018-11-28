package com.mcds5510.connection;

import java.sql.*;


public class Connection_SQL {
	
	private static Connection_SQL my_Connect=new Connection_SQL();
	
	private Connection_SQL()
	{
		
	}
	
	public static Connection_SQL getObject()
	{
		return my_Connect;
	}
	
	public Connection getConnection()
	{
		Connection myCon=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/CREDITCARD", "root", "gudu1212");
			return myCon;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return myCon;
		
	}
}
