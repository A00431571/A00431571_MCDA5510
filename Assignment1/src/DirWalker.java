import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirWalker {
static int skippedrowstotal=0;
    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();
	    System.setProperty("java.util.logging.config.file",
	              "./logging.properties");

        if (list == null) return;
        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
 //               System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                SimpleCsvParser x = new SimpleCsvParser();
                skippedrowstotal+=x.appendcsv(f.getAbsoluteFile());
      		  Logger.getLogger("Main").log(Level.INFO,"Skipped row in the file "+f.getAbsolutePath());

 //           	System.out.println( "File:" + f.getAbsoluteFile() );
            }
        }
    }

    public static void main(String[] args) {
    	DirWalker fw = new DirWalker();
    	File result = new File("/Users/dearbharat/Documents/A00431571_MCDA5510/Assignment1/Output/output.csv");
    	result.delete();
    	Writer out;
		try {
			out = new FileWriter("/Users/dearbharat/Documents/A00431571_MCDA5510/Assignment1/Output/output.csv", true);
			out.write("First Name, Last Name, Street Number, Street, City, Province, Pin Code, "
					+ "Country, Telephone Number, Email, Date\n");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final long startTime = System.currentTimeMillis();
    	fw.walk("/Users/dearbharat/Documents/A00431571_MCDA5510/Assignment1/Data/" );
		final long endTime = System.currentTimeMillis();
		System.out.println("Skipped Rows: " +skippedrowstotal);
		System.out.println("Total execution time: " + (endTime - startTime) +" ms");

    }

}
