import java.util.ArrayList;

public class Suspect {
    String name;
    String location;
    String description;
    ArrayList<String> dialogue;
    Boolean guilty;



    public Suspect()
    {
        //Read info from file
    }

    public String talk(int index) {
        //Display the String kept in the Array List at index
        //TODO: Build dialogue decision tree class?
        return "";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ArrayList<String> getDialogue()
    {
        return dialogue;
    }

    public void setDialogue(ArrayList<String> dialogue)
    {
        this.dialogue = dialogue;
    }

    public Boolean getGuilty()
    {
        return guilty;
    }

    public void setGuilty(Boolean guilty)
    {
        this.guilty = guilty;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
