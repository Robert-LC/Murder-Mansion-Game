/**
 * ---------------------------------------------------------------------------
 * File name: Mansion.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Sam Compson, compson@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
 */

/**
 * Creates mansion a holder class for rooms
 *
 * Date created: April 8, 2021
 *
 * @author Sam Compson
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Mansion {
    private HashMap<String, Room> map;
    private ArrayList<Room> rooms;
    //private ArrayList<Suspect> suspects;
    private Suspect culprit;

    public Mansion() {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        FileReaderClass reader = new FileReaderClass();
        //Creates Rooms, adds items, and suspects to those rooms based on file.
        rooms = reader.readRoomFile("rooms.txt", reader.readItemsFile("Items.txt"), reader.readSuspectFile("suspects.txt"));
        //Run randomize method to get a random culprit
        culprit = Randomize.randomize(reader.readSuspectFile("suspects.txt"));
        //Put all the rooms into the hashmap
        this.build();
    }

    public Room getRoom(String name) {
        return map.get(name);
    }

    // Builds the Rooms
    public void build() {
        for(Room r: rooms) {
            map.put(r.getName(), r);
        }
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms)
    {
        this.rooms = rooms;
    }

    public Suspect getCulprit()
    {
        return culprit;
    }
}