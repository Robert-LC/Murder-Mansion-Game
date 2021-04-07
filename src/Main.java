import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Mansion m = new Mansion();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameGUI.fxml"));
        loader.setControllerFactory(GameGUIController -> new GameGUIController(m));
        Parent root = loader.load();
        primaryStage.setTitle("Murder Mansion");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
