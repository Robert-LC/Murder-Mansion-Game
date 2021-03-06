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
public class Consumable extends Item implements PointValue
{

    // Constructor for consumable calls the Item Constructor.
    Consumable(String name, String description, String roomLocation, int points)
    {
        super(name, description, roomLocation, points);
    }
    
    //method from PointValue interface
    public int calcPoints()
    {
        return points;
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Consumable(){
        this.points = 10;
    }





}
