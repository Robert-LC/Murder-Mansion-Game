import java.util.ArrayList;
import java.util.HashMap;

public class Mansion {
    HashMap<String, Room> map;
    ArrayList<Room> rooms;

    public Mansion()
    {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        //File Read in all room info -- for now just manually create for testing
        //Name, Description, Exits, Contents, etc.
        FileReaderClass reader = new FileReaderClass();
        HashMap<String, Item> itemTypeHashMap = new HashMap<String, Item>();

        // Reads items.txt, Creates Item Objects then stores them in a Hashmap(Item Name, Item Object)
        itemTypeHashMap = reader.readItemsFile("Items.txt");


        // Reads Rooms.txt, Creates room objects using the txt file, and the HashMap with items in it
        reader.readRoomFile("Rooms.txt", itemTypeHashMap);
        this.build();
    }

    public Room getRoom(String name) {
        return map.get(name);
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public void build() {
        for(Room r: rooms) {
            map.put(r.getName(), r);
        }
    }
}