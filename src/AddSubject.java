//import javafx.application.Application;
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

public class AddSubject extends Stage {
/*	public static void main(String[] args) 
	{
		launch(args);

	}
*/
	public AddSubject()
	{
		
		Student student = new Student("Fahmi", "1300001", "3");
		HBox hboz = new HBox();
		Label labelname = new Label("Name : ");
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
		ListView<String> list = new ListView<String>();
		ObservableList<String> items =FXCollections.observableArrayList ("null");
		list.setItems(items);
		HBox hboxz = new HBox();
		Button AddButton = new Button("ADD");
		AddButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				new add();
			}
			
			
		});
		hboxz.getChildren().add(AddButton);
		hbox.getChildren().add(labelsubjects);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hboz,hbox,list,hboxz);
		 this.setScene(new Scene(vbox, 300, 300));
		  this.show();;
		//primaryStage.setScene(scene);
	}
	}
/*	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.show();
		new AddSubject();
		Student student = new Student("Fahmi", "1300001", "3");
		HBox hboz = new HBox();
		Label labelname = new Label("Name : ");
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
		ListView<String> list = new ListView<String>();
		ObservableList<String> items =FXCollections.observableArrayList ("null");
		list.setItems(items);
		HBox hboxz = new HBox();
		Button AddButton = new Button("ADD");
		AddButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				new add();
			}
			
			
		});
		hboxz.getChildren().add(AddButton);
		hbox.getChildren().add(labelsubjects);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hboz,hbox,list,hboxz);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
	}
	*/


