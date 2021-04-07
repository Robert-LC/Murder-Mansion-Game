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

import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates a txt file using game data
 * 
 * @since 03/25/2021
 * @author Chris Seals
 */
public class TextFileWriter
{
    public static void textFileWriter(int turn, Player player, String fileName)
    {
        try(FileWriter myWriter = new FileWriter(fileName))
        {
            myWriter.write(turn + "\n");
            myWriter.write(player.checkPoints() + "\n");
            myWriter.write(player.checkLocation() + "\n");

            String temp = "";
            for(Item item:player.getInventory())
            {
                temp += item.getName() + ",";
            }
            temp = temp.substring(0, temp.length() - 1);
            myWriter.write(temp);
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
}//end TextFileWriter