import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameGUIController {

    //Set starting location to Main Hall
    private String location = "Main Hall";

    public Mansion m;

    public GameGUIController(Mansion m) {
        this.m=m;
    }

    @FXML
    private TextArea textArea;

    @FXML
    private Button exitButton1;

    @FXML
    private Button exitButton2;

    @FXML
    private Button exitButton3;

    @FXML
    private Button exitButton4;

    void displayText(Player p, Mansion m) {
        System.out.println(m.getRoom(p.location).getDesc());
    }

    public void initialize() {
        exitButton1.managedProperty().bind(exitButton1.visibleProperty());
        exitButton2.managedProperty().bind(exitButton2.visibleProperty());
        exitButton3.managedProperty().bind(exitButton3.visibleProperty());
        exitButton4.managedProperty().bind(exitButton4.visibleProperty());
        exitButton1.setText("Bedroom");
        exitButton2.setText("Kitchen");
        exitButton3.setText("Library");
        exitButton4.setText("Basement");
        textArea.setText(m.getRoom("Main Hall").getDesc());
    }

    @FXML
    void exitButton1Pressed(ActionEvent event) {
        location = exitButton1.getText();
        textArea.setText(m.getRoom(location).getDesc());
        exitButton1.setText(m.getRoom(location).getExits()[0]);
        this.updateButtons(m.getRoom(location).getExits());
    }

    @FXML
    void exitButton2Pressed(ActionEvent event) {
        location = exitButton2.getText();
        textArea.setText(m.getRoom(location).getDesc());
        exitButton1.setText(m.getRoom(location).getExits()[0]);
        this.updateButtons(m.getRoom(location).getExits());
    }

    @FXML
    void exitButton3Pressed(ActionEvent event) {
        location = exitButton3.getText();
        textArea.setText(m.getRoom(location).getDesc());
        exitButton1.setText(m.getRoom(location).getExits()[0]);
        this.updateButtons(m.getRoom(location).getExits());
    }

    @FXML
    void exitButton4Pressed(ActionEvent event) {
        location = exitButton4.getText();
        textArea.setText(m.getRoom(location).getDesc());
        exitButton1.setText(m.getRoom(location).getExits()[0]);
        this.updateButtons(m.getRoom(location).getExits());
    }

    void updateButtons(String[] array) {
        for(int i = 1; i < array.length; i++) {
            if(array[i] != null) {
                switch (i) {
                    case 1:
                        exitButton2.setText(array[i]);
                        break;
                    case 2:
                        exitButton3.setText(array[i]);
                        break;
                    case 3:
                        exitButton4.setText(array[i]);
                        break;
                }
            }
        }
        if(array.length == 4) {
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(true);
        }
        if(array.length == 3) {
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(false);
        }
        if(array.length == 2) {
            exitButton2.setVisible(true);
            exitButton3.setVisible(false);
            exitButton4.setVisible(false);
        }
        if(array.length == 1) {
            exitButton2.setVisible(false);
            exitButton3.setVisible(false);
            exitButton4.setVisible(false);
        }
    }
}
