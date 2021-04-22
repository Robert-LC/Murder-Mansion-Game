/**
 * =================================================================================
 * File Name: Ending.java
 * Project Name: Final Game Project
 * =================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/21/2021
 * Course: CSCI-1260-942
 * =================================================================================
 */

import java.util.ArrayList; //used to access player's inventory and get clues

/**
 * Contains a method to use when the player tries to end the game.
 *
 * @author Chris Seals
 * @since 04/22/2021
 */
public class Ending
{
    /**
     * Checks if the selected clue is in the player's inventory, then checks if that clues matches with the culprit.
     *
     * @param player - Player object that holds the player's inventory
     * @param culprit - Suspect object that is the culprit
     * @param selectedClue - A String that is the name of the selected clue object
     * @return True if the player selected the right clue and has it on them, False if the player didn't select the right clue or didn't have the item
     */
    public static boolean accuse(Player player, Suspect culprit, Clue selectedClue, Suspect accused)
    {
        Clue tempClue = null;

        for(Item item:player.getInventory()) //iterates through player's inventory
        {
            if(item.getName().equalsIgnoreCase(selectedClue.getName())) //if the selected clue is actually in the player's inventory
            {
                tempClue = (Clue)item; //Casts it to a Clue object so Clue methods can be used
                break; //stops for each loop since only one clue object matches with each suspect
            }
        }
        if(tempClue.getAssociatedSuspect().equalsIgnoreCase(culprit.getName()) && accused.getName().equals(culprit.getName())) //if the clue actually matches with the culprit
        {
            return true;
        }
        else //this will happen if either the player didn't have the selected clue in their inventory, or they selected the wrong clue
        {
            return false;
        }
    }//end accuse()
}//end Ending
