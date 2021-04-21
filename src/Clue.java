/**
 * ---------------------------------------------------------------------------
 * File name: Clue.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Megan Toth, tothmn@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
*/

/**
 * Implements Clue subclass of Item
 *
 * Date created: April 8, 2021
 * 
 * @author Megan Toth
 */
public class Clue extends Item
{
    private String associatedSuspect;
    
    // Constructor for Clues calls the Item Constructor.
    Clue(String name, String description, String roomLocation)
    {
        super(name, description, roomLocation);
    }
    
    public String getAssociatedSuspect()
    {
        return associatedSuspect;
    }

    public void setAssociatedSuspect(String suspectName)
    {
        this.associatedSuspect = suspectName;
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Clue(){}
}
