import java.util.Date;


public class Student {
	String firstName, lastName;
	Date date;
	int timeSpent, videosWatched;
	
	Student(String first, String last, int time, int videos, String d)
	{
		firstName = first;
		lastName = last;
		date = formatDate(d);
		timeSpent = time;
		videosWatched = videos;
	}
	
	@SuppressWarnings("deprecation")
	public Date formatDate(String unformatted)
	{
		Date d = new Date();
		
		String[] split = unformatted.split("/");
		
		d.setMonth(Integer.parseInt(split[0]));
		d.setDate(Integer.parseInt(split[1]));
		d.setYear(Integer.parseInt(split[2]));
		
		return d;
	}
	
	public String getFirst()
	{
		return firstName;
	}
	
	public String getLast()
	{
		return lastName;
	}
	
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	public int getTime()
	{
		return timeSpent;
	}
	
	public int getVideos()
	{
		return videosWatched;
	}
	
	public String toString()
	{
		return "Name: " + getFullName() + "\n" +
				"Time: " + getTime() + "\n" +
				"Number of videos: " + getVideos() + "\n";
	}
}
