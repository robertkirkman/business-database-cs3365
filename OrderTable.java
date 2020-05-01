/*
 * Author ......: Connor Irvine
 * Course ......: CS 3365
 * Description..: Order table class for small business database
 */

package smallbusinessdb;

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class OrderTable implements Table
{
	public int FieldIndex;
	// Pre-chosen table fields using dynamically allocated arrays
	private ArrayList<String> OrderNumber = new ArrayList<String>();
	private ArrayList<String> OrderItem = new ArrayList<String>();
	private ArrayList<String> OrderItemAmount = new ArrayList<String>();
	private ArrayList<String> OrderDate = new ArrayList<String>();
	public static String FieldNames = "OrderNumber | Item | Amount | Date";
	
	//Constructor
	public OrderTable()
	{
		this.OrderNumber.add("None");
		this.OrderItem.add("None");
		this.OrderItemAmount.add("None");
		this.OrderDate.add("None");
	}
	
	//Concatenate order information into a readable string for display
	private String GetOrderInfo(int FieldIndex)
	{
		return  "\n Order Number: " + OrderNumber.get(FieldIndex) + 
				"\n Order Item: " + OrderItem.get(FieldIndex) +
				"\n Item Amount: " + OrderItemAmount.get(FieldIndex) +
				"\n Order Date: " + OrderDate.get(FieldIndex);
	}
	
	//Query method
	public String QueryTableField(String FieldName, String QueryString)
	{
		
		//use indexOf to search corresponding ArrayList for desired information
		switch(FieldName)
		{
			case "OrderNumber":
			{
				if((FieldIndex = OrderNumber.indexOf(QueryString)) != -1)
					return GetOrderInfo(FieldIndex);
				else return "\nOrder number not found.";
			}
			case "Item":
			{
				if((FieldIndex = OrderItem.indexOf(QueryString)) != -1)
					return GetOrderInfo(FieldIndex);
				else return "\nOrder item not found.";
			}
			case "Amount":
			{
				if((FieldIndex = OrderItemAmount.indexOf(QueryString)) != -1)
					return GetOrderInfo(FieldIndex);
				else return "\nOrder item Amount not found.";
			}
			case "Date":
			{
				if((FieldIndex = OrderDate.indexOf(QueryString)) != -1)
					return GetOrderInfo(FieldIndex);
				else return "\nOrder item not found.";
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
			case "OrderNumber":
			{
				if((FieldIndex = OrderNumber.indexOf(QueryString)) != -1)
				{
					OrderNumber.set(FieldIndex, EntryString);
					return "\nOrder number modified.";
				} else return "\nOrder number not found.";
			}
			case "Item":
			{
				if((FieldIndex = OrderItem.indexOf(QueryString)) != -1)
				{
					OrderItem.set(FieldIndex, EntryString);
					return "\nOrder item modified.";
				} else return "\nOrder item not found.";
			}
			case "Amount":
			{
				if((FieldIndex = OrderItemAmount.indexOf(QueryString)) != -1)
				{
					OrderItemAmount.set(FieldIndex, EntryString);
					return "\nOrder item amount modified.";
				} else return "\nOrder item amount not found.";
			}
			case "Date":
			{
				if((FieldIndex = OrderDate.indexOf(QueryString)) != -1)
				{
					OrderDate.set(FieldIndex, EntryString);
					return "\nOrder date modified.";
				} else return "\nOrder date not found.";
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
		if (FieldIndex < 0 || FieldIndex >= OrderNumber.size())
			return "\nInvalid insertion index: out of range";
		
		//use switch statement to match input with field name
		switch(FieldName)
		{
			case "OrderNumber":
			{
				OrderNumber.add(FieldIndex, EntryStr);
				OrderItem.add(FieldIndex, "None");
				OrderItemAmount.add(FieldIndex, "None");
				OrderDate.add(FieldIndex, "None");
				return "\nOrder Number entry created with other fields blank.";
			}
			case "Item":
			{
				OrderNumber.add(FieldIndex, "None");
				OrderItem.add(FieldIndex, EntryStr);
				OrderItemAmount.add(FieldIndex, "None");
				OrderDate.add(FieldIndex, "None");
				return "\nItem entry created with other fields blank.";
			}
			case "Amount":
			{
				OrderNumber.add(FieldIndex, "None");
				OrderItem.add(FieldIndex, "None");
				OrderItemAmount.add(FieldIndex, EntryStr);
				OrderDate.add(FieldIndex, "None");
				return "\nItem Amount entry created with other fields blank.";
			}
			case "Date":
			{
				OrderNumber.add(FieldIndex, "None");
				OrderItem.add(FieldIndex, "None");
				OrderItemAmount.add(FieldIndex, "None");
				OrderDate.add(FieldIndex, EntryStr);
				return "\nDate entry created with other fields blank.";
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
			case "OrderNumber":
			{
				if((FieldIndex = OrderNumber.indexOf(QueryStr)) != -1)
				{
					OrderNumber.remove(FieldIndex);
					OrderItem.remove(FieldIndex);
					OrderItemAmount.remove(FieldIndex);
					OrderDate.remove(FieldIndex);
					return "\nOrder number and other fields deleted.";
				}
				else return "\nOrder number not found.";
			}
			case "Item":
			{
				if((FieldIndex = OrderItem.indexOf(QueryStr)) != -1)
				{
					OrderNumber.remove(FieldIndex);
					OrderItem.remove(FieldIndex);
					OrderItemAmount.remove(FieldIndex);
					OrderDate.remove(FieldIndex);
					return "\nOrder item and other fields deleted.";
				}
				else return "\nOrder item not found.";
			}
			case "Amount":
			{
				if((FieldIndex = OrderItemAmount.indexOf(QueryStr)) != -1)
				{
					OrderNumber.remove(FieldIndex);
					OrderItem.remove(FieldIndex);
					OrderItemAmount.remove(FieldIndex);
					OrderDate.remove(FieldIndex);
					return "\nOrder item amount and other fields deleted.";
				}
				else return "\nOrder item amount not found.";
			}
			case "Date":
			{
				if((FieldIndex = OrderDate.indexOf(QueryStr)) != -1)
				{
					OrderNumber.remove(FieldIndex);
					OrderItem.remove(FieldIndex);
					OrderItemAmount.remove(FieldIndex);
					OrderDate.remove(FieldIndex);
					return "\nOrder date and other fields deleted.";
				}
				else return "\nOrder date not found.";
			}
			default: return "\nFieldname not found";
		}
		
	}

}
