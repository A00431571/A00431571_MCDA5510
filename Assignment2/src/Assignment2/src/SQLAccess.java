
/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
 **/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class SQLAccess {

	public Collection<TransactionData> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<TransactionData> results = new ArrayList<TransactionData>();

		while (resultSet.next()) {
			TransactionData trxn = new TransactionData();
			trxn.setID(resultSet.getString(1));
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			trxn.setUnitPrice(resultSet.getString("UnitPrice"));
			trxn.setQantity(resultSet.getString("Quantity"));
			trxn.setTotaltPrice(resultSet.getString("TotalPrice"));
			trxn.setExpDate(resultSet.getString("ExpDate"));
			trxn.setCreatedON(resultSet.getString("CreatedON"));
			trxn.setCreatedBy(resultSet.getString("CreatedBY"));
			trxn.setCreditCard(resultSet.getString("transactionid"));
			results.add(trxn);
		}
		return results;
	}

	public boolean insert_ID(TransactionData insert) {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "gudu1212");
			Statement stmt = con.createStatement();

			//				System.out.println("INSERT INTO transaction " + "VALUES ("+id+", '"+NameOnCard+"', "
			//						+ "'"+CardNumber+"', "+UnitPrice+", "+Quantity+","+TotalPrice+",'"
			//								+ExpDate+"',"+CreatedON+", '"+CreatedBY+"','"+transactionid+"' )");
			ResultSet results = stmt.executeQuery("select * from transaction where id='" + insert.getID() + "'");

			if (!results.next()) {

				stmt.executeUpdate("INSERT INTO transaction " + "VALUES (" + insert.getID() + ", '"
						+ insert.getNameOnCard() + "', " + "'" + insert.getCardNumber() + "', " + insert.getUnitPrice()
						+ ", " + insert.getQantity() + "," + insert.getTotaltPrice() + ",'" + insert.getExpDate() + "',"
						+ insert.getCreatedON() + ", '" + insert.getCreatedBy() + "','" + insert.getCreditCard()
						+ "' )");
				con.close();
				return true;
			} else {
				System.out.println("ID already exists\nUse Update!!!");
				con.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public TransactionData getForUpdate(int id) {
		Connection con;
		TransactionData getValues = new TransactionData();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "gudu1212");
			Statement stmt = con.createStatement();
			String tempID = Integer.toString(id);
			ResultSet resultSet = stmt.executeQuery("select * from transaction where id='" + tempID + "'");
			if (resultSet.next()) {
				getValues.setID(resultSet.getString(1));
				getValues.setNameOnCard(resultSet.getString("NameOnCard"));
				getValues.setCardNumber(resultSet.getString("CardNumber"));
				getValues.setUnitPrice(resultSet.getString("UnitPrice"));
				getValues.setQantity(resultSet.getString("Quantity"));
				getValues.setTotaltPrice(resultSet.getString("TotalPrice"));
				getValues.setExpDate(resultSet.getString("ExpDate"));
				getValues.setCreatedON(resultSet.getString("CreatedON"));
				getValues.setCreatedBy(resultSet.getString("CreatedBY"));
				getValues.setCreditCard(resultSet.getString("transactionid"));
			}
			return getValues;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getValues;
	}

	public boolean update_ID(TransactionData insert) {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "gudu1212");
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE transaction SET NameOnCard='" + insert.getNameOnCard() + "',CardNumber='"
					+ insert.getCardNumber() + "',UnitPrice=" + insert.getUnitPrice() + ",Quantity="
					+ insert.getQantity() + ",TotalPrice=" + insert.getTotaltPrice() + ",ExpDate='"
					+ insert.getExpDate() + "',CreatedON=" + insert.getCreatedON() + ",CreatedBY='"
					+ insert.getCreatedBy() + "',transactionid='" + insert.getCreditCard() + "' WHERE id = "
					+ insert.getID() + "");
			con.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
