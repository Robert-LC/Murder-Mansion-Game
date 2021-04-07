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
import java.util.ArrayList;
import java.util.HashMap;

// FileReaderClass has methods to read from a file to create Item Objects, and Room Objects, and create Suspect Objects
public class FileReaderClass
{
    private String e;

    // Reads from a txt file, creates a Clue, Utility, or Consumable based on the txt file.
    public HashMap<Item, String> readItemsFile(String path)
    {
        // Create a hashmap (Item Object, String ObjType(Clue,Utility,Consumable))
        HashMap<Item, String> itemTypeHashMap = new HashMap<>();
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
                // Index 1, 2, and 3 are then used as arguments to construct the object
                // After attributes are added to the object, add it to the Items HashMap
                if(info[0].equalsIgnoreCase("clue"))
                {
                    clu.setName(info[1]);
                    clu.setDescription(info[2]);
                    clu.setRoomLocation(info[3]);

                    itemTypeHashMap.put(clu, info[3]);
                }
                else if(info[0].equalsIgnoreCase("utility"))
                {
                    uti.setName(info[1]);
                    uti.setDescription(info[2]);
                    uti.setRoomLocation(info[3]);

                    itemTypeHashMap.put(uti, info[3]);
                }
                else if(info[0].equalsIgnoreCase("consumable"))
                {
                    con.setName(info[1]);
                    con.setDescription(info[2]);
                    con.setRoomLocation(info[3]);

                    itemTypeHashMap.put(uti, info[3]);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }

        // Return an Array of all the items that were created from the txt file.
        return itemTypeHashMap;
    }

    // Reads a file with rooms and creates them
    public ArrayList<Room> readRoomFile(String path)
    {
        // Create an empty items arrayList to be populated
        ArrayList<Room> roomsArray = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                String[] info = e.split("/");
                Room r = new Room();

            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }
    }

    public ArrayList<Suspect> readSuspectFile(String path)
    {

    }


}