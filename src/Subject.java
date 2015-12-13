
public class Subject 
{
	protected String name;
	protected String code;
	protected String teacher;
	protected double price;
	protected Student stud;
	public Subject(String name,String code,String teacher,double price)
	{
		this.name = name;
		this.code = code;
		this.teacher = teacher;
		this.price = price;
		stud = null;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setStudent(Student stud)
	{
		if(this.stud != null)
		{
			
		}
	}
	public void setprice(double price)
	{
		this.price = price;
	}
	public void setcode(String code)
	{
		this.code = code;
	}
	public void setTeacher(String teacher)
	{
		this.teacher = teacher;
	}
	public String getName()
	{
		return name;
	}
	public String getCode()
	{
		return code;
	}
	public String getTeacher()
	{
		return teacher;
	}
	public double getPrice()
	{
		return price;
	}
	public String toString()
	{
		return "Subjects : " + code + " " + name + "\nPrice : " + price + "\nTeacher : " + teacher;
	}
	
}
