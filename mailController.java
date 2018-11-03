import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import mailSender;

public class mailController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fromAddress;

    @FXML
    private TextField fromPassword;

    @FXML
    private TextField toAddress;

    @FXML
    private TextField subject;

    @FXML
    private TextArea message;

    @FXML
    private Button sendButton;

    @FXML
    void sendMessage(ActionEvent event) {
	//mailSender(fromAddress, fromPassword, toAddress, subject, message);
    }

    @FXML
    void initialize() {
        assert fromAddress != null : "fx:id=\"fromAddress\" was not injected: check your FXML file 'mailForm.fxml'.";
        assert fromPassword != null : "fx:id=\"fromPassword\" was not injected: check your FXML file 'mailForm.fxml'.";
        assert toAddress != null : "fx:id=\"toAddress\" was not injected: check your FXML file 'mailForm.fxml'.";
        assert subject != null : "fx:id=\"subject\" was not injected: check your FXML file 'mailForm.fxml'.";
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'mailForm.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'mailForm.fxml'.";

    }
}
