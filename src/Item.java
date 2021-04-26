/**
 * ===============================================================
 * File Name: Item.java
 * Project Name: Final Game Project
 * ===============================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/26/2021
 * Course: CSCI-1260-942
 * ===============================================================
 */

/**
 * Items that has subclasses that go more indepth. Used for Inventory in player class.
 * 
 * @since 04/26/2021
 * @author Chris Seals
 */
public abstract class Item implements PointValue
{
    private String name, description, roomLocation;
    int points;

    public Item(String name, String description, String roomLocation, int points)
    {
        this.name = name;
        this.description = description;
        this.roomLocation = roomLocation;
        this.points = 10;
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    public Item(){}

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRoomLocation()
    {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation)
    {
        this.roomLocation = roomLocation;
    }

    public void setPoints(int points)
    {
        this.points = 10;
    }

    public int getPoints()
    {
        return points;
    }
}