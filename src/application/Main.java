package application;

// Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    // Stage and scene parameters
    @Override
    public void start(Stage primaryStage) {
    	
    	// The program will try to execute, the exception type will be printed if diagnosed
    	try {
    		
    		// Here the base of application is defined, the size and style of the window
    		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
    		Scene scene = new Scene(root, 450, 352);
    		scene.getStylesheets().add(getClass().getResource("Application.css").toExternalForm());
    		
    		// The stage will receive the scene and will be shown
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    		// Title
    		primaryStage.setTitle("Java Calculator");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // Main part of application
    public static void main(String[] args) {
    	
    	// The application is launched
    	launch(args);
    }
}
