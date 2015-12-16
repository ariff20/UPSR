import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Student 
{
	protected String name;
	protected String ID;
	protected String year;
	protected double fees;
	protected ArrayList<Subject> collectionz = new ArrayList<Subject>();

	
	public Student()
	{
		
	}
	public Student(String name,String ID,String year)
	{
		this.name = name;
		this.ID = ID;
		this.year = year;	
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void addSubject(Subject subject)
	{
		collectionz.add(new Subject(subject));
	}
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public void setyear(String year)
	{
		this.year = year;
	}
	public String getName()
	{
		return name;
	}
	public String getID()
	{
		return ID;
	}
	public String getYear()
	{
		return year;
	}
	public double getFees()
	{
		double fee = getTotalFee();
		return fee;
	}
	public double getTotalFee() {
		double total = 0;
		for (Subject sub : collectionz) {
			total += sub.getPrice();
		}
		return total;
	}
	public static ArrayList<TableColumn<Student,?>> getColumn(TableView table)
	{
		 int i;
		 ArrayList<TableColumn<Student,?>> columns = new  ArrayList<TableColumn<Student,?>>();
		 String[] columnNames = {"Student Name","ID","Year"};
		 String[] variableNames = {"name","ID","year"};
		 Integer[] column_width = {33,50,8};
		 i=0;
		 TableColumn<Student,String> nameCol = new TableColumn<>(columnNames[i++]);
		 TableColumn<Student,String> idCol = new TableColumn<>(columnNames[i++]);
		 TableColumn<Student,String> yearCol = new TableColumn<>(columnNames[i]);
		 
		 i=0;
		 nameCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i++]));
		 idCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i++]));
		 yearCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i]));
		 i=0;
		 nameCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i++]));
		 idCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i++]));
		 yearCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i]));
		 columns.add(nameCol);
		 columns.add(idCol);
		 columns.add(yearCol);
		 return columns;
	}
	public String toString()
	{
		return ID;	
	}
}
