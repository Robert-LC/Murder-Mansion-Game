public abstract class Item
{
    private String name, description, roomLocation;

    public Item(String name, String description, String roomLocation)
    {
        this.name = name;
        this.description = description;
        this.roomLocation = roomLocation;
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
}
