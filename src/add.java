import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class add extends Stage
{
	Label addsubject = new Label("Subject :");
	Label subcode = new Label("Subject Code : ");
	Label subprice = new Label ("Price : ");
	Label subteacher = new Label("Teacher : ");
	public static ObservableList<Subject> getSubjectDummy()
	{
		ObservableList<Subject> suboptions = FXCollections.observableArrayList();
	    suboptions.addAll(new Subject("Bahasa Malaysia","BM501","Cikgu Arissa",55.50));
	    suboptions.addAll(new Subject("English","ENG101","Teacher Muthu",52.50));
	    suboptions.addAll(new Subject("Mathematics","MAT101","Ramu",62.50));
	    
	    return suboptions;
		
	}
	final ComboBox comboBox = new ComboBox(getSubjectDummy());
	Text cod = new Text(comboBox.getValue().toString());
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox3 = new HBox();
	HBox hbox4 = new HBox();
	VBox vbox = new VBox();
	add()
	{
		hbox1.getChildren().addAll(addsubject);
		hbox2.getChildren().addAll(subcode,cod);
		hbox3.getChildren().add(subprice);
		hbox4.getChildren().add(subteacher);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
		this.setScene(new Scene(vbox, 300, 300));
	    this.show();
	}
	
	//Scene scenez = new Scene()
}

