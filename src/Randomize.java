/**
 * ==========================================================================================
 * File Name: Randomize.java
 * Project Name: Final Project
 * ==========================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/14/2021
 * Course: CSCI-1260-942
 * ==========================================================================================
 */

import java.util.Random; //used to generate a random number to assign an item to a room
import java.util.ArrayList; //used to get roomnames from a collection of rooms
import java.util.HashMap; //used to access HashMap methods
import java.util.Map; //used to iterate through hashmap

/**
 * Includes methods to randomize game objects to allow a better game experience.
 * 
 * @author Chris Seals
 * @since 04/14/2021
 */
public class Randomize
{
    /**
     * Randomizes the clues in the items HashMap to room locations. Chooses the three that connect
     * to a randomly chosen suspect, and assigns those to different rooms. Then gets some dummy clues
     * and dispurses them. One clue object that ties to the main suspect will be put in an INACCESSABLE room,
     * this is in case one of the main three clues isn't put into one of those rooms.
	 * 
     * @param items
     * @param rooms
     * @param suspects
     */
    public static void randomize(HashMap<String, Item> items, ArrayList<Room> rooms, ArrayList<Suspect> suspects)
    {
        Random rand = new Random(); 
        Suspect guiltyParty = suspects.get(rand.nextInt(suspects.size())); //selects a random suspect that will be the guilty party throughout the game
        guiltyParty.setGuilty(true);
        ArrayList<Clue> tempClues = new ArrayList<>();
        ArrayList<Clue> finalClues = new ArrayList<>();

        for(Map.Entry<String, Item> set:items.entrySet()) //iterates through the HashMap and adds all clue objects to a temp ArrayList
        {
            if(set.getValue().getClass().getName().equals("Clue"))
            {
                tempClues.add((Clue)set.getValue());
            }
        }
        for(Clue myClue:tempClues) //gets the three clues that match with the guilty suspect and adds it to the ArrayList used for randomizing
        {
            if((myClue.getSuspect1().getName().equals(guiltyParty.getName())) && (myClue.getSuspect2().getName().equals(guiltyParty.getName())) && (myClue.getSuspect3().getName().equals(guiltyParty.getName())))
            {
                finalClues.add((Clue)myClue);
            }
        }
        while(finalClues.size() != 6) //adds some dummy clues that aren't related to the guilty suspect. This amount is changable by changing the number in the while loop
        {
            Clue temp = tempClues.get(rand.nextInt(tempClues.size()));
            if(!((temp.getSuspect1().getName().equals(guiltyParty.getName())) && (temp.getSuspect2().getName().equals(guiltyParty.getName())) && (temp.getSuspect3().getName().equals(guiltyParty.getName()))))
            {
                finalClues.add((Clue)temp);
            }
        }
        ArrayList<Room> tempRooms = new ArrayList<>();
        for(Room room:rooms) //loops through the ArrayList of rooms to find all INACCESSABLE rooms
        {
            if(room.getType() == RoomType.INACCESSABLE)
            {
                tempRooms.add(room);
            }
        }
        //Assigns the first clue that is important to the guilty suspect to an INACCESSABLE room
        //This is so at least one item that is neccessary to win is in a room you'll need to work for to get into
        finalClues.get(0).setRoomLocation(tempUnRooms.get(rand.nextInt(tempUnRooms.size())).getName());

        for(int loop = 1; loop < finalClues.size(); loop++) //Loops through the other randomly selected items and assigns them randomly to any room. This can cause duplicates but it's fine cause it's random
        {
            finalClues.get(loop).setRoomLocation(rooms.get(rand.nextInt(rooms.size())).getName());
        }
    }//end randomize()
}//end randomizeItems