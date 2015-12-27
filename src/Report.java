import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

/*This class was really technically difficult but Alhamdulillah we managed to solve it. It is the Report GUI
 * and we have implemented a lot of complex concepts such as LinkedHashMap and ObservableLists.
 */
public class Report extends Stage
{
	
	
	double totincome;
	int x = ChooseStudent.suboptions.size();
	private ObservableList<Label> teacherlabels = FXCollections.observableArrayList();
	private ObservableList<Label> eachlecturertotstudents = FXCollections.observableArrayList();
	private ObservableList<Label> subincome = FXCollections.observableArrayList();
	private ObservableList<Label> teacherpayments = FXCollections.observableArrayList();
	double perc[] = {0.7,0.4};
	ArrayList <Double> totincompersub = new ArrayList<Double>();
	ArrayList <Double> payment = new ArrayList<Double>();
	ArrayList <String> paymentz = new ArrayList<String>();
	double allpayment,tuitionincome ,totalfeesa;
	Subject subz;
	ObservableList<Student> data;
	final Map<String, Integer> teacherMap = new LinkedHashMap<String, Integer>();
	public Map<String, Integer> checknumberofstudents()
	{
		       

			    for (int i = 0; i < data.size(); i++) 
			    {
			        Student student = data.get(i);
			        List<Subject> subjectList = student.collectionz;
			        for(Subject subject: subjectList)
			        {
			            Integer entry = teacherMap.get(subject.getTeacher());
			            if(entry == null) {
			                teacherMap.put(subject.getTeacher(), Integer.valueOf(1));
			            } else {
			                teacherMap.put(subject.getTeacher(), entry + 1);
			            }
			        }
			       
			    }

			    return teacherMap;
			
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
		checknumberofstudents();
	    Label totStudents = new Label("\t\t\t\t\t\t\t                     Total Students : " + data.size());
		totStudents.setFont(new Font("Arial", 15));	
		Label totstudents = new Label("\t\t\t\t\t\t\t TOTAL STUDENTS");		
		final Set<Entry<String,Integer>> mapValues = teacherMap.entrySet();
	    final int maplength = mapValues.size();
	    final Entry<String,Integer>[] test = new Entry[maplength];
	    mapValues.toArray(test);

	    for(int v=0;v<test.length;v++)
		{
	    	Label b = new Label(test[v].getKey() + ": ");
		    teacherlabels.add(b);
			Label studenteachlecturer = new Label("\t\t\t\t\t" + test[v].getValue());
			eachlecturertotstudents.add(studenteachlecturer);
		}
	   
		for(int z=0;z<test.length;z++)
		{
			
			totincompersub.add((double)test[z].getValue()*ChooseStudent.suboptions.get(z).getPrice());
			totincome += totincompersub.get(z);
			Label subjectincome = new Label("\t\t\t\t\t\t" + currencyFormatter.format(totincompersub.get(z)));
			subincome.add(subjectincome);
			
			if(test[z].getValue()>(0.5*teacherMap.size()))
			{
				 payment.add(totincompersub.get(z) * perc[0]);
			}
			else
			{
				payment.add(totincompersub.get(z) * perc[1]);
			}
			allpayment += payment.get(z);
			paymentz.add(currencyFormatter.format(payment.get(z)));
			Label payments = new Label ("\t\t\t\t\t\t\t\t\t " + paymentz.get(z));
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
		
		VBox vb = new VBox();
		vb.getChildren().addAll(tuitionreport,totStudents,totalFees);
		vb.setSpacing(10);

		VBox vbez = new VBox();
		vbez.getChildren().addAll(vb,instructors,hboxtitle);

		for(int m=0;m<test.length;m++) {
		  HBox hb = new HBox();

	
		  hb.getChildren().addAll(teacherlabels.get(m),eachlecturertotstudents.get(m),subincome.get(m),teacherpayments.get(m));
		  hb.setSpacing(10);


		  vbez.getChildren().add(hb);

		}

		vbez.getChildren().addAll(linez,allpaymenta,tuitionincomea);
		this.setScene(new Scene(vbez, 2000, 2000));
		this.show();
		
		
	}
	

}