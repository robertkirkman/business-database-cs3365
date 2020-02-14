/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Customer Table Class for Small Business Database
 */
import java.util.Arrays;
import java.util.ArrayList;

public class CustomerTable
{
	// Pre-chosen table fields using dynamically allocated arrays
	private ArrayList<String> CustomerName = new ArrayList<String>();
	private ArrayList<String> CustomerAddress = new ArrayList<String>();
	private ArrayList<String> CustomerWorkPhone = new ArrayList<String>();
	private ArrayList<String> CustomerCellPhone = new ArrayList<String>();
	
	//Concatenate customer information into a readable string for display
	private String GetCustomerInfo(int FieldIndex)
	{
		return "Name: " + CustomerName.get(FieldIndex) + ". Address: " + CustomerAddress.get(FieldIndex)
		+ ". Work Phone: " + CustomerWorkPhone.get(FieldIndex) + ". Cell Phone: " 
		+ CustomerCellPhone.get(FieldIndex) + ".";
	}
	
	//Query method
	public String QueryTableField(String FieldName, String QueryString)
	{
		int FieldIndex;
		//use indexOf to search corresponding ArrayList for desired information
		switch(FieldName)
		{
			case "Name":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Name entry not found.";
				}
			case "Address":
				{
					if ((FieldIndex = CustomerAddress.indexOf(QueryString)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Address entry not found.";
				}
			case "Work Phone":
				{
					if ((FieldIndex = CustomerWorkPhone.indexOf(QueryString)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Work phone entry not found.";
				}
			case "Cell Phone":
				{
					if ((FieldIndex = CustomerCellPhone.indexOf(QueryString)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Cell phone entry not found.";
				}
			default:
				return "Fieldname not found.";
		}
			
	}
	
	//Modify method for existing entries
	public String ModifyTableField(String FieldName, String QueryString, String EntryString)
	{
		int FieldIndex;
		switch(FieldName)
		{
			case "Name":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
					{
						CustomerName.set(FieldIndex, EntryString);
						return "Entry modified.";
					}
					else return "Entry not found.";
				}
			case "Address":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
					{
						CustomerName.set(FieldIndex, EntryString);
						return "Entry modified.";
					}
					else return "Entry not found.";
				}
			case "Work Phone":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
					{
						CustomerName.set(FieldIndex, EntryString);
						return "Entry modified.";
					}
					else return "Entry not found.";
				}
			case "Cell Phone":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
					{
						CustomerName.set(FieldIndex, EntryString);
						return "Entry modified.";
					}
					else return "Entry not found.";
				}
			default:
				return "Fieldname not found.";
		}
	}
	
	//Creation method for new entries
	public String ExpandTableField(String FieldName, String EntryString)
	{
		
	}
	
	//Deleting entries
	private void DeleteFieldEntry(String FieldName, String QueryString)
}
