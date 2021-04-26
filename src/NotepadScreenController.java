/**
 * ============================================================
 * File Name: NotepadScreenController.java
 * Project Name: Final Game Project
 * ============================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/26/2021
 * Course: CSCI-1260-942
 * ============================================================
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

/**
 * Controller used for the Notepad gui.
 * 
 * @author Chris Seals
 * @since 04/26/2021
 */
public class NotepadScreenController {

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    private Notepad notes;

    public void initialize()
    {
        notes = new Notepad();
    }

    @FXML
    void clearNotepadButtonPressed(ActionEvent event) {
        notes.clearNotes();
        updateTextArea();
    }

    @FXML
    void deleteNoteButtonPressed(ActionEvent event) {
        if(notes.getNotes().size()>0) {
            notes.getNotes().remove(notes.getNotes().size() - 1);
            updateTextArea();
        }
    }

    @FXML
    void saveNoteButtonPressed(ActionEvent event) {
        notes.write(textField.getText());
        textField.clear();
        updateTextArea();
    }

    void updateTextArea()
    {
        textArea.setText(notes.read(notes.getNotes()));
    }
}