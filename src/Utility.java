/**
 * ---------------------------------------------------------------------------
 * File name: Utility.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Megan Toth, tothmn@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
*/

/**
 * Implements Utility subclass of Item
 *
 * Date created: April 8, 2021
 * 
 * @author Megan Toth
 */
public class Utility extends Item implements PointValue
{
    private Room usableIn;
    
    // Constructor for Utility calls the Item Constructor.
    Utility(String name, String description, String roomLocation, int points)
    {
        super(name, description, roomLocation, points);
    }
    
    public int calcPoints()
    {
        
    }
    
    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Utility(){}


}
