import java.io.*;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SimpleCsvParser {

	public static int appendcsv(File filename) {

		Reader in;
		Writer out;
		int skippedrows = 0;
		try {
			in = new FileReader(filename);
			out = new FileWriter("/Users/dearbharat/Documents/A00431571_MCDA5510/Assignment1/Output/output.csv", true);
			
//			System.out.println(filename);
			String f = filename.toString();
			if(!f.endsWith(".DS_Store")){
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
				if(record.size() == 10) {
				String fname = record.get(0);
			    String lname = record.get(1);
			    String streetn = record.get(2);
			    String street = record.get(3);
			    String city = record.get(4);
			    String province = record.get(5);
			    String pcode = record.get(6);
			    String country = record.get(7);
			    String tel = record.get(8);
			    String email = record.get(9);
			    String[] dt = f.split("\\/");
			    String date =dt[7]+"/"+dt[8]+"/"+dt[9];
//			    System.out.println(date);
			    if(record.getRecordNumber()==1) {
			    continue;
			    }
			    if(fname.isEmpty() || lname.isEmpty() || streetn.isEmpty() || street.isEmpty() || 
						city.isEmpty() || province.isEmpty() || pcode.isEmpty() ||
						country.isEmpty() || tel.isEmpty() || email.isEmpty()) 
			    {
			    	skippedrows++;
			    	continue;
			    }
//			    System.out.println(record);
			    out.write(fname+", "+lname+", "+streetn+", "+street+", "
			    		+city+", "+province+", "+pcode+", "
			    		+country+", "+tel+", "+email+", "+date+"\n");
			    
			}
			
			}
			
			out.close();
			
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}

		return skippedrows;
		
	}

}
