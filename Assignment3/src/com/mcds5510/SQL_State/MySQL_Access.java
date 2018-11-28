package com.mcds5510.SQL_State;
import java.sql.*;

import com.mcds5510.connection.Connection_SQL;
import com.mcds5510.transaction.*;

public class MySQL_Access {
	
	private static MySQL_Access mysql=new MySQL_Access();
	private MySQL_Access()
	{
		
	}
	
	public static MySQL_Access getObject()
	{
		return mysql;
	}
	
	public boolean insertToDatabase(Transaction_Data trans_Data) 
	{
		Connection_SQL myCon=Connection_SQL.getObject();
		Connection my_Connection=myCon.getConnection();
		try {
			Statement stmt=my_Connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from Transaction where id='" + trans_Data.getID() + "'");
			if (!results.next()) {

				stmt.executeUpdate("INSERT INTO Transaction " + "VALUES (" + trans_Data.getID() + ", '"
						+ trans_Data.getNameOnCard() + "', " + "'" + trans_Data.getCardNumber() + "', " + trans_Data.getUnitPrice()
						+ ", " + trans_Data.getQantity() + "," + trans_Data.getTotaltPrice() + ",'" + trans_Data.getExpDate() + "',"
						+ trans_Data.getCreatedON() + ", '" + trans_Data.getCreatedBy() + "','" + trans_Data.getCreditCard()
						+ "' )");
				my_Connection.close();
				return true;
			} else {
				System.out.println("ID already exists\nUse Update!!!");
				my_Connection.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateToDatabase(Transaction_Data trans_Data) 
	{
		Connection_SQL myCon=Connection_SQL.getObject();
		Connection my_Connection=myCon.getConnection();
		try {
			Statement stmt=my_Connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from Transaction where id='" + trans_Data.getID() + "'");
			if (results.next()) {

				stmt.executeUpdate("UPDATE Transaction SET NameOnCard='" + trans_Data.getNameOnCard() + "',CardNumber='"
						+ trans_Data.getCardNumber() + "',UnitPrice=" + trans_Data.getUnitPrice() + ",Quantity="
						+ trans_Data.getQantity() + ",TotalPrice=" + trans_Data.getTotaltPrice() + ",ExpDate='"
						+ trans_Data.getExpDate() + "',CreatedOn=" + trans_Data.getCreatedON() + ",CreatedBy='"
						+ trans_Data.getCreatedBy() + "',transactionid='" + trans_Data.getCreditCard() + "' WHERE id = "
						+ trans_Data.getID() + "");
				my_Connection.close();
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean removeFromDatabase(Transaction_Data trans_Delete) 
	{
		Connection_SQL myCon=Connection_SQL.getObject();
		Connection my_Connection=myCon.getConnection();
		try {
			Statement stmt=my_Connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from Transaction where id='" + trans_Delete.getID() + "'");
			if (results.next()) {

				stmt.executeUpdate("DELETE FROM Transaction WHERE id =" + trans_Delete.getID());
				my_Connection.close();
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Transaction_Data viewFromDatabase(Transaction_Data trans_View) 
	{
		Connection_SQL myCon=Connection_SQL.getObject();
		Connection my_Connection=myCon.getConnection();
		Transaction_Data trans_Display=new Transaction_Data();
		
		try {
			Statement stmt=my_Connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from Transaction where id='" + trans_View.getID() + "'");
			if (results.next()) {

				trans_Display.setID(results.getString(1));
				trans_Display.setNameOnCard(results.getString("NameOnCard"));
				trans_Display.setCardNumber(results.getString("CardNumber"));
				trans_Display.setUnitPrice(results.getString("UnitPrice"));
				trans_Display.setQantity(results.getString("Quantity"));
				trans_Display.setTotaltPrice(results.getString("TotalPrice"));
				trans_Display.setExpDate(results.getString("ExpDate"));
				trans_Display.setCreatedON(results.getString("CreatedOn"));
				trans_Display.setCreatedBy(results.getString("CreatedBy"));
				trans_Display.setCreditCard(results.getString("transactionid"));
				
				my_Connection.close();
				return trans_Display;
			} else {
				return trans_Display;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans_Display;
	}
}
