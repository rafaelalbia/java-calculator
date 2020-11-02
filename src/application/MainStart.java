package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStart extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainController.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Application.css").toExternalForm());

            primaryStage.setTitle("Java Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
