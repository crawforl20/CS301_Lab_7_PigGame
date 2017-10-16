package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    private PigGameState gameState;

    public PigLocalGame() {
        //TODO  You will implement this constructor
        this.gameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method

        return playerIdx == gameState.getplayerID();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        int thisPlayerID = gameState.getplayerID();
        if(action instanceof PigHoldAction)
        {
            if(thisPlayerID == 0)
            {
                gameState.setPlayer_0score(gameState.getPlayer_0score()+gameState.getRunningScore());
            }
            else if(thisPlayerID == 1)
            {
                gameState.setPlayer_1score(gameState.getPlayer_1score()+gameState.getRunningScore());
            }
            gameState.setRunningScore(0);
            gameState.setPlayerID(1-thisPlayerID);
            return true;
        }
        else if(action instanceof PigRollAction)
        {
            gameState.setDiceVal();
            if(gameState.getDiceVal() != 1)
            {
                gameState.setRunningScore(gameState.getRunningScore()+gameState.getDiceVal());
            }
            else
            {
                gameState.setRunningScore(0);
                gameState.setPlayerID(1-thisPlayerID);
            }
            return true;
        }
        else
        {
            return false;
        }

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method

        PigGameState StateForPlayer = new PigGameState(gameState);
        p.sendInfo(StateForPlayer);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(gameState.getPlayer_0score() >= 50)
        {
            return "Game is over, Player 0 is the Winner!";
        }
        else if(gameState.getPlayer_1score() >= 50)
        {
            return "Game is over, Player 1 is the Winner!";
        }
        else
        {
            return null;
        }
    }

}// class PigLocalGame
