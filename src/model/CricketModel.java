package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CricketModel {
    Scanner input = new Scanner(System.in);
    private static ArrayList<Cricketers> cricketers = new ArrayList<>();
    private boolean play;
    private boolean firstBatsmanOut = false;
    private boolean goldenDuck;

    public String showCricketers() {
        return cricketers.toString();
    }


    public ArrayList<Cricketers> addPlayers() throws Exception {
        System.out.println("Add 2 Players: ");
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter Name For " + (i + 1) + " Player:");
            String name = input.nextLine();
            cricketers.add(new Cricketers(name, 0, 0, false));
        }
        return cricketers;
    }

    public void isFinish(Cricketers winner, Cricketers loser) throws Exception {
        winner.setBatting(false);
        loser.setBatting(false);
        winner.setScore(0);
        loser.setScore(0);
        winner.setRecord(winner.getRecord() + 1);
        goldenDuck = false;
        firstBatsmanOut = false;
        play = false;
    }

    public void twoPlayerAuto() throws Exception {
        toss();
        play = true;
        while (play) {
            if (cricketers.get(0).isBatting() == true) {
                addRuns(cricketers.get(0), cricketers.get(1));
            } else if (cricketers.get(1).isBatting() == true) {
                addRuns(cricketers.get(1), cricketers.get(0));
            }
        }
        play = true;
    }

    public void addRuns(Cricketers batsman, Cricketers bowler) throws Exception {
        Random random = new Random();
        System.out.println("enter for batsmen ");
        int batsmanRandom = input.nextInt();
        System.out.println("enter for bowler ");

        int bowlerRandom = input.nextInt();
        if (batsmanRandom > 6) {
            System.out.println("enter number less than or equals to 6");
            batsmanRandom = input.nextInt();

        } else if (bowlerRandom > 6) {
            System.out.println("enter number less than or equals to 6");
            bowlerRandom = input.nextInt();
        }
        System.out.println(batsman.getName() + " has chosen " + batsmanRandom);
        System.out.println(bowler.getName() + " has chosen " + bowlerRandom);
        if (batsmanRandom == bowlerRandom) {
            if (firstBatsmanOut == true) {
                if (batsman.getScore() == bowler.getScore()) {
                    System.out.println("Game Tied");
                    batsman.setBatting(false);
                    bowler.setBatting(false);
                    batsman.setScore(0);
                    bowler.setScore(0);
                    goldenDuck = false;
                    firstBatsmanOut = false;
                    play = false;
                } else {
                    System.out.println(bowler.getName() + " has won this game");
                    isFinish(bowler, batsman);
                }

            } else {
                System.out.println(batsman.getName() + " is out and has set a total of " + batsman.getScore() + " for " + bowler.getName());
                batsman.setBatting(false);
                firstBatsmanOut = true;
                if (batsman.getScore() == 0) {
                    goldenDuck = true;
                }
                bowler.setBatting(true);
            }

        } else if (!(batsmanRandom == bowlerRandom)) {
            batsman.setScore(batsman.getScore() + batsmanRandom);
            if (goldenDuck == true && batsman.getScore() > bowler.getScore()) {
                System.out.println(batsman.getName() + " has won this game");
                isFinish(batsman, bowler);
            } else if (firstBatsmanOut == true && batsman.getScore() > bowler.getScore()) {
                System.out.println(batsman.getName() + " has won this game");
                isFinish(batsman, bowler);
            }
        }
    }

    public boolean toss() throws Exception {
        System.out.println("Enter any number to toss the coin");
        Random random = new Random();
        Random random1 = new Random();
        int autoGuess = input.nextInt();
        if (autoGuess == 0) {
            System.out.println(cricketers.get(1).getName() + " has called HEADS");
        } else {
            System.out.println(cricketers.get(1).getName() + " has called TAILS");
        }
        int coinFlip = random1.nextInt(2);
        if (coinFlip == 0) {
            System.out.println("Umpire calls HEADS");
        } else {
            System.out.println("Umpire calls TAILS");
        }
        if (autoGuess == coinFlip) {
            System.out.print(cricketers.get(1).getName() + " has won the toss");
            int batOrBall = random.nextInt(2);
            if (batOrBall == 0) {
                System.out.println(" and decided to bat first");
                cricketers.get(1).setBatting(true);
            } else if (batOrBall == 1) {
                System.out.println(" and decided to bowl first");
                cricketers.get(0).setBatting(true);
            }
        } else if (!(autoGuess == coinFlip)) {
            System.out.print(cricketers.get(0).getName() + " has won the toss");
            int ballOrBat = random.nextInt(2);
            if (ballOrBat == 0) {
                System.out.println(" and decided to bat first");
                cricketers.get(0).setBatting(true);
            } else if (ballOrBat == 1) {
                System.out.println(" and decided to bowl first");
                cricketers.get(1).setBatting(true);
            }
        }
        return cricketers.get(0).isBatting();
    }
}
