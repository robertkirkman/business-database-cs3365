/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Virtual Table Class for Small Business Database
 */

package smallbusinessdb;

public class Table
{
	//index variable used when methods that access fields are called
	protected int FieldIndex;
	
	//methods to be overridden 
	public String QueryTableField(String FieldName, String QueryStr)
	{
		return "This method is to be overridden.";
	}
	
	public String ModifyTableField(String FieldName, String QueryStr, String EntryStr)
	{
		return "This method is to be overridden.";
	}
	
	public String ExpandTableField(String FieldName, String EntryStr, String IndexStr)
	{
		return "This method is to be overridden.";
	}
	
	public String DeleteFieldEntry(String FieldName, String QueryStr)
	{
		return "This method is to be overridden.";
	}
}