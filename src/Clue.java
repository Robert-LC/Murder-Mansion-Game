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
    private Suspect suspect;
    
    // Constructor for Clues calls the Item Constructor.
    Clue(String name, String description, String roomLocation)
    {
        super(name, description, roomLocation);
    }
    
    public Suspect getSuspect()
    {
        return suspect;
    }
    
    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Clue(){}

    public int calcPoints()
    {
        if(suspect.getGuilty())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}
