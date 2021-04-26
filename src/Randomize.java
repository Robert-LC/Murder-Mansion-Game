/**
 * ==========================================================================================
 * File Name: Randomize.java
 * Project Name: Final Project
 * ==========================================================================================
 * Creator's Name and Email: Chris Seals, sealscm@etsu.edu
 * Date Created: 04/14/2021
 * Course: CSCI-1260-942
 * ==========================================================================================
 */

import java.util.Random; //used to generate a random number to select a suspect
import java.util.ArrayList; //used to select from the suspects

/**
 * Randomizes the suspect so it's different suspect when you play.
 *
 * @author Chris Seals
 * @since 04/21/2021
 */
public class Randomize
{
    /**
     * Selects a suspect at random from an arraylist that will be the culprit in a game.
     *
     * @param suspects - a list of suspects to be chosen randomly
     * @return Suspect that is guilty
     */
    public static Suspect randomize(ArrayList<Suspect> suspects)
    {
        Random rand = new Random(); //used to select a random int
        Suspect culprit = suspects.get(rand.nextInt(suspects.size())); //selects a random suspect that will be the guilty party throughout the game
        culprit.setGuilty(true);
        return culprit;
    }//end randomize()
}//end Randomize