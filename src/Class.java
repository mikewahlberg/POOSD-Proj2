import java.util.ArrayList;
import java.util.Date;

public class Class implements Comparable{
	static ArrayList<Student> roster = new ArrayList<Student>();
	String className;
	
	Class(String title)
	{
		className = title;
	}
	
	public void addStudent(Student tempStud)
	{
		roster.add(tempStud);
		//System.out.println(tempStud);
	}
	
	public String toString()
	{
		String s = className + "\n" + "Class Size: " + roster.size() + "\n";
		
		//sortVideos();
		
		for(int i = 0; i < roster.size(); i++)
		{
			s += roster.get(i);
		}
		
		return s;
	}
	
	
	//Functions to determine closest three.
	//Closest three will be any matches and the one above and or below.
	
	public String matchFirst(String key)
	{
		sortFirst();
		
		int lower = 0, upper = roster.size()-1;
		int pos = roster.size()/2;
		
		while(roster.get(pos).firstName.compareTo(key) != 0 && lower <= upper)
		{
			if(roster.get(pos).firstName.compareTo(key) < 0)
				lower = pos+1;
			else
				upper = pos-1;
			pos = (upper+lower)/2;
		}
		
		if(pos < roster.size()-1 && pos != 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos+1);
		}
		
		if(pos == 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos+1) + "\n" + roster.get(pos+2);
		}
		
		return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos-2);
	}
	
	public String matchLast(String key)
	{
		sortLast();
		
		int lower = 0, upper = roster.size()-1;
		int pos = roster.size()/2;
		
		while(roster.get(pos).lastName.compareTo(key) != 0 && lower <= upper)
		{
			if(roster.get(pos).lastName.compareTo(key) < 0)
				lower = pos+1;
			else
				upper = pos-1;
			pos = (upper+lower)/2;
		}
		
		if(pos < roster.size()-1 && pos != 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos+1);
		}
		
		if(pos == 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos+1) + "\n" + roster.get(pos+2);
		}
		
		return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos-2);
	}
	
	public String matchDate(String date)
	{
		sortDate();
		Date d = formatDate(date);
		
		int lower = 0, upper = roster.size()-1;
		int pos = roster.size()/2;
		
		while(roster.get(pos).date.compareTo(d) != 0 && lower <= upper)
		{
			if(roster.get(pos).date.compareTo(d) < 0)
				lower = pos+1;
			else
				upper = pos-1;
			pos = (upper+lower)/2;
		}
		
		if(pos < roster.size()-1 && pos != 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos+1);
		}
		
		if(pos == 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos+1) + "\n" + roster.get(pos+2);
		}
		
		return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos-2);
	}
	
	public String matchTime(int time)
	{
		sortTime();
	
		int lower = 0, upper = roster.size()-1;
		int pos = roster.size()/2;
		
		while(roster.get(pos).timeSpent != time && lower <= upper)
		{
			if(roster.get(pos).timeSpent < time)
				lower = pos+1;
			else
				upper = pos-1;
			pos = (upper+lower)/2;
		}
		
		if(pos < roster.size()-1 && pos != 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos+1);
		}
		
		if(pos == 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos+1) + "\n" + roster.get(pos+2);
		}
		
		return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos-2);
	}
	
	public String matchVideos(int videos)
	{
		sortVideos();	
		
		int lower = 0, upper = roster.size()-1;
		int pos = roster.size()/2;
		
		while(roster.get(pos).videosWatched != videos && lower <= upper)
		{
			if(roster.get(pos).videosWatched < videos)
				lower = pos+1;
			else
				upper = pos-1;
			pos = (upper+lower)/2;
		}
		
		if(pos < roster.size()-1 && pos != 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos+1);
		}
		
		if(pos == 0)
		{
			return roster.get(pos) + "\n" + roster.get(pos+1) + "\n" + roster.get(pos+2);
		}
		
		return roster.get(pos) + "\n" + roster.get(pos-1) + "\n" + roster.get(pos-2);
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//The sort functions, all except course name. 
	//Utilize MergeSort.
	public  void sortFirst()
	{
		roster = mergeBase(roster, 1);
	}
	
	
	public static void sortLast()
	{
		roster = mergeBase(roster, 2);
	}
	
	public static void sortDate()
	{
		roster = mergeBase(roster, 3);
	}
	
	public static void sortTime()
	{
		roster = mergeBase(roster, 4);
	}
	
	public static void sortVideos()
	{
		roster = mergeBase(roster, 5);
	}
	
	/*
	 *  Which Values:
	 *  - 1 = First
	 *  - 2 = Last
	 *  - 3 = Date
	 *  - 4 = Time
	 *  - 5 = Videos
	 */
	
	public static ArrayList<Student> mergeBase(ArrayList<Student> studs, int which)
	{
		ArrayList<Student> left = new ArrayList<Student>();
		ArrayList<Student> right = new ArrayList<Student>();
		int middle = studs.size()/2;
		
		if(studs.size() == 1)
			return studs;
		
		else
		{
			for(int i = 0; i < middle; i++)
			{
				left.add(studs.get(i));
			}
			
			for(int i = middle; i < studs.size(); i++)
			{
				right.add(studs.get(i));
			}
			
			left = mergeBase(left, which);
			right = mergeBase(right, which);
			
			merge(left, right, studs, which);
		}
		
		return studs;
	}
	
	public static void merge(ArrayList<Student> left, ArrayList<Student> right, ArrayList<Student> studs, int which)
	{
		int li = 0, ri = 0, i = 0;
		
		switch(which)
		{
			case 1:
				while(li < left.size() && ri < right.size())
				{
					if(left.get(li).firstName.compareTo(right.get(ri).firstName) < 0)
					{
						studs.set(i, left.get(li));
						li++;
					}
					
					else
					{
						studs.set(i, right.get(ri));
						ri++;
					}
					
					i++;
				}
				
				ArrayList<Student> remainder;
				int remInd;
				if(li >= left.size())
				{
					remainder = right;
					remInd = ri;
				}
				else
				{
					remainder = left;
					remInd = li;
				}
				
				for(int remi = remInd; remi < remainder.size(); remi++)
				{
					studs.set(i, remainder.get(remi));
					i++;
				}
				break;
			
			case 2:
				while(li < left.size() && ri < right.size())
				{
					if(left.get(li).lastName.compareTo(right.get(ri).lastName) < 0)
					{
						studs.set(i, left.get(li));
						li++;
					}
					
					else
					{
						studs.set(i, right.get(ri));
						ri++;
					}
					
					i++;
				}
				
				ArrayList<Student> remainder2;
				int remInd2;
				if(li >= left.size())
				{
					remainder2 = right;
					remInd2 = ri;
				}
				else
				{
					remainder2 = left;
					remInd2 = li;
				}
				
				for(int remi = remInd2; remi < remainder2.size(); remi++)
				{
					studs.set(i, remainder2.get(remi));
					i++;
				}
				break;
				
			case 3:
				while(li < left.size() && ri < right.size())
				{
					if(left.get(li).date.compareTo(right.get(ri).date) < 0)
					{
						studs.set(i, left.get(li));
						li++;
					}
					
					else
					{
						studs.set(i, right.get(ri));
						ri++;
					}
					
					i++;
				}
				
				ArrayList<Student> remainder3;
				int remInd3;
				if(li >= left.size())
				{
					remainder3 = right;
					remInd3 = ri;
				}
				else
				{
					remainder3 = left;
					remInd3 = li;
				}
				
				for(int remi = remInd3; remi < remainder3.size(); remi++)
				{
					studs.set(i, remainder3.get(remi));
					i++;
				}
				break;
				
			case 4:
				while(li < left.size() && ri < right.size())
				{
					if(left.get(li).timeSpent < right.get(ri).timeSpent)
					{
						studs.set(i, left.get(li));
						li++;
					}
					
					else
					{
						studs.set(i, right.get(ri));
						ri++;
					}
					
					i++;
				}
				
				ArrayList<Student> remainder4;
				int remInd4;
				if(li >= left.size())
				{
					remainder4 = right;
					remInd4 = ri;
				}
				else
				{
					remainder4 = left;
					remInd4 = li;
				}
				
				for(int remi = remInd4; remi < remainder4.size(); remi++)
				{
					studs.set(i, remainder4.get(remi));
					i++;
				}
				break;
			
			case 5:
				while(li < left.size() && ri < right.size())
				{
					if(left.get(li).videosWatched < right.get(ri).videosWatched)
					{
						studs.set(i, left.get(li));
						li++;
					}
					
					else
					{
						studs.set(i, right.get(ri));
						ri++;
					}
					
					i++;
				}
				
				ArrayList<Student> remainder5;
				int remInd5;
				if(li >= left.size())
				{
					remainder5 = right;
					remInd5 = ri;
				}
				else
				{
					remainder5 = left;
					remInd5 = li;
				}
				
				for(int remi = remInd5; remi < remainder5.size(); remi++)
				{
					studs.set(i, remainder5.get(remi));
					i++;
				}
				break;
				
			default:
				System.out.println("How did you get here...");
				break;
		}
	}
	
	public Date formatDate(String unformatted)
	{
		Date d = new Date();
		
		String[] split = unformatted.split("/");
		
		d.setMonth(Integer.parseInt(split[0]));
		d.setDate(Integer.parseInt(split[1]));
		d.setYear(Integer.parseInt(split[2]));
		
		return d;
	}
}