import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class View_ID {
	public Collection<TransactionData> view_details(int id) {
		int u_id = id;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "gudu1212");
			Statement stmt = con.createStatement();
			Collection<TransactionData> resultSet = null;
			ResultSet results = stmt.executeQuery("select * from transaction where id='" + u_id + "'");
			SQLAccess viewDataSQL = new SQLAccess();
			resultSet = viewDataSQL.createTrxns(results);
			for (TransactionData trxn : resultSet) {
				System.out.println(trxn.toString());
			}

			return resultSet;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}