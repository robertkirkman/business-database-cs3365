/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Customer Table Class for Small Business Database
 */
import java.util.*;
import java.io.*;

public class SmallBusinessDatabase
{
	public static void main(String[] args)throws IOException
	{
		// Declare the database filename
		String DatabaseFilename = "DB.csv";
		
		// Declare the behavior loop condition
		boolean RunBehaviorLoop = true;
		
		// Declare Input string buffer
		String InputBuf;
		
		// Initialize the input scanner
		Scanner UserInput = new Scanner(System.in);
		
		// Create a null instance of CustomerTable
		CustomerTable CustomerTableObj = new CustomerTable();
		
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
						System.out.println(CustomerTableObj.QueryTableField(InputBufArray[1], InputBufArray[2]));
					break;
				}
				case "modify":
				{
					break;
				}
				case "expand":
				{
					if (InputBufArray.length == 4)
						System.out.println(CustomerTableObj.ExpandTableField(InputBufArray[1], InputBufArray[2], 
							InputBufArray[3]));
					break;
				}
				case "delete":
				{
					break;
				}
				case "export": //exports CSV as a TXT
				{
				        String[] filepath = new String[5];
        				filepath[0]=DatabaseFilenameObj.getAbsolutePath();
        				Export.Export(filepath);
					System.out.println("Your file has been exported");
					break;
				}
				case "changetable":
				{
					break;
				}
				case "quit":
				{
					RunBehaviorLoop = false;
					break;
				}
				default:
				{
					System.out.println("Commands: ");
					System.out.println("query [" + CustomerTable.FieldNames + "] [query string]");
					System.out.println("modify [" + CustomerTable.FieldNames + "] [query string] [entry string]");
					System.out.println("expand [" + CustomerTable.FieldNames + "] [entry string] [index integer]");
					System.out.println("delete [" + CustomerTable.FieldNames + "] [query string]");
					System.out.println("export");
					System.out.println("changetable");
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
            DatabaseObjOutStream.writeObject(CustomerTableObj); 
              
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
