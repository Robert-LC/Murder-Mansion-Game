/**
 * ---------------------------------------------------------------------------
 * File name: Clue.java
 * Project name: Murder Mansion Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Megan Toth, tothmn@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: April 8, 2021
 * ---------------------------------------------------------------------------
*/

/**
 * Implements Clue subclass of Item
 *
 * Date created: April 8, 2021
 * 
 * @author Megan Toth
 */
public class Clue extends Item
{
    private Suspects suspect;
    
    public Clue()
    {
        super();

    }

    public Suspects getSuspect()
    {
        return Suspects;
    }

}
