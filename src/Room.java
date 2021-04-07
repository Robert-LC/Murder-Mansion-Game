import java.awt.*;
import java.util.ArrayList;

public class Room
{
    String name;
    String desc;
    ArrayList<Item> contents;
    ArrayList<String> exits;

    //public Room(String name, String[] exits, Item[] contents)
   // {
    //    this.name = name;
    //    this.exits = exits;
    //    this.contents = contents;
    //}

    public Room()
    {

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getExits()
    {
        String result = "";
        for(String s: exits)
        {
            result += s + " ";
        }
        return result;
    }

    public String getContents()
    {
        String result = "";
        for(Item i: contents)
        {
            result += i.getName() + " ";
        }
        return result;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setExits(ArrayList<String> exits)
    {
        this.exits = exits;
    }

    public void setContents(ArrayList<Item> contents)
    {
        this.contents = contents;
    }
}
