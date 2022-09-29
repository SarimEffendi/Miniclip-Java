package model;

public class RPSPlayer {

    private String playerName;
    private double points=0;
    public byte numberOfTries=3;

    public RPSPlayer(String playerName){
        this.setPlayerName(playerName);
    }

    public byte getNumberOfTries() {
        return numberOfTries;
    }



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getPoints() {
        return points;
    }
}
