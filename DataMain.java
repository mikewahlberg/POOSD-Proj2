import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;

public class DataMain
{
  public static void main(String[] args) throws IOException
  {
	  BufferedReader brInput = new BufferedReader(new FileReader("InputFile.txt"));
	  //Scanner input = new Scanner(new File("InputFile.txt"));

    int numClasses = (int)brInput.read() - '0';

    System.out.println(numClasses);

    ArrayList<ArrayList> database = new ArrayList<ArrayList>(numClasses);
    
    String wholeFile = "", temp;
    
    //Create String with each line not including blank lines.
    while((temp = brInput.readLine()) != null)
    {
    	if(temp.equals(""))
    		continue;
    	wholeFile += temp + "\n";
    }
    
    String[] splitFile = wholeFile.split("\n");
    for(int i = 0; i < splitFile.length; i++)
    	System.out.println(splitFile[i] + "\n");
    
    //System.out.println(splitFile);
    
    //System.out.println(wholeFile);
    
  }
}
