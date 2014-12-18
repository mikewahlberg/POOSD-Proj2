import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.*;

@SuppressWarnings("unused")
public class DataMain
{
  public static void main(String[] args) throws IOException
  {
	BufferedReader brInput = new BufferedReader(new FileReader("InputFile.txt"));

    int numClasses = (int)brInput.read() - '0';

    ArrayList<Class> database = new ArrayList<Class>();
    
    String wholeFile = "", temp, date;
    String classTitle;
    String timeSpent, videosWatched;
    int arrListCount = -1;
    
    //Create String with each line not including blank lines.
    while((temp = brInput.readLine()) != null)
    {
    	if(temp.equals(""))
    		continue;
    	wholeFile += temp + "\n";
    }
    brInput.close();
    
    String[] splitFile = wholeFile.split("\n");
    //for(int i = 0; i < splitFile.length; i++)
    //	System.out.println(splitFile[i]);
    
    Class tempClass;
    int i = 0;
    while(i < splitFile.length)
    {
    	if(splitFile[i+2].split("/").length == 3)
    	{
    		//System.out.println(splitFile[i] + " " + database.size() + " " + (arrListCount+1));
    		arrListCount++;
    		database.add(arrListCount, new Class(splitFile[i++]));
    	}
    	else
    	{
	    	String[] fullName;
	    	fullName = splitFile[i++].split(" ");
	    	date = splitFile[i++];
	    	timeSpent = splitFile[i++];
	    	videosWatched = splitFile[i++];
	    	
	    	database.get(database.size()-1).addStudent(new Student(fullName[0], fullName[1], Integer.parseInt(timeSpent), Integer.parseInt(videosWatched), date));
	    	
    	}
    	
//    	for(int j = 0; j < database.size(); j++)
//    		System.out.println(database.get(j));
    	
    }
    
    for(int j = 0; j < database.size(); j++)
		System.out.println(database.get(j));
    
       
  }
  
  public static int numSpaces(String temp)
  {
	  int count = 0;
	  
	  //The loop looks at the second to last character since the last character could be a space.
	  for(int i = 0; i < temp.length()-1; i++)
	  {
		  if(temp.charAt(i) == ' ')
			  count++;
	  }
	  
	  return count;
  }
}
