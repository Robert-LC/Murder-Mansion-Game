public abstract class Item implements PointValue
{
    private String name, description, roomLocation;
    int points;
    
    //main constructor that subclasses will inherit
    public Item(String name, String description, String roomLocation, int points)
    {
        this.name = name;
        this.description = description;
        this.roomLocation = roomLocation;
        this.points = points;
    }

    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    public Item(){}

    //getter for name
    public String getName()
    {
        return this.name;
    }
    
    //setter for name
    public void setName(String name)
    {
        this.name = name;
    }
    
    //getter for description
    public String getDescription()
    {
        return this.description;
    }
    
    //setter for description
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    //getter for room location
    public String getRoomLocation()
    {
        return roomLocation;
    }
    
    //setter for room location
    public void setRoomLocation(String roomLocation)
    {
        this.roomLocation = roomLocation;
    }
    
    //setter for points
    public void setPoints(int points)
    {
        this.points = 10;
    }
    
    //getter for points
    public int getPoints()
    {
        return points;
    }
}
