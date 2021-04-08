/**
 * ---------------------------------------------------------------------------
 * File name: Consumable.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Megan Toth, tothmn@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
*/

/**
 * Implements Consumable subclass of Item
 *
 * Date created: April 8, 2021
 * 
 * @author Megan Toth
 */
public class Consumable extends Item
{
    private String type;
    
    // Constructor for consumable calls the Item Constructor.
    Consumable(String name, String description, String roomLocation)
    {
        super(name, description, roomLocation);
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Consumable(){}


    public void consume()
    {

    }


}
