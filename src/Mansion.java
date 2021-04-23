import java.util.ArrayList;
import java.util.HashMap;

public class Mansion {
    private HashMap<String, Room> map;
    private ArrayList<Room> rooms;
    private HashMap<String, Item> items; // Hash map of Item Name as key, Item Object as Value.
    private ArrayList<Suspect> suspects; // Array list of suspects that are in mansion
    private Suspect culprit; // Randomly chosen culprit

    public Mansion() {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        FileReaderClass reader = new FileReaderClass();
        //Create Items and Suspects separately, then pass variables to rooms creator that way files only need to be read once.
        items = reader.readItemsFile("Items.txt");
        suspects = reader.readSuspectFile("suspects.txt", items);
        rooms = reader.readRoomFile("rooms.txt", items, suspects);
        culprit = Randomize.randomize(suspects);
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

    public Suspect getCulprit()
    {
        return culprit;
    }
}
