import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*This is another GUI class where the staff can add a brand new subject
 * 
 */
public class AddNewSubject extends Stage
{
	public AddNewSubject()
	{
		Stage addStage = new Stage();
		addStage.setTitle("ADD YOUR OWN SUBJECT");
		Text title = new Text("ADD A NEW SUBJECT FOR THE TUITION");
		title.setFont(Font.font("Times New Roman", FontWeight.THIN, 25));
		Label subname = new Label("Subject Name : ");
		final TextField textfieldName = new TextField();
		textfieldName.setPromptText("Subject Name...");
		Label subcode = new Label("Subject Code : ");
		final TextField textfieldCode = new TextField();
		textfieldCode.setPromptText("Subject Code...");
		Label subteacher= new Label("Subject Teacher : ");
		final TextField textfieldTeacher = new TextField();
		textfieldTeacher.setPromptText("Teacher...");
		Label subprice = new Label("Subject Price : ");
		final TextField textfieldPrice = new TextField();
		textfieldPrice.setPromptText("Subject Price...");
		textfieldPrice.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                textfieldPrice.setText(newValue.replaceAll("[^\\d]", ""));
	            }
	        }
	    });
		Button ok = new Button("OK");
		ok.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				double pricevalue = Double.parseDouble(textfieldPrice.getText());
				ChooseStudent.suboptions.addAll(new Subject(textfieldName.getText(),textfieldCode.getText(),textfieldTeacher.getText(),pricevalue));
				addStage.close();
			}
		}
		);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		VBox vbox = new VBox();
		hbox1.getChildren().addAll(subname,textfieldName);
		hbox2.getChildren().addAll(subcode,textfieldCode);
		hbox3.getChildren().addAll(subteacher,textfieldTeacher);
		hbox4.getChildren().addAll(subprice,textfieldPrice);
		vbox.getChildren().addAll(title,hbox1,hbox2,hbox3,hbox4,ok);
		addStage.setScene(new Scene(vbox, 500, 500));
	    addStage.show();
		
	}
}
