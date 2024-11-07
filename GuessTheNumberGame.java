import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 3;  // Number of rounds
        int maxAttempts = 5;  // Maximum attempts per round
        int totalScore = 0;   // Total score of the player

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("You have " + rounds + " rounds to play. Each round has " + maxAttempts + " attempts.");
        
        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int score = 0;  // Score for the current round
            boolean guessedCorrectly = false;
            
            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess the number between 1 and 100!");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score = maxAttempts - attempt + 1;  // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber);
            }

            System.out.println("Score for this round: " + score);
            totalScore += score;
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Your total score is: " + totalScore);
        scanner.close();
    }
}
