package com.malar.project;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	        Random random = new Random();

	        String playAgain = "yes";
	        int round = 1;

	        while (playAgain.equalsIgnoreCase("yes")) {

	            int randomNumber = random.nextInt(100) + 1;
	            int attempts = 0;
	            int maxAttempts = 7;
	            boolean guessed = false;

	            System.out.println("\n========== Round " + round + " ==========");
	            System.out.println("Guess a number between 1 and 100");

	            while (attempts < maxAttempts) {

	                System.out.print("Enter your guess: ");
	                int guess = sc.nextInt();

	                attempts++;

	                if (guess > randomNumber) {
	                    System.out.println("Too High!");
	                } else if (guess < randomNumber) {
	                    System.out.println("Too Low!");
	                } else {
	                    System.out.println("Correct!");
	                    System.out.println("You guessed in " + attempts + " attempts.");
	                    guessed = true;
	                    break;
	                }

	                if (!guessed && attempts < maxAttempts) {
	                    System.out.println("Attempts Left : " + (maxAttempts - attempts));
	                }
	            }

	            if (!guessed) {
	                System.out.println("\nYou Lost!");
	                System.out.println("Correct Number was : " + randomNumber);
	            }

	            System.out.println("\nRound " + round + " Completed.");

	            System.out.print("Do you want to play again? (yes/no): ");
	            playAgain = sc.next();

	            round++;
	        }

	        System.out.println("\nThank you for playing!");
	        sc.close();
	    }
	}