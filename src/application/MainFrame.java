package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class MainFrame {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private AnchorPane window;

    @FXML
    private Label screen;

    @FXML
    private Pane keys;

    @FXML
    private Button zero, one, two, three, four, five, six, seven, eight, nine, dot;

    @FXML
    private Button percent, division, multiplication, subtraction, addition, equal, backstep, clear;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == zero) {
            screen.setText(screen.getText() + "0");
        }
        else if(event.getSource() == one) {
            screen.setText(screen.getText() + "1");
        }
        else if(event.getSource() == two) {
            screen.setText(screen.getText() + "2");
        }
        else if(event.getSource() == three) {
            screen.setText(screen.getText() + "3");
        }
        else if(event.getSource() == four) {
            screen.setText(screen.getText() + "4");
        }
        else if(event.getSource() == five) {
            screen.setText(screen.getText() + "5");
        }
        else if(event.getSource() == six) {
            screen.setText(screen.getText() + "6");
        }
        else if(event.getSource() == seven) {
            screen.setText(screen.getText() + "7");
        }
        else if(event.getSource() == eight) {
            screen.setText(screen.getText() + "8");
        }
        else if(event.getSource() == nine) {
            screen.setText(screen.getText() + "9");
        }
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}