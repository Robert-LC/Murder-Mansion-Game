import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class NotepadScreenController {

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button saveNoteButton;

    @FXML
    private Button clearNotepadButton;

    @FXML
    private Button deleteNoteButton;

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