import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Student 
{
	protected String name;
	protected String ID;
	protected String year;
	protected SubjectCollection sub;
	
	public Student()
	{
		
	}
	public Student(String name,String ID,String year)
	{
		this.name = name;
		this.ID = ID;
		this.year = year;
		sub = null;
	}
	public void setName(String name)
	{
		this.name = name;
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
		 TableColumn<Student,String> yearCol = new TableColumn<>(columnNames[i++]);
		 
		 i=0;
		 nameCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i++]));
		 idCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i++]));
		 yearCol.prefWidthProperty().bind(table.widthProperty().divide(100/column_width[i++]));
		 i=0;
		 nameCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i++]));
		 idCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i++]));
		 yearCol.setCellValueFactory(new PropertyValueFactory<Student,String>(variableNames[i++]));
		 columns.add(nameCol);
		 columns.add(idCol);
		 columns.add(yearCol);
		 return columns;
	}
	public String toString()
	{
		return "Name : " + name + "\n Year : " + year + "\n ID : " + ID;	
	}
}
