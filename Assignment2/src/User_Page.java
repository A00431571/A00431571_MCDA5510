import java.util.*;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class User_Page {

	public static void main(String args[]) {
		Handler consoleHandler = null;
		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		Logger logger = Logger.getLogger("Main");
		
		//Log file Config
		consoleHandler = new ConsoleHandler();
		try {
			fileHandler = new FileHandler("./Logs/sampleLogfile.log", true);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assigning handlers to LOGGER object
		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);
		// Setting levels to handlers and LOGGER
		consoleHandler.setLevel(Level.ALL);
		fileHandler.setLevel(Level.FINE);
		logger.setLevel(Level.ALL);
		
		simpleFormatter = new SimpleFormatter();
	
		// Setting formatter to the handler
		fileHandler.setFormatter(simpleFormatter);

		logger.config("Configuration done.");
			// COnfig file ended

		Check_Input chk=new Check_Input();
		final long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		String u_name;
		String passwd;
		String u_token;
		boolean create;
		boolean update;
		System.out.println("Hello!!!...");

		while (true) {
			System.out.println("Enter username");
			u_name = chk.check_string(sc.next());
			System.out.println("Enter Password");
			passwd = chk.check_string(sc.next());
			int entry;
			u_token = Check_Login.login(u_name, passwd);
			logger.log(Level.FINE, "Credentials Entered for Login" );

			// System.out.println("User name is correct");
			// System.out.println(u_token);

			if (u_token != null) {
				
				while (true) {
					String uniqueID = UUID.randomUUID().toString();
					// System.out.println(uniqueID);
					System.out.println("Press 1 to Insert new record!!!");
					System.out.println("Press 2 to Update record!!!");
					System.out.println("Press 3 to View record!!!");
					System.out.println("Press 4 to Deletes new record!!!");
					System.out.println("Press 5 to exit transaction!!!");
					entry = chk.check_int(sc.next());
					if (entry == 5) {
						final long endTime = System.currentTimeMillis();
						System.out.println("Total Executed time"+(endTime-startTime));
						logger.log(Level.FINE, "Total Execution time "+(endTime-startTime));
						System.exit(0);
					}
					switch (entry) {
					case 1: {
						Create_ID c = new Create_ID();
						create = c.create_New(u_token, logger);
						// System.out.println(create);
						if (create) {
							logger.log(Level.FINE, "Inserted in DB");
							System.out.println("Succesfully Inserted");
						}
						break;
					}
					case 2: {
						Update_ID up = new Update_ID();
						update = up.update_ex(uniqueID, u_token, logger);
						// System.out.println(update);
						if (update) {
							logger.log(Level.FINE, "Updated in DB");
							System.out.println("Succesfully Updated");
						}
						break;

					}
					case 3: {
						View_ID view = new View_ID();
						System.out.println("Enter the ID to view");
						int a;
						a = chk.check_int(sc.next());
						// System.out.println(view);
						logger.log(Level.FINE, "Fetched from DB");
						view.view_details(a);
						break;
					}
					case 4: {
						Delete_ID del = new Delete_ID();
						System.out.println("Enter ID to delete");
						int id;
						id =  chk.check_int(sc.next());
						if (del.delete(id)) {
							logger.log(Level.FINE, "Deleted in DB");
							System.out.println("ID Deleted Successfully");
						}
						break;
					}
					}
				}
			}

			else {
				logger.log(Level.SEVERE, "Credentials Mismatch" );
				System.out.println("Press 1 to Try Again!!!");
				
				if ( chk.check_int(sc.next()) == 1)
					continue;
				else
					System.exit(0);
			}
		}
	}

}
