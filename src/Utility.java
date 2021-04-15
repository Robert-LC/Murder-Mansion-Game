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
public class Utility extends Item
{
    private Room usableIn;
    
    // Constructor for Utility calls the Item Constructor.
    Utility(String name, String description, String roomLocation)
    {
        super(name, description, roomLocation);
    }
    
    //public Room getRoom()
    //{
        //return Room;
    //}
    
    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Utility(){}


}
