import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Mansion {
    private HashMap<String, Room> map;
    private ArrayList<Room> rooms;
    //private ArrayList<Suspect> suspects;
    private Suspect culprit;
    private Random rand = new Random();

    public Mansion() {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        FileReaderClass reader = new FileReaderClass();
        //Creates Rooms, adds items, and suspects to those rooms based on file.
        rooms = reader.readRoomFile("rooms.txt", reader.readItemsFile("Items.txt"), reader.readSuspectFile("suspects.txt"));


        culprit = Randomize.randomize(reader.readSuspectFile("suspects.txt"));

        this.build();
    }

    public Room getRoom(String name) {
        return map.get(name);
    }

    public void addRoom(Room r) {
        rooms.add(r);
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

    //public ArrayList<Suspect> getSuspects()
    //{
        //return suspects;
    //}

    //public void setSuspects(ArrayList<Suspect> suspects)
    //{
        //this.suspects = suspects;
    //}
}
