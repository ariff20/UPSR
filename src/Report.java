import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
	int nomborsemua;
	int nomborsub[] = {nomborbm, nomborbi,nombormath,nomborsains};
	double perc[] = {0.7,0.4};
	double totincomepersubbm,totincomepersubbi,totincomepersubmath,totincomepersubsains,totincomeallsub;
	double incomebm,incomebi,incomemath,incomesains,allpayment,tuitionincome;
	Subject subz;
	ObservableList<Student> data;
	ObservableList<Subject> cikgu2;
	public void checknumberofstudents()
	{
		for (Student stud : data) {
			for (int i = 0; i < stud.collectionz.size(); i++) {
				if  (stud.collectionz.get(i).getTeacher() == "Cikgu Suraya")
					nomborbm++;
				else if (stud.collectionz.get(i).getTeacher() == "Teacher Muthu")
					nomborbi++;
				else if (stud.collectionz.get(i).getTeacher() == "Teacher Ramu")
					nombormath++;
				else if (stud.collectionz.get(i).getTeacher() == "Teacher Syafiqah")
					nomborsains++;
			}
		}
		nomborsub[0] = nomborbm;
		nomborsub[1] = nomborbi;
		nomborsub[2] = nombormath;
		nomborsub[3] = nomborsains;
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
	public Report(ObservableList<Student> data,ObservableList<Subject> cikgu)
	{
		this.data = data;
		Label tuitionreport = new Label("\n\n\t\t\t\t   TUITION REPORT");
		tuitionreport.setFont(new Font("Arial",30));
		nomborsemua = nomborbm + nomborbi+nombormath+nomborsains;
		Label totStudents = new Label("\t\t\t\t\t\t\t                     Total Students : " + nomborsemua);
		Label totalFees = new Label ("\t\t\t\t\t\t\t\t              Total fees :  " + totalfeez() );
		totStudents.setFont(new Font("Arial", 15));
		totalFees.setFont(new Font("Arial", 15));
		Text instructors = new Text("\n\n\n\t\t\t\t\t\t\t      ***INSTRUCTORS***\n\n");
		instructors.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		Label teacher1 = new Label(cikgu.get(0).getTeacher());
		Label teacher2 = new Label(cikgu.get(1).getTeacher());
		Label teacher3 = new Label(cikgu.get(2).getTeacher());
		Label teacher4 = new Label(cikgu.get(3).getTeacher());
		
		checknumberofstudents();
		Locale locale = new Locale("en", "US");      
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	    
		totincomepersubbm = nomborbm * cikgu.get(0).getPrice();
		totincomepersubbi = nomborbi * cikgu.get(1).getPrice();
		totincomepersubmath = nombormath * cikgu.get(2).getPrice();
		totincomepersubsains = nomborsains * cikgu.get(3).getPrice();
		Label totstudents = new Label("\t\t\t\t\t\t\tTOTAL STUDENTS");
		Label studentbm = new Label("\t\t\t\t\t    " + nomborbm );
		Label studentbi = new Label("\t\t\t\t\t " + nomborbi );
		Label studentmath = new Label("\t\t\t\t\t  " + nombormath );
		Label studentsains = new Label("\t\t\t\t\t " + nomborsains );
		Label totinbm = new Label("\t\t\t\t\t\t" + currencyFormatter.format(totincomepersubbm));
		Label totinbi = new Label("\t\t\t\t\t\t" + currencyFormatter.format(totincomepersubbi));
		Label totinmath = new Label("\t\t\t\t\t\t" + currencyFormatter.format(totincomepersubmath));
		Label totinsains = new Label("\t\t\t\t\t\t   " + currencyFormatter.format(totincomepersubsains));
		
		
		if(nomborbm>(0.5*data.size()))
		{
			 incomebm = totincomepersubbm * perc[0];
			
		}
		else
		{
			incomebm = totincomepersubbm * perc[1];
			
		}
		if(nomborbi>5)
		{
			 incomebi = totincomepersubbi * perc[0];
			 
		}
		else
		{
			incomebi = totincomepersubbi * perc[1];
			
		}
		if(nombormath>5)
		{
			 incomemath = totincomepersubmath * perc[0];
			 
		}
		else
		{
			incomemath = totincomepersubmath * perc[1];
			
		}
		if(nomborsains>5)
		{
			 incomesains = totincomepersubsains * perc[0];
			 
		}
		else
		{
			incomesains = totincomepersubsains * perc[1];
			
		}
		
	    Label totincome = new Label("\t\t\tTOTAL INCOME");
	    Label totpayment = new Label("\t\t\t\t\t\t\t\tPAYMENT");
	    String paymentbm = currencyFormatter.format(incomebm);
	    String paymentbi = currencyFormatter.format(incomebi);
	    String paymentmath = currencyFormatter.format(incomemath);
	    String paymentsains = currencyFormatter.format(incomesains);
	    allpayment = incomebm + incomebi + incomemath + incomesains;
	    String allpaymentz = currencyFormatter.format(allpayment);
		Label paymentz1 = new Label("\t\t\t\t\t\t\t\t\t" + paymentbm);
		Label paymentz2 = new Label("\t\t\t\t\t\t\t\t\t  " +paymentbi);
		Label paymentz3 = new Label("\t\t\t\t\t\t\t\t\t  " +paymentmath);
		Label paymentz4 = new Label("\t\t\t\t\t\t\t\t\t     " +paymentsains);
		Label allpaymenta = new Label("Total payments :     " + allpaymentz);
		tuitionincome = totalfeez() - allpayment;
		String tuitionincomez = currencyFormatter.format(tuitionincome);
		Label tuitionincomea = new Label("Tuition income after payment :  " + tuitionincomez);
		HBox hboxtitle = new HBox();
		hboxtitle.getChildren().addAll(totstudents,totincome,totpayment);
		hboxtitle.setSpacing(10);
		HBox hb = new HBox();
		hb.getChildren().addAll(teacher1,studentbm,totinbm,paymentz1);
		hb.setSpacing(10);
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(teacher2,studentbi,totinbi,paymentz2);
		hb2.setSpacing(10);
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(teacher3,studentmath,totinmath,paymentz3);
		hb3.setSpacing(10);
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(teacher4,studentsains,totinsains,paymentz4);
		hb.setSpacing(10);
		VBox vb = new VBox();
		vb.getChildren().addAll(tuitionreport,totStudents,totalFees);
		vb.setSpacing(10);
		VBox vbez = new VBox();
		vbez.getChildren().addAll(vb,instructors,hboxtitle,hb,hb2,hb3,hb4,allpaymenta,tuitionincomea);
		this.setScene(new Scene(vbez,1000,1000));
		this.show();
		
	}
	

}
