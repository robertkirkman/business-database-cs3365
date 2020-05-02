package smallbusinessdb;

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
  
  public void showMessage(String[] args) throws IOException {
    /////////////////////READS CSV/////////////////////////
    List<List<String>> records = new ArrayList<>();
    //String[] filepath = new String[5];
    //filepath[0]="C:\\Users\\Milam\\Desktop\\Book1.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(" ");
            records.add(Arrays.asList(values));
        }
    }catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }catch (IOException e) {
        e.printStackTrace();
    }
    
    //////////////////////WRITES TXT//////////////////////////
    try{
        FileWriter writer = new FileWriter("YourFile.txt",false);
        
        for (int i=0 ; i< records.size();i++)
        {
        writer.write(""+records.get(i));
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
