import java.util.ArrayList;

public class Room {
    String name;
    String desc;
    String[] exits;
    RoomType type;
    ArrayList<Item> contents;
    ArrayList<Suspect> suspects; // A room can have no suspects, it will just be an emtpy arrayList. This will save a lot of hassle.


    public Room() {
        type = RoomType.OCCUPIED;
        contents = new ArrayList<>();
    }

    public void addItem(Item i) {
        contents.add(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExits(String[] exits) {
        this.exits = exits;
    }

    public ArrayList<Item> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Item> contents) {
        this.contents = contents;
    }

    public String[] getExits() {
        return exits;
    }

    public ArrayList<Suspect> getSuspects()
    {
        return suspects;
    }

    public void setSuspects(ArrayList<Suspect> suspects)
    {
        this.suspects = suspects;
    }

    public void addSingleSuspect(Suspect suspect) //Adds a suspect to the arrayList of suspects in a room.
    {
        suspects.add(suspect);
    }

    public void setType(RoomType type)
    {
        this.type = type;
    }

    public RoomType getType()
    {
        return type;
    }
}
