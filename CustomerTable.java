/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Customer Table Class for Small Business Database
 */

package smallbusinessdb;

import java.util.ArrayList;

public class CustomerTable extends Table
{
	// Pre-chosen table fields using dynamically allocated arrays
	private ArrayList<String> CustomerName = new ArrayList<String>();
	private ArrayList<String> CustomerAddress = new ArrayList<String>();
	private ArrayList<String> CustomerWorkPhone = new ArrayList<String>();
	private ArrayList<String> CustomerCellPhone = new ArrayList<String>();
	public static String FieldNames = "Name | Address | Work Phone | Cell Phone";
	
	//Constructor
	public CustomerTable()
	{
		this.CustomerName.add("None");
		this.CustomerAddress.add("None");
		this.CustomerWorkPhone.add("None");
		this.CustomerCellPhone.add("None");
	}
	
	//Concatenate customer information into a readable string for display
	private String GetCustomerInfo(int FieldIndex)
	{
		return "Name: " + CustomerName.get(FieldIndex) + ". Address: " + CustomerAddress.get(FieldIndex)
		+ ". Work Phone: " + CustomerWorkPhone.get(FieldIndex) + ". Cell Phone: " 
		+ CustomerCellPhone.get(FieldIndex) + ".";
	}
	
	//Query method
	@Override
	public String QueryTableField(String FieldName, String QueryStr)
	{
		//use indexOf to search corresponding ArrayList for desired information
		switch(FieldName)
		{
			case "Name":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryStr)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Name entry not found.";
				}
			case "Address":
				{
					if ((FieldIndex = CustomerAddress.indexOf(QueryStr)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Address entry not found.";
				}
			case "Work Phone":
				{
					if ((FieldIndex = CustomerWorkPhone.indexOf(QueryStr)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Work phone entry not found.";
				}
			case "Cell Phone":
				{
					if ((FieldIndex = CustomerCellPhone.indexOf(QueryStr)) != -1)
						return GetCustomerInfo(FieldIndex);
					else return "Cell phone entry not found.";
				}
			default:
				return "Fieldname not found.";
		}
			
	}
	
	//Modify method for existing entries
	@Override
	public String ModifyTableField(String FieldName, String QueryStr, String EntryStr)
	{
		//use indexOf to search corresponding ArrayList for desired information
		switch(FieldName)
		{
			//replace contents of specified entry with the desired new information
			case "Name":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryStr)) != -1)
					{
						CustomerName.set(FieldIndex, EntryStr);
						return "Name entry modified.";
					}
					else return "Name entry not found.";
				}
			case "Address":
				{
					if ((FieldIndex = CustomerAddress.indexOf(QueryStr)) != -1)
					{
						CustomerAddress.set(FieldIndex, EntryStr);
						return "Address entry modified.";
					}
					else return "Address entry not found.";
				}
			case "Work Phone":
				{
					if ((FieldIndex = CustomerWorkPhone.indexOf(QueryStr)) != -1)
					{
						CustomerWorkPhone.set(FieldIndex, EntryStr);
						return "Work phone entry modified.";
					}
					else return "Work phone entry not found.";
				}
			case "Cell Phone":
				{
					if ((FieldIndex = CustomerCellPhone.indexOf(QueryStr)) != -1)
					{
						CustomerCellPhone.set(FieldIndex, EntryStr);
						return "Cell phone entry modified.";
					}
					else return "Cell phone entry not found.";
				}
			default:
				return "Fieldname not found.";
		}
	}
	
	//Creation method for new entries
	@Override
	public String ExpandTableField(String FieldName, String EntryStr, String IndexStr)
	{
		//attempt to convert IndexStr to an integer for use in indexing the table
		try
		{
			FieldIndex = Integer.parseInt(IndexStr);
		}
		catch (NumberFormatException error)
		{
			return "Invalid insertion index: " + error.getMessage();
		}
		if ((FieldIndex < 0) || (FieldIndex >= CustomerName.size()))
			return "Invalid insertion index: out of range";
		//use switch statement to match input with field name
		switch(FieldName)
		{
			//push new entries into the ArrayLists with the selected field containing the desired new information
			case "Name":
				{
					CustomerName.add(FieldIndex, EntryStr);
					CustomerAddress.add(FieldIndex, "None");
					CustomerCellPhone.add(FieldIndex, "None");
					CustomerWorkPhone.add(FieldIndex, "None");
					return "Name entry created with other fields blank.";
				}
			case "Address":
				{
					CustomerName.add(FieldIndex, "None");
					CustomerAddress.add(FieldIndex, EntryStr);
					CustomerCellPhone.add(FieldIndex, "None");
					CustomerWorkPhone.add(FieldIndex, "None");
					return "Address entry created with other fields blank.";
				}
			case "Work Phone":
				{
					CustomerName.add(FieldIndex, "None");
					CustomerAddress.add(FieldIndex, "None");
					CustomerCellPhone.add(FieldIndex, "None");
					CustomerWorkPhone.add(FieldIndex, EntryStr);
					return "Work phone entry created with other fields blank.";
				}
			case "Cell Phone":
				{
					CustomerName.add(FieldIndex, "None");
					CustomerAddress.add(FieldIndex, "None");
					CustomerCellPhone.add(FieldIndex, EntryStr);
					CustomerWorkPhone.add(FieldIndex, "None");
					return "Cell phone entry created with other fields blank.";
				}
			default:
				return "Fieldname not found.";
		}
	}
	
	//Deleting entries
	@Override
	public String DeleteFieldEntry(String FieldName, String QueryStr)
	{
		//use indexOf to search corresponding ArrayList for desired information
		switch(FieldName)
		{
			//delete contents of specified entry and corresponding fields
			case "Name":
				{
					if ((FieldIndex = CustomerName.indexOf(QueryStr)) != -1)
					{
						CustomerName.remove(FieldIndex);
						CustomerAddress.remove(FieldIndex);
						CustomerWorkPhone.remove(FieldIndex);
						CustomerCellPhone.remove(FieldIndex);
						return "Name entry and other fields deleted.";
					}
					else return "Name entry not found.";
				}
			case "Address":
				{
					if ((FieldIndex = CustomerAddress.indexOf(QueryStr)) != -1)
					{
						CustomerName.remove(FieldIndex);
						CustomerAddress.remove(FieldIndex);
						CustomerWorkPhone.remove(FieldIndex);
						CustomerCellPhone.remove(FieldIndex);
						return "Address entry and other fields deleted.";
					}
					else return "Address entry not found.";
				}
			case "Work Phone":
				{
					if ((FieldIndex = CustomerWorkPhone.indexOf(QueryStr)) != -1)
					{
						CustomerName.remove(FieldIndex);
						CustomerAddress.remove(FieldIndex);
						CustomerWorkPhone.remove(FieldIndex);
						CustomerCellPhone.remove(FieldIndex);
						return "Work phone entry and other fields deleted.";
					}
					else return "Work phone entry not found.";
				}
			case "Cell Phone":
				{
					if ((FieldIndex = CustomerCellPhone.indexOf(QueryStr)) != -1)
					{
						CustomerName.remove(FieldIndex);
						CustomerAddress.remove(FieldIndex);
						CustomerWorkPhone.remove(FieldIndex);
						CustomerCellPhone.remove(FieldIndex);
						return "Cell phone entry and other fields deleted.";
					}
					else return "Cell phone entry not found.";
				}
			default:
				return "Fieldname not found.";
		}
	}
}