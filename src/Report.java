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
	int nomborsub[] = {nomborbm, nomborbi,nombormath,nomborsains};
	double perc[] = {0.7,0.4};
	double totincomepersubbm,totincomepersubbi,totincomepersubmath,totincomepersubsains;
	double incomebm,incomebi,incomemath,incomesains;
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
		Text text = new Text(500,500,"TUITION REPORT");
		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);
		DropShadow ds = new DropShadow();
		ds.setColor(Color.rgb(254, 235, 66, 0.3));
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		ds.setRadius(5);
		ds.setSpread(0.2);
		
		blend.setBottomInput(ds);

		DropShadow ds1 = new DropShadow();
		ds1.setColor(Color.web("#f13a00"));
		ds1.setRadius(20);
		ds1.setSpread(0.2);

		Blend blend2 = new Blend();
		blend2.setMode(BlendMode.MULTIPLY);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.web("#feeb42"));
		is.setRadius(9);
		is.setChoke(0.8);
		blend2.setBottomInput(is);

		InnerShadow is1 = new InnerShadow();
		is1.setColor(Color.web("#f13a00"));
		is1.setRadius(5);
		is1.setChoke(0.4);
		blend2.setTopInput(is1);

		Blend blend1 = new Blend();
		blend1.setMode(BlendMode.MULTIPLY);
		blend1.setBottomInput(ds1);
		blend1.setTopInput(blend2);

		blend.setTopInput(blend1);

		text.setEffect(blend);
		Label totStudents = new Label("Total Students : " + data.size());
		
		Label totalFees = new Label ("Total fees :  " + totalfeez() );
		totStudents.setFont(new Font("Arial", 15));
		totalFees.setFont(new Font("Arial", 15));
		Text instructors = new Text("***INSTRUCTORS***");
		instructors.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		Label teacher1 = new Label(cikgu.get(0).getTeacher());
		Label teacher2 = new Label(cikgu.get(1).getTeacher());
		Label teacher3 = new Label(cikgu.get(2).getTeacher());
		Label teacher4 = new Label(cikgu.get(3).getTeacher());
		checknumberofstudents();
		totincomepersubbm = nomborbm * cikgu.get(0).getPrice();
		totincomepersubbi = nomborbi * cikgu.get(1).getPrice();
		totincomepersubmath = nombormath * cikgu.get(2).getPrice();
		totincomepersubsains = nomborsains * cikgu.get(3).getPrice();
		Label totstudents = new Label("\t\t\t\t\t\t\tTOTAL STUDENTS");
		Label studentbm = new Label("\t\t\t\t\t\t\t" + nomborbm );
		Label studentbi = new Label("\t\t\t\t\t\t\t" + nomborbi );
		Label studentmath = new Label("\t\t\t\t\t\t" + nombormath );
		Label studentsains = new Label("\t\t\t\t\t\t" + nomborsains );
		DecimalFormat twoPlaces = new DecimalFormat("0.00");
		Label totinbm = new Label("\t\t\t\t\t\t" + twoPlaces.format(totincomepersubbm));
		Label totinbi = new Label("\t\t\t\t\t\t" + twoPlaces.format(totincomepersubbi));
		Label totinmath = new Label("\t\t\t\t\t\t\t" + twoPlaces.format(totincomepersubmath));
		Label totinsains = new Label("\t\t\t\t\t\t\t" + twoPlaces.format(totincomepersubsains));
		if(nomborbm>5)
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
			;
		}
		
	    Label totincome = new Label("\t\t\tTOTAL INCOME");
	    Label totpayment = new Label("\t\t\t\t\t\t\t\tPAYMENT");
	    Locale locale = new Locale("en", "US");      
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	    String paymentbm = currencyFormatter.format(incomebm);
	    String paymentbi = currencyFormatter.format(incomebi);
	    String paymentmath = currencyFormatter.format(incomemath);
	    String paymentsains = currencyFormatter.format(incomesains);
		Label paymentz1 = new Label("\t\t\t\t\t\t\t" + paymentbm);
		Label paymentz2 = new Label("\t\t\t\t\t\t\t" +paymentbi);
		Label paymentz3 = new Label("\t\t\t\t\t\t\t\t" +paymentmath);
		Label paymentz4 = new Label("\t\t\t\t\t\t\t\t" +paymentsains);
		
		HBox hboxtitle = new HBox();
		hboxtitle.getChildren().addAll(totstudents,totincome,totpayment);
		hboxtitle.setSpacing(10);
		HBox hbez = new HBox();
		hbez.getChildren().addAll(totStudents,totalFees);
		hbez.setSpacing(30);
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
		VBox vbez = new VBox();
		vbez.getChildren().addAll(text,hbez,instructors,hboxtitle,hb,hb2,hb3,hb4);
		this.setScene(new Scene(vbez,1000,1000));
		this.show();
		
	}
	

}
