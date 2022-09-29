package model;
import java.util.Random;
import java.util.Scanner;
public class Hangman {
    private static final String collection[] = {"Pakistan", "America", "England", "Germany", "Australia", "Turkey"};

    public void Game()throws Exception {
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        int ranNum = ran.nextInt(6);

        String word = collection[ranNum].toUpperCase();
        String wordDash = word.replaceAll("[A-Z]", "_ ");

        int check = 0;
        int flag = 0;
        String guess;
        char letter;

        boolean alreadyTaken;
        boolean trueGuess;
        String userWord = "";

        do {
            System.out.println(wordDash + "\n");

            int temp = 5 - flag;

            if(flag != 0) {
                System.out.println("Guesses left = " + temp);
            }

            System.out.println("Enter a letter: ");

            guess = input.nextLine().toUpperCase();
            letter = guess.charAt(0);

            alreadyTaken = (userWord.indexOf(letter)) != -1;
            userWord += letter;

            letter = Character.toUpperCase(letter);

            if(alreadyTaken == true) {
                System.out.println("Already guessed: " + letter + "\n");
            }

            trueGuess = (word.indexOf(letter)) != -1;

            if(trueGuess == true) {
                System.out.println("Yay! " + letter + " does exist in word.\n");

                for(int l1 = 0; l1 < word.length(); l1++) {
                    if(word.charAt(l1) == letter && wordDash.charAt(l1) != letter) {
                        wordDash = wordDash.replaceAll("_ ", "_");

                        String rightLetter;
                        rightLetter = wordDash.substring(0, l1) + letter +wordDash.substring(l1+1);
                        rightLetter = rightLetter.replaceAll("_", "_ ");
                        wordDash = rightLetter;
                    }
                }
            }

            else {
                System.out.println(letter + " not present");
                flag++;
            }

            check++;
        }while(flag < 5 && wordDash.contains("_"));

        if (flag == 5) {
            System.out.println("Better luck next time! The word was " + word);
        }

        else {

            System.out.print(
                    "The word is: " + wordDash + "\n You won!");
        }
    }
}
