/**
 * ======================================================================
 * File Name: GameGUIController.java
 * Project Name: Final Game Project
 * ======================================================================
 * Creators: Primary Author: Sam Compson
 * Would not have finished without great contributions from all the rest of Group 1
 * Date Created:
 * Course: CSCI-1260-942
 * ======================================================================
 */

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

/**
 * Controller class for the GameGUI.fxml file.
 *
 * @since 04/24/2021
 */
public class GameGUIController
{

    //Set starting location to Main Hall
    private String location = "Main Hall";

    public Suspect accused = new Suspect();

    public Mansion m = new Mansion();

    public Player p = new Player();

    public int turn;

    private boolean firstGuess;

    //Usage explained below
    int buttonClicked = -1;

    @FXML
    private Button newGameButton;

    @FXML
    private Button actionButton1;

    @FXML
    private Button actionButton2;

    @FXML
    private Button actionButton3;


    public Button actionButtonClicked;

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
    private Text invSlot10;

    @FXML
    private Text invSlot11;

    @FXML
    private Text invSlot12;

    @FXML
    private Text invSlot13;

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

    private Stage notepadStage;

    //Array of all exit buttons
    public Button[] exitButtonArray;

    //Array of all inv buttons
    public Text[] invSlots;

    //Array of action buttons
    public Button[] actionButtons;

    /**
     * Sets up the gui objects so empty inventory spots won't be showing and sets up the visable exits and other buttons
     */
    public void initialize()
    {
        /**
         * The command b.managedProperty().bind(b.visibleProperty()); makes it so that whatever boolean value is in
         * visible property, managedProperty also becomes that value. What managed property does is it tells the GUI
         * whether or not a button should be considered when formatting other GUI elements. So by binding the values
         * I am telling the GUI that when I make a button invisible remove it from formatting, this allows the other
         * elements to reposition nicely in the GUI.
         */
        exitButtonArray = new Button[]{this.exitButton1, this.exitButton2, this.exitButton3, this.exitButton4};
        for(Button b: exitButtonArray)
            b.managedProperty().bind(b.visibleProperty());
        //We have to populate these arrays inside the method as the buttons/text areas are null until initialize is called
        invSlots = new Text[]{invSlot1, invSlot2, invSlot3, invSlot4, invSlot5, invSlot6, invSlot7, invSlot8, invSlot9, invSlot10, invSlot11, invSlot12, invSlot13};
        for(Text t: invSlots) {
            t.managedProperty().bind(t.visibleProperty());
            //On top of doing the above also sets all inventory spaces to be invisible.
            t.setVisible(false);
        }
        //More binding
        talkButton.managedProperty().bind(talkButton.visibleProperty());
        quitTalkButton.managedProperty().bind(quitTalkButton.visibleProperty());
        guessCulpritButton.managedProperty().bind(guessCulpritButton.visibleProperty());
        guessCluesButton.managedProperty().bind(guessCluesButton.visibleProperty());
        nevermindButton.managedProperty().bind(nevermindButton.visibleProperty());
        questionButton.managedProperty().bind(questionButton.visibleProperty());
        contextButton1.managedProperty().bind(contextButton1.visibleProperty());
        contextButton2.managedProperty().bind(contextButton2.visibleProperty());
        chooseSuspectPane.setVisible(false);
        chooseCluePane.setVisible(false);
        quitTalkButton.setVisible(false);
        questionButton.setVisible(false);
        contextButton1.setVisible(false);
        contextButton2.setVisible(false);
        guessCluesButton.setVisible(false);
        nevermindButton.setVisible(false);
        //Add action buttons to an array
        actionButtons = new Button[]{actionButton1, actionButton2, actionButton3};
        //Sets the starting room text
        exitButton1.setText("Kitchen");
        exitButton2.setText("Library");
        exitButton3.setText("Bedroom");
        exitButton4.setText("Basement");
        //Displays the description of the starting room
        textArea.setText(m.getRoom("Main Hall").getDesc());
        actionButton1.setText("Map");
        actionButton2.setText("Rusty Key");
        actionButton3.setText("Broken Glass");
        turn = 1;
        this.updateButtons(); //needs to be called so greet button will work on Butler Billy.
    }

