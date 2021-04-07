import java.util.ArrayList;
import java.util.HashMap;

public class Mansion {
    HashMap<String, Room> map;
    ArrayList<Room> rooms;

    public Mansion() {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        FileReaderClass reader = new FileReaderClass();
        rooms = reader.readRoomFile("rooms.txt", reader.readItemsFile("Items.txt"));
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
