/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Wrapper class and main method for Small Business Database
 */
package smallbusinessdb;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;

public class SmallBusinessDatabase
{
	public static void main(String[] args)throws IOException
	{
		// Declare the database filename
		String DatabaseFilename = "DB.ser";
		
		// Declare the behavior loop condition
		boolean RunBehaviorLoop = true;
		
		// Declare Input string buffer
		String InputBuf;
		
		// Initialize the input scanner
		Scanner UserInput = new Scanner(System.in);
		
		// Create a new instance of CustomerTable
		Table CustomerTableObj = new CustomerTable();
		
		// Create a null instance of Table to swap to
		Table CurrentTableObj = null;
		
		// Create instances of OrderTable and EmployeeTable
		Table EmployeeTableObj = new EmployeeTable();
		Table OrderTableObj = new OrderTable();
		
		// Check if the database filename exists, and if not, skip reading from a file
		File DatabaseFilenameObj = new File(DatabaseFilename);
		if (DatabaseFilenameObj.exists())
		{
	        // Try to read any stored database information from a file and replace the current objects 
			// with the stored ones
	        try
	        {    
	            // Read the objects from a file 
	            FileInputStream DatabaseFileInStream = new FileInputStream(DatabaseFilename); 
	            ObjectInputStream DatabaseObjInStream = new ObjectInputStream(DatabaseFileInStream); 
	              
	            // Deserialize objects
	            CustomerTableObj = (CustomerTable)DatabaseObjInStream.readObject();
	            EmployeeTableObj = (EmployeeTable)DatabaseObjInStream.readObject();
	            OrderTableObj = (OrderTable)DatabaseObjInStream.readObject();
	            
	            //close object stream and file
	            DatabaseObjInStream.close(); 
	            DatabaseFileInStream.close(); 
	             
	            System.out.println("Customer table has been loaded."); 
	        } 
	        catch(ClassNotFoundException error) 
	        { 
	            System.out.println("ClassNotFoundException: " + error.getMessage()); 
	        } 
	        catch(IOException error) 
	        { 
	            System.out.println("IOException: " + error.getMessage()); 
	        } 
		}
		
		// Swap current table object to CustomerTableObj
		CurrentTableObj = CustomerTableObj;

        // Enter main behavior loop and await user input 
		while (RunBehaviorLoop)
		{
			System.out.print("> ");
			InputBuf = UserInput.nextLine();
			
			//basic command parsing
			String[] InputBufArray = (InputBuf.split("\\s+"));
			switch(InputBufArray[0])
			{
				case "query":
				{
					if (InputBufArray.length == 3)
						System.out.println(CurrentTableObj.QueryTableField(InputBufArray[1], InputBufArray[2]));
					else System.out.println("Incorrect parameters.");
					break;
				}
				case "modify":
				{
                    if (InputBufArray.length == 4)
                        System.out.println(CurrentTableObj.ModifyTableField(InputBufArray[1], InputBufArray[2], 
                            InputBufArray[3]));
                    else System.out.println("Incorrect parameters.");
					break;
				}
				case "expand":
				{
					if (InputBufArray.length == 4)
						System.out.println(CurrentTableObj.ExpandTableField(InputBufArray[1], InputBufArray[2], 
							InputBufArray[3]));
					else System.out.println("Incorrect parameters.");
					break;
				}
				case "delete":
				{
					if (InputBufArray.length == 3)
                        System.out.println(CurrentTableObj.DeleteFieldEntry(InputBufArray[1], InputBufArray[2]));
					else System.out.println("Incorrect parameters.");
					break;
				}
				case "export": //exports CSV as a TXT
				{
			        String[] filepath = new String[5];
    				filepath[0]=DatabaseFilenameObj.getAbsolutePath();
    				ExportCSV.ExportCSV(filepath);
    				System.out.println("Your file has been exported");
    				break;
				}
				case "changetable":
				{
					if (InputBufArray.length == 2)
					{
						switch (InputBufArray[1])
						{
							case "Customers":
							{
								CurrentTableObj = CustomerTableObj;
								break;
							}
							case "Orders":
							{
								CurrentTableObj = OrderTableObj;
								break;
							}
							case "Employees":
							{
								CurrentTableObj = EmployeeTableObj;
								break;
							}
							default:
								System.out.println("Invalid table name.");
						}
					}
					else System.out.println("Incorrect parameters.");
					break;
				}
				case "quit":
				{
					RunBehaviorLoop = false;
					break;
				}
				//help for commands
				default:
				{
					System.out.println("Commands: ");
					System.out.println("query [" + CustomerTable.FieldNames + "] [query string]");
					System.out.println("modify [" + CustomerTable.FieldNames + "] [query string] [entry string]");
					System.out.println("expand [" + CustomerTable.FieldNames + "] [entry string] [index integer]");
					System.out.println("delete [" + CustomerTable.FieldNames + "] [query string]");
					System.out.println("export");
					System.out.println("changetable [Customers | Orders | Employees]");
					System.out.println("quit");
				}
			}
		}
		
        // Try to serialize and store objects as a file
        try
        {    
            FileOutputStream DatabaseFileOutStream = new FileOutputStream(DatabaseFilename); 
            ObjectOutputStream DatabaseObjOutStream = new ObjectOutputStream(DatabaseFileOutStream); 
              
            // Write object into the file stream
            DatabaseObjOutStream.writeObject(OrderTableObj); 
            DatabaseObjOutStream.writeObject(EmployeeTableObj); 
            DatabaseObjOutStream.writeObject(OrderTableObj); 
              
            DatabaseObjOutStream.close(); 
            DatabaseFileOutStream.close(); 
              
            System.out.println("Customer table has been saved."); 
        }
        catch(IOException error) 
        { 
            System.out.println("IOException: " + error.getMessage()); 
        } 
		
		//Close input scanner
		UserInput.close();
	}
}