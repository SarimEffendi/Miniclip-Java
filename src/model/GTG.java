package model;

import java.util.Scanner;

public class GTG {
    public void Game()throws Exception {
        System.out.println("Welcome to the number guessing game.");
        System.out.println("The game is as simple as it can get. Guess the randomly generated number" +
                " within 5 trials and win.");

        Scanner input = new Scanner(System.in);

        int trials = 5;
        int guess;

        int number;
        number = 1 + (int) (50 * Math.random());

        for (int l1 = 1, check = 4; l1 <= trials; l1++, check--) {
            System.out.println("Your Guess: ");
            guess = input.nextInt();

            if (guess == number) {
                System.out.println("Congratulations! You have guessed the right number.");
                break;
            }

            else if (guess > number && l1 != trials) {
                System.out.println("Your guess is greater than the number.");
                System.out.println("You have " + check + " tries left");

                if (l1 == 2) {
                    if ((number % 2) == 0) {
                        System.out.println("Hint: The number is even");
                    }

                    else {
                        System.out.println("The number is odd");
                    }
                }
            }

            else if (guess < number && l1 != trials) {
                System.out.println("Your guess is lesser than the number.");
                System.out.println("You have " + check + " tries left");

                if (l1 == 2) {
                    if ((number % 2) == 0) {
                        System.out.println("Hint: The number is even");
                    }

                    else {
                        System.out.println("The number is odd");
                    }
                }
            }

            else if (l1 == trials) {
                System.out.println("Your have ran out of tries.");
                System.out.println("The number was " + number);
                break;
            }
        }
    }
}
