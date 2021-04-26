/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Sam Compson, compson@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
 */

/**
 * Rooms contain contents, descriptions, suspects, etc.
 *
 * Date created: April 8, 2021
 *
 * @author Sam Compson
 */
import java.util.ArrayList;

public class Room {
    String name;
    String desc;
    String[] exits;
    RoomType type;
    ArrayList<Item> contents;
    ArrayList<Suspect> suspects;


    public Room() {
        type = RoomType.OCCUPIED;
        contents = new ArrayList<>();
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

    public void setType(RoomType type)
    {
        this.type = type;
    }

    public RoomType getType()
    {
        return type;
    }
}