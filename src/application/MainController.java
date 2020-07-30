package application;

// Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	// Display
	@FXML
	private Label result;
	
	// Numeric buttons
	@FXML
	private Button one, two, three, four, five, six, seven, eight, nine;
	
	// Operation buttons
	@FXML
	private Button equal, plus, minus, multiply, divide, dot, c, ce, backstep;
	
	public void peformCalculation(ActionEvent event) {
		
	}
}
