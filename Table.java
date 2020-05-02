/* 
 *  Author ......: Robert Kirkman
 *  Course.......: CS 3365
 *  Description..: Virtual Table Class for Small Business Database
 */

package smallbusinessdatabase;

public interface Table
{	
	//methods to be overridden
    	String GetInfo(int FieldIndex);
	
        String QueryTableField(String FieldName, String QueryStr);
	
	String ModifyTableField(String FieldName, String QueryStr, String EntryStr);
	
	String ExpandTableField(String FieldName, String EntryStr, String IndexStr);
	
	String DeleteFieldEntry(String FieldName, String QueryStr);

        int GetTableLength();

}