    @FXML
    void newGamePressed(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleScreen.fxml"));
        Parent root = loader.load();
        secondStage.setTitle("Murder Mansion");
        secondStage.setScene(new Scene(root));
        secondStage.show();
        Stage thisWindow = (Stage) newGameButton.getScene().getWindow();
        thisWindow.close();
        if(notepadStage != null)
            notepadStage.close();
    }

    /**
     * loads a seperate window for the notepad screen
     */
    @FXML
    void notepadButtonPressed(ActionEvent event) throws IOException
    {
        notepadStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotepadScreen.fxml"));
        Parent root = loader.load();
        notepadStage.setTitle("Murder Mansion - Notepad");
        notepadStage.setScene(new Scene(root));
        notepadStage.show();
    }

    @FXML
    void exitButton1Pressed(ActionEvent event)
    {
        exit(exitButton1);
    }

    /**
     * An important thing to note here, is that due to the way GUIs work in javafx, we have to repeat code for each
     * individual button so we will not be going over what each button does as there is significant overlap.
     */

    @FXML
    void exitButton2Pressed(ActionEvent event)
    {
        exit(exitButton2);
    }

    @FXML
    void exitButton3Pressed(ActionEvent event)
    {
        exit(exitButton3);
    }

    @FXML
    void exitButton4Pressed(ActionEvent event)
    {
        exit(exitButton4);
    }

    void exit(Button b) {
        turn++; //increments turn by going to a different room
        location = b.getText(); //The location variable keeps track of where the player is located in the map
        //The location is always a string name of a room, and we use a hash map to access room methods.
        textArea.setText(m.getRoom(location).getDesc()); //Display room locations description
        p.setLocation(location); //Set the players location
        this.updateButtons(); //updates buttons to display new exits and items to pick up
    }

    void updateButtons()
    {
        //Show updated turn counter
        turnNumText.setText("Turn: " + turn);
        //only the Closet has no suspects to talk to, so if we are in the closet, hide the talk button
        if(m.getRoom(location).getName().equalsIgnoreCase("Closet")) {
            talkButton.setVisible(false);
        } else { //If we are anywhere else, make the talk button visible
            talkButton.setVisible(true);
        }
        //Use an if statement below to make sure we get no array index out of bounds errors.
        if (m.getRoom(location).getSuspects().size()>0) { //If a room has suspects
            //Display "Greet 'SUSPECT NAME'"
            //We used an array for suspects before we knew how many suspects we would have per room, it ended up being only
            //1 suspect per room
            talkButton.setText("Greet " + m.getRoom(p.getLocation()).getSuspects().get(0).getName());
            //you can only guess the culprit from the main hall
            if (!p.getLocation().equalsIgnoreCase("main hall")) { //If player is not in main hall
                guessCulpritButton.setVisible(false); //They cannot click the guess culprit button
            } else {
                guessCulpritButton.setVisible(true); //If they are in main hall, they can click it
            }
        }
        //Create an array with the players current locations exits to other rooms
        String[] array = m.getRoom(location).getExits();
        //First loop sets all exit buttons to invisible
        for(Button b: exitButtonArray)
            b.setVisible(false);
        //Second loop sets only the buttons for as many exits as there are visible
        for(int i = 0; i < array.length; i++) {
            exitButtonArray[i].setVisible(true);
            exitButtonArray[i].setText(array[i]);
        }

        //Exact same logic as above
        ArrayList<Item> contents = m.getRoom(location).getContents();
        for(Button b: actionButtons)
            b.setVisible(false);
        for(int i = 0; i < contents.size(); i++) {
            actionButtons[i].setVisible(true);
            actionButtons[i].setText(contents.get(i).getName());
        }

        //these buttons are used for picking yes or no for picking up an item, since you aren't picking up an item during this method, they are set to not visible
        contextButton1.setVisible(false);
        contextButton2.setVisible(false);
    }

