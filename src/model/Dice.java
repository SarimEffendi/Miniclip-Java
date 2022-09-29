package model;


import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

    public class Dice {
        Scanner sc = new Scanner(System.in);
        private DicePlayer player;
        public void Player()throws Exception{
            System.out.println("Enter player name");
            String player_name = sc.nextLine();
             player = new DicePlayer(player_name);

        }

        public void diceGame()throws Exception{
            int playerNumber;
            char cont;
            try{
                System.out.println("Your points at the start of game are : " +player.getPoints());
                System.out.println("Number of tries left : " +player.getNumberOfTries());
                do{
                    Random random = new Random();
                    int random_number;
                    /*                System.out.println("Your points are : " +getPoints());*/
                    System.out.println();
                    System.out.print("Enter your number : ");
                    playerNumber=sc.nextInt();

                    random_number= random.nextInt(7);
                    System.out.println("Computer Generated number is : " +random_number);

                    if(playerNumber==(random_number)){
                        System.out.println(player.getPlayerName()+" Won. Congrats");
                        double points = player.getPoints();

                        points ++;

                        System.out.println("Your points : " +points);
/*                    System.out.println("Do you want to play again (Y/N) : ");
                    String choice = sc.next().toLowerCase(Locale.ROOT);*/
                        while(player.getNumberOfTries()==3){
                            diceGame();
                        }
                    }
                    if(playerNumber!=(random_number)){
                        System.out.println("try again "+player.getPlayerName());
                        player.numberOfTries-=1;

                        System.out.println(player.numberOfTries+" tries left");

                        while(player.getNumberOfTries()==3){
                            diceGame();
                        }
                    }
                    System.out.print("\nDo you want to continue (Y/N) : ");
                    cont = sc.next().toLowerCase(Locale.ROOT).charAt(0);

                    if(player.numberOfTries==0){
                        cont='n';
                    }
                }while(cont=='y');

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
}
