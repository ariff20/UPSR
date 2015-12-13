
public class StudentCollection
{
	private Student[] collection;
	private int TotalStudent;
	private int count;
	
	public StudentCollection()
	{
		collection = new Student[30];
		count = 0;
	}
	public void addStudent(String name, String id, String year)
	{
		collection [count] = new Student(name, id, year);
		count++;
	}
	public String toString()
	{
		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "Number of Student taking UPSR management system\n\n";
		for (int i = 0; i < count; i++)
		{
			report += collection[i].toString() + "\n";
		}
		return report+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	}
}
