public class Clue extends Item
{
    private Suspects suspect;
    
    // Constructor for Clues calls the Item Constructor.
    Clue(String name, String description, String roomLocation)
    {
        super(name, description, roomLocation);
    }
    
    public Suspects getSuspect()
    {
        return Suspects;
    }
    
    // DO NOT DELETE, NEED BLANK CONSTRUCTOR TO READ FROM FILE
    Clue(){}

}
