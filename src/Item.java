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