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

    int numClasses = (int)brInput.read() - '0';

    ArrayList<Class> database = new ArrayList<Class>(numClasses);
    
    String wholeFile = "", temp, date;
    String classTitle;
    int timeSpent, videosWatched, arrListCount = -1;
    
    //Create String with each line not including blank lines.
    while((temp = brInput.readLine()) != null)
    {
    	if(temp.equals(""))
    		continue;
    	wholeFile += temp + "\n";
    }
    
    String[] splitFile = wholeFile.split("\n");
//    for(int i = 0; i < splitFile.length; i++)
//    	System.out.println(splitFile[i]);
    
    int i = 0;
    while(i < splitFile.length)
    {
    	if(numSpaces(splitFile[i]) > 1)
    	{
    		arrListCount++;
    		database.add(new Class(splitFile[i++]));
    	}
    	
    	String[] fullName;
    	fullName = splitFile[i++].split(" ");
    	
    	date = splitFile[i++];
    	timeSpent = Integer.parseInt(splitFile[i++]);
    	videosWatched = Integer.parseInt(splitFile[i++]);
    	
    	database.get(arrListCount).addStudent(new Student(fullName[0], fullName[1], timeSpent, videosWatched));
    	//i++;
    }

       
  }
  
  public static int numSpaces(String temp)
  {
	  int count = 0;
	  
	  for(int i = 0; i < temp.length(); i++)
	  {
		  if(temp.charAt(i) == ' ')
			  count++;
	  }
	  
	  return count;
  }
}
