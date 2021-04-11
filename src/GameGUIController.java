import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GameGUIController {

    //Set starting location to Main Hall
    private String location = "Main Hall";

    public Mansion m = new Mansion();

    public Player p = new Player();

    @FXML
    private Button actionButton1;

    @FXML
    private Button actionButton2;

    @FXML
    private Button actionButton3;

    @FXML
    private Button actionButton4;

    @FXML
    private Text invSlot1;

    @FXML
    private Text invSlot2;

    @FXML
    private Text invSlot3;

    @FXML
    private Text invSlot4;

    @FXML
    private Text invSlot5;

    @FXML
    private Text invSlot6;

    @FXML
    private Text invSlot7;

    @FXML
    private Text invSlot8;

    @FXML
    private Text invSlot9;

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

    public void initialize() {
        exitButton1.managedProperty().bind(exitButton1.visibleProperty());
        exitButton2.managedProperty().bind(exitButton2.visibleProperty());
        exitButton3.managedProperty().bind(exitButton3.visibleProperty());
        exitButton4.managedProperty().bind(exitButton4.visibleProperty());
        invSlot1.managedProperty().bind(invSlot1.visibleProperty());
        invSlot2.managedProperty().bind(invSlot2.visibleProperty());
        invSlot3.managedProperty().bind(invSlot3.visibleProperty());
        invSlot4.managedProperty().bind(invSlot4.visibleProperty());
        invSlot5.managedProperty().bind(invSlot5.visibleProperty());
        invSlot6.managedProperty().bind(invSlot6.visibleProperty());
        invSlot7.managedProperty().bind(invSlot7.visibleProperty());
        invSlot8.managedProperty().bind(invSlot8.visibleProperty());
        invSlot9.managedProperty().bind(invSlot9.visibleProperty());
        invSlot1.setVisible(false);
        invSlot2.setVisible(false);
        invSlot3.setVisible(false);
        invSlot4.setVisible(false);
        invSlot5.setVisible(false);
        invSlot6.setVisible(false);
        invSlot7.setVisible(false);
        invSlot8.setVisible(false);
        invSlot9.setVisible(false);
        exitButton1.setText("Kitchen");
        exitButton2.setText("Library");
        exitButton3.setText("Bedroom");
        exitButton4.setText("Basement");
        textArea.setText(m.getRoom("Main Hall").getDesc());
        actionButton1.setText("Map");
        actionButton2.setText("Rusty Key");
        actionButton3.setText("Broken Glass");
        actionButton4.setVisible(false);
    }

    @FXML
    void exitButton1Pressed(ActionEvent event) {
        location = exitButton1.getText();
        textArea.setText(m.getRoom(location).getDesc());
        this.updateButtons();
    }

    @FXML
    void exitButton2Pressed(ActionEvent event) {
        location = exitButton2.getText();
        textArea.setText(m.getRoom(location).getDesc());
        this.updateButtons();
    }

    @FXML
    void exitButton3Pressed(ActionEvent event) {
        location = exitButton3.getText();
        textArea.setText(m.getRoom(location).getDesc());
        this.updateButtons();
    }

    @FXML
    void exitButton4Pressed(ActionEvent event) {
        location = exitButton4.getText();
        textArea.setText(m.getRoom(location).getDesc());
        this.updateButtons();
    }

    void updateButtons() {
        String[] array = m.getRoom(location).getExits();
        for(int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                switch (i) {
                    case 0:
                        exitButton1.setText(array[i]);
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

        ArrayList<Item> contents = m.getRoom(location).getContents();
        for(int i = 0; i < contents.size(); i++) {
            switch(i) {
                case 0:
                    actionButton1.setText(contents.get(i).getName());
                    break;
                case 1:
                    actionButton2.setText(contents.get(i).getName());
                    break;
                case 2:
                    actionButton3.setText(contents.get(i).getName());
                    break;
                case 3:
                    actionButton4.setText(contents.get(i).getName());
                    break;
            }
        }
        switch (contents.size()) {
            case 0:
                actionButton1.setVisible(false);
                actionButton2.setVisible(false);
                actionButton3.setVisible(false);
                actionButton4.setVisible(false);
                break;
            case 1:
                actionButton1.setVisible(true);
                actionButton2.setVisible(false);
                actionButton3.setVisible(false);
                actionButton4.setVisible(false);
                break;
            case 2:
                actionButton1.setVisible(true);
                actionButton2.setVisible(true);
                actionButton3.setVisible(false);
                actionButton4.setVisible(false);
                break;
            case 3:
                actionButton1.setVisible(true);
                actionButton2.setVisible(true);
                actionButton3.setVisible(true);
                actionButton4.setVisible(false);
                break;
            case 4:
                actionButton1.setVisible(true);
                actionButton2.setVisible(true);
                actionButton3.setVisible(true);
                actionButton4.setVisible(true);
                break;
        }
    }

    @FXML
    void actionButton1Pressed(ActionEvent event) {
        //Add an if here to check if button relates to an item or to an NPC
        //Find first empty inv slot -- Should be equal to Inventory size + 1
        switch(p.getInventory().size()) {
            case 0:
                invSlot1.setVisible(true);
                invSlot1.setText(actionButton1.getText());
                break;
            case 1:
                invSlot2.setVisible(true);
                invSlot2.setText(actionButton1.getText());
                break;
            case 2:
                invSlot3.setVisible(true);
                invSlot3.setText(actionButton1.getText());
                break;
            case 3:
                invSlot4.setVisible(true);
                invSlot4.setText(actionButton1.getText());
                break;
            case 4:
                invSlot5.setVisible(true);
                invSlot5.setText(actionButton1.getText());
                break;
            case 5:
                invSlot6.setVisible(true);
                invSlot6.setText(actionButton1.getText());
                break;
            case 6:
                invSlot7.setVisible(true);
                invSlot7.setText(actionButton1.getText());
                break;
            case 7:
                invSlot8.setVisible(true);
                invSlot8.setText(actionButton1.getText());
                break;
            case 8:
                invSlot9.setVisible(true);
                invSlot9.setText(actionButton1.getText());
                break;
        }

        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for(Item i: m.getRoom(location).getContents()) {
            if(i.getName().equalsIgnoreCase(actionButton1.getText())) {
                //Add item to player inventory
                p.addItem(i);
                //Remove item from room.contents
                toRemove = i;
            }
        }
        if(toRemove != null)
            m.getRoom(location).getContents().remove(toRemove);

        //Update Action buttons
        this.updateButtons();
    }

    @FXML
    void actionButton2Pressed(ActionEvent event) {
        //Add an if here to check if button relates to an item or to an NPC
        //Find first empty inv slot -- Should be equal to Inventory size + 1
        switch(p.getInventory().size()) {
            case 0:
                invSlot1.setVisible(true);
                invSlot1.setText(actionButton2.getText());
                break;
            case 1:
                invSlot2.setVisible(true);
                invSlot2.setText(actionButton2.getText());
                break;
            case 2:
                invSlot3.setVisible(true);
                invSlot3.setText(actionButton2.getText());
                break;
            case 3:
                invSlot4.setVisible(true);
                invSlot4.setText(actionButton2.getText());
                break;
            case 4:
                invSlot5.setVisible(true);
                invSlot5.setText(actionButton2.getText());
                break;
            case 5:
                invSlot6.setVisible(true);
                invSlot6.setText(actionButton2.getText());
                break;
            case 6:
                invSlot7.setVisible(true);
                invSlot7.setText(actionButton2.getText());
                break;
            case 7:
                invSlot8.setVisible(true);
                invSlot8.setText(actionButton2.getText());
                break;
            case 8:
                invSlot9.setVisible(true);
                invSlot9.setText(actionButton2.getText());
                break;
        }

        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for(Item i: m.getRoom(location).getContents()) {
            if(i.getName().equalsIgnoreCase(actionButton2.getText())) {
                //Add item to player inventory
                p.addItem(i);
                //Remove item from room.contents
                toRemove = i;
            }
        }
        if(toRemove != null)
            m.getRoom(location).getContents().remove(toRemove);

        //Update Action buttons
        this.updateButtons();
    }

    @FXML
    void actionButton3Pressed(ActionEvent event) {
        //Add an if here to check if button relates to an item or to an NPC
        //Find first empty inv slot -- Should be equal to Inventory size + 1
        switch(p.getInventory().size()) {
            case 0:
                invSlot1.setVisible(true);
                invSlot1.setText(actionButton3.getText());
                break;
            case 1:
                invSlot2.setVisible(true);
                invSlot2.setText(actionButton3.getText());
                break;
            case 2:
                invSlot3.setVisible(true);
                invSlot3.setText(actionButton3.getText());
                break;
            case 3:
                invSlot4.setVisible(true);
                invSlot4.setText(actionButton3.getText());
                break;
            case 4:
                invSlot5.setVisible(true);
                invSlot5.setText(actionButton3.getText());
                break;
            case 5:
                invSlot6.setVisible(true);
                invSlot6.setText(actionButton3.getText());
                break;
            case 6:
                invSlot7.setVisible(true);
                invSlot7.setText(actionButton3.getText());
                break;
            case 7:
                invSlot8.setVisible(true);
                invSlot8.setText(actionButton3.getText());
                break;
            case 8:
                invSlot9.setVisible(true);
                invSlot9.setText(actionButton3.getText());
                break;
        }

        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for(Item i: m.getRoom(location).getContents()) {
            if(i.getName().equalsIgnoreCase(actionButton3.getText())) {
                //Add item to player inventory
                p.addItem(i);
                //Remove item from room.contents
                toRemove = i;
            }
        }
        if(toRemove != null)
            m.getRoom(location).getContents().remove(toRemove);

        //Update Action buttons
        this.updateButtons();
    }

    @FXML
    void actionButton4Pressed(ActionEvent event) {
        //Add an if here to check if button relates to an item or to an NPC
        //Find first empty inv slot -- Should be equal to Inventory size + 1
        switch(p.getInventory().size()) {
            case 0:
                invSlot1.setVisible(true);
                invSlot1.setText(actionButton4.getText());
                break;
            case 1:
                invSlot2.setVisible(true);
                invSlot2.setText(actionButton4.getText());
                break;
            case 2:
                invSlot3.setVisible(true);
                invSlot3.setText(actionButton4.getText());
                break;
            case 3:
                invSlot4.setVisible(true);
                invSlot4.setText(actionButton4.getText());
                break;
            case 4:
                invSlot5.setVisible(true);
                invSlot5.setText(actionButton4.getText());
                break;
            case 5:
                invSlot6.setVisible(true);
                invSlot6.setText(actionButton4.getText());
                break;
            case 6:
                invSlot7.setVisible(true);
                invSlot7.setText(actionButton4.getText());
                break;
            case 7:
                invSlot8.setVisible(true);
                invSlot8.setText(actionButton4.getText());
                break;
            case 8:
                invSlot9.setVisible(true);
                invSlot9.setText(actionButton4.getText());
                break;
        }

        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for(Item i: m.getRoom(location).getContents()) {
            if(i.getName().equalsIgnoreCase(actionButton4.getText())) {
                //Add item to player inventory
                p.addItem(i);
                //Remove item from room.contents
                toRemove = i;
            }
        }
        if(toRemove != null)
            m.getRoom(location).getContents().remove(toRemove);

        //Update Action buttons
        this.updateButtons();
    }
}
