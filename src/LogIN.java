import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* Project Members: - Syed Mohamed Ariff 1426457
 * 					- Syafizal Hakimi 1413481
 * 					- Ahmad Hazim  1416735
 * 					- Azri Abdullah 1419547
 * 
 * Hello and welcome to KAHA TUITION MANAGEMENT SYSTEM!. We have developed a flexible system that allows staff to add subjects for the tuition centre and also
 * for the students! This is the main class where it will execute the login page! Also JavaFX is our choice here and it is very useful and intuitive!
 */
public class LogIN extends Application 
{
	Label lb_text;
	Button loginButton,cancelButton;
	Stage thestage;
	String[] StaffID = new String[]{"ariff20", "azri", "hazim","kimi"};
	String[] StaffPassword = new String[]{"syed", "irza", "mizah","imik"};
	public static void main(String[] args) 
	{
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception 
	{
		
		thestage=primaryStage;
		primaryStage.setTitle("KAHA TUITION MANAGEMENT SYSTEM");
		primaryStage.show();
		Image img = new Image("KAHA.jpg");
		ImageView imgview = new ImageView(img);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	    Text t = new Text();
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0f);
		t.setY(270.0f);
		t.setFill(Color.RED);
		t.setText("WELCOME TO KAHA TUITION MANAGEMENT SYSTEM");
		t.setFont(Font.font(null, FontWeight.BOLD, 32));
		Label label1 = new Label("User:");
		final TextField textField = new TextField ();
		textField.setPromptText("UserID");
		Label label2 = new Label("Password:");
		final PasswordField pb = new PasswordField();
		loginButton = new Button("Login");
		cancelButton = new Button("Cancel");
		loginButton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0)
					{
						boolean confirm = false;
						for(int i = 0;i<4;i++)
						{
							
							if (textField.getText().equals(StaffID[i]) && pb.getText().equals(StaffPassword[i]))
							{
								confirm = true;
								break;
							}
						}
						if (confirm)
							new ChooseStudent(primaryStage);
						else
							JOptionPane.showMessageDialog(null, "Wrong username or password");
					}
			
				});
		cancelButton.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0)
					{
						System.exit(0);
					}
				});
		
		HBox hb = new HBox();
		hb.getChildren().add(t);
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(label1, textField);
		hb1.setSpacing(50);
		HBox hb2 = new HBox();
     	hb2.getChildren().addAll(label2,pb);
	    hb2.setSpacing(23);
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(loginButton,cancelButton);
		hb3.setSpacing(40);
		VBox vb = new VBox();
		vb.getChildren().addAll(imgview,hb,hb1,hb2,hb3);
		Scene scene = new Scene(vb);
	        
		primaryStage.setScene(scene);
	}

}
