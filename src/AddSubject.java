
import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*This is the class where the staff can add a subject for the student!
 * 
 */
public class AddSubject extends Stage {

	private Student student;
	protected ListProperty<Subject> listProperty = new SimpleListProperty<>();
	ObservableList<Student> data;	
	public AddSubject(Stage primaryStage,Student student, ObservableList<Student> data)
	{
		this.data = data;
		this.student = student;
		VBox vbox = new VBox();
		HBox hboz = new HBox();
		HBox hboy = new HBox();
		Label labelname = new Label("Name : ");
		Label labeltotsubjects = new Label ("Total Subjects : " + student.collectionz.size());
		 BigDecimal bs= new BigDecimal(student.getTotalFee());
		 bs = bs.setScale(2, RoundingMode.HALF_UP);
		Label labeltotprice = new Label("Total Fee : " + bs);
		Text studentname = new Text(student.getName());
		studentname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		Label labelID = new Label("ID : ");
		Text studentid = new Text(student.getID());
		studentid.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		Label labelyear = new Label("Year : ");
		Text studentyear = new Text(student.getYear());
		studentyear.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		hboz.getChildren().addAll(labelname,studentname,labelID,studentid,labelyear,studentyear);
		hboz.setSpacing(30);
		HBox hbox = new HBox();
		Label labelsubjects = new Label("Subjects : ");
		Button backbutton = new Button("BACK");
		ListView<Subject> list = new ListView<Subject>();
		list.itemsProperty().bind(listProperty);
		listProperty.set(FXCollections.observableArrayList(student.collectionz));
		HBox hboxz = new HBox();
		Button AddButton = new Button("ADD");
		backbutton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
				{
					for (int  i = 0; i  < data.size(); i++) {
						if (data.get(i).getName() == student.getName()) {
							data.set(i, student);
							break;
						}
					}
					 new ChooseStudent(primaryStage, data);
				}	
			
			
			
				});
		Button RefreshButton = new Button("REFRESH");
		RefreshButton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
						public void handle(ActionEvent e)
					{
						listProperty.set(FXCollections.observableArrayList(student.collectionz));
						labeltotsubjects.setText("Total Subjects : " + student.collectionz.size());
						labeltotprice.setText("Total Fee : " + student.getTotalFee());
					}	
				});
		AddButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				new add(student);
			}	
		});
		Button DropButton = new Button("DROP");
		DropButton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
						public void handle(ActionEvent e)
					{
						int i = list.getSelectionModel().getSelectedIndex();
						listProperty.set(FXCollections.observableArrayList(student.collectionz.remove(i)));
						labeltotsubjects.setText("Total Subjects : " + student.collectionz.size());
						labeltotprice.setText("Total Fee : " + student.getTotalFee());
					}
				});
		
		hboy.getChildren().addAll(labeltotsubjects,labeltotprice);
		hboy.setSpacing(15);
		hboxz.getChildren().addAll(AddButton,DropButton,RefreshButton,backbutton);
		hbox.getChildren().add(labelsubjects);
		vbox.getChildren().addAll(hboz,hbox,list,hboy,hboxz);
		primaryStage.setScene(new Scene(vbox, 500, 500));
		primaryStage.show();;
	
	}
	}



