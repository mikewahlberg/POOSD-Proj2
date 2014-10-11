import java.util.ArrayList;

public class Class {
	ArrayList<Student> roster = new ArrayList<Student>();
	String className;
	
	Class(String title)
	{
		className = title;
	}
	
	public void addStudent(Student tempStud)
	{
		roster.add(tempStud);
		System.out.println(tempStud);
	}
	
	//Add sorting functions.
}
