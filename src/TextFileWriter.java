/**
 * ================================================================================
 * File Name: TextFileWriter.java
 * Project Name: File Handling Lab
 * ================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 03/25/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */

import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates a txt file using a Library object.
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

            String temp = (player.checkPoints() + "," + player.checkLocation() + ",");

            for(Item item:player.getInventory())
            {
                temp += item.getName() + ",";
            }
            myWriter.write(temp);
            
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
}//end TextFileWriter