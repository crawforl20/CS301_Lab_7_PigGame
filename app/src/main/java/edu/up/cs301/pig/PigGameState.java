package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by crawf on 10/12/2017.
 */

public class PigGameState extends GameState
{
    //instance variables
    private int playerID;
    private int player_0score;
    private int player_1score;
    private int runningScore;
    private int diceVal;

    //constructor
    public PigGameState()
    {
        playerID = 0;
        player_0score = 0;
        player_1score = 0;
        runningScore = 0;
        diceVal = 1;
    }
    public PigGameState(PigGameState aPigGameState)
    {
        playerID = aPigGameState.getplayerID();
        player_0score = aPigGameState.getPlayer_0score();
        player_1score = aPigGameState.getPlayer_1score();
        runningScore = aPigGameState.getRunningScore();
        diceVal = aPigGameState.getDiceVal();
    }
    public int getplayerID()
    {
        return playerID;
    }
    public int getPlayer_0score()
    {
        return player_0score;
    }
    public int getPlayer_1score()
    {
        return player_1score;
    }
    public int getRunningScore()
    {
        return runningScore;
    }
    public int getDiceVal()
    {
        return diceVal;
    }
    public void setPlayerID(int playerTurn)
    {
        playerID = playerTurn;
    }
    public void setPlayer_0score(int score)
    {
        player_0score = score;
    }
    public void setPlayer_1score(int score)
    {
        player_1score = score;
    }
    public void setRunningScore(int score)
    {
        runningScore = score;
    }
    public void setDiceVal()
    {
        Random rand = new Random();
        int n = rand.nextInt(6)+1;
        diceVal = n;
    }
}
