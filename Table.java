/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Virtual Table Class for Small Business Database
 */

package smallbusinessdb;

public interface Table
{	
	//methods to be overridden 
	String QueryTableField(String FieldName, String QueryStr);
	
	String ModifyTableField(String FieldName, String QueryStr, String EntryStr);
	
	String ExpandTableField(String FieldName, String EntryStr, String IndexStr);
	
	String DeleteFieldEntry(String FieldName, String QueryStr);
	
	int GetTableLength();
}