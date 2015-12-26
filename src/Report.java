import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Report extends Stage
{
	
	int nomborbm =0;
	int nomborbi =0;
	int nombormath =0;
	int nomborsains =0;
	int nomborsub[] = {nomborbm, nomborbi,nombormath,nomborsains};
	double totincome;
	int x = ChooseStudent.suboptions.size();
	int[] noofteachers = new int[x];
	private ObservableList<Label> teacherlabels = FXCollections.observableArrayList();
	private ObservableList<Label> eachlecturertotstudents = FXCollections.observableArrayList();
	private ObservableList<Label> subincome = FXCollections.observableArrayList();
	private ObservableList<Label> teacherpayments = FXCollections.observableArrayList();
	double perc[] = {0.7,0.4};
	double totincomepersub[];
	double payment[];
	String paymentz[];
	double incomebm,incomebi,incomemath,incomesains,allpayment,tuitionincome ,totalfeesa;
	Subject subz;
	ObservableList<Student> data;
	public void checknumberofstudents()
	{
		for (Student stud : data) {
			for (int i = 0; i < ChooseStudent.suboptions.size(); i++) 
			{
				if  (stud.collectionz.get(i).getTeacher() == ChooseStudent.suboptions.get(i).getTeacher())
					noofteachers[i]++;
				else
				{
					System.out.println("Error with the teacher array");
				}
			}
		}
		
		}
	
	public double totalfeez()
	{	
		double totalfeeza = 0;
			for(int i=0;i<data.size();i++)
			{
			     totalfeeza += data.get(i).getFees();
			}
			return totalfeeza;
	}
	public Report(ObservableList<Student> data)
	{
		this.data = data;
		Label tuitionreport = new Label("\n\n\t\t\t\t   TUITION REPORT");
		tuitionreport.setFont(new Font("Arial",50));
		Locale locale = new Locale("en", "US");      
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		totalfeesa = totalfeez();
		currencyFormatter.format(totalfeesa);
	    Label totalFees = new Label ("\t\t\t\t\t\t\t\t              Total fees :  " + totalfeesa );
		totalFees.setFont(new Font("Arial", 15));
		Text instructors = new Text("\n\n\n\t\t\t\t\t\t\t      ***INSTRUCTORS***\n\n");
		instructors.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		for(int y =0;y<ChooseStudent.suboptions.size();y++)
		{
			Label b = new Label(ChooseStudent.suboptions.get(y).getTeacher() + ": ");
		    teacherlabels.add(b);
		}
		
		checknumberofstudents();
	    Label totStudents = new Label("\t\t\t\t\t\t\t                     Total Students : " + data.size());
		totStudents.setFont(new Font("Arial", 15));	
		Label totstudents = new Label("\t\t\t\t\t\t\t TOTAL STUDENTS");
		for(int v=0;v<ChooseStudent.suboptions.size();v++)
		{
			Label studenteachlecturer = new Label("\t\t\t\t\t" + noofteachers[v]);
			eachlecturertotstudents.add(studenteachlecturer);
		}
		for(int z=0;z<ChooseStudent.suboptions.size();z++)
		{
			totincomepersub[z] = noofteachers[z] * ChooseStudent.suboptions.get(z).getPrice();
			totincome += totincomepersub[z];
			Label subjectincome = new Label("\t\t\t\t\t\t" + currencyFormatter.format(totincomepersub[z]));
			subincome.add(subjectincome);
			
			if(noofteachers[z]>(0.5*noofteachers.length))
			{
				payment[z] = totincome * perc[0];
			}
			else
			{
				payment[z] = totincome * perc[1];
			}
			allpayment += payment[z];
			paymentz[z] = currencyFormatter.format(payment[z]);
			Label payments = new Label ("\t\t\t\t\t\t\t\t\t " + paymentz[z]);
			teacherpayments.add(payments);
			
		}
		String allpaymentz = currencyFormatter.format(allpayment);
	    Label totincome = new Label("\t\t\tTOTAL INCOME");
	    Label totpayment = new Label("\t\t\t\t\t\t\t\tPAYMENT");
		Label linez = new Label ("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Label allpaymenta = new Label("Total payments :     " + allpaymentz);
		tuitionincome = totalfeez() - allpayment;
		String tuitionincomez = currencyFormatter.format(tuitionincome);
		Label tuitionincomea = new Label("Tuition income after payment :  " + tuitionincomez);
		HBox hboxtitle = new HBox();
		hboxtitle.getChildren().addAll(totstudents,totincome,totpayment);
		hboxtitle.setSpacing(10);
		for(int m=0;m<ChooseStudent.suboptions.size();m++)
		{
			HBox hb = new HBox();
			hb.getChildren().addAll(teacherlabels.get(m),eachlecturertotstudents.get(m),subincome.get(m),teacherpayments.get(m));
			hb.setSpacing(10);
			VBox vb = new VBox();
			vb.getChildren().addAll(tuitionreport,totStudents,totalFees);
			vb.setSpacing(10);
			VBox vbez = new VBox();
			vbez.getChildren().addAll(vb,instructors,hboxtitle,hb,linez,allpaymenta,tuitionincomea);
			this.setScene(new Scene(vbez,1000,1000));
			this.show();
		}
		
		
		
	}
	

}