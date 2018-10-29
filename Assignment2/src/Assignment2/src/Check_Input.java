import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Check_Input {

	public String check_string(String check_string) {
		String a_string;
		a_string = check_string;
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (a_string.matches(";") || a_string.contains(":") || a_string.contains("!") || a_string.contains("@")
					|| a_string.contains("#") || a_string.contains("$") || a_string.contains("%")
					|| a_string.contains("^") || a_string.contains("*") || a_string.contains("+")
					|| a_string.contains("?") || a_string.contains("<") || a_string.contains(">")
					|| a_string.contains(",")) {
				System.out.println("Invalid Input! Enter valid Input!!");
				a_string = sc.next();
			} else
				break;
		}
		// sc.close();
		return a_string;
	}

	public Float check_float(String check_string) {
		String a_string;
		Scanner sc = new Scanner(System.in);
		a_string = check_string;
		Float out;
		while (true) {
			if (!a_string.matches("[a-zA-Z]+") && a_string.matches("[0-9]+")) {
				out = Float.parseFloat(a_string);
				return out;
			} else {
				System.out.println("Invalid value!!Re-enter Input");
				a_string = sc.next();
			}
		}

	}

	public int check_int(String check_string) {
		String a_string;
		Scanner sc = new Scanner(System.in);
		a_string = check_string;
		int out;
		while (true) {
			if (!a_string.matches("[a-zA-Z]+") && a_string.matches("[0-9]+")) {
				out = Integer.parseInt(a_string);
				return out;
			} else {
				System.out.println("Invalid value!!Re-enter Input");
				a_string = sc.next();
			}
		}

	}

	public String check_exp_date(String check_string) {
		String a_string;
		Scanner sc = new Scanner(System.in);
		a_string = check_string;
		String out;
		while (true) {
			String temp[] = a_string.split("/");
			if (temp[0].length() == 2 && temp[1].length() == 4 && !temp[0].matches("[a-zA-Z]+")
					&& temp[0].matches("[0-9]+") && !temp[1].matches("[a-zA-Z]+") && temp[1].matches("[0-9]+")
					&& Integer.parseInt(temp[0]) < 13 && Integer.parseInt(temp[0]) > 0
					&& Integer.parseInt(temp[1]) > 2015 && Integer.parseInt(temp[1]) < 2032) {
				return a_string;
			} else {
				System.out.println("Invalid Input! Enter correct format");
				a_string = sc.next();
			}
		}

	}

	public int check_int(String check_string, int a) {
		String a_string;
		Scanner sc = new Scanner(System.in);
		a_string = check_string;
		int out;
		while (true) {

			if (!a_string.matches("[a-zA-Z]+") && a_string.matches("[0-9]+")) {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",
							"gudu1212");
					Statement stmt = con.createStatement();
					ResultSet results = stmt.executeQuery("select * from transaction where id='" + a_string + "'");

					if (!results.next()) {
						out = Integer.parseInt(a_string);
						return out;
					} else {
						System.out.println("ID Already Taken!!! Try other!!!!");
						a_string = sc.next();
						continue;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				System.out.println("Invalid value!!Re-enter Input");
				a_string = sc.next();
				continue;
			}

		}

	}

	public int check_int(String check_string, int a, int b) {
		String a_string;
		Scanner sc = new Scanner(System.in);
		a_string = check_string;
		int out;
		while (true) {

			if (!a_string.matches("[a-zA-Z]+") && a_string.matches("[0-9]+")) {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b_bharat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",
							"gudu1212");
					Statement stmt = con.createStatement();
					ResultSet results = stmt.executeQuery("select * from transaction where id='" + a_string + "'");

					if (results.next()) {
						out = Integer.parseInt(a_string);
						return out;
					} else {
						System.out.println("ID Not Present!!! Try other!!!!");
						a_string = sc.next();
						continue;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				System.out.println("Invalid value!!Re-enter Input");
				a_string = sc.next();
				continue;
			}

		}

	}

}
