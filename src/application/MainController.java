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

    @FXML // This variable is the whole window of the program
    private AnchorPane window;

    @FXML // This variable is the information screen of the program
    private Label screen;

    @FXML // This variable is the panel where the buttons will be
    private Pane keys;

    @FXML // These variables are a part of all the buttons in the panel
    private Button zero, one, two, three, four, five, six, seven, eight, nine, dot;

    @FXML // 
    private Button percent, division, multiplication, subtraction, addition, equal, backstep, clear;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Key actions events, key event equal to X (button value), and adding X to the screen variable
        // Key equal '0', and add '0' to screen variable
        if (event.getSource() == zero) {
            screen.setText(screen.getText() + "0");
        }
        // Key equal '1', and add '1' to screen variable
        else if (event.getSource() == one) {
            screen.setText(screen.getText() + "1");
        }
        // Key equal '2', and add '2' to screen variable
        else if (event.getSource() == two) {
            screen.setText(screen.getText() + "2");
        }
        // Key equal '3', and add '3' to screen variable
        else if (event.getSource() == three) {
            screen.setText(screen.getText() + "3");
        }
        // Key equal '4', and add '4' to screen variable
        else if (event.getSource() == four) {
            screen.setText(screen.getText() + "4");
        }
        // Key equal '5', and add '5' to screen variable
        else if (event.getSource() == five) {
            screen.setText(screen.getText() + "5");
        }
        // Key equal '6', and add '6' to screen variable
        else if (event.getSource() == six) {
            screen.setText(screen.getText() + "6");
        }
        // Key equal '7', and add '7' to screen variable
        else if (event.getSource() == seven) {
            screen.setText(screen.getText() + "7");
        }
        // Key equal '8', and add '8' to screen variable
        else if (event.getSource() == eight) {
            screen.setText(screen.getText() + "8");
        }
        // Key equal '9', and add '9' to screen variable
        else if (event.getSource() == nine) {
            screen.setText(screen.getText() + "9");
        }
        // Key equal '.', and add '.' to screen variable with specific changes
        else if (event.getSource() == dot) {
            if (screen.getText() == "" || screen.getText().indexOf(".") != -1) {
                ;
            } else {
                screen.setText(screen.getText() + ".");
            }
        }
        // Key equal 'C', clear screen variable
        else if (event.getSource() == clear) {
            screen.setText("");
        }
        // Key equal '<-', clears the last character of the screen variable
        else if (event.getSource() == backstep) {
            if (screen.getText() == "" || screen.getText().length() == 0) {
                ;
            } else {
                String digits = String.valueOf(screen.getText());
                digits = digits.substring(0, digits.length() - 1);
                screen.setText(digits);
            }
        }
        // For operators: +, -, *, / and %. previousValue variable receives the screen variable
        // Operation variable receives 2 (for switch-case) and clears screen variable
        else if (event.getSource() == addition) {
            if (screen.getText() == "") {
                ;
            } else {
                previousValue = Float.parseFloat(screen.getText());
                operation = 2;
                screen.setText("");
            }
        }
        // Operation variable receives 3 (for switch-case) and clears screen variable
        else if (event.getSource() == subtraction) {
            if (screen.getText() == "") {
                ;
            } else {
                previousValue = Float.parseFloat(screen.getText());
                operation = 3;
                screen.setText("");
            }
        }
        // Operation variable receives 4 (for switch-case) and clears screen variable
        else if (event.getSource() == multiplication) {
            if (screen.getText() == "") {
                ;
            } else {
                previousValue = Float.parseFloat(screen.getText());
                operation = 4;
                screen.setText("");
            }
        }
        // Operation variable receives 5 (for switch-case) and clears screen variable
        else if (event.getSource() == division) {
            if (screen.getText() == "") {
                ;
            } else {
                previousValue = Float.parseFloat(screen.getText());
                operation = 5;
                screen.setText("");
            }
        }
        // Operation variable receives 6 (for switch-case) and clears screen variable
        else if (event.getSource() == percent) {
            if (screen.getText() == "") {
                ;
            } else {
                previousValue = Float.parseFloat(screen.getText());
                operation = 6;
                screen.setText("");
            }
        }
        // Key equal '=', currentValue variable receives the screen variable
        // According to the value of the operation variable, the calculation is made
        // with variables: previousValue and currentValue
        else if (event.getSource() == equal) {
            if (screen.getText() == "") {
                ;
            } else {
                Float currentValue = Float.parseFloat(screen.getText());
                switch (operation) {
                    case 1:
                        previousValue = 0f;
                    case 2: // Value of operation variable regarding Addition
                        addition(previousValue, currentValue);
                        break;
                    case 3: // Value of operation variable regarding Subtraction
                        subtraction(previousValue, currentValue);
                        break;
                    case 4: // Value of operation variable regarding Multiplication
                        multiplication(previousValue, currentValue);
                        break;
                    case 5: // Value of operation variable regarding Division
                        division(previousValue, currentValue);
                        break;
                    case 6: // Value of operation variable regarding Percentage
                        percentage(previousValue, currentValue);
                        break;
                }
            }
        }
    }

    // Function that checks whether the result can be converted to an integer and remains the same
    private void verificationValue(Float answerVerification) {
        if (answerVerification == answerVerification.intValue()) {
            screen.setText(String.valueOf(answerVerification.intValue()));
        }
        else {
            screen.setText(String.valueOf(answerVerification));
        }
        operation = 1;
    }

    // Function that performs addition calculation and calls the result verification function
    private void addition(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand + secondOperand;
        verificationValue(answer);
    }

    // Function that performs subtraction calculation and calls the result verification function
    private void subtraction(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand - secondOperand;
        verificationValue(answer);
    }

    // Function that performs multiplication calculation and calls the result verification function
    private void multiplication(Float firstOperand, Float secondOperand) {
        Float answer = firstOperand * secondOperand;
        verificationValue(answer);
    }

    // Function that performs division calculation and calls the result verification function
    private void division(Float firstOperand, Float secondOperand) {
        Float answer = 0f;
        try {
            answer = firstOperand / secondOperand;
        } catch (Exception exception) {
            screen.setText("Error");
        }
        verificationValue(answer);
    }

    // Function that performs percentage calculation and calls the result verification function
    private void percentage(Float firstOperand, Float secondOperand) {
        Float answer = (firstOperand * secondOperand) / 100;
        verificationValue(answer);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
