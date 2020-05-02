/* 
 *  Author ......: Lora Milam
 *  Course.......: CS 3365
 *  Description..: ExportCSV Class for Small Business Database
 */
package smallbusinessdatabase;

import java.io.*;
import java.util.*;
import java.awt.Desktop;

public class ExportCSV {
  //create instance  
  private static ExportCSV export = new ExportCSV();
  
  private ExportCSV(){}
  
  public static ExportCSV getInstance(){
      return export;
  }
  
  public void showMessage(Table args) throws IOException {
    //////////////////////WRITES TXT//////////////////////////
    try{
        FileWriter writer = new FileWriter("YourFile.txt",false);
        
        for (int i=0 ; i< Integer.valueOf(args.GetTableLength());i++)
        {
        writer.write(""+args.GetInfo(i));
        writer.write("\r\n");
        }
        writer.close();
    }catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }catch (IOException e) {
        e.printStackTrace();
    }

    //////////////////////OPEN TXT//////////////////////////////
    Desktop desktop = null;
    // on Windows, retrieve the path of the "Program Files" folder
    File file = new File("YourFile.txt");

    try {
      if (Desktop.isDesktopSupported()) {
         desktop = Desktop.getDesktop();
         desktop.open(file);
      }
      else {
         System.out.println("desktop is not supported");
      }
    }catch (IOException e){  }
  }
}
