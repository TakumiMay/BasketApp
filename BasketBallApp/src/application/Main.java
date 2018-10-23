package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {		
		Parent root = FXMLLoader.load(getClass().getResource("/views/Screen1.fxml"));
		Scene scene = new Scene(root);		
		primaryStage.setScene(scene);
//		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
