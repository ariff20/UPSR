import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class ChooseStudent 
{
	TableView<Student> table;

		
	public ChooseStudent(Stage primaryStage)
	{
		table = new TableView<Student>();
		table.getColumns().addAll(Student.getColumn(table));
		table.setItems(getStudentDummy());
		table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>()
				{
						@Override
						public void handle(MouseEvent event)
						{
							if(event.getClickCount()>0)
							{
								if(table.getSelectionModel().getSelectedIndex()>=0)
								{
									 new AddSubject(primaryStage,table.getSelectionModel().getSelectedItem());
								}
							}
						}
				});
		VBox vb = new VBox();
		vb.getChildren().addAll(table);
		Scene scene2 = new Scene(vb,800,500);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	public static ObservableList<Student> getStudentDummy()
	{
		ObservableList<Student> data = FXCollections.observableArrayList();
		
		data.addAll(new Student("Fahmi", "1300001", "3"));
		data.addAll(new Student("Ahmad", "1300002", "3"));
		data.addAll(new Student("Nasuha", "1300003","3"));
		data.addAll(new Student("Kimi", "1300004", "3"));
		data.addAll(new Student("Alia", "1300005", "3"));
		data.addAll(new Student("Ariff", "1400001", "2"));
		data.addAll(new Student("Faiz", "1400002", "2"));
		data.addAll(new Student("Osman", "1400003", "2"));
		data.addAll(new Student("Hadi", "1200001", "4"));
		data.addAll(new Student("Nabilah", "1300006", "3"));
	    data.addAll(new Student("Syafiqah", "1500001", "1"));
		data.addAll(new Student("Amalina", "1200002", "1"));
		data.addAll(new Student("Intan", "1500002", "1"));
		data.addAll(new Student("Rahman", "1400004", "1"));
		data.addAll(new Student("Hazim", "1000001", "6"));
		data.addAll(new Student("Azri", "1100001", "5"));
		data.addAll(new Student("Hanif", "1100002", "5"));
		data.addAll(new Student("Nazim", "1100003","5"));
		data.addAll(new Student("Faris", "1400005", "2"));
		data.addAll(new Student("Firdaus", "1500003", "1"));
		return data;
	}
   
}
