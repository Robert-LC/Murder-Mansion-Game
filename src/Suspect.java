import java.util.ArrayList;

public class Suspect {
    String name;
    ArrayList<String> dialogue;
    String description;
    Boolean guilty;
    String location; //Probably makes more sense to put the suspects into the room class

    public Suspect() {
        //Read info from file
    }

    public String talk(int index) {
        //Display the String kept in the Array List at index
        //TODO: Build dialogue decision tree class?
        return "";
    }
}
