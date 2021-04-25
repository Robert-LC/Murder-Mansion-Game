import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreenController {

    @FXML
    private Button newGameButton;

    @FXML
    void newGamePressed(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameGUI.fxml"));
        Parent root = loader.load();
        secondStage.setTitle("Murder Mansion");
        secondStage.setScene(new Scene(root));
        secondStage.show();
        secondStage.setResizable(false); //Makes it so it cant be resized so user cant see the bad
        Stage thisWindow = (Stage) newGameButton.getScene().getWindow();
        thisWindow.close();
    }

}
