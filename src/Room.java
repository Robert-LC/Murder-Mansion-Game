import java.util.ArrayList;

public class Room {
    String name;
    String desc;
    String[] exits;
    ArrayList<Item> contents;

    public Room() {
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
}
