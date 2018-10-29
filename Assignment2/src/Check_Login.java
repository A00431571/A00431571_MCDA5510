import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Check_Login {
	public static String login(String u_name, String passwd) {
		String user = u_name;
		String pass = passwd;
		String user_name = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guna_smu?useSSL=false", "root",
					"admin");

			Statement stmt = con.createStatement();

			ResultSet results = stmt
					.executeQuery("select username,password from user_login where username='" + user + "'");

			if (results.next()) {
				if (pass.equals(results.getString("password").toString())) {
					user_name = System.getProperty("user.name");
				} else {
					System.out.println("Password Incorrect");
				}
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user_name;

	}
}
