package com.mcds5510.webservice;

import com.mcds5510.SQL_State.MySQL_Access;
import com.mcds5510.transaction.Transaction_Data;
//import com.mcds5510.business.Validation_Data;;
public class Transaction_Call {
	
public String create_Transaction(String id, String nameOnCard, String cardNumber,String unitPrice, 
		String quantity, String expDate) 
{
//	Validation_Data check_input=new Validation_Data();
	Transaction_Data trans_Insert=new Transaction_Data();
	MySQL_Access insert=MySQL_Access.getObject();
	
	String createdON = "NOW()";
	String createdBy = System.getProperty("user.name");
	
	trans_Insert.setID(id);
	trans_Insert.setNameOnCard(nameOnCard);
	trans_Insert.setCardNumber(cardNumber);
	trans_Insert.setUnitPrice(unitPrice);
	trans_Insert.setQantity(quantity);
	float totaltPrice=Float.parseFloat(unitPrice)*Float.parseFloat(quantity);
	trans_Insert.setTotaltPrice(String.valueOf(totaltPrice));
	trans_Insert.setExpDate(expDate);
	trans_Insert.setCreatedBy(createdBy);
	trans_Insert.setCreatedON(createdON);
	
	boolean result=insert.insertToDatabase(trans_Insert);
	if (result==true)
		return "ID is Inserted";
	else
		return "Error Occured";
	}


public String update_Transaction(String id, String nameOnCard, String cardNumber,String unitPrice, 
	String quantity, String expDate) 
{
//Validation_Data check_input=new Validation_Data();
Transaction_Data trans_Update=new Transaction_Data();
MySQL_Access update=MySQL_Access.getObject();

String createdON = "NOW()";
String createdBy = System.getProperty("user.name");
trans_Update.setID(id);
trans_Update.setNameOnCard(nameOnCard);
trans_Update.setCardNumber(cardNumber);
trans_Update.setUnitPrice(unitPrice);
trans_Update.setQantity(quantity); 
//float totaltPrice=Float.parseFloat(unitPrice)*Float.parseFloat(quantity);
//trans_Update.setTotaltPrice(String.valueOf(totaltPrice));
trans_Update.setExpDate(expDate);
trans_Update.setCreatedBy(createdBy);
trans_Update.setCreatedON(createdON);


boolean result=update.updateToDatabase(trans_Update);
if (result==true)
	return "ID is Updated";
else
	return "Error Occured";
}

public String delete_Transaction(String id) 
	{
	//Validation_Data check_input=new Validation_Data();
	Transaction_Data trans_Delete=new Transaction_Data();
	MySQL_Access delete=MySQL_Access.getObject();
	trans_Delete.setID(id);
	

	boolean result=delete.removeFromDatabase(trans_Delete);
	if (result==true)
		return "ID is Deleted";
	else
		return "ID Not Exists\nUse Create";
	}

public String view_Transaction(String id) 
{
//Validation_Data check_input=new Validation_Data();
Transaction_Data trans_View=new Transaction_Data();
MySQL_Access view=MySQL_Access.getObject();
trans_View.setID(id);


Transaction_Data result=view.viewFromDatabase(trans_View);
if (result!=null)
{
	return result.toString();
}
else
	return "ID Not Exists\nUse Create";
}

}
