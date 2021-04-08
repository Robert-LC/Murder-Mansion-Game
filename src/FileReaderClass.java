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
    public HashMap<String, Item> readItemsFile(String path)
    {
        // Create a hashmap (Item Name, Item Object))
        HashMap<String, Item> itemTypeHashMap = new HashMap<String, Item>();
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
                // After attributes are added to the object, add the object to the Items HashMap, along with its type
                if(info[0].equalsIgnoreCase("clue"))
                {
                    clu.setName(info[1]);
                    clu.setDescription(info[2]);
                    clu.setRoomLocation(info[3]);

                    itemTypeHashMap.put(info[1], clu);
                }
                else if(info[0].equalsIgnoreCase("utility"))
                {
                    uti.setName(info[1]);
                    uti.setDescription(info[2]);
                    uti.setRoomLocation(info[3]);

                    itemTypeHashMap.put(info[1], uti);
                }
                else if(info[0].equalsIgnoreCase("consumable"))
                {
                    con.setName(info[1]);
                    con.setDescription(info[2]);
                    con.setRoomLocation(info[3]);

                    itemTypeHashMap.put(info[1], uti);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }

        // Return A HashMap(Item Name, Item Object)
        return itemTypeHashMap;
    }

    // Reads a file with rooms and creates them
    public ArrayList<Room> readRoomFile(String path, HashMap<String, Item> itemStringHashMap)
    {
        // Create an empty items arrayList to be populated
        ArrayList<Room> roomsArray = new ArrayList<>();


        try (BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                String[] info = e.split("/");
                //Creates a new empty Room, itemArray, and exitArray every loop.
                Room r = new Room();
                ArrayList<Item> itemsArray = new ArrayList<>();
                ArrayList<String> exitsArray = new ArrayList<>();

                // For every item in the HashMap
                for(Item item : itemStringHashMap.values())
                {
                    // If the RoomName(Info[0]) is also the location of the Item Object
                    // If they are equal, add the Item to the Items Array
                    if(info[0].equalsIgnoreCase(item.getRoomLocation()))
                    {
                        itemsArray.add(item);
                    }

                }

                // 2 Is the index where the room exits start on the file
                for(int i = 2; i < info.length; i++)
                {
                    exitsArray.add(info[i]);
                }

                // Then construct the Room
                r.setName(info[0]);
                r.setDesc(info[1]);
                r.setContents(itemsArray);



                //Convert array list to array as that's what is used in Room class
                String[] newArray = new String[exitsArray.size()];
                for(int i = 0; i < exitsArray.size(); i++)
                {
                    newArray[i] = exitsArray.get(i);
                }
                r.setExits(newArray);

                //Finally add the Room to an ArrayList of Rooms
                roomsArray.add(r);

                // Once the for loop ends, Room and itemsArray get renewed as empty.
            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }

        return roomsArray;
    }



    public ArrayList<Suspect> readSuspectFile(String path)
    {
        return new ArrayList<>();
    }


}
