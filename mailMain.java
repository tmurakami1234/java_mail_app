import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mailMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
	String fxmlResource = "mailForm.fxml";
	FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlResource));
	Parent panel = loader.load();
	Scene scene = new Scene(panel);
	Stage stage = new Stage();
	stage.setScene(scene);
	stage.show();
    }
}
