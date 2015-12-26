import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class ChooseStudent 
{
	TableView<Student> table;
	Student student;
	ObservableList<Student> data = FXCollections.observableArrayList();
	static ObservableList<Subject> suboptions = FXCollections.observableArrayList();

	
	public ChooseStudent(Stage primaryStage, ObservableList<Student> data)
	{
		
		suboptions.addAll(new Subject("Bahasa Malaysia","BM501","Cikgu Suraya",55.55));
		suboptions.addAll(new Subject("English","ENG101","Teacher Muthu",52.55));
		suboptions.addAll(new Subject("Mathematics","MAT101","Teacher Ramu",62.55));
		suboptions.addAll(new Subject("Science","SCN101","Teacher Syafiqah",65.75));
		
		Button addnewsub = new Button("ADD NEW SUBJECT");
		addnewsub.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				new AddNewSubject();
			}
		}
		);
		this.student = student;
		this.data = data;
		Button report = new Button("REPORT");
		report.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
		{
			  new Report(data);
		}	
		}
				);
		table = new TableView<Student>();
		table.getColumns().addAll(Student.getColumn(table));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setItems(data);
		table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>()
				{
						@Override
						public void handle(MouseEvent event)
						{
							if(event.getClickCount()>0)
							{
								if(table.getSelectionModel().getSelectedIndex()>=0)
								{
									 new AddSubject(primaryStage,table.getSelectionModel().getSelectedItem(), data);
								}
							}
						}
				});
		Label labelsearch = new Label("Search ID : ");
		final TextField searchField = new TextField ();
		searchField.setPromptText("Search ID...");
		searchField.textProperty().addListener(new InvalidationListener()
		{


            	@Override
            	public void invalidated(Observable o) 
            	{

            		if(searchField.textProperty().get().isEmpty()) {

                    table.setItems(data);

                    return;
                }

                ObservableList<Student> tableItems = FXCollections.observableArrayList();

                ObservableList<TableColumn<Student, ?>> cols = table.getColumns();

                for(int i=0; i<data.size(); i++)
                {

                       for(int j=0; j<cols.size(); j++) 
                   {

                        TableColumn col = cols.get(j);

                        String cellValue = col.getCellData(data.get(i)).toString();

                        cellValue = cellValue.toLowerCase();

                        if(cellValue.contains(searchField.textProperty().get().toLowerCase())) {

                            tableItems.add(data.get(i));

                            break;

                        }                        

                    }


                }

                table.setItems(tableItems);
                table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>()
				{
						@Override
						public void handle(MouseEvent event)
						{
							if(event.getClickCount()>0)
							{
								if(table.getSelectionModel().getSelectedIndex()>=0)
								{
									 new AddSubject(primaryStage,table.getSelectionModel().getSelectedItem(), data);
								}
							}
						}
				});

            }

        });

		HBox hb = new HBox();
		hb.getChildren().addAll(labelsearch,searchField,addnewsub,report);
		hb.setSpacing(30);
		VBox vb = new VBox();
		vb.getChildren().addAll(table,hb);
		Scene scene2 = new Scene(vb,800,500);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
		
	public ChooseStudent(Stage primaryStage)
	{
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
		Button addnewsub = new Button("ADD NEW SUBJECT");
		addnewsub.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				new AddNewSubject();
			}
		}
		);
		table = new TableView<Student>();
		table.getColumns().addAll(Student.getColumn(table));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		Button report = new Button("REPORT");
		table.setItems(data);
		table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>()
				{
						@Override
						public void handle(MouseEvent event)
						{
							if(event.getClickCount()>0)
							{
								if(table.getSelectionModel().getSelectedIndex()>=0)
								{
									 new AddSubject(primaryStage,table.getSelectionModel().getSelectedItem(),data);
								}
							}
						}
				});
		final TextField searchField = new TextField ();
		searchField.setPromptText("Search ID...");
		searchField.textProperty().addListener(new InvalidationListener()
		{


            	@Override
            	public void invalidated(Observable o) 
            	{

            		if(searchField.textProperty().get().isEmpty()) {

                    table.setItems(data);

                    return;
                }

                ObservableList<Student> tableItems = FXCollections.observableArrayList();

                ObservableList<TableColumn<Student, ?>> cols = table.getColumns();

                for(int i=0; i<19; i++)
                {

                       for(int j=0; j<cols.size(); j++) 
                   {

                        TableColumn col = cols.get(j);

                        String cellValue = col.getCellData(data.get(i)).toString();

                        cellValue = cellValue.toLowerCase();

                        if(cellValue.contains(searchField.textProperty().get().toLowerCase())) 
                        {

                            tableItems.add(data.get(i));

                            break;

                        }                        
                        
                   }
                       


                }

                table.setItems(tableItems);

            }

        });
		HBox hb = new HBox();
		hb.getChildren().addAll(searchField,addnewsub);
		VBox vb = new VBox();
		vb.getChildren().addAll(table,hb);
		Scene scene2 = new Scene(vb,800,500);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
}
