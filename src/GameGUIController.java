import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameGUIController
{

    //Set starting location to Main Hall
    private String location = "Main Hall";

    public Mansion m = new Mansion();

    public Player p = new Player();

    public int turn;

    int buttonClicked = -1;

    int actionButtonClicked = -1;

    @FXML
    private Button actionButton1;

    @FXML
    private Button actionButton2;

    @FXML
    private Button actionButton3;

    @FXML
    private Button actionButton4;

    @FXML
    private Button talkButton;

    @FXML
    private Button guessCluesButton;

    @FXML
    private Button nevermindButton;

    @FXML
    private Button quitTalkButton;

    @FXML
    private Button questionButton;

    @FXML
    private Button guessCulpritButton;

    @FXML
    private Button notepadButton;

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
    private Text turnNumText;

    @FXML
    private TextArea textArea;

    @FXML
    private Button contextButton1;

    @FXML
    private Button contextButton2;

    @FXML
    private Button exitButton1;

    @FXML
    private Button exitButton2;

    @FXML
    private Button exitButton3;

    @FXML
    private Button exitButton4;

    @FXML
    private AnchorPane chooseSuspectPane;

    @FXML
    private AnchorPane chooseCluePane;

    @FXML
    private Button exitGuessButton;

    @FXML
    private Button accuseButlerButton;

    @FXML
    private Button accuseFatherButton;

    @FXML
    private Button accuseChefButton;

    @FXML
    private Button accuseGardenerButton;

    @FXML
    private Button accuseSonButton;

    @FXML
    private Button accuseLibrarianButton;

    @FXML
    private Button accuseDaughterButton;

    @FXML
    private Button accuseMotherButton;


    @FXML
    private Button clue1Button;

    @FXML
    private Button clue5Button;

    @FXML
    private Button clue2Button;

    @FXML
    private Button clue6Button;

    @FXML
    private Button clue3Button;

    @FXML
    private Button clue7Button;

    @FXML
    private Button clue4Button;

    @FXML
    private Button clue8Button;

    @FXML
    private Button exitGuessButton2;


    public void initialize()
    {
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
        talkButton.managedProperty().bind(talkButton.visibleProperty());
        quitTalkButton.managedProperty().bind(quitTalkButton.visibleProperty());
        guessCulpritButton.managedProperty().bind(guessCulpritButton.visibleProperty());
        guessCluesButton.managedProperty().bind(guessCluesButton.visibleProperty());
        nevermindButton.managedProperty().bind(nevermindButton.visibleProperty());
        questionButton.managedProperty().bind(questionButton.visibleProperty());
        contextButton1.managedProperty().bind(contextButton1.visibleProperty());
        contextButton2.managedProperty().bind(contextButton2.visibleProperty());
        invSlot1.setVisible(false);
        invSlot2.setVisible(false);
        invSlot3.setVisible(false);
        invSlot4.setVisible(false);
        invSlot5.setVisible(false);
        invSlot6.setVisible(false);
        invSlot7.setVisible(false);
        invSlot8.setVisible(false);
        invSlot9.setVisible(false);
        chooseSuspectPane.setVisible(false);
        chooseCluePane.setVisible(false);
        quitTalkButton.setVisible(false);
        questionButton.setVisible(false);
        contextButton1.setVisible(false);
        contextButton2.setVisible(false);
        guessCluesButton.setVisible(false);
        nevermindButton.setVisible(false);
        exitButton1.setText("Kitchen");
        exitButton2.setText("Library");
        exitButton3.setText("Bedroom");
        exitButton4.setText("Basement");
        textArea.setText(m.getRoom("Main Hall").getDesc());
        actionButton1.setText("Map");
        actionButton2.setText("Rusty Key");
        actionButton3.setText("Broken Glass");
        actionButton4.setVisible(false);
        turn = 1;
        this.updateButtons(); //needs to be called so greet button will work on Butler Billy.
    }

    @FXML
    void notepadButtonPressed(ActionEvent event) throws IOException
    {
        Stage thirdStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotepadScreen.fxml"));
        Parent root = loader.load();
        thirdStage.setTitle("Murder Mansion - Notepad");
        thirdStage.setScene(new Scene(root));
        thirdStage.show();
    }

    @FXML
    void exitButton1Pressed(ActionEvent event)
    {
        turn++;
        location = exitButton1.getText();
        textArea.setText(m.getRoom(location).getDesc());
        p.setLocation(location);
        this.updateButtons();
    }

    @FXML
    void exitButton2Pressed(ActionEvent event)
    {
        turn++;
        location = exitButton2.getText();
        textArea.setText(m.getRoom(location).getDesc());
        p.setLocation(location);
        this.updateButtons();
    }

    @FXML
    void exitButton3Pressed(ActionEvent event)
    {
        turn++;
        location = exitButton3.getText();
        textArea.setText(m.getRoom(location).getDesc());
        p.setLocation(location);
        this.updateButtons();
    }

    @FXML
    void exitButton4Pressed(ActionEvent event)
    {
        turn++;
        location = exitButton4.getText();
        textArea.setText(m.getRoom(location).getDesc());
        p.setLocation(location);
        this.updateButtons();
    }

    void updateButtons()
    {
        turnNumText.setText("Turn: " + turn);
        talkButton.setText("Greet " + m.getRoom(p.getLocation()).getSuspects().get(0).getName());
        if (!p.getLocation().equalsIgnoreCase("main hall"))
        {
            guessCulpritButton.setVisible(false);
        } else
        {
            guessCulpritButton.setVisible(true);
        }
        String[] array = m.getRoom(location).getExits();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                switch (i)
                {
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
        if (array.length == 4)
        {
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(true);
        }
        if (array.length == 3)
        {
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(false);
        }
        if (array.length == 2)
        {
            exitButton2.setVisible(true);
            exitButton3.setVisible(false);
            exitButton4.setVisible(false);
        }
        if (array.length == 1)
        {
            exitButton2.setVisible(false);
            exitButton3.setVisible(false);
            exitButton4.setVisible(false);
        }

        ArrayList<Item> contents = m.getRoom(location).getContents();
        for (int i = 0; i < contents.size(); i++)
        {
            switch (i)
            {
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
        switch (contents.size())
        {
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
        contextButton1.setVisible(false);
        contextButton2.setVisible(false);
    }

    @FXML
    void contextButton1Pressed(ActionEvent event)
    {
        if (contextButton1.getText().equalsIgnoreCase("Yes"))
        {
            buttonClicked = 1;
            this.itemHandler(actionButtonClicked);
            enableAllButtons();
        }
    }

    @FXML
    void contextButton2Pressed(ActionEvent event)
    {
        if (contextButton2.getText().equalsIgnoreCase("No"))
        {
            buttonClicked = 2;
            this.itemHandler(actionButtonClicked);
            enableAllButtons();
        }
    }

    void itemHandler(int button)
    {
        //take this logic, duplicate 4 times once for each button
        if (actionButtonClicked == 1)
        {
            Item toRemove = null;
            for (Item i : m.getRoom(location).getContents())
            {
                if (i.getName().equalsIgnoreCase(actionButton1.getText()))
                {
                    //Add item to player inventory
                    p.addItem(i);
                    toRemove = i;
                }
            }
            if (buttonClicked == 1)
            {
                //Find first empty inv slot -- Should be equal to Inventory size + 1
                switch (p.getInventory().size())
                {
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

                if (toRemove != null)
                    m.getRoom(location).getContents().remove(toRemove);

                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            } else if (buttonClicked == 2)
            {
                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            }
        } else if (actionButtonClicked == 2)
        {
            Item toRemove = null;
            for (Item i : m.getRoom(location).getContents())
            {
                if (i.getName().equalsIgnoreCase(actionButton2.getText()))
                {
                    //Add item to player inventory
                    p.addItem(i);
                    toRemove = i;
                }
            }
            if (buttonClicked == 1)
            {
                //Find first empty inv slot -- Should be equal to Inventory size + 1
                switch (p.getInventory().size())
                {
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

                if (toRemove != null)
                    m.getRoom(location).getContents().remove(toRemove);

                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            } else if (buttonClicked == 2)
            {
                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            }
        } else if (actionButtonClicked == 3)
        {
            Item toRemove = null;
            for (Item i : m.getRoom(location).getContents())
            {
                if (i.getName().equalsIgnoreCase(actionButton3.getText()))
                {
                    //Add item to player inventory
                    p.addItem(i);
                    toRemove = i;
                }
            }
            if (buttonClicked == 1)
            {
                switch (p.getInventory().size())
                {
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

                if (toRemove != null)
                    m.getRoom(location).getContents().remove(toRemove);

                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            } else if (buttonClicked == 2)
            {
                exitButton1.setVisible(true);
                exitButton2.setVisible(true);
                exitButton3.setVisible(true);
                exitButton4.setVisible(true);
                contextButton1.setVisible(false);
                contextButton2.setVisible(false);
                textArea.setText(m.getRoom(location).getDesc());
                this.updateButtons();
                buttonClicked = -1;
            }
        }
    }

    @FXML
    void actionButton1Pressed(ActionEvent event)
    {
        //Add an if here to check if button relates to an item or to an NPC
        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(actionButton1.getText()))
            {
                toRemove = i;
            }
        }
        actionButtonClicked = 1;
        displayItemPrompt(toRemove);
    }

    @FXML
    void actionButton2Pressed(ActionEvent event)
    {
        //Add an if here to check if button relates to an item or to an NPC
        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(actionButton2.getText()))
            {
                toRemove = i;
            }
        }
        actionButtonClicked = 2;
        displayItemPrompt(toRemove);
    }

    @FXML
    void actionButton3Pressed(ActionEvent event)
    {
        //Add an if here to check if button relates to an item or to an NPC
        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(actionButton3.getText()))
            {
                toRemove = i;
            }
        }
        actionButtonClicked = 3;
        displayItemPrompt(toRemove);
    }

    private void displayItemPrompt(Item toRemove)
    {
        textArea.setText(toRemove.getDescription() + "\n\nDo you want to take the item?");
        exitButton1.setVisible(false);
        exitButton2.setVisible(false);
        exitButton3.setVisible(false);
        exitButton4.setVisible(false);
        contextButton1.setText("Yes");
        contextButton2.setText("No");
        contextButton1.setVisible(true);
        contextButton2.setVisible(true);
        disableAllButtons();
    }

    @FXML
    void actionButton4Pressed(ActionEvent event)
    {
        //Add an if here to check if button relates to an item or to an NPC
        //Find first empty inv slot -- Should be equal to Inventory size + 1
        switch (p.getInventory().size())
        {
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
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(actionButton4.getText()))
            {
                //Add item to player inventory
                p.addItem(i);
                //Remove item from room.contents
                toRemove = i;
            }
        }
        if (toRemove != null)
            m.getRoom(location).getContents().remove(toRemove);

        //Update Action buttons
        this.updateButtons();
    }

    @FXML
    void talkButtonPressed(ActionEvent event)
    {
        //Return dialogue to screen
        textArea.setText(Dialogue.greet(m.getRoom(location).getSuspects().get(0)));
        //Disable other buttons to prevent problems
        disableAllButtons();
        guessCulpritButton.setVisible(false); //make the endGame button invisible to make room for the talking options.

        // If the user has greeted them 6 times do not re-enable the question button.
        if (m.getRoom(location).getSuspects().get(0).getGreetedCounter() <= 6)
        {
            questionButton.setVisible(true);
        } else
        {
            questionButton.setVisible(false);
        }

        quitTalkButton.setVisible(true);
        turn++;
        updateButtons();
        guessCulpritButton.setVisible(false);
    }

    @FXML
    void questionButtonPressed(ActionEvent event)
    {
        //Return question answer from suspect to screen
        textArea.setText(Dialogue.question(m.getRoom(location).getSuspects().get(0), m));

        //Disable other buttons to prevent problems
        disableAllButtons();

        talkButton.setDisable(true);
        questionButton.setDisable(true);
    }


    @FXML
    void quitTalkButtonPressed(ActionEvent event)
    {
        //Return room description to screen
        textArea.setText(m.getRoom(location).getDesc());

        //Re-enable navigation and action buttons
        enableAllButtons();

        questionButton.setDisable(false);
        questionButton.setVisible(false);
        quitTalkButton.setVisible(false);
        guessCulpritButton.setVisible(true);
        this.updateButtons();
    }

    @FXML
    void guessCulpritButtonPressed(ActionEvent event)
    {
        disableAllButtons();
        chooseSuspectPane.setVisible(true);
        showSuspectButtons();
        enableAllSuspectButtons();
        textArea.setText("Greetings Detective, I appreciate you meeting with me. So who did it, and what clues indite them?");
    }

    //Inside method used to disable most buttons except for a select few.
    void enableAllButtons()
    {
        actionButton1.setDisable(false);
        actionButton2.setDisable(false);
        actionButton3.setDisable(false);
        actionButton4.setDisable(false);
        exitButton1.setDisable(false);
        exitButton2.setDisable(false);
        exitButton3.setDisable(false);
        exitButton4.setDisable(false);
        talkButton.setDisable(false);
        guessCulpritButton.setDisable(false);
    }

    void disableAllButtons()
    {
        actionButton1.setDisable(true);
        actionButton2.setDisable(true);
        actionButton3.setDisable(true);
        actionButton4.setDisable(true);
        exitButton1.setDisable(true);
        exitButton2.setDisable(true);
        exitButton3.setDisable(true);
        exitButton4.setDisable(true);
        talkButton.setDisable(true);
        guessCulpritButton.setDisable(true);
    }

    void disableAllSuspectButtons()//Only disables the buttons on CulpritGuess
    {
        accuseButlerButton.setDisable(true);
        accuseChefButton.setDisable(true);
        accuseFatherButton.setDisable(true);
        accuseGardenerButton.setDisable(true);
        accuseDaughterButton.setDisable(true);
        accuseMotherButton.setDisable(true);
        accuseLibrarianButton.setDisable(true);
        accuseSonButton.setDisable(true);
        exitGuessButton.setDisable(true);
    }

    void enableAllSuspectButtons()//Enables the buttons on CulpritGuess
    {
        accuseButlerButton.setDisable(false);
        accuseChefButton.setDisable(false);
        accuseFatherButton.setDisable(false);
        accuseGardenerButton.setDisable(false);
        accuseDaughterButton.setDisable(false);
        accuseMotherButton.setDisable(false);
        accuseLibrarianButton.setDisable(false);
        accuseSonButton.setDisable(false);
        exitGuessButton.setDisable(false);
    }

    @FXML
    void accuseButlerButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Butler is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
    }

    @FXML
    void accuseChefButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Chef is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        ;
    }

    @FXML
    void accuseSonButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Son is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        ;
    }

    @FXML
    void accuseDaughterButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Daughter is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        ;
    }

    @FXML
    void accuseFatherButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Father is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        ;
    }

    @FXML
    void accuseGardenerButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Gardener is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
    }

    @FXML
    void accuseLibrarianButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Librarian is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
    }

    @FXML
    void accuseMotherButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Mother is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
    }

    @FXML
    void exitGuessButtonPressed(ActionEvent event)
    {
        enableAllButtons();
        chooseSuspectPane.setVisible(false);
        textArea.setText(m.getRoom(location).getDesc());
        guessCluesButton.setVisible(false);
        nevermindButton.setVisible(false);
        updateButtons();
    }


    @FXML
    void guessCluesButtonPressed(ActionEvent event)
    {
        hideSuspectButtons();
        nevermindButton.setDisable(false);
        exitGuessButton.setDisable(false);
        exitGuessButton.setVisible(false);
        guessCluesButton.setVisible(false);
        nevermindButton.setVisible(false);
        chooseCluePane.setVisible(true);
        textArea.setText("Ok, so what clue proves it was them?");
    }

    @FXML
    void nevermindButtonPressed(ActionEvent event)
    {
        enableAllSuspectButtons();
        nevermindButton.setVisible(false);
        guessCluesButton.setVisible(false);
        exitButton1.setVisible(true);
        exitButton2.setVisible(true);
        exitButton3.setVisible(true);
        exitButton4.setVisible(true);
        textArea.setText("Ok, then who was it?");
    }

    @FXML
    void hideSuspectButtons()
    {
        accuseButlerButton.setVisible(false);
        accuseChefButton.setVisible(false);
        accuseFatherButton.setVisible(false);
        accuseGardenerButton.setVisible(false);
        accuseDaughterButton.setVisible(false);
        accuseMotherButton.setVisible(false);
        accuseLibrarianButton.setVisible(false);
        accuseSonButton.setVisible(false);
    }

    @FXML
    void showSuspectButtons()
    {
        accuseButlerButton.setVisible(true);
        accuseChefButton.setVisible(true);
        accuseFatherButton.setVisible(true);
        accuseGardenerButton.setVisible(true);
        accuseDaughterButton.setVisible(true);
        accuseMotherButton.setVisible(true);
        accuseLibrarianButton.setVisible(true);
        accuseSonButton.setVisible(true);
    }


    @FXML
    void confirmCulpritChoice() //Helper method to enable the Yes and No Buttons
    {
        exitButton1.setVisible(false);
        exitButton2.setVisible(false);
        exitButton3.setVisible(false);
        exitButton4.setVisible(false);
        guessCluesButton.setVisible(true);
        nevermindButton.setVisible(true);
        guessCluesButton.setText("Choose Clues");
        nevermindButton.setText("Never mind, I think it was someone else.");
    }

    @FXML
    void clue1ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue2ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue3ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue4ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue5ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue6ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue7ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void clue8ButtonPressed(ActionEvent event)
    {

    }

    @FXML
    void exitGuessButton2Pressed(ActionEvent event)
    {
        enableAllButtons();
        chooseCluePane.setVisible(false);
        textArea.setText(m.getRoom(location).getDesc());
        exitGuessButton.setVisible(true);
        chooseSuspectPane.setVisible(false);
        guessCluesButton.setVisible(false);
        nevermindButton.setVisible(false);
        updateButtons();
    }

}