package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button sendMessage;

    @FXML
    private Button deleteMessage;

    @FXML
    private TextArea generalTextArea;

    @FXML
    private TextField myTextField;

    @FXML
    public void deleteMessage() {
        myTextField.clear();
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        generalTextArea.appendText(System.getProperty("user.name") + ": " + myTextField.getText()+"\n");
        myTextField.clear();
        myTextField.requestFocus();
    }



}
