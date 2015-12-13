
public class SubjectCollection
{
	private Subject[] collectionz;
	private int numberofsubs;
	private int count;
	
	public SubjectCollection()
	{
		collectionz = new Subject[5];
		count = 0;
	}
	public void addSubject(String name, String code,String teacher, double price)
	{
		collectionz[count] = new Subject(name, code,teacher,price);
		count++; 
	}
	public String toString()
	{
		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "List of UPSR Subjects available\n\n";
		for (int i = 0; i < count; i++)
		{
			report += collectionz[i].toString() + "\n";
		}
		return report+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	}
}
