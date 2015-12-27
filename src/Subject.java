
/*This is the subject class for the adding of subjects for the students\
 * 
 */
public class Subject extends Student
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
		
	}
	public Subject(Subject sub)
	{
		this.name = sub.getName();
		this.code = sub.getCode();
		this.teacher = sub.getTeacher();
		this.price = sub.getPrice();
	}
	public void setname(String name)
	{
		this.name = name;
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
		return "Name : " + name +"\n"+ "Code : " + code +"\n"+ "Teacher : " + teacher +"\n" + "Price : " + price;
	}
	
}
