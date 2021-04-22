/**
 * ================================================================================
 * File Name: TextFileWriter.java
 * Project Name: Final Project
 * ================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/07/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */

import java.io.FileWriter; //used to write a file
import java.io.IOException;

/**
 * Creates a txt file using game data
 * 
 * @since 04/22/2021
 * @author Chris Seals
 */
public class TextFileWriter
{
    /**
     * Writes a text file with information about a game
     * 
     * @param turn - the turn number the player was on
     * @param player - player object used to get inventory
     * @param culprit - the culprit of the game
     * @param fileName - the name the file will be saved as
     */
    public static void textFileWriter(int turn, Player player, Suspect culprit, String fileName)
    {
        try(FileWriter myWriter = new FileWriter(fileName))
        {
            myWriter.write(turn + "\n");
            myWriter.write(culprit.getName() + "\n");

            String temp = "";
            for(Item item:player.getInventory()) //iterates through player's inventory to get all items
            {
                temp += item.getName() + ","; //seperates items by commas
            }
            temp = temp.substring(0, temp.length() - 1); //removes final comma from the last item
            myWriter.write(temp);
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
}//end TextFileWriter