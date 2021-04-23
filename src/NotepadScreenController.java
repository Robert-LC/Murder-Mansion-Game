/**
 * ======================================================================
 * File Name: NotepadScreenController.java
 * Project Name: Final Game Project
 * ======================================================================
 * Creator's Name: Chris Seals
 * Date Created: 04/23/2021
 * Course: CSCI-1260-942
 * ======================================================================
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

/**
 * Controller for the Notepad Screen GUI.
 * 
 * @since 04/23/2021
 * @author Chris Seals
 */
public class NotepadScreenController {

    @FXML
    private TextField textField; //field the user will enter notes into

    @FXML
    private TextArea textArea; //the area the notes will be displayed at

    @FXML
    private Button saveNoteButton; //button to save note from the textField

    @FXML
    private Button clearNotepadButton; //clears the notepad

    @FXML
    private Button deleteNoteButton; //deletes the last note in the notepad

    private Notepad notes; //Notepad object to hold notes

    public void initialize()
    {
        notes = new Notepad();
    }

    @FXML
    void clearNotepadButtonPressed(ActionEvent event)
    {
        notes.clearNotes(); //calls the Notepad object's clear method to clear the arraylist
        updateTextArea(); //updates text area to show all notes were deleted
    }

    @FXML
    void deleteNoteButtonPressed(ActionEvent event)
    {
        if(notes.getNotes().size() > 0) //only tries to remove the last note if there is one
        {
            notes.getNotes().remove(notes.getNotes().size() - 1); //removes the last string in the arraylist of the Notepad object
            updateTextArea(); //updates text area to show changes
        }
    }

    @FXML
    void saveNoteButtonPressed(ActionEvent event)
    {
        notes.write(textField.getText()); //saves the note in the textfield to the arraylist in the Notepad object
        textField.clear(); //clears textfield after note was saved
        updateTextArea(); //updates screen to show new note
    }

    void updateTextArea()
    {
        textArea.setText(notes.read(notes.getNotes())); //updates screen to show current notes saved in notepad
    }
}//end NotepadScreenController