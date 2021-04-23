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
            greetMsg += s.getDescription()+ "\nHello Detective, my name is "  + s.getName() + ". What brings you to the " + s.getLocation() + "?";
            s.incrementGreetedCounter();
        }
        else if(s.getGreetedCounter() >= 1 && s.getGreetedCounter() <= 5)
        {
            greetMsg += s.getDescription() + "\nHey Detective, nice to see you again. What can I do for you?";
            s.incrementGreetedCounter();
        }
        else if(s.getGreetedCounter() >= 6) // Once it gets to 6, the greet button will no longer open up the other dialogue options.
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
    public static String question(Suspect s, Mansion m)
    {
        Random rand = new Random();
        Random rand2 = new Random();
        String questionMsg = "";

        //Returns a number between 0 and 99, then add 1, which makes it return a number between 1 and 100;
        int r = rand.nextInt(100) + 1;
        int r2 = rand2.nextInt(7); // 8 Suspects, picks one of their indexes randomly.

        // random number between 1-100. If number is between 1-20 AND suspect is NOT the murderer, give clue about actual murderer
        // else give useless statement.
        // 1 - 50 helpful clues, 51 - 100 useless.
        if(r <= 5 && !s.getGuilty())
        {
            questionMsg += "I think I saw " + m.getCulprit().getName() + " running from the crime!";
        }
        else if(r >= 6 && r <= 10 && !s.getGuilty())
        {
            // Switches if the person saw the guilty party with their matching clue or, just a dud clue.
            if(r >= 8)
            {
                // 1. Culprit Name
                // 2. Name of Random Suspect
                // 3. Clue associated with the guilty suspect
                questionMsg += "I couldn't tell if it was " + m.getCulprit().getName() +
                        " or " + m.getRooms().get(r2).getSuspects().get(0).getName() + ", but I saw one of them holding a"
                        + m.getCulprit().getAssociatedClue() + ".";
            }
            else
            {
                // 1. Name of Random Suspect
                // 2. Culprit Name
                // 3. Finds a random suspect, and returns their associated clue, which is a dud clue
                // because the associated clue only works when the suspect is guilty.
                questionMsg += "I couldn't tell if it was " + m.getRooms().get(r2).getSuspects().get(0).getName() +
                        " or " + m.getCulprit().getName() + ", but I saw one of them holding a "
                        + m.getRooms().get(r2).getSuspects().get(0).getAssociatedClue();
            }
        }
        else if(r >= 11 && r <= 50 && !s.getGuilty())
        {
            // Switch the names based on RNG so the dialogue cant be cheated.
            if(r >= 40) // Culprit name said first
            {
                questionMsg += "I think I heard a loud scream near " + m.getCulprit().getLocation() + " or " +
                        m.getRooms().get(r2).getName() + ", I can't really tell for sure though.";
            }
            else //Random suspect name said first
            {
                questionMsg += "I think I heard a loud scream near " + m.getRooms().get(r2).getName()  + " or " +
                        m.getCulprit().getLocation() + " I can't really tell for sure though.";
            }
        }
        else
        {
            questionMsg += "I haven't seen anything out of the ordinary. I'll keep an eye out!";
        }
        return questionMsg;
    }

    // Helper function to stop you from leaving the conversation and then hopping right back in.
    private void preventButtonSpam()
    {
        ;
    }
}
