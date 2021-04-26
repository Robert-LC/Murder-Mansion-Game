/**
 * ============================================================
 * File Name: Suspect.java
 * Project Name: Final Game Project
 * ============================================================
 * Creators Name: Robert LoCicero and Sam Compson
 * Date Created: 04/26/2021
 * Course: CSCI-1260-942
 * ============================================================
 */

import java.util.ArrayList;

/**
 * Suspects that the player will meet in the game.
 * 
 * @author Robert LoCicero and Sam Compson
 * @since 04/26/2021
 */
public class Suspect {
    private String name;
    private String location;
    private String description;
    private int greetedCounter = 0; //Simple counter, that will be used to count how many times a Suspect has been talked to for dialogue options
    private Boolean guilty;

    public Suspect()
    {
        //Read info from file
    }

    public String getName()
    {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public int getGreetedCounter()
    {
        return greetedCounter;
    }

    public void setGreetedCounter(int greetedCounter)
    {
        this.greetedCounter = greetedCounter;
    }

    public void incrementGreetedCounter()
    {
        greetedCounter++;
    }
}