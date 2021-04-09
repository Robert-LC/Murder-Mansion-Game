/**
 * ==========================================================================================
 * File Name: randomizeItems.java
 * Project Name: Final Project
 * ==========================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/09/2021
 * Course: CSCI-1260-942
 * ==========================================================================================
 */

import java.util.Random; //used to generate a random number to assign an item to a room
import java.util.ArrayList; //used to get roomnames from a collection of rooms
import java.util.HashMap; //used to access HashMap methods
import java.util.Map; //used to iterate through hashmap

/**
 * Assigns a HashMap of Item objects their room location by randomly selecting
 * a Room from an ArrayList.
 * 
 * @author Chris Seals
 * @since 04/09/2021
 */
public class randomizeItems
{  
    /**
     * Randomizes a HashMap of Item objects by assigning their room fields a random room name from the rooms arraylist.
     * 
     * @param items - HashMap of Items to be randomized
     * @param rooms - Rooms to be randomly selected
     */
    public static void randomize(HashMap<String, Item> items, ArrayList<Room> rooms)
    {
        Random rand = new Random(); //used to generate a random int

        for(Map.Entry<String, Item> set:items.entrySet()) //iterates through the HashMap
        {
            /*
            sets the roomLocation field by a getting the value of a set in the HashMap 
            and passes it a string randomly selected from the list of names available
            */
            set.getValue().setRoomLocation(rooms.get(rand.nextInt(rooms.size())).getName()); 
        }
    }
}//end randomizeItems