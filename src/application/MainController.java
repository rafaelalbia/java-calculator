package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class MainController {

    Float previousValue = 0f;
    int operation = 1;

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
        else if(event.getSource() == dot) {
            screen.setText(screen.getText() + ".");
        }
        else if(event.getSource() == clear) {
            screen.setText("");
        }
        else if(event.getSource() == backstep) {
            String digits = String.valueOf(screen.getText());
            int lastIndex = digits.length() - 1;
            digits = digits.replaceFirst(String.valueOf(digits.charAt(lastIndex)), "");
            screen.setText(digits);
        }
        else if(event.getSource() == addition) {
            previousValue = Float.parseFloat(screen.getText());
            operation = 2; // Addition
            screen.setText("");
        }
        else if(event.getSource() == subtraction) {
            previousValue = Float.parseFloat(screen.getText());
            operation = 3; // Subtraction
            screen.setText("");
        }
        else if(event.getSource() == multiplication) {
            previousValue = Float.parseFloat(screen.getText());
            operation = 4; // Multiplication
            screen.setText("");
        }
        else if(event.getSource() == division) {
            previousValue = Float.parseFloat(screen.getText());
            operation = 5; // Division
            screen.setText("");
        }
        else if(event.getSource() == percent) {
            previousValue = Float.parseFloat(screen.getText());
            operation = 6; // Percentage
            screen.setText("");
        }
        else if(event.getSource() == equal) {
            Float currentValue = Float.parseFloat(screen.getText());
            switch(operation) {
                case 1:
                    previousValue = 0f;
                case 2: // Addition
                    addition(previousValue, currentValue);
                    break;
                case 3: // Subtraction
                    subtraction(previousValue, currentValue);
                    break;
                case 4: // Multiplication
                    multiplication(previousValue, currentValue);
                    break;
                case 5: // Division
                    division(previousValue, currentValue);
                    break;
                case 6:
                    percentage(previousValue, currentValue);
                    break;
            }
        }
    }
    
    private void verificationValue(Float answerVerification) {
        if (answerVerification == answerVerification.intValue()) {
            screen.setText(String.valueOf(answerVerification.intValue()));
        }
        else {
            screen.setText(String.valueOf(answerVerification));
        }
        operation = 1;
    }

    private void addition(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand + secondOperand;
        verificationValue(answer);
    }

    private void subtraction(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand - secondOperand;
        verificationValue(answer);
    }

    private void multiplication(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand * secondOperand;
        verificationValue(answer);
    }

    private void division(Float firstOperand, Float secondOperand) {
        Float answer = 0f;
        try {
            answer = firstOperand / secondOperand;
        } catch (Exception exception) {
            screen.setText("Error");
        }
        verificationValue(answer);
    }

    private void percentage(Float firstOperand, Float secondOperand) {
        Float answer = (firstOperand * secondOperand) / 100;
        verificationValue(answer);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}