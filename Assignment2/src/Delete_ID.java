import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_ID {
	boolean delete(int id) {
		int a = id;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guna_smu", "root", "admin");
			Statement stmt = con.createStatement();

//			System.out.println("INSERT INTO transaction " + "VALUES ("+id+", '"+NameOnCard+"', "
//					+ "'"+CardNumber+"', "+UnitPrice+", "+Quantity+","+TotalPrice+",'"
//							+ExpDate+"',"+CreatedON+", '"+CreatedBY+"','"+transactionid+"' )");
			ResultSet results = stmt.executeQuery("select * from transaction where id='" + a + "'");

			if (results.next()) {
				stmt.executeUpdate("DELETE FROM transaction WHERE id =" + a);
				return true;
			} else {
				System.out.println("ID not Exists");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
