
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Create_ID {
	public boolean create_New(String token, Logger logger) {

		TransactionData trxn_Create = new TransactionData();
		SQLAccess create_Query = new SQLAccess();
		int id;
		String NameOnCard;
		String CardNumber;
		float UnitPrice;
		int Quantity;
		float TotalPrice;
		String ExpDate;
		String CreatedON = "NOW()";
		String CreatedBY = token;
		String cc_type;
		String temp;
		Check_Input check_i = new Check_Input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID");

		temp = sc.next();
		id = check_i.check_int(temp, 1);

		System.out.println("Enter the Name of Card Holder");
		NameOnCard = check_i.check_string(sc.next());

		System.out.println("Enter Card Number");
		CardNumber = check_i.check_string(sc.next());
		while (true) {
			if (CardNumber.length() == 16 && (CardNumber.startsWith("51") || CardNumber.startsWith("52")
					|| CardNumber.startsWith("53") || CardNumber.startsWith("54") || CardNumber.startsWith("55"))) {
				cc_type = "Master Card";
				break;
			} else if (CardNumber.length() == 16 && (CardNumber.startsWith("4"))) {
				cc_type = "VISA Card";
				break;
			} else if (CardNumber.length() == 15 && (CardNumber.startsWith("34") || CardNumber.startsWith("37"))) {
				cc_type = "AMEX";
				break;
			} else {

				System.out.println("Enter Valid Card number");
				CardNumber = check_i.check_string(sc.next());
			}
		}
		// System.out.println(cc_type);
		System.out.println("Enter Unit Price");
		temp = sc.next();
		UnitPrice = check_i.check_float(temp);
		System.out.println("Enter Quantity");
		temp = sc.next();
		Quantity = check_i.check_int(temp);

		TotalPrice = UnitPrice * Quantity;

		System.out.println("Enter Expiry Date");

		ExpDate = check_i.check_exp_date(sc.next());

		trxn_Create.setID(Integer.toString(id));
		trxn_Create.setNameOnCard(NameOnCard);
		trxn_Create.setCardNumber(CardNumber);
		trxn_Create.setUnitPrice(Float.toString(UnitPrice));
		trxn_Create.setQantity(Integer.toString(Quantity));
		trxn_Create.setTotaltPrice(Float.toString(TotalPrice));
		trxn_Create.setExpDate(ExpDate);
		trxn_Create.setCreatedON(CreatedON);
		trxn_Create.setCreatedBy(CreatedBY);
		trxn_Create.setCreditCard(cc_type);
		logger.log(Level.FINE, "Values in Object");
		logger.log(Level.FINE, "Calling DB Query to Insert");
		return create_Query.insert_ID(trxn_Create);

	}

}