    @FXML
    void contextButton1Pressed(ActionEvent event)
    {
        //Originally we were going to use these buttons for more than just yes/no prompts, hence the if statement
        //That ended up not happening
        if (contextButton1.getText().equalsIgnoreCase("Yes"))
        {
            //buttonClicked tracks whether or not you pressed yes or no across the methods
            buttonClicked = 1;
            this.itemHandler(actionButtonClicked); //calls method to pick up item
            enableAllButtons();
        }
    }

    @FXML
    void contextButton2Pressed(ActionEvent event)
    {
        if (contextButton2.getText().equalsIgnoreCase("No"))
        {
            buttonClicked = 2;
            this.itemHandler(actionButtonClicked); //calls method to leave item
            enableAllButtons();
        }
    }

    void itemHandler(Button button)
    {
        //Loop through contents and find the right item
        Item toRemove = null;
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(button.getText()) && buttonClicked == 1)
            {
                //Add item to player inventory
                p.addItem(i);
                toRemove = i;
            }
        }
        //If you hit yes on the context menu
        if (buttonClicked == 1)
        {
            //Find first empty inv slot -- Should be equal to Inventory size
            invSlots[p.getInventory().size()].setVisible(true);
            invSlots[p.getInventory().size()].setText(button.getText());

            //Remove that item from the rooms contents
            m.getRoom(location).getContents().remove(toRemove);

            //Make other buttons visible/invisible
            exitButton1.setVisible(true);
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(true);
            contextButton1.setVisible(false);
            contextButton2.setVisible(false);
            textArea.setText(m.getRoom(location).getDesc());
            this.updateButtons(); //updates buttons to show you have picked up the item
            buttonClicked = -1; //Reset the context menu button pressed
        } else if (buttonClicked == 2)
        {
            //All of this just returns you to the default display
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

    void actionLogic(Button b) {
        //Add an if here to check if button relates to an item or to an NPC
        //Need extra variable to avoid ConcurrentModificationException
        Item toRemove = null;
        //Use loop to find item in room.contents
        for (Item i : m.getRoom(location).getContents())
        {
            if (i.getName().equalsIgnoreCase(b.getText()))
            {
                toRemove = i;
            }
        }
        actionButtonClicked = b;
        displayItemPrompt(toRemove);
    }

    @FXML
    void actionButton1Pressed(ActionEvent event)
    {
        actionLogic(actionButton1);
    }

    @FXML
    void actionButton2Pressed(ActionEvent event)
    {
        actionLogic(actionButton2);
    }

    @FXML
    void actionButton3Pressed(ActionEvent event)
    {
        actionLogic(actionButton3);
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
    void talkButtonPressed(ActionEvent event)
    {
        //Return dialogue to screen
        String text = Dialogue.greet(m.getRoom(location).getSuspects().get(0));
        text += "\n\n" + m.getRoom(location).getSuspects().get(0).getDescription();
        textArea.setText(text);
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
        accused = m.getRoom("Main Hall").suspects.get(0);
    }

    @FXML
    void accuseChefButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Chef is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Kitchen").suspects.get(0);
    }

    @FXML
    void accuseSonButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Son is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Bedroom").suspects.get(0);
    }

    @FXML
    void accuseDaughterButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Daughter is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Basement").suspects.get(0);
    }

    @FXML
    void accuseFatherButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Father is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Dining Hall").suspects.get(0);
    }

    @FXML
    void accuseGardenerButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Gardener is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Garden").suspects.get(0);
    }

    @FXML
    void accuseLibrarianButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Librarian is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Library").suspects.get(0);
    }

    @FXML
    void accuseMotherButtonPressed(ActionEvent event)
    {
        textArea.setText("So the Mother is the murderer! How can you be so sure?");
        confirmCulpritChoice();
        disableAllSuspectButtons();
        accused = m.getRoom("Bathroom").suspects.get(0);
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
        this.updateClueButtons();
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

    //Changes the buttons on the clue guess screen based on whats in your inventory
    void updateClueButtons() {
        int counter = 0;
        //If the player has no clues in their inventory
        //Tell them to return to find more, and reset the display
        if(p.getInventory().size() == 0) {
            textArea.setText("You don't have any clues! Try harder!");
            nevermindButton.setDisable(false);
            exitGuessButton.setDisable(false);
            exitGuessButton.setVisible(false);
            guessCluesButton.setVisible(false);
            nevermindButton.setVisible(false);
            chooseCluePane.setVisible(false);
            exitButton1.setVisible(true);
            exitButton2.setVisible(true);
            exitButton3.setVisible(true);
            exitButton4.setVisible(true);
            this.enableAllButtons();
        }
        //For every item in the players inventory
        for(int i = 0; i < p.getInventory().size(); i++) {
            //If that item is a clue
            if(p.getInventory().get(i) instanceof Clue) { //This loop ensures only as many clue buttons as you have clues will be shown
                //Take the counter and sets what button num equal to counter num as that clue
                switch (counter) {
                    case 0:
                        clue1Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 1:
                        clue2Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 2:
                        clue3Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 3:
                        clue4Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 4:
                        clue5Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 5:
                        clue6Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 6:
                        clue7Button.setText(p.getInventory().get(i).getName());
                        break;
                    case 7:
                        clue8Button.setText(p.getInventory().get(i).getName());
                        break;
                }
                counter++; //Increment counter
            }
        }
        //Based on the size of the counter, set visible/Invisible that many buttons
        setAllCluesInvisible();
        Button array[] = new Button[]{clue1Button, clue2Button, clue3Button, clue4Button, clue5Button, clue6Button, clue7Button, clue8Button};
        //FYI -- we have 8 clue buttons because there are only 8 clues in game
        for(int i = 0; i < counter; i++) {
            array[i].setVisible(true);
        }
    }

    void setAllCluesInvisible() {
        clue1Button.setVisible(false);
        clue2Button.setVisible(false);
        clue3Button.setVisible(false);
        clue4Button.setVisible(false);
        clue5Button.setVisible(false);
        clue6Button.setVisible(false);
        clue7Button.setVisible(false);
        clue8Button.setVisible(false);
    }

    @FXML
    void clue1ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue1Button);
    }

    @FXML
    void clue2ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue2Button);
    }

    @FXML
    void clue3ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue3Button);
    }

    @FXML
    void clue4ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue4Button);
    }

    @FXML
    void clue5ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue5Button);
    }

    @FXML
    void clue6ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue6Button);
    }

    @FXML
    void clue7ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue7Button);
    }

    @FXML
    void clue8ButtonPressed(ActionEvent event)
    {
        clueCheckMethod(clue8Button);
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

    //Helper method that checks if you have the right clue based on the clue button you press
    void clueCheckMethod(Button b)
    {
        Clue c = new Clue();
        for (int i = 0; i < p.getInventory().size(); i++)
        {
            if (b.getText().equals(p.getInventory().get(i).getName()))
            {
                c = (Clue) p.getInventory().get(i);
            }
        }
        if(Ending.accuse(p, m.getCulprit(), c, accused))
        {
            if(firstGuess)
            {
                p.setPoints(p.getPoints() + 50);
            }
            System.out.println("WIN"); //call win method
            textArea.setText("Congratulations! You found the culprit!\n" + m.getCulprit().getName() + " was the culprit.\n" + "You got " + p.getPoints() + " points!\n" + p.getClassification());
        }
        else
        {
            firstGuess = false;
            p.setPoints(p.getPoints() - 50);
            System.out.println("LOSE");//call lose method
            textArea.setText("You guessed wrong, too bad!\n" + m.getCulprit().getName() + " was the culprit.\n" + "You got " + p.getPoints() + " points!\n" + p.getClassification());
        }
        TextFileWriter.textFileWriter(turn, p, m.getCulprit(), "Game_Details.txt");
    }
}