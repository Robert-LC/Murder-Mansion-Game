 /**
 * ================================================================================
 * File Name: FileReaderClass.java
 * Project Name: Final Project
 * ================================================================================
 * Creator's Name and Email: Robert LoCicero, LOCICERO@etsu.edu
 * Date Created: 04/07/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// FileReaderClass has methods to read from a file to create Item Objects, and Room Objects
public class FileReaderClass
{
    private String e;

    // Reads from a txt file, creates a Clue, Utility, or Consumable based on the txt file.
    public void readItemsFile(String path)
    {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                String[] info = e.split("/");
                Clue clu = new Clue();
                Utility uti = new Utility();
                Consumable con = new Consumable();

                // Index 0 determines if the Item is Clue, Utility or Consumable
                // Index 1 and 2 are then used as arguments to construct the object
                if(info[0].equalsIgnoreCase("clue"))
                {
                    clu.setName(info[1]);
                    clu.setDescription(info[2]);

                }
                else if(info[2].equalsIgnoreCase("utility"))
                {
                    uti.setName(info[1]);
                    uti.setName(info[2]);
                }
                // Creates a Consumable
                else
                {
                    con.setName(info[1]);
                    con.setDescription(info[2]);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }
    }

    // Reads a file with rooms and creates them, MUST CREATE ITEMS FIRST!!! WORK IN PROGRESS 1:54PM ROB_LC
    public void readRoomFile(String path)
    {
        //Open the file passed in the function argument
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                String[] info = e.split("/");
                Room r = new Room();

                r.setName(info[1]);
                r.setDesc(info[2]);

            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }
    }


}