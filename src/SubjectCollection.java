
public class SubjectCollection
{
	protected Subject[] collectionz;
	private int count;
	
	public SubjectCollection()
	{
		collectionz = new Subject[5];
		count = 0;
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
