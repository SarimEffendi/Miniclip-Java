package model;

public class DicePlayer {

    private String playerName;
    private double points=0;
    public byte numberOfTries=3;

    public DicePlayer(String playerName){
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
