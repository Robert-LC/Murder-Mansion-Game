import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotepadTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotepadScreen.fxml"));
        loader.setControllerFactory(NotepadScreenController -> new NotepadScreenController());
        Parent root = loader.load();
        primaryStage.setTitle("Murder Mansion");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
