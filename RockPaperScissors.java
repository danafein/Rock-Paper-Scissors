/*Dana Fein-Schaffer
 * A program that plays Rock Paper Scissors between the computer and a 
 * non-computer player
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
  String computerPlay; //stores the computer's play for the round
  //keep track of total number of wins for both computer and player
  int playerWins = 0;
  int computerWins = 0;
  int ties = 0;
  
  //method that plays a single round of rock, paper, scissors
  //takes in the non-computer player's play as a parameter
  //returns 0 if tie, 1 if player wins, 2 if computer wins
  public int playRound (String playerPlay) {
    Random rand = new Random();
    int randNum = rand.nextInt(3);
    
    //randomly pick rock, paper, or scissors for the computer
    if (randNum == 0) {
      computerPlay = "rock"; 
    }
    else if (randNum == 1) {
      computerPlay = "paper"; 
    }
    else { //if randNum == 2
      computerPlay = "scissors"; 
    }
    
    //figure out who wins the round
    //if tie
    if (playerPlay.equals(computerPlay)) {
      ties++;
      return 0;
    }
    //all situations in which player will win
    else if (playerPlay.equals("paper") && computerPlay.equals("rock")) {
      playerWins++;
      return 1;
    } 
    else if (playerPlay.equals("rock") && computerPlay.equals("scissors")) {
      playerWins++;
      return 1;
    } 
    else if (playerPlay.equals("scissors") && computerPlay.equals("paper")) {
      playerWins++;
      return 1;
    } 
    //if not any of those situations, computer wins
    else {
     computerWins++;
     return 2; 
    }
  }
  
  //main method that plays multiple rounds of the Rock, Paper, Scissors game
  public static void main(String[] args) {
    RockPaperScissors game = new RockPaperScissors();
    
    System.out.println("Welcome to Rock Paper Scissors!\n");
    
    //loop continues until player types a 'q', at which point it breaks out of the loop
    while (true) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter 'rock', 'paper', or 'scissors' to continue playing, " + 
                         "or 'q' if you would like to quit");
    String playerPlay = scan.next().toLowerCase();
    if (playerPlay.equals("q")) { //first check if player wants to quit
     break; 
    }
    //if player doesn't type in q, rock, paper, or scissors
    while (!(playerPlay.equals("rock") || playerPlay.equals("paper") || playerPlay.equals("scissors"))) {
     System.out.println("You must enter either 'rock', 'paper', or 'scissors'\nIf you want to quit, enter 'q'");
     playerPlay = scan.next().toLowerCase();
     if (playerPlay.equals("q")) { //break out of inner loop if want to quit at this point
      break; 
     }
    }
    scan.close();
    if (playerPlay.equals("q")) { //break out of outer loop to quit at this point
     break; 
    }
    
    //play one round of the game
    int winner = game.playRound(playerPlay);
    
    System.out.println("Your play: " + playerPlay);
    System.out.println("Computer play: " + game.computerPlay + "\n");
    
    //print out who won this round
    if (winner == 0) {
     System.out.println("It's a tie!\n"); 
    }
    else if (winner == 1) {
     System.out.println("You win!\n"); 
    }
    else {
     System.out.println("Computer wins :(\n"); 
    }
    
    //print out current scores
    System.out.println("Current scores:\nPlayer wins: " + game.playerWins + "\nComputer Wins: " + game.computerWins + 
                       "\nTies: " + game.ties + "\n");

    }
    //print out final scores once player has quit the game
    System.out.println("Final scores:\nTotal Player Wins: " + game.playerWins + "\nTotal Computer Wins: " + 
                       game.computerWins + "\nTotal Ties: " + game.ties);
    
    //calculate and print who the overall winner is
    if (game.playerWins == game.computerWins) {
     System.out.println("\nYou tied with the computer!");
    }
    else if (game.playerWins > game.computerWins) {
     System.out.println("\nYou won! Congratulations!"); 
    }
    else {
     System.out.println("\nThe computer won :( Better luck next time!"); 
    }
    
    System.out.println("Thank you for playing!");
  }
}