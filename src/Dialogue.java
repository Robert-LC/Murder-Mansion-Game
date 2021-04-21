/**
 * ================================================================================
 * File Name: Dialogue.java
 * Project Name: Final Project
 * ================================================================================
 * Creator's Name and Email: Robert LoCicero, LOCICERO@etsu.edu
 * Date Created: 04/15/2021
 * Course: CSCI-1260-942
 * ================================================================================
 */

import java.util.Random;
import java.util.ArrayList;

/**
 * Includes static methods that will be called when talking to suspects
 * The methods are static so the Dialogue class does not need to be instantiated.
 * Dialogue with a Suspect will not give clue objects to the player, instead the player will use the notepad to write
 * the info down.
 *
 * @author Robert LoCicero
 * @since 04/15/2021
 */
public class Dialogue
{
    /**
     * Allows the player to greet a suspect, getting a generic message and opening the player
     * to the other dialogue options to be pressed.
     * @param s - A Suspect Object
     * @return - A String of dialogue based on how many times the player has talked to the suspect.
     */
    // On GUI this method will be called when you click on the greet button.
    public static String greet(Suspect s)
    {
        //This is the Basic greeting message,
        // we can add if statements to change what is said based on turn, suspect, or random.
        // We can create pools of dialogue for each Suspect, I can use FileReaderClass then use s.getDialogue[index]
        // and filter them through if statements here later.
        String greetMsg = "";
        if(s.getGreetedCounter() == 0)
        {
            greetMsg += "Hello Detective, my name is "  + s.getName() + ". What brings you to the " + s.getLocation() + "?";
            s.incrementGreetedCounter();
        }
        else if(s.getGreetedCounter() >= 2 && s.getGreetedCounter() <= 5)
        {
            greetMsg += "Hey Detective, nice to see you again. What can I do for you?";
            s.incrementGreetedCounter();
        }
        else if(s.getGreetedCounter() > 6) // Once it gets to 6, the greet button will no longer open up the other dialogue options.
        {
            greetMsg += "Ive had enough of your annoying antics, don't talk to me again!";
            s.incrementGreetedCounter();
        }

        return greetMsg;
    }


    /**
     * Allows the player to question a suspect, will be opened after greeting them.
     * Random chance whether the dialogue is useful or not.
     * @param s - A Suspect Object, the Suspect that is being talked to.
     * @return - A String of dialogue
     */
    public static String question(Suspect s)
    {
        Random rand = new Random();
        String questionMsg = "";

        //Returns a number between 0 and 99, then add 1, which makes it return a number between 1 and 100;
        int r = rand.nextInt(100) + 1;

        // random number between 1-100. If number is between 1-20 AND suspect is NOT the murderer, give clue about actual murderer
        // else give useless statement.
        // 1 - 20 helpful clues, 21 - 100 useless.
        if(r <= 5 && s.getGuilty() == false)
        {
            questionMsg += "I think I saw VARIABLE MURDERER.NAME acting strange.";
        }
        else if(r >= 6 && r <= 10 && s.getGuilty() == false)
        {
            questionMsg += "I couldn't tell if it was VARIABLE MURDER.NAME or SUSPECT.NAME, but I saw one of them holding a CLUE.GETNAME";
        }
        else if(r >= 11 && r <= 20 && s.getGuilty() == false)
        {
            questionMsg += "I think I heard a weird noise near MURDERER.getLocation or randomSuspect.getLocation.";
        }
        else
        {
            questionMsg += "I haven't seen anything out of the ordinary.";
        }
        return questionMsg;
    }


}
