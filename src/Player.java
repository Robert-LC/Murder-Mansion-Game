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

    public void setPoints(int points)
    {
        this.points = points;
    }

    // Same as Move()
    public void setLocation(String location)
    {
        this.location = location;
    }


    public void addItem(Item item)
    {
        inventory.add(item);
    }

    public void removeItem(int index)
    {
        inventory.remove(index);
    }

    public int getPoints()
    {
        return points;
    }

    public String getLocation()
    {
        return location;
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    //logic to determine the player's classification based on the points earned
    public String getClassification()
    {
        if (points <= 20)
        {
            System.out.println("Classification: " + Classification.BEGINNER);
        }
        else if (points > 20 && points <= 40)
        {
            System.out.println("Classification: " + Classification.INTERMEDIATE);
        }
        else if (points > 40)
        {
            System.out.println("Classification: " + Classification.EXPERT);
        }
    }
}
