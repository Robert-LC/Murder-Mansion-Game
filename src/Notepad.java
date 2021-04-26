/**
 * ================================================================================
 * File Name: Notepad.java
 * Project Name: Final Project
 * ================================================================================
 * Creator's Name and Email: Robert LoCicero, LOCICERO@etsu.edu
 * Date Created: 04/15/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */

import java.util.ArrayList;

/**
 * Allows the use to read their notes, and take notes.
 *
 * @author Robert LoCicero
 * @since 04/15/2021
 */
public class Notepad
{
    private ArrayList<String> notes;

    //to initialize the ArrayList
    public Notepad()
    {
        notes = new ArrayList<>();
    }

    /**
     * Every index in the notes array will be concatenated to string and separated by a new line.
     *
     * @param notes - An ArrayList<String> that will be split into notes.
     * @return notesString
     */
    public String read(ArrayList<String> notes)
    {
        String notesString = "";
        //For every string in notes array.
        for(String s : notes)
        {
            notesString += s + "\n";
        }

        return notesString;
    }

    /**
     * Takes a players not and add it to the notes ArrayList<String>
     *
     * @param playerNote - A string that that the player types into the notepad.
     */
    public void write(String playerNote)
    {
        notes.add(playerNote);
    }

    // Returns the notes as an ArrayList not sure if it will be utilized.
    public ArrayList<String> getNotes()
    {
        return notes;
    }

    public void clearNotes()
    {
        notes.clear();
    }
}