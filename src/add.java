import javafx.util.Callback;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.effect.Reflection;
public class add extends Stage
{
	
	Text t = new Text("CHOOSE YOUR SUBJECT WISELY");
	Label addsubject = new Label("Choose :");
	Button ok = new Button("OK");
	Button cancel = new Button("Cancel");
	public static ObservableList<Subject> getSubjectDummy()
	{
		ObservableList<Subject> suboptions = FXCollections.observableArrayList();
	    suboptions.addAll(new Subject("Bahasa Malaysia","BM501","Cikgu Arissa",55.50));
	    suboptions.addAll(new Subject("English","ENG101","Teacher Muthu",52.50));
	    suboptions.addAll(new Subject("Mathematics","MAT101","Ramu",62.50));
	    
	    return suboptions;
		
	}
	
	
	public add()
	{
		Stage addStage = new Stage();
		addStage.setTitle("ADD YOUR SUBJECT");
		t.setX(10.0f);
		t.setY(50.0f);
		t.setCache(true);
		t.setFill(Color.RED);
		t.setFont(Font.font(null, FontWeight.BOLD, 30));
		Reflection r = new Reflection();
		r.setFraction(0.7f); 
		t.setEffect(r); 
		t.setTranslateY(400);
		final ComboBox<Subject> comboBox = new ComboBox(getSubjectDummy());
		comboBox.getSelectionModel().selectFirst();
		comboBox.setCellFactory(new Callback<ListView<Subject>,ListCell<Subject>>()
				{
			 		@Override
			 		public ListCell<Subject> call(ListView<Subject> p)	 	
			 	  {
	                 final ListCell<Subject> cell = new ListCell<Subject>(){
	 
	                    @Override
	                    protected void updateItem(Subject t, boolean bln) 
	                    {
	                        super.updateItem(t, bln);
	                         if(t != null){
	                            setText(t.name);
	                        }else{
	                            setText(null);
	                        }
	                    }
	  
	                };
	                 
	                return cell;
			 	  }
				});
		ok.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				Student addsubject = new Student();
				addsubject.addSubject(comboBox.getValue());
				addStage.close();
			}	
		});
		cancel.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				addStage.close();
				
			}	
		});
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		VBox vbox = new VBox();
		hbox1.getChildren().addAll(t);
		hbox2.getChildren().addAll(addsubject,comboBox);
		hbox3.getChildren().addAll(ok,cancel);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3);
		addStage.setScene(new Scene(vbox, 700, 700));
	    addStage.show();
	}
	
	//Scene scenez = new Scene()
}

