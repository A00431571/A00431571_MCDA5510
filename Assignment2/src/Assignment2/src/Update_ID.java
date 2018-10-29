import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Update_ID {

	public boolean update_ex(String uniqueID, String token, Logger logger) {
		TransactionData updateUser = new TransactionData();
		TransactionData getUserModify = new TransactionData();
		SQLAccess getForUpdate = new SQLAccess();

		int id;
		Check_Input check_i = new Check_Input();
		String NameOnCard;
		String CardNumber;
		float UnitPrice;
		int Quantity;
		float TotalPrice;
		String ExpDate;
		String CreatedON = "NOW()";
		String CreatedBY = token;
		String cc_type = null;
		String temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID");
		temp = sc.next();
		id = check_i.check_int(temp, 1, 1);

		getUserModify = getForUpdate.getForUpdate(id);

		//

		id = Integer.parseInt(getUserModify.getID());
		NameOnCard = getUserModify.getNameOnCard();
		CardNumber = getUserModify.getCardNumber();
		UnitPrice = Float.parseFloat(getUserModify.getUnitPrice());
		Quantity = Integer.parseInt(getUserModify.getQantity());
		TotalPrice = Float.parseFloat(getUserModify.getTotaltPrice());
		ExpDate = getUserModify.getExpDate();
		cc_type = getUserModify.getCreditCard();
		logger.log(Level.FINE, "Inserted Object");
		char a;

		System.out.println("Want to update Name On Card?" + NameOnCard + "\n");
		a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y')
			NameOnCard = check_i.check_string(sc.next());
		System.out.println("Want to update Card Number?" + CardNumber + "\n");
		a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y') {
			CardNumber = sc.next();
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

		}
		System.out.println("Want to update Unit Price?" + UnitPrice + "\n");
		a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y') {
			temp = sc.next();
			UnitPrice = check_i.check_float(temp);
		}

		System.out.println("Want to update Quantity?" + Quantity + "\n");
		a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y') {
			temp = sc.next();
			Quantity = check_i.check_int(temp);
		}

		System.out.println("Want to update Expiry Date?" + ExpDate + "\n");
		a = sc.next().charAt(0);
		if (a == 'y' || a == 'Y')
			ExpDate = check_i.check_exp_date(sc.next());

		TotalPrice = Quantity * UnitPrice;

		updateUser.setID(Integer.toString(id));
		updateUser.setNameOnCard(NameOnCard);
		updateUser.setCardNumber(CardNumber);
		updateUser.setUnitPrice(Float.toString(UnitPrice));
		updateUser.setQantity(Integer.toString(Quantity));
		updateUser.setTotaltPrice(Float.toString(TotalPrice));
		updateUser.setExpDate(ExpDate);
		updateUser.setCreatedBy(CreatedBY);
		updateUser.setCreatedON(CreatedON);
		updateUser.setCreditCard(cc_type);
		logger.log(Level.FINE, "Values updated in Transaction Object");
		logger.log(Level.FINE, "Callign Query to update");
		return getForUpdate.update_ID(updateUser);
	}
}