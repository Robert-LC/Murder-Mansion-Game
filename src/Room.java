
public class Room
{
    String name;
    String desc;
    String[] exits;
    Item[] contents;

    public Room(String name, String[] exits, Item[] contents) {
        this.name = name;
        this.exits = exits;
        this.contents = contents;
    }

    public Room() {

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getExits() {
        String result = "";
        for(String s: exits) {
            result += s + " ";
        }
        return result;
    }



}
