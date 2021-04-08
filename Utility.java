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
    private Room usablein;

    public Utility()
    {
        super();
    }

    public Room getRoom()
    {
        return Room;
    }
}