
public class Student {
	String firstName, lastName;
	//Date
	int timeSpent, videosWatched;
	
	Student(String first, String last, int time, int videos)
	{
		firstName = first;
		lastName = last;
		
		timeSpent = time;
		videosWatched = videos;
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
		return getFullName() + "\n" +
				getTime() + "\n" +
				getVideos();
	}
}
