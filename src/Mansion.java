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

        // Create an arrayList of items from the text file
        reader.readItemsFile("Items.txt");


        reader.readRoomFile("Rooms.txt");
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