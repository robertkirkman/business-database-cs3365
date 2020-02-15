/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Customer Table Class for Small Business Database
 */
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
	public static void main(String[] args)
	{
		// Declare the database filename
		String DatabaseFilename = "DB.ser";
		
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
			InputBuf = UserInput.next();
			
			//basic command parsing
			switch(InputBuf)
			{
				case "query":
				{
					
				}
				case "modify":
				{
					
				}
				case "expand":
				{
					
				}
				case "delete":
				{
					
				}
				case "export":
				{
					
				}
				case "changetable":
				{
					
				}
				case "quit":
				{
					RunBehaviorLoop = false;
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
