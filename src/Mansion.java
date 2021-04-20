import java.util.ArrayList;
import java.util.HashMap;

public class Mansion {
    private HashMap<String, Room> map;
    private ArrayList<Room> rooms;
    private ArrayList<Suspect> suspects;

    public Mansion() {
        map = new HashMap<>();
        rooms = new ArrayList<>();
        suspects = new ArrayList<>();
        FileReaderClass reader = new FileReaderClass();
        rooms = reader.readRoomFile("rooms.txt", reader.readItemsFile("Items.txt"), reader.readSuspectFile("suspects.txt"));
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

    public ArrayList<Suspect> getSuspects()
    {
        return suspects;
    }

    public void setSuspects(ArrayList<Suspect> suspects)
    {
        this.suspects = suspects;
    }
}
