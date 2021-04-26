/**
 * ================================================================================
 * File Name: Player.java
 * Project Name: Final Project
 * ================================================================================
 * Creator's Name and Email: Robert LoCicero, LOCICERO@etsu.edu
 * Date Created: 04/08/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */
import java.util.ArrayList;

public class Player
{
    private int points;
    private ArrayList<Item> inventory;
    private String location;

    Player()
    {
        setPoints(0);
        setLocation("Main Hall");
        inventory = new ArrayList<Item>();

    }
    
    //setter for points
    public void setPoints(int points)
    {
        this.points = points;
    }

    // Same as Move()
    public void setLocation(String location)
    {
        this.location = location;
    }

    //adds item to inventory Arraylist
    public void addItem(Item item)
    {
        inventory.add(item);
        points += item.calcPoints();
    }
    
    //getter for points
    public int getPoints()
    {
        return points;
    }
    
    //setter for points
    public String getLocation()
    {
        return location;
    }
    
    //returns inventory Arraylist
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    //logic to determine the player's classification based on the points earned
    public String getClassification()
    {
        
        if (points <= 60)
        {
            return ("Classification: " + Classification.BEGINNER);
        }
        else if (points > 60 && points <= 120)
        {
            return ("Classification: " + Classification.INTERMEDIATE);
        }
        else if (points > 120)
        {
            return ("Classification: " + Classification.EXPERT);
        }
        return "Error -- Invalid point classification";
    }
    
    //returns 10
    public int calcPoints()
    {
       return 10;
    }
}
