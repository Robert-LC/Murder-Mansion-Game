/**
 * ==========================================================================================
 * File Name: randomizeItems.java
 * Project Name: Final Project
 * ==========================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/08/2021
 * Course: CSCI-1260-942
 */

import java.util.Random; //used to generate a random number to assign an item to a room
import java.util.HashMap; //used to access HashMap methods
import java.util.Map; //used to iterate through hashmap

/**
 * Assigns a hashmap of Item objects their room location by randomly selecting a room.
 * 
 * @author Chris Seals
 * @since 04/08/2021
 */
public class randomizeItems
{  
    //Used to select a room
    private static final String[] ROOMNAMES = {"Bedroom", "Library", "Garden", "Closet", "Main Hall", "Kitchen", "Bathroom", "Dining Hall", "Basement"};

    public static void randomize(HashMap<String, Item> items)
    {
        Random rand = new Random(); //used to generate a random int

        for(Map.Entry<String, Item> set:items.entrySet()) //iterates through the HashMap
        {
            //sets the roomLocation field by a method call and passes it a string randomly selected from the list of names available
            set.getValue().setRoomLocation(ROOMNAMES[rand.nextInt(9)]); 
        }
    }
}//end randomizeItems