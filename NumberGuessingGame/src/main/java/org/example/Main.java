package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        int randomNumber= (int) ((Math.random()*100)+1);

        int result=100;

        int  userGuess;;
        boolean GuessCorrectly=false;

        System.out.println("Welcome to Game Guessing Number");
        System.out.println("Try to guess a number between 1 and 100");

        while (!GuessCorrectly && result!=0){

            System.out.println("Enter your guess :");
            userGuess= scanner.nextInt();
            if(userGuess==randomNumber) {

                System.out.println("Congratulations, you guess the correct number.");

                System.out.println("You score is : "+result+" points");
                return;

            }else  if(userGuess<randomNumber){

                System.out.println("Oops! it's wrong, you guess is lower, try again.");
                result-=10;

            }else {

                System.out.println("Oops! it's wrong, you guess is higher, try again.");
                result-=10;
            }
        }
        if(result == 0){

            System.out.println("Sorry, this is the limit of your attempts.Good Luck next time.");
            System.out.println("The number is : "+randomNumber);
        }
    }
}