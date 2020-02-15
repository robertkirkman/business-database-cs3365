package export.csv;

import java.io.*;
import java.util.*;

public class ExportCSV {
  public static void ExportCSV(String[] args) throws IOException {
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
    try{
        FileWriter writer = new FileWriter("YourFile.txt",true);
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
  }
}