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
public class Clue extends Item implements PointValue
{
    private String associatedSuspect;

    // Constructor for Clues calls the Item Constructor.
    Clue(String name, String description, String roomLocation, int points)
    {
        super(name, description, roomLocation, points);
    }
    
    //getter for associated suspect
    public String getAssociatedSuspect()
    {
        return associatedSuspect;
    }
    
    //setter for associated suspect
    public void setAssociatedSuspect(String suspectName)
    {
        this.associatedSuspect = suspectName;
    }
    
    //method from interface
    public int calcPoints()
    {
        return points;
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Clue(){
        this.points = 10;
    }
}
