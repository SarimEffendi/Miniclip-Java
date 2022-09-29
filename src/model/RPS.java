package model;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
public class RPS {

    Scanner sc = new Scanner(System.in);

    private DicePlayer player;
    public void Player()throws Exception{
        System.out.println("Enter player name");
        String player_name = sc.nextLine();
        player = new DicePlayer(player_name);

    }


    private String playerTurn()throws Exception{
        System.out.print("(ROCK/PAPER/SCISSORS)- Enter your choice : ");
        String playerChoice = sc.next().toLowerCase(Locale.ROOT);

        if(playerChoice.toLowerCase(Locale.ROOT).equals("rock") || playerChoice.toLowerCase(Locale.ROOT).equals("paper")
                || playerChoice.toLowerCase(Locale.ROOT).equals("scissors")){
            return playerChoice;
        }
        else{
            return "Wrong Input";
        }
    }

    private String computerTurn()throws Exception{
        String computerChoice;
        Random random = new Random();
        int cpu = random.nextInt(3)+1;
        if(cpu==1){
            computerChoice="rock";
            return computerChoice;
        }
        else if(cpu==2){
            computerChoice="paper";
            return computerChoice;
        }
        else {
            computerChoice="scissors";
        }
        return computerChoice;
    }

    public void rpsGame()throws Exception{
        double points;
        System.out.println("Rock Paper Scissor Game.\n");
        try{
            System.out.println("Your points at the start of game are : " +player.getPoints());
            System.out.println("Number of tries left : " +player.getNumberOfTries());
            char cont;
            do{
                points=player.getPoints();
                String playerMove = playerTurn();
                String computerMove = computerTurn();


                if(playerMove.equals(computerMove)){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println("Tie");
                }
                else if(playerMove.equals("rock")&&computerMove.equals("paper")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println("Computer Won");
                    player.numberOfTries-=1;
                }
                else if(playerMove.equals("rock")&&computerMove.equals("scissors")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println("Computer Won");
                    player.numberOfTries-=1;
                }
                else if(playerMove.equals("paper")&&computerMove.equals("rock")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println(player.getPlayerName()+" Won");
                    points++;
                    System.out.println("Your points : " +points);
                }
                else if(playerMove.equals("paper")&&computerMove.equals("scissors")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println("Computer Won");
                    player.numberOfTries-=1;
                }
                else if(playerMove.equals("scissors")&&computerMove.equals("rock")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println("Computer Won");
                    player.numberOfTries-=1;
                }
                else if(playerMove.equals("scissors")&&computerMove.equals("paper")){
                    System.out.println("Computer choice is : "+computerMove);
                    System.out.println(player.getPlayerName()+" Won");
                    points++;
                    System.out.println("Your points : " +points);
                }

                System.out.print("do you want to continue (Y/N) : ");
                cont = sc.next().toLowerCase(Locale.ROOT).charAt(0);

                if(player.numberOfTries==0){
                    cont='n';
                }
            }while(cont=='y');
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
