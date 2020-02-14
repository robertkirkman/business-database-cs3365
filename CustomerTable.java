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
	
	//Query method
	public String QueryTableField(String FieldName, String QueryString)
	{
		int FieldIndex;
		if (FieldName == "Name")
			if ((FieldIndex = CustomerName.indexOf(QueryString)) != -1)
				return CustomerName.get(FieldIndex);
			else return "Entry not found.";
		else return "Fieldname not found.";
			
	}
	
	//Modify method for existing entries
	public String ModifyTableField(String FieldName, String QueryString, String EntryString)
	{
		
	}
	
	//Modify method for new entries
	private String ModifyTableField(String FieldName, String EntryString)
	{
		
	}
	
	//Deleting entries
	private void DeleteFieldEntry(String FieldName, String QueryString)
}
