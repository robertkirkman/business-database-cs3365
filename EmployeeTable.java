/*
 * Author ......: Connor Irvine
 * Course ......: CS 3365
 * Description..: Employee table class for small business database
 */

package smallbusinessdb;

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class EmployeeTable extends Table 
{
	// Pre-chosen table fields using dynamically allocated arrays
		private ArrayList<String> EmployeeName = new ArrayList<String>();
		private ArrayList<String> EmployeeAddress = new ArrayList<String>();
		private ArrayList<String> EmployeeWorkPhone = new ArrayList<String>();
		private ArrayList<String> EmployeeHomePhone = new ArrayList<String>();
		public static final String FieldNames = "Name | Address | Work Phone | Home Phone";
		
		//Concatenate order information into a readable string for display
		private String GetEmployeeInfo(int FieldIndex)
		{
			return  "\n Name: " + EmployeeName.get(FieldIndex) + 
					"\n Address: " + EmployeeAddress.get(FieldIndex) +
					"\n Work Phone: " + EmployeeWorkPhone.get(FieldIndex) +
					"\n Home Phone: " + EmployeeHomePhone.get(FieldIndex);
		}
		
		//Query method
		public String QueryTableField(String FieldName, String QueryString)
		{
			
			//use indexOf to search corresponding ArrayList for desired information
			switch(FieldName)
			{
				case "Name":
				{
					if((FieldIndex = EmployeeName.indexOf(QueryString)) != -1)
						return GetEmployeeInfo(FieldIndex);
					else return "\nEmployee name not found.";
				}
				case "Address":
				{
					if((FieldIndex = EmployeeAddress.indexOf(QueryString)) != -1)
						return GetEmployeeInfo(FieldIndex);
					else return "\nEmployee address not found.";
				}
				case "Work Phone":
				{
					if((FieldIndex = EmployeeWorkPhone.indexOf(QueryString)) != -1)
						return GetEmployeeInfo(FieldIndex);
					else return "\nEmployee work number not found.";
				}
				case "Home Phone":
				{
					if((FieldIndex = EmployeeHomePhone.indexOf(QueryString)) != -1)
						return GetEmployeeInfo(FieldIndex);
					else return "\nEmployee home number not found.";
				}
				default:
					return "\nFieldname not found.";
			}
		}
		
		//Modify method for existing entries
		public String ModifyTableField(String FieldName, String QueryString, String EntryString)
		{
			switch(FieldName)
			{
				case "Name":
				{
					if((FieldIndex = EmployeeName.indexOf(QueryString)) != -1)
					{
						EmployeeName.set(FieldIndex, EntryString);
						return "\nEmployee name modified.";
					} else return "\nEmployee name not found.";
				}
				case "Address":
				{
					if((FieldIndex = EmployeeAddress.indexOf(QueryString)) != -1)
					{
						EmployeeAddress.set(FieldIndex, EntryString);
						return "\nEmployee address modified.";
					} else return "\nEmployee address not found.";
				}
				case "Work Phone":
				{
					if((FieldIndex = EmployeeWorkPhone.indexOf(QueryString)) != -1)
					{
						EmployeeWorkPhone.set(FieldIndex, EntryString);
						return "\nEmployee work phone amount modified.";
					} else return "\nEmployee work phone amount not found.";
				}
				case "Home Phone":
				{
					if((FieldIndex = EmployeeHomePhone.indexOf(QueryString)) != -1)
					{
						EmployeeHomePhone.set(FieldIndex, EntryString);
						return "\nEmployee home phone modified.";
					} else return "\nEmployee home phone not found.";
				}
				default:
					return "\nFieldname not found.";
			}
		}
		
		public String ExpandTableField(String FieldName, String EntryStr, String IndexStr)
		{
			// attempt to convert IndexStr to an integer for use in indexing the table
			try
			{
				FieldIndex = Integer.parseInt(IndexStr);
			}
			catch (NumberFormatException error)
			{
				return "\nInvalid insertion index: " + error.getMessage();
			}
			if (FieldIndex < 0 || FieldIndex >= EmployeeName.size())
				return "\nInvalid insertion index: out of range";
			
			//use switch statement to match input with field name
			switch(FieldName)
			{
				case "Name":
				{
					EmployeeName.add(FieldIndex, EntryStr);
					EmployeeAddress.add(FieldIndex, "");
					EmployeeWorkPhone.add(FieldIndex, "");
					EmployeeHomePhone.add(FieldIndex, "");
					return "\nEmployee name entry created with other fields blank.";
				}
				case "Address":
				{
					EmployeeName.add(FieldIndex, "");
					EmployeeAddress.add(FieldIndex, EntryStr);
					EmployeeWorkPhone.add(FieldIndex, "");
					EmployeeHomePhone.add(FieldIndex, "");
					return "\nEmployee address created with other fields blank.";
				}
				case "Work Phone":
				{
					EmployeeName.add(FieldIndex, "");
					EmployeeAddress.add(FieldIndex, "");
					EmployeeWorkPhone.add(FieldIndex, EntryStr);
					EmployeeHomePhone.add(FieldIndex, "");
					return "\nEmployee work phone entry created with other fields blank.";
				}
				case "Home Phone":
				{
					EmployeeName.add(FieldIndex, "");
					EmployeeAddress.add(FieldIndex, "");
					EmployeeWorkPhone.add(FieldIndex, "");
					EmployeeHomePhone.add(FieldIndex, EntryStr);
					return "\nEmployee home phone created with other fields blank.";
				}
				default:
					return "Fieldname not found.";
			}
		}
		
		// Deleting entries
		public String DeleteFieldEntry(String FieldName, String QueryStr)
		{
			//use indexOf to search corresponding ArrayList for desired information
			switch(FieldName)
			{
				// delete contents of specified entry and corresponding fields
				case "Name":
				{
					if((FieldIndex = EmployeeName.indexOf(QueryStr)) != -1)
					{
						EmployeeName.remove(FieldIndex);
						EmployeeAddress.remove(FieldIndex);
						EmployeeWorkPhone.remove(FieldIndex);
						EmployeeHomePhone.remove(FieldIndex);
						return "\nEmployee name and other fields deleted.";
					}
					else return "\nEmployee name not found.";
				}
				case "Address":
				{
					if((FieldIndex = EmployeeAddress.indexOf(QueryStr)) != -1)
					{
						EmployeeName.remove(FieldIndex);
						EmployeeAddress.remove(FieldIndex);
						EmployeeWorkPhone.remove(FieldIndex);
						EmployeeHomePhone.remove(FieldIndex);
						return "\nEmployee address and other fields deleted.";
					}
					else return "\nEmployee address not found.";
				}
				case "Work Phone":
				{
					if((FieldIndex = EmployeeWorkPhone.indexOf(QueryStr)) != -1)
					{
						EmployeeName.remove(FieldIndex);
						EmployeeAddress.remove(FieldIndex);
						EmployeeWorkPhone.remove(FieldIndex);
						EmployeeHomePhone.remove(FieldIndex);
						return "\nEmployee work phone amount and other fields deleted.";
					}
					else return "\nEmployee work phone amount not found.";
				}
				case "Home Phone":
				{
					if((FieldIndex = EmployeeHomePhone.indexOf(QueryStr)) != -1)
					{
						EmployeeName.remove(FieldIndex);
						EmployeeAddress.remove(FieldIndex);
						EmployeeWorkPhone.remove(FieldIndex);
						EmployeeHomePhone.remove(FieldIndex);
						return "\nEmployee home phone and other fields deleted.";
					}
					else return "\nEmployee home phone not found.";
				}
				default: return "\nFieldname not found";
			}
			
		}
}
