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
                    clu.setAssociatedSuspect(info[4]);

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

    // Read a file with Room names and descriptions, takes a file path, hash map of Items
    // Uses all that data to create Room Objects which are then put in a Mansion Object.
    public ArrayList<Room> readRoomFile(String path, HashMap<String, Item> itemStringHashMap, ArrayList<Suspect> suspectsArrayList)
    {
        // Create an empty items arrayList to be populated
        ArrayList<Room> roomsArray = new ArrayList<>();


        try(BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                String[] info = e.split("/");
                //Creates a new empty Room, itemArray, and exitArray every loop, and suspectArray that is specific to each room.
                Room r = new Room();
                ArrayList<Item> itemsArray = new ArrayList<>();
                ArrayList<String> exitsArray = new ArrayList<>();
                ArrayList<Suspect> suspectsArray = new ArrayList<>();

                // Loop to add items to rooms if item.location == room.getname
                for(Item item : itemStringHashMap.values())
                {
                    // If the RoomName(Info[0]) is also the location of the Item Object
                    // If they are equal, add the Item to the items in the room array.
                    if(info[0].equalsIgnoreCase(item.getRoomLocation()))
                    {
                        itemsArray.add(item);
                    }

                }

                //Takes the suspectArrayList of ALL suspects, add them to another suspect array specific to the room.
                for(Suspect s : suspectsArrayList)
                {
                    // Checks suspect location, with room name to make sure suspects go in the right rooms.
                    if(info[0].equalsIgnoreCase(s.getLocation()))
                    {
                        suspectsArray.add(s);
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
                r.setSuspects(suspectsArray);

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
        catch(IOException ex)
        {
            System.out.println("File not found");
        }

        return roomsArray;
    }

    // Reads from a creates a Suspect, then adds it to an arrayList of Suspects
    public ArrayList<Suspect> readSuspectFile(String path, HashMap<String, Item> itemStringHashMap)
    {
        // Create an arrayList to be populated with suspects
        ArrayList<Suspect> suspectArray = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(path)))
        {
            // Reads file until the reader reaches the end of the file
            while((e = fileReader.readLine()) != null)
            {
                // Creates a Suspect from the file, then adds the Suspect Object to the arrayList.
                String[] info = e.split("/");
                Suspect s = new Suspect();
                s.setName(info[0]);
                s.setLocation(info[1]);
                s.setDescription(info[2]);
                s.setGuilty(false);
                // Loops through the items hash map, find the ones that are instance of clues
                // and uses its name to set the suspects associated clue
                for(Item item : itemStringHashMap.values())
                {
                    //If the clues associated suspect is the same as suspect name, set the clue name as associated Clue.
                    if(item instanceof Clue && ((Clue) item).getAssociatedSuspect().equalsIgnoreCase(s.getName()))
                    {
                        s.setAssociatedClue(item.getName());
                    }

                }


                //Didn't add guilty boolean from file - Instead all Suspects guilty = false.
                //Then in Mansion constructor, we draw one random suspect from the arrayList and set their boolean
                //Guilty = true;

                // Finally add the created Suspect to the suspectArray
                suspectArray.add(s);
            }
        }
        catch(IOException ex)
        {
            System.out.println("File not found");
        }

        return suspectArray;
    }
}








