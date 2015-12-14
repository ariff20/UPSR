//import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddSubject extends Stage {

	public AddSubject(Stage primaryStage,Student student)
	{
		
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
		
		ListView<Subject> list = new ListView<Subject>();
		ObservableList<Subject> items = FXCollections.observableArrayList(student.collectionz);
		list.setItems(items);
	    list.setCellFactory(new Callback<ListView<Subject>, ListCell<Subject>>(){
	 
	            @Override
	            public ListCell<Subject> call(ListView<Subject> p) 
	            {
	                 
	                ListCell<Subject> cell = new ListCell<Subject>(){
	 
	                    @Override
	                    protected void updateItem(Subject t, boolean bln) {
	                        super.updateItem(t, bln);
	                        if (t != null) {
	                        	for (int i = 0; i < 5; i++)
	                    		{
	                        		System.out.print(student.collectionz);
	                        		setText(t.getName());
	                    		}
	                        }
	                    }
	 
	                };
	                 
	                return cell;
	            }
	        });
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
		primaryStage.setScene(new Scene(vbox, 500, 500));
		primaryStage.show();;
	
	}
	}



