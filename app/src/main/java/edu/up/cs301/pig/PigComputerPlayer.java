package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    private PigGameState comState;

    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        comState = (PigGameState)info;
        if(comState.getplayerID() == this.playerNum)
        {
            sleep((int) (2000 * Math.random()));

            Random rand = new Random();
            int choice = rand.nextInt(1);
            if (choice == 0)
            {
                game.sendAction(new PigHoldAction(this));
            }
            else if (choice == 1)
            {
                game.sendAction(new PigRollAction(this));
            }
        }
    }//receiveInfo

}
